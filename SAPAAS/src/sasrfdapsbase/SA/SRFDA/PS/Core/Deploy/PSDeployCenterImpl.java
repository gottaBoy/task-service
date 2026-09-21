/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDeployCenter;
import SA.SRFDA.PS.Core.Deploy.IPSRegistryRepo;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.Deploy.PSRegistryRepoImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSDeployCenter;
import SA.SRFDA.PS.Data.PSRegistryRepo;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDeployCenterImpl
extends PSDCResObjectImplBase
implements IPSDeployCenter {
    private static final Log log = LogFactory.getLog(PSDeployCenterImpl.class);
    protected PSDeployCenter psDeployCenter = null;
    private String strSSHIpAddr = null;
    private int nSSHPort = 22;
    private String strLocalSSHIpAddr = null;
    private int nLocalSSHPort = 22;
    private String strSSHUserName = null;
    private String strSSHPassword = null;
    private String strUploadMode = "SSH";
    private String strUploadPath = null;
    private String strWorkshopPath = null;
    private String strCIType = "JENKINS";
    private String strCDType = "DEFAULT";
    private String strAPIUrl = "";
    private String strAPIToken = "";
    private IPSRegistryRepo iPSRegistryRepo = null;
    private String strPSRegistryRepoId = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDeployCenter psDeployCenter) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDeployCenter = psDeployCenter;
        this.setId(this.psDeployCenter.getPSDEPLOYCENTERID());
        this.setName(this.psDeployCenter.getPSDEPLOYCENTERNAME());
        this.setPSObjectData(this.psDeployCenter);
        this.strLocalSSHIpAddr = this.psDeployCenter.getIPADDR();
        if (!this.psDeployCenter.isPORTNull()) {
            this.nLocalSSHPort = this.psDeployCenter.getPORT();
        }
        this.strSSHIpAddr = this.psDeployCenter.getSSHIPADDR();
        if (!this.psDeployCenter.isSSHPORTNull()) {
            this.nSSHPort = this.psDeployCenter.getSSHPORT();
        }
        if (StringHelper.isNullOrEmpty((String)this.strSSHIpAddr)) {
            this.strSSHIpAddr = this.strLocalSSHIpAddr;
        }
        this.setRemoteAddress(this.strSSHIpAddr);
        this.setRemotePort(this.nSSHPort);
        this.strSSHUserName = this.psDeployCenter.getUSERNAME();
        this.strSSHPassword = this.psDeployCenter.getPASSWD();
        this.setRemoteUserName(this.strSSHUserName);
        this.setRemotePassword(this.strSSHPassword);
        if (!StringHelper.isNullOrEmpty((String)this.psDeployCenter.getUPLOADFILEMODE())) {
            this.strUploadMode = this.psDeployCenter.getUPLOADFILEMODE();
        }
        this.strUploadPath = this.psDeployCenter.getUPLOADPATH();
        this.strWorkshopPath = this.psDeployCenter.getWORKSHOPPATH();
        this.setRemoteUploadMode(this.strUploadMode);
        this.setRemoteUploadPath(this.strUploadPath);
        if (!StringHelper.isNullOrEmpty((String)this.psDeployCenter.getDCTYPE())) {
            this.strCIType = this.psDeployCenter.getDCTYPE();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDeployCenter.getDCTYPE2())) {
            this.strCDType = this.psDeployCenter.getDCTYPE2();
        }
        this.strAPIUrl = this.psDeployCenter.getAPIURL();
        this.strAPIToken = this.psDeployCenter.getAPITOKEN();
        if (!StringHelper.isNullOrEmpty((String)this.psDeployCenter.getPSREGISTRYREPOID())) {
            this.strPSRegistryRepoId = this.psDeployCenter.getPSREGISTRYREPOID();
            PSRegistryRepo psRegistryRepo = new PSRegistryRepo();
            CallResult callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSRegistryRepo(this.psDeployCenter.getPSREGISTRYREPOID(), psRegistryRepo);
            if (callResult.isOk()) {
                PSRegistryRepoImpl psRegistryRepoImpl = new PSRegistryRepoImpl();
                psRegistryRepoImpl.init(this.getDAGlobalHelper(), psRegistryRepo);
                this.iPSRegistryRepo = psRegistryRepoImpl;
            }
        }
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
        return "PSDEPLOYCENTER";
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
        if (!StringHelper.isNullOrEmpty((String)this.getDeployCenterType())) {
            params.put("deps.type", this.getDeployCenterType());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getCIType())) {
            params.put("deps.citype", this.getCIType());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getCDType())) {
            params.put("deps.cdtype", this.getCDType());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getAPIUrl())) {
            params.put("deps.apiurl", this.getAPIUrl());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getAPIToken())) {
            params.put("deps.apitoken", this.getAPIToken());
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
    public String getDeployCenterType() {
        return this.strCIType;
    }

    @Override
    @PSModelRTMeta(description="\u6301\u7eed\u96c6\u6210\u7c7b\u578b", codelist="DeployCenterType")
    public String getCIType() {
        return this.strCIType;
    }

    @Override
    @PSModelRTMeta(description="\u6301\u7eed\u90e8\u7f72\u7c7b\u578b", codelist="DeployCenterType2")
    public String getCDType() {
        return this.strCDType;
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u8def\u5f84")
    public String getAPIUrl() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]getAPIUrl", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.strAPIUrl;
    }

    @Override
    public String getAPIToken() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]getAPIToken", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.strAPIToken;
    }

    @Override
    public IPSRegistryRepo getPSRegistryRepo() {
        return this.iPSRegistryRepo;
    }

    @Override
    public String getPSRegistryRepoId() {
        return this.strPSRegistryRepoId;
    }
}

