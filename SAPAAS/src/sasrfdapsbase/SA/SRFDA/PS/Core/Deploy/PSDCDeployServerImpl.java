/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDCDeployServer;
import SA.SRFDA.PS.Core.Deploy.IPSDeployServer;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Data.PSDCDeployServer;
import SA.SRFDA.PS.Data.PSDeployServer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.sql.Timestamp;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;

public class PSDCDeployServerImpl
extends PSDCResObjectImplBase
implements IPSDCDeployServer {
    protected PSDCDeployServer psDCDeployServer = null;
    private String strSSHIpAddr = null;
    private int nSSHPort = 22;
    private String strSSHUserName = null;
    private String strSSHPassword = null;
    private String strUploadMode = "SSH";
    private IPSDeployServer iPSDeployServer = null;
    private String strUploadPath = null;
    private String strWorkshopPath = null;
    private String strLocalSSHIpAddr = null;
    private int nLocalSSHPort = 22;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDCDeployServer psDCDeployServer) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDCDeployServer = psDCDeployServer;
        this.setId(this.psDCDeployServer.getPSDCDEPLOYSERVERID());
        this.setName(this.psDCDeployServer.getPSDCDEPLOYSERVERNAME());
        this.setPSObjectData(this.psDCDeployServer);
        if (this.psDCDeployServer.getEXPRIEDTIME() != null) {
            this.setExpiredTime(new Timestamp(this.psDCDeployServer.getEXPRIEDTIME().getTime()));
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCDeployServer.getPSDEPLOYSERVERID())) {
            this.iPSDeployServer = this.getPSModelStorage().getPSDeployServer(this.psDCDeployServer.getPSDEPLOYSERVERID());
            this.setRemoteAddress(this.iPSDeployServer.getRemoteAddress());
            this.setRemoteUserName(this.iPSDeployServer.getRemoteUserName());
            this.setRemotePassword(this.iPSDeployServer.getRemotePassword());
            this.setRemotePort(this.iPSDeployServer.getRemotePort());
            this.setRemoteUploadMode(this.iPSDeployServer.getRemoteUploadMode());
            this.setRemoteUploadPath(this.iPSDeployServer.getRemoteUploadPath());
            this.setLocalRes(this.iPSDeployServer.isLocalRes());
        } else {
            this.strLocalSSHIpAddr = this.psDCDeployServer.getIPADDR();
            if (!this.psDCDeployServer.isPORTNull()) {
                this.nLocalSSHPort = this.psDCDeployServer.getPORT();
            }
            this.strSSHIpAddr = this.psDCDeployServer.getSSHIPADDR();
            if (!this.psDCDeployServer.isSSHPORTNull()) {
                this.nSSHPort = this.psDCDeployServer.getSSHPORT();
            }
            if (StringHelper.isNullOrEmpty((String)this.strSSHIpAddr)) {
                this.strSSHIpAddr = this.strLocalSSHIpAddr;
            }
            this.setRemoteAddress(this.strSSHIpAddr);
            this.setRemotePort(this.nSSHPort);
            this.strSSHUserName = this.psDCDeployServer.getUSERNAME();
            this.strSSHPassword = this.psDCDeployServer.getPASSWD();
            this.setRemoteUserName(this.strSSHUserName);
            this.setRemotePassword(this.strSSHPassword);
            if (!StringHelper.isNullOrEmpty((String)this.psDCDeployServer.getUPLOADFILEMODE())) {
                this.strUploadMode = this.psDCDeployServer.getUPLOADFILEMODE();
            }
            this.setResPos(2);
        }
        if (!this.psDCDeployServer.isRESPOSNull()) {
            this.setResPos(this.psDCDeployServer.getRESPOS());
        }
        if (!this.psDCDeployServer.isRESSTATENull()) {
            this.setResState(this.psDCDeployServer.getRESSTATE());
        }
        this.strUploadPath = this.psDCDeployServer.getUPLOADPATH();
        this.strWorkshopPath = this.psDCDeployServer.getWORKSHOPPATH();
        this.onInit();
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDeployServer psDCDeployServer) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getSSHIPAddr() {
        if (this.iPSDeployServer != null) {
            return this.iPSDeployServer.getSSHIPAddr();
        }
        return this.strSSHIpAddr;
    }

    @Override
    public int getSSHPort() {
        if (this.iPSDeployServer != null) {
            return this.iPSDeployServer.getSSHPort();
        }
        return this.nSSHPort;
    }

    @Override
    public String getSSHUserName() {
        if (this.iPSDeployServer != null) {
            return this.iPSDeployServer.getSSHUserName();
        }
        return this.strSSHUserName;
    }

    @Override
    public String getSSHPassword() {
        if (this.iPSDeployServer != null) {
            return this.iPSDeployServer.getSSHPassword();
        }
        return this.strSSHPassword;
    }

    @Override
    public String getUploadMode() {
        if (this.iPSDeployServer != null) {
            return this.iPSDeployServer.getUploadMode();
        }
        return this.strUploadMode;
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
    public String getModelType() {
        return "PSDCDEPLOYSERVER";
    }

    @Override
    public String getUploadPath() {
        if (this.iPSDeployServer != null) {
            return this.iPSDeployServer.getUploadPath();
        }
        return this.strUploadPath;
    }

    @Override
    public String getWorkshopPath() {
        if (this.iPSDeployServer != null) {
            return this.iPSDeployServer.getWorkshopPath();
        }
        return this.strWorkshopPath;
    }

    @Override
    public String getLocalSSHIPAddr() {
        if (this.iPSDeployServer != null) {
            return this.iPSDeployServer.getLocalSSHIPAddr();
        }
        return this.strLocalSSHIpAddr;
    }

    @Override
    public int getLocalSSHPort() {
        if (this.iPSDeployServer != null) {
            return this.iPSDeployServer.getLocalSSHPort();
        }
        return this.nLocalSSHPort;
    }
}

