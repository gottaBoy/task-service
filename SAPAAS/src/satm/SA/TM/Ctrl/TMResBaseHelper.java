/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.BaseTMObject;
import SA.TM.Ctrl.Data.TMResBase;
import SA.TM.Ctrl.Data.TMResBooking;
import SA.TM.Ctrl.ITMActionContext;
import SA.TM.Ctrl.ITMResBaseHelper;
import SA.TM.Ctrl.ITMResTypeHelper;
import java.sql.Timestamp;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class TMResBaseHelper
extends BaseTMObject
implements ITMResBaseHelper {
    protected TMResBase tmResBase = null;
    protected Vector<String> tmRBRules = new Vector();
    protected ITMResTypeHelper iTMResTypeHelper = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, ITMResTypeHelper iTMResTypeHelper, TMResBase tmResBase) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.tmResBase = tmResBase;
        this.iTMResTypeHelper = iTMResTypeHelper;
        this.tmRBRules.add("TIMERULE");
        this.tmRBRules.add("STANDARDRULE");
        this.OnInit();
    }

    @Override
    protected void OnInit() throws Exception {
    }

    @Override
    public String getId() {
        return this.tmResBase.getTMRESBASEID();
    }

    @Override
    public int getVersion() {
        return this.tmResBase.getVERSION();
    }

    @Override
    public String getName() {
        return this.tmResBase.getTMRESBASENAME();
    }

    @Override
    public Vector<String> getRBRules() {
        return this.tmRBRules;
    }

    @Override
    public TMResBooking Booking(ITMActionContext iTMActionContext, TMResBooking tmResBooking) throws Exception {
        return null;
    }

    @Override
    public void CancelBooking(ITMActionContext iTMActionContext, TMResBooking tmResBooking) throws Exception {
    }

    @Override
    public CallResult TestBooking(ITMActionContext iTMActionContext, TMResBooking tmResBooking) throws Exception {
        return null;
    }

    @Override
    public TMResBooking UpdateBooking(ITMActionContext iTMActionContext, TMResBooking tmResBooking, TMResBooking tmResBookingLast) throws Exception {
        return null;
    }

    @Override
    public boolean TestValidTime(Timestamp beginTime, Timestamp endTime) throws Exception {
        return this.OnTestValidTime(beginTime, endTime);
    }

    protected boolean OnTestValidTime(Timestamp beginTime, Timestamp endTime) throws Exception {
        return true;
    }

    @Override
    public String getTimeRuleId() {
        if (!StringHelper.IsNullOrEmpty((String)this.tmResBase.getTMTIMERULEID())) {
            return this.tmResBase.getTMTIMERULEID();
        }
        return this.iTMResTypeHelper.getTimeRuleId();
    }

    @Override
    public float getCapacity() {
        return this.tmResBase.getCAPACITY();
    }

    @Override
    public float getCapacity2() {
        return this.tmResBase.getCAPACITY2();
    }

    @Override
    public int getCapacity3() {
        return this.tmResBase.getCAPACITY3();
    }

    @Override
    public int getCapacity4() {
        return this.tmResBase.getCAPACITY4();
    }

    @Override
    public String getResType() {
        return this.tmResBase.getTMRESBASETYPE();
    }

    @Override
    public String getDetailInfo() {
        return this.OnGetDetailInfo();
    }

    protected String OnGetDetailInfo() {
        return this.getName();
    }
}

