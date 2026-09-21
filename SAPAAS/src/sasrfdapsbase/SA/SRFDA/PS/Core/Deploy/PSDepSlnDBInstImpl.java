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

import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.Deploy.IPSDepSln;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnDBInst;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnResObjectImpl;
import SA.SRFDA.PS.Data.PSDepSlnDBInst;
import SA.SRFDA.PS.Data.PSDevCenterDBInst;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnDBInstImpl
extends PSDepSlnResObjectImpl
implements IPSDepSlnDBInst {
    private static final Log log = LogFactory.getLog(PSDepSlnDBInstImpl.class);
    protected PSDepSlnDBInst psDepSlnDBInst = null;
    protected PSDevCenterDBInst psDevCenterDBInst = null;
    protected IPSDBDevInst iPSDBDevInst = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDepSln iPSDepSln, PSDepSlnDBInst psDepSlnDBInst) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSDepSln(iPSDepSln);
        this.psDepSlnDBInst = psDepSlnDBInst;
        this.setId(this.psDepSlnDBInst.getPSDEPSLNDBINSTID());
        this.setName(this.psDepSlnDBInst.getPSDEPSLNDBINSTNAME());
        this.setPSObjectData(this.psDepSlnDBInst);
        if (!this.psDepSlnDBInst.isENABLELOCALMODENull()) {
            this.setEnableLocalDeploy(this.psDepSlnDBInst.getENABLELOCALMODE());
        }
        if (!this.psDepSlnDBInst.isENABLEREMOTEMODENull()) {
            this.setEnableRemoteDeploy(this.psDepSlnDBInst.getENABLEREMOTEMODE());
        }
        if (this.isEnableRemoteDeploy()) {
            if (!StringHelper.isNullOrEmpty((String)this.psDepSlnDBInst.getPSDEVCENTERDBINSTID())) {
                this.psDevCenterDBInst = new PSDevCenterDBInst();
                CallResult callResult = this.getPSModelHelper().getPSDCDBInst(this.psDepSlnDBInst.getPSDEVCENTERDBINSTID(), this.psDevCenterDBInst);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u4e2d\u5fc3\u6570\u636e\u5e93\u5b9e\u4f8b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.psDepSlnDBInst.getPSDEVCENTERDBINSTID(), (Object)callResult.getErrorInfo()));
                }
                if (!StringHelper.isNullOrEmpty((String)this.psDevCenterDBInst.getPSDBDEVINSTID())) {
                    this.iPSDBDevInst = this.getPSModelStorage().getPSDBDevInst(this.psDevCenterDBInst.getPSDBDEVINSTID());
                }
            }
            if (this.iPSDBDevInst == null) {
                throw new Exception("\u6ca1\u6709\u4e3a\u4e91\u7aef\u90e8\u7f72\u6307\u5b9a\u4e91\u7aef\u8d44\u6e90");
            }
        }
        if (this.isEnableLocalDeploy()) {
            this.setPSDepSlnHostId(this.psDepSlnDBInst.getPSDEPSLNHOSTID());
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
        return "PSDEPSLNDBINST";
    }

    @Override
    public String getDBType(boolean bRemote) throws Exception {
        if (bRemote) {
            if (!this.isEnableRemoteDeploy()) {
                throw new Exception("\u4e0d\u652f\u6301\u4e91\u7aef\u90e8\u7f72");
            }
            return this.iPSDBDevInst.getDBType();
        }
        if (!this.isEnableLocalDeploy()) {
            throw new Exception("\u4e0d\u652f\u6301\u672c\u5730\u90e8\u7f72");
        }
        return this.psDepSlnDBInst.getDBTYPE();
    }

    @Override
    public String getConnUrl(boolean bRemote) throws Exception {
        if (bRemote) {
            if (!this.isEnableRemoteDeploy()) {
                throw new Exception("\u4e0d\u652f\u6301\u4e91\u7aef\u90e8\u7f72");
            }
            return this.iPSDBDevInst.getConnUrl();
        }
        if (!this.isEnableLocalDeploy()) {
            throw new Exception("\u4e0d\u652f\u6301\u672c\u5730\u90e8\u7f72");
        }
        return this.psDepSlnDBInst.getCONNSTR();
    }

    @Override
    public String getUserName(boolean bRemote) throws Exception {
        if (bRemote) {
            if (!this.isEnableRemoteDeploy()) {
                throw new Exception("\u4e0d\u652f\u6301\u4e91\u7aef\u90e8\u7f72");
            }
            return this.iPSDBDevInst.getUserName();
        }
        if (!this.isEnableLocalDeploy()) {
            throw new Exception("\u4e0d\u652f\u6301\u672c\u5730\u90e8\u7f72");
        }
        return this.psDepSlnDBInst.getUSERNAME();
    }

    @Override
    public String getPassword(boolean bRemote) throws Exception {
        if (bRemote) {
            if (!this.isEnableRemoteDeploy()) {
                throw new Exception("\u4e0d\u652f\u6301\u4e91\u7aef\u90e8\u7f72");
            }
            return this.iPSDBDevInst.getPassword();
        }
        if (!this.isEnableLocalDeploy()) {
            throw new Exception("\u4e0d\u652f\u6301\u672c\u5730\u90e8\u7f72");
        }
        return this.psDepSlnDBInst.getPASSWD();
    }
}

