/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSDatabase;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

@PSModelIgnoreMeta
public interface IPSDBType3 {
    public static final String DBOBJ_TABLE = "TABLE";
    public static final String DBOBJ_VIEW = "VIEW";
    public static final String DBOBJ_INDEX = "INDEX";
    public static final String DBOBJ_FUNCTION = "FUNCTION";
    public static final String DBOBJ_PROCEDUCE = "PROCEDUCE";
    public static final String DBOBJ_SEQUENSE = "SEQUENSE";
    public static final String CODETYPE_CREATEMODEL = "CREATEMODEL";
    public static final String CODETYPE_UPDATEMODEL = "UPDATEMODEL";
    public static final String CODETYPE_DROPMODEL = "DROPMODEL";
    public static final String CODETYPE_INSERTDATA = "INSERTDATA";
    public static final String CODETYPE_UPDATEDATA = "UPDATEDATA";
    public static final String CODETYPE_DELETEDATA = "DELETEDATA";
    public static final String CODETYPE_SELECTDATA = "SELECTDATA";
    public static final String CODETYPE_SELECTCOUNT = "SELECTCOUNT";

    public CallResult getTables(IPSDatabase var1, String var2, Vector<BaseDataEntity> var3) throws Exception;

    public CallResult getViews(IPSDatabase var1, String var2, Vector<BaseDataEntity> var3) throws Exception;

    public CallResult getFunctions(IPSDatabase var1, String var2, Vector<BaseDataEntity> var3) throws Exception;

    public CallResult getIndices(IPSDatabase var1, String var2, Vector<BaseDataEntity> var3) throws Exception;

    public CallResult getProceduces(IPSDatabase var1, String var2, Vector<BaseDataEntity> var3) throws Exception;

    public CallResult getSequenses(IPSDatabase var1, String var2, Vector<BaseDataEntity> var3) throws Exception;

    public CallResult getTableColumns(IPSDatabase var1, String var2, Vector<BaseDataEntity> var3) throws Exception;

    public CallResult getViewColumns(IPSDatabase var1, String var2, Vector<BaseDataEntity> var3) throws Exception;

    public CallResult executeSQL(IPSDatabase var1, String var2, Vector<BaseDataEntity> var3) throws Exception;

    public CallResult generateSQL(IPSDatabase var1, String var2, String var3, String var4, Vector<BaseDataEntity> var5) throws Exception;
}

