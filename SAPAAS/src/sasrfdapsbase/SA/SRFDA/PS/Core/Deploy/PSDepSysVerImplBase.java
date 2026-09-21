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

import SA.SRFDA.PS.Core.Deploy.IPSDepSysApp;
import SA.SRFDA.PS.Core.Deploy.IPSDepSysVer;
import SA.SRFDA.PS.Core.Deploy.PSDepSysAppGlobalModel;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDepSysVer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDepSysVerImplBase
extends PSObjectImpl
implements IPSDepSysVer {
    private static final Log log = LogFactory.getLog(PSDepSysVerImplBase.class);
    protected PSDepSysVer psDepSysVer = null;
    protected String strPSDepSysId = "";
    protected String strPSDepSysName = "";
    private String strPSDevSlnSysId = "";
    private PSDepSysAppGlobalModel psDepSysAppGlobalModel = new PSDepSysAppGlobalModel();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDepSysVer psDepSysVer) throws Exception {
        this.psDepSysVer = psDepSysVer;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDepSysVer.getPSDEPSYSVERID());
        this.setName(psDepSysVer.getPSDEPSYSVERNAME());
        this.setPSObjectData(this.psDepSysVer);
        this.strPSDepSysId = this.psDepSysVer.getPSDEPSYSID();
        this.strPSDepSysName = this.psDepSysVer.getPSDEPSYSNAME();
        this.strPSDevSlnSysId = this.psDepSysVer.getPSDEVSLNSYSID();
        if (StringHelper.isNullOrEmpty((String)this.strPSDevSlnSysId)) {
            this.strPSDevSlnSysId = psDepSysVer.getPSDEPSYSVERID();
        }
        this.psDepSysAppGlobalModel.Init(iDAGlobalHelper, this);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDEPSYSVER";
    }

    @Override
    public String getPSDepSysId() {
        return this.strPSDepSysId;
    }

    @Override
    public String getPSDepSysName() {
        return this.strPSDepSysName;
    }

    @Override
    public Iterator<IPSDepSysApp> getAllPSDepSysApps() throws Exception {
        return this.psDepSysAppGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDepSysApp getPSDepSysApp(String strDepSysAppId) throws Exception {
        return (IPSDepSysApp)this.psDepSysAppGlobalModel.FindModelHelper(strDepSysAppId);
    }

    @Override
    public void resetPSDepSysApp(String strDepSysAppId) throws Exception {
        this.psDepSysAppGlobalModel.ResetModel(strDepSysAppId);
    }

    @Override
    public void resetAllPSDepSysApps() {
        this.psDepSysAppGlobalModel.ResetAll();
    }

    @Override
    public String getPSDevSlnSysId() {
        return this.strPSDevSlnSysId;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

