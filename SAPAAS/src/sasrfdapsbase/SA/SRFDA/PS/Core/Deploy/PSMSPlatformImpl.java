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

import SA.SRFDA.PS.Core.Deploy.IPSMSPlatform;
import SA.SRFDA.PS.Core.Deploy.IPSMSPlatformFunc;
import SA.SRFDA.PS.Core.Deploy.IPSMSPlatformNode;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.Deploy.PSMSPlatformFuncImpl;
import SA.SRFDA.PS.Core.Deploy.PSMSPlatformNodeImpl;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSMSPlatform;
import SA.SRFDA.PS.Data.PSMSPlatformFunc;
import SA.SRFDA.PS.Data.PSMSPlatformNode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSMSPlatformImpl
extends PSDCResObjectImplBase
implements IPSMSPlatform {
    private static final Log log = LogFactory.getLog(PSMSPlatformImpl.class);
    protected PSMSPlatform psMSPlatform = null;
    private String strSSHIpAddr = null;
    private int nSSHPort = 22;
    private String strLocalSSHIpAddr = null;
    private int nLocalSSHPort = 22;
    private String strSSHUserName = null;
    private String strSSHPassword = null;
    private String strUploadMode = "SSH";
    private String strUploadPath = null;
    private String strWorkshopPath = null;
    protected HashMap<String, IPSMSPlatformFunc> psMSPlatformFuncMap = new HashMap();
    protected HashMap<String, IPSMSPlatformNode> psMSPlatformNodeMap = new HashMap();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSMSPlatform psMSPlatform) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psMSPlatform = psMSPlatform;
        this.setId(this.psMSPlatform.getPSMSPLATFORMID());
        this.setName(this.psMSPlatform.getPSMSPLATFORMNAME());
        this.setPSObjectData(this.psMSPlatform);
        this.strLocalSSHIpAddr = this.psMSPlatform.getIPADDR();
        if (!this.psMSPlatform.isPORTNull()) {
            this.nLocalSSHPort = this.psMSPlatform.getPORT();
        }
        this.strSSHIpAddr = this.psMSPlatform.getSSHIPADDR();
        if (!this.psMSPlatform.isSSHPORTNull()) {
            this.nSSHPort = this.psMSPlatform.getSSHPORT();
        }
        if (StringHelper.isNullOrEmpty((String)this.strSSHIpAddr)) {
            this.strSSHIpAddr = this.strLocalSSHIpAddr;
        }
        this.setRemoteAddress(this.strSSHIpAddr);
        this.setRemotePort(this.nSSHPort);
        this.strSSHUserName = this.psMSPlatform.getUSERNAME();
        this.strSSHPassword = this.psMSPlatform.getPASSWD();
        this.setRemoteUserName(this.strSSHUserName);
        this.setRemotePassword(this.strSSHPassword);
        if (!StringHelper.isNullOrEmpty((String)this.psMSPlatform.getUPLOADFILEMODE())) {
            this.strUploadMode = this.psMSPlatform.getUPLOADFILEMODE();
        }
        this.strUploadPath = this.psMSPlatform.getUPLOADPATH();
        this.strWorkshopPath = this.psMSPlatform.getWORKSHOPPATH();
        this.setRemoteUploadMode(this.strUploadMode);
        this.setRemoteUploadPath(this.strUploadPath);
        this.onPreparePSMSPlatformFuncs();
        this.onPreparePSMSPlatformNodes();
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
        return "PSMSPLATFORM";
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void onPreparePSMSPlatformFuncs() throws Exception {
        HashMap<String, IPSMSPlatformFunc> hashMap = this.psMSPlatformFuncMap;
        synchronized (hashMap) {
            this.psMSPlatformFuncMap.clear();
            Vector<PSMSPlatformFunc> psMSPlatformFuncList = new Vector<PSMSPlatformFunc>();
            CallResult callResullt = this.getPSModelHelper().getPSMSPlatformFuncs(this.getId(), psMSPlatformFuncList);
            if (callResullt.isError()) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5fae\u670d\u52a1\u5e73\u53f0\u529f\u80fd\u96c6\u5408\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResullt.getErrorInfo()));
            }
            for (PSMSPlatformFunc psMSPlatformFunc : psMSPlatformFuncList) {
                if (!psMSPlatformFunc.isVALIDFLAGNull() && !psMSPlatformFunc.getVALIDFLAG()) continue;
                PSMSPlatformFuncImpl iPSMSPlatformFunc = new PSMSPlatformFuncImpl();
                iPSMSPlatformFunc.init(this.getDAGlobalHelper(), this, psMSPlatformFunc);
                this.psMSPlatformFuncMap.put(iPSMSPlatformFunc.getId(), iPSMSPlatformFunc);
                if (StringHelper.isNullOrEmpty((String)iPSMSPlatformFunc.getFuncType())) continue;
                this.psMSPlatformFuncMap.put(iPSMSPlatformFunc.getFuncType(), iPSMSPlatformFunc);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void onPreparePSMSPlatformNodes() throws Exception {
        HashMap<String, IPSMSPlatformNode> hashMap = this.psMSPlatformNodeMap;
        synchronized (hashMap) {
            this.psMSPlatformNodeMap.clear();
            Vector<PSMSPlatformNode> psMSPlatformNodeList = new Vector<PSMSPlatformNode>();
            CallResult callResullt = this.getPSModelHelper().getPSMSPlatformNodes(this.getId(), psMSPlatformNodeList);
            if (callResullt.isError()) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5fae\u670d\u52a1\u5e73\u53f0\u8282\u70b9\u96c6\u5408\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResullt.getErrorInfo()));
            }
            for (PSMSPlatformNode psMSPlatformNode : psMSPlatformNodeList) {
                if (!psMSPlatformNode.isVALIDFLAGNull() && !psMSPlatformNode.getVALIDFLAG()) continue;
                PSMSPlatformNodeImpl iPSMSPlatformNode = new PSMSPlatformNodeImpl();
                iPSMSPlatformNode.init(this.getDAGlobalHelper(), this, psMSPlatformNode);
                this.psMSPlatformNodeMap.put(iPSMSPlatformNode.getId(), iPSMSPlatformNode);
            }
        }
    }

    @Override
    public IPSMSPlatformFunc getPSMSPlatformFunc(String strPSMSPlatformFuncId) throws Exception {
        IPSMSPlatformFunc iPSMSPlatformFunc = this.psMSPlatformFuncMap.get(strPSMSPlatformFuncId);
        if (iPSMSPlatformFunc == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5fae\u670d\u52a1\u5e73\u53f0\u529f\u80fd[%1$s]", (Object)strPSMSPlatformFuncId));
        }
        return iPSMSPlatformFunc;
    }

    @Override
    public IPSMSPlatformNode getPSMSPlatformNode(String strPSMSPlatformNodeId) throws Exception {
        IPSMSPlatformNode iPSMSPlatformNode = this.psMSPlatformNodeMap.get(strPSMSPlatformNodeId);
        if (iPSMSPlatformNode == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5fae\u670d\u52a1\u5e73\u53f0\u8282\u70b9[%1$s]", (Object)strPSMSPlatformNodeId));
        }
        return iPSMSPlatformNode;
    }
}

