/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.pswx.core.IWXEntApp
 */
package SA.SRFDA.PS.Core.WX;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.WX.IPSWXAccount;
import SA.SRFDA.PS.Core.WX.IPSWXAccountObject;
import SA.SRFDA.PS.Core.WX.IPSWXLogic;
import SA.SRFDA.PS.Core.WX.IPSWXMenu;
import SA.SRFDA.PS.Core.WX.IPSWXMenuFunc;
import SA.SRFDA.PS.Data.PSWXEntApp;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.pswx.core.IWXEntApp;

@PSModelPFIgnoreMeta
public interface IPSWXEntApp
extends IPSWXAccountObject,
IPSObject,
IWXEntApp {
    public void init(ISRFDAGlobalHelper var1, IPSWXAccount var2, PSWXEntApp var3) throws Exception;

    public String getAppURL();

    public IPSApplication getPSApplication();

    @Override
    public String getCodeName();

    public Iterator<IPSWXLogic> getPSWXLogics();

    public Iterator<IPSWXMenuFunc> getPSWXMenuFuncs();

    public IPSWXMenuFunc getPSWXMenuFunc(String var1) throws Exception;

    public Iterator<IPSWXMenu> getPSWXMenus();

    public IPSWXMenu getDefaultPSWXMenu();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();

    public IPSSysResource getPSSysResource();
}

