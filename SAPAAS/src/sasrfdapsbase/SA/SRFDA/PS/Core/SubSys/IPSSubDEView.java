/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.SubSys.IPSSubDE;
import SA.SRFDA.PS.Core.SubSys.IPSSubSys;
import SA.SRFDA.PS.Core.SubSys.IPSSubSysObject;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFDA.PS.Data.PSSubDEView;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSSubDEView
extends IPSSubSysObject {
    public void init(ISRFDAGlobalHelper var1, IPSSubSys var2, PSSubDEView var3) throws Exception;

    public IPSSubDE getPSSubDE();

    public IPSViewType getPSViewType();
}

