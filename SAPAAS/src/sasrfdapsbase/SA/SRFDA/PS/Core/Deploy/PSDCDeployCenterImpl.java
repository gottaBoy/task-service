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

import SA.SRFDA.PS.Core.Deploy.IPSDCDeployCenter;
import SA.SRFDA.PS.Core.Deploy.IPSDeployCenter;
import SA.SRFDA.PS.Core.Deploy.IPSRegistryRepo;
import SA.SRFDA.PS.Core.Deploy.PSDCRegistryRepoImpl;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSDCDeployCenter;
import SA.SRFDA.PS.Data.PSDCRegistryRepo;
import SA.SRFDA.PS.Data.PSDeployCenter;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.sql.Timestamp;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCDeployCenterImpl
extends PSDCResObjectImplBase
implements IPSDCDeployCenter {
    private static final Log log = LogFactory.getLog(PSDCDeployCenterImpl.class);
    protected PSDCDeployCenter psDCDeployCenter = null;
    private String strSSHIpAddr = null;
    private int nSSHPort = 22;
    private String strSSHUserName = null;
    private String strSSHPassword = null;
    private String strUploadMode = "SSH";
    private IPSDeployCenter iPSDeployCenter = null;
    private String strUploadPath = null;
    private String strWorkshopPath = null;
    private String strLocalSSHIpAddr = null;
    private int nLocalSSHPort = 22;
    private String strCIType = "JENKINS";
    private String strCDType = "DEFAULT";
    private String strAPIUrl = "";
    private String strAPIToken = "";
    private IPSRegistryRepo iPSRegistryRepo = null;
    private String strPSRegistryRepoId = null;
    private String strPSDCRegistryRepoId = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDCDeployCenter psDCDeployCenter) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDCDeployCenter = psDCDeployCenter;
        this.setId(this.psDCDeployCenter.getPSDCDEPLOYCENTERID());
        this.setName(this.psDCDeployCenter.getPSDCDEPLOYCENTERNAME());
        this.setPSObjectData(this.psDCDeployCenter);
        if (this.psDCDeployCenter.getEXPRIEDTIME() != null) {
            this.setExpiredTime(new Timestamp(this.psDCDeployCenter.getEXPRIEDTIME().getTime()));
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCDeployCenter.getPSDEPLOYCENTERID())) {
            this.iPSDeployCenter = this.getPSModelStorage().getPSDeployCenter(this.psDCDeployCenter.getPSDEPLOYCENTERID());
            this.setRemoteAddress(this.iPSDeployCenter.getRemoteAddress());
            this.setRemoteUserName(this.iPSDeployCenter.getRemoteUserName());
            this.setRemotePassword(this.iPSDeployCenter.getRemotePassword());
            this.setRemotePort(this.iPSDeployCenter.getRemotePort());
            this.setRemoteUploadMode(this.iPSDeployCenter.getRemoteUploadMode());
            this.setRemoteUploadPath(this.iPSDeployCenter.getRemoteUploadPath());
            this.setLocalRes(this.iPSDeployCenter.isLocalRes());
        } else {
            this.strLocalSSHIpAddr = this.psDCDeployCenter.getIPADDR();
            if (!this.psDCDeployCenter.isPORTNull()) {
                this.nLocalSSHPort = this.psDCDeployCenter.getPORT();
            }
            this.strSSHIpAddr = this.psDCDeployCenter.getSSHIPADDR();
            if (!this.psDCDeployCenter.isSSHPORTNull()) {
                this.nSSHPort = this.psDCDeployCenter.getSSHPORT();
            }
            if (StringHelper.isNullOrEmpty((String)this.strSSHIpAddr)) {
                this.strSSHIpAddr = this.strLocalSSHIpAddr;
            }
            this.setRemoteAddress(this.strSSHIpAddr);
            this.setRemotePort(this.nSSHPort);
            this.strSSHUserName = this.psDCDeployCenter.getUSERNAME();
            this.strSSHPassword = this.psDCDeployCenter.getPASSWD();
            this.setRemoteUserName(this.strSSHUserName);
            this.setRemotePassword(this.strSSHPassword);
            if (!StringHelper.isNullOrEmpty((String)this.psDCDeployCenter.getUPLOADFILEMODE())) {
                this.strUploadMode = this.psDCDeployCenter.getUPLOADFILEMODE();
            }
            this.setResPos(2);
        }
        if (!this.psDCDeployCenter.isRESPOSNull()) {
            this.setResPos(this.psDCDeployCenter.getRESPOS());
        }
        if (!this.psDCDeployCenter.isRESSTATENull()) {
            this.setResState(this.psDCDeployCenter.getRESSTATE());
        }
        this.strUploadPath = this.psDCDeployCenter.getUPLOADPATH();
        this.strWorkshopPath = this.psDCDeployCenter.getWORKSHOPPATH();
        if (!StringHelper.isNullOrEmpty((String)this.psDCDeployCenter.getDCTYPE())) {
            this.strCIType = this.psDCDeployCenter.getDCTYPE();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCDeployCenter.getDCTYPE2())) {
            this.strCDType = this.psDCDeployCenter.getDCTYPE2();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCDeployCenter.getAPIURL())) {
            this.strAPIUrl = this.psDCDeployCenter.getAPIURL();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCDeployCenter.getAPITOKEN())) {
            this.strAPIToken = this.psDCDeployCenter.getAPITOKEN();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCDeployCenter.getPSDCREGISTRYREPOID())) {
            this.strPSDCRegistryRepoId = this.psDCDeployCenter.getPSDCREGISTRYREPOID();
            PSDCRegistryRepo psDCRegistryRepo = new PSDCRegistryRepo();
            CallResult callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDCRegistryRepo(this.psDCDeployCenter.getPSDCREGISTRYREPOID(), psDCRegistryRepo);
            if (callResult.isOk()) {
                if (!StringHelper.isNullOrEmpty((String)psDCRegistryRepo.getPSREGISTRYREPOID())) {
                    this.strPSRegistryRepoId = psDCRegistryRepo.getPSREGISTRYREPOID();
                }
                this.strPSRegistryRepoId = psDCRegistryRepo.getPSREGISTRYREPOID();
                PSDCRegistryRepoImpl psDCRegistryRepoImpl = new PSDCRegistryRepoImpl();
                psDCRegistryRepoImpl.init(this.getDAGlobalHelper(), psDCRegistryRepo);
                this.iPSRegistryRepo = psDCRegistryRepoImpl;
            }
        }
        this.onInit();
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDeployCenter psDCDeployCenter) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getSSHIPAddr() {
        if (this.iPSDeployCenter != null) {
            return this.iPSDeployCenter.getSSHIPAddr();
        }
        return this.strSSHIpAddr;
    }

    @Override
    public int getSSHPort() {
        if (this.iPSDeployCenter != null) {
            return this.iPSDeployCenter.getSSHPort();
        }
        return this.nSSHPort;
    }

    @Override
    public String getSSHUserName() {
        if (this.iPSDeployCenter != null) {
            return this.iPSDeployCenter.getSSHUserName();
        }
        return this.strSSHUserName;
    }

    @Override
    public String getSSHPassword() {
        if (this.iPSDeployCenter != null) {
            return this.iPSDeployCenter.getSSHPassword();
        }
        return this.strSSHPassword;
    }

    @Override
    public String getUploadMode() {
        if (this.iPSDeployCenter != null) {
            return this.iPSDeployCenter.getUploadMode();
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
    public String getModelType() {
        return "PSDCDEPLOYCENTER";
    }

    @Override
    public String getUploadPath() {
        if (this.iPSDeployCenter != null) {
            return this.iPSDeployCenter.getUploadPath();
        }
        return this.strUploadPath;
    }

    @Override
    public String getWorkshopPath() {
        if (this.iPSDeployCenter != null) {
            return this.iPSDeployCenter.getWorkshopPath();
        }
        return this.strWorkshopPath;
    }

    @Override
    public String getLocalSSHIPAddr() {
        if (this.iPSDeployCenter != null) {
            return this.iPSDeployCenter.getLocalSSHIPAddr();
        }
        return this.strLocalSSHIpAddr;
    }

    @Override
    public int getLocalSSHPort() {
        if (this.iPSDeployCenter != null) {
            return this.iPSDeployCenter.getLocalSSHPort();
        }
        return this.nLocalSSHPort;
    }

    @Override
    public String getDeployCenterType() {
        if (this.iPSDeployCenter != null) {
            return this.iPSDeployCenter.getDeployCenterType();
        }
        return this.strCIType;
    }

    @Override
    @PSModelRTMeta(description="\u6301\u7eed\u96c6\u6210\u7c7b\u578b", codelist="DeployCenterType")
    public String getCIType() {
        if (this.iPSDeployCenter != null) {
            return this.iPSDeployCenter.getCIType();
        }
        return this.strCIType;
    }

    @Override
    @PSModelRTMeta(description="\u6301\u7eed\u90e8\u7f72\u7c7b\u578b", codelist="DeployCenterType2")
    public String getCDType() {
        if (this.iPSDeployCenter != null) {
            return this.iPSDeployCenter.getCDType();
        }
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
        if (this.iPSDeployCenter != null) {
            return this.iPSDeployCenter.getAPIUrl();
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
        if (this.iPSDeployCenter != null) {
            return this.iPSDeployCenter.getAPIToken();
        }
        return this.strAPIToken;
    }

    @Override
    @PSModelRTMeta(description="\u955c\u50cf\u670d\u52a1\u5668")
    public IPSRegistryRepo getPSRegistryRepo() {
        if (this.iPSDeployCenter != null) {
            return this.iPSDeployCenter.getPSRegistryRepo();
        }
        return this.iPSRegistryRepo;
    }

    @Override
    public String getPSRegistryRepoId() {
        return this.strPSRegistryRepoId;
    }

    @Override
    public String getPSDCRegistryRepoId() {
        return this.strPSDCRegistryRepoId;
    }
}

