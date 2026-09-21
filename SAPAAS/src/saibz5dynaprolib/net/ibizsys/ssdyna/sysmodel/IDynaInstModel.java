/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dynasys.IPSDynaInst
 *  net.ibizsys.paas.appmodel.IAppViewModel
 *  net.ibizsys.paas.controller.IDynaViewControllerInst
 *  net.ibizsys.paas.core.IModelBase2
 */
package net.ibizsys.ssdyna.sysmodel;

import net.ibizsys.model.dynasys.IPSDynaInst;
import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.core.IModelBase2;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import net.ibizsys.ssdynawf.core.IDynaWFModel;

public interface IDynaInstModel
extends IModelBase2 {
    public void init(IDynaSysModel var1, IPSDynaInst var2) throws Exception;

    public String getDynaTag();

    public boolean containsDynaDEModel(String var1) throws Exception;

    public IDynaDEModel getDynaDEModel(String var1, boolean var2) throws Exception;

    public void registerDynaDEModel(IDynaDEModel var1) throws Exception;

    public IDynaSysModel getDynaSysModel();

    public void registerDynaAppViewModel(IAppViewModel var1) throws Exception;

    public boolean containsDynaAppViewModel(String var1);

    public IAppViewModel getDynaAppViewModel(String var1, boolean var2) throws Exception;

    public IDynaWFModel getDynaWFModel(String var1) throws Exception;

    public void registerDynaWFModel(IDynaWFModel var1) throws Exception;

    public boolean containsDynaWFModel(String var1) throws Exception;

    public IDynaViewControllerInst getDynaViewControllerInst(String var1, boolean var2) throws Exception;

    public void registerDynaViewControllerInst(IDynaViewControllerInst var1) throws Exception;

    public boolean containsDynaViewControllerInst(String var1) throws Exception;
}

