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

import SA.SRFDA.PS.Core.Deploy.IPSMobAppPackServer;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSMobAppPackServer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSMobAppPackServerImpl
extends PSDCResObjectImplBase
implements IPSMobAppPackServer {
    private static final Log log = LogFactory.getLog(PSMobAppPackServerImpl.class);
    protected PSMobAppPackServer psMobAppPackServer = null;
    private String strSSHIpAddr = null;
    private int nSSHPort = 22;
    private String strSSHUserName = null;
    private String strSSHPassword = null;
    private String strUploadMode = "SSH";
    private String strUploadPath = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSMobAppPackServer psMobAppPackServer) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psMobAppPackServer = psMobAppPackServer;
        this.setId(this.psMobAppPackServer.getPSMOBAPPPACKSERVERID());
        this.setName(this.psMobAppPackServer.getPSMOBAPPPACKSERVERNAME());
        this.setPSObjectData(this.psMobAppPackServer);
        if (!StringHelper.isNullOrEmpty((String)this.psMobAppPackServer.getIPADDR())) {
            this.strSSHIpAddr = this.psMobAppPackServer.getIPADDR();
            this.setRemoteAddress(this.strSSHIpAddr);
            if (!this.psMobAppPackServer.isPORTNull()) {
                this.nSSHPort = this.psMobAppPackServer.getPORT();
                this.setRemotePort(this.nSSHPort);
            }
            this.strSSHUserName = this.psMobAppPackServer.getUSERNAME();
            this.strSSHPassword = this.psMobAppPackServer.getPASSWD();
            this.setRemoteUserName(this.strSSHUserName);
            this.setRemotePassword(this.strSSHPassword);
        }
        if (!StringHelper.isNullOrEmpty((String)this.psMobAppPackServer.getUPLOADFILEMODE())) {
            this.strUploadMode = this.psMobAppPackServer.getUPLOADFILEMODE();
        }
        this.strUploadPath = this.psMobAppPackServer.getUPLOADPATH();
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
        return "PSMOBAPPPACKSERVER";
    }

    @Override
    protected void onFillResCfgParams(Map<String, String> params) throws Exception {
        super.onFillResCfgParams(params);
        if (this.getUploadMode() != null) {
            params.put("maps.uploadmode", this.getUploadMode());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getUploadPath())) {
            params.put("maps.unloadpath", this.getUploadPath());
        }
    }

    @Override
    public String getUploadPath() {
        return this.strUploadPath;
    }
}

