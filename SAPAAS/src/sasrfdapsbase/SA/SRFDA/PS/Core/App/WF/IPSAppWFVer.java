/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.WF;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFUIAction;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFUIActionGroup;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Data.PSAppWFVer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

public interface IPSAppWFVer
extends IPSApplicationObject {
    public void init(ISRFDAGlobalHelper var1, IPSApplication var2, PSAppWFVer var3) throws Exception;

    public IPSAppWF getPSAppWF();

    public IPSWFVersion getPSWFVersion();

    public Iterator<IPSAppWFUIAction> getAllPSAppWFUIActions() throws Exception;

    public IPSAppWFUIAction getPSAppWFUIAction(String var1) throws Exception;

    public IPSAppWFUIAction getPSAppWFUIAction(String var1, boolean var2) throws Exception;

    public void resetPSAppWFUIAction(String var1) throws Exception;

    public IPSAppWFUIActionGroup getPSAppWFUIActionGroup(String var1) throws Exception;

    public IPSAppWFUIActionGroup getPSAppWFUIActionGroup(String var1, boolean var2) throws Exception;

    public void resetPSAppWFUIActionGroup(String var1) throws Exception;

    public Iterator<IPSAppWFUIAction> getPSAppWFUIActions() throws Exception;

    public Iterator<IPSAppWFUIActionGroup> getPSAppWFUIActionGroups() throws Exception;

    @Override
    public String getCodeName();

    public Iterator<IPSAppView> getAllPSAppViews() throws Exception;
}

