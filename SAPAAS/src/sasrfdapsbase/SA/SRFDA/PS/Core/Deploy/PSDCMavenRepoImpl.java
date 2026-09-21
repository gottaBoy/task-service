/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDCMavenRepo;
import SA.SRFDA.PS.Core.Deploy.IPSMavenServer;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDCMavenRepo;
import SA.SRFDA.PS.Data.PSMavenRepo;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCMavenRepoImpl
extends PSDCResObjectImplBase
implements IPSDCMavenRepo {
    private static final Log log = LogFactory.getLog(PSDCMavenRepoImpl.class);
    protected PSDCMavenRepo psDCMavenRepo = null;
    private String strMavenServerType = "NEXUS";
    private String strConnStr = "";
    private String strUserName = null;
    private String strPassword = null;
    private String strAdminUserName = null;
    private String strAdminPassword = null;
    private IPSMavenServer iPSMavenServer = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDCMavenRepo psDCMavenRepo) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDCMavenRepo = psDCMavenRepo;
        this.setId(this.psDCMavenRepo.getPSDCMAVENREPOID());
        this.setName(this.psDCMavenRepo.getPSDCMAVENREPONAME());
        this.setPSObjectData(this.psDCMavenRepo);
        this.strUserName = psDCMavenRepo.getROUSERNAME();
        this.strPassword = psDCMavenRepo.getROPASSWD();
        this.strAdminUserName = psDCMavenRepo.getMAVENUSERNAME();
        this.strAdminPassword = psDCMavenRepo.getMAVENPASSWD();
        this.strConnStr = this.psDCMavenRepo.getCONNSTR();
        this.setLocalRes(false);
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8fde\u63a5\u4e32")
    public String getConnStr() {
        return this.strConnStr;
    }

    protected void setConnStr(String strConnStr) {
        this.strConnStr = strConnStr;
    }

    @Override
    @PSModelRTMeta(description="\u7248\u672c\u5e93\u7c7b\u578b")
    public String getMavenServerType() {
        return this.strMavenServerType;
    }

    protected void setMavenServerType(String strMavenServerType) {
        this.strMavenServerType = strMavenServerType;
    }

    @Override
    public String getUserName() {
        return this.strUserName;
    }

    @Override
    public String getPassword() {
        return this.strPassword;
    }

    protected void setUserName(String strUserName) {
        this.strUserName = strUserName;
    }

    protected void setPassword(String strPassword) {
        this.strPassword = strPassword;
    }

    @Override
    public IPSMavenServer getPSMavenServer() {
        return this.iPSMavenServer;
    }

    @Override
    public String getAdminUserName() {
        return this.strAdminUserName;
    }

    @Override
    public String getAdminPassword() {
        return this.strAdminPassword;
    }

    protected void setAdminUserName(String strAdminUserName) {
        this.strAdminUserName = strAdminUserName;
    }

    protected void setAdminPassword(String strAdminPassword) {
        this.strAdminPassword = strAdminPassword;
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSMavenRepo psMavenRepo) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }
}

