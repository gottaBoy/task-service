/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.Data.TMRBRuleItem;
import SA.TM.Ctrl.Data.TMResBooking;
import SA.TM.Ctrl.ITMActionContext;
import SA.TM.Ctrl.ITMResBaseHelper;
import SA.TM.Ctrl.TMRBRuleHelper;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TMRBTimeRuleHelper
extends TMRBRuleHelper {
    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
    }

    @Override
    protected CallResult OnCheck(ITMActionContext iTMActionContext, TMResBooking tmResBooking, boolean bCancel, Vector<TMResBooking> relatedTMResBookingList) throws Exception {
        CallResult callResult = new CallResult();
        String strTMRBRuleItemId = StringHelper.Format((String)"%1$s_%2$s", (Object)this.getId(), (Object)tmResBooking.getTMRESBOOKINGID());
        IDEDataCtrl iDEDataCtrl = iTMActionContext.getDEDataCtrl("TM0185");
        TMRBRuleItem tmRBRuleItem = new TMRBRuleItem();
        tmRBRuleItem.setTMRBRULEITEMID(strTMRBRuleItemId);
        iDEDataCtrl.Remove((BaseDataEntity)tmRBRuleItem);
        if (!bCancel) {
            boolean bTestOk = true;
            if (!tmResBooking.isBEGINTIMENull() && !tmResBooking.isENDTIMENull()) {
                ITMResBaseHelper iTMResBaseHelper = this.getTMModelStorage().FindTMResource(tmResBooking.getTMRESBASEID());
                bTestOk = iTMResBaseHelper.TestValidTime(tmResBooking.getBEGINTIME(), tmResBooking.getENDTIME());
            }
            if (!bTestOk) {
                tmRBRuleItem.Reset();
                tmRBRuleItem.setTMRBRULEITEMNAME(this.tmRBRule.getTMRBRULENAME());
                tmRBRuleItem.setTMRBRULEITEMID(strTMRBRuleItemId);
                tmRBRuleItem.setTMRBRULEID(this.getId());
                tmRBRuleItem.setTMRESBOOKINGID(tmResBooking.getTMRESBOOKINGID());
                tmRBRuleItem.setRBSTATE("WARNING");
                callResult = iDEDataCtrl.Save(true, (BaseDataEntity)tmRBRuleItem);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u8d44\u6e90\u9884\u7ea6\u5f02\u5e38\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                callResult.setUserObject((Object)tmRBRuleItem);
            }
        }
        return callResult;
    }
}

