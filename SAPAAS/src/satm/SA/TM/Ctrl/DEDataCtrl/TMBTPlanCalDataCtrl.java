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
import SA.TM.Ctrl.Data.TMBTPlanCal;
import SA.TM.Ctrl.Data.TMComplexResDetail;
import SA.TM.Ctrl.ITMComplexResHelper;
import SA.TM.Ctrl.ITMModelStorage;
import SA.TM.Ctrl.ITMResBaseHelper;
import SA.TM.Ctrl.TMModelStorageFactory;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TMBTPlanCalDataCtrl
extends BaseDEDataCtrl {
    public static final String UPDATEMODE_RBSTATE = "RBSTATE";
    private static final Log log = LogFactory.getLog(TMBTPlanCalDataCtrl.class);

    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        return callResult;
    }

    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        if (StringHelper.Compare((String)strActionMode, (String)UPDATEMODE_RBSTATE, (boolean)true) != 0) {
            try {
                ITMResBaseHelper iTMResBaseHelper;
                ITMModelStorage iTMModelStorage = TMModelStorageFactory.Create(this.globalHelperEx);
                String strKeyFieldName = this.GetDEHelper().GetKeyDEFHelper().getName();
                TMBTPlanCal tmBTPlanCal = new TMBTPlanCal();
                tmBTPlanCal.Proxy(dataEntity);
                tmBTPlanCal.setTMBTPLANCALID(dataEntity.GetParamStringValue(strKeyFieldName, ""));
                TMBTPlanCal tmBTPlanCalLast = null;
                if (lastDataEntity != null) {
                    tmBTPlanCalLast = new TMBTPlanCal();
                    tmBTPlanCalLast.Proxy(lastDataEntity);
                    tmBTPlanCalLast.setTMBTPLANCALID(lastDataEntity.GetParamStringValue(strKeyFieldName, ""));
                    ITMResBaseHelper iTMResBaseHelperLast = iTMModelStorage.FindTMResource(tmBTPlanCalLast.getTMRESBASEID());
                    if (iTMResBaseHelperLast.isComplexResource()) {
                        IDEDataCtrl tmCRDDataCtrl = this.GetRelatedDataCtrl("TM0165");
                        BaseDataEntity cond = new BaseDataEntity();
                        cond.SetParamValue("PTMBTPLANCALID", (Object)tmBTPlanCalLast.getTMBTPLANCALID());
                        Vector tmCRDBookingList = new Vector();
                        callResult = tmCRDDataCtrl.Select(cond, tmCRDBookingList);
                        if (callResult.IsError()) {
                            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u590d\u5408\u8d44\u6e90\u660e\u7ec6\u9884\u7ea6\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                            return callResult;
                        }
                        for (BaseDataEntity tmCRDBooking : tmCRDBookingList) {
                            callResult = tmCRDDataCtrl.Remove(tmCRDBooking);
                            if (!callResult.IsError()) continue;
                            log.error((Object)StringHelper.Format((String)"\u5220\u9664\u590d\u5408\u8d44\u6e90\u660e\u7ec6\u9884\u7ea6\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                            return callResult;
                        }
                    }
                }
                if ((iTMResBaseHelper = iTMModelStorage.FindTMResource(tmBTPlanCal.getTMRESBASEID())).isComplexResource()) {
                    ITMComplexResHelper iTMComplexResHelper = (ITMComplexResHelper)iTMResBaseHelper;
                    IDEDataCtrl tmCRDDataCtrl = this.GetRelatedDataCtrl("TM0165");
                    for (TMComplexResDetail tmComplexResDetail : iTMComplexResHelper.getComplexResDetails()) {
                        TMBTPlanCal tmBTPlanCal2 = new TMBTPlanCal();
                        tmBTPlanCal.CopyTo(tmBTPlanCal2, false);
                        tmBTPlanCal2.setTMRESBASEID(tmComplexResDetail.getTMRESBASEID());
                        tmBTPlanCal2.setTMRESBASENAME(tmComplexResDetail.getTMRESBASENAME());
                        tmBTPlanCal2.setPTMBTPLANCALID(tmBTPlanCal.GetParamStringValue(strKeyFieldName, ""));
                        tmBTPlanCal2.setTMBTPLANID(tmBTPlanCal.getTMBTPLANID());
                        tmBTPlanCal2.setRESBOOKINGTYPE("COMPLEXRESBOOKING");
                        tmBTPlanCal2.RemoveParam("TMBTPLANCALID");
                        callResult = tmCRDDataCtrl.Save(true, (BaseDataEntity)tmBTPlanCal2);
                        if (!callResult.IsError()) continue;
                        log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u590d\u5408\u8d44\u6e90\u660e\u7ec6\u9884\u7ea6\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        return callResult;
                    }
                }
                if ((callResult = this.Get(tmBTPlanCal)).IsError()) {
                    return callResult;
                }
                return callResult;
            }
            catch (Exception ex) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u8d44\u6e90\u9884\u7ea6\u6570\u636e\u4fdd\u5b58\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
                return callResult;
            }
        }
        return callResult;
    }

    protected CallResult OnAfterRemoveOK(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = super.OnAfterRemoveOK(strActionMode, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        if (StringHelper.Compare((String)strActionMode, (String)UPDATEMODE_RBSTATE, (boolean)true) != 0) {
            try {
                String strKeyFieldName = this.GetDEHelper().GetKeyDEFHelper().getName();
                TMBTPlanCal tmBTPlanCal = new TMBTPlanCal();
                tmBTPlanCal.Proxy(dataEntity);
                tmBTPlanCal.setTMBTPLANCALID(dataEntity.GetParamStringValue(strKeyFieldName, ""));
            }
            catch (Exception ex) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u8d44\u6e90\u9884\u7ea6\u6570\u636e\u5220\u9664\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
                return callResult;
            }
        }
        return callResult;
    }

    protected CallResult OnBeforeRemove(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = super.OnBeforeRemove(strActionMode, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        return callResult;
    }
}

