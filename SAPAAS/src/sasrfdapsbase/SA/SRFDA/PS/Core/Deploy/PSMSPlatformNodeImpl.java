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

import SA.SRFDA.PS.Core.Deploy.IPSMSPlatform;
import SA.SRFDA.PS.Core.Deploy.IPSMSPlatformNode;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSMSPlatformNode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSMSPlatformNodeImpl
extends PSDCResObjectImplBase
implements IPSMSPlatformNode {
    private static final Log log = LogFactory.getLog(PSMSPlatformNodeImpl.class);
    protected PSMSPlatformNode psMSPlatformNode = null;
    private String strSSHIpAddr = null;
    private int nSSHPort = 22;
    private String strLocalSSHIpAddr = null;
    private int nLocalSSHPort = 22;
    private String strSSHUserName = null;
    private String strSSHPassword = null;
    private String strUploadMode = "SSH";
    private String strUploadPath = null;
    private String strWorkshopPath = null;
    private IPSMSPlatform iPSMSPlatform = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSMSPlatform iPSMSPlatform, PSMSPlatformNode psMSPlatformNode) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psMSPlatformNode = psMSPlatformNode;
        this.setId(this.psMSPlatformNode.getPSMSPLATFORMNODEID());
        this.setName(this.psMSPlatformNode.getPSMSPLATFORMNODENAME());
        this.setPSObjectData(this.psMSPlatformNode);
        this.iPSMSPlatform = iPSMSPlatform;
        this.strLocalSSHIpAddr = this.psMSPlatformNode.getIPADDR();
        if (!this.psMSPlatformNode.isPORTNull()) {
            this.nLocalSSHPort = this.psMSPlatformNode.getPORT();
        }
        this.strSSHIpAddr = this.psMSPlatformNode.getSSHIPADDR();
        if (!this.psMSPlatformNode.isSSHPORTNull()) {
            this.nSSHPort = this.psMSPlatformNode.getSSHPORT();
        }
        if (StringHelper.isNullOrEmpty((String)this.strSSHIpAddr)) {
            this.strSSHIpAddr = this.strLocalSSHIpAddr;
        }
        this.setRemoteAddress(this.strSSHIpAddr);
        this.setRemotePort(this.nSSHPort);
        this.strSSHUserName = this.psMSPlatformNode.getUSERNAME();
        this.strSSHPassword = this.psMSPlatformNode.getPASSWD();
        this.setRemoteUserName(this.strSSHUserName);
        this.setRemotePassword(this.strSSHPassword);
        if (!StringHelper.isNullOrEmpty((String)this.psMSPlatformNode.getUPLOADFILEMODE())) {
            this.strUploadMode = this.psMSPlatformNode.getUPLOADFILEMODE();
        }
        this.strUploadPath = this.psMSPlatformNode.getUPLOADPATH();
        this.strWorkshopPath = this.psMSPlatformNode.getWORKSHOPPATH();
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
    public String getModelType() {
        return "PSMSPLATFORM";
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
    public String getUploadPath() {
        return this.strUploadPath;
    }

    @Override
    public String getWorkshopPath() {
        return this.strWorkshopPath;
    }

    @Override
    public String getUploadMode() {
        return this.strUploadMode;
    }

    @Override
    public IPSMSPlatform getPSMSPlatform() {
        return this.iPSMSPlatform;
    }
}

