/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSLinkDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.DEField.PSLinkDEFieldImpl;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSPickupDEFieldImpl
extends PSLinkDEFieldImpl
implements IPSPickupDEField {
    private IPSLinkDEField pickupTextPSDEField = null;
    private static final Log log = LogFactory.getLog(PSPickupDEFieldImpl.class);
    private IPSDER1N iPSDER1N = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5916\u952e\u6587\u672c\u5c5e\u6027\u5bf9\u8c61")
    public synchronized IPSLinkDEField getPSPickupTextDEField() throws Exception {
        if (this.pickupTextPSDEField != null) {
            return this.pickupTextPSDEField;
        }
        Iterator<IPSDEField> psDEFields = this.getPSDataEntity().getPSDEFields();
        while (psDEFields.hasNext()) {
            IPSDEField iPSDEField = psDEFields.next();
            if (StringHelper.Compare((String)iPSDEField.getDataType(), (String)"PICKUPTEXT", (boolean)true) != 0) continue;
            if (!(iPSDEField instanceof IPSLinkDEField)) {
                throw new Exception(StringHelper.Format((String)"[%1$s]\u4e0d\u662f\u5173\u7cfb\u5c5e\u6027", (Object)iPSDEField.getFullName()));
            }
            IPSLinkDEField iPSLinkDEField = (IPSLinkDEField)iPSDEField;
            if (StringHelper.Compare((String)iPSLinkDEField.getPSDER().getName(), (String)this.getPSDER().getName(), (boolean)false) != 0) continue;
            this.pickupTextPSDEField = iPSLinkDEField;
            break;
        }
        return this.pickupTextPSDEField;
    }

    @Override
    public String getPickupDataRange() {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u7269\u7406\u5c5e\u6027", ignoredumpvalues="true")
    public boolean isPhisicalDEField() {
        if (this.getPSDEFieldData().getDEFTYPE() == 1) {
            return true;
        }
        return super.isPhisicalDEField();
    }

    @Override
    @PSModelRTMeta(description="1:N\u5173\u7cfb\u5bf9\u8c61", fields={"PSDERID"})
    public synchronized IPSDER1N getPSDER1N() throws Exception {
        if (this.iPSDER1N != null) {
            return this.iPSDER1N;
        }
        if (!(this.getPSDER() instanceof IPSDER1N)) {
            throw new Exception(StringHelper.Format((String)"\u5b9e\u4f53\u5173\u7cfb[%1$s]\u4e0d\u662f1:N\u5173\u7cfb", (Object)this.getPSDER().getName()));
        }
        this.iPSDER1N = (IPSDER1N)this.getPSDER();
        return this.iPSDER1N;
    }
}

