/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database.Liquibase;

import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseConstraintsAttributes;
import SA.SRFDA.PS.Core.Database.Liquibase.PSLiquibaseObjectImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public abstract class PSLiquibaseConstraintsAttributesImpl
extends PSLiquibaseObjectImpl
implements IPSLiquibaseConstraintsAttributes {
    private static final Log log = LogFactory.getLog(PSLiquibaseConstraintsAttributesImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u503c")
    public Boolean isNullable() {
        return this.getAttrBooleanValue("nullable", null);
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u952e")
    public Boolean isPrimaryKey() {
        return this.getAttrBooleanValue("primaryKey", null);
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u952e\u540d\u79f0")
    public String getPrimaryKeyName() {
        return this.getAttrStringValue("primaryKeyName", null);
    }
}

