/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUIPFPluginLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEUILogicNodeImpl;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSDEUIPFPluginLogicImpl
extends PSDEUILogicNodeImpl
implements IPSDEUIPFPluginLogic {
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSPFXCodeObject iPSPFXCodeObject = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPSSYSPFPLUGINID())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u524d\u7aef\u6269\u5c55\u63d2\u4ef6");
        }
        this.iPSSysPFPlugin = this.getPSAppDEUILogic() != null ? this.getPSAppDEUILogic().getPSApplication().getPSSysPFPlugin(this.psDELogicNode.getPSSYSPFPLUGINID(), "DEUIPFPLUGIN", null, null) : this.getPSDEUILogic().getPSDataEntity().getPSSystem().getPSSysPFPlugin(this.psDELogicNode.getPSSYSPFPLUGINID());
        if (this.getPSAppDEUILogic() != null && this.getPSAppDEUILogic().getPSDataEntity() != null) {
            String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPlugin().getId(), (String)this.getPSAppDEUILogic().getPSAppDataEntity().getPSApplication().getPSPF().getId());
            IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSAppDEUILogic().getPSAppDataEntity().getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
            if (iPSSysPFPluginTempl != null) {
                this.iPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, null, null, (Object)this);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u5668\u5bf9\u8c61")
    public IPSPFXCodeObject getRender() {
        return this.iPSPFXCodeObject;
    }
}

