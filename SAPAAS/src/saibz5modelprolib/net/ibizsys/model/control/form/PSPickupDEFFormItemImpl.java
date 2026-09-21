/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.field.IPSPickupDEField
 *  net.ibizsys.model.der.IPSDER1N
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.control.form.PSLinkDEFFormItemImpl;
import net.ibizsys.model.dataentity.field.IPSPickupDEField;
import net.ibizsys.model.der.IPSDER1N;
import net.ibizsys.paas.util.StringHelper;

public class PSPickupDEFFormItemImpl
extends PSLinkDEFFormItemImpl {
    protected IPSPickupDEField iPSPickupDEField = null;
    private String strRefPSDEId = "";

    @Override
    protected void onInit() throws Exception {
        this.iPSPickupDEField = (IPSPickupDEField)this.getPSDEField();
        if (this.iPSPickupDEField == null) {
            throw new Exception(StringHelper.format((String)"\u5916\u952e\u5c5e\u6027[%1$s]\u65e0\u6548", (Object)this.getPSDEField().getName()));
        }
        this.strRefPSDEId = ((IPSDER1N)this.iPSPickupDEField.getPSDER()).getMajorDEId();
        super.onInit();
    }

    @Override
    public String getRefPSDEId() {
        if (!StringHelper.isNullOrEmpty((String)super.getRefPSDEId())) {
            return super.getRefPSDEId();
        }
        return this.strRefPSDEId;
    }

    @Override
    public String getRefPSDEACModeId() {
        return super.getRefPSDEACModeId();
    }
}

