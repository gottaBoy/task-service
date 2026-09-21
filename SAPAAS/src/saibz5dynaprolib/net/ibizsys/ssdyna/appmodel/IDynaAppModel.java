/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.IPSApplication
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.saas.appmodel.ISaaSAppModel
 */
package net.ibizsys.ssdyna.appmodel;

import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.saas.appmodel.ISaaSAppModel;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;

public interface IDynaAppModel
extends ISaaSAppModel {
    public IDynaViewModel getDynaViewModel(String var1, boolean var2) throws Exception;

    public IPSApplication getPSApplication() throws Exception;

    public IDynaSysModel getDynaSysModel();

    public IDynaCtrlModel createDynaCtrlModel(IDynaViewModel var1, IPSControl var2) throws Exception;

    public IDynaCtrlHandler createDynaCtrlHandler(IDynaViewModel var1, IPSControl var2) throws Exception;
}

