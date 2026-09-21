/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.SubSys.IPSSubSys;
import SA.SRFDA.PS.Data.PSSubDE;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSSubDE
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, IPSSubSys var2, PSSubDE var3) throws Exception;
}

