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
import SA.SRFDA.PS.Data.PSSysModelInst;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSSysModelInst
extends IPSObject,
IPSDatabase {
    public void init(ISRFDAGlobalHelper var1, PSSysModelInst var2) throws Exception;

    @Override
    public void close();
}

