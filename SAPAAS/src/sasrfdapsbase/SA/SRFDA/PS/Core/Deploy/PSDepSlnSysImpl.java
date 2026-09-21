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
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnSys;
import SA.SRFDA.PS.Core.Deploy.IPSDepSysVer;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnObjectImpl;
import SA.SRFDA.PS.Data.PSDepSlnSys;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnSysImpl
extends PSDepSlnObjectImpl
implements IPSDepSlnSys {
    private static final Log log = LogFactory.getLog(PSDepSlnSysImpl.class);
    protected PSDepSlnSys psDepSlnSys = null;
    private IPSDepSysVer iPSDepSysVer = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDepSln iPSDepSln, PSDepSlnSys psDepSlnSys) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSDepSln(iPSDepSln);
        this.psDepSlnSys = psDepSlnSys;
        this.setId(this.psDepSlnSys.getPSDEPSLNSYSID());
        this.setName(this.psDepSlnSys.getPSDEPSLNSYSNAME());
        this.setPSObjectData(this.psDepSlnSys);
        this.iPSDepSysVer = this.getPSModelStorage().getPSDepSysVer(psDepSlnSys.getPSDEPSYSVERID());
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDEPSLNSYS";
    }

    @Override
    public IPSDepSysVer getPSDepSysVer() {
        return this.iPSDepSysVer;
    }
}

