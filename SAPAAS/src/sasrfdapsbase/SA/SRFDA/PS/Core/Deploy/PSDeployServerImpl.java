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

import SA.SRFDA.PS.Core.Deploy.IPSDeployServer;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSDeployServer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDeployServerImpl
extends PSDCResObjectImplBase
implements IPSDeployServer {
    private static final Log log = LogFactory.getLog(PSDeployServerImpl.class);
    protected PSDeployServer psDeployServer = null;
    private String strSSHIpAddr = null;
    private int nSSHPort = 22;
    private String strLocalSSHIpAddr = null;
    private int nLocalSSHPort = 22;
    private String strSSHUserName = null;
    private String strSSHPassword = null;
    private String strUploadMode = "SSH";
    private String strUploadPath = null;
    private String strWorkshopPath = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDeployServer psDeployServer) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDeployServer = psDeployServer;
        this.setId(this.psDeployServer.getPSDEPLOYSERVERID());
        this.setName(this.psDeployServer.getPSDEPLOYSERVERNAME());
        this.setPSObjectData(this.psDeployServer);
        this.strLocalSSHIpAddr = this.psDeployServer.getIPADDR();
        if (!this.psDeployServer.isPORTNull()) {
            this.nLocalSSHPort = this.psDeployServer.getPORT();
        }
        this.strSSHIpAddr = this.psDeployServer.getSSHIPADDR();
        if (!this.psDeployServer.isSSHPORTNull()) {
            this.nSSHPort = this.psDeployServer.getSSHPORT();
        }
        if (StringHelper.isNullOrEmpty((String)this.strSSHIpAddr)) {
            this.strSSHIpAddr = this.strLocalSSHIpAddr;
        }
        this.setRemoteAddress(this.strSSHIpAddr);
        this.setRemotePort(this.nSSHPort);
        this.strSSHUserName = this.psDeployServer.getUSERNAME();
        this.strSSHPassword = this.psDeployServer.getPASSWD();
        this.setRemoteUserName(this.strSSHUserName);
        this.setRemotePassword(this.strSSHPassword);
        if (!StringHelper.isNullOrEmpty((String)this.psDeployServer.getUPLOADFILEMODE())) {
            this.strUploadMode = this.psDeployServer.getUPLOADFILEMODE();
        }
        this.strUploadPath = this.psDeployServer.getUPLOADPATH();
        this.strWorkshopPath = this.psDeployServer.getWORKSHOPPATH();
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
        return "PSDEPLOYSERVER";
    }

    @Override
    protected void onFillResCfgParams(Map<String, String> params) throws Exception {
        super.onFillResCfgParams(params);
        if (this.getUploadMode() != null) {
            params.put("deps.uploadmode", this.getUploadMode());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getUploadPath())) {
            params.put("deps.unloadpath", this.getUploadPath());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getWorkshopPath())) {
            params.put("deps.workshop", this.getWorkshopPath());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getLocalSSHIPAddr())) {
            params.put("host.addr2", this.getLocalSSHIPAddr());
            params.put("host.port2", StringHelper.format((String)"%1$s", (Object)this.getLocalSSHPort()));
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
}

