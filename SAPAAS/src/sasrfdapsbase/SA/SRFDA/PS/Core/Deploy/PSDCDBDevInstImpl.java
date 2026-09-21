/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.Deploy.IPSDBServer;
import SA.SRFDA.PS.Core.Deploy.IPSDCAppServer;
import SA.SRFDA.PS.Core.Deploy.IPSDCDBDevInst;
import SA.SRFDA.PS.Core.Deploy.PSDBServerImpl;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDBDevInst;
import SA.SRFDA.PS.Data.PSDBServer;
import SA.SRFDA.PS.Data.PSDevCenterDBInst;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;

public class PSDCDBDevInstImpl
extends PSDCResObjectImplBase
implements IPSDCDBDevInst {
    protected PSDevCenterDBInst psDevCenterDBInst = null;
    private IPSDBDevInst iPSDBDevInst = null;
    private IPSDCAppServer iPSDCAppServer = null;
    private IPSDBServer iPSDBServer = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDCAppServer iPSDCAppServer, PSDevCenterDBInst psDevCenterDBInst) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDevCenterDBInst = psDevCenterDBInst;
        this.setId(this.psDevCenterDBInst.getPSDEVCENTERDBINSTID());
        this.setName(this.psDevCenterDBInst.getPSDEVCENTERDBINSTNAME());
        this.setPSObjectData(this.psDevCenterDBInst);
        this.iPSDCAppServer = iPSDCAppServer;
        if (psDevCenterDBInst.getEXPRIEDTIME() != null) {
            this.setExpiredTime(new Timestamp(psDevCenterDBInst.getEXPRIEDTIME().getTime()));
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDevCenterDBInst.getPSDBDEVINSTID())) {
            if (psDevCenterDBInst.getRESPOS() == 5) {
                this.getPSModelStorage().resetPSDBDevInst(this.psDevCenterDBInst.getPSDBDEVINSTID());
            }
            this.iPSDBDevInst = this.getPSModelStorage().getPSDBDevInst(this.psDevCenterDBInst.getPSDBDEVINSTID());
            this.setResPos(this.iPSDBDevInst.getResPos());
            if (iPSDCAppServer != null) {
                this.setRemoteAddress(iPSDCAppServer.getRemoteAddress());
                this.setRemotePort(iPSDCAppServer.getRemotePort());
                this.setRemoteUserName(iPSDCAppServer.getRemoteUserName());
                this.setRemotePassword(iPSDCAppServer.getRemotePassword());
                this.setRemoteUploadMode(iPSDCAppServer.getRemoteUploadMode());
                this.setRemoteUploadPath(iPSDCAppServer.getRemoteUploadPath());
            } else {
                this.setRemoteAddress(this.iPSDBDevInst.getRemoteAddress());
                this.setRemotePort(this.iPSDBDevInst.getRemotePort());
                this.setRemoteUserName(this.iPSDBDevInst.getRemoteUserName());
                this.setRemotePassword(this.iPSDBDevInst.getRemotePassword());
                this.setRemoteUploadMode(this.iPSDBDevInst.getRemoteUploadMode());
                this.setRemoteUploadPath(this.iPSDBDevInst.getRemoteUploadPath());
            }
            this.setLocalRes(this.iPSDBDevInst.isLocalRes());
        } else {
            this.setResPos(psDevCenterDBInst.getRESPOS());
            this.setRemoteAddress(this.psDevCenterDBInst.getHOSTADDRESS());
            if (this.psDevCenterDBInst.getHOSTSSHPORT() > 0) {
                this.setRemotePort(this.psDevCenterDBInst.getHOSTSSHPORT());
            }
            this.setRemoteUserName(this.psDevCenterDBInst.getHOSTUSERNAME());
            this.setRemotePassword(this.psDevCenterDBInst.getHOSTPASSWD());
            if (!StringHelper.isNullOrEmpty((String)this.psDevCenterDBInst.getUPLOADFILEMODE())) {
                this.setRemoteUploadMode(this.psDevCenterDBInst.getUPLOADFILEMODE());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDevCenterDBInst.getUPLOADPATH())) {
                this.setRemoteUploadPath(this.psDevCenterDBInst.getUPLOADPATH());
            }
            PSDBServer psDBServer = new PSDBServer();
            psDBServer.setPSDBSERVERID(this.psDevCenterDBInst.getPSDEVCENTERDBINSTID());
            psDBServer.setPSDBSERVERNAME(this.psDevCenterDBInst.getPSDEVCENTERDBINSTNAME());
            psDBServer.setDBTYPE(this.psDevCenterDBInst.getDBTYPE());
            psDBServer.setDBPORT(this.psDevCenterDBInst.getDBPORT());
            psDBServer.setIPADDR(this.psDevCenterDBInst.getHOSTADDRESS());
            psDBServer.setPORT(this.psDevCenterDBInst.getHOSTSSHPORT());
            psDBServer.setUSERNAME(this.psDevCenterDBInst.getHOSTUSERNAME());
            psDBServer.setPASSWD(this.psDevCenterDBInst.getHOSTPASSWD());
            psDBServer.setDBUSERNAME(this.psDevCenterDBInst.getUSERNAME());
            psDBServer.setDBPASSWD(this.psDevCenterDBInst.getPASSWD());
            psDBServer.setUPLOADPATH(this.psDevCenterDBInst.getUPLOADPATH());
            psDBServer.setUPLOADFILEMODE(this.psDevCenterDBInst.getUPLOADFILEMODE());
            psDBServer.setDBINSTALLPATH(this.psDevCenterDBInst.getDBINSTALLPATH());
            PSDBServerImpl psDBServerImpl = new PSDBServerImpl();
            psDBServerImpl.init(iDAGlobalHelper, psDBServer);
            this.iPSDBServer = psDBServerImpl;
        }
        if (!this.psDevCenterDBInst.isRESPOSNull()) {
            this.setResPos(this.psDevCenterDBInst.getRESPOS());
        }
        if (!this.psDevCenterDBInst.isRESSTATENull()) {
            this.setResState(this.psDevCenterDBInst.getRESSTATE());
        }
        this.onInit();
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDevCenterDBInst psDevCenterDBInst) throws Exception {
        this.init(iDAGlobalHelper, null, psDevCenterDBInst);
    }

    protected IPSDBDevInst getPSDBDevInst() {
        return this.iPSDBDevInst;
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDBDevInst psDevCenterDBInst) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u7c7b\u578b", codelist="DBType")
    public String getDBType() {
        if (this.getPSDBDevInst() != null) {
            return this.iPSDBDevInst.getDBType();
        }
        return this.psDevCenterDBInst.getDBTYPE();
    }

    @Override
    public Connection getConnection() throws SQLException {
        if (this.getPSDBDevInst() != null) {
            return this.iPSDBDevInst.getConnection();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u540d\u79f0")
    public String getDBName() {
        if (this.getPSDBDevInst() != null) {
            return this.getPSDBDevInst().getDBName();
        }
        return this.psDevCenterDBInst.getDBNAME();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u8fde\u63a5\u4e32")
    public String getConnUrl() {
        if (this.getPSDBDevInst() != null) {
            return this.getPSDBDevInst().getConnUrl();
        }
        return this.psDevCenterDBInst.getCONNSTR();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u7528\u6237\u540d", debugmode=true)
    public String getUserName() {
        if (this.getPSDBDevInst() != null) {
            return this.getPSDBDevInst().getUserName();
        }
        return this.psDevCenterDBInst.getUSERNAME();
    }

    @Override
    public String getPassword() {
        if (this.getPSDBDevInst() != null) {
            return this.getPSDBDevInst().getPassword();
        }
        return this.psDevCenterDBInst.getPASSWD();
    }

    @Override
    public String getDBSchema() {
        if (this.getPSDBDevInst() != null) {
            return this.getPSDBDevInst().getDBSchema();
        }
        return null;
    }

    @Override
    public String getDBClientPath() {
        return this.psDevCenterDBInst.getDBINSTALLPATH();
    }

    @Override
    protected void onFillResCfgParams(Map<String, String> params) throws Exception {
        super.onFillResCfgParams(params);
        if (this.getDBName() != null) {
            params.put("db.name", this.getDBName());
        }
        if (this.getDBType() != null) {
            params.put("db.type", this.getDBType());
        }
        if (this.getDBSchema() != null) {
            params.put("db.scheme", this.getDBSchema());
        }
        if (this.getUserName() != null) {
            params.put("db.user", this.getUserName());
        }
        if (this.getPassword() != null) {
            params.put("db.pass", this.getPassword());
        }
        if (this.getDBClientPath() != null) {
            params.put("db.path", this.getDBClientPath());
        }
        if (this.getRemoteAddress() != null) {
            params.put("db.addr", this.getRemoteAddress());
        }
    }

    @Override
    public String getModelType() {
        return "PSDEVCENTERDBINST";
    }

    @Override
    public long getLastActiveTime() {
        if (this.iPSDBDevInst != null) {
            return this.iPSDBDevInst.getLastActiveTime();
        }
        return 0L;
    }

    @Override
    public void active() {
        if (this.iPSDBDevInst != null) {
            this.iPSDBDevInst.active();
        }
    }

    @Override
    public boolean isClose() {
        if (this.iPSDBDevInst != null) {
            return this.iPSDBDevInst.isClose();
        }
        return true;
    }

    @Override
    public void close() {
        if (this.iPSDBDevInst != null) {
            this.iPSDBDevInst.close();
        }
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5bb9\u5668", debugmode=true)
    public IPSDCAppServer getPSDCAppServer() {
        return this.iPSDCAppServer;
    }

    @Override
    public String getPSDBServerId() {
        if (this.iPSDBDevInst != null) {
            return this.iPSDBDevInst.getPSDBServerId();
        }
        return this.getId();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u670d\u52a1\u5668", debugmode=true)
    public IPSDBServer getPSDBServer() throws Exception {
        if (this.iPSDBDevInst != null) {
            return this.iPSDBDevInst.getPSDBServer();
        }
        return this.iPSDBServer;
    }

    @Override
    public String getDBSchemaOrName() {
        if (this.getPSDBDevInst() != null) {
            return this.getPSDBDevInst().getDBSchemaOrName();
        }
        return null;
    }
}

