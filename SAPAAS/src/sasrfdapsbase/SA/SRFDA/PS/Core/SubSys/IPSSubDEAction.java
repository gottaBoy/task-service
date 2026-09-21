/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.SubSys.IPSSubDE;
import SA.SRFDA.PS.Data.PSSubDEAction;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSSubDEAction
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, IPSSubDE var2, PSSubDEAction var3) throws Exception;
}

