/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlhandler.ICounterHandler
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 *  net.ibizsys.paas.sysmodel.ISystemModel
 *  net.ibizsys.paas.sysmodel.ISystemRuntime
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.JIT.SysModel;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.JIT.App.IPSJITAppModel;
import net.ibizsys.paas.ctrlhandler.ICounterHandler;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.ISystemRuntime;
import org.hibernate.SessionFactory;

public interface IPSJITSystemModel
extends ISystemModel,
ISystemRuntime {
    public void registerCodeListModel(ICodeListModel var1);

    public ICodeListModel getCodeListModel(String var1) throws Exception;

    public IPSJITAppModel getAppModel(IPSApplication var1) throws Exception;

    public IService getService(String var1, SessionFactory var2) throws Exception;

    public void registerCounterHandler(String var1, ICounterHandler var2);

    public ICounterHandler getCounterHandler(Class var1) throws Exception;

    public ICounterHandler getCounterHandler(String var1) throws Exception;

    public String getJITCodeFolder();

    public String getJITWorkshopFolder();

    public boolean isPreviewMode();
}

