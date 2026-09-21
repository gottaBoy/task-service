/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepSlnHost;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnResObject;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnObjectImpl;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSDepSlnResObjectImpl
extends PSDepSlnObjectImpl
implements IPSDepSlnResObject {
    private IPSDepSlnHost iPSDepSlnHost = null;
    private boolean bEnableRemoteDeploy = false;
    private boolean bEnableLocalDeploy = false;

    protected void setPSDepSlnHostId(String strPSDepSlnHostId) throws Exception {
        this.iPSDepSlnHost = StringHelper.isNullOrEmpty((String)strPSDepSlnHostId) ? null : this.getPSDepSln().getPSDepSlnHost(strPSDepSlnHostId);
    }

    protected void setPSDepSlnHost(IPSDepSlnHost iPSDepSlnHost) {
        this.iPSDepSlnHost = iPSDepSlnHost;
    }

    @Override
    public IPSDepSlnHost getPSDepSlnHost() {
        return this.iPSDepSlnHost;
    }

    @Override
    public boolean isEnableRemoteDeploy() {
        return this.bEnableRemoteDeploy;
    }

    @Override
    public boolean isEnableLocalDeploy() {
        return this.bEnableLocalDeploy;
    }

    protected void setEnableRemoteDeploy(boolean bEnableRemoteDeploy) {
        this.bEnableRemoteDeploy = bEnableRemoteDeploy;
    }

    protected void setEnableLocalDeploy(boolean bEnableLocalDeploy) {
        this.bEnableLocalDeploy = bEnableLocalDeploy;
    }
}

