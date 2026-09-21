/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Database.Liquibase;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSLiquibaseColumnAttributes {
    public static final String ATTR_NAME = "name";
    public static final String ATTR_TYPE = "type";
    public static final String ATTR_VALUE = "value";
    public static final String ATTR_DEFAULTVALUE = "defaultValue";
    public static final String ATTR_REMARKS = "remarks";

    public String getName();

    public String getType();

    public String getDefaultValue();

    public String getRemarks();
}

