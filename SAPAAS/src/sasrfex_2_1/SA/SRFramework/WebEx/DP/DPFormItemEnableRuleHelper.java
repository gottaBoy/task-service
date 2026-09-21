/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DP;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.ValueRule.SyntaxEngine;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.SRFExControl;
import java.util.ArrayList;

public class DPFormItemEnableRuleHelper {
    private String strLastError = "";

    public String GetEnableCondCode(SRFExForm form, String strSAVR) {
        SyntaxEngine syntaxEngine = new SyntaxEngine();
        ArrayList list = syntaxEngine.Parse(strSAVR);
        if (list == null) {
            form.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u5206\u6790[%1$s]\u51fa\u73b0\u9519\u8bef\uff1a%2$s", (Object)strSAVR, (Object)syntaxEngine.getLastError()));
            return "";
        }
        StringBuilderEx code = new StringBuilderEx();
        if (this.GetCondCode(false, form, list, 0, code, false) == -1) {
            form.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6[%1$s]\u51fa\u73b0\u9519\u8bef\uff1a%2$s", (Object)strSAVR, (Object)this.strLastError));
            return "";
        }
        return code.toString();
    }

    public String GetProcessCondCode(SRFExForm form, String strSAVR) {
        SyntaxEngine syntaxEngine = new SyntaxEngine();
        ArrayList list = syntaxEngine.Parse(strSAVR);
        if (list == null) {
            form.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u5206\u6790[%1$s]\u51fa\u73b0\u9519\u8bef\uff1a%2$s", (Object)strSAVR, (Object)syntaxEngine.getLastError()));
            return "";
        }
        StringBuilderEx code = new StringBuilderEx();
        if (this.GetCondCode(false, form, list, 0, code, true) == -1) {
            form.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6[%1$s]\u51fa\u73b0\u9519\u8bef\uff1a%2$s", (Object)strSAVR, (Object)this.strLastError));
            return "";
        }
        return code.toString();
    }

    /*
     * Enabled aggressive block sorting
     */
    private int GetCondCode(boolean bParentAsFunc, SRFExForm form, ArrayList list, int nStartPos, StringBuilderEx code, boolean bProcess) {
        if (list == null || list.size() == 0) {
            return -1;
        }
        int nRet = 0;
        boolean bLastIsOperator = false;
        int nPos = 0;
        while (nPos < list.size()) {
            block17: {
                Object objParam;
                block18: {
                    objParam = list.get(nPos);
                    if (!(objParam instanceof String)) break block18;
                    String strKey = (String)objParam;
                    if (this.IsFunction(strKey)) {
                        nRet = this.GetFunctionCode(strKey, form, list, nPos + 1, code, bProcess);
                        if (nRet == -1) {
                            return -1;
                        }
                        nPos = nRet;
                        bLastIsOperator = false;
                        continue;
                    }
                    if (this.IsOperator(strKey)) {
                        if (bParentAsFunc) {
                            this.strLastError = "\u51fd\u6570\u4e2d\u4e0d\u80fd\u5305\u542b\u64cd\u4f5c\u7b26\u53f7";
                            return -1;
                        }
                        if (bLastIsOperator) {
                            this.strLastError = "\u4e0d\u80fd\u8fde\u7eed\u51fa\u73b0\u64cd\u4f5c\u7b26\u53f7";
                            return -1;
                        }
                        nRet = this.GetOperatorCode(strKey, form, list, nPos + 1, code);
                        if (nRet == -1) {
                            return -1;
                        }
                        nPos = nRet;
                        bLastIsOperator = true;
                        continue;
                    }
                    if (nPos != 0 && !bLastIsOperator) {
                        if (!bParentAsFunc) {
                            this.strLastError = "\u4e0d\u80fd\u51fa\u73b0\u8054\u7cfb\u4e24\u4e2a\u64cd\u4f5c\u6570";
                            return -1;
                        }
                        code.Append(",");
                    }
                    if (strKey.indexOf(91) == 0) {
                        String strFormItem = strKey.substring(1, strKey.length() - 1);
                        if (bProcess) {
                            code.Append("de.get('%1$s')", strFormItem);
                            break block17;
                        } else {
                            SRFExControl control = form.FindControl(strFormItem);
                            if (control == null) {
                                this.strLastError = StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u6307\u5b9a\u8868\u5355\u9879[%1$s]", (Object)strFormItem);
                                return -1;
                            }
                            code.Append("%1$s.G('%2$s')", form.getFormId(), control.getUniqueID());
                        }
                        break block17;
                    } else {
                        code.Append("%1$s", strKey);
                    }
                    break block17;
                }
                if (objParam instanceof ArrayList) {
                    code.Append("(");
                    nRet = this.GetCondCode(false, form, (ArrayList)objParam, 0, code, bProcess);
                    if (nRet == -1) {
                        return nRet;
                    }
                    code.Append(")");
                }
            }
            ++nPos;
        }
        return list.size();
    }

