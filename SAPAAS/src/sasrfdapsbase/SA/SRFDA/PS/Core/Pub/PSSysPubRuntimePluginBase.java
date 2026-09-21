/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Deploy.IPSSysRunSession;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysPubRuntime;
import SA.SRFDA.PS.Core.Pub.IPSSysPubRuntimePlugin;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public abstract class PSSysPubRuntimePluginBase
extends PSObjectImpl
implements IPSSysPubRuntimePlugin {
    private IPSSysPubRuntime iPSSysPubRuntime = null;
    private IPSSysRunSession iPSSysRunSession = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysPubRuntime iPSSysPubRuntime) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSSysPubRuntime = iPSSysPubRuntime;
        if (this.iPSSysPubRuntime instanceof IPSSysRunSession) {
            this.iPSSysRunSession = (IPSSysRunSession)((Object)this.iPSSysPubRuntime);
        }
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    protected IPSSysPubRuntime getPSSysPubRuntime() {
        return this.iPSSysPubRuntime;
    }

    protected void setPSSysPubRuntime(IPSSysPubRuntime iPSSysPubRuntime) {
        this.iPSSysPubRuntime = iPSSysPubRuntime;
    }

    protected IPSSysRunSession getPSSysRunSession() {
        return this.iPSSysRunSession;
    }

    protected void setPSSysRunSession(IPSSysRunSession iPSSysRunSession) {
        this.iPSSysRunSession = iPSSysRunSession;
    }
}

