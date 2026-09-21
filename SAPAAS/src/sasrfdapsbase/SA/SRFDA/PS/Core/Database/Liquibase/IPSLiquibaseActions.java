/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Database.Liquibase;

import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseAction;
import SA.SRFDA.PS.Core.DynaModel.IPSXmlNodes;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSLiquibaseActions
extends IPSXmlNodes<IPSLiquibaseAction> {
    public static final String NODENAME_ACTIONS = "actions";
}

