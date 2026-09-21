/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.WF;

import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFVer;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIActionGroup;
import SA.SRFDA.PS.Data.PSDEUIActionGroup;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
public interface IPSAppWFUIActionGroup
extends IPSWFUIActionGroup {
    public void init(ISRFDAGlobalHelper var1, IPSAppWF var2, IPSAppWFVer var3, PSDEUIActionGroup var4) throws Exception;

    public IPSAppWF getPSAppWF();

    public IPSAppWFVer getPSAppWFVer();
}

