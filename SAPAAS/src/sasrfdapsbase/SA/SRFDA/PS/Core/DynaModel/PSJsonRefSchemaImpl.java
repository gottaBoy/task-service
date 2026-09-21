/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.PSJsonNodeSchemaImplBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJsonRefSchemaImpl
extends PSJsonNodeSchemaImplBase {
    private static final Log log = LogFactory.getLog(PSJsonRefSchemaImpl.class);

    @Override
    protected String onGetType() {
        try {
            if (this.getRefPSJsonNodeSchema() != null) {
                return this.getRefPSJsonNodeSchema().getType();
            }
        }
        catch (Exception e) {
            log.error((Object)e);
        }
        return "unknown";
    }
}

