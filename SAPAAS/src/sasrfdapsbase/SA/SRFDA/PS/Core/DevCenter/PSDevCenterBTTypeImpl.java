/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterBKTask;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterBTType;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDCBKTask;
import SA.SRFDA.PS.Data.PSDCBKType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDevCenterBTTypeImpl
extends PSObjectImpl
implements IPSDevCenterBTType {
    protected PSDCBKType psDCBKType = null;
    private static final Log log = LogFactory.getLog(PSDevCenterBTTypeImpl.class);
    private boolean bUseRobot = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDCBKType psDCBKType) throws Exception {
        this.psDCBKType = psDCBKType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDCBKType.getPSDCBKTYPEID());
        this.setName(psDCBKType.getPSDCBKTYPENAME());
        this.setPSObjectData(this.psDCBKType);
        if (!this.psDCBKType.isUSEROBOTFLAGNull()) {
            this.bUseRobot = this.psDCBKType.getUSEROBOTFLAG();
        }
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
    public IPSDevCenterBKTask createPSDevCenterBKTask(PSDCBKTask psDevCenterBKTask) throws Exception {
        return (IPSDevCenterBKTask)ObjectHelper.Create((String)this.psDCBKType.getTASKOBJ());
    }

    @Override
    public boolean isUseRobot() {
        return this.bUseRobot;
    }
}

