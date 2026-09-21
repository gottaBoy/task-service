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

import SA.SRFDA.PS.Core.Deploy.IPSAppServer;
import SA.SRFDA.PS.Core.Deploy.IPSDepSln;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnAS;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnResObjectImpl;
import SA.SRFDA.PS.Data.PSDepSlnAS;
import SA.SRFDA.PS.Data.PSDevCenterAS;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnASImpl
extends PSDepSlnResObjectImpl
implements IPSDepSlnAS {
    private static final Log log = LogFactory.getLog(PSDepSlnASImpl.class);
    protected PSDepSlnAS psDepSlnAS = null;
    protected IPSAppServer iPSAppServer = null;
    protected PSDevCenterAS psDevCenterAS = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDepSln iPSDepSln, PSDepSlnAS psDepSlnAS) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSDepSln(iPSDepSln);
        this.psDepSlnAS = psDepSlnAS;
        this.setId(this.psDepSlnAS.getPSDEPSLNASID());
        this.setName(this.psDepSlnAS.getPSDEPSLNASNAME());
        this.setPSObjectData(this.psDepSlnAS);
        if (!this.psDepSlnAS.isENABLELOCALMODENull()) {
            this.setEnableLocalDeploy(this.psDepSlnAS.getENABLELOCALMODE());
        }
        if (!this.psDepSlnAS.isENABLEREMOTEMODENull()) {
            this.setEnableRemoteDeploy(this.psDepSlnAS.getENABLEREMOTEMODE());
        }
        if (this.isEnableRemoteDeploy()) {
            if (!StringHelper.isNullOrEmpty((String)this.psDepSlnAS.getPSDEVCENTERASID())) {
                this.psDevCenterAS = new PSDevCenterAS();
                CallResult callResult = this.getPSModelHelper().getPSDevCenterAS(this.psDepSlnAS.getPSDEVCENTERASID(), this.psDevCenterAS);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u4e2d\u5fc3\u5e94\u7528\u5bb9\u5668[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.psDepSlnAS.getPSDEVCENTERASID(), (Object)callResult.getErrorInfo()));
                }
                if (!StringHelper.isNullOrEmpty((String)this.psDevCenterAS.getPSAPPSERVERID())) {
                    this.iPSAppServer = this.getPSModelStorage().getPSAppServer(this.psDevCenterAS.getPSAPPSERVERID());
                }
            }
            if (this.iPSAppServer == null) {
                throw new Exception("\u6ca1\u6709\u4e3a\u4e91\u7aef\u90e8\u7f72\u6307\u5b9a\u4e91\u7aef\u8d44\u6e90");
            }
        }
        if (this.isEnableLocalDeploy()) {
            this.setPSDepSlnHostId(this.psDepSlnAS.getPSDEPSLNHOSTID());
            if (this.getPSDepSlnHost() == null) {
                throw new Exception("\u6ca1\u6709\u4e3a\u672c\u5730\u90e8\u7f72\u6307\u5b9a\u4e3b\u673a\u8d44\u6e90");
            }
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDEPSLNAS";
    }

    @Override
    public String getASType(boolean bRemote) throws Exception {
        if (bRemote) {
            if (!this.isEnableRemoteDeploy()) {
                throw new Exception("\u4e0d\u652f\u6301\u4e91\u7aef\u90e8\u7f72");
            }
            return this.iPSAppServer.getASType();
        }
        if (!this.isEnableLocalDeploy()) {
            throw new Exception("\u4e0d\u652f\u6301\u672c\u5730\u90e8\u7f72");
        }
        return this.psDepSlnAS.getASTYPE();
    }

    @Override
    public int getHttpPort(boolean bRemote) throws Exception {
        if (bRemote) {
            if (!this.isEnableRemoteDeploy()) {
                throw new Exception("\u4e0d\u652f\u6301\u4e91\u7aef\u90e8\u7f72");
            }
            return this.psDevCenterAS.getHTTPPORT();
        }
        if (!this.isEnableLocalDeploy()) {
            throw new Exception("\u4e0d\u652f\u6301\u672c\u5730\u90e8\u7f72");
        }
        return this.psDepSlnAS.getHTTPPORT();
    }
}

