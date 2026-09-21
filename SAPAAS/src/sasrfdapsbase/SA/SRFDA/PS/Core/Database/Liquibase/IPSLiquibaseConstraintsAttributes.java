/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Database.Liquibase;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSLiquibaseConstraintsAttributes {
    public static final String ATTR_NULLABLE = "nullable";
    public static final String ATTR_PRIMARYKEY = "primaryKey";
    public static final String ATTR_PRIMARYKEYNAME = "primaryKeyName";
    public static final String ATTR_UNIQUE = "unique";
    public static final String ATTR_UNIQUECONSTRAINTNAME = "uniqueConstraintName";

    public Boolean isNullable();

    public Boolean isPrimaryKey();

    public String getPrimaryKeyName();
}

