/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.view;

import java.util.ArrayList;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.view.IViewMessage;
import net.ibizsys.paas.view.IViewMsgGroupModel;

public interface IViewMsgGroupPlugin
extends IPlugin {
    public PluginActionResult doGetViewMessages(IViewController var1, IViewMsgGroupModel var2, ArrayList<IViewMessage> var3, Object var4) throws Exception;
}

