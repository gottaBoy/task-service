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

import SA.SRFDA.PS.Core.Deploy.IPSAppServer;
import SA.SRFDA.PS.Core.Deploy.IPSDBServer;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDBServer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDBServerImpl
extends PSDCResObjectImplBase
implements IPSDBServer {
    private static final Log log = LogFactory.getLog(PSDBServerImpl.class);
    protected PSDBServer psDBServer = null;
    private String strDBUserName = null;
    private String strDBPassword = null;
    private String strDBType = null;
    private String strDBUrl = null;
    private int nDBPort = 0;
    private String strPSAppServerId = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDBServer psDBServer) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDBServer = psDBServer;
        this.setId(this.psDBServer.getPSDBSERVERID());
        this.setName(this.psDBServer.getPSDBSERVERNAME());
        this.setPSObjectData(this.psDBServer);
        this.strDBType = this.psDBServer.getDBTYPE();
        if (!StringHelper.isNullOrEmpty((String)this.psDBServer.getIPADDR())) {
            this.setRemoteAddress(this.psDBServer.getIPADDR());
        }
        if (!this.psDBServer.isPORTNull()) {
            this.setRemotePort(this.psDBServer.getPORT());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDBServer.getUPLOADPATH())) {
            this.setRemoteUploadPath(this.psDBServer.getUPLOADPATH());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDBServer.getUPLOADFILEMODE())) {
            this.setRemoteUploadMode(this.psDBServer.getUPLOADFILEMODE());
        }
        this.setRemoteUserName(this.psDBServer.getUSERNAME());
        this.setRemotePassword(this.psDBServer.getPASSWD());
        this.strDBUserName = this.psDBServer.getDBUSERNAME();
        this.strDBPassword = this.psDBServer.getDBPASSWD();
        this.strDBUrl = this.psDBServer.getDBURL();
        this.strPSAppServerId = this.psDBServer.getPSAPPSERVERID();
        if (!this.psDBServer.isDBPORTNull()) {
            this.nDBPort = this.psDBServer.getDBPORT();
        }
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u7528\u6237", debugmode=true)
    public String getDBUserName() {
        return this.strDBUserName;
    }

    @Override
    public String getDBPassword() {
        return this.strDBPassword;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u7c7b\u578b", codelist="DBType2")
    public String getDBType() {
        return this.strDBType;
    }

    @Override
    public String getModelType() {
        return "PSDBSERVER";
    }

    @Override
    protected void onFillResCfgParams(Map<String, String> params) throws Exception {
        super.onFillResCfgParams(params);
        if (this.getDBType() != null) {
            params.put("dbs.type", this.getDBType());
        }
        if (this.getDBAddress() != null) {
            params.put("dbs.addr", this.getDBAddress());
        }
        if (this.getDBPort() != 0) {
            params.put("dbs.port", StringHelper.format((String)"%1$s", (Object)this.getDBPort()));
        }
        if (this.getDBUserName() != null) {
            params.put("dbs.user", this.getDBUserName());
        }
        if (this.getDBPassword() != null) {
            params.put("dbs.pass", this.getDBPassword());
        }
        if (this.getDBUrl() != null) {
            params.put("dbs.url", this.getDBUrl());
        }
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u5730\u5740", debugmode=true)
    public String getDBAddress() {
        return this.getRemoteAddress();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u7aef\u53e3", debugmode=true)
    public int getDBPort() {
        return this.nDBPort;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u8def\u5f84", debugmode=true)
    public String getDBUrl() {
        return this.strDBUrl;
    }

    @Override
    public IPSAppServer getPSAppServer() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getPSAppServerId())) {
            return null;
        }
        return this.getPSModelStorage().getPSAppServer(this.getPSAppServerId());
    }

    @Override
    public String getPSAppServerId() {
        return this.strPSAppServerId;
    }
}

