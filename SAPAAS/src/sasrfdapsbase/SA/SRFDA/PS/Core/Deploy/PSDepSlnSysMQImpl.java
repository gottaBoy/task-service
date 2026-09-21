/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepSln;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnMQInst;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnSys;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnSysMQ;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnSysObjectImpl;
import SA.SRFDA.PS.Data.PSDepSlnSysMQ;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnSysMQImpl
extends PSDepSlnSysObjectImpl
implements IPSDepSlnSysMQ {
    private static final Log log = LogFactory.getLog(PSDepSlnSysMQImpl.class);
    protected PSDepSlnSysMQ psDepSlnSysMQ = null;
    private IPSDepSlnMQInst iPSDepSlnMQInst = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDepSln iPSDepSln, PSDepSlnSysMQ psDepSlnSysMQ) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSDepSln(iPSDepSln);
        this.psDepSlnSysMQ = psDepSlnSysMQ;
        this.setId(this.psDepSlnSysMQ.getPSDEPSLNSYSMQID());
        this.setName(this.psDepSlnSysMQ.getPSDEPSLNSYSMQNAME());
        this.setPSObjectData(this.psDepSlnSysMQ);
        IPSDepSlnSys iPSDepSlnSys = this.getPSDepSln().getPSDepSlnSys(psDepSlnSysMQ.getPSDEPSLNSYSID());
        this.setPSDepSlnSys(iPSDepSlnSys);
        this.iPSDepSlnMQInst = this.getPSDepSln().getPSDepSlnMQInst(psDepSlnSysMQ.getPSDEPSLNMQINSTID());
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDEPSLNSYSMQ";
    }

    @Override
    public IPSDepSlnMQInst getPSDepSlnMQInst() {
        return this.iPSDepSlnMQInst;
    }
}

