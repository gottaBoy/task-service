/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Database.Liquibase;

import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseChangeLog;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSLiquibaseChangeLogOwner {
    public IPSLiquibaseChangeLog getPSLiquibaseChangeLog();
}

