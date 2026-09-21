/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.dataentity.field.IPSLinkDEField
 *  net.ibizsys.model.dataentity.field.IPSPickupDEField
 *  net.ibizsys.model.der.IPSDER1N
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.field;

import java.util.Iterator;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.field.IPSLinkDEField;
import net.ibizsys.model.dataentity.field.IPSPickupDEField;
import net.ibizsys.model.dataentity.field.PSLinkDEFieldImpl;
import net.ibizsys.model.der.IPSDER1N;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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

    @PSModelRTMeta(description="\u5916\u952e\u6587\u672c\u6811\u5bf9\u8c61")
    public synchronized IPSLinkDEField getPSPickupTextDEField() throws Exception {
        if (this.pickupTextPSDEField != null) {
            return this.pickupTextPSDEField;
        }
        Iterator psDEFields = this.getPSDataEntity().getPSDEFields();
        while (psDEFields.hasNext()) {
            IPSDEField iPSDEField = (IPSDEField)psDEFields.next();
            if (StringHelper.compare((String)iPSDEField.getDataType(), (String)"PICKUPTEXT", (boolean)true) != 0) continue;
            if (!(iPSDEField instanceof IPSLinkDEField)) {
                throw new Exception(StringHelper.format((String)"[%1$s]\u4e0d\u662f\u5173\u7cfb\u5c5e\u6027", (Object)iPSDEField.getFullName()));
            }
            IPSLinkDEField iPSLinkDEField = (IPSLinkDEField)iPSDEField;
            if (StringHelper.compare((String)iPSLinkDEField.getPSDER().getName(), (String)this.getPSDER().getName(), (boolean)false) != 0) continue;
            this.pickupTextPSDEField = iPSLinkDEField;
            break;
        }
        return this.pickupTextPSDEField;
    }

    public String getPickupDataRange() {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u7269\u7406\u5c5e\u6027")
    public boolean isPhisicalDEField() {
        return true;
    }

    @PSModelRTMeta(description="1:N\u5173\u7cfb\u5bf9\u8c61")
    public synchronized IPSDER1N getPSDER1N() throws Exception {
        if (this.iPSDER1N != null) {
            return this.iPSDER1N;
        }
        if (!(this.getPSDER() instanceof IPSDER1N)) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53\u5173\u7cfb[%1$s]\u4e0d\u662f1:N\u5173\u7cfb", (Object)this.getPSDER().getName()));
        }
        this.iPSDER1N = (IPSDER1N)this.getPSDER();
        return this.iPSDER1N;
    }
}

