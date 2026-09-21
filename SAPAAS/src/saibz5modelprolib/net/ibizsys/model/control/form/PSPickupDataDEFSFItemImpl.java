/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.field.IPSPickupDEField
 *  net.ibizsys.model.dataentity.field.IPSPickupDataDEField
 *  net.ibizsys.model.der.IPSDER1N
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.control.form.PSLinkDEFSFItemImpl;
import net.ibizsys.model.dataentity.field.IPSPickupDEField;
import net.ibizsys.model.dataentity.field.IPSPickupDataDEField;
import net.ibizsys.model.der.IPSDER1N;
import net.ibizsys.model.der.IPSDER1NRuntime;
import net.ibizsys.paas.util.StringHelper;

public class PSPickupDataDEFSFItemImpl
extends PSLinkDEFSFItemImpl {
    protected IPSPickupDataDEField iPSPickupDataDEField = null;
    protected IPSPickupDEField iPSPickupDEField = null;
    private String strRefPSDEDataSetId = "";
    private String strRefPSDEId = "";
    private boolean bRefTempData = false;

    @Override
    protected void onInit() throws Exception {
        this.iPSPickupDataDEField = (IPSPickupDataDEField)this.getPSDEField();
        this.iPSPickupDEField = this.iPSPickupDataDEField.getPSPickupDEField();
        if (this.iPSPickupDEField == null) {
            throw new Exception(StringHelper.format((String)"\u5916\u952e\u9644\u52a0\u6570\u636e\u5c5e\u6027[%1$s]\u65e0\u6548", (Object)this.getPSDEField().getName()));
        }
        this.strRefPSDEDataSetId = ((IPSDER1NRuntime)this.iPSPickupDEField.getPSDER()).getRefPSDEDataSetId();
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
    public String getRefPSDEDataSetId() {
        if (!StringHelper.isNullOrEmpty((String)super.getRefPSDEDataSetId())) {
            return super.getRefPSDEDataSetId();
        }
        return this.strRefPSDEDataSetId;
    }

    @Override
    public boolean isRefTempData() {
        return this.bRefTempData;
    }
}

