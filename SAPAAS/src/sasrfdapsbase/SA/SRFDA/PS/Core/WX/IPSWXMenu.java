/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.pswx.core.IWXMenu
 *  net.ibizsys.pswx.core.WXMenuRootItem
 */
package SA.SRFDA.PS.Core.WX;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WX.IPSWXAccount;
import SA.SRFDA.PS.Core.WX.IPSWXAccountObject;
import SA.SRFDA.PS.Core.WX.IPSWXEntApp;
import SA.SRFDA.PS.Core.WX.IPSWXMenuItem;
import SA.SRFDA.PS.Data.PSWXMenu;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.pswx.core.IWXMenu;
import net.ibizsys.pswx.core.WXMenuRootItem;

@PSModelPFIgnoreMeta
public interface IPSWXMenu
extends IPSWXAccountObject,
IPSObject,
IWXMenu {
    public void init(ISRFDAGlobalHelper var1, IPSWXAccount var2, IPSWXEntApp var3, PSWXMenu var4) throws Exception;

    public Iterator<IPSWXMenuItem> getPSWXMenuItems();

    public boolean isDefaultMenu();

    public IPSWXEntApp getPSWXEntApp();

    public WXMenuRootItem getRootItem();
}

