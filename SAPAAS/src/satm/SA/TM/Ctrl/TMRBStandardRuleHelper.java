/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.Data.TMRBRIDetail;
import SA.TM.Ctrl.Data.TMRBRuleItem;
import SA.TM.Ctrl.Data.TMResBooking;
import SA.TM.Ctrl.ITMActionContext;
import SA.TM.Ctrl.TMRBRuleHelper;
import java.sql.Connection;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TMRBStandardRuleHelper
extends TMRBRuleHelper {
    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
    }

    @Override
    protected CallResult OnCheck(ITMActionContext iTMActionContext, TMResBooking tmResBooking, boolean bCancel, Vector<TMResBooking> relatedTMResBookingList) throws Exception {
        CallResult callResult = new CallResult();
        String strSQL = StringHelper.Format((String)"select t1.* from SRFT_TMRESBOOKING_BASE t1 where t1.BEGINTIME<? AND t1.ENDTIME>? and t1.TMRESBOOKINGID <>  ? and t1.TMRESBASEID=? ");
        CallParamList callParamList = new CallParamList();
        callParamList.AddDateTime((Object)tmResBooking.getENDTIME());
        callParamList.AddDateTime((Object)tmResBooking.getBEGINTIME());
        callParamList.Add((Object)tmResBooking.getTMRESBOOKINGID());
        callParamList.Add((Object)tmResBooking.getTMRESBASEID());
        Vector tmResBookingList = new Vector();
        callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.iDAGlobalHelper, (Connection)iTMActionContext.getDBConnection(this.strTMResBookingDBStorage), (String)this.strTMResBookingDBStorage, (String)strSQL, (Vector)callParamList.GetList(), tmResBookingList, (String)TMResBooking.class.getName());
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8d44\u6e90\u9884\u7ea6\u65f6\u95f4\u6bb5\u5185\u5176\u5b83\u9884\u7ea6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        String strTMRBRuleItemId = StringHelper.Format((String)"%1$s_%2$s", (Object)this.getId(), (Object)tmResBooking.getTMRESBOOKINGID());
        IDEDataCtrl iDEDataCtrl = iTMActionContext.getDEDataCtrl("TM0185");
        TMRBRuleItem tmRBRuleItem = new TMRBRuleItem();
        tmRBRuleItem.setTMRBRULEITEMID(strTMRBRuleItemId);
        iDEDataCtrl.Remove((BaseDataEntity)tmRBRuleItem);
        for (TMResBooking tmResBookingOther : tmResBookingList) {
            relatedTMResBookingList.add(tmResBookingOther);
        }
        if (!bCancel) {
            boolean bTestOk = true;
            for (TMResBooking tmResBookingOther : tmResBookingList) {
                if (!tmResBookingOther.getEXCLUSIVEFLAG() && !tmResBooking.getEXCLUSIVEFLAG()) continue;
                bTestOk = false;
                break;
            }
            if (!bTestOk) {
                tmRBRuleItem.Reset();
                tmRBRuleItem.setTMRBRULEITEMNAME(this.tmRBRule.getTMRBRULENAME());
                tmRBRuleItem.setTMRBRULEITEMID(strTMRBRuleItemId);
                tmRBRuleItem.setTMRBRULEID(this.getId());
                tmRBRuleItem.setTMRESBOOKINGID(tmResBooking.getTMRESBOOKINGID());
                tmRBRuleItem.setRBSTATE("ERROR");
                callResult = iDEDataCtrl.Save(true, (BaseDataEntity)tmRBRuleItem);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u8d44\u6e90\u9884\u7ea6\u5f02\u5e38\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                IDEDataCtrl tmRBRIDetailDataCtrl = iTMActionContext.getDEDataCtrl("TM0186");
                for (TMResBooking tmResBookingOther : tmResBookingList) {
                    if (!tmResBookingOther.getEXCLUSIVEFLAG() && !tmResBooking.getEXCLUSIVEFLAG()) continue;
                    TMRBRIDetail tmRBRIDetail = new TMRBRIDetail();
                    tmRBRIDetail.setTMRBRULEITEMID(strTMRBRuleItemId);
                    tmRBRIDetail.setTMRESBOOKINGID(tmResBookingOther.getTMRESBOOKINGID());
                    callResult = tmRBRIDetailDataCtrl.Save(true, (BaseDataEntity)tmRBRIDetail);
                    if (!callResult.IsError()) continue;
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u8d44\u6e90\u9884\u7ea6\u5f02\u5e38\u9879\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                callResult.setUserObject((Object)tmRBRuleItem);
            }
        }
        return callResult;
    }
}

