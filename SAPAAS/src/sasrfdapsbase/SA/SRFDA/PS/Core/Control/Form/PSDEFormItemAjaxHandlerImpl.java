/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Ajax.PSAjaxHandlerImpl;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;

public class PSDEFormItemAjaxHandlerImpl
extends PSAjaxHandlerImpl {
    public IPSDEFormItem getPSDEFormItem() {
        return (IPSDEFormItem)this.getItem();
    }

    @Override
    public String getModelType() {
        return "PSACHANDLER_FORMITEM";
    }

    @Override
    public String getModelId() {
        return this.getPSDEFormItem().getModelId();
    }

    @Override
    public IPSAppView getPSAppView() {
        return this.getPSDEFormItem().getPSDEForm().getPSAppView();
    }
}

