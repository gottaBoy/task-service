/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDCCluster;
import SA.SRFDA.PS.Core.Deploy.IPSDCMSPlatform;
import SA.SRFDA.PS.Core.Deploy.IPSDCMSPlatformFunc;
import SA.SRFDA.PS.Core.Deploy.IPSDCMSPlatformNode;
import SA.SRFDA.PS.Core.Deploy.IPSMSPlatform;
import SA.SRFDA.PS.Core.Deploy.IPSMSPlatformFunc;
import SA.SRFDA.PS.Core.Deploy.IPSMSPlatformNode;
import SA.SRFDA.PS.Core.Deploy.PSDCMSPlatformFuncImpl;
import SA.SRFDA.PS.Core.Deploy.PSDCMSPlatformNodeImpl;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Data.PSDCMSPlatform;
import SA.SRFDA.PS.Data.PSDCMSPlatformFunc;
import SA.SRFDA.PS.Data.PSDCMSPlatformNode;
import SA.SRFDA.PS.Data.PSMSPlatform;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCMSPlatformImpl
extends PSDCResObjectImplBase
implements IPSDCMSPlatform {
    private static final Log log = LogFactory.getLog(PSDCMSPlatformImpl.class);
    protected PSDCMSPlatform psDCMSPlatform = null;
    private String strSSHIpAddr = null;
    private int nSSHPort = 22;
    private String strSSHUserName = null;
    private String strSSHPassword = null;
    private String strUploadMode = "SSH";
    private IPSMSPlatform iPSMSPlatform = null;
    private String strUploadPath = null;
    private String strWorkshopPath = null;
    private String strLocalSSHIpAddr = null;
    private int nLocalSSHPort = 22;
    private Properties platformParams = null;
    private IPSDCCluster iPSDCCluster = null;
    protected HashMap<String, IPSDCMSPlatformFunc> psDCMSPlatformFuncMap = new HashMap();
    protected HashMap<String, IPSDCMSPlatformNode> psDCMSPlatformNodeMap = new HashMap();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDCMSPlatform psDCMSPlatform) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDCMSPlatform = psDCMSPlatform;
        this.setId(this.psDCMSPlatform.getPSDCMSPLATFORMID());
        this.setName(this.psDCMSPlatform.getPSDCMSPLATFORMNAME());
        this.setPSObjectData(this.psDCMSPlatform);
        if (this.psDCMSPlatform.getEXPRIEDTIME() != null) {
            this.setExpiredTime(new Timestamp(this.psDCMSPlatform.getEXPRIEDTIME().getTime()));
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCMSPlatform.getPSMSPLATFORMID())) {
            this.iPSMSPlatform = this.getPSModelStorage().getPSMSPlatform(this.psDCMSPlatform.getPSMSPLATFORMID());
            this.setRemoteAddress(this.iPSMSPlatform.getRemoteAddress());
            this.setRemoteUserName(this.iPSMSPlatform.getRemoteUserName());
            this.setRemotePassword(this.iPSMSPlatform.getRemotePassword());
            this.setRemotePort(this.iPSMSPlatform.getRemotePort());
            this.setRemoteUploadMode(this.iPSMSPlatform.getRemoteUploadMode());
            this.setRemoteUploadPath(this.iPSMSPlatform.getRemoteUploadPath());
            this.setLocalRes(this.iPSMSPlatform.isLocalRes());
        } else {
            this.strLocalSSHIpAddr = this.psDCMSPlatform.getIPADDR();
            if (!this.psDCMSPlatform.isPORTNull()) {
                this.nLocalSSHPort = this.psDCMSPlatform.getPORT();
            }
            this.strSSHIpAddr = this.psDCMSPlatform.getSSHIPADDR();
            if (!this.psDCMSPlatform.isSSHPORTNull()) {
                this.nSSHPort = this.psDCMSPlatform.getSSHPORT();
            }
            if (StringHelper.isNullOrEmpty((String)this.strSSHIpAddr)) {
                this.strSSHIpAddr = this.strLocalSSHIpAddr;
            }
            this.setRemoteAddress(this.strSSHIpAddr);
            this.setRemotePort(this.nSSHPort);
            this.strSSHUserName = this.psDCMSPlatform.getUSERNAME();
            this.strSSHPassword = this.psDCMSPlatform.getPASSWD();
            this.setRemoteUserName(this.strSSHUserName);
            this.setRemotePassword(this.strSSHPassword);
            if (!StringHelper.isNullOrEmpty((String)this.psDCMSPlatform.getUPLOADFILEMODE())) {
                this.strUploadMode = this.psDCMSPlatform.getUPLOADFILEMODE();
            }
            this.strUploadPath = this.psDCMSPlatform.getUPLOADPATH();
            this.setRemoteUploadMode(this.strUploadMode);
            this.setRemoteUploadPath(this.strUploadPath);
            this.setResPos(2);
        }
        if (!this.psDCMSPlatform.isRESPOSNull()) {
            this.setResPos(this.psDCMSPlatform.getRESPOS());
        }
        if (!this.psDCMSPlatform.isRESSTATENull()) {
            this.setResState(this.psDCMSPlatform.getRESSTATE());
        }
        this.strWorkshopPath = this.psDCMSPlatform.getWORKSHOPPATH();
        if (!StringHelper.isNullOrEmpty((String)this.psDCMSPlatform.getUSERPARAMS())) {
            this.platformParams = PropertiesHelper.load((String)this.psDCMSPlatform.getUSERPARAMS());
        }
        this.onPreparePSDCMSPlatformFuncs();
        this.onPreparePSDCMSPlatformNodes();
        this.onInit();
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSMSPlatform psDCMSPlatform) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getSSHIPAddr() {
        if (this.iPSMSPlatform != null) {
            return this.iPSMSPlatform.getSSHIPAddr();
        }
        return this.strSSHIpAddr;
    }

    @Override
    public int getSSHPort() {
        if (this.iPSMSPlatform != null) {
            return this.iPSMSPlatform.getSSHPort();
        }
        return this.nSSHPort;
    }

    @Override
    public String getSSHUserName() {
        if (this.iPSMSPlatform != null) {
            return this.iPSMSPlatform.getSSHUserName();
        }
        return this.strSSHUserName;
    }

    @Override
    public String getSSHPassword() {
        if (this.iPSMSPlatform != null) {
            return this.iPSMSPlatform.getSSHPassword();
        }
        return this.strSSHPassword;
    }

    @Override
    public String getUploadMode() {
        if (this.iPSMSPlatform != null) {
            return this.iPSMSPlatform.getUploadMode();
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
        return "PSDCMSPLATFORM";
    }

    @Override
    public String getUploadPath() {
        if (this.iPSMSPlatform != null) {
            return this.iPSMSPlatform.getUploadPath();
        }
        return this.strUploadPath;
    }

    @Override
    public String getWorkshopPath() {
        if (this.iPSMSPlatform != null) {
            return this.iPSMSPlatform.getWorkshopPath();
        }
        return this.strWorkshopPath;
    }

    @Override
    public String getLocalSSHIPAddr() {
        if (this.iPSMSPlatform != null) {
            return this.iPSMSPlatform.getLocalSSHIPAddr();
        }
        return this.strLocalSSHIpAddr;
    }

    @Override
    public int getLocalSSHPort() {
        if (this.iPSMSPlatform != null) {
            return this.iPSMSPlatform.getLocalSSHPort();
        }
        return this.nLocalSSHPort;
    }

    @Override
    public IPSMSPlatformFunc getPSMSPlatformFunc(String strPSMSPlatformFuncId) throws Exception {
        if (this.iPSMSPlatform != null) {
            return this.iPSMSPlatform.getPSMSPlatformFunc(strPSMSPlatformFuncId);
        }
        return this.getPSDCMSPlatformFunc(strPSMSPlatformFuncId);
    }

    @Override
    public IPSMSPlatformNode getPSMSPlatformNode(String strPSMSPlatformNodeId) throws Exception {
        if (this.iPSMSPlatform != null) {
            return this.iPSMSPlatform.getPSMSPlatformNode(strPSMSPlatformNodeId);
        }
        return this.getPSDCMSPlatformNode(strPSMSPlatformNodeId);
    }

    @Override
    public IPSMSPlatform getPSMSPlatform() {
        return this.iPSMSPlatform;
    }

    @Override
    public IPSDCCluster getPSDCCluster() throws Exception {
        if (this.iPSDCCluster != null) {
            return this.iPSDCCluster;
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDCMSPlatform.getPSDCCLUSTERID())) {
            this.iPSDCCluster = this.getPSModelStorage().getPSDCCluster(this.psDCMSPlatform.getPSDCCLUSTERID());
        }
        return this.iPSDCCluster;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void onPreparePSDCMSPlatformFuncs() throws Exception {
        HashMap<String, IPSDCMSPlatformFunc> hashMap = this.psDCMSPlatformFuncMap;
        synchronized (hashMap) {
            this.psDCMSPlatformFuncMap.clear();
            Vector<PSDCMSPlatformFunc> psDCMSPlatformFuncList = new Vector<PSDCMSPlatformFunc>();
            CallResult callResullt = this.getPSModelHelper().getPSDCMSPlatformFuncs(this.getId(), psDCMSPlatformFuncList);
            if (callResullt.isError()) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5fae\u670d\u52a1\u5e73\u53f0\u529f\u80fd\u96c6\u5408\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResullt.getErrorInfo()));
            }
            for (PSDCMSPlatformFunc psDCMSPlatformFunc : psDCMSPlatformFuncList) {
                if (!psDCMSPlatformFunc.isVALIDFLAGNull() && !psDCMSPlatformFunc.getVALIDFLAG()) continue;
                PSDCMSPlatformFuncImpl iPSDCMSPlatformFunc = new PSDCMSPlatformFuncImpl();
                iPSDCMSPlatformFunc.init(this.getDAGlobalHelper(), this, psDCMSPlatformFunc);
                this.psDCMSPlatformFuncMap.put(iPSDCMSPlatformFunc.getId(), iPSDCMSPlatformFunc);
                if (StringHelper.isNullOrEmpty((String)iPSDCMSPlatformFunc.getFuncType())) continue;
                this.psDCMSPlatformFuncMap.put(iPSDCMSPlatformFunc.getFuncType(), iPSDCMSPlatformFunc);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void onPreparePSDCMSPlatformNodes() throws Exception {
        HashMap<String, IPSDCMSPlatformNode> hashMap = this.psDCMSPlatformNodeMap;
        synchronized (hashMap) {
            this.psDCMSPlatformNodeMap.clear();
            Vector<PSDCMSPlatformNode> psDCMSPlatformNodeList = new Vector<PSDCMSPlatformNode>();
            CallResult callResullt = this.getPSModelHelper().getPSDCMSPlatformNodes(this.getId(), psDCMSPlatformNodeList);
            if (callResullt.isError()) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5fae\u670d\u52a1\u5e73\u53f0\u8282\u70b9\u96c6\u5408\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResullt.getErrorInfo()));
            }
            for (PSDCMSPlatformNode psDCMSPlatformNode : psDCMSPlatformNodeList) {
                if (!psDCMSPlatformNode.isVALIDFLAGNull() && !psDCMSPlatformNode.getVALIDFLAG()) continue;
                PSDCMSPlatformNodeImpl iPSDCMSPlatformNode = new PSDCMSPlatformNodeImpl();
                iPSDCMSPlatformNode.init(this.getDAGlobalHelper(), this, psDCMSPlatformNode);
                this.psDCMSPlatformNodeMap.put(iPSDCMSPlatformNode.getId(), iPSDCMSPlatformNode);
            }
        }
    }

    @Override
    public IPSDCMSPlatformFunc getPSDCMSPlatformFunc(String strPSDCMSPlatformFuncId) throws Exception {
        IPSDCMSPlatformFunc iPSDCMSPlatformFunc = this.psDCMSPlatformFuncMap.get(strPSDCMSPlatformFuncId);
        if (iPSDCMSPlatformFunc == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5fae\u670d\u52a1\u5e73\u53f0\u529f\u80fd[%1$s]", (Object)strPSDCMSPlatformFuncId));
        }
        return iPSDCMSPlatformFunc;
    }

    @Override
    public IPSDCMSPlatformNode getPSDCMSPlatformNode(String strPSDCMSPlatformNodeId) throws Exception {
        IPSDCMSPlatformNode iPSDCMSPlatformNode = this.psDCMSPlatformNodeMap.get(strPSDCMSPlatformNodeId);
        if (iPSDCMSPlatformNode == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5fae\u670d\u52a1\u5e73\u53f0\u8282\u70b9[%1$s]", (Object)strPSDCMSPlatformNodeId));
        }
        return iPSDCMSPlatformNode;
    }

    @Override
    public Iterator<IPSDCMSPlatformNode> getAllPSDCMSPlatformNodes() {
        return this.psDCMSPlatformNodeMap.values().iterator();
    }

    @Override
    public Iterator<IPSDCMSPlatformFunc> getAllPSDCMSPlatformFuncs() {
        return this.psDCMSPlatformFuncMap.values().iterator();
    }

    public Properties getPlatformParams() {
        return this.platformParams;
    }
}

