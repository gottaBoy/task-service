/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEEditForm;
import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizardForm;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5411\u5bfc\u7f16\u8f91\u8868\u5355\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEForm")
public interface IPSDEWizardEditForm
extends IPSDEEditForm {
    public IPSDEWizardForm getPSDEWizardForm();

    public IPSControlAction getGoBackPSControlAction();
}

