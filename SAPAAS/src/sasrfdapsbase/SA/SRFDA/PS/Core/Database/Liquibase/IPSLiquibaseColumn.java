/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Database.Liquibase;

import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseColumnAttributes;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseConstraintsOwner;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSLiquibaseColumn
extends IPSLiquibaseColumnAttributes,
IPSLiquibaseObject,
IPSLiquibaseConstraintsOwner {
    public static final String NODENAME_COLUMN = "column";
}

