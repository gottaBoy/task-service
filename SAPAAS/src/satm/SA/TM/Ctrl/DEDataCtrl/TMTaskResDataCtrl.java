/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.TM.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.DEDataCtrl.ITMTaskDataCtrl;
import SA.TM.Ctrl.DEDataCtrl.ITMTaskResDataCtrl;
import SA.TM.Ctrl.DEDataCtrl.TMTaskDataCtrl;
import SA.TM.Ctrl.Data.TMResCD;
import SA.TM.Ctrl.Data.TMTRBooking;
import SA.TM.Ctrl.Data.TMTaskBase;
import SA.TM.Ctrl.Data.TMTaskRes;
import SA.TM.Ctrl.ITMModelStorage;
import SA.TM.Ctrl.ITMResCatalogHelper;
import SA.TM.Ctrl.ITMTaskResArrangeEngine;
import SA.TM.Ctrl.TMActionContext;
import SA.TM.Ctrl.TMModelStorageFactory;
import java.sql.Timestamp;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TMTaskResDataCtrl
extends BaseDEDataCtrl
implements ITMTaskResDataCtrl {
    private static final Log log = LogFactory.getLog(TMTaskDataCtrl.class);
    public static final String CUSTOMCALL_CANCELRESBINDING = "CANCELRESBINDING";
    public static final String CUSTOMCALL_AUTORESBINDING = "AUTORESBINDING";

    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            TMTaskRes tmTaskRes = new TMTaskRes();
            tmTaskRes.Proxy(dataEntity);
            TMTaskRes tmTaskResLast = null;
            if (lastDataEntity != null) {
                tmTaskResLast = new TMTaskRes();
                tmTaskResLast.Proxy(lastDataEntity);
            }
            String strTMTRBookingIdLast = "";
            String strTMTaskBaseId = tmTaskRes.getTMTASKBASEID();
            if (tmTaskResLast != null) {
                strTMTRBookingIdLast = tmTaskResLast.getTMRESBOOKINGID();
                strTMTaskBaseId = tmTaskResLast.getTMTASKBASEID();
            }
            TMTaskBase tmTaskBase = new TMTaskBase();
            tmTaskBase.setTMTASKBASEID(strTMTaskBaseId);
            IDEDataCtrl tmTaskBaseDataCtrl = this.GetRelatedDataCtrl("TM0050");
            callResult = tmTaskBaseDataCtrl.Get((BaseDataEntity)tmTaskBase);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u4efb\u52a1[%1$s]\u6570\u636e\u5931\u8d25\uff0c%2$s", (Object)tmTaskRes.getTMTASKBASEID(), (Object)callResult.getErrorInfo()));
                return callResult;
            }
            tmTaskRes.setIMPORTANCEFLAG(tmTaskBase.getIMPORTANCEFLAG());
            if (tmTaskRes.getCUSTOMTRTIME()) {
                if (tmTaskRes.getDURATION() <= 0 || tmTaskBase.isBEGINTIMENull() || tmTaskBase.isENDTIMENull()) {
                    tmTaskRes.setBEGINTIME(null);
                    tmTaskRes.setENDTIME(null);
                } else {
                    long nMin = tmTaskBase.getENDTIME().getTime() - tmTaskBase.getBEGINTIME().getTime();
                    if ((nMin /= 60000L) < (long)tmTaskRes.getDURATION()) {
                        callResult.setRetCode(5);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u4efb\u52a1\u65f6\u957f[%1$s\u5206\u949f]\u4e0d\u80fd\u6ee1\u8db3\u8d44\u6e90\u81ea\u5b9a\u4e49\u65f6\u957f\u8981\u6c42[%2$s\u5206\u949f]", (Object)nMin, (Object)tmTaskRes.getDURATION()));
                        return callResult;
                    }
                    if (tmTaskRes.isBEGINTIMENull() || tmTaskRes.getBEGINTIME().getTime() < tmTaskBase.getBEGINTIME().getTime() || tmTaskRes.getBEGINTIME().getTime() > tmTaskBase.getENDTIME().getTime() || tmTaskRes.getBEGINTIME().getTime() + (long)(tmTaskRes.getDURATION() * 60000) > tmTaskBase.getENDTIME().getTime()) {
                        tmTaskRes.setBEGINTIME(tmTaskBase.getBEGINTIME());
                    }
                    tmTaskRes.setENDTIME(new Timestamp(tmTaskRes.getBEGINTIME().getTime() + (long)(tmTaskRes.getDURATION() * 60000)));
                }
            } else {
                tmTaskRes.setBEGINTIME(tmTaskBase.getBEGINTIME());
                tmTaskRes.setENDTIME(tmTaskBase.getENDTIME());
            }
            if (StringHelper.IsNullOrEmpty((String)tmTaskRes.getTMRESCDID())) {
                if (!StringHelper.IsNullOrEmpty((String)strTMTRBookingIdLast)) {
                    tmTaskRes.setTMRESBOOKINGID("");
                }
            } else {
                TMResCD tmResCD = new TMResCD();
                tmResCD.setTMRESCDID(tmTaskRes.getTMRESCDID());
                IDEDataCtrl tmResCDDataCtrl = this.GetRelatedDataCtrl("TM0109");
                callResult = tmResCDDataCtrl.Get((BaseDataEntity)tmResCD);
                if (callResult.IsError()) {
                    return callResult;
                }
                if (StringHelper.Compare((String)tmResCD.getTMRESCATALOGID(), (String)tmTaskRes.getTMRESCATALOGID(), (boolean)true) != 0) {
                    callResult.setRetCode(5);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u8d44\u6e90[%1$s]\u5206\u7c7b\u4e0e\u8981\u6c42\u4e0d\u4e00\u81f4", (Object)tmResCD.getTMRESBASENAME()));
                    return callResult;
                }
                IDEDataCtrl tmTRBookingDataCtrl = this.GetRelatedDataCtrl("TM0130");
                TMTRBooking tmTRBooking = new TMTRBooking();
                tmTRBooking.setTMRESBASEID(tmResCD.getTMRESBASEID());
                tmTRBooking.setTMRESBASENAME(tmResCD.getTMRESBASENAME());
                tmTRBooking.setMEMO(tmTaskRes.getMEMO());
                tmTRBooking.setIMPORTANCEFLAG(tmTaskBase.getIMPORTANCEFLAG());
                tmTRBooking.setBEGINTIME(tmTaskRes.getBEGINTIME());
                tmTRBooking.setENDTIME(tmTaskRes.getENDTIME());
                tmTRBooking.setEXCLUSIVEFLAG(tmTaskRes.getEXCLUSIVEFLAG());
                tmTRBooking.setREQUIREMODE(tmTaskRes.getREQUIREMODE());
                if (!StringHelper.IsNullOrEmpty((String)tmTaskRes.getTMTASKRESID())) {
                    tmTRBooking.setUSERTAG(tmTaskRes.getTMTASKRESID());
                }
                if (!StringHelper.IsNullOrEmpty((String)strTMTRBookingIdLast)) {
                    tmTRBooking.setTMTRBOOKINGID(strTMTRBookingIdLast);
                    callResult = tmTRBookingDataCtrl.Save(false, (BaseDataEntity)tmTRBooking);
                    if (callResult.IsError()) {
                        log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u4efb\u52a1\u8d44\u6e90\u9884\u7ea6\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        return callResult;
                    }
                } else {
                    tmTRBooking.setTMTASKBASEID(strTMTaskBaseId);
                    tmTRBooking.setTASKRESTYPE(tmTaskRes.getTASKRESTYPE());
                    callResult = tmTRBookingDataCtrl.Save(true, (BaseDataEntity)tmTRBooking);
                    if (callResult.IsError()) {
                        log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u4efb\u52a1\u8d44\u6e90\u9884\u7ea6\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        return callResult;
                    }
                    tmTaskRes.setTMRESBOOKINGID(tmTRBooking.getTMTRBOOKINGID());
                }
            }
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u4efb\u52a1\u8d44\u6e90\u6570\u636e\u4fdd\u5b58\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            TMTaskRes tmTaskRes = new TMTaskRes();
            tmTaskRes.Proxy(dataEntity);
            TMTaskRes tmTaskResLast = null;
            if (lastDataEntity != null) {
                tmTaskResLast = new TMTaskRes();
                tmTaskResLast.Proxy(lastDataEntity);
            }
            String strTMTRBookingIdLast = "";
            if (tmTaskResLast != null) {
                strTMTRBookingIdLast = tmTaskResLast.getTMRESBOOKINGID();
            }
            if (StringHelper.IsNullOrEmpty((String)tmTaskRes.getTMRESCDID())) {
                if (!StringHelper.IsNullOrEmpty((String)strTMTRBookingIdLast)) {
                    IDEDataCtrl tmTRBookingDataCtrl = this.GetRelatedDataCtrl("TM0130");
                    TMTRBooking tmTRBooking = new TMTRBooking();
                    tmTRBooking.setTMTRBOOKINGID(strTMTRBookingIdLast);
                    callResult = tmTRBookingDataCtrl.Remove((BaseDataEntity)tmTRBooking);
                    if (callResult.IsError()) {
                        log.error((Object)StringHelper.Format((String)"\u5220\u9664\u4efb\u52a1\u8d44\u6e90\u9884\u7ea6\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        return callResult;
                    }
                }
            } else if (bInsert && !StringHelper.IsNullOrEmpty((String)tmTaskRes.getTMRESBOOKINGID())) {
                IDEDataCtrl tmTRBookingDataCtrl = this.GetRelatedDataCtrl("TM0130");
                TMTRBooking tmTRBooking = new TMTRBooking();
                tmTRBooking.setTMTRBOOKINGID(tmTaskRes.getTMRESBOOKINGID());
                tmTRBooking.setUSERTAG(tmTaskRes.getTMTASKRESID());
                callResult = tmTRBookingDataCtrl.Save(false, "RBSTATE", (BaseDataEntity)tmTRBooking);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u4efb\u52a1\u8d44\u6e90\u9884\u7ea6\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return callResult;
                }
            }
            return this.UpdateParentTaskResState(tmTaskRes.getTMTASKBASEID(), tmTaskRes.getTASKTYPE());
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u4efb\u52a1\u8d44\u6e90\u6570\u636e\u4fdd\u5b58\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
    }

    protected CallResult OnBeforeRemove(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = super.OnBeforeRemove(strActionMode, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            TMTaskRes tmTaskRes = new TMTaskRes();
            dataEntity.CopyTo((BaseDataEntity)tmTaskRes, false);
            callResult = this.Get(tmTaskRes);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u4efb\u52a1\u8d44\u6e90\u9884\u7ea6\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return callResult;
            }
            String strTMTRBookingIdLast = tmTaskRes.getTMRESBOOKINGID();
            if (!StringHelper.IsNullOrEmpty((String)strTMTRBookingIdLast)) {
                dataEntity.CopyTo((BaseDataEntity)tmTaskRes, true);
                tmTaskRes.setTMRESCDID("");
                callResult = this.Save(false, tmTaskRes);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u4efb\u52a1\u8d44\u6e90\u9884\u7ea6\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return callResult;
                }
            }
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u4efb\u52a1\u8d44\u6e90\u6570\u636e\u5220\u9664\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
    }

    protected CallResult OnAfterRemoveOK(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = super.OnAfterRemoveOK(strActionMode, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        return this.UpdateParentTaskResState(dataEntity.GetParamStringValue("TMTASKBASEID", ""), dataEntity.GetParamStringValue("TASKTYPE", ""));
    }

    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CANCELRESBINDING, (boolean)true) == 0) {
            return this.CancelResBinding(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_AUTORESBINDING, (boolean)true) == 0) {
            return this.AutoResBinding(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult CancelResBinding(BaseDataEntity dataEntity) {
        try {
            return this.OnCancelResBinding(dataEntity);
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)StringHelper.Format((String)"\u53d6\u6d88\u8d44\u6e90\u7ed1\u5b9a\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            return callResult;
        }
    }

    public CallResult AutoResBinding(BaseDataEntity dataEntity) {
        try {
            return this.OnAutoResBinding(dataEntity);
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)StringHelper.Format((String)"\u81ea\u52a8\u8d44\u6e90\u7ed1\u5b9a\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            return callResult;
        }
    }

    protected CallResult OnCancelResBinding(BaseDataEntity dataEntity) throws Exception {
        TMTaskRes tmTaskRes = new TMTaskRes();
        tmTaskRes.Proxy(dataEntity);
        CallResult callResult = this.Get(tmTaskRes);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u4efb\u52a1\u8d44\u6e90\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (StringHelper.IsNullOrEmpty((String)tmTaskRes.getTMRESCDID())) {
            return callResult;
        }
        TMTaskRes tmTaskRes2 = new TMTaskRes();
        tmTaskRes2.setTMTASKRESID(tmTaskRes.getTMTASKRESID());
        tmTaskRes2.setTMRESCDID("");
        callResult = this.Save(false, tmTaskRes2);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u89e3\u9664\u4efb\u52a1\u8d44\u6e90\u7ed1\u5b9a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return callResult;
    }

    protected CallResult OnAutoResBinding(BaseDataEntity dataEntity) throws Exception {
        TMTaskRes tmTaskRes = new TMTaskRes();
        tmTaskRes.Proxy(dataEntity);
        CallResult callResult = this.Get(tmTaskRes);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u4efb\u52a1\u8d44\u6e90\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (!StringHelper.IsNullOrEmpty((String)tmTaskRes.getTMRESCDID())) {
            log.debug((Object)StringHelper.Format((String)"\u8d44\u6e90\u5df2\u7ecf\u7ed1\u5b9a\uff0c\u65e0\u6cd5\u518d\u6b21\u7ed1\u5b9a"));
            return callResult;
        }
        ITMModelStorage iTMModelStorage = TMModelStorageFactory.Create(this.globalHelperEx);
        ITMResCatalogHelper iTMResCatalogHelper = iTMModelStorage.FindTMResCatalog(tmTaskRes.getTMRESCATALOGID());
        if (StringHelper.IsNullOrEmpty((String)iTMResCatalogHelper.getTMTaskResAEId())) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u4e3a\u8d44\u6e90\u5206\u7c7b[%1$s]\u6307\u5b9a\u6392\u5e03\u5f15\u64ce\uff0c\u65e0\u6cd5\u81ea\u52a8\u7ed1\u5b9a\u8d44\u6e90", (Object)iTMResCatalogHelper.getName()));
            return callResult;
        }
        TMActionContext tmActionContext = new TMActionContext();
        tmActionContext.Init(this.getWebContext().getGlobalHelper(), this);
        ITMTaskResArrangeEngine iTMTaskResArrangeEngine = iTMModelStorage.CreateTMTaskResArrangeEngine(iTMResCatalogHelper.getTMTaskResAEId());
        Hashtable<String, Float> tmResCDScoreMap = new Hashtable<String, Float>();
        String strTMResCDId = iTMTaskResArrangeEngine.CalcResCDScore(tmActionContext, tmTaskRes, tmResCDScoreMap, null);
        if (StringHelper.IsNullOrEmpty((String)strTMResCDId)) {
            log.debug((Object)StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u4efb\u52a1[%1$s]\u8d44\u6e90\u7684\u9700\u8981\u7684\u8d44\u6e90[%2$s]", (Object)tmTaskRes.getTMTASKBASENAME(), (Object)tmTaskRes.getTASKRESTYPE()));
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"%1$s[%2$s] \u8d44\u6e90\u7c7b\u522b[%3$s] \u65e0\u6cd5\u8ba1\u7b97\u8d44\u6e90\r\n", (Object)tmTaskRes.getROOTTMTASKBASENAME(), (Object)tmTaskRes.getTMTASKBASENAME(), (Object)tmTaskRes.getTMRESCATALOGNAME()));
            return callResult;
        }
        log.debug((Object)StringHelper.Format((String)"\u8ba1\u7b97\u4efb\u52a1[%1$s]\u8d44\u6e90\u7684\u9700\u8981\u7684\u8d44\u6e90[%2$s]==>[%3$s]", (Object)tmTaskRes.getTMTASKBASENAME(), (Object)tmTaskRes.getTASKRESTYPE(), (Object)strTMResCDId));
        TMTaskRes tmTaskRes2 = new TMTaskRes();
        tmTaskRes2.setTMTASKRESID(tmTaskRes.getTMTASKRESID());
        tmTaskRes2.setTMRESCDID(strTMResCDId);
        callResult = this.Save(false, tmTaskRes2);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u4efb\u52a1\u8d44\u6e90\u7ed1\u5b9a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return callResult;
    }

    protected CallResult UpdateParentTaskResState(String strTMTaskId, String strTMTaskType) {
        CallResult callResult = new CallResult();
        IDEHelper tmTaskBaseDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper("TM0050");
        DERINDEX derIndex = tmTaskBaseDEHelper.FindDERINDEX(strTMTaskType);
        if (derIndex == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4efb\u52a1\u5bf9\u8c61\u7ee7\u627f\u7c7b\u578b[%1$s]", (Object)strTMTaskType));
            return callResult;
        }
        try {
            IDEDataCtrl iDEDataCtrl = this.GetRelatedDataCtrl(derIndex.getDEID());
            if (iDEDataCtrl instanceof ITMTaskDataCtrl) {
                ITMTaskDataCtrl iTMTaskDataCtrl = (ITMTaskDataCtrl)iDEDataCtrl;
                BaseDataEntity tmTaskBase = new BaseDataEntity();
                tmTaskBase.SetParamValue(iDEDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), (Object)strTMTaskId);
                callResult = iTMTaskDataCtrl.UpdateTaskResState(tmTaskBase);
            }
            return callResult;
        }
        catch (Exception e) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
            log.error((Object)callResult.getErrorInfo(), (Throwable)e);
            return callResult;
        }
    }
}

