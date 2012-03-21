/* The following code was generated by JFlex 1.4.3 on 3/20/12 3:01 PM */

package com.intellij.plugins.haxe.lang.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import java.util.*;
import java.lang.reflect.Field;
import org.jetbrains.annotations.NotNull;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 3/20/12 3:01 PM from the specification file
 * <tt>C:/workspace/idea/plugins/haxe/src/com/intellij/plugins/haxe/lang/lexer/haxe.flex</tt>
 */
public class _HaxeLexer implements FlexLexer, HaxeTokenTypes, HaxeTokenTypeSets {
  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\1\1\7\1\0\1\1\1\7\22\0\1\1\1\70\1\23"+
    "\1\100\1\0\1\77\1\74\1\21\1\61\1\62\1\6\1\17\1\64"+
    "\1\65\1\20\1\5\1\13\7\12\2\11\1\53\1\63\1\75\1\67"+
    "\1\66\1\72\1\52\4\10\1\16\1\10\21\2\1\15\2\2\1\57"+
    "\1\22\1\60\1\76\1\3\1\0\1\32\1\30\1\42\1\34\1\25"+
    "\1\35\1\43\1\47\1\27\1\2\1\33\1\37\1\46\1\24\1\44"+
    "\1\41\1\54\1\31\1\45\1\40\1\36\1\50\1\26\1\14\1\51"+
    "\1\2\1\55\1\73\1\56\1\71\53\0\1\2\12\0\1\2\4\0"+
    "\1\2\5\0\27\2\1\0\37\2\1\0\u013f\2\31\0\162\2\4\0"+
    "\14\2\16\0\5\2\11\0\1\2\213\0\1\2\13\0\1\2\1\0"+
    "\3\2\1\0\1\2\1\0\24\2\1\0\54\2\1\0\46\2\1\0"+
    "\5\2\4\0\202\2\10\0\105\2\1\0\46\2\2\0\2\2\6\0"+
    "\20\2\41\0\46\2\2\0\1\2\7\0\47\2\110\0\33\2\5\0"+
    "\3\2\56\0\32\2\5\0\13\2\25\0\12\4\4\0\2\2\1\0"+
    "\143\2\1\0\1\2\17\0\2\2\7\0\2\2\12\4\3\2\2\0"+
    "\1\2\20\0\1\2\1\0\36\2\35\0\3\2\60\0\46\2\13\0"+
    "\1\2\u0152\0\66\2\3\0\1\2\22\0\1\2\7\0\12\2\4\0"+
    "\12\4\25\0\10\2\2\0\2\2\2\0\26\2\1\0\7\2\1\0"+
    "\1\2\3\0\4\2\3\0\1\2\36\0\2\2\1\0\3\2\4\0"+
    "\12\4\2\2\23\0\6\2\4\0\2\2\2\0\26\2\1\0\7\2"+
    "\1\0\2\2\1\0\2\2\1\0\2\2\37\0\4\2\1\0\1\2"+
    "\7\0\12\4\2\0\3\2\20\0\11\2\1\0\3\2\1\0\26\2"+
    "\1\0\7\2\1\0\2\2\1\0\5\2\3\0\1\2\22\0\1\2"+
    "\17\0\2\2\4\0\12\4\25\0\10\2\2\0\2\2\2\0\26\2"+
    "\1\0\7\2\1\0\2\2\1\0\5\2\3\0\1\2\36\0\2\2"+
    "\1\0\3\2\4\0\12\4\1\0\1\2\21\0\1\2\1\0\6\2"+
    "\3\0\3\2\1\0\4\2\3\0\2\2\1\0\1\2\1\0\2\2"+
    "\3\0\2\2\3\0\3\2\3\0\10\2\1\0\3\2\55\0\11\4"+
    "\25\0\10\2\1\0\3\2\1\0\27\2\1\0\12\2\1\0\5\2"+
    "\46\0\2\2\4\0\12\4\25\0\10\2\1\0\3\2\1\0\27\2"+
    "\1\0\12\2\1\0\5\2\3\0\1\2\40\0\1\2\1\0\2\2"+
    "\4\0\12\4\25\0\10\2\1\0\3\2\1\0\27\2\1\0\20\2"+
    "\46\0\2\2\4\0\12\4\25\0\22\2\3\0\30\2\1\0\11\2"+
    "\1\0\1\2\2\0\7\2\72\0\60\2\1\0\2\2\14\0\7\2"+
    "\11\0\12\4\47\0\2\2\1\0\1\2\2\0\2\2\1\0\1\2"+
    "\2\0\1\2\6\0\4\2\1\0\7\2\1\0\3\2\1\0\1\2"+
    "\1\0\1\2\2\0\2\2\1\0\4\2\1\0\2\2\11\0\1\2"+
    "\2\0\5\2\1\0\1\2\11\0\12\4\2\0\2\2\42\0\1\2"+
    "\37\0\12\4\26\0\10\2\1\0\42\2\35\0\4\2\164\0\42\2"+
    "\1\0\5\2\1\0\2\2\25\0\12\4\6\0\6\2\112\0\46\2"+
    "\12\0\51\2\7\0\132\2\5\0\104\2\5\0\122\2\6\0\7\2"+
    "\1\0\77\2\1\0\1\2\1\0\4\2\2\0\7\2\1\0\1\2"+
    "\1\0\4\2\2\0\47\2\1\0\1\2\1\0\4\2\2\0\37\2"+
    "\1\0\1\2\1\0\4\2\2\0\7\2\1\0\1\2\1\0\4\2"+
    "\2\0\7\2\1\0\7\2\1\0\27\2\1\0\37\2\1\0\1\2"+
    "\1\0\4\2\2\0\7\2\1\0\47\2\1\0\23\2\16\0\11\4"+
    "\56\0\125\2\14\0\u026c\2\2\0\10\2\12\0\32\2\5\0\113\2"+
    "\25\0\15\2\1\0\4\2\16\0\22\2\16\0\22\2\16\0\15\2"+
    "\1\0\3\2\17\0\64\2\43\0\1\2\4\0\1\2\3\0\12\4"+
    "\46\0\12\4\6\0\130\2\10\0\51\2\127\0\35\2\51\0\12\4"+
    "\36\2\2\0\5\2\u038b\0\154\2\224\0\234\2\4\0\132\2\6\0"+
    "\26\2\2\0\6\2\2\0\46\2\2\0\6\2\2\0\10\2\1\0"+
    "\1\2\1\0\1\2\1\0\1\2\1\0\37\2\2\0\65\2\1\0"+
    "\7\2\1\0\1\2\3\0\3\2\1\0\7\2\3\0\4\2\2\0"+
    "\6\2\4\0\15\2\5\0\3\2\1\0\7\2\164\0\1\2\15\0"+
    "\1\2\202\0\1\2\4\0\1\2\2\0\12\2\1\0\1\2\3\0"+
    "\5\2\6\0\1\2\1\0\1\2\1\0\1\2\1\0\4\2\1\0"+
    "\3\2\1\0\7\2\3\0\3\2\5\0\5\2\u0ebb\0\2\2\52\0"+
    "\5\2\5\0\2\2\4\0\126\2\6\0\3\2\1\0\132\2\1\0"+
    "\4\2\5\0\50\2\4\0\136\2\21\0\30\2\70\0\20\2\u0200\0"+
    "\u19b6\2\112\0\u51a6\2\132\0\u048d\2\u0773\0\u2ba4\2\u215c\0\u012e\2\2\0"+
    "\73\2\225\0\7\2\14\0\5\2\5\0\1\2\1\0\12\2\1\0"+
    "\15\2\1\0\5\2\1\0\1\2\1\0\2\2\1\0\2\2\1\0"+
    "\154\2\41\0\u016b\2\22\0\100\2\2\0\66\2\50\0\14\2\164\0"+
    "\5\2\1\0\207\2\23\0\12\4\7\0\32\2\6\0\32\2\13\0"+
    "\131\2\3\0\6\2\2\0\6\2\2\0\6\2\2\0\3\2\43\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\1\1\4\1\5\2\6"+
    "\1\7\1\10\1\11\1\12\17\3\1\1\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\1\3\0\1\37\1\40\1\41\1\42"+
    "\1\43\1\0\1\44\1\45\1\46\1\0\2\11\2\12"+
    "\6\3\1\47\1\50\4\3\1\51\22\3\1\0\1\52"+
    "\1\53\1\54\1\0\1\55\1\56\1\57\1\60\1\61"+
    "\1\62\1\63\1\64\1\65\1\66\1\67\2\0\1\46"+
    "\1\0\1\40\1\70\1\71\1\72\1\73\16\3\1\74"+
    "\2\3\1\75\15\3\1\76\4\0\1\77\1\100\3\0"+
    "\1\101\1\0\2\70\1\102\1\3\1\103\1\104\14\3"+
    "\1\105\1\106\6\3\1\107\1\110\5\3\5\0\1\111"+
    "\2\0\1\40\1\0\2\3\1\112\4\3\1\113\3\3"+
    "\1\114\2\3\1\115\4\3\1\116\1\117\4\3\6\0"+
    "\1\120\1\3\1\121\1\122\2\3\1\123\1\124\7\3"+
    "\1\125\2\3\1\126\1\127\5\0\1\130\1\0\1\131"+
    "\2\3\1\132\1\133\1\3\1\134\1\135\1\136\1\137"+
    "\2\3\1\0\1\140\2\0\1\141\1\142\2\3\1\143"+
    "\1\144\1\145\3\0\1\146\1\3\1\147\2\0\1\150"+
    "\1\151\1\152";

