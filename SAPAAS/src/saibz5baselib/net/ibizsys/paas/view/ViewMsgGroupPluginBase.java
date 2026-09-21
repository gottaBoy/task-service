/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.view;

import java.util.ArrayList;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.core.PluginBase;
import net.ibizsys.paas.sysmodel.ISystemPlugin;
import net.ibizsys.paas.view.IViewMessage;
import net.ibizsys.paas.view.IViewMsgGroupModel;
import net.ibizsys.paas.view.IViewMsgGroupPlugin;

public abstract class ViewMsgGroupPluginBase
extends PluginBase
implements IViewMsgGroupPlugin {
    private IViewMsgGroupPlugin prevViewMsgGroupPlugin = null;

    @Override
    public PluginActionResult doGetViewMessages(IViewController iViewController, IViewMsgGroupModel iViewMsgGroupModel, ArrayList<IViewMessage> viewMessageList, Object objParam) throws Exception {
        if (this.prevViewMsgGroupPlugin != null) {
            return this.prevViewMsgGroupPlugin.doGetViewMessages(iViewController, iViewMsgGroupModel, viewMessageList, objParam);
        }
        return PluginActionResult.Continue;
    }

    @Override
    public void setPrevPlugin(IPlugin iPlugin) {
        super.setPrevPlugin(iPlugin);
        if (iPlugin instanceof IViewMsgGroupPlugin) {
            this.prevViewMsgGroupPlugin = (IViewMsgGroupPlugin)iPlugin;
        }
        if (iPlugin instanceof ISystemPlugin) {
            this.prevViewMsgGroupPlugin = ((ISystemPlugin)iPlugin).getViewMsgGroupPlugin();
        }
    }
}