    private boolean IsOperator(String strKey) {
        if (StringHelper.Compare((String)strKey, (String)"=", (boolean)true) == 0) {
            return true;
        }
        if (StringHelper.Compare((String)strKey, (String)"<>", (boolean)true) == 0) {
            return true;
        }
        if (StringHelper.Compare((String)strKey, (String)">", (boolean)true) == 0) {
            return true;
        }
        if (StringHelper.Compare((String)strKey, (String)">=", (boolean)true) == 0) {
            return true;
        }
        if (StringHelper.Compare((String)strKey, (String)"<", (boolean)true) == 0) {
            return true;
        }
        if (StringHelper.Compare((String)strKey, (String)"<=", (boolean)true) == 0) {
            return true;
        }
        if (StringHelper.Compare((String)strKey, (String)"AND", (boolean)true) == 0) {
            return true;
        }
        return StringHelper.Compare((String)strKey, (String)"OR", (boolean)true) == 0;
    }

    private int GetOperatorCode(String strKey, SRFExForm form, ArrayList list, int nStartPos, StringBuilderEx code) {
        if (StringHelper.Compare((String)strKey, (String)"=", (boolean)true) == 0) {
            code.Append("==");
            return nStartPos;
        }
        if (StringHelper.Compare((String)strKey, (String)"<>", (boolean)true) == 0) {
            code.Append(" != ");
            return nStartPos;
        }
        if (StringHelper.Compare((String)strKey, (String)">", (boolean)true) == 0) {
            code.Append(" > ");
            return nStartPos;
        }
        if (StringHelper.Compare((String)strKey, (String)">=", (boolean)true) == 0) {
            code.Append(" >= ");
            return nStartPos;
        }
        if (StringHelper.Compare((String)strKey, (String)"<", (boolean)true) == 0) {
            code.Append(" < ");
            return nStartPos;
        }
        if (StringHelper.Compare((String)strKey, (String)"<=", (boolean)true) == 0) {
            code.Append(" <= ");
            return nStartPos;
        }
        if (StringHelper.Compare((String)strKey, (String)"AND", (boolean)true) == 0) {
            code.Append(" && ");
            return nStartPos;
        }
        if (StringHelper.Compare((String)strKey, (String)"OR", (boolean)true) == 0) {
            code.Append(" || ");
            return nStartPos;
        }
        return -1;
    }

    private boolean IsFunction(String strKey) {
        return StringHelper.Compare((String)strKey, (String)"NOT", (boolean)true) == 0;
    }

    private int GetFunctionCode(String strKey, SRFExForm form, ArrayList list, int nStartPos, StringBuilderEx code, boolean bProcess) {
        int nRet = nStartPos;
        if (StringHelper.Compare((String)strKey, (String)"NOT", (boolean)true) == 0) {
            if (nStartPos >= list.size()) {
                this.strLastError = "NOT \u9700\u8981\u64cd\u4f5c\u6570";
                return -1;
            }
            code.Append("!");
            Object objParam = list.get(nStartPos);
            if (objParam instanceof String) {
                if (this.IsFunction((String)objParam)) {
                    nRet = this.GetFunctionCode((String)objParam, form, list, nStartPos + 1, code, bProcess);
                    if (nRet == -1) {
                        return nRet;
                    }
                    return nRet;
                }
            } else {
                if (objParam instanceof ArrayList) {
                    code.Append("(");
                    nRet = this.GetCondCode(true, form, (ArrayList)objParam, 0, code, bProcess);
                    if (nRet == -1) {
                        return nRet;
                    }
                    code.Append(")");
                    return nStartPos + 1;
                }
                return -1;
            }
        }
        return -1;
    }
}

