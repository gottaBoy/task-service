/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.Database.IPSDBIndexBase;
import SA.SRFDA.PS.Core.Database.IPSDEDBIndex;
import SA.SRFDA.PS.Core.Database.IPSSysDBColumn;
import SA.SRFDA.PS.Core.Database.IPSSysDBIndexColumn;
import SA.SRFDA.PS.Core.Database.IPSSysDBTable;
import SA.SRFDA.PS.Core.Database.IPSSysDBTableObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSSysDBIndex
extends IPSDBIndexBase,
IPSSysDBTableObject {
    public static final String SOURCETYPE_DER = "DER";
    public static final String SOURCETYPE_DEDBINDEX = "DEDBINDEX";
    public static final String SOURCETYPE_DEFIELD = "DEFIELD";
    public static final String SOURCETYPE_DBCOLUMN = "DBCOLUMN";

    public void init(ISRFDAGlobalHelper var1, IPSSysDBTable var2, Object var3, IPSSysDBColumn[] var4) throws Exception;

    public Iterator<IPSSysDBIndexColumn> getPSSysDBIndexColumns(boolean var1);

    public Iterator<IPSSysDBIndexColumn> getAllPSSysDBIndexColumns();

    public boolean getRemoveFlag();

    public String getUniqueId();

    public String getSourceType();

    public IPSDERBase getPSDER();

    public IPSDEDBIndex getPSDEDBIndex();

    public IPSDEField getPSDEField();

    public IPSSysDBColumn getPSSysDBColumn();
}

