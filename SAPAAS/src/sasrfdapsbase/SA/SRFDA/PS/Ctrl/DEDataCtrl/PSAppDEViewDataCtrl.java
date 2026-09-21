/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSAppDEView;
import SA.SRFDA.PS.Data.PSAppModule;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDEViewDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSAppDEViewDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        try {
            if (bInsert) {
                PSAppDEView psAppDEView = new PSAppDEView();
                psAppDEView.proxy(dataEntity);
                if (StringHelper.IsNullOrEmpty((String)psAppDEView.getPSAPPDEVIEWNAME())) {
                    PSDEViewBase psDEViewBase = new PSDEViewBase();
                    psDEViewBase.setPSDEVIEWBASEID(psAppDEView.getPSDEVIEWBASEID());
                    IDEDataCtrl psDEViewBaseDataCtrl = this.GetRelatedDataCtrl("DE2300");
                    callResult = psDEViewBaseDataCtrl.Get((BaseDataEntity)psDEViewBase);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    IPSDataEntity iPSDataEntity = this.getPSModelStorage().getPSDataEntity(psDEViewBase.getPSDEID());
                    psAppDEView.setPSAPPDEVIEWNAME(StringHelper.Format((String)"%1$s%2$s", (Object)iPSDataEntity.getCodeName(), (Object)psDEViewBase.getCODENAME()));
                }
            }
        }
        catch (Exception e) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
            return callResult;
        }
        return callResult;
    }

    public CallResult GetDefault(ISRFDAWebContext webContext, BaseDataEntity dataEntity) {
        CallResult callResult = super.GetDefault(webContext, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        String strPSAppModuleId = webContext.GetParamValue("PSAPPMODULEID");
        if (!StringHelper.IsNullOrEmpty((String)strPSAppModuleId)) {
            try {
                PSAppModule psAppModule = new PSAppModule();
                psAppModule.setPSAPPMODULEID(strPSAppModuleId);
                IDEDataCtrl psAppModuleDataCtrl = this.GetRelatedDataCtrl("DE2501");
                callResult = psAppModuleDataCtrl.Get((BaseDataEntity)psAppModule);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u4e91\u5e94\u7528\u6a21\u5757\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                dataEntity.setParamValue("PSSYSAPPID", (Object)psAppModule.getPSSYSAPPID());
                dataEntity.setParamValue("PSSYSAPPNAME", (Object)psAppModule.getPSSYSAPPNAME());
            }
            catch (Exception e) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(e.getMessage());
                return callResult;
            }
        }
        return callResult;
    }
}

