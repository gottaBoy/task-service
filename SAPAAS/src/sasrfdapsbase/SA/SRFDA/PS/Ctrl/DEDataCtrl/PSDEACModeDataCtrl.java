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
import SA.SRFDA.PS.Data.PSDEACMode;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEACModeDataCtrl
extends PSModelDEDataCtrl
implements IPSModelInitDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEACModeDataCtrl.class);

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
            if (StringHelper.Compare((String)strDEId, (String)"DE2050", (boolean)true) == 0) {
                PSDataEntity psDataEntity = new PSDataEntity();
                psDataEntity.proxy(dataEntity);
                PSDEACMode psDEACMode = new PSDEACMode();
                psDEACMode.setPSDEACMODEID(psDataEntity.getPSDATAENTITYID());
                callResult = this.Get(psDEACMode);
                if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
                    psDEACMode.Reset();
                    psDEACMode.setPSDEID(psDataEntity.getPSDATAENTITYID());
                    psDEACMode.setDEFAULTMODE(true);
                    boolean bDefault = true;
                    callResult = this.Select(psDEACMode);
                    if (!callResult.isError()) {
                        bDefault = false;
                    }
                    psDEACMode.Reset();
                    psDEACMode.setPSDEACMODEID(psDataEntity.getPSDATAENTITYID());
                    psDEACMode.setPSDEID(psDataEntity.getPSDATAENTITYID());
                    psDEACMode.setDEFAULTMODE(bDefault);
                    psDEACMode.setPSDEACMODENAME("DEFAULT");
                    psDEACMode.setCODENAME("Default");
                    callResult = this.Save(true, psDEACMode);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4f53\u9ed8\u8ba4\u81ea\u586b\u6a21\u5f0f\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
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

