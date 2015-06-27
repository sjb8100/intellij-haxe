/*
 * Copyright 2000-2013 JetBrains s.r.o.
 * Copyright 2014-2015 AS3Boyan
 * Copyright 2014-2014 Elias Ku
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.plugins.haxe.model;

import com.google.common.collect.Lists;
import com.intellij.openapi.util.Key;
import com.intellij.plugins.haxe.HaxeComponentType;
import com.intellij.plugins.haxe.lang.psi.*;
import com.intellij.plugins.haxe.model.resolver.HaxeResolver2Class;
import com.intellij.plugins.haxe.model.type.*;
import com.intellij.plugins.haxe.util.UsefulPsiTreeUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiIdentifier;
import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class HaxeClassModel {
  public HaxeClass haxeClass;

  public HaxeClassModel(HaxeClass haxeClass) {
    this.haxeClass = haxeClass;
  }

  public HaxeProjectModel getProject() {
    return HaxeProjectModel.fromElement(haxeClass);
  }

  public HaxeModuleModel getModule() {
    return HaxeModuleModel.fromElement(haxeClass);
  }

  private HaxeFileModel file = null;
  public HaxeFileModel getFile() {
    if (file == null) file = new HaxeFileModel((HaxeFile)haxeClass.getContainingFile());
    return file;
  }


  public HaxePackageModel getPackage() {
    String fqName = haxeClass.getQualifiedName();
    if (fqName == null) return null;
    return getProject().getPackageFromPath(HaxeProjectModel.extractPackagePathFromClassFqName(fqName));
  }

  public HaxeClassReferenceModel getParentClassReference() {
    List<HaxeType> list = haxeClass.getHaxeExtendsList();
    if (list.size() == 0) return null;
    return new HaxeClassReferenceModel(list.get(0));
  }

  static public boolean isValidClassName(String name) {
    return name.substring(0, 1).equals(name.substring(0, 1).toUpperCase());
  }

  public HaxeResolver2Class getResolver(boolean inStaticContext) {
    return new HaxeResolver2Class(this, inStaticContext);
  }

  public HaxeClassModel getParentClass() {
    final HaxeClassReferenceModel reference = this.getParentClassReference();
    return (reference != null) ? reference.getHaxeClass() : null;
  }

  public List<HaxeClassReferenceModel> getInterfaceExtendingInterfaces() {
    List<HaxeType> list = haxeClass.getHaxeExtendsList();
    List<HaxeClassReferenceModel> out = new ArrayList<HaxeClassReferenceModel>();
    for (HaxeType type : list) {
      out.add(new HaxeClassReferenceModel(type));
    }
    return out;
  }

  public List<HaxeClassReferenceModel> getImplementingInterfaces() {
    List<HaxeType> list = haxeClass.getHaxeImplementsList();
    List<HaxeClassReferenceModel> out = new ArrayList<HaxeClassReferenceModel>();
    for (HaxeType type : list) {
      out.add(new HaxeClassReferenceModel(type));
    }
    return out;
  }

  public boolean isExtern() {
    return haxeClass.isExtern();
  }

  public boolean isClass() {
    return !this.isAbstract() && (HaxeComponentType.typeOf(haxeClass) == HaxeComponentType.CLASS);
  }

  public boolean isInterface() {
    return HaxeComponentType.typeOf(haxeClass) == HaxeComponentType.INTERFACE;
  }

  public boolean isEnum() {
    return HaxeComponentType.typeOf(haxeClass) == HaxeComponentType.ENUM;
  }

  public boolean isTypedef() {
    return HaxeComponentType.typeOf(haxeClass) == HaxeComponentType.TYPEDEF;
  }

  public boolean isAbstract() {
    return haxeClass instanceof HaxeAbstractClassDeclaration;
  }

  // @TODO: Create AbstractHaxeClassModel extending this class for these methods?
  // @TODO: this should be properly parsed in haxe.bnf so searching for the underlying type is not required
  @Nullable
  public HaxeTypeOrAnonymous getAbstractUnderlyingType() {
    if (!isAbstract()) return null;
    PsiElement[] children = getPsi().getChildren();
    if (children.length >= 2) {
      if (children[1] instanceof HaxeTypeOrAnonymous) {
        return (HaxeTypeOrAnonymous)children[1];
      }
    }
    return null;
  }

  // @TODO: this should be properly parsed in haxe.bnf so searching for to is not required
  public List<HaxeType> getAbstractToList() {
    if (!isAbstract()) return Collections.emptyList();
    List<HaxeType> types = new LinkedList<HaxeType>();
    for (HaxeIdentifier id : UsefulPsiTreeUtil.getChildren(haxeClass, HaxeIdentifier.class)) {
      if (id.getText().equals("to")) {
        PsiElement sibling = UsefulPsiTreeUtil.getNextSiblingNoSpaces(id);
        if (sibling instanceof HaxeType) {
          types.add((HaxeType)sibling);
        }
      }
    }
    return types;
  }

  // @TODO: this should be properly parsed in haxe.bnf so searching for from is not required
  public List<HaxeType> getAbstractFromList() {
    if (!isAbstract()) return Collections.emptyList();
    List<HaxeType> types = new LinkedList<HaxeType>();
    for (HaxeIdentifier id : UsefulPsiTreeUtil.getChildren(haxeClass, HaxeIdentifier.class)) {
      if (id.getText().equals("from")) {
        PsiElement sibling = UsefulPsiTreeUtil.getNextSiblingNoSpaces(id);
        if (sibling instanceof HaxeType) {
          types.add((HaxeType)sibling);
        }
      }
    }
    return types;
  }

  public boolean hasMethod(String name) {
    return getMethod(name) != null;
  }

  public boolean hasMethodSelf(String name) {
    return getMethodSelf(name) != null;
  }

  public HaxeMethodModel getMethodSelf(String name) {
    final HaxeMemberModel member = getMemberSelf(name);
    return (member instanceof HaxeMethodModel) ? (HaxeMethodModel)member : null;
  }

  public HaxeFieldModel getFieldSelf(String name) {
    final HaxeMemberModel member = getMemberSelf(name);
    return (member instanceof HaxeFieldModel) ? (HaxeFieldModel)member : null;
  }

  @Nullable
  public HaxeMethodModel getConstructorSelf() {
    return getMethodSelf("new");
  }

  @Nullable
  public HaxeMethodModel getConstructor() {
    return getMethod("new");
  }

  public boolean hasConstructor() {
    return getConstructor() != null;
  }

  @Nullable
  public HaxeMethodModel getParentConstructor() {
    HaxeClassReferenceModel parentClass = getParentClassReference();
    if (parentClass == null) return null;
    return parentClass.getHaxeClass().getMethod("new");
  }

  @Nullable
  public HaxeMemberModel getMember(String name) {
    final HaxeMemberModel member = getMemberSelf(name);
    if (member == null) {
      // @TODO: Inherited
    }
    return member;
  }

  @Nullable
  public HaxeMemberModel getMemberSelf(String name) {
    final Map<String, HaxeMemberModel> membersSelf = getMembersMapSelf();
    return membersSelf.get(name);
  }

  public List<HaxeMemberModel> getMembers() {
    ArrayList<HaxeMemberModel> members = new ArrayList<HaxeMemberModel>();
    for (HaxeMemberModel member : getMembersSelf()) {
      members.add(member);
    }
    for (HaxeClassReferenceModel clazz : this.getImplementingInterfaces()) {
      final HaxeClassModel clazzModel = clazz.getHaxeClass();
      if (clazzModel != null) {
        clazzModel.getMembers();
      }
    }

    return members;
  }

  private LinkedHashMap<String, HaxeMemberModel> selfMembersMap;

  static final private Key<LinkedHashMap<String, HaxeMemberModel>> HAXE_CLASS_MEMBERS_MAP = new Key<LinkedHashMap<String, HaxeMemberModel>>("HAXE_CLASS_MEMBERS_MAP");

  private void prepareMembers() {
    getFile().removeCache(); // @TODO: Remove this line

    final HaxeCacheModel cache = getFile().getCache();

    if (!cache.has(HAXE_CLASS_MEMBERS_MAP)) {
      LinkedHashMap<String, HaxeMemberModel> selfMembersMap = new LinkedHashMap<String, HaxeMemberModel>();
      final PsiElement bodyPsi = this.getBodyPsi();
      if (bodyPsi != null) {
        for (PsiElement element : bodyPsi.getChildren()) {
          HaxeMemberModel member = null;
          if (element instanceof HaxeMethod) {
            member = ((HaxeMethod)element).getModel();
          } else if (element instanceof HaxeVarDeclaration) {
            member = ((HaxeVarDeclaration)element).getModel();
          }
          if (member != null) {
            selfMembersMap.put(member.getName(), member);
          }
        }
      }
      cache.put(HAXE_CLASS_MEMBERS_MAP, selfMembersMap);
    }
    this.selfMembersMap = cache.get(HAXE_CLASS_MEMBERS_MAP);
  }

  @NotNull
  public List<HaxeMemberModel> getMembersSelf() {
    prepareMembers();
    return new ArrayList<HaxeMemberModel>(selfMembersMap.values());
  }

  @NotNull
  public Map<String, HaxeMemberModel> getMembersMapSelf() {
    prepareMembers();
    return selfMembersMap;
  }

  @Nullable
  public HaxeFieldModel getField(String name) {
    final HaxeMemberModel member = getMember(name);
    return (member instanceof HaxeFieldModel) ? (HaxeFieldModel)member : null;
  }

  public HaxeMethodModel getMethod(String name) {
    final HaxeMemberModel member = getMember(name);
    return (member instanceof HaxeMethodModel) ? (HaxeMethodModel)member : null;
  }

  public List<HaxeMethodModel> getMethods() {
    List<HaxeMethodModel> out = new ArrayList<HaxeMethodModel>();
    for (HaxeMemberModel member : getMembers()) {
      if (member instanceof HaxeMethodModel) out.add((HaxeMethodModel)member);
    }
    return out;
  }

  public List<HaxeMethodModel> getMethodsSelf() {
    final ArrayList<HaxeMethodModel> out = new ArrayList<HaxeMethodModel>();
    for (HaxeMemberModel member : getMembersSelf()) {
      if (member instanceof HaxeMethodModel) {
        out.add((HaxeMethodModel)member);
      }
    }
    return out;
  }

  public List<HaxeMethodModel> getAncestorMethods() {
    List<HaxeMethodModel> models = new ArrayList<HaxeMethodModel>();
    for (HaxeMethod method : haxeClass.getHaxeMethods()) {
      if (method.getContainingClass() != this.haxeClass) models.add(method.getModel());
    }
    return models;
  }

  @NotNull
  public HaxeClass getPsi() {
    return haxeClass;
  }

  @Nullable
  public PsiElement getBodyPsi() {
    if (haxeClass instanceof HaxeClassDeclaration) {
      return ((HaxeClassDeclaration)haxeClass).getClassBody();
    }
    if (haxeClass instanceof HaxeAbstractClassDeclaration) {
      return ((HaxeAbstractClassDeclaration)haxeClass).getClassBody();
    }
    if (haxeClass instanceof HaxeExternClassDeclaration) {
      return ((HaxeExternClassDeclaration)haxeClass).getExternClassDeclarationBody();
    }
    if (haxeClass instanceof HaxeInterfaceDeclaration) {
      return ((HaxeInterfaceDeclaration)haxeClass).getInterfaceBody();
    }
    if (haxeClass instanceof HaxeExternInterfaceDeclaration) {
      return ((HaxeExternInterfaceDeclaration)haxeClass).getInterfaceBody();
    }
    if (haxeClass instanceof HaxeTypedefDeclaration) {
      final HaxeTypeOrAnonymous anonymous = ((HaxeTypedefDeclaration)haxeClass).getTypeOrAnonymous();
      if (anonymous != null) {
        final HaxeAnonymousType type = anonymous.getAnonymousType();
        if (type != null) {
          return type.getAnonymousTypeBody().getInterfaceBody();
        }
      }
    }
    return null;
  }

  @Nullable
  public PsiIdentifier getNamePsi() {
    return haxeClass.getNameIdentifier();
  }

  private HaxeDocumentModel _document = null;

  @NotNull
  public HaxeDocumentModel getDocument() {
    if (_document == null) _document = HaxeDocumentModel.fromElement(haxeClass);
    return _document;
  }

  public String getName() {
    return haxeClass.getName();
  }

  public void addMethodsFromPrototype(List<HaxeMethodModel> methods) {
    throw new NotImplementedException("Not implemented HaxeClassMethod.addMethodsFromPrototype() : check HaxeImplementMethodHandler");
  }

  public List<HaxeFieldModel> getFields() {
    List<HaxeFieldModel> out = new ArrayList<HaxeFieldModel>();
    for (HaxeMemberModel member : getMembers()) {
      if (member instanceof HaxeFieldModel) out.add((HaxeFieldModel)member);
    }
    return out;
  }

  public List<HaxeFieldModel> getFieldsSelf() {
    final ArrayList<HaxeFieldModel> out = new ArrayList<HaxeFieldModel>();
    for (HaxeMemberModel member : getMembersSelf()) {
      if (member instanceof HaxeFieldModel) {
        out.add((HaxeFieldModel)member);
      }
    }
    return out;
  }

  public Set<HaxeClassModel> getCompatibleTypes() {
    final Set<HaxeClassModel> output = new LinkedHashSet<HaxeClassModel>();
    writeCompatibleTypes(output);
    return output;
  }

  public void writeCompatibleTypes(Set<HaxeClassModel> output) {
    // Own
    output.add(this);

    final HaxeClassModel parentClass = this.getParentClass();

    // Parent classes
    if (parentClass != null) {
      if (!output.contains(parentClass)) {
        parentClass.writeCompatibleTypes(output);
      }
    }

    // Interfaces
    for (HaxeClassReferenceModel model : this.getImplementingInterfaces()) {
      if (model == null) continue;
      final HaxeClassModel aInterface = model.getHaxeClass();
      if (aInterface == null) continue;
      if (!output.contains(aInterface)) {
        aInterface.writeCompatibleTypes(output);
      }
    }

    // @CHECK abstract FROM
    for (HaxeType type : getAbstractFromList()) {
      final ResultHolder aTypeRef = HaxeTypeResolver.getTypeFromType(type);
      SpecificHaxeClassReference classType = aTypeRef.getClassType();
      if (classType != null) {
        classType.getHaxeClassModel().writeCompatibleTypes(output);
      }
    }

    // @CHECK abstract TO
    for (HaxeType type : getAbstractToList()) {
      final ResultHolder aTypeRef = HaxeTypeResolver.getTypeFromType(type);
      SpecificHaxeClassReference classType = aTypeRef.getClassType();
      if (classType != null) {
        classType.getHaxeClassModel().writeCompatibleTypes(output);
      }
    }
  }

  public List<HaxeGenericParamModel> getGenericParams() {
    List<HaxeGenericParamModel> out = new LinkedList<HaxeGenericParamModel>();
    if (getPsi().getGenericParam() != null) {
      int index = 0;
      for (HaxeGenericListPart part : getPsi().getGenericParam().getGenericListPartList()) {
        out.add(new HaxeGenericParamModel(part, index));
        index++;
      }
    }
    return out;
  }

  public void addField(String name, SpecificTypeReference type) {
    this.getDocument().addTextAfterElement(getBodyPsi(), "\npublic var " + name + ":" + type.toStringWithoutConstant() + ";\n");
  }

  public void addMethod(String name, String... args) {
    this.getDocument().addTextAfterElement(getBodyPsi(), "\npublic function " + name + "(" + StringUtils.join(args, ", ") + ") {\n}\n");
  }

  public HaxeClassReference getReference() {
    return new HaxeClassReference(this, this.getPsi());
  }

  public ResultHolder getInstanceType() {
    return SpecificHaxeClassReference.withoutGenerics(getReference()).createHolder();
  }

  public ResultHolder getClassType() {
    return SpecificHaxeClassReference.withGenerics(
      SpecificHaxeClassReference.getClass(this.getPsi()).getHaxeClassRef(),
      getInstanceType()
    ).createHolder();
  }
}
