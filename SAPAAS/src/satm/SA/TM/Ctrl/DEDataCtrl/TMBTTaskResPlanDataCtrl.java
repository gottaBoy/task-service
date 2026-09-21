/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.TM.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.DEDataCtrl.ITMBTTaskResPlanDataCtrl;
import SA.TM.Ctrl.DEDataCtrl.TMTaskDataCtrl;
import SA.TM.Ctrl.Data.TMBTPlanCal;
import SA.TM.Ctrl.Data.TMBTPlanTaskRes;
import SA.TM.Ctrl.Data.TMBTTask;
import SA.TM.Ctrl.Data.TMBTTaskRes;
import SA.TM.Ctrl.Data.TMResCD;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TMBTTaskResPlanDataCtrl
extends BaseDEDataCtrl
implements ITMBTTaskResPlanDataCtrl {
    private static final Log log = LogFactory.getLog(TMTaskDataCtrl.class);
    public static final String CUSTOMCALL_CANCELRESBINDING = "CANCELRESBINDING";
    public static final String CUSTOMCALL_AUTORESBINDING = "AUTORESBINDING";

    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            TMBTPlanTaskRes tmBTPlanTaskRes = new TMBTPlanTaskRes();
            tmBTPlanTaskRes.Proxy(dataEntity);
            TMBTPlanTaskRes tmBTPlanTaskResLast = null;
            if (lastDataEntity != null) {
                tmBTPlanTaskResLast = new TMBTPlanTaskRes();
                tmBTPlanTaskResLast.Proxy(lastDataEntity);
            }
            TMBTTaskRes tmBTTaskRes = new TMBTTaskRes();
            tmBTTaskRes.setTMBTTASKRESID(tmBTPlanTaskRes.getTMBTTASKRESID());
            IDEDataCtrl tmBTTaskResDataCtrl = this.GetRelatedDataCtrl("TM0157");
            callResult = tmBTTaskResDataCtrl.Get((BaseDataEntity)tmBTTaskRes);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u4efb\u52a1\u5b9e\u4f8b\u8d44\u6e90[%1$s]\u6570\u636e\u5931\u8d25\uff0c%2$s", (Object)tmBTTaskRes.getTMBTTASKRESID(), (Object)callResult.getErrorInfo()));
                return callResult;
            }
            String strTMBTPlanCalIdLast = "";
            String strTMBTTaskId = tmBTTaskRes.getTMBTTASKID();
            if (tmBTPlanTaskResLast != null) {
                strTMBTPlanCalIdLast = tmBTPlanTaskResLast.getTMBTPLANCALID();
            }
            TMBTTask tmBTTask = new TMBTTask();
            tmBTTask.setTMBTTASKID(strTMBTTaskId);
            IDEDataCtrl tmBTTaskDataCtrl = this.GetRelatedDataCtrl("TM0156");
            callResult = tmBTTaskDataCtrl.Get((BaseDataEntity)tmBTTask);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u4efb\u52a1\u5b9e\u4f8b[%1$s]\u6570\u636e\u5931\u8d25\uff0c%2$s", (Object)strTMBTTaskId, (Object)callResult.getErrorInfo()));
                return callResult;
            }
            if (StringHelper.IsNullOrEmpty((String)tmBTPlanTaskRes.getTMRESCDID())) {
                if (!StringHelper.IsNullOrEmpty((String)strTMBTPlanCalIdLast)) {
                    tmBTPlanTaskRes.setTMBTPLANCALID("");
                }
            } else {
                TMResCD tmResCD = new TMResCD();
                tmResCD.setTMRESCDID(tmBTPlanTaskRes.getTMRESCDID());
                IDEDataCtrl tmResCDDataCtrl = this.GetRelatedDataCtrl("TM0109");
                callResult = tmResCDDataCtrl.Get((BaseDataEntity)tmResCD);
                if (callResult.IsError()) {
                    return callResult;
                }
                if (StringHelper.Compare((String)tmResCD.getTMRESCATALOGID(), (String)tmBTTaskRes.getTMRESCATALOGID(), (boolean)true) != 0) {
                    callResult.setRetCode(5);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u8d44\u6e90[%1$s]\u5206\u7c7b\u4e0e\u8981\u6c42\u4e0d\u4e00\u81f4", (Object)tmResCD.getTMRESBASENAME()));
                    return callResult;
                }
                IDEDataCtrl tmBTPlanCalDataCtrl = this.GetRelatedDataCtrl("TM0165");
                TMBTPlanCal tmBTPlanCal = new TMBTPlanCal();
                tmBTPlanCal.setTMBTPLANID(tmBTPlanTaskRes.getTMBTPLANID());
                tmBTPlanCal.setRESBOOKINGTYPE("TASKRESBOOKING");
                tmBTPlanCal.setTMRESBASEID(tmResCD.getTMRESBASEID());
                tmBTPlanCal.setTMRESBASENAME(tmResCD.getTMRESBASENAME());
                tmBTPlanCal.setBEGINTIME(tmBTPlanTaskRes.getBEGINTIME());
                tmBTPlanCal.setENDTIME(tmBTPlanTaskRes.getENDTIME());
                tmBTPlanCal.setEXCLUSIVEFLAG(true);
                if (!StringHelper.IsNullOrEmpty((String)strTMBTPlanCalIdLast)) {
                    tmBTPlanCal.setTMBTPLANCALID(strTMBTPlanCalIdLast);
                    callResult = tmBTPlanCalDataCtrl.Save(false, (BaseDataEntity)tmBTPlanCal);
                    if (callResult.IsError()) {
                        log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u4efb\u52a1\u8d44\u6e90\u9884\u7ea6\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        return callResult;
                    }
                } else {
                    tmBTPlanCal.setTMBTTASKID(strTMBTTaskId);
                    callResult = tmBTPlanCalDataCtrl.Save(true, (BaseDataEntity)tmBTPlanCal);
                    if (callResult.IsError()) {
                        log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u4efb\u52a1\u8d44\u6e90\u9884\u7ea6\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        return callResult;
                    }
                    tmBTPlanTaskRes.setTMBTPLANCALID(tmBTPlanCal.getTMBTPLANCALID());
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
            TMBTPlanTaskRes tmBTPlanTaskRes = new TMBTPlanTaskRes();
            tmBTPlanTaskRes.Proxy(dataEntity);
            TMBTPlanTaskRes tmBTPlanTaskResLast = null;
            if (lastDataEntity != null) {
                tmBTPlanTaskResLast = new TMBTPlanTaskRes();
                tmBTPlanTaskResLast.Proxy(lastDataEntity);
            }
            String strTMBTPlanCalIdLast = "";
            if (tmBTPlanTaskResLast != null) {
                strTMBTPlanCalIdLast = tmBTPlanTaskResLast.getTMBTPLANCALID();
            }
            if (StringHelper.IsNullOrEmpty((String)tmBTPlanTaskRes.getTMRESCDID())) {
                if (!StringHelper.IsNullOrEmpty((String)strTMBTPlanCalIdLast)) {
                    IDEDataCtrl tmBTPlanCalDataCtrl = this.GetRelatedDataCtrl("TM0165");
                    TMBTPlanCal tmBTPlanCal = new TMBTPlanCal();
                    tmBTPlanCal.setTMBTPLANCALID(strTMBTPlanCalIdLast);
                    callResult = tmBTPlanCalDataCtrl.Remove((BaseDataEntity)tmBTPlanCal);
                    if (callResult.IsError()) {
                        log.error((Object)StringHelper.Format((String)"\u5220\u9664\u4efb\u52a1\u8d44\u6e90\u9884\u7ea6\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        return callResult;
                    }
                }
            } else if (bInsert && !StringHelper.IsNullOrEmpty((String)tmBTPlanTaskRes.getTMBTPLANCALID())) {
                IDEDataCtrl tmBTPlanCalDataCtrl = this.GetRelatedDataCtrl("TM0165");
                TMBTPlanCal tmBTPlanCal = new TMBTPlanCal();
                tmBTPlanCal.setTMBTPLANCALID(tmBTPlanTaskRes.getTMBTPLANCALID());
                callResult = tmBTPlanCalDataCtrl.Save(false, "RBSTATE", (BaseDataEntity)tmBTPlanCal);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u4efb\u52a1\u8d44\u6e90\u9884\u7ea6\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return callResult;
                }
            }
            return callResult;
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
            TMBTPlanTaskRes tmBTPlanTaskRes = new TMBTPlanTaskRes();
            dataEntity.CopyTo((BaseDataEntity)tmBTPlanTaskRes, false);
            callResult = this.Get(tmBTPlanTaskRes);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u4efb\u52a1\u8d44\u6e90\u9884\u7ea6\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return callResult;
            }
            String strTMBTPlanCalIdLast = tmBTPlanTaskRes.getTMBTPLANCALID();
            if (!StringHelper.IsNullOrEmpty((String)strTMBTPlanCalIdLast)) {
                dataEntity.CopyTo((BaseDataEntity)tmBTPlanTaskRes, true);
                tmBTPlanTaskRes.setTMRESCDID("");
                callResult = this.Save(false, tmBTPlanTaskRes);
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
        return callResult;
    }
}

