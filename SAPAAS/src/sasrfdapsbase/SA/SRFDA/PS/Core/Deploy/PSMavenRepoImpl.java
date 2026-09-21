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

import SA.SRFDA.PS.Core.Deploy.IPSMavenRepo;
import SA.SRFDA.PS.Core.Deploy.IPSMavenServer;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSMavenRepo;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSMavenRepoImpl
extends PSDCResObjectImplBase
implements IPSMavenRepo {
    private static final Log log = LogFactory.getLog(PSMavenRepoImpl.class);
    protected PSMavenRepo psMavenRepo = null;
    private String strMavenServerType = "NEXUS";
    private String strConnStr = "";
    private String strUserName = null;
    private String strPassword = null;
    private String strAdminUserName = null;
    private String strAdminPassword = null;
    private IPSMavenServer iPSMavenServer = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSMavenRepo psMavenRepo) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psMavenRepo = psMavenRepo;
        this.setId(this.psMavenRepo.getPSMAVENREPOID());
        this.setName(this.psMavenRepo.getPSMAVENREPONAME());
        this.setPSObjectData(this.psMavenRepo);
        this.strUserName = psMavenRepo.getROUSERNAME();
        this.strPassword = psMavenRepo.getROPASSWD();
        this.strAdminUserName = psMavenRepo.getMAVENUSERNAME();
        this.strAdminPassword = psMavenRepo.getMAVENPASSWD();
        this.strConnStr = this.psMavenRepo.getCONNSTR();
        if (!StringHelper.isNullOrEmpty((String)this.psMavenRepo.getPSMAVENSERVERID())) {
            this.iPSMavenServer = this.getPSModelStorage().getPSMavenServer(this.psMavenRepo.getPSMAVENSERVERID());
        }
        if (!this.psMavenRepo.isLOCALRESNull()) {
            this.setLocalRes(this.psMavenRepo.getLOCALRES());
        }
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
}

