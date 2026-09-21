/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.sysmodel.ISystemViewMsgGroupPlugin;
import net.ibizsys.paas.view.IViewMessage;
import net.ibizsys.paas.view.IViewMsgGroupModel;
import net.ibizsys.paas.view.IViewMsgGroupPlugin;
import net.ibizsys.paas.view.ViewMsgGroupPluginBase;

public class SystemViewMsgGroupPlugin
extends ViewMsgGroupPluginBase
implements ISystemViewMsgGroupPlugin {
    protected HashMap<String, IViewMsgGroupPlugin> iViewMsgGroupPluginMap = new HashMap();

    @Override
    public void registerViewMsgGroupPlugin(String strUniqueTag, IViewMsgGroupPlugin iViewMsgGroupPlugin) throws Exception {
        this.iViewMsgGroupPluginMap.put(strUniqueTag, iViewMsgGroupPlugin);
    }

    @Override
    public PluginActionResult doGetViewMessages(IViewController iViewController, IViewMsgGroupModel iViewMsgGroupModel, ArrayList<IViewMessage> viewMessageList, Object objParam) throws Exception {
        PluginActionResult pluginActionResult;
        IViewMsgGroupPlugin iViewMsgGroupPlugin = this.iViewMsgGroupPluginMap.get(iViewMsgGroupModel.getUniqueTag());
        if (iViewMsgGroupPlugin == null) {
            iViewMsgGroupPlugin = this.iViewMsgGroupPluginMap.get("");
        }
        if (iViewMsgGroupPlugin != null && (pluginActionResult = iViewMsgGroupPlugin.doGetViewMessages(iViewController, iViewMsgGroupModel, viewMessageList, objParam)) == PluginActionResult.Replace) {
            return pluginActionResult;
        }
        return super.doGetViewMessages(iViewController, iViewMsgGroupModel, viewMessageList, objParam);
    }
}

