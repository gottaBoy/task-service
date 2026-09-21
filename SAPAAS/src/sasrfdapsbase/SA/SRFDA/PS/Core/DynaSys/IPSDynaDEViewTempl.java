/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DynaSys;

import SA.SRFDA.PS.Core.App.View.IPSAppDynaDEView;
import SA.SRFDA.PS.Core.DynaSys.IPSDynaDETempl;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDynaDEViewTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSDynaDEViewTempl
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, IPSDynaDETempl var2, PSDynaDEViewTempl var3) throws Exception;

    public IPSDynaDETempl getPSDynaDETempl();

    public Iterator<IPSAppDynaDEView> getPSAppDynaDEViews() throws Exception;
}

