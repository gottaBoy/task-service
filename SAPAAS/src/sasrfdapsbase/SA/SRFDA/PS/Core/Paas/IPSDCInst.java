/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Paas;

import SA.SRFDA.PS.Core.Database.IPSDatabase;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDCInst;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDCInst
extends IPSObject,
IPSDatabase {
    public void init(ISRFDAGlobalHelper var1, PSDCInst var2) throws Exception;

    @Override
    public void close();
}

