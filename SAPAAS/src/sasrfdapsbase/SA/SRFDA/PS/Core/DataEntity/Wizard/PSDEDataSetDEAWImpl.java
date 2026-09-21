/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Wizard;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEDataSetDEAW;
import SA.SRFDA.PS.Core.DataEntity.Wizard.PSDEActionWizardImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelIgnoreMeta
public class PSDEDataSetDEAWImpl
extends PSDEActionWizardImpl
implements IPSDEDataSetDEAW {
    private IPSDataEntity awPSDataEntity = null;
    private IPSDataEntity awiPSDataEntity = null;
    private IPSDEDataSet awPSDEDataSet = null;
    private IPSDEDataSet awiPSDEDataSet = null;
    IPSDEField awNamePSDEField;
    IPSDEField awKeywordPSDEField;
    IPSDEField awSortPSDEField;
    IPSDEField awiNamePSDEField;
    IPSDEField awiValuePSDEField;
    IPSDEField awiFKeyPSDEField;
    IPSDEField awiContentPSDEField;
    IPSDEField awiUrlPSDEField;
    IPSDEField awiSortPSDEField;

    @Override
    protected void onInit() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psDEActionWizard.getAWPSDEID())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u64cd\u4f5c\u5411\u5bfc\u6570\u636e\u96c6\u5b9e\u4f53\u5bf9\u8c61");
        }
        if (StringHelper.isNullOrEmpty((String)this.psDEActionWizard.getAWPSDEDSID())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u64cd\u4f5c\u5411\u5bfc\u6570\u636e\u96c6\u5bf9\u8c61");
        }
        if (StringHelper.isNullOrEmpty((String)this.psDEActionWizard.getAWIPSDEID())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u64cd\u4f5c\u5411\u5bfc\u9879\u6570\u636e\u96c6\u5b9e\u4f53\u5bf9\u8c61");
        }
        if (StringHelper.isNullOrEmpty((String)this.psDEActionWizard.getAWIPSDEDSID())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u64cd\u4f5c\u5411\u5bfc\u9879\u6570\u636e\u96c6\u5bf9\u8c61");
        }
        this.awPSDataEntity = this.getPSDataEntity().getPSSystem().getPSDataEntity2(this.psDEActionWizard.getAWPSDEID());
        this.awPSDEDataSet = this.awPSDataEntity.getPSDEDataSet(this.psDEActionWizard.getAWPSDEDSID());
        this.awiPSDataEntity = this.getPSDataEntity().getPSSystem().getPSDataEntity2(this.psDEActionWizard.getAWIPSDEID());
        this.awiPSDEDataSet = this.awiPSDataEntity.getPSDEDataSet(this.psDEActionWizard.getAWIPSDEDSID());
        if (!StringHelper.isNullOrEmpty((String)this.psDEActionWizard.getAWNAMEPSDEFID())) {
            this.awNamePSDEField = this.getAWPSDE().getPSDEField(this.psDEActionWizard.getAWNAMEPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEActionWizard.getAWKWPSDEFID())) {
            this.awKeywordPSDEField = this.getAWPSDE().getPSDEField(this.psDEActionWizard.getAWKWPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEActionWizard.getAWSORTPSDEFID())) {
            this.awSortPSDEField = this.getAWPSDE().getPSDEField(this.psDEActionWizard.getAWSORTPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEActionWizard.getAWINAMEPSDEFID())) {
            this.awiNamePSDEField = this.getAWIPSDE().getPSDEField(this.psDEActionWizard.getAWINAMEPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEActionWizard.getAWIVALUEPSDEFID())) {
            this.awiValuePSDEField = this.getAWIPSDE().getPSDEField(this.psDEActionWizard.getAWIVALUEPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEActionWizard.getAWIFKEYPSDEFID())) {
            this.awiFKeyPSDEField = this.getAWIPSDE().getPSDEField(this.psDEActionWizard.getAWIFKEYPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEActionWizard.getAWICONTENTPSDEFID())) {
            this.awiContentPSDEField = this.getAWIPSDE().getPSDEField(this.psDEActionWizard.getAWICONTENTPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEActionWizard.getAWIURLPSDEFID())) {
            this.awiUrlPSDEField = this.getAWIPSDE().getPSDEField(this.psDEActionWizard.getAWIURLPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEActionWizard.getAWISORTPSDEFID())) {
            this.awiSortPSDEField = this.getAWIPSDE().getPSDEField(this.psDEActionWizard.getAWISORTPSDEFID());
        }
        super.onInit();
    }

    public String getAWDEName() {
        if (this.getAWPSDE() != null) {
            return this.getAWPSDE().getName();
        }
        return null;
    }

    public String getAWDEDataSetName() {
        if (this.getAWPSDEDataSet() != null) {
            return this.getAWPSDEDataSet().getName();
        }
        return null;
    }

    public String getAWNameField() {
        if (this.getAWNamePSDEField() != null) {
            return this.getAWNamePSDEField().getName();
        }
        return null;
    }

    public String getAWKeywordField() {
        if (this.getAWKeywordPSDEField() != null) {
            return this.getAWKeywordPSDEField().getName();
        }
        return null;
    }

    public String getAWSortField() {
        if (this.getAWSortPSDEField() != null) {
            return this.getAWSortPSDEField().getName();
        }
        return null;
    }

    public String getAWIDEName() {
        if (this.getAWIPSDE() != null) {
            return this.getAWIPSDE().getName();
        }
        return null;
    }

    public String getAWIDEDataSetName() {
        if (this.getAWIPSDEDataSet() != null) {
            return this.getAWIPSDEDataSet().getName();
        }
        return null;
    }

    public String getAWINameField() {
        if (this.getAWINamePSDEField() != null) {
            return this.getAWINamePSDEField().getName();
        }
        return null;
    }

    public String getAWIValueField() {
        if (this.getAWIValuePSDEField() != null) {
            return this.getAWIValuePSDEField().getName();
        }
        return null;
    }

    public String getAWIFKeyField() {
        if (this.getAWIFKeyPSDEField() != null) {
            return this.getAWIFKeyPSDEField().getName();
        }
        return null;
    }

    public String getAWIContentField() {
        if (this.getAWIContentPSDEField() != null) {
            return this.getAWIContentPSDEField().getName();
        }
        return null;
    }

    public String getAWIUrlField() {
        if (this.getAWIUrlPSDEField() != null) {
            return this.getAWIUrlPSDEField().getName();
        }
        return null;
    }

    public String getAWISortField() {
        if (this.getAWISortPSDEField() != null) {
            return this.getAWISortPSDEField().getName();
        }
        return null;
    }

    @Override
    public IPSDataEntity getAWPSDE() {
        return this.awPSDataEntity;
    }

    @Override
    public IPSDEDataSet getAWPSDEDataSet() {
        return this.awPSDEDataSet;
    }

    @Override
    public IPSDEField getAWNamePSDEField() {
        return this.awNamePSDEField;
    }

    @Override
    public IPSDEField getAWKeywordPSDEField() {
        return this.awKeywordPSDEField;
    }

    @Override
    public IPSDEField getAWSortPSDEField() {
        return this.awSortPSDEField;
    }

    @Override
    public IPSDataEntity getAWIPSDE() {
        return this.awiPSDataEntity;
    }

    @Override
    public IPSDEDataSet getAWIPSDEDataSet() {
        return this.awiPSDEDataSet;
    }

    @Override
    public IPSDEField getAWINamePSDEField() {
        return this.awiNamePSDEField;
    }

    @Override
    public IPSDEField getAWIValuePSDEField() {
        return this.awiValuePSDEField;
    }

    @Override
    public IPSDEField getAWIFKeyPSDEField() {
        return this.awiFKeyPSDEField;
    }

    @Override
    public IPSDEField getAWIContentPSDEField() {
        return this.awiContentPSDEField;
    }

    @Override
    public IPSDEField getAWIUrlPSDEField() {
        return this.awiUrlPSDEField;
    }

    @Override
    public IPSDEField getAWISortPSDEField() {
        return this.awiSortPSDEField;
    }
}

