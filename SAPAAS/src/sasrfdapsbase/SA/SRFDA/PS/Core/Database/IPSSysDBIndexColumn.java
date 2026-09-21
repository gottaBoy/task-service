/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSDBIndexColumnBase;
import SA.SRFDA.PS.Core.Database.IPSSysDBColumn;
import SA.SRFDA.PS.Core.Database.IPSSysDBIndex;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
public interface IPSSysDBIndexColumn
extends IPSDBIndexColumnBase {
    public void init(ISRFDAGlobalHelper var1, IPSSysDBIndex var2, Object var3) throws Exception;

    public IPSSysDBIndex getPSSysDBIndex();

    public IPSSysDBColumn getPSSysDBColumn();
}

