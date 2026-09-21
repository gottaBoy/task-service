/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.pswx.core.IWXAccount
 */
package SA.SRFDA.PS.Core.WX;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.WX.IPSWXEntApp;
import SA.SRFDA.PS.Core.WX.IPSWXLogic;
import SA.SRFDA.PS.Core.WX.IPSWXMenu;
import SA.SRFDA.PS.Core.WX.IPSWXMenuFunc;
import SA.SRFDA.PS.Data.PSWXAccount;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.pswx.core.IWXAccount;

@PSModelPFIgnoreMeta
public interface IPSWXAccount
extends IPSSystemObject,
IWXAccount,
IPSSysSFPubObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSWXAccount var3) throws Exception;

    public Iterator<IPSWXEntApp> getPSWXEntApps();

    public IPSWXEntApp getPSWXEntApp(String var1) throws Exception;

    public Iterator<IPSWXLogic> getPSWXLogics();

    public Iterator<IPSWXMenuFunc> getPSWXMenuFuncs();

    public IPSWXMenuFunc getPSWXMenuFunc(String var1) throws Exception;

    public Iterator<IPSWXMenu> getPSWXMenus();

    public IPSWXMenu getDefaultPSWXMenu();

    @Override
    public String getCodeName();

    public IPSSystemModule getPSSystemModule();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();

    public IPSSysResource getPSSysResource();
}

