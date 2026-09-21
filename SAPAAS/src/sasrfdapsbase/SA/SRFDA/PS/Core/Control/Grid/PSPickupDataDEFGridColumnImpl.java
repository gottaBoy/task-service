/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.Control.Grid.PSLinkDEFGridColumnImpl;
import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDataDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFramework.Utility.StringHelper;

public class PSPickupDataDEFGridColumnImpl
extends PSLinkDEFGridColumnImpl {
    protected IPSPickupDataDEField iPSPickupDataDEField = null;
    protected IPSPickupDEField iPSPickupDEField = null;
    private String strRefPSDEDataSetId = "";
    private String strRefPSDEId = "";
    private String strRefPSDEACModeId = "";
    private boolean bRefTempData = false;

    @Override
    protected void onInit() throws Exception {
        this.iPSPickupDataDEField = (IPSPickupDataDEField)this.getPSDEField();
        this.iPSPickupDEField = this.iPSPickupDataDEField.getPSPickupDEField();
        if (this.iPSPickupDEField == null) {
            throw new Exception(StringHelper.Format((String)"\u5916\u952e\u9644\u52a0\u6570\u636e\u5c5e\u6027[%1$s]\u65e0\u6548", (Object)this.getPSDEField().getFullName()));
        }
        this.strRefPSDEDataSetId = ((IPSDER1N)this.iPSPickupDEField.getPSDER()).getRefPSDEDataSetId();
        this.strRefPSDEId = ((IPSDER1N)this.iPSPickupDEField.getPSDER()).getMajorDEId();
        this.strRefPSDEACModeId = ((IPSDER1N)this.iPSPickupDEField.getPSDER()).getRefPSDEACModeId();
        this.bRefTempData = ((IPSDER1N)this.iPSPickupDEField.getPSDER()).getTempDataOrder() >= 0;
        super.onInit();
    }

    @Override
    public String getRefPSDEId() {
        if (!StringHelper.IsNullOrEmpty((String)super.getRefPSDEId())) {
            return super.getRefPSDEId();
        }
        return this.strRefPSDEId;
    }

    @Override
    public String getRefPSDEDataSetId() {
        if (!StringHelper.IsNullOrEmpty((String)super.getRefPSDEDataSetId())) {
            return super.getRefPSDEDataSetId();
        }
        return this.strRefPSDEDataSetId;
    }

    @Override
    public String getRefPSDEACModeId() {
        if (!StringHelper.IsNullOrEmpty((String)super.getRefPSDEACModeId())) {
            return super.getRefPSDEACModeId();
        }
        return this.strRefPSDEACModeId;
    }

    @Override
    public boolean isRefTempData() {
        if (this.isRefTempDataDefined()) {
            return super.isRefTempData();
        }
        return this.bRefTempData;
    }
}