  private static int [] zzUnpackAction() {
    int [] result = new int[301];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\101\0\202\0\303\0\u0104\0\u0145\0\u0186\0\u01c7"+
    "\0\u0208\0\u0249\0\u028a\0\u02cb\0\u030c\0\u034d\0\u038e\0\u03cf"+
    "\0\u0410\0\u0451\0\u0492\0\u04d3\0\u0514\0\u0555\0\u0596\0\u05d7"+
    "\0\u0618\0\u0659\0\u069a\0\u06db\0\u071c\0\101\0\101\0\101"+
    "\0\101\0\101\0\101\0\101\0\101\0\101\0\u075d\0\u079e"+
    "\0\u07df\0\u0820\0\101\0\101\0\u0861\0\u08a2\0\u08e3\0\u0924"+
    "\0\u0965\0\u09a6\0\u0104\0\u09e7\0\u0a28\0\u0a69\0\u0aaa\0\101"+
    "\0\101\0\u0aeb\0\u0b2c\0\101\0\101\0\u0b6d\0\u0bae\0\101"+
    "\0\u0bef\0\u0c30\0\101\0\u0c71\0\u0cb2\0\u0cf3\0\u0d34\0\u0d75"+
    "\0\u0db6\0\u0df7\0\303\0\u0e38\0\u0e79\0\u0eba\0\u0efb\0\303"+
    "\0\u0f3c\0\u0f7d\0\u0fbe\0\u0fff\0\u1040\0\u1081\0\u10c2\0\u1103"+
    "\0\u1144\0\u1185\0\u11c6\0\u1207\0\u1248\0\u1289\0\u12ca\0\u130b"+
    "\0\u134c\0\u138d\0\u13ce\0\101\0\101\0\101\0\u140f\0\101"+
    "\0\101\0\101\0\101\0\101\0\101\0\101\0\101\0\u1450"+
    "\0\101\0\101\0\u1491\0\u14d2\0\u1513\0\u1513\0\u1554\0\u1595"+
    "\0\u0b2c\0\101\0\303\0\u15d6\0\u1617\0\u1658\0\u1699\0\u16da"+
    "\0\u171b\0\u175c\0\u179d\0\u17de\0\u181f\0\u1860\0\u18a1\0\u18e2"+
    "\0\u1923\0\303\0\u1964\0\u19a5\0\303\0\u19e6\0\u1a27\0\u1a68"+
    "\0\u1aa9\0\u1aea\0\u1b2b\0\u1b6c\0\u1bad\0\u1bee\0\u1c2f\0\u1c70"+
    "\0\u1cb1\0\u1cf2\0\303\0\u1d33\0\u1d74\0\u1db5\0\u1df6\0\101"+
    "\0\101\0\u1e37\0\u1e78\0\u1eb9\0\101\0\u1efa\0\u1f3b\0\101"+
    "\0\303\0\u1f7c\0\303\0\303\0\u1fbd\0\u1ffe\0\u203f\0\u2080"+
    "\0\u20c1\0\u2102\0\u2143\0\u2184\0\u21c5\0\u2206\0\u2247\0\u2288"+
    "\0\303\0\303\0\u22c9\0\u230a\0\u234b\0\u238c\0\u23cd\0\u240e"+
    "\0\303\0\303\0\u244f\0\u2490\0\u24d1\0\u2512\0\u2553\0\u2594"+
    "\0\u25d5\0\u2616\0\u2657\0\u2698\0\101\0\u26d9\0\u271a\0\101"+
    "\0\u275b\0\u279c\0\u27dd\0\303\0\u281e\0\u285f\0\u28a0\0\u28e1"+
    "\0\303\0\u2922\0\u2963\0\u29a4\0\303\0\u29e5\0\u2a26\0\303"+
    "\0\u2a67\0\u2aa8\0\u2ae9\0\u2b2a\0\303\0\303\0\u2b6b\0\u2bac"+
    "\0\u2bed\0\u2c2e\0\u2c6f\0\u2cb0\0\u2cf1\0\u2d32\0\u2d73\0\u2db4"+
    "\0\u2df5\0\u2e36\0\303\0\303\0\u2e77\0\u2eb8\0\303\0\303"+
    "\0\u2ef9\0\u2f3a\0\u2f7b\0\u2fbc\0\u2ffd\0\u303e\0\u307f\0\303"+
    "\0\u30c0\0\u3101\0\303\0\303\0\u3142\0\u3183\0\u31c4\0\u3205"+
    "\0\u3246\0\101\0\u3287\0\303\0\u32c8\0\u3309\0\303\0\303"+
    "\0\u334a\0\303\0\303\0\303\0\303\0\u338b\0\u33cc\0\u340d"+
    "\0\101\0\u344e\0\u348f\0\101\0\101\0\u34d0\0\u3511\0\303"+
    "\0\303\0\303\0\u3552\0\u3593\0\u35d4\0\303\0\u3615\0\101"+
    "\0\u3656\0\u3697\0\303\0\101\0\101";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[301];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\2\4\1\5\1\6\1\7\1\3\1\4"+
    "\2\10\1\11\3\4\1\12\1\13\1\14\1\2\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\2\4\1\24"+
    "\1\25\1\26\1\4\1\27\1\30\1\31\1\4\1\32"+
    "\1\33\2\4\1\34\1\4\1\35\1\36\1\4\1\37"+
    "\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47"+
    "\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57"+
    "\1\60\1\61\1\62\102\0\1\3\5\0\1\3\73\0"+
    "\3\4\3\0\7\4\5\0\26\4\2\0\1\4\30\0"+
    "\1\63\4\0\3\63\2\0\1\64\1\0\1\65\4\0"+
    "\1\64\60\0\1\66\1\67\60\0\1\70\100\0\1\71"+
    "\15\0\1\63\4\0\3\10\2\0\1\64\1\0\1\65"+
    "\4\0\1\64\57\0\1\63\4\0\1\63\2\72\2\73"+
    "\1\64\1\0\1\65\4\0\1\64\72\0\1\74\47\0"+
    "\1\75\15\0\1\76\4\0\3\76\4\0\1\77\60\0"+
    "\7\14\1\0\11\14\1\100\1\101\56\14\7\15\1\0"+
    "\12\15\1\102\1\103\55\15\2\0\3\4\3\0\7\4"+
    "\5\0\1\4\1\104\10\4\1\105\13\4\2\0\1\4"+
    "\26\0\3\4\3\0\4\4\1\106\2\4\5\0\1\107"+
    "\12\4\1\110\12\4\2\0\1\4\26\0\3\4\3\0"+
    "\7\4\5\0\23\4\1\111\2\4\2\0\1\4\26\0"+
    "\3\4\3\0\7\4\5\0\1\112\10\4\1\113\10\4"+
    "\1\114\3\4\2\0\1\4\26\0\3\4\3\0\7\4"+
    "\5\0\5\4\1\115\20\4\2\0\1\4\26\0\3\4"+
    "\3\0\7\4\5\0\1\4\1\116\24\4\2\0\1\4"+
    "\26\0\3\4\3\0\7\4\5\0\1\4\1\117\16\4"+
    "\1\120\4\4\1\121\2\0\1\4\26\0\3\4\3\0"+
    "\7\4\5\0\6\4\1\122\3\4\1\123\5\4\1\124"+
    "\5\4\2\0\1\4\26\0\3\4\3\0\7\4\5\0"+
    "\1\125\25\4\2\0\1\4\26\0\3\4\3\0\7\4"+
    "\5\0\5\4\1\126\15\4\1\127\1\4\1\130\2\0"+
    "\1\4\26\0\3\4\3\0\7\4\5\0\5\4\1\131"+
    "\1\132\3\4\1\133\13\4\2\0\1\4\26\0\3\4"+
    "\3\0\7\4\5\0\6\4\1\134\4\4\1\135\4\4"+
    "\1\136\5\4\2\0\1\4\26\0\3\4\3\0\7\4"+
    "\5\0\24\4\1\137\1\4\2\0\1\4\26\0\3\4"+
    "\3\0\7\4\5\0\2\4\1\140\11\4\1\141\11\4"+
    "\2\0\1\4\26\0\3\4\3\0\7\4\5\0\6\4"+
    "\1\142\17\4\2\0\1\4\77\0\1\143\112\0\1\144"+
    "\1\145\1\146\77\0\1\147\1\150\100\0\1\151\100\0"+
    "\1\152\100\0\1\153\3\0\1\154\74\0\1\155\4\0"+
    "\1\156\73\0\1\157\5\0\1\160\72\0\1\161\100\0"+
    "\1\162\36\0\1\163\1\0\1\164\55\0\1\165\4\0"+
    "\3\165\3\0\1\166\45\0\1\166\17\0\1\76\4\0"+
    "\3\76\65\0\7\66\1\0\71\66\6\167\1\170\72\167"+
    "\4\0\1\63\4\0\1\63\2\72\2\0\1\64\1\0"+
    "\1\65\4\0\1\64\63\0\4\171\2\0\1\171\6\0"+
    "\1\171\2\0\1\171\1\0\1\171\1\0\2\171\4\0"+
    "\1\171\42\0\1\76\4\0\3\76\2\0\1\64\6\0"+
    "\1\64\73\0\1\172\60\0\7\14\1\0\71\14\7\15"+
    "\1\0\71\15\2\0\3\4\3\0\7\4\5\0\2\4"+
    "\1\173\23\4\2\0\1\4\26\0\3\4\3\0\7\4"+
    "\5\0\13\4\1\174\12\4\2\0\1\4\26\0\3\4"+
    "\3\0\7\4\5\0\14\4\1\175\11\4\2\0\1\4"+
    "\26\0\3\4\3\0\7\4\5\0\12\4\1\176\13\4"+
    "\2\0\1\4\26\0\3\4\3\0\7\4\5\0\21\4"+
    "\1\177\4\4\2\0\1\4\26\0\3\4\3\0\7\4"+
    "\5\0\3\4\1\200\22\4\2\0\1\4\26\0\3\4"+
    "\3\0\7\4\5\0\13\4\1\201\1\202\11\4\2\0"+
    "\1\4\26\0\3\4\3\0\7\4\5\0\15\4\1\203"+
    "\10\4\2\0\1\4\26\0\3\4\3\0\7\4\5\0"+
    "\1\4\1\204\24\4\2\0\1\4\26\0\3\4\3\0"+
    "\7\4\5\0\14\4\1\205\11\4\2\0\1\4\26\0"+
    "\3\4\3\0\7\4\5\0\11\4\1\206\14\4\2\0"+
    "\1\4\26\0\3\4\3\0\7\4\5\0\1\207\25\4"+
    "\2\0\1\4\26\0\3\4\3\0\7\4\5\0\13\4"+
    "\1\210\12\4\2\0\1\4\26\0\3\4\3\0\7\4"+
    "\5\0\1\211\25\4\2\0\1\4\26\0\3\4\3\0"+
    "\7\4\5\0\5\4\1\212\20\4\2\0\1\4\26\0"+
    "\3\4\3\0\7\4\5\0\14\4\1\213\11\4\2\0"+
    "\1\4\26\0\3\4\3\0\7\4\5\0\12\4\1\214"+
    "\12\4\1\215\2\0\1\4\26\0\3\4\3\0\7\4"+
    "\5\0\3\4\1\216\1\4\1\217\20\4\2\0\1\4"+
    "\26\0\3\4\3\0\7\4\5\0\15\4\1\220\10\4"+
    "\2\0\1\4\26\0\3\4\3\0\7\4\5\0\3\4"+
    "\1\221\22\4\2\0\1\4\26\0\3\4\3\0\7\4"+
    "\5\0\16\4\1\222\7\4\2\0\1\4\26\0\3\4"+
    "\3\0\7\4\5\0\4\4\1\223\21\4\2\0\1\4"+
    "\26\0\3\4\3\0\7\4\5\0\14\4\1\224\4\4"+
    "\1\225\4\4\2\0\1\4\26\0\3\4\3\0\7\4"+
    "\5\0\6\4\1\226\17\4\2\0\1\4\26\0\3\4"+
    "\3\0\7\4\5\0\1\227\25\4\2\0\1\4\26\0"+
    "\3\4\3\0\7\4\5\0\1\4\1\230\24\4\2\0"+
    "\1\4\26\0\3\4\3\0\7\4\5\0\3\4\1\231"+
    "\22\4\2\0\1\4\26\0\3\4\3\0\7\4\5\0"+
    "\6\4\1\232\17\4\2\0\1\4\26\0\3\4\3\0"+
    "\7\4\5\0\5\4\1\233\20\4\2\0\1\4\55\0"+
    "\1\234\3\0\1\235\4\0\1\236\3\0\1\237\121\0"+
    "\1\240\100\0\1\241\35\0\1\242\4\0\1\243\5\0"+
    "\1\244\76\0\1\245\47\0\1\165\4\0\3\165\65\0"+
    "\6\167\1\246\72\167\5\247\1\250\1\170\72\247\2\0"+
    "\3\4\3\0\7\4\5\0\13\4\1\251\12\4\2\0"+
    "\1\4\26\0\3\4\3\0\7\4\5\0\1\4\1\252"+
    "\24\4\2\0\1\4\26\0\3\4\3\0\7\4\5\0"+
    "\22\4\1\253\3\4\2\0\1\4\26\0\3\4\3\0"+
    "\7\4\5\0\1\4\1\254\24\4\2\0\1\4\26\0"+
    "\3\4\3\0\7\4\5\0\13\4\1\255\12\4\2\0"+
    "\1\4\26\0\3\4\3\0\7\4\5\0\3\4\1\256"+
    "\22\4\2\0\1\4\26\0\3\4\3\0\7\4\5\0"+
    "\1\4\1\257\24\4\2\0\1\4\26\0\3\4\3\0"+
    "\7\4\5\0\13\4\1\260\4\4\1\261\5\4\2\0"+
    "\1\4\26\0\3\4\3\0\7\4\5\0\6\4\1\262"+
    "\17\4\2\0\1\4\26\0\3\4\3\0\7\4\5\0"+
    "\12\4\1\263\13\4\2\0\1\4\26\0\3\4\3\0"+
    "\7\4\5\0\6\4\1\264\17\4\2\0\1\4\26\0"+
    "\3\4\3\0\7\4\5\0\6\4\1\265\17\4\2\0"+
    "\1\4\26\0\3\4\3\0\7\4\5\0\21\4\1\266"+
    "\4\4\2\0\1\4\26\0\3\4\3\0\7\4\5\0"+
    "\16\4\1\267\7\4\2\0\1\4\26\0\3\4\3\0"+
    "\7\4\5\0\25\4\1\270\2\0\1\4\26\0\3\4"+
    "\3\0\7\4\5\0\1\4\1\271\24\4\2\0\1\4"+
    "\26\0\3\4\3\0\7\4\5\0\21\4\1\272\4\4"+
    "\2\0\1\4\26\0\3\4\3\0\7\4\5\0\20\4"+
    "\1\273\5\4\2\0\1\4\26\0\3\4\3\0\7\4"+
    "\5\0\1\4\1\274\24\4\2\0\1\4\26\0\3\4"+
    "\3\0\7\4\5\0\24\4\1\275\1\4\2\0\1\4"+
    "\26\0\3\4\3\0\7\4\5\0\7\4\1\276\16\4"+
    "\2\0\1\4\26\0\3\4\3\0\7\4\5\0\13\4"+
    "\1\277\12\4\2\0\1\4\26\0\3\4\3\0\7\4"+
    "\5\0\16\4\1\300\7\4\2\0\1\4\26\0\3\4"+
    "\3\0\7\4\5\0\1\4\1\301\12\4\1\302\11\4"+
    "\2\0\1\4\26\0\3\4\3\0\7\4\5\0\21\4"+
    "\1\303\4\4\2\0\1\4\26\0\3\4\3\0\7\4"+
    "\5\0\14\4\1\304\11\4\2\0\1\4\26\0\3\4"+
    "\3\0\7\4\5\0\5\4\1\305\20\4\2\0\1\4"+
    "\26\0\3\4\3\0\7\4\5\0\14\4\1\306\11\4"+
    "\2\0\1\4\26\0\3\4\3\0\7\4\5\0\14\4"+
    "\1\307\11\4\2\0\1\4\51\0\1\310\102\0\1\311"+
    "\2\0\1\312\112\0\1\313\66\0\1\314\102\0\1\315"+
    "\75\0\1\316\114\0\1\317\33\0\5\167\1\320\1\246"+
    "\72\167\6\247\1\321\72\247\2\0\3\4\3\0\7\4"+
    "\5\0\1\322\4\4\1\323\20\4\2\0\1\4\26\0"+
    "\3\4\3\0\7\4\5\0\1\4\1\324\24\4\2\0"+
    "\1\4\26\0\3\4\3\0\7\4\5\0\1\325\25\4"+
    "\2\0\1\4\26\0\3\4\3\0\7\4\5\0\5\4"+
    "\1\326\20\4\2\0\1\4\26\0\3\4\3\0\7\4"+
    "\5\0\1\4\1\327\24\4\2\0\1\4\26\0\3\4"+
    "\3\0\7\4\5\0\5\4\1\330\20\4\2\0\1\4"+
    "\26\0\3\4\3\0\7\4\5\0\7\4\1\331\16\4"+
    "\2\0\1\4\26\0\3\4\3\0\7\4\5\0\5\4"+
    "\1\332\20\4\2\0\1\4\26\0\3\4\3\0\7\4"+
    "\5\0\12\4\1\333\13\4\2\0\1\4\26\0\3\4"+
    "\3\0\7\4\5\0\22\4\1\334\3\4\2\0\1\4"+
    "\26\0\3\4\3\0\7\4\5\0\1\4\1\335\24\4"+
    "\2\0\1\4\26\0\3\4\3\0\7\4\5\0\14\4"+
    "\1\336\11\4\2\0\1\4\26\0\3\4\3\0\7\4"+
    "\5\0\15\4\1\337\10\4\2\0\1\4\26\0\3\4"+
    "\3\0\7\4\5\0\2\4\1\340\23\4\2\0\1\4"+
    "\26\0\3\4\3\0\7\4\5\0\10\4\1\341\15\4"+
    "\2\0\1\4\26\0\3\4\3\0\7\4\5\0\6\4"+
    "\1\342\17\4\2\0\1\4\26\0\3\4\3\0\7\4"+
    "\5\0\6\4\1\343\17\4\2\0\1\4\26\0\3\4"+
    "\3\0\7\4\5\0\3\4\1\344\22\4\2\0\1\4"+
    "\26\0\3\4\3\0\7\4\5\0\23\4\1\345\2\4"+
    "\2\0\1\4\26\0\3\4\3\0\7\4\5\0\21\4"+
    "\1\346\4\4\2\0\1\4\26\0\3\4\3\0\7\4"+
    "\5\0\3\4\1\347\22\4\2\0\1\4\26\0\3\4"+
    "\3\0\7\4\5\0\5\4\1\350\20\4\2\0\1\4"+
    "\26\0\3\4\3\0\7\4\5\0\16\4\1\351\7\4"+
    "\2\0\1\4\26\0\3\4\3\0\7\4\5\0\3\4"+
    "\1\352\22\4\2\0\1\4\100\0\1\353\50\0\1\354"+
    "\107\0\1\355\76\0\1\356\111\0\1\357\102\0\1\360"+
    "\61\0\1\361\53\0\5\247\1\250\1\321\72\247\2\0"+
    "\3\4\3\0\7\4\5\0\10\4\1\362\15\4\2\0"+
    "\1\4\26\0\3\4\3\0\7\4\5\0\1\363\25\4"+
    "\2\0\1\4\26\0\3\4\3\0\7\4\5\0\1\4"+
    "\1\364\24\4\2\0\1\4\26\0\3\4\3\0\7\4"+
    "\5\0\11\4\1\365\14\4\2\0\1\4\26\0\3\4"+
    "\3\0\7\4\5\0\22\4\1\366\3\4\2\0\1\4"+
    "\26\0\3\4\3\0\7\4\5\0\14\4\1\367\11\4"+
    "\2\0\1\4\26\0\3\4\3\0\7\4\5\0\1\370"+
    "\25\4\2\0\1\4\26\0\3\4\3\0\7\4\5\0"+
    "\13\4\1\371\12\4\2\0\1\4\26\0\3\4\3\0"+
    "\7\4\5\0\3\4\1\372\22\4\2\0\1\4\26\0"+
    "\3\4\3\0\7\4\5\0\3\4\1\373\22\4\2\0"+
    "\1\4\26\0\3\4\3\0\7\4\5\0\1\4\1\374"+
    "\24\4\2\0\1\4\26\0\3\4\3\0\7\4\5\0"+
    "\1\4\1\375\24\4\2\0\1\4\26\0\3\4\3\0"+
    "\7\4\5\0\14\4\1\376\11\4\2\0\1\4\26\0"+
    "\3\4\3\0\7\4\5\0\17\4\1\377\6\4\2\0"+
    "\1\4\26\0\3\4\3\0\7\4\5\0\16\4\1\u0100"+
    "\7\4\2\0\1\4\26\0\3\4\3\0\7\4\5\0"+
    "\1\u0101\25\4\2\0\1\4\26\0\3\4\3\0\7\4"+
    "\5\0\3\4\1\u0102\22\4\2\0\1\4\26\0\3\4"+
    "\3\0\7\4\5\0\23\4\1\u0103\2\4\2\0\1\4"+
    "\26\0\3\4\3\0\7\4\5\0\16\4\1\u0104\7\4"+
    "\2\0\1\4\62\0\1\u0105\74\0\1\u0106\73\0\1\u0107"+
    "\100\0\1\u0108\104\0\1\u0109\100\0\1\u010a\76\0\1\u010b"+
    "\53\0\3\4\3\0\7\4\5\0\21\4\1\u010c\4\4"+
    "\2\0\1\4\26\0\3\4\3\0\7\4\5\0\6\4"+
    "\1\u010d\17\4\2\0\1\4\26\0\3\4\3\0\7\4"+
    "\5\0\1\4\1\u010e\24\4\2\0\1\4\26\0\3\4"+
    "\3\0\7\4\5\0\14\4\1\u010f\11\4\2\0\1\4"+
    "\26\0\3\4\3\0\7\4\5\0\16\4\1\u0110\7\4"+
    "\2\0\1\4\26\0\3\4\3\0\7\4\5\0\20\4"+
    "\1\u0111\5\4\2\0\1\4\26\0\3\4\3\0\7\4"+
    "\5\0\10\4\1\u0112\15\4\2\0\1\4\26\0\3\4"+
    "\3\0\7\4\5\0\11\4\1\u0113\14\4\2\0\1\4"+
    "\26\0\3\4\3\0\7\4\5\0\1\4\1\u0114\24\4"+
    "\2\0\1\4\26\0\3\4\3\0\7\4\5\0\1\4"+
    "\1\u0115\24\4\2\0\1\4\26\0\3\4\3\0\7\4"+
    "\5\0\12\4\1\u0116\13\4\2\0\1\4\26\0\3\4"+
    "\3\0\7\4\5\0\10\4\1\u0117\15\4\2\0\1\4"+
    "\53\0\1\u0118\110\0\1\u0119\57\0\1\u011a\65\0\1\u011b"+
    "\141\0\1\u011c\71\0\1\u011d\45\0\3\4\3\0\7\4"+
    "\5\0\16\4\1\u011e\7\4\2\0\1\4\26\0\3\4"+
    "\3\0\7\4\5\0\1\u011f\25\4\2\0\1\4\26\0"+
    "\3\4\3\0\7\4\5\0\1\u0120\25\4\2\0\1\4"+
    "\26\0\3\4\3\0\7\4\5\0\1\4\1\u0121\24\4"+
    "\2\0\1\4\26\0\3\4\3\0\7\4\5\0\1\4"+
    "\1\u0122\24\4\2\0\1\4\55\0\1\u0123\73\0\1\u0124"+
    "\106\0\1\u0125\50\0\3\4\3\0\7\4\5\0\1\4"+
    "\1\u0126\24\4\2\0\1\4\26\0\3\4\3\0\7\4"+
    "\5\0\14\4\1\u0127\11\4\2\0\1\4\51\0\1\u0128"+
    "\111\0\1\u0129\103\0\1\u012a\41\0\3\4\3\0\7\4"+
    "\5\0\21\4\1\u012b\4\4\2\0\1\4\72\0\1\u012c"+
    "\61\0\1\u012d\51\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[14040];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;
  private static final char[] EMPTY_BUFFER = new char[0];
  private static final int YYEOF = -1;
  private static java.io.Reader zzReader = null; // Fake

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\33\1\11\11\4\1\2\11\6\1\3\0"+
    "\2\1\2\11\1\1\1\0\2\11\1\1\1\0\1\11"+
    "\2\1\1\11\37\1\1\0\3\11\1\0\10\11\1\1"+
    "\2\11\2\0\1\1\1\0\3\1\1\11\41\1\4\0"+
    "\2\11\3\0\1\11\1\0\1\1\1\11\37\1\5\0"+
    "\1\11\2\0\1\11\1\0\31\1\6\0\24\1\5\0"+
    "\1\11\1\0\14\1\1\0\1\11\2\0\2\11\5\1"+
    "\3\0\2\1\1\11\2\0\1\1\2\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[301];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** this buffer may contains the current text array to be matched when it is cheap to acquire it */
  private char[] zzBufferArray;

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;


  public _HaxeLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public _HaxeLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 1320) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart(){
    return zzStartRead;
  }

