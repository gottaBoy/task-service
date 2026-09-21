/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.BaseTMObject;
import SA.TM.Ctrl.Data.TMRBRule;
import SA.TM.Ctrl.Data.TMResBooking;
import SA.TM.Ctrl.ITMActionContext;
import SA.TM.Ctrl.ITMRBRuleHelper;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TMRBRuleHelper
extends BaseTMObject
implements ITMRBRuleHelper {
    protected TMRBRule tmRBRule = null;
    protected String strTMResBookingDBStorage = "";

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, TMRBRule tmRBRule) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.tmRBRule = tmRBRule;
        this.OnInit();
    }

    @Override
    protected void OnInit() throws Exception {
        IDEHelper tmResBookingDEHelper = this.iDAGlobalHelper.getDAModelStorage().FindDEHelper("TM0110");
        if (tmResBookingDEHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)"TM0110"));
        }
        this.strTMResBookingDBStorage = tmResBookingDEHelper.GetDBStorage();
    }

    @Override
    public CallResult Check(ITMActionContext iTMActionContext, TMResBooking tmResBooking, boolean bCancel, Vector<TMResBooking> relatedTMResBooking) throws Exception {
        return this.OnCheck(iTMActionContext, tmResBooking, bCancel, relatedTMResBooking);
    }

    protected CallResult OnCheck(ITMActionContext iTMActionContext, TMResBooking tmResBooking, boolean bCancel, Vector<TMResBooking> relatedTMResBooking) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u89c4\u5219\u68c0\u67e5\u65b9\u6cd5");
    }

    @Override
    public int getVersion() {
        return this.tmRBRule.getVERSION();
    }

    @Override
    public String getId() {
        return this.tmRBRule.getTMRBRULEID();
    }

    @Override
    public String getRuleInfo() {
        return this.tmRBRule.getRULEINFO();
    }

    @Override
    public String getName() {
        return this.tmRBRule.getTMRBRULENAME();
    }
}

