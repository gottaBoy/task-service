/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.ErrorCode
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Data.ErrorCode;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class ErrorViewPage
extends SRFDAPageEx {
    protected String strErrorInfo = "";

    public ErrorViewPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
        this.setResourceId("");
    }

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        String strErrorCodeId = "";
        strErrorCodeId = SRFDAWebCTXHelper.GetErrorCodeId((ISRFDAWebContext)this.getWebContext());
        if (!StringHelper.IsNullOrEmpty((String)strErrorCodeId)) {
            IDEDataCtrl iDataCtrl = this.GetDEDataCtrl("DE0105");
            if (iDataCtrl == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0105"));
                return false;
            }
            ErrorCode errorCode = new ErrorCode();
            errorCode.setERRORCODEID(strErrorCodeId);
            CallResult callResult = iDataCtrl.Get((BaseDataEntity)errorCode);
            if (callResult.IsError()) {
                this.strErrorInfo = StringHelper.Format((String)"\u83b7\u53d6\u9519\u8bef\u4ee3\u7801[%1$s]\u5931\u8d25\uff0c%2$s", (Object)callResult.getErrorInfo());
                this.PageLog((Object)this, 1, this.strErrorInfo);
                return false;
            }
            this.strErrorInfo = errorCode.getDESCRIPTION();
        } else {
            this.strErrorInfo = SRFDAWebCTXHelper.GetErrorInfo((ISRFDAWebContext)this.getWebContext());
            if (StringHelper.IsNullOrEmpty((String)this.strErrorInfo)) {
                this.strErrorInfo = "\u6ca1\u6709\u6307\u5b9a\u9519\u8bef\u4ee3\u7801\u7f16\u53f7\u6216\u9519\u8bef\u4fe1\u606f";
            }
        }
        return true;
    }

    public String GetErrorInfo() {
        return this.strErrorInfo;
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        jsonObject.put("errorinfo", (Object)this.GetErrorInfo());
        return true;
    }
}

