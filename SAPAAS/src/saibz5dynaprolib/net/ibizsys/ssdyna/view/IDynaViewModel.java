/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.paas.controller.IDynaViewController
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.view.IDynaView
 */
package net.ibizsys.ssdyna.view;

import java.util.Iterator;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.paas.controller.IDynaViewController;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.view.IDynaView;
import net.ibizsys.ssdyna.appmodel.IDynaAppModel;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import net.ibizsys.ssdyna.view.IDynaUIActionModel;

public interface IDynaViewModel
extends IDynaView,
IViewController,
IDynaViewController {
    public IPSAppView getPSAppView();

    public IDynaAppModel getDynaAppModel();

    public IDynaSysModel getDynaSysModel();

    public boolean isDynaViewInstMode();

    public IDynaCtrlHandler createDynaCtrlHandler(IPSControl var1) throws Exception;

    public IDynaCtrlModel createDynaCtrlModel(IPSControl var1) throws Exception;

    public void registerDynaUIActionModel(String var1, IDynaUIActionModel var2) throws Exception;

    public Iterator<IDynaUIActionModel> getDynaUIActionModels();
}

