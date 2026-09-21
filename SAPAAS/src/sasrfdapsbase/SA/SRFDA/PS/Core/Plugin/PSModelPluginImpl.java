/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Plugin;

import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Plugin.IPSModelDiffPlugin;
import SA.SRFDA.PS.Core.Plugin.IPSModelPlugin;
import SA.SRFDA.PS.Data.PSModelPlugin;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class PSModelPluginImpl
extends PSObjectImpl
implements IPSModelPlugin {
    protected PSModelPlugin psModelPlugin = null;
    protected IPSModelDiffPlugin iPSModelDiffPlugin = null;
    protected String strPluginType = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSModelPlugin psModelPlugin) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psModelPlugin = psModelPlugin;
        this.setId(this.psModelPlugin.getPSMODELPLUGINID());
        this.setName(this.psModelPlugin.getPSMODELPLUGINNAME());
        this.psModelPlugin.set("USERPARAMS", this.psModelPlugin.getPLUGINPARAMS());
        this.setPSObjectData(this.psModelPlugin);
        this.strPluginType = this.psModelPlugin.getPLUGINTYPE();
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getPluginType() {
        return this.strPluginType;
    }
}

