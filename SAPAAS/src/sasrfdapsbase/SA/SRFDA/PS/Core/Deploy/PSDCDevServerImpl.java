/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDCDevServer;
import SA.SRFDA.PS.Core.Deploy.IPSDevServer;
import SA.SRFDA.PS.Core.Deploy.IPSDevServerType;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Data.PSDevCenterServer;
import SA.SRFDA.PS.Data.PSDevServer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.sql.Timestamp;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;

public class PSDCDevServerImpl
extends PSDCResObjectImplBase
implements IPSDCDevServer {
    protected PSDevCenterServer psDevCenterServer = null;
    private String strSSHIpAddr = null;
    private int nSSHPort = 22;
    private String strSSHUserName = null;
    private String strSSHPassword = null;
    private boolean bRemoteDeploy = false;
    private String strDSType = null;
    private String strUploadMode = "SSH";
    private IPSDevServer iPSDevServer = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDevCenterServer psDevCenterServer) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDevCenterServer = psDevCenterServer;
        this.setId(this.psDevCenterServer.getPSDEVCENTERSERVERID());
        this.setName(this.psDevCenterServer.getPSDEVCENTERSERVERNAME());
        this.setPSObjectData(this.psDevCenterServer);
        if (this.psDevCenterServer.getEXPRIEDTIME() != null) {
            this.setExpiredTime(new Timestamp(this.psDevCenterServer.getEXPRIEDTIME().getTime()));
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDevCenterServer.getPSDEVSERVERID())) {
            PSDevServer psDevServer = new PSDevServer();
            CallResult callResult = this.getPSModelHelper(null).getPSDevServer(this.psDevCenterServer.getPSDEVSERVERID(), psDevServer);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u4e91\u5e73\u53f0\u5f00\u53d1\u684c\u9762\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            IPSDevServerType iPSDevServerType = this.getPSModelStorage().getPSDevServerType(psDevServer.getDSTYPE());
            IPSDevServer iPSDevServer = iPSDevServerType.createPSDevServer(psDevServer);
            iPSDevServer.init(this.getDAGlobalHelper(), psDevServer);
            this.iPSDevServer = iPSDevServer;
            this.setRemoteAddress(this.iPSDevServer.getRemoteAddress());
            this.setRemoteUserName(this.iPSDevServer.getRemoteUserName());
            this.setRemotePassword(this.iPSDevServer.getRemotePassword());
            this.setRemotePort(this.iPSDevServer.getRemotePort());
            this.setRemoteUploadMode(this.iPSDevServer.getRemoteUploadMode());
            this.setRemoteUploadPath(this.iPSDevServer.getRemoteUploadPath());
            this.setLocalRes(this.iPSDevServer.isLocalRes());
        }
        if (!this.psDevCenterServer.isRESPOSNull()) {
            this.setResPos(this.psDevCenterServer.getRESPOS());
        }
        if (!this.psDevCenterServer.isRESSTATENull()) {
            this.setResState(this.psDevCenterServer.getRESSTATE());
        }
        this.onInit();
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDevServer psDevCenterServer) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getSSHIPAddr() {
        if (this.iPSDevServer != null) {
            return this.iPSDevServer.getSSHIPAddr();
        }
        return this.strSSHIpAddr;
    }

    @Override
    public int getSSHPort() {
        if (this.iPSDevServer != null) {
            return this.iPSDevServer.getSSHPort();
        }
        return this.nSSHPort;
    }

    @Override
    public String getSSHUserName() {
        if (this.iPSDevServer != null) {
            return this.iPSDevServer.getSSHUserName();
        }
        return this.strSSHUserName;
    }

    @Override
    public String getSSHPassword() {
        if (this.iPSDevServer != null) {
            return this.iPSDevServer.getSSHPassword();
        }
        return this.strSSHPassword;
    }

    @Override
    public String getDSType() {
        if (this.iPSDevServer != null) {
            return this.iPSDevServer.getDSType();
        }
        return this.strDSType;
    }

    @Override
    public String getUploadMode() {
        if (this.iPSDevServer != null) {
            return this.iPSDevServer.getUploadMode();
        }
        return this.strUploadMode;
    }

    @Override
    protected void onFillResCfgParams(Map<String, String> params) throws Exception {
        super.onFillResCfgParams(params);
        if (this.getDSType() != null) {
            params.put("ds.type", this.getDSType());
        }
        if (this.getUploadMode() != null) {
            params.put("ds.uploadmode", this.getUploadMode());
        }
    }

    @Override
    public String getModelType() {
        return "PSDEVCENTERSERVER";
    }

    @Override
    public boolean isTimeShareRes() {
        if (this.iPSDevServer != null) {
            return this.iPSDevServer.isTimeShareRes();
        }
        return false;
    }
}

