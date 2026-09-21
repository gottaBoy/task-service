/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database.Liquibase;

import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseObject;
import SA.SRFDA.PS.Core.DynaModel.PSXmlElementImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public abstract class PSLiquibaseObjectImpl
extends PSXmlElementImpl
implements IPSLiquibaseObject {
    private static final Log log = LogFactory.getLog(PSLiquibaseObjectImpl.class);
}

