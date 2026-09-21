/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.control.menu.AppMenuRootItem
 */
package SA.SRFDA.PS.Core.App.AppMenu;

import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItem;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSAppMenu;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.control.menu.AppMenuRootItem;

@PSModelInterfaceMeta(title="\u5e94\u7528\u83dc\u5355\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSAppMenuModelImpl", model="PSAppMenu")
public interface IPSAppMenuModel
extends IPSApplicationObject {
    public void init(ISRFDAGlobalHelper var1, IPSApplication var2, PSAppMenu var3) throws Exception;

    public Iterator<IPSAppMenuItem> getPSAppMenuItems() throws Exception;

    public Iterator<IPSAppFunc> getPSAppFuncs();

    public IPSSysCounter getPSSysCounter();

    @Override
    public String getCodeName();

    public String getLogicName();

    public AppMenuRootItem getRootItem();
}

