/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupTextDEField;
import SA.SRFDA.PS.Core.DEField.PSPickupDataDEFieldImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSPickupTextDEFieldImpl
extends PSPickupDataDEFieldImpl
implements IPSPickupTextDEField {
    private static final Log log = LogFactory.getLog(PSPickupTextDEFieldImpl.class);

    @Override
    @PSModelRTMeta(description="\u7269\u7406\u5c5e\u6027", ignoredumpvalues="true")
    public boolean isPhisicalDEField() {
        if (this.getPSDEFieldData().getDEFTYPE() == 1) {
            return true;
        }
        return super.isPhisicalDEField();
    }

    @Override
    protected IPSDEField onGetValuePSDEField() throws Exception {
        IPSDEField iPSDEField = super.onGetValuePSDEField();
        if (iPSDEField != null) {
            return iPSDEField;
        }
        return this.getPSPickupDEField();
    }
}

