/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CommonEx.Errors
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSModelInitDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelDEDataCtrl;
import SA.SRFDA.PS.Data.PSDELogic;
import SA.SRFDA.PS.Data.PSDELogicParam;
import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDELogicParamDataCtrl
extends PSModelDEDataCtrl
implements IPSModelInitDataCtrl {
    private static final Log log = LogFactory.getLog(PSDELogicParamDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    public CallResult initModel(String strDEId, BaseDataEntity dataEntity, String strMode) {
        CallResult callResult = new CallResult();
        try {
            if (StringHelper.Compare((String)strDEId, (String)"DE2083", (boolean)true) == 0) {
                PSDELogic psDELogic = new PSDELogic();
                psDELogic.proxy(dataEntity);
                PSDELogicParam psDELogicParam = new PSDELogicParam();
                psDELogicParam.setPSDELOGICPARAMID(psDELogic.getPSDELOGICID());
                callResult = this.Get(psDELogicParam);
                if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
                    psDELogicParam.Reset();
                    psDELogicParam.setDEFAULTPARAM(true);
                    psDELogicParam.setPSDELOGICPARAMID(psDELogic.getPSDELOGICID());
                    psDELogicParam.setPSDELOGICPARAMNAME("Default");
                    psDELogicParam.setPSDELOGICID(psDELogic.getPSDELOGICID());
                    psDELogicParam.setPARAMPSDEID(psDELogic.getPSDEID());
                    psDELogicParam.setPARAMPSDENAME(psDELogic.getPSDENAME());
                    psDELogicParam.setLOGICNAME("\u4f20\u5165\u53d8\u91cf");
                    callResult = this.Save(true, psDELogicParam);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4f53\u903b\u8f91\u9ed8\u8ba4\u53d8\u91cf\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
                    }
                }
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }
}

