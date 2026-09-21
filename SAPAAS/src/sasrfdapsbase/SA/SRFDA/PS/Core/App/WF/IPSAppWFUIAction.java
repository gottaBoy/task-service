/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.WF;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppUIAction;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFVer;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIAction;
import SA.SRFDA.PS.Data.PSDEUIAction;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(implement="PSWFUIActionImpl")
public interface IPSAppWFUIAction
extends IPSWFUIAction,
IPSAppUIAction {
    public void init(ISRFDAGlobalHelper var1, IPSAppWF var2, IPSAppWFVer var3, PSDEUIAction var4) throws Exception;

    public IPSAppWF getPSAppWF();

    public IPSAppWFVer getPSAppWFVer();

    public IPSAppDataEntity getPSAppDataEntity();

    public IPSAppDEMethod getPSAppDEMethod();
}

