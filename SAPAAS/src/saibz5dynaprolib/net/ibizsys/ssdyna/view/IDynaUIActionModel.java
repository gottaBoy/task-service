/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSModelJsonExporter
 *  net.ibizsys.model.view.IPSUIAction
 *  net.ibizsys.paas.view.IUIAction
 */
package net.ibizsys.ssdyna.view;

import net.ibizsys.model.IPSModelJsonExporter;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.paas.view.IUIAction;
import net.ibizsys.ssdyna.view.IDynaViewModel;

public interface IDynaUIActionModel
extends IUIAction,
IPSModelJsonExporter {
    public void init(IDynaViewModel var1, IPSUIAction var2) throws Exception;

    public IDynaViewModel getDynaViewModel();

    public IPSUIAction getPSUIAction();
}

