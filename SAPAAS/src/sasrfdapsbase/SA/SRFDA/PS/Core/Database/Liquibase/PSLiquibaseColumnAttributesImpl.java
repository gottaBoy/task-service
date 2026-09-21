/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database.Liquibase;

import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseColumnAttributes;
import SA.SRFDA.PS.Core.Database.Liquibase.PSLiquibaseObjectImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public abstract class PSLiquibaseColumnAttributesImpl
extends PSLiquibaseObjectImpl
implements IPSLiquibaseColumnAttributes {
    private static final Log log = LogFactory.getLog(PSLiquibaseColumnAttributesImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u540d\u79f0")
    public String getName() {
        String strName = this.getAttrStringValue("name", null);
        if (!StringHelper.isNullOrEmpty((String)strName)) {
            return strName;
        }
        return super.getName();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7c7b\u578b")
    public String getType() {
        return this.getAttrStringValue("type", null);
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c")
    public String getDefaultValue() {
        return this.getAttrStringValue("defaultValue", null);
    }

    @Override
    @PSModelRTMeta(description="\u63cf\u8ff0\u4fe1\u606f")
    public String getRemarks() {
        return this.getAttrStringValue("remarks", null);
    }
}

