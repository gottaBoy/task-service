/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.PPMWebPart
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Data.PPMWebPart;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PPModelPage
extends SRFDAPage {
    private static final Log log = LogFactory.getLog(PPModelPage.class);
    protected String strPPModelId = "";

    public PPModelPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPPModelId = this.getWebContext().GetParamValue("PPMODELID");
        if (StringHelper.IsNullOrEmpty((String)this.strPPModelId)) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u95e8\u6237\u9875\u9762\u540d\u79f0"));
            return false;
        }
        return true;
    }

    protected void OnLoadBackEnd() {
        if (StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
            String strPPModel = this.getWebContext().GetPostValue("ppmodel");
            IDEDataCtrl iDEDataCtrl = this.getDAModelStorage().FindDEDataCtrl("DE0026", (ISRFDAWebContext)this.getWebContext());
            if (iDEDataCtrl == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0026"));
                return;
            }
            BaseDataEntity baseDataEntity = new BaseDataEntity();
            baseDataEntity.SetParamValue("PPMODELID", (Object)this.strPPModelId);
            CallResult callResult = iDEDataCtrl.CustomCall("RESETBYPPMODELID", baseDataEntity);
            if (callResult.getRetCode() != 0) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u91cd\u7f6e\u95e8\u6237\u6570\u636e\u6a21\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return;
            }
            String[] models = strPPModel.split("[;]");
            int i = 0;
            while (i < models.length) {
                String[] webparts;
                String strModel = models[i];
                if (!StringHelper.IsNullOrEmpty((String)strModel) && (webparts = strModel.split("[|]")).length == 3) {
                    PPMWebPart ppmWebPart = new PPMWebPart();
                    ppmWebPart.setPPMODELID(this.strPPModelId);
                    ppmWebPart.setWEBPARTID(webparts[2]);
                    ppmWebPart.setCOLUMNID(DataTypeParse.TestInteger((String)webparts[0]));
                    ppmWebPart.setROWID2(DataTypeParse.TestInteger((String)webparts[1]));
                    callResult = iDEDataCtrl.Save(true, (BaseDataEntity)ppmWebPart);
                    if (callResult.getRetCode() != 0) {
                        this.PageLog((Object)this, 1, StringHelper.Format((String)"\u63d2\u5165\u95e8\u6237\u6570\u636e\u6a21\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                }
                ++i;
            }
            return;
        }
        if (StringHelper.Compare((String)this.getWebContext().getSRFPageModel(), (String)"SL", (boolean)true) == 0) {
            String strAction = this.getWebContext().GetParamValue("ACTION");
            IDEDataCtrl iDEDataCtrl = this.getDAModelStorage().FindDEDataCtrl("DE0025", (ISRFDAWebContext)this.getWebContext());
            if (iDEDataCtrl == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0025"));
                return;
            }
            BaseDataEntity baseDataEntity = new BaseDataEntity();
            baseDataEntity.SetParamValue("PPMODELID", (Object)this.strPPModelId);
            if (StringHelper.Compare((String)strAction, (String)"RESET", (boolean)true) == 0) {
                CallResult callResult = iDEDataCtrl.Remove(baseDataEntity);
                if (callResult.getRetCode() != 0) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u91cd\u7f6e\u9875\u9762\u6a21\u578b\u51fa\u73b0\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return;
                }
                return;
            }
            String strPPModelDetail = this.getWebContext().GetPostValue("ppmodeldetail");
            baseDataEntity.SetParamValue("PPMODELDETAIL", (Object)strPPModelDetail);
            CallResult callResult = iDEDataCtrl.Save(false, baseDataEntity);
            if (callResult.getRetCode() != 0) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u4fdd\u5b58\u9875\u9762\u6a21\u578b\u51fa\u73b0\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return;
            }
            return;
        }
    }
}

