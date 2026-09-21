/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Utility;

import SA.SRFramework.Utility.StringHelper;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSHelper {
    public static final String ENCODE_BASE64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_$";
    public boolean isDebug = false;

    public static String Optimize(String strScript) {
        return strScript.replace("\r\n", "");
    }

    public static String OptimizeEx(String strScript) {
        try {
            JSHelper jsh = new JSHelper();
            strScript = jsh.encode(strScript, 0);
            return strScript;
        }
        catch (Exception ex) {
            return strScript;
        }
    }

    public String encode(String jscript, int offset) throws Exception {
        Date beginDate = new Date();
        int size = jscript.length();
        jscript = jscript.replaceAll("\\\\", "\\\\\\\\");
        jscript = jscript.replaceAll("\\'", "\\\\\\'");
        Pattern p = Pattern.compile("([\\w\\$]+)");
        Matcher m = p.matcher(jscript);
        StringBuffer encscript = new StringBuffer();
        StringBuffer dicttab = new StringBuffer();
        Vector<String> dict = new Vector<String>();
        this.debugInfo("=====\u7f16\u7801\u5b57\u5178\u5bf9\u5e94\u8868=====");
        while (m.find()) {
            int index;
            String element = m.group(1).trim();
            if (!dict.contains(element)) {
                dict.add(element);
                index = dict.size() - 1;
            } else {
                index = dict.indexOf(element);
            }
            this.debugInfo(String.valueOf(index) + "==>" + element);
            m.appendReplacement(encscript, this.Base64Encode(offset + index + 1));
        }
        for (String o : dict) {
            dicttab.append(String.valueOf(o) + "|");
        }
        m.appendTail(encscript);
        String dictstr = dicttab.substring(0, dicttab.length() - 1).toString();
        this.debugInfo("\u5b57\u5178\u5b57\u7b26\u4e32:\n" + dictstr);
        String res = this.formatCode(encscript.toString(), dictstr, dict.size(), offset);
        int packsize = res.length();
        DecimalFormat df = new DecimalFormat("######.0");
        System.out.print("\r\n\u539f\u59cb\u5927\u5c0f\uff1a" + size + "\u538b\u7f29\u540e\u5927\u5c0f\uff1a" + packsize);
        System.out.print("\u538b\u7f29\u6bd4\u7387\uff1a" + df.format((double)(size - packsize) * 100.0 / (double)size) + "% \u8017\u65f6:" + StringHelper.Format((String)"%1$s", (Object)(new Date().getTime() - beginDate.getTime())) + "ms\r\n");
        return res;
    }

    private void debugInfo(String txt) {
        if (this.isDebug) {
            System.out.println(txt);
        }
    }

    private String Base64Encode(int c) throws Exception {
        if (c < 0) {
            throw new Exception("Error:Offset\u5fc5\u987b>=0.");
        }
        String res = c > 63 ? String.valueOf(this.Base64Encode(c >> 6)) + this.Base64Encode(c & 0x3F) : (c == 63 ? "\\$" : String.valueOf(ENCODE_BASE64.charAt(c)));
        return res;
    }

    private String formatCode(String enc, String dict, int size, int offset) {
        StringBuffer str = new StringBuffer();
        str.append("eval(function(E,I,A,D,J,K,L,H){function C(A){return A<62?String.fromCharCode(A+=A<26?65:A<52?71:-4):A<63?'_':A<64?'$':C(A>>6)+C(A&63)}while(A>0)K[C(D--)]=I[--A];function N(A){return K[A]==L[A]?A:K[A]}if(''.replace(/^/,String)){var M=E.match(J),B=M[0],F=E.split(J),G=0;if(E.indexOf(F[0]))F=[''].concat(F);do{H[A++]=F[G++];H[A++]=N(B)}while(B=M[G]);H[A++]=F[G]||'';return H.join('')}return E.replace(J,N)}(");
        str.append("'" + enc + "',");
        str.append("'" + dict + "'.split('|'),");
        str.append(String.valueOf(size) + "," + (size + offset) + ",/[\\w\\$]+/g,{},{},[]))");
        return str.toString();
    }
}

