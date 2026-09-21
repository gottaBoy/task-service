/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepSln;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnAS;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnASGroup;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnSys;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnSysAS;
import SA.SRFDA.PS.Core.Deploy.IPSDepSysApp;
import SA.SRFDA.PS.Core.Deploy.IPSDepSysVer;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnSysObjectImpl;
import SA.SRFDA.PS.Data.PSDepSlnSysAS;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnSysASImpl
extends PSDepSlnSysObjectImpl
implements IPSDepSlnSysAS {
    private static final Log log = LogFactory.getLog(PSDepSlnSysASImpl.class);
    protected PSDepSlnSysAS psDepSlnSysAS = null;
    private IPSDepSlnAS iPSDepSlnAS = null;
    private IPSDepSlnASGroup iPSDepSlnASGroup = null;
    private String strContainerType = "";
    private String strServiceContainer = "";
    private IPSDepSysVer iPSDepSysVer = null;
    private IPSDepSysApp iPSDepSysApp = null;
    private IPSDepSysApp no2PSDepSysApp = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDepSln iPSDepSln, PSDepSlnSysAS psDepSlnSysAS) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSDepSln(iPSDepSln);
        this.psDepSlnSysAS = psDepSlnSysAS;
        this.setId(this.psDepSlnSysAS.getPSDEPSLNSYSASID());
        this.setName(this.psDepSlnSysAS.getPSDEPSLNSYSASNAME());
        this.setPSObjectData(this.psDepSlnSysAS);
        IPSDepSlnSys iPSDepSlnSys = this.getPSDepSln().getPSDepSlnSys(psDepSlnSysAS.getPSDEPSLNSYSID());
        this.setPSDepSlnSys(iPSDepSlnSys);
        this.strContainerType = this.psDepSlnSysAS.getCONTAINERTYPE();
        if (StringHelper.compare((String)this.strContainerType, (String)"AS", (boolean)false) == 0) {
            this.iPSDepSlnAS = this.getPSDepSln().getPSDepSlnAS(psDepSlnSysAS.getPSDEPSLNASID());
        }
        if (StringHelper.compare((String)this.strContainerType, (String)"ASGROUP", (boolean)false) == 0) {
            this.iPSDepSlnASGroup = this.getPSDepSln().getPSDepSlnASGroup(psDepSlnSysAS.getPSDEPSLNASGRPID());
        }
        this.strServiceContainer = this.psDepSlnSysAS.getSERVICECONTAINER();
        this.iPSDepSysVer = this.getPSDepSlnSys().getPSDepSysVer();
        if (!StringHelper.isNullOrEmpty((String)this.psDepSlnSysAS.getPSDEPSYSAPPID())) {
            this.iPSDepSysApp = this.getPSDepSysVer().getPSDepSysApp(this.psDepSlnSysAS.getPSDEPSYSAPPID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDepSlnSysAS.getNO2PSDEPSYSAPPID())) {
            this.no2PSDepSysApp = this.getPSDepSysVer().getPSDepSysApp(this.psDepSlnSysAS.getNO2PSDEPSYSAPPID());
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDEPSLNSYSAS";
    }

    @Override
    public String getServiceContainer() {
        return this.strServiceContainer;
    }

    @Override
    public IPSDepSysVer getPSDepSysVer() {
        return this.iPSDepSysVer;
    }

    @Override
    public IPSDepSysApp getPSDepSysApp() {
        return this.iPSDepSysApp;
    }

    @Override
    public IPSDepSysApp getNo2PSDepSysApp() {
        return this.no2PSDepSysApp;
    }

    @Override
    public IPSDepSlnASGroup getPSDepSlnASGroup() {
        return this.iPSDepSlnASGroup;
    }

    @Override
    public IPSDepSlnAS getPSDepSlnAS() {
        return this.iPSDepSlnAS;
    }

    @Override
    public String getContainerType() {
        return this.strContainerType;
    }
}

