/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDCMSPlatform;
import SA.SRFDA.PS.Core.Deploy.IPSDCMSPlatformNode;
import SA.SRFDA.PS.Core.Deploy.IPSMSPlatform;
import SA.SRFDA.PS.Core.Deploy.IPSMSPlatformNode;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Data.PSDCMSPlatformNode;
import SA.SRFDA.PS.Data.PSMSPlatformNode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;

public class PSDCMSPlatformNodeImpl
extends PSDCResObjectImplBase
implements IPSDCMSPlatformNode {
    protected PSDCMSPlatformNode psDCMSPlatformNode = null;
    private String strSSHIpAddr = null;
    private int nSSHPort = 22;
    private String strSSHUserName = null;
    private String strSSHPassword = null;
    private String strUploadMode = "SSH";
    private IPSMSPlatformNode iPSMSPlatformNode = null;
    private String strUploadPath = null;
    private String strWorkshopPath = null;
    private String strLocalSSHIpAddr = null;
    private int nLocalSSHPort = 22;
    private IPSDCMSPlatform iPSDCMSPlatform = null;
    private String strNodeType = null;
    private String strPSDCRegistryItemId = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDCMSPlatform iPSDCMSPlatform, PSDCMSPlatformNode psDCMSPlatformNode) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDCMSPlatformNode = psDCMSPlatformNode;
        this.setId(this.psDCMSPlatformNode.getPSDCMSPLATFORMNODEID());
        this.setName(this.psDCMSPlatformNode.getPSDCMSPLATFORMNODENAME());
        this.setPSObjectData(this.psDCMSPlatformNode);
        this.iPSDCMSPlatform = iPSDCMSPlatform;
        if (!StringHelper.isNullOrEmpty((String)this.psDCMSPlatformNode.getPSMSPLATFORMNODEID())) {
            if (this.getPSDCMSPlatform().getPSMSPlatform() == null) {
                throw new Exception(StringHelper.format((String)"\u5e94\u7528\u4e2d\u5fc3\u5fae\u670d\u52a1\u5e73\u53f0\u4e0d\u662f\u5e73\u53f0\u9884\u7f6e\u8d44\u6e90"));
            }
            this.iPSMSPlatformNode = this.getPSDCMSPlatform().getPSMSPlatform().getPSMSPlatformNode(this.psDCMSPlatformNode.getPSMSPLATFORMNODEID());
            this.setRemoteAddress(this.iPSMSPlatformNode.getRemoteAddress());
            this.setRemoteUserName(this.iPSMSPlatformNode.getRemoteUserName());
            this.setRemotePassword(this.iPSMSPlatformNode.getRemotePassword());
            this.setRemotePort(this.iPSMSPlatformNode.getRemotePort());
            this.setRemoteUploadMode(this.iPSMSPlatformNode.getRemoteUploadMode());
            this.setRemoteUploadPath(this.iPSMSPlatformNode.getRemoteUploadPath());
            this.setLocalRes(this.iPSMSPlatformNode.isLocalRes());
        } else {
            this.strLocalSSHIpAddr = this.psDCMSPlatformNode.getIPADDR();
            if (!this.psDCMSPlatformNode.isPORTNull()) {
                this.nLocalSSHPort = this.psDCMSPlatformNode.getPORT();
            }
            this.strSSHIpAddr = this.psDCMSPlatformNode.getSSHIPADDR();
            if (!this.psDCMSPlatformNode.isSSHPORTNull()) {
                this.nSSHPort = this.psDCMSPlatformNode.getSSHPORT();
            }
            if (StringHelper.isNullOrEmpty((String)this.strSSHIpAddr)) {
                this.strSSHIpAddr = this.strLocalSSHIpAddr;
            }
            this.setRemoteAddress(this.strSSHIpAddr);
            this.setRemotePort(this.nSSHPort);
            this.strSSHUserName = this.psDCMSPlatformNode.getUSERNAME();
            this.strSSHPassword = this.psDCMSPlatformNode.getPASSWD();
            this.setRemoteUserName(this.strSSHUserName);
            this.setRemotePassword(this.strSSHPassword);
            if (!StringHelper.isNullOrEmpty((String)this.psDCMSPlatformNode.getUPLOADFILEMODE())) {
                this.strUploadMode = this.psDCMSPlatformNode.getUPLOADFILEMODE();
            }
            this.strUploadPath = this.psDCMSPlatformNode.getUPLOADPATH();
            this.setRemoteUploadMode(this.strUploadMode);
            this.setRemoteUploadPath(this.strUploadPath);
            this.setResPos(2);
        }
        this.strPSDCRegistryItemId = this.psDCMSPlatformNode.getPSDCREGISTRYITEMID();
        this.setResPos(this.getPSDCMSPlatform().getResPos());
        this.setResState(this.getPSDCMSPlatform().getResState());
        this.strWorkshopPath = this.psDCMSPlatformNode.getWORKSHOPPATH();
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getSSHIPAddr() {
        if (this.iPSMSPlatformNode != null) {
            return this.iPSMSPlatformNode.getSSHIPAddr();
        }
        return this.strSSHIpAddr;
    }

    @Override
    public int getSSHPort() {
        if (this.iPSMSPlatformNode != null) {
            return this.iPSMSPlatformNode.getSSHPort();
        }
        return this.nSSHPort;
    }

    @Override
    public String getSSHUserName() {
        if (this.iPSMSPlatformNode != null) {
            return this.iPSMSPlatformNode.getSSHUserName();
        }
        return this.strSSHUserName;
    }

    @Override
    public String getSSHPassword() {
        if (this.iPSMSPlatformNode != null) {
            return this.iPSMSPlatformNode.getSSHPassword();
        }
        return this.strSSHPassword;
    }

    @Override
    public String getUploadMode() {
        if (this.iPSMSPlatformNode != null) {
            return this.iPSMSPlatformNode.getUploadMode();
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
        return "PSDCMSPLATFORMNODE";
    }

    @Override
    public String getUploadPath() {
        if (this.iPSMSPlatformNode != null) {
            return this.iPSMSPlatformNode.getUploadPath();
        }
        return this.strUploadPath;
    }

    @Override
    public String getWorkshopPath() {
        if (this.iPSMSPlatformNode != null) {
            return this.iPSMSPlatformNode.getWorkshopPath();
        }
        return this.strWorkshopPath;
    }

    @Override
    public String getLocalSSHIPAddr() {
        if (this.iPSMSPlatformNode != null) {
            return this.iPSMSPlatformNode.getLocalSSHIPAddr();
        }
        return this.strLocalSSHIpAddr;
    }

    @Override
    public int getLocalSSHPort() {
        if (this.iPSMSPlatformNode != null) {
            return this.iPSMSPlatformNode.getLocalSSHPort();
        }
        return this.nLocalSSHPort;
    }

    @Override
    public IPSMSPlatform getPSMSPlatform() {
        return this.getPSDCMSPlatform();
    }

    @Override
    public IPSDCMSPlatform getPSDCMSPlatform() {
        return this.iPSDCMSPlatform;
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSMSPlatform iPSMSPlatform, PSMSPlatformNode psMSPlatformNode) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public String getPSDCRegistryItemId() {
        return this.strPSDCRegistryItemId;
    }
}

