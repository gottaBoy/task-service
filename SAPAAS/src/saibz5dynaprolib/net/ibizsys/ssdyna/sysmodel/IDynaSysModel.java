/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSModelStorage
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.paas.sysmodel.ISystemRuntime
 *  net.ibizsys.saas.sysmodel.ISaaSSystemModel
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.ssdyna.sysmodel;

import java.util.Iterator;
import net.ibizsys.model.IPSModelStorage;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.paas.sysmodel.ISystemRuntime;
import net.ibizsys.saas.sysmodel.ISaaSSystemModel;
import net.ibizsys.ssdyna.core.IDynaDETemplModel;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;
import net.ibizsys.ssdyna.service.IDynaService;
import net.ibizsys.ssdyna.sysmodel.IDynaInstModel;
import org.hibernate.SessionFactory;

public interface IDynaSysModel
extends ISaaSSystemModel,
ISystemRuntime {
    public IPSModelStorage getDynaModelStorage();

    public IPSSystem getPSSystem() throws Exception;

    public IDynaService getDynaService(String var1, SessionFactory var2) throws Exception;

    public IDynaDEModel getDynaDEModel(String var1) throws Exception;

    public void registerDynaDETemplModel(IDynaDETemplModel var1) throws Exception;

    public IDynaDETemplModel getDynaDETemplModel(String var1) throws Exception;

    public Iterator<IDynaDETemplModel> getDynaDETemplModels();

    public IDynaInstModel getDynaInstModel(String var1) throws Exception;

    public void resetDynaInstModel(String var1);
}

