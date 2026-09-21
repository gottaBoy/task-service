/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database.Liquibase;

import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseConstraints;
import SA.SRFDA.PS.Core.Database.Liquibase.PSLiquibaseConstraintsAttributesImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSLiquibaseConstraintsImpl
extends PSLiquibaseConstraintsAttributesImpl
implements IPSLiquibaseConstraints {
    private static final Log log = LogFactory.getLog(PSLiquibaseConstraintsImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSLIQUIBASECONSTRAINTS$" + this.getPSXmlNodeOwner().getModelType();
    }
}

