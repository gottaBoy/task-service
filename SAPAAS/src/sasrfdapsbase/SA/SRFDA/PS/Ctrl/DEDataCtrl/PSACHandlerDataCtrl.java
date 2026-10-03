/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.CommonEx.Errors
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSModelInitDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelDEDataCtrl;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.PS.Data.PSSFACHandler;
import SA.SRFDA.PS.Data.PSSystem;
import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSACHandlerDataCtrl
extends PSModelDEDataCtrl
implements IPSModelInitDataCtrl {
    private static final Log log = LogFactory.getLog(PSACHandlerDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        if (bInsert) {
            PSACHandler psACHandler = new PSACHandler();
            psACHandler.proxy(dataEntity);
        }
        return callResult;
    }

    @Override
    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    protected CallResult OnBeforeRemove(String strActionMode, BaseDataEntity dataEntity) {
        return super.OnBeforeRemove(strActionMode, dataEntity);
    }

    protected CallResult OnAfterRemoveOK(String strActionMode, BaseDataEntity dataEntity) {
        return super.OnAfterRemoveOK(strActionMode, dataEntity);
    }

    @Override
    public CallResult initModel(String strDEId, BaseDataEntity dataEntity, String strMode) {
        CallResult callResult = new CallResult();
        try {
            if (StringHelper.Compare((String)strDEId, (String)"DE2030", (boolean)true) == 0) {
                PSSystem psSystem = new PSSystem();
                psSystem.proxy(dataEntity);
                IDEDataCtrl pssfACHandlerDataCtrl = this.GetRelatedDataCtrl("DE1650");
                BaseDataEntity cond = new BaseDataEntity();
                cond.setParamValue("PSSFID", (Object)psSystem.getPSSFID());
                Vector<PSSFACHandler> psSFACHandlerList = new Vector<PSSFACHandler>();
                callResult = pssfACHandlerDataCtrl.Select(cond, psSFACHandlerList, PSSFACHandler.class.getName());
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u670d\u52a1\u90e8\u4ef6\u5904\u7406\u5668\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
                }
                for (PSSFACHandler psSFACHandler : psSFACHandlerList) {
                    String strPSSFACHandlerId = Helper.GenUniqueId((String)psSystem.getPSSYSTEMID(), (String)psSFACHandler.getPSSFACHANDLERID());
                    PSACHandler psACHandler = new PSACHandler();
                    psACHandler.setPSACHANDLERID(strPSSFACHandlerId);
                    callResult = this.Get(psACHandler);
                    if (!Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) continue;
                    psSFACHandler.CopyTo(psACHandler, false);
                    psACHandler.setPSSYSTEMID(psSystem.getPSSYSTEMID());
                    psACHandler.setPSACHANDLERNAME(psSFACHandler.getPSSFACHANDLERNAME());
                    callResult = this.Save(true, psACHandler);
                    if (!callResult.isError()) continue;
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4e91\u90e8\u4ef6\u540e\u53f0\u5904\u7406\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
                }
                return callResult;
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
