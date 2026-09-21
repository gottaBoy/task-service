/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Database.Liquibase;

import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseActionsOwner;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSLiquibaseChangeSet
extends IPSLiquibaseObject,
IPSLiquibaseActionsOwner {
    public static final String NODENAME_CHANGESET = "changeSet";
}

