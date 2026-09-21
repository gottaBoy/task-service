/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDCCluster;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Data.PSDCCluster;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.sql.Timestamp;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCClusterImpl
extends PSDCResObjectImplBase
implements IPSDCCluster {
    private static final Log log = LogFactory.getLog(PSDCClusterImpl.class);
    protected PSDCCluster psDCCluster = null;
    private String strSSHIpAddr = null;
    private int nSSHPort = 22;
    private String strSSHUserName = null;
    private String strSSHPassword = null;
    private String strUploadPath = null;
    private String strWorkshopPath = null;
    private String strLocalSSHIpAddr = null;
    private int nLocalSSHPort = 22;
    private Properties clusterParams = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDCCluster psDCCluster) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDCCluster = psDCCluster;
        this.setId(this.psDCCluster.getPSDCCLUSTERID());
        this.setName(this.psDCCluster.getPSDCCLUSTERNAME());
        this.setPSObjectData(this.psDCCluster);
        if (this.psDCCluster.getEXPRIEDTIME() != null) {
            this.setExpiredTime(new Timestamp(this.psDCCluster.getEXPRIEDTIME().getTime()));
        }
        this.strLocalSSHIpAddr = this.psDCCluster.getIPADDR();
        if (!this.psDCCluster.isPORTNull()) {
            this.nLocalSSHPort = this.psDCCluster.getPORT();
        }
        if (StringHelper.isNullOrEmpty((String)this.strSSHIpAddr)) {
            this.strSSHIpAddr = this.strLocalSSHIpAddr;
        }
        this.setRemoteAddress(this.strSSHIpAddr);
        this.setRemotePort(this.nSSHPort);
        this.strSSHUserName = this.psDCCluster.getUSERNAME();
        this.setRemoteUserName(this.strSSHUserName);
        this.setRemotePassword(this.strSSHPassword);
        this.setResPos(2);
        if (!this.psDCCluster.isRESPOSNull()) {
            this.setResPos(this.psDCCluster.getRESPOS());
        }
        if (!this.psDCCluster.isRESSTATENull()) {
            this.setResState(this.psDCCluster.getRESSTATE());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCCluster.getCLUSTERPARAMS())) {
            this.clusterParams = PropertiesHelper.load((String)this.psDCCluster.getCLUSTERPARAMS());
        }
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getSSHIPAddr() {
        return this.strSSHIpAddr;
    }

    @Override
    public int getSSHPort() {
        return this.nSSHPort;
    }

    @Override
    public String getSSHUserName() {
        return this.strSSHUserName;
    }

    @Override
    public String getSSHPassword() {
        return this.strSSHPassword;
    }

    @Override
    protected void onFillResCfgParams(Map<String, String> params) throws Exception {
        super.onFillResCfgParams(params);
        if (!StringHelper.isNullOrEmpty((String)this.getLocalSSHIPAddr())) {
            params.put("host.addr2", this.getLocalSSHIPAddr());
            params.put("host.port2", StringHelper.format((String)"%1$s", (Object)this.getLocalSSHPort()));
        }
    }

    @Override
    public String getModelType() {
        return "PSDCCLUSTER";
    }

    @Override
    public String getLocalSSHIPAddr() {
        return this.strLocalSSHIpAddr;
    }

    @Override
    public int getLocalSSHPort() {
        return this.nLocalSSHPort;
    }

    public Properties getClusterParams() {
        return this.clusterParams;
    }
}

