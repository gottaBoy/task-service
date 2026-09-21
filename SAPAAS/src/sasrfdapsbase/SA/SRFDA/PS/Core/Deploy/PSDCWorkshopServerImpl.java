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

import SA.SRFDA.PS.Core.Deploy.IPSDCWorkshopServer;
import SA.SRFDA.PS.Core.Deploy.IPSSVNServer;
import SA.SRFDA.PS.Core.Deploy.IPSWorkshopServer;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDCWorkshopServer;
import SA.SRFDA.PS.Data.PSWorkshopServer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.sql.Timestamp;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCWorkshopServerImpl
extends PSDCResObjectImplBase
implements IPSDCWorkshopServer {
    private static final Log log = LogFactory.getLog(PSDCWorkshopServerImpl.class);
    protected PSDCWorkshopServer psDCWorkshopServer = null;
    private String strSSHIpAddr = null;
    private int nSSHPort = 22;
    private String strSSHUserName = null;
    private String strSSHPassword = null;
    private String strUploadMode = "SSH";
    private IPSWorkshopServer iPSWorkshopServer = null;
    private String strUploadPath = null;
    private String strWorkshopPath = null;
    private String strLocalSSHIpAddr = null;
    private int nLocalSSHPort = 22;
    private String strGitPath = null;
    private String strGitUserName = null;
    private String strGitPassword = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDCWorkshopServer psDCWorkshopServer) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDCWorkshopServer = psDCWorkshopServer;
        this.setId(this.psDCWorkshopServer.getPSDCWORKSHOPSERVERID());
        this.setName(this.psDCWorkshopServer.getPSDCWORKSHOPSERVERNAME());
        this.setPSObjectData(this.psDCWorkshopServer);
        if (this.psDCWorkshopServer.getEXPRIEDTIME() != null) {
            this.setExpiredTime(new Timestamp(this.psDCWorkshopServer.getEXPRIEDTIME().getTime()));
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCWorkshopServer.getPSWORKSHOPSERVERID())) {
            this.iPSWorkshopServer = this.getPSModelStorage().getPSWorkshopServer(this.psDCWorkshopServer.getPSWORKSHOPSERVERID());
            this.setRemoteAddress(this.iPSWorkshopServer.getRemoteAddress());
            this.setRemoteUserName(this.iPSWorkshopServer.getRemoteUserName());
            this.setRemotePassword(this.iPSWorkshopServer.getRemotePassword());
            this.setRemotePort(this.iPSWorkshopServer.getRemotePort());
            this.setRemoteUploadMode(this.iPSWorkshopServer.getRemoteUploadMode());
            this.setRemoteUploadPath(this.iPSWorkshopServer.getRemoteUploadPath());
            this.setLocalRes(this.iPSWorkshopServer.isLocalRes());
        } else {
            this.strLocalSSHIpAddr = this.psDCWorkshopServer.getIPADDR();
            if (!this.psDCWorkshopServer.isPORTNull()) {
                this.nLocalSSHPort = this.psDCWorkshopServer.getPORT();
            }
            this.strSSHIpAddr = this.psDCWorkshopServer.getSSHIPADDR();
            if (!this.psDCWorkshopServer.isSSHPORTNull()) {
                this.nSSHPort = this.psDCWorkshopServer.getSSHPORT();
            }
            if (StringHelper.isNullOrEmpty((String)this.strSSHIpAddr)) {
                this.strSSHIpAddr = this.strLocalSSHIpAddr;
            }
            this.setRemoteAddress(this.strSSHIpAddr);
            this.setRemotePort(this.nSSHPort);
            this.strSSHUserName = this.psDCWorkshopServer.getUSERNAME();
            this.strSSHPassword = this.psDCWorkshopServer.getPASSWD();
            this.setRemoteUserName(this.strSSHUserName);
            this.setRemotePassword(this.strSSHPassword);
            if (!StringHelper.isNullOrEmpty((String)this.psDCWorkshopServer.getUPLOADFILEMODE())) {
                this.strUploadMode = this.psDCWorkshopServer.getUPLOADFILEMODE();
            }
            this.setResPos(2);
            this.strGitPath = this.psDCWorkshopServer.getGITPATH();
            this.strGitUserName = this.psDCWorkshopServer.getGITUSERNAME();
            this.strGitPassword = this.psDCWorkshopServer.getGITPASSWORD();
            this.strUploadPath = this.psDCWorkshopServer.getUPLOADPATH();
            this.setRemoteUploadMode(this.strUploadMode);
            this.setRemoteUploadPath(this.strUploadPath);
        }
        if (!this.psDCWorkshopServer.isRESPOSNull()) {
            this.setResPos(this.psDCWorkshopServer.getRESPOS());
        }
        if (!this.psDCWorkshopServer.isRESSTATENull()) {
            this.setResState(this.psDCWorkshopServer.getRESSTATE());
        }
        this.strWorkshopPath = this.psDCWorkshopServer.getWORKSHOPPATH();
        this.onInit();
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSWorkshopServer psDCWorkshopServer) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getSSHIPAddr() {
        if (this.iPSWorkshopServer != null) {
            return this.iPSWorkshopServer.getSSHIPAddr();
        }
        return this.strSSHIpAddr;
    }

    @Override
    public int getSSHPort() {
        if (this.iPSWorkshopServer != null) {
            return this.iPSWorkshopServer.getSSHPort();
        }
        return this.nSSHPort;
    }

    @Override
    public String getSSHUserName() {
        if (this.iPSWorkshopServer != null) {
            return this.iPSWorkshopServer.getSSHUserName();
        }
        return this.strSSHUserName;
    }

    @Override
    public String getSSHPassword() {
        if (this.iPSWorkshopServer != null) {
            return this.iPSWorkshopServer.getSSHPassword();
        }
        return this.strSSHPassword;
    }

    @Override
    public String getUploadMode() {
        if (this.iPSWorkshopServer != null) {
            return this.iPSWorkshopServer.getUploadMode();
        }
        return this.strUploadMode;
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
        if (!StringHelper.isNullOrEmpty((String)this.strGitPath)) {
            params.put("ws.gitpath", this.strGitPath);
            if (!StringHelper.isNullOrEmpty((String)this.strGitUserName)) {
                params.put("ws.gituser", this.strGitUserName);
            }
            if (!StringHelper.isNullOrEmpty((String)this.strGitPassword)) {
                params.put("ws.gitpass", this.strGitPassword);
            }
        }
    }

    @Override
    public String getModelType() {
        return "PSDCWORKSHOPSERVER";
    }

    @Override
    public String getUploadPath() {
        if (this.iPSWorkshopServer != null) {
            return this.iPSWorkshopServer.getUploadPath();
        }
        return this.strUploadPath;
    }

    @Override
    public String getWorkshopPath() {
        if (this.iPSWorkshopServer != null) {
            return this.iPSWorkshopServer.getWorkshopPath();
        }
        return this.strWorkshopPath;
    }

    @Override
    public String getLocalSSHIPAddr() {
        if (this.iPSWorkshopServer != null) {
            return this.iPSWorkshopServer.getLocalSSHIPAddr();
        }
        return this.strLocalSSHIpAddr;
    }

    @Override
    public int getLocalSSHPort() {
        if (this.iPSWorkshopServer != null) {
            return this.iPSWorkshopServer.getLocalSSHPort();
        }
        return this.nLocalSSHPort;
    }

    @Override
    @PSModelRTMeta(description="Git\u5e93\u8def\u5f84")
    public String getGitPath() {
        if (this.iPSWorkshopServer != null) {
            return this.iPSWorkshopServer.getGitPath();
        }
        return this.strGitPath;
    }

    @Override
    public String getGitServerId() {
        if (this.iPSWorkshopServer != null) {
            return this.iPSWorkshopServer.getGitServerId();
        }
        return null;
    }

    @Override
    public String getGitServerCfgFilePath() {
        if (this.iPSWorkshopServer != null) {
            return this.iPSWorkshopServer.getGitServerCfgFilePath();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7d20\u6750\u670d\u52a1\u5668", hideempty=true)
    public IPSSVNServer getPSSVNServer() {
        if (this.iPSWorkshopServer != null) {
            return this.iPSWorkshopServer.getPSSVNServer();
        }
        return null;
    }
}

