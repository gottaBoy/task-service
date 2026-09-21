/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.pswx.core.IWXMenuItem
 */
package SA.SRFDA.PS.Core.WX;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WX.IPSWXMenu;
import SA.SRFDA.PS.Core.WX.IPSWXMenuFunc;
import SA.SRFDA.PS.Data.PSWXMenuItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.pswx.core.IWXMenuItem;

@PSModelPFIgnoreMeta
public interface IPSWXMenuItem
extends IPSModelObject,
IWXMenuItem {
    public void init(ISRFDAGlobalHelper var1, IPSWXMenu var2, IPSWXMenuItem var3, PSWXMenuItem var4) throws Exception;

    public IPSWXMenu getPSWXMenu();

    public IPSWXMenuItem getParentPSWXMenuItem();

    public IPSWXMenuFunc getPSWXMenuFunc();

    public Iterator<IPSWXMenuItem> getPSWXMenuItems();

    public String getWXMenuFuncId();
}

