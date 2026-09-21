/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.DEDC.Web;

import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public class RuleProcessDesignerPage
extends SRFDAPage {
    public RuleProcessDesignerPage() {
        this.setJSCache(false);
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    public String GetCtrlID() {
        return this.getWebContext().GetParamValue("SRFCTRLID");
    }

    public String OutputFuncCodeListJSCode() {
        CodeListConfig codeListConfig = this.getWebContext().getCodeListMgr().GetCodeListConfig("CODELIST_02006", this.getLanguage());
        if (codeListConfig == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]", (Object)"CODELIST_02006"));
            return "";
        }
        StringBuilderEx sb = new StringBuilderEx();
        int nCount = codeListConfig.getCodeItems().size();
        int i = 0;
        while (i < nCount) {
            CodeItemConfig codeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(i);
            sb.Append("if(_1=='%1$s')return '%2$s';\r\n", (Object)codeItemConfig.getValue(), (Object)codeItemConfig.getText());
            ++i;
        }
        return sb.toString();
    }

    public String OutputItemLogicCodeListJSCode() {
        CodeListConfig codeListConfig = this.getWebContext().getCodeListMgr().GetCodeListConfig("CODELIST_02007", this.getLanguage());
        if (codeListConfig == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]", (Object)"CODELIST_02007"));
            return "";
        }
        StringBuilderEx sb = new StringBuilderEx();
        int nCount = codeListConfig.getCodeItems().size();
        int i = 0;
        while (i < nCount) {
            CodeItemConfig codeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(i);
            sb.Append("if(_1=='%1$s')return '%2$s';\r\n", (Object)codeItemConfig.getValue(), (Object)codeItemConfig.getText());
            ++i;
        }
        return sb.toString();
    }
}

