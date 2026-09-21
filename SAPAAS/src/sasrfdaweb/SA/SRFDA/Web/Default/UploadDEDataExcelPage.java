/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEDataImport
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Data.DEDataImport;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;

public class UploadDEDataExcelPage
extends BaseMainPage {
    protected String strUpdateDataActionPath = "../srfpage/uploaddedataexcel.jsp";

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        if (StringHelper.IsNullOrEmpty((String)this.strPageDataEntityId)) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u7f16\u53f7"));
            return false;
        }
        if (!this.LoadPageDataEntity()) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u52a0\u8f7d\u9875\u9762\u5b9e\u4f53[%1$s]\u5931\u8d25", (Object)this.strPageDataEntityId));
            return false;
        }
        String strDEDataImport = this.getWebContext().GetParamValue("SRFDEDATAIMPORT");
        if (!StringHelper.IsNullOrEmpty((String)strDEDataImport)) {
            DEDataImport deDataImport = this.getDEHelper().GetDataImport(strDEDataImport);
            if (deDataImport != null) {
                if (!StringHelper.IsNullOrEmpty((String)deDataImport.getIMPORTACTION())) {
                    this.strUpdateDataActionPath = deDataImport.getIMPORTACTION();
                }
            } else {
                this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u5bfc\u5165\u6a21\u5f0f[%2$s]", (Object)this.getDEHelper().getId(), (Object)strDEDataImport));
            }
        }
        this.strUpdateDataActionPath = URLHelper.AppendURLSeperator((String)this.strUpdateDataActionPath);
        this.strUpdateDataActionPath = String.valueOf(this.strUpdateDataActionPath) + this.getWebContext().GetQueryString();
        return true;
    }

    public String OutputDELogicName() {
        return this.getDEHelper().getLogicName(this.getLanguage());
    }

    public String OutputDataActionPath() {
        return this.strUpdateDataActionPath;
    }
}

