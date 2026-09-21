/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DP;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExPage;

public class DPEventCodeParser {
    public static final String TAG_FORM = "$FORM";
    public static final String TAG_FORMITEM = "$FORMITEM";
    public static final String TAG_GETFIVALUE = "$GETFIVALUE";
    public static final String TAG_SETFIVALUE = "$SETFIVALUE";

    public static String Parse(String strCode, SRFExPage page) {
        strCode = DPEventCodeParser.ParseFormItem(strCode, page);
        strCode = DPEventCodeParser.ParseForm(strCode, page);
        strCode = DPEventCodeParser.ParseGetFIValue(strCode, page);
        strCode = DPEventCodeParser.ParseSetFIValue(strCode, page);
        return strCode;
    }

    private static String ParseGetFIValue(String strCode, SRFExPage page) {
        String strRet = "";
        int nPos = strCode.indexOf(TAG_GETFIVALUE);
        while (nPos != -1) {
            if (nPos != 0) {
                strRet = String.valueOf(strRet) + strCode.substring(0, nPos);
            }
            if ((nPos += TAG_GETFIVALUE.length()) >= strCode.length()) {
                page.PageLog((Object)"DPEventCodeParser", 1, StringHelper.Format((String)"\u8bed\u6cd5\u6709\u9519\u8bef\uff0c%1$s\u6ca1\u6709\u6307\u5b9a\u53c2\u6570", (Object)TAG_GETFIVALUE));
                return "";
            }
            char ch = strCode.charAt(nPos);
            if (ch != '(') {
                page.PageLog((Object)"DPEventCodeParser", 1, StringHelper.Format((String)"\u8bed\u6cd5\u6709\u9519\u8bef\uff0c%1$s\u540e\u9762\u6ca1\u6709(", (Object)TAG_GETFIVALUE));
                return "";
            }
            int nEndPos = strCode.indexOf(41, nPos);
            if (nEndPos == -1) {
                page.PageLog((Object)"DPEventCodeParser", 1, StringHelper.Format((String)"\u8bed\u6cd5\u6709\u9519\u8bef\uff0c%1$s\u540e\u9762\u6ca1\u6709)", (Object)TAG_GETFIVALUE));
                return "";
            }
            String strParam = strCode.substring(nPos + 1, nEndPos);
            SRFExControl control = page.getDefaultForm().FindControl(strParam);
            if (control == null) {
                page.PageLog((Object)"DPEventCodeParser", 1, StringHelper.Format((String)"\u6ca1\u6709\u627e\u5230\u6307\u5b9a[%1$s]\u7684\u8868\u5355\u9879)", (Object)strParam));
                return "";
            }
            strRet = String.valueOf(strRet) + StringHelper.Format((String)"%1$s.G('%2$s')", (Object)page.getDefaultFormId(), (Object)control.getUniqueID());
            if (nEndPos + 1 >= strCode.length()) {
                return strRet;
            }
            strCode = strCode.substring(nEndPos + 1);
            nPos = strCode.indexOf(TAG_GETFIVALUE);
        }
        if (!StringHelper.IsNullOrEmpty((String)strCode)) {
            strRet = String.valueOf(strRet) + strCode;
        }
        return strRet;
    }

    private static String ParseSetFIValue(String strCode, SRFExPage page) {
        String strRet = "";
        int nPos = strCode.indexOf(TAG_SETFIVALUE);
        while (nPos != -1) {
            if (nPos != 0) {
                strRet = String.valueOf(strRet) + strCode.substring(0, nPos);
            }
            if ((nPos += TAG_SETFIVALUE.length()) >= strCode.length()) {
                page.PageLog((Object)"DPEventCodeParser", 1, StringHelper.Format((String)"\u8bed\u6cd5\u6709\u9519\u8bef\uff0c%1$s\u6ca1\u6709\u6307\u5b9a\u53c2\u6570", (Object)TAG_SETFIVALUE));
                return "";
            }
            char ch = strCode.charAt(nPos);
            if (ch != '(') {
                page.PageLog((Object)"DPEventCodeParser", 1, StringHelper.Format((String)"\u8bed\u6cd5\u6709\u9519\u8bef\uff0c%1$s\u540e\u9762\u6ca1\u6709(", (Object)TAG_SETFIVALUE));
                return "";
            }
            int nEndPos = strCode.indexOf(41, nPos);
            if (nEndPos == -1) {
                page.PageLog((Object)"DPEventCodeParser", 1, StringHelper.Format((String)"\u8bed\u6cd5\u6709\u9519\u8bef\uff0c%1$s\u540e\u9762\u6ca1\u6709)", (Object)TAG_SETFIVALUE));
                return "";
            }
            String strParam = strCode.substring(nPos + 1, nEndPos);
            int nPos2 = strParam.indexOf(44);
            if (nPos2 == -1) {
                page.PageLog((Object)"DPEventCodeParser", 1, StringHelper.Format((String)"\u8bed\u6cd5\u6709\u9519\u8bef\uff0c%1$s\u6ca1\u6709\u6307\u5b9a\u503c\u8bed\u53e5)", (Object)TAG_SETFIVALUE));
                return "";
            }
            String strParamValue = strParam.substring(nPos2 + 1);
            strParam = strParam.substring(0, nPos2);
            SRFExControl control = page.getDefaultForm().FindControl(strParam);
            if (control == null) {
                page.PageLog((Object)"DPEventCodeParser", 1, StringHelper.Format((String)"\u6ca1\u6709\u627e\u5230\u6307\u5b9a[%1$s]\u7684\u8868\u5355\u9879)", (Object)strParam));
                return "";
            }
            strRet = String.valueOf(strRet) + StringHelper.Format((String)"%1$s.S('%2$s',%3$s)", (Object)page.getDefaultFormId(), (Object)control.getUniqueID(), (Object)strParamValue);
            if (nEndPos + 1 >= strCode.length()) {
                return strRet;
            }
            strCode = strCode.substring(nEndPos + 1);
            nPos = strCode.indexOf(TAG_SETFIVALUE);
        }
        if (!StringHelper.IsNullOrEmpty((String)strCode)) {
            strRet = String.valueOf(strRet) + strCode;
        }
        return strRet;
    }

