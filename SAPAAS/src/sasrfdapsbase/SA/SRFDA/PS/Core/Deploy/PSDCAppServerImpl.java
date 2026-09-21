/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSAppServer;
import SA.SRFDA.PS.Core.Deploy.IPSDCAppServer;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSAppServer;
import SA.SRFDA.PS.Data.PSDevCenterAS;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.sql.Timestamp;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;

public class PSDCAppServerImpl
extends PSDCResObjectImplBase
implements IPSDCAppServer {
    protected PSDevCenterAS psDevCenterAS = null;
    private String strSSHIpAddr = null;
    private int nSSHPort = 22;
    private String strSSHUserName = null;
    private String strSSHPassword = null;
    private boolean bRemoteDeploy = false;
    private String strASType = null;
    private String strUploadMode = "SSH";
    private IPSAppServer iPSAppServer = null;
    private int nHttpPort = 8080;
    private int nHttpsPort = -1;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDevCenterAS psDevCenterAS) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDevCenterAS = psDevCenterAS;
        this.setId(this.psDevCenterAS.getPSDEVCENTERASID());
        this.setName(this.psDevCenterAS.getPSDEVCENTERASNAME());
        this.setPSObjectData(this.psDevCenterAS);
        if (this.psDevCenterAS.getEXPRIEDTIME() != null) {
            this.setExpiredTime(new Timestamp(this.psDevCenterAS.getEXPRIEDTIME().getTime()));
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDevCenterAS.getPSAPPSERVERID())) {
            this.iPSAppServer = this.getPSModelStorage().getPSAppServer(this.psDevCenterAS.getPSAPPSERVERID());
            this.setRemoteAddress(this.iPSAppServer.getRemoteAddress());
            this.setRemoteUserName(this.iPSAppServer.getRemoteUserName());
            this.setRemotePassword(this.iPSAppServer.getRemotePassword());
            this.setRemotePort(this.iPSAppServer.getRemotePort());
            this.setRemoteUploadMode(this.iPSAppServer.getRemoteUploadMode());
            this.setRemoteUploadPath(this.iPSAppServer.getRemoteUploadPath());
            this.setLocalRes(this.iPSAppServer.isLocalRes());
        } else {
            this.strASType = this.psDevCenterAS.getASTYPE();
            this.strSSHIpAddr = this.psDevCenterAS.getHOSTADDRESS();
            this.setRemoteAddress(this.strSSHIpAddr);
            if (!this.psDevCenterAS.isHOSTPORTNull()) {
                this.nSSHPort = this.psDevCenterAS.getHOSTPORT();
                this.setRemotePort(this.nSSHPort);
            }
            this.strSSHUserName = this.psDevCenterAS.getHOSTUSERNAME();
            this.strSSHPassword = this.psDevCenterAS.getHOSTPASSWD();
            this.setRemoteUserName(this.strSSHUserName);
            this.setRemotePassword(this.strSSHPassword);
            this.bRemoteDeploy = true;
            this.setResPos(2);
            if (!StringHelper.isNullOrEmpty((String)this.psDevCenterAS.getUPLOADFILEMODE())) {
                this.strUploadMode = this.psDevCenterAS.getUPLOADFILEMODE();
            }
            if (!this.psDevCenterAS.isHTTPPORTNull()) {
                this.nHttpPort = this.psDevCenterAS.getHTTPPORT();
            }
            if (!this.psDevCenterAS.isHTTPSPORTNull()) {
                this.nHttpsPort = this.psDevCenterAS.getHTTPSPORT();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDevCenterAS.getUPLOADPATH())) {
                this.setRemoteUploadPath(this.psDevCenterAS.getUPLOADPATH());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDevCenterAS.getUPLOADFILEMODE())) {
                this.setRemoteUploadMode(this.psDevCenterAS.getUPLOADFILEMODE());
            }
        }
        if (!this.psDevCenterAS.isRESPOSNull()) {
            this.setResPos(this.psDevCenterAS.getRESPOS());
        }
        if (!this.psDevCenterAS.isRESSTATENull()) {
            this.setResState(this.psDevCenterAS.getRESSTATE());
        }
        this.onInit();
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSAppServer psDevCenterAS) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getAppFolder() {
        if (this.iPSAppServer != null) {
            return this.iPSAppServer.getAppFolder();
        }
        return this.psDevCenterAS.getASINSTALLPATH();
    }

    @Override
    public String getSSHIPAddr() {
        if (this.iPSAppServer != null) {
            return this.iPSAppServer.getSSHIPAddr();
        }
        return this.strSSHIpAddr;
    }

    @Override
    public int getSSHPort() {
        if (this.iPSAppServer != null) {
            return this.iPSAppServer.getSSHPort();
        }
        return this.nSSHPort;
    }

    @Override
    public String getSSHUserName() {
        if (this.iPSAppServer != null) {
            return this.iPSAppServer.getSSHUserName();
        }
        return this.strSSHUserName;
    }

    @Override
    public String getSSHPassword() {
        if (this.iPSAppServer != null) {
            return this.iPSAppServer.getSSHPassword();
        }
        return this.strSSHPassword;
    }

    @Override
    public boolean isRemoteDeploy() {
        if (this.iPSAppServer != null) {
            return this.iPSAppServer.isRemoteDeploy();
        }
        return this.bRemoteDeploy;
    }

    @Override
    public String getASType() {
        if (this.iPSAppServer != null) {
            return this.iPSAppServer.getASType();
        }
        return this.strASType;
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u4f20\u6a21\u5f0f", codelist="ASFileUploadMode")
    public String getUploadMode() {
        if (this.iPSAppServer != null) {
            return this.iPSAppServer.getUploadMode();
        }
        return this.strUploadMode;
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
    @PSModelRTMeta(description="Http\u7aef\u53e3")
    public int getHttpPort() {
        if (this.iPSAppServer != null) {
            return this.iPSAppServer.getHttpPort();
        }
        return this.nHttpPort;
    }

    @Override
    public int getHttpsPort() {
        if (this.iPSAppServer != null) {
            return this.iPSAppServer.getHttpsPort();
        }
        return this.nHttpsPort;
    }

    @Override
    public String getModelType() {
        return "PSDEVCENTERAS";
    }

    @Override
    public boolean isTimeShareRes() {
        if (this.iPSAppServer != null) {
            return this.iPSAppServer.isTimeShareRes();
        }
        return false;
    }
}

