/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDevSlnSysWSGit;
import SA.SRFDA.PS.Core.Deploy.IPSWorkshopServer;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSDevSlnSysRuntime;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDevSlnSysWSGit;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDevSlnSysWSGitImpl
extends PSObjectImpl
implements IPSDevSlnSysWSGit {
    private static final Log log = LogFactory.getLog(PSDevSlnSysWSGitImpl.class);
    protected PSDevSlnSysWSGit psDevSlnSysWSGit = null;
    private IPSDevSlnSys iPSDevSlnSys = null;
    private String strGitUserName = null;
    private String strGitPassword = null;
    private String strGitPath = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDevSlnSys iPSDevSlnSys, PSDevSlnSysWSGit psDevSlnSysWSGit) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDevSlnSysWSGit = psDevSlnSysWSGit;
        this.iPSDevSlnSys = iPSDevSlnSys;
        this.setId(this.psDevSlnSysWSGit.getPSDEVSLNSYSWSGITID());
        this.setName(this.psDevSlnSysWSGit.getPSDEVSLNSYSWSGITNAME());
        this.setPSObjectData(this.psDevSlnSysWSGit);
        this.strGitPath = psDevSlnSysWSGit.getGITPATH();
        if (StringHelper.IsNullOrEmpty((String)this.strGitPath)) {
            this.strGitPath = String.valueOf(this.getPSWorkshopServer().getGitPath()) + "/" + this.getName();
        }
        this.strGitUserName = psDevSlnSysWSGit.getGITUSERNAME();
        this.strGitPassword = psDevSlnSysWSGit.getGITPASSWORD();
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDEVSLNSYSWSGIT";
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public IPSDevSlnSys getPSDevSlnSys() throws Exception {
        return this.iPSDevSlnSys;
    }

    @Override
    public IPSWorkshopServer getPSWorkshopServer() throws Exception {
        if (this.getPSDevSlnSys() != null) {
            return ((IPSDevSlnSysRuntime)((Object)this.getPSDevSlnSys())).getPSWorkshopServer();
        }
        return null;
    }

    @Override
    public String getGitPath() {
        return this.strGitPath;
    }

    @Override
    public String getGitUserName() {
        return this.strGitUserName;
    }

    @Override
    public String getGitPassword() {
        return this.strGitPassword;
    }
}

