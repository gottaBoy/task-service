/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Wizard;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizard;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5411\u5bfc\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEWizardLogic")
public interface IPSDEWizardLogic
extends IPSDEUILogicGroupDetail {
    public IPSDEWizard getPSDEWizard();

    public String getPSDEWizardStepId();

    public String getPSDEWizardFormId();

    public String getPSDEWizardStepName();

    public String getPSDEWizardFormName();

    public String getPSDEWizardStepTag();

    public String getPSDEWizardFormTag();
}

