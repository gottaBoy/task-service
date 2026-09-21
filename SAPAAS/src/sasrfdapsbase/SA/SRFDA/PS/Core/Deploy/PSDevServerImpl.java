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

import SA.SRFDA.PS.Core.Deploy.IPSDevServer;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSDevServer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDevServerImpl
extends PSDCResObjectImplBase
implements IPSDevServer {
    private static final Log log = LogFactory.getLog(PSDevServerImpl.class);
    protected PSDevServer psDevServer = null;
    private String strSSHIpAddr = null;
    private int nSSHPort = 22;
    private String strSSHUserName = null;
    private String strSSHPassword = null;
    private String strDSType = null;
    private String strUploadMode = "SSH";
    private boolean bTimeShareRes = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDevServer psDevServer) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDevServer = psDevServer;
        this.setId(this.psDevServer.getPSDEVSERVERID());
        this.setName(this.psDevServer.getPSDEVSERVERNAME());
        this.setPSObjectData(this.psDevServer);
        this.strDSType = this.psDevServer.getDSTYPE();
        if (!StringHelper.isNullOrEmpty((String)this.psDevServer.getSSHIPADDR())) {
            this.strSSHIpAddr = this.psDevServer.getSSHIPADDR();
            this.setRemoteAddress(this.strSSHIpAddr);
            if (!this.psDevServer.isSSHPORTNull()) {
                this.nSSHPort = this.psDevServer.getSSHPORT();
                this.setRemotePort(this.nSSHPort);
            }
            this.strSSHUserName = this.psDevServer.getUSERNAME();
            this.strSSHPassword = this.psDevServer.getPASSWD();
            this.setRemoteUserName(this.strSSHUserName);
            this.setRemotePassword(this.strSSHPassword);
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDevServer.getUPLOADFILEMODE())) {
            this.strUploadMode = this.psDevServer.getUPLOADFILEMODE();
        }
        if (!this.psDevServer.isLOCALRESNull()) {
            this.setLocalRes(this.psDevServer.getLOCALRES());
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
    public String getDSType() {
        return this.strDSType;
    }

    @Override
    public String getUploadMode() {
        return this.strUploadMode;
    }

    @Override
    public String getModelType() {
        return "PSDEVSERVER";
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
    public boolean isTimeShareRes() {
        return this.bTimeShareRes;
    }
}

