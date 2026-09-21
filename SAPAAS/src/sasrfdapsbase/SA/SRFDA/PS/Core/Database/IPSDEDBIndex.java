/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.Database.IPSDBIndexBase;
import SA.SRFDA.PS.Core.Database.IPSDEDBIndexField;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEDBIndex;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSDEDBIndex
extends IPSDBIndexBase,
IPSDataEntityObject {
    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEDBIndex var3) throws Exception;

    public Iterator<IPSDEDBIndexField> getPSDEDBIndexFields(boolean var1);

    public Iterator<IPSDEDBIndexField> getAllPSDEDBIndexFields();

    public boolean getRemoveFlag();
}

