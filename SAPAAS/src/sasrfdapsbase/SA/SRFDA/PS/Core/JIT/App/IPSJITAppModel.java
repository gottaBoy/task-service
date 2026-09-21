/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.appmodel.IApplicationModel
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlmodel.IAppMenuModel
 */
package SA.SRFDA.PS.Core.JIT.App;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.JIT.Controller.IPSJITViewController;
import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlmodel.IAppMenuModel;

public interface IPSJITAppModel
extends IApplicationModel {
    public void init(ISRFDAGlobalHelper var1, IPSJITSystemModel var2, IPSApplication var3) throws Exception;

    public IPSJITSystemModel getPSJITSystemModel();

    public IPSApplication getPSApplication();

    public IPSJITViewController getViewController(IPSAppView var1) throws Exception;

    public void registerViewController2(String var1, IViewController var2);

    public IViewController getViewController2(Class var1) throws Exception;

    public IViewController getViewController2(String var1) throws Exception;

    public void registerAppMenuModel2(String var1, IAppMenuModel var2);

    public IAppMenuModel getAppMenuModel2(Class var1) throws Exception;

    public IAppMenuModel getAppMenuModel2(String var1) throws Exception;
}

