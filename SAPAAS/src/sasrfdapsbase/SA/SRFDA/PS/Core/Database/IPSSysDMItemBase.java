/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSSysDMItemBase
extends IPSObject {
    public static final String DBOBJTYPE_TABLE = "TABLE";
    public static final String DBOBJTYPE_COLUMN = "COLUMN";
    public static final String DBOBJTYPE_VIEW = "VIEW";
    public static final String DBOBJTYPE_FKEY = "FKEY";
    public static final String DBOBJTYPE_INDEX = "INDEX";

    public String getDBObjType();

    public boolean isUserCustomMode();

    public String getDropSql();

    public String getBeforeCreateSql();

    public String getCreateSql();

    public String getAfterCreateSql();

    public String getAfterCreateSql2();

    public String getTestSql();

    public String getPSObjId();

    public String getPSObjName();

    public String getDBType();

    public String getPSDEId();

    public String getPSDEName();

    public String getPSSystemDBCfgId();

    public long getCreateTime();

    public long getUpdateTime();
}

