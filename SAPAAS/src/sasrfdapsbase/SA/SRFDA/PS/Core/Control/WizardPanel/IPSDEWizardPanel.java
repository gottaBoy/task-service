/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.WizardPanel;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.Control.Form.IPSDEEditForm;
import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.Control.WizardPanel.IPSWizardPanel;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizard;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5411\u5bfc\u9762\u677f\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEWizard")
public interface IPSDEWizardPanel
extends IPSWizardPanel {
    public IPSDEWizard getPSDEWizard();

    public Iterator<IPSDEEditForm> getPSDEEditForms();

    public boolean isShowStepBar();

    public boolean isShowActionBar();

    public IPSControlAction getInitPSControlAction();

    public IPSControlAction getFinishPSControlAction();

    public IPSDEField getStatePSDEField();

    public IPSAppDEField getStatePSAppDEField();
}

