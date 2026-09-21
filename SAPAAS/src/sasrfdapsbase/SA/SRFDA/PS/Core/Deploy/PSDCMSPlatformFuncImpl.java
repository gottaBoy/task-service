/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDCMSPlatform;
import SA.SRFDA.PS.Core.Deploy.IPSDCMSPlatformFunc;
import SA.SRFDA.PS.Core.Deploy.IPSMSPlatform;
import SA.SRFDA.PS.Core.Deploy.IPSMSPlatformFunc;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Data.PSDCMSPlatformFunc;
import SA.SRFDA.PS.Data.PSMSPlatformFunc;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;

public class PSDCMSPlatformFuncImpl
extends PSDCResObjectImplBase
implements IPSDCMSPlatformFunc {
    protected PSDCMSPlatformFunc psDCMSPlatformFunc = null;
    private String strSSHIpAddr = null;
    private int nSSHPort = 22;
    private String strSSHUserName = null;
    private String strSSHPassword = null;
    private String strUploadMode = "SSH";
    private IPSMSPlatformFunc iPSMSPlatformFunc = null;
    private String strUploadPath = null;
    private String strWorkshopPath = null;
    private String strLocalSSHIpAddr = null;
    private int nLocalSSHPort = 22;
    private IPSDCMSPlatform iPSDCMSPlatform = null;
    private String strFuncType = null;
    private String strServiceUrl = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDCMSPlatform iPSDCMSPlatform, PSDCMSPlatformFunc psDCMSPlatformFunc) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDCMSPlatformFunc = psDCMSPlatformFunc;
        this.setId(this.psDCMSPlatformFunc.getPSDCMSPLATFORMFUNCID());
        this.setName(this.psDCMSPlatformFunc.getPSDCMSPLATFORMFUNCNAME());
        this.setPSObjectData(this.psDCMSPlatformFunc);
        this.iPSDCMSPlatform = iPSDCMSPlatform;
        if (!StringHelper.isNullOrEmpty((String)this.psDCMSPlatformFunc.getPSMSPLATFORMFUNCID())) {
            if (this.getPSDCMSPlatform().getPSMSPlatform() == null) {
                throw new Exception(StringHelper.format((String)"\u5e94\u7528\u4e2d\u5fc3\u5fae\u670d\u52a1\u5e73\u53f0\u4e0d\u662f\u5e73\u53f0\u9884\u7f6e\u8d44\u6e90"));
            }
            this.iPSMSPlatformFunc = this.getPSDCMSPlatform().getPSMSPlatform().getPSMSPlatformFunc(this.psDCMSPlatformFunc.getPSMSPLATFORMFUNCID());
            this.setRemoteAddress(this.iPSMSPlatformFunc.getRemoteAddress());
            this.setRemoteUserName(this.iPSMSPlatformFunc.getRemoteUserName());
            this.setRemotePassword(this.iPSMSPlatformFunc.getRemotePassword());
            this.setRemotePort(this.iPSMSPlatformFunc.getRemotePort());
            this.setRemoteUploadMode(this.iPSMSPlatformFunc.getRemoteUploadMode());
            this.setRemoteUploadPath(this.iPSMSPlatformFunc.getRemoteUploadPath());
            this.setLocalRes(this.iPSMSPlatformFunc.isLocalRes());
        } else {
            this.strFuncType = this.psDCMSPlatformFunc.getMSFUNCTYPE();
            this.strLocalSSHIpAddr = this.psDCMSPlatformFunc.getIPADDR();
            if (!this.psDCMSPlatformFunc.isPORTNull()) {
                this.nLocalSSHPort = this.psDCMSPlatformFunc.getPORT();
            }
            this.strSSHIpAddr = this.psDCMSPlatformFunc.getSSHIPADDR();
            if (!this.psDCMSPlatformFunc.isSSHPORTNull()) {
                this.nSSHPort = this.psDCMSPlatformFunc.getSSHPORT();
            }
            if (StringHelper.isNullOrEmpty((String)this.strSSHIpAddr)) {
                this.strSSHIpAddr = this.strLocalSSHIpAddr;
            }
            this.setRemoteAddress(this.strSSHIpAddr);
            this.setRemotePort(this.nSSHPort);
            this.strSSHUserName = this.psDCMSPlatformFunc.getUSERNAME();
            this.strSSHPassword = this.psDCMSPlatformFunc.getPASSWD();
            this.setRemoteUserName(this.strSSHUserName);
            this.setRemotePassword(this.strSSHPassword);
            if (!StringHelper.isNullOrEmpty((String)this.psDCMSPlatformFunc.getUPLOADFILEMODE())) {
                this.strUploadMode = this.psDCMSPlatformFunc.getUPLOADFILEMODE();
            }
            this.strUploadPath = this.psDCMSPlatformFunc.getUPLOADPATH();
            this.setRemoteUploadMode(this.strUploadMode);
            this.setRemoteUploadPath(this.strUploadPath);
            this.setResPos(2);
        }
        this.setResPos(this.getPSDCMSPlatform().getResPos());
        this.setResState(this.getPSDCMSPlatform().getResState());
        this.strWorkshopPath = this.psDCMSPlatformFunc.getWORKSHOPPATH();
        this.strServiceUrl = this.psDCMSPlatformFunc.getSERVICEURL();
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getSSHIPAddr() {
        if (this.iPSMSPlatformFunc != null) {
            return this.iPSMSPlatformFunc.getSSHIPAddr();
        }
        return this.strSSHIpAddr;
    }

    @Override
    public int getSSHPort() {
        if (this.iPSMSPlatformFunc != null) {
            return this.iPSMSPlatformFunc.getSSHPort();
        }
        return this.nSSHPort;
    }

    @Override
    public String getSSHUserName() {
        if (this.iPSMSPlatformFunc != null) {
            return this.iPSMSPlatformFunc.getSSHUserName();
        }
        return this.strSSHUserName;
    }

    @Override
    public String getSSHPassword() {
        if (this.iPSMSPlatformFunc != null) {
            return this.iPSMSPlatformFunc.getSSHPassword();
        }
        return this.strSSHPassword;
    }

    @Override
    public String getUploadMode() {
        if (this.iPSMSPlatformFunc != null) {
            return this.iPSMSPlatformFunc.getUploadMode();
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
        return "PSDCMSPLATFORMFUNC";
    }

    @Override
    public String getUploadPath() {
        if (this.iPSMSPlatformFunc != null) {
            return this.iPSMSPlatformFunc.getUploadPath();
        }
        return this.strUploadPath;
    }

    @Override
    public String getWorkshopPath() {
        if (this.iPSMSPlatformFunc != null) {
            return this.iPSMSPlatformFunc.getWorkshopPath();
        }
        return this.strWorkshopPath;
    }

    @Override
    public String getLocalSSHIPAddr() {
        if (this.iPSMSPlatformFunc != null) {
            return this.iPSMSPlatformFunc.getLocalSSHIPAddr();
        }
        return this.strLocalSSHIpAddr;
    }

    @Override
    public int getLocalSSHPort() {
        if (this.iPSMSPlatformFunc != null) {
            return this.iPSMSPlatformFunc.getLocalSSHPort();
        }
        return this.nLocalSSHPort;
    }

    @Override
    public String getFuncType() {
        if (this.iPSMSPlatformFunc != null) {
            return this.iPSMSPlatformFunc.getFuncType();
        }
        return this.strFuncType;
    }

    @Override
    public String getServiceUrl() {
        if (this.iPSMSPlatformFunc != null) {
            return this.iPSMSPlatformFunc.getServiceUrl();
        }
        return this.strServiceUrl;
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
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSMSPlatform iPSMSPlatform, PSMSPlatformFunc psMSPlatformFunc) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }
}

