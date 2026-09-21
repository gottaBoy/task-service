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

import SA.SRFDA.PS.Core.Deploy.IPSAppServer;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSAppServer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppServerImpl
extends PSDCResObjectImplBase
implements IPSAppServer {
    private static final Log log = LogFactory.getLog(PSAppServerImpl.class);
    protected PSAppServer psAppServer = null;
    private String strSSHIpAddr = null;
    private int nSSHPort = 22;
    private String strSSHUserName = null;
    private String strSSHPassword = null;
    private boolean bRemoteDeploy = false;
    private String strASType = null;
    private String strUploadMode = "SSH";
    private int nHttpPort = 8080;
    private int nHttpsPort = -1;
    private boolean bTimeShareRes = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSAppServer psAppServer) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psAppServer = psAppServer;
        this.setId(this.psAppServer.getPSAPPSERVERID());
        this.setName(this.psAppServer.getPSAPPSERVERNAME());
        this.setPSObjectData(this.psAppServer);
        this.strASType = this.psAppServer.getASTYPE();
        if (!StringHelper.isNullOrEmpty((String)this.psAppServer.getSSHIPADDR())) {
            this.strSSHIpAddr = this.psAppServer.getSSHIPADDR();
            this.setRemoteAddress(this.strSSHIpAddr);
            if (!this.psAppServer.isSSHPORTNull()) {
                this.nSSHPort = this.psAppServer.getSSHPORT();
                this.setRemotePort(this.nSSHPort);
            }
            this.strSSHUserName = this.psAppServer.getUSERNAME();
            this.strSSHPassword = this.psAppServer.getPASSWD();
            this.setRemoteUserName(this.strSSHUserName);
            this.setRemotePassword(this.strSSHPassword);
            this.bRemoteDeploy = true;
        }
        if (!StringHelper.isNullOrEmpty((String)this.psAppServer.getUPLOADFILEMODE())) {
            this.strUploadMode = this.psAppServer.getUPLOADFILEMODE();
        }
        if (!this.psAppServer.isHTTPPORTNull()) {
            this.nHttpPort = this.psAppServer.getHTTPPORT();
        }
        if (!this.psAppServer.isHTTPSPORTNull()) {
            this.nHttpsPort = this.psAppServer.getHTTPSPORT();
        }
        if (!this.psAppServer.isLOCALRESNull()) {
            this.setLocalRes(this.psAppServer.getLOCALRES());
        }
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getAppFolder() {
        return this.psAppServer.getAPPFOLDER();
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
    public boolean isRemoteDeploy() {
        return this.bRemoteDeploy;
    }

    @Override
    public String getASType() {
        return this.strASType;
    }

    @Override
    public String getUploadMode() {
        return this.strUploadMode;
    }

    @Override
    public int getHttpPort() {
        return this.nHttpPort;
    }

    @Override
    public int getHttpsPort() {
        return this.nHttpsPort;
    }

    @Override
    public String getModelType() {
        return "PSAPPSERVER";
    }

    @Override
    protected void onFillResCfgParams(Map<String, String> params) throws Exception {
        super.onFillResCfgParams(params);
        if (this.getASType() != null) {
            params.put("as.type", this.getASType());
        }
        if (this.getUploadMode() != null) {
            params.put("as.uploadmode", this.getUploadMode());
        }
        if (this.getAppFolder() != null) {
            params.put("as.path", this.getAppFolder());
        }
        if (this.getHttpPort() > 0) {
            params.put("as.http", Integer.toString(this.getHttpPort()));
        }
        if (this.getHttpsPort() > 0) {
            params.put("as.https", Integer.toString(this.getHttpsPort()));
        }
        params.put("as.remote", Boolean.toString(this.isRemoteDeploy()));
    }

    @Override
    public boolean isTimeShareRes() {
        return this.bTimeShareRes;
    }
}

