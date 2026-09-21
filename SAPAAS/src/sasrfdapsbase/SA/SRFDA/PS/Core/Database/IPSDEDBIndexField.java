/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.Database.IPSDBIndexColumnBase;
import SA.SRFDA.PS.Core.Database.IPSDEDBIndex;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEDBIndexField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
public interface IPSDEDBIndexField
extends IPSDBIndexColumnBase {
    public void init(ISRFDAGlobalHelper var1, IPSDEDBIndex var2, PSDEDBIndexField var3) throws Exception;

    public IPSDEDBIndex getPSDEDBIndex();

    public IPSDEField getPSDEField();
}

