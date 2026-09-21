/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Database.Liquibase;

import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseAction;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseColumnsOwner;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSLiquibaseCreateTable
extends IPSLiquibaseAction,
IPSLiquibaseColumnsOwner {
    public static final String NODENAME_CREATETABLE = "createTable";
    public static final String ATTR_TABLENAME = "tableName";
    public static final String ATTR_REMARKS = "remarks";

    public String getTableName();

    public String getRemarks();
}

