/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Database.Liquibase;

import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseColumn;
import SA.SRFDA.PS.Core.DynaModel.IPSXmlNodes;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSLiquibaseColumns
extends IPSXmlNodes<IPSLiquibaseColumn> {
    public static final String NODENAME_COLUMNS = "columns";
}

