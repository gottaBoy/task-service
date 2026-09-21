/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepFunc;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepFuncItem;
import SA.SRFDA.PS.Core.Deploy.PSDCMSPDeployItemImplBase;
import SA.SRFDA.PS.Data.PSDevSlnMSDepFuncItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;

public abstract class PSDevSlnMSDepFuncItemImplBase
extends PSDCMSPDeployItemImplBase
implements IPSDevSlnMSDepFuncItem {
    protected PSDevSlnMSDepFuncItem psDevSlnMSDepFuncItem = null;
    private IPSDevSlnMSDepFunc iPSDevSlnMSDepFunc = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDevSlnMSDepFunc iPSDevSlnMSDepFunc, PSDevSlnMSDepFuncItem psDevSlnMSDepFuncItem) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDevSlnMSDepFuncItem = psDevSlnMSDepFuncItem;
        this.iPSDevSlnMSDepFunc = iPSDevSlnMSDepFunc;
        this.setId(this.psDevSlnMSDepFuncItem.getPSDEVSLNMSDEPFUNCITEMID());
        this.setName(this.psDevSlnMSDepFuncItem.getPSDEVSLNMSDEPFUNCITEMNAME());
        this.setPSObjectData(this.psDevSlnMSDepFuncItem);
        this.setPSDCMSPlatform(this.getPSDevSlnMSDepFunc().getPSDCMSPlatform());
        this.setPSDCMSPlatformNode(this.getPSDevSlnMSDepFunc().getPSDCMSPlatformNode());
        this.onInit();
    }

    @Override
    public IPSDevSlnMSDepFunc getPSDevSlnMSDepFunc() {
        return this.iPSDevSlnMSDepFunc;
    }

    @Override
    public String getModelType() {
        return "PSDEVSLNMSDEPFUNCITEM";
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDevSlnMSDepFunc().getModelId(), (Object)this.getId());
    }
}

