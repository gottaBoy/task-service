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

import SA.SRFDA.PS.Core.Deploy.IPSSVNServer;
import SA.SRFDA.PS.Core.Deploy.IPSWorkshopServer;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSWorkshopServer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWorkshopServerImpl
extends PSDCResObjectImplBase
implements IPSWorkshopServer {
    private static final Log log = LogFactory.getLog(PSWorkshopServerImpl.class);
    protected PSWorkshopServer psWorkshopServer = null;
    private String strSSHIpAddr = null;
    private int nSSHPort = 22;
    private String strLocalSSHIpAddr = null;
    private int nLocalSSHPort = 22;
    private String strSSHUserName = null;
    private String strSSHPassword = null;
    private String strUploadMode = "SSH";
    private String strUploadPath = null;
    private String strWorkshopPath = null;
    private IPSSVNServer iPSSVNServer = null;
    private String strGitPath = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSWorkshopServer psWorkshopServer) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psWorkshopServer = psWorkshopServer;
        this.setId(this.psWorkshopServer.getPSWORKSHOPSERVERID());
        this.setName(this.psWorkshopServer.getPSWORKSHOPSERVERNAME());
        this.setPSObjectData(this.psWorkshopServer);
        if (!StringHelper.isNullOrEmpty((String)this.psWorkshopServer.getPSSVNSERVERID())) {
            this.iPSSVNServer = this.getPSModelStorage().getPSSVNServer(this.psWorkshopServer.getPSSVNSERVERID());
        }
        this.strLocalSSHIpAddr = this.psWorkshopServer.getIPADDR();
        if (!this.psWorkshopServer.isPORTNull()) {
            this.nLocalSSHPort = this.psWorkshopServer.getPORT();
        }
        this.strSSHIpAddr = this.psWorkshopServer.getSSHIPADDR();
        if (!this.psWorkshopServer.isSSHPORTNull()) {
            this.nSSHPort = this.psWorkshopServer.getSSHPORT();
        }
        if (StringHelper.isNullOrEmpty((String)this.strSSHIpAddr)) {
            this.strSSHIpAddr = this.strLocalSSHIpAddr;
        }
        this.setRemoteAddress(this.strSSHIpAddr);
        this.setRemotePort(this.nSSHPort);
        this.strSSHUserName = this.psWorkshopServer.getUSERNAME();
        this.strSSHPassword = this.psWorkshopServer.getPASSWD();
        this.setRemoteUserName(this.strSSHUserName);
        this.setRemotePassword(this.strSSHPassword);
        if (!StringHelper.isNullOrEmpty((String)this.psWorkshopServer.getUPLOADFILEMODE())) {
            this.strUploadMode = this.psWorkshopServer.getUPLOADFILEMODE();
        }
        this.strUploadPath = this.psWorkshopServer.getUPLOADPATH();
        this.strWorkshopPath = this.psWorkshopServer.getWORKSHOPPATH();
        if (this.iPSSVNServer != null) {
            this.strGitPath = this.iPSSVNServer.getGitPath();
        }
        this.setRemoteUploadMode(this.strUploadMode);
        this.setRemoteUploadPath(this.strUploadPath);
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getSSHIPAddr() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]getSSHIPAddr", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.strSSHIpAddr;
    }

    @Override
    public int getSSHPort() {
        return this.nSSHPort;
    }

    @Override
    public String getSSHUserName() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]getSSHUserName", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.strSSHUserName;
    }

    @Override
    public String getSSHPassword() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]getSSHPassword", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.strSSHPassword;
    }

    @Override
    public String getUploadMode() {
        return this.strUploadMode;
    }

    @Override
    public String getModelType() {
        return "PSWORKSHOPSERVER";
    }

    @Override
    protected void onFillResCfgParams(Map<String, String> params) throws Exception {
        super.onFillResCfgParams(params);
        if (this.getUploadMode() != null) {
            params.put("ws.uploadmode", this.getUploadMode());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getUploadPath())) {
            params.put("ws.unloadpath", this.getUploadPath());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getWorkshopPath())) {
            params.put("ws.workshop", this.getWorkshopPath());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getLocalSSHIPAddr())) {
            params.put("host.addr2", this.getLocalSSHIPAddr());
            params.put("host.port2", StringHelper.format((String)"%1$s", (Object)this.getLocalSSHPort()));
        }
        if (this.iPSSVNServer != null) {
            params.put("ws.gitserver", this.iPSSVNServer.getId());
        }
    }

    @Override
    public String getUploadPath() {
        return this.strUploadPath;
    }

    @Override
    public String getWorkshopPath() {
        return this.strWorkshopPath;
    }

    @Override
    public String getLocalSSHIPAddr() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]getLocalSSHIPAddr", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.strLocalSSHIpAddr;
    }

    @Override
    public int getLocalSSHPort() {
        return this.nLocalSSHPort;
    }

    @Override
    @PSModelRTMeta(description="Git\u5730\u5740")
    public String getGitPath() {
        return this.strGitPath;
    }

    @Override
    public String getGitServerId() {
        if (this.iPSSVNServer != null) {
            return this.iPSSVNServer.getId();
        }
        return null;
    }

    @Override
    public String getGitServerCfgFilePath() {
        if (this.iPSSVNServer != null) {
            return this.iPSSVNServer.getResCfgFilePath();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7d20\u6750\u670d\u52a1\u5668")
    public IPSSVNServer getPSSVNServer() {
        return this.iPSSVNServer;
    }
}

