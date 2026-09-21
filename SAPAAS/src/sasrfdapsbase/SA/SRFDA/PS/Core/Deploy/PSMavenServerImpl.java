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

import SA.SRFDA.PS.Core.Deploy.IPSMavenServer;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSMavenServer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSMavenServerImpl
extends PSDCResObjectImplBase
implements IPSMavenServer {
    private static final Log log = LogFactory.getLog(PSMavenServerImpl.class);
    protected PSMavenServer psMavenServer = null;
    private boolean bRemoteDeploy = false;
    private String strMSType = null;
    private String strUploadMode = "SSH";
    private String strAPIPath = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSMavenServer psMavenServer) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psMavenServer = psMavenServer;
        this.setId(this.psMavenServer.getPSMAVENSERVERID());
        this.setName(this.psMavenServer.getPSMAVENSERVERNAME());
        this.setPSObjectData(this.psMavenServer);
        this.strMSType = this.psMavenServer.getMAVENSERVERTYPE();
        this.strAPIPath = this.psMavenServer.getAPIPATH();
        if (!StringHelper.isNullOrEmpty((String)this.psMavenServer.getIPADDR())) {
            String strSSHIpAddr = this.psMavenServer.getIPADDR();
            this.setRemoteAddress(strSSHIpAddr);
            String strSSHUserName = this.psMavenServer.getUSERNAME();
            String strSSHPassword = this.psMavenServer.getPASSWD();
            this.setRemoteUserName(strSSHUserName);
            this.setRemotePassword(strSSHPassword);
            this.bRemoteDeploy = true;
        }
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public boolean isRemoteDeploy() {
        return this.bRemoteDeploy;
    }

    @Override
    @PSModelRTMeta(description="Maven\u670d\u52a1\u5668\u7c7b\u578b")
    public String getMSType() {
        return this.strMSType;
    }

    @Override
    public String getModelType() {
        return "PSMAVENSERVER";
    }

    @Override
    protected void onFillResCfgParams(Map<String, String> params) throws Exception {
        super.onFillResCfgParams(params);
        if (this.getMSType() != null) {
            params.put("ms.type", this.getMSType());
        }
        params.put("ms.remote", Boolean.toString(this.isRemoteDeploy()));
    }

    @Override
    public String getAPIPath() {
        return this.strAPIPath;
    }
}

