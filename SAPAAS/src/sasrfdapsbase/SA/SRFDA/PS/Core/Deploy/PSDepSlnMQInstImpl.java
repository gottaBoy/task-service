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

import SA.SRFDA.PS.Core.Deploy.IPSDepSln;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnMQInst;
import SA.SRFDA.PS.Core.Deploy.IPSMQInst;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnResObjectImpl;
import SA.SRFDA.PS.Data.PSDepSlnMQInst;
import SA.SRFDA.PS.Data.PSDevCenterMQ;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnMQInstImpl
extends PSDepSlnResObjectImpl
implements IPSDepSlnMQInst {
    private static final Log log = LogFactory.getLog(PSDepSlnMQInstImpl.class);
    protected PSDepSlnMQInst psDepSlnMQInst = null;
    protected PSDevCenterMQ psDevCenterMQ = null;
    private IPSMQInst iPSMQInst = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDepSln iPSDepSln, PSDepSlnMQInst psDepSlnMQInst) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSDepSln(iPSDepSln);
        this.psDepSlnMQInst = psDepSlnMQInst;
        this.setId(this.psDepSlnMQInst.getPSDEPSLNMQINSTID());
        this.setName(this.psDepSlnMQInst.getPSDEPSLNMQINSTNAME());
        this.setPSObjectData(this.psDepSlnMQInst);
        if (!this.psDepSlnMQInst.isENABLELOCALMODENull()) {
            this.setEnableLocalDeploy(this.psDepSlnMQInst.getENABLELOCALMODE());
        }
        if (!this.psDepSlnMQInst.isENABLEREMOTEMODENull()) {
            this.setEnableRemoteDeploy(this.psDepSlnMQInst.getENABLEREMOTEMODE());
        }
        if (this.isEnableRemoteDeploy()) {
            if (!StringHelper.isNullOrEmpty((String)this.psDepSlnMQInst.getPSDEVCENTERMQID())) {
                this.psDevCenterMQ = new PSDevCenterMQ();
                CallResult callResult = this.getPSModelHelper().getPSDCMQInst(this.psDepSlnMQInst.getPSDEVCENTERMQID(), this.psDevCenterMQ);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u4e2d\u5fc3MQ\u5b9e\u4f8b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.psDepSlnMQInst.getPSDEVCENTERMQID(), (Object)callResult.getErrorInfo()));
                }
                if (!StringHelper.isNullOrEmpty((String)this.psDevCenterMQ.getPSMQINSTID())) {
                    this.iPSMQInst = this.getPSModelStorage().getPSMQInst(this.psDevCenterMQ.getPSMQINSTID());
                }
            }
            if (this.iPSMQInst == null) {
                throw new Exception("\u6ca1\u6709\u4e3a\u4e91\u7aef\u90e8\u7f72\u6307\u5b9a\u4e91\u7aef\u8d44\u6e90");
            }
        }
        if (this.isEnableLocalDeploy()) {
            this.setPSDepSlnHostId(this.psDepSlnMQInst.getPSDEPSLNHOSTID());
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
        return "PSDEPSLNMQINST";
    }

    @Override
    public String getMQType(boolean bRemote) throws Exception {
        if (bRemote) {
            if (!this.isEnableRemoteDeploy()) {
                throw new Exception("\u4e0d\u652f\u6301\u4e91\u7aef\u90e8\u7f72");
            }
            return this.iPSMQInst.getMQType();
        }
        if (!this.isEnableLocalDeploy()) {
            throw new Exception("\u4e0d\u652f\u6301\u672c\u5730\u90e8\u7f72");
        }
        return this.psDepSlnMQInst.getMQTYPE();
    }

    @Override
    public String getConnUrl(boolean bRemote) throws Exception {
        if (bRemote) {
            if (!this.isEnableRemoteDeploy()) {
                throw new Exception("\u4e0d\u652f\u6301\u4e91\u7aef\u90e8\u7f72");
            }
            return this.iPSMQInst.getConnUrl();
        }
        if (!this.isEnableLocalDeploy()) {
            throw new Exception("\u4e0d\u652f\u6301\u672c\u5730\u90e8\u7f72");
        }
        return this.psDepSlnMQInst.getCONNSTR();
    }

    @Override
    public String getUserName(boolean bRemote) throws Exception {
        if (bRemote) {
            if (!this.isEnableRemoteDeploy()) {
                throw new Exception("\u4e0d\u652f\u6301\u4e91\u7aef\u90e8\u7f72");
            }
            return this.iPSMQInst.getUserName();
        }
        if (!this.isEnableLocalDeploy()) {
            throw new Exception("\u4e0d\u652f\u6301\u672c\u5730\u90e8\u7f72");
        }
        return this.psDepSlnMQInst.getUSERNAME();
    }

    @Override
    public String getPassword(boolean bRemote) throws Exception {
        if (bRemote) {
            if (!this.isEnableRemoteDeploy()) {
                throw new Exception("\u4e0d\u652f\u6301\u4e91\u7aef\u90e8\u7f72");
            }
            return this.iPSMQInst.getPassword();
        }
        if (!this.isEnableLocalDeploy()) {
            throw new Exception("\u4e0d\u652f\u6301\u672c\u5730\u90e8\u7f72");
        }
        return this.psDepSlnMQInst.getPASSWD();
    }
}