    private static String ParseForm(String strCode, SRFExPage page) {
        String strRet = "";
        int nPos = strCode.indexOf(TAG_FORM);
        while (nPos != -1) {
            if (nPos != 0) {
                strRet = String.valueOf(strRet) + strCode.substring(0, nPos);
            }
            if ((nPos += TAG_FORM.length()) >= strCode.length()) {
                page.PageLog((Object)"DPEventCodeParser", 1, StringHelper.Format((String)"\u8bed\u6cd5\u6709\u9519\u8bef\uff0c%1$s\u6ca1\u6709\u6307\u5b9a\u53c2\u6570", (Object)TAG_FORM));
                return "";
            }
            strRet = String.valueOf(strRet) + StringHelper.Format((String)"%1$s", (Object)page.getDefaultFormId());
            if (nPos >= strCode.length()) {
                return strRet;
            }
            strCode = strCode.substring(nPos);
            nPos = strCode.indexOf(TAG_FORM);
        }
        if (!StringHelper.IsNullOrEmpty((String)strCode)) {
            strRet = String.valueOf(strRet) + strCode;
        }
        return strRet;
    }

    private static String ParseFormItem(String strCode, SRFExPage page) {
        String strRet = "";
        int nPos = strCode.indexOf(TAG_FORMITEM);
        while (nPos != -1) {
            if (nPos != 0) {
                strRet = String.valueOf(strRet) + strCode.substring(0, nPos);
            }
            if ((nPos += TAG_FORMITEM.length()) >= strCode.length()) {
                page.PageLog((Object)"DPEventCodeParser", 1, StringHelper.Format((String)"\u8bed\u6cd5\u6709\u9519\u8bef\uff0c%1$s\u6ca1\u6709\u6307\u5b9a\u53c2\u6570", (Object)TAG_FORMITEM));
                return "";
            }
            char ch = strCode.charAt(nPos);
            if (ch != '(') {
                page.PageLog((Object)"DPEventCodeParser", 1, StringHelper.Format((String)"\u8bed\u6cd5\u6709\u9519\u8bef\uff0c%1$s\u540e\u9762\u6ca1\u6709(", (Object)TAG_FORMITEM));
                return "";
            }
            int nEndPos = strCode.indexOf(41, nPos);
            if (nEndPos == -1) {
                page.PageLog((Object)"DPEventCodeParser", 1, StringHelper.Format((String)"\u8bed\u6cd5\u6709\u9519\u8bef\uff0c%1$s\u540e\u9762\u6ca1\u6709)", (Object)TAG_FORMITEM));
                return "";
            }
            String strParam = strCode.substring(nPos + 1, nEndPos);
            SRFExControl control = page.getDefaultForm().FindControl(strParam);
            if (control == null) {
                page.PageLog((Object)"DPEventCodeParser", 1, StringHelper.Format((String)"\u6ca1\u6709\u627e\u5230\u6307\u5b9a[%1$s]\u7684\u8868\u5355\u9879)", (Object)strParam));
                return "";
            }
            strRet = String.valueOf(strRet) + StringHelper.Format((String)"Ext.getDom('%1$s')", (Object)control.getUniqueID());
            if (nEndPos + 1 >= strCode.length()) {
                return strRet;
            }
            strCode = strCode.substring(nEndPos + 1);
            nPos = strCode.indexOf(TAG_FORMITEM);
        }
        if (!StringHelper.IsNullOrEmpty((String)strCode)) {
            strRet = String.valueOf(strRet) + strCode;
        }
        return strRet;
    }
}

