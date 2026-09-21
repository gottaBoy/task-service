/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DEMAField;
import SA.SRFDA.Ctrl.IDEMAFieldHelper;
import SA.SRFDA.Ctrl.IDEMainActionHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class DEMAFieldHelper
extends BaseDAObjectHelper
implements IDEMAFieldHelper {
    protected IDEMainActionHelper iDEMainActionHelper = null;
    protected DEMAField deMAField = null;
    protected String strDEFId = "";
    protected IDEFHelper iDEFHelper = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IDEMainActionHelper iDEMainActionHelper, DEMAField deMAField) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iDEMainActionHelper = iDEMainActionHelper;
        this.deMAField = deMAField;
        this.InitModel(this.deMAField);
        this.OnInit();
    }

    private void InitModel(DEMAField item) {
        if (!item.isDEFIDNull()) {
            this.setDEFId(item.getDEFID());
        }
    }

    protected final IDEFHelper getDEFHelper() {
        if (this.iDEFHelper == null) {
            try {
                this.iDEFHelper = this.iDEMainActionHelper.getDEHelper().GetDEFHelper(this.getDEFId());
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.iDEFHelper;
    }

    @Override
    public final String getDEFId() {
        return this.strDEFId;
    }

    protected void setDEFId(String strDEFId) {
        this.strDEFId = strDEFId;
    }

    @Override
    public final String getCodelistId() {
        if (this.deMAField.isCODELISTIDNull()) {
            return this.getDEFHelper().GetCodeList();
        }
        return this.deMAField.getCODELISTID();
    }

    @Override
    public String getFormItemStyle() {
        if (this.deMAField.isFORMITEMSTYLENull()) {
            return this.getDEFHelper().GetFormItemStyle();
        }
        return this.deMAField.getFORMITEMSTYLE();
    }

    @Override
    public boolean isEnableModify() {
        if (this.deMAField.isISENABLEMODIFYNull()) {
            return this.deMAField.isISENABLEMODIFYNull();
        }
        return this.getDEFHelper().isEnableUpdate();
    }

    @Override
    public final String getUpdateMode() {
        return this.deMAField.getUPDATEMODE();
    }

    @Override
    public final String getUpdateValue() {
        return this.deMAField.getUPDATEVALUE();
    }
}

