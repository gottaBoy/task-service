/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Database.Liquibase;

import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseChangeSet;
import SA.SRFDA.PS.Core.DynaModel.IPSXmlNodes;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSLiquibaseChangeSets
extends IPSXmlNodes<IPSLiquibaseChangeSet> {
    public static final String NODENAME_CHANGESETS = "changeSets";
}