  public final int getTokenEnd(){
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end,int initialState){
    zzBuffer = buffer;
    zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzPushbackPos = 0;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBufferArray != null ? zzBufferArray[zzStartRead+pos]:zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;
    char[] zzBufferArrayL = zzBufferArray;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL.charAt(zzCurrentPosL++);
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL.charAt(zzCurrentPosL++);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 40: 
          { return KIF ;
          }
        case 107: break;
        case 20: 
          { return OMINUS;
          }
        case 108: break;
        case 24: 
          { return OCOMPLEMENT;
          }
        case 109: break;
        case 86: 
          { return KSWITCH ;
          }
        case 110: break;
        case 32: 
          { return MML_COMMENT;
          }
        case 111: break;
        case 27: 
          { return OBIT_AND;
          }
        case 112: break;
        case 25: 
          { return OQUEST;
          }
        case 113: break;
        case 10: 
          { return LITSTRING;
          }
        case 114: break;
        case 4: 
          { return OQUOTIENT;
          }
        case 115: break;
        case 101: 
          { return KOVERRIDE;
          }
        case 116: break;
        case 72: 
          { return( KCAST );
          }
        case 117: break;
        case 49: 
          { return OCOND_OR;
          }
        case 118: break;
        case 77: 
          { return KTHROW ;
          }
        case 119: break;
        case 69: 
          { return KTRUE ;
          }
        case 120: break;
        case 3: 
          { return ID;
          }
        case 121: break;
        case 48: 
          { return OBIT_OR_ASSIGN;
          }
        case 122: break;
        case 33: 
          { return OQUOTIENT_ASSIGN;
          }
        case 123: break;
        case 53: 
          { return OSHIFT_LEFT;
          }
        case 124: break;
        case 83: 
          { return KIMPORT ;
          }
        case 125: break;
        case 66: 
          { return KNULL ;
          }
        case 126: break;
        case 89: 
          { return( KEXTENDS );
          }
        case 127: break;
        case 67: 
          { return( KENUM );
          }
        case 128: break;
        case 15: 
          { return PRBRACK;
          }
        case 129: break;
        case 43: 
          { return OARROW;
          }
        case 130: break;
        case 1: 
          { yybegin(YYINITIAL); return com.intellij.psi.TokenType.BAD_CHARACTER;
          }
        case 131: break;
        case 14: 
          { return PLBRACK;
          }
        case 132: break;
        case 78: 
          { return KCATCH;
          }
        case 133: break;
        case 82: 
          { return KINLINE;
          }
        case 134: break;
        case 106: 
          { return KCOREAPI;
          }
        case 135: break;
        case 95: 
          { return( KPACKAGE );
          }
        case 136: break;
        case 87: 
          { return KSTATIC;
          }
        case 137: break;
        case 70: 
          { return KTHIS ;
          }
        case 138: break;
        case 104: 
          { return( KIMPLEMENTS );
          }
        case 139: break;
        case 2: 
          { return com.intellij.psi.TokenType.WHITE_SPACE;
          }
        case 140: break;
        case 102: 
          { return( KINTERFACE );
          }
        case 141: break;
        case 37: 
          { return OPLUS_ASSIGN;
          }
        case 142: break;
        case 29: 
          { return OBIT_XOR;
          }
        case 143: break;
        case 36: 
          { return OPLUS_PLUS;
          }
        case 144: break;
        case 81: 
          { return KEXTERN;
          }
        case 145: break;
        case 55: 
          { return OREMAINDER_ASSIGN;
          }
        case 146: break;
        case 76: 
          { return KFALSE ;
          }
        case 147: break;
        case 35: 
          { return LITOCT;
          }
        case 148: break;
        case 11: 
          { return OCOLON;
          }
        case 149: break;
        case 64: 
          { return OSHIFT_LEFT_ASSIGN;
          }
        case 150: break;
        case 80: 
          { return PPELSE;
          }
        case 151: break;
        case 52: 
          { return OLESS_OR_EQUAL;
          }
        case 152: break;
        case 31: 
          { return MSL_COMMENT;
          }
        case 153: break;
        case 62: 
          { return KVAR;
          }
        case 154: break;
        case 8: 
          { return ODOT;
          }
        case 155: break;
        case 44: 
          { return OMINUS_ASSIGN;
          }
        case 156: break;
        case 96: 
          { return KFINAL;
          }
        case 157: break;
        case 73: 
          { return PPEND;
          }
        case 158: break;
        case 28: 
          { return OLESS;
          }
        case 159: break;
        case 57: 
          { return LITHEX;
          }
        case 160: break;
        case 38: 
          { return LITFLOAT;
          }
        case 161: break;
        case 84: 
          { return KRETURN ;
          }
        case 162: break;
        case 17: 
          { return PRPAREN;
          }
        case 163: break;
        case 59: 
          { return ONEW;
          }
        case 164: break;
        case 42: 
          { return OMINUS_MINUS;
          }
        case 165: break;
        case 16: 
          { return PLPAREN;
          }
        case 166: break;
        case 85: 
          { return KPUBLIC;
          }
        case 167: break;
        case 60: 
          { return KFOR ;
          }
        case 168: break;
        case 26: 
          { return OBIT_OR;
          }
        case 169: break;
        case 91: 
          { return KDYNAMIC;
          }
        case 170: break;
        case 90: 
          { return( KDEFAULT );
          }
        case 171: break;
        case 21: 
          { return OGREATER;
          }
        case 172: break;
        case 19: 
          { return OCOMMA;
          }
        case 173: break;
        case 99: 
          { return( KFUNCTION );
          }
        case 174: break;
        case 9: 
          { return LITCHAR;
          }
        case 175: break;
        case 46: 
          { return OEQ;
          }
        case 176: break;
        case 41: 
          { return KDO ;
          }
        case 177: break;
        case 103: 
          { return KREQUIRE;
          }
        case 178: break;
        case 94: 
          { return KPRIVATE;
          }
        case 179: break;
        case 63: 
          { return OSHIFT_RIGHT_ASSIGN;
          }
        case 180: break;
        case 23: 
          { return ONOT;
          }
        case 181: break;
        case 13: 
          { return PRCURLY;
          }
        case 182: break;
        case 61: 
          { return KTRY;
          }
        case 183: break;
        case 98: 
          { return PPELSEIF;
          }
        case 184: break;
        case 71: 
          { return( KCASE );
          }
        case 185: break;
        case 12: 
          { return PLCURLY;
          }
        case 186: break;
        case 79: 
          { return( KCLASS );
          }
        case 187: break;
        case 97: 
          { return KMACRO;
          }
        case 188: break;
        case 22: 
          { return OASSIGN;
          }
        case 189: break;
        case 45: 
          { return OGREATER_OR_EQUAL;
          }
        case 190: break;
        case 5: 
          { return OMUL;
          }
        case 191: break;
        case 51: 
          { return OCOND_AND;
          }
        case 192: break;
        case 47: 
          { return ONOT_EQ;
          }
        case 193: break;
        case 105: 
          { return KFAKEENUM;
          }
        case 194: break;
        case 74: 
          { return KWHILE ;
          }
        case 195: break;
        case 50: 
          { return OBIT_AND_ASSIGN;
          }
        case 196: break;
        case 7: 
          { return OPLUS;
          }
        case 197: break;
        case 68: 
          { return KELSE ;
          }
        case 198: break;
        case 6: 
          { return LITINT;
          }
        case 199: break;
        case 56: 
          { return DOC_COMMENT;
          }
        case 200: break;
        case 100: 
          { return KCONTINUE ;
          }
        case 201: break;
        case 92: 
          { return KUNTYPED;
          }
        case 202: break;
        case 75: 
          { return( KBREAK );
          }
        case 203: break;
        case 18: 
          { return OSEMI;
          }
        case 204: break;
        case 30: 
          { return OREMAINDER;
          }
        case 205: break;
        case 34: 
          { return OMUL_ASSIGN;
          }
        case 206: break;
        case 39: 
          { return OIN;
          }
        case 207: break;
        case 93: 
          { return KTYPEDEF;
          }
        case 208: break;
        case 88: 
          { return PPERROR;
          }
        case 209: break;
        case 54: 
          { return OBIT_XOR_ASSIGN;
          }
        case 210: break;
        case 58: 
          { return OTRIPLE_DOT;
          }
        case 211: break;
        case 65: 
          { return PPIF;
          }
        case 212: break;
        default:
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
            return null;
          }
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
