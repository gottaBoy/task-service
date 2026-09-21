/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Database.Liquibase;

import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseConstraints;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSLiquibaseConstraintsOwner {
    public IPSLiquibaseConstraints getPSLiquibaseConstraints();
}

