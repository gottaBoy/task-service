/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.ResBooking;

import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.ResBooking.IPSBookingResType;
import SA.SRFDA.PS.Core.ResBooking.IPSResBooking;
import SA.SRFDA.PS.Data.PSBookingResType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSBookingResTypeImpl
extends PSObjectImpl
implements IPSBookingResType {
    protected PSBookingResType psBookingResType = null;
    private static final Log log = LogFactory.getLog(PSBookingResTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSBookingResType psBookingResType) throws Exception {
        this.psBookingResType = psBookingResType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psBookingResType.getPSBOOKINGRESTYPEID());
        this.setName(psBookingResType.getPSBOOKINGRESTYPENAME());
        this.setPSObjectData(this.psBookingResType);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public void initResBooking(IPSResBooking iPSResBooking) throws Exception {
        this.onInitResBooking(iPSResBooking);
    }

    protected void onInitResBooking(IPSResBooking iPSResBooking) throws Exception {
    }

    @Override
    public void restoreResBooking(IPSResBooking iPSResBooking) throws Exception {
        this.onRestoreResBooking(iPSResBooking);
    }

    protected void onRestoreResBooking(IPSResBooking iPSResBooking) throws Exception {
    }

    @Override
    public void backupResBooking(IPSResBooking iPSResBooking) throws Exception {
        this.onBackupResBooking(iPSResBooking);
    }

    protected void onBackupResBooking(IPSResBooking iPSResBooking) throws Exception {
    }

    @Override
    public void uninitResBooking(IPSResBooking iPSResBooking) throws Exception {
        this.onUninitResBooking(iPSResBooking);
    }

    protected void onUninitResBooking(IPSResBooking iPSResBooking) throws Exception {
    }
}

