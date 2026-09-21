/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IDynaViewController
 *  net.ibizsys.paas.controller.IDynaViewControllerInst
 *  net.ibizsys.paas.ctrlhandler.IDynaCtrlHandler
 *  net.ibizsys.paas.ctrlmodel.IDynaCtrlModel
 *  net.ibizsys.paas.view.IDynaViewSetting
 */
package net.ibizsys.paas.view;

import net.ibizsys.paas.controller.IDynaViewController;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.paas.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.paas.ctrlmodel.IDynaEditFormModel;
import net.ibizsys.paas.ctrlmodel.IDynaSearchFormModel;
import net.ibizsys.paas.ctrlmodel.IDynaToolbarModel;
import net.ibizsys.paas.sysmodel.IDynaSystemSettingModel;
import net.ibizsys.paas.view.IDynaViewSetting;

public interface IDynaViewSettingModel
extends IDynaViewSetting {
    public void init(IDynaSystemSettingModel var1) throws Exception;

    public IDynaSystemSettingModel getDynaSystemSettingModel();

    public IDynaViewControllerInst createDynaViewControllerInst(IDynaViewController var1, String var2) throws Exception;

    public IDynaCtrlModel createDynaCtrlModel(String var1, Object var2) throws Exception;

    public IDynaCtrlHandler createDynaCtrlHandler(IDynaCtrlModel var1) throws Exception;

    public IDynaToolbarModel createDynaToolbarModel();

    public IDynaEditFormModel createDynaEditFormModel();

    public IDynaSearchFormModel createDynaSearchFormModel();
}

