/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Database.Liquibase;

import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseConstraintsAttributes;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSLiquibaseConstraints
extends IPSLiquibaseConstraintsAttributes,
IPSLiquibaseObject {
    public static final String NODENAME_CONSTRAINTS = "constraints";
}

