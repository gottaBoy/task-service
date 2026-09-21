/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.ValueRule;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.ValueRule.ValueRuleConfig;
import java.util.ArrayList;

public class ValueRuleConvertor {
    private String strLastError = "";

    public ValueRuleConfig Parse(String strSAVR) {
        ArrayList childs = new ArrayList();
        int nRet = this.InternalParse(strSAVR, 0, childs);
        if (nRet == -1) {
            return null;
        }
        if (nRet != strSAVR.length()) {
            return null;
        }
        return null;
    }

    private int InternalParse(String strSAVR, int nStartPos, ArrayList childs) {
        if (StringHelper.IsNullOrEmpty((String)strSAVR)) {
            this.strLastError = "\u65e0\u6cd5\u89e3\u6790\u7a7a\u89c4\u5219\u4e32";
            return -1;
        }
        int nPos = nStartPos;
        int nLastPos = nStartPos;
        String strLastPart = "";
        while (true) {
            char ch = strSAVR.charAt(nPos);
            switch (ch) {
                case '(': {
                    ArrayList subchilds;
                    int nRet;
                    if (!StringHelper.IsNullOrEmpty((String)strLastPart)) {
                        childs.add(strLastPart);
                        strLastPart = "";
                    }
                    if ((nRet = this.InternalParse(strSAVR, nPos + 1, subchilds = new ArrayList())) == -1) {
                        return -1;
                    }
                    childs.add(subchilds);
                    nLastPos = nPos;
                    nPos = nRet;
                    while ((ch = strSAVR.charAt(nPos)) == ' ') {
                        if (nPos >= strSAVR.length()) {
                            this.strLastError = StringHelper.Format((String)"\u65e0\u6cd5\u5b9a\u4f4d\u4f4d\u7f6e[%1$s]'('\u5bf9\u5e94\u7684')'", (Object)nLastPos);
                            return -1;
                        }
                        ++nPos;
                    }
                    if (ch == ')') break;
                    this.strLastError = StringHelper.Format((String)"\u65e0\u6cd5\u5b9a\u4f4d\u4f4d\u7f6e[%1$s]'('\u5bf9\u5e94\u7684')',\u51fa\u73b0\u4e86'%2$s'", (Object)nLastPos, (Object)Character.valueOf(ch));
                    return -1;
                }
                case ')': {
                    return nPos;
                }
                case '\'': {
                    String strString = "'";
                    if (!StringHelper.IsNullOrEmpty((String)strLastPart)) {
                        this.strLastError = StringHelper.Format((String)"\u4f4d\u7f6e[%1$s]\u51fa\u73b0\u4e86'''\uff0c\u65e0\u6cd5\u8bc6\u522b'%2$s'", (Object)nLastPos, (Object)strLastPart);
                        return -1;
                    }
                    nLastPos = nPos++;
                    while (true) {
                        if ((ch = strSAVR.charAt(nPos)) != '\'') {
                            strString = String.valueOf(strString) + ch;
                        } else if (nPos + 1 < strSAVR.length()) {
                            if (strSAVR.charAt(nPos + 1) == '\'') {
                                strString = String.valueOf(strString) + "'";
                                ++nPos;
                            } else {
                                strString = String.valueOf(strString) + "'";
                                childs.add(strString);
                                break;
                            }
                        }
                        if (nPos >= strSAVR.length()) break;
                        ++nPos;
                    }
                    if (StringHelper.IsNullOrEmpty((String)strString)) break;
                    this.strLastError = StringHelper.Format((String)"\u4f4d\u7f6e[%1$s]\u7684\u5b57\u7b26\u4e32\u6ca1\u6709\u5c01\u95ed", (Object)nLastPos);
                    return -1;
                }
                case ' ': {
                    if (StringHelper.IsNullOrEmpty((String)strLastPart)) break;
                    childs.add(strLastPart);
                    strLastPart = "";
                    break;
                }
                case ',': {
                    if (StringHelper.IsNullOrEmpty((String)strLastPart)) break;
                    childs.add(strLastPart);
                    strLastPart = "";
                    break;
                }
                default: {
                    strLastPart = String.valueOf(strLastPart) + ch;
                }
            }
            if (nPos >= strSAVR.length()) break;
            ++nPos;
        }
        return nPos + 1;
    }
}

