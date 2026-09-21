/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.PSLinkDEFSFItemImpl;
import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFramework.Utility.StringHelper;

public class PSPickupDEFSFItemImpl
extends PSLinkDEFSFItemImpl {
    protected IPSPickupDEField iPSPickupDEField = null;
    private String strRefPSDEId = "";

    @Override
    protected void onInit() throws Exception {
        this.iPSPickupDEField = (IPSPickupDEField)this.getPSDEField();
        if (this.iPSPickupDEField == null) {
            throw new Exception(StringHelper.Format((String)"\u5916\u952e\u5c5e\u6027[%1$s]\u65e0\u6548", (Object)this.getPSDEField().getFullName()));
        }
        this.strRefPSDEId = ((IPSDER1N)this.iPSPickupDEField.getPSDER()).getMajorDEId();
        super.onInit();
    }

    @Override
    public String getRefPSDEId() {
        if (!StringHelper.IsNullOrEmpty((String)super.getRefPSDEId())) {
            return super.getRefPSDEId();
        }
        return this.strRefPSDEId;
    }
}

