/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ToolTipsPage
extends SRFDAPage {
    private static final Log log = LogFactory.getLog(ToolTipsPage.class);

    public ToolTipsPage() {
        this.setResourceId("");
    }

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        return this.LoadPageDataEntity();
    }

    protected void OnLoadBackEnd() {
        String strKeyName = this.getDEHelper().GetKeyDEFHelper().getName();
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue(strKeyName, (Object)this.getWebContext().GetParamValue(strKeyName));
        CallResult callResult = this.GetDEDataCtrl().Get(dataEntity);
        if (callResult.IsError()) {
            this.PageLog((Object)this, "\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef", callResult);
            this.Output(StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        this.Output(this.getDEHelper().GetToolTip(dataEntity, (ISRFDAWebContext)this.getWebContext(), this.getWebContext().getCurUserId()));
    }
}

