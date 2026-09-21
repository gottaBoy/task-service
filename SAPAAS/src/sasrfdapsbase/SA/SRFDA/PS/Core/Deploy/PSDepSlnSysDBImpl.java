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
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnDBInst;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnSys;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnSysDB;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnSysObjectImpl;
import SA.SRFDA.PS.Data.PSDepSlnSysDB;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnSysDBImpl
extends PSDepSlnSysObjectImpl
implements IPSDepSlnSysDB {
    private static final Log log = LogFactory.getLog(PSDepSlnSysDBImpl.class);
    protected PSDepSlnSysDB psDepSlnSysDB = null;
    private IPSDepSlnDBInst iPSDepSlnDBInst = null;
    private String strDSLink = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDepSln iPSDepSln, PSDepSlnSysDB psDepSlnSysDB) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSDepSln(iPSDepSln);
        this.psDepSlnSysDB = psDepSlnSysDB;
        this.setId(this.psDepSlnSysDB.getPSDEPSLNSYSDBID());
        this.setName(this.psDepSlnSysDB.getPSDEPSLNSYSDBNAME());
        this.setPSObjectData(this.psDepSlnSysDB);
        IPSDepSlnSys iPSDepSlnSys = this.getPSDepSln().getPSDepSlnSys(psDepSlnSysDB.getPSDEPSLNSYSID());
        this.setPSDepSlnSys(iPSDepSlnSys);
        this.iPSDepSlnDBInst = this.getPSDepSln().getPSDepSlnDBInst(psDepSlnSysDB.getPSDEPSLNDBINSTID());
        this.strDSLink = this.psDepSlnSysDB.getPSDEPSLNSYSDBNAME();
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDEPSLNSYSDB";
    }

    @Override
    public String getDSLink() {
        return this.strDSLink;
    }

    @Override
    public IPSDepSlnDBInst getPSDepSlnDBInst() {
        return this.iPSDepSlnDBInst;
    }
}

