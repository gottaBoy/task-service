/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.wizard;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.wizard.IPSDEWizard;
import net.ibizsys.model.dataentity.wizard.IPSDEWizardStep;

public interface IPSDEWizardForm
extends IPSModelObject {
    public static final String STEPACTION_PREV = "PREV";
    public static final String STEPACTION_NEXT = "NEXT";
    public static final String STEPACTION_FINISH = "FINISH";

    public IPSDEWizard getPSDEWizard();

    public IPSDEWizardStep getPSDEWizardStep();

    public String getFormTag();

    public IPSDEAction getLoadPSDEAction();

    public IPSDEAction getSavePSDEAction();

    public String[] getStepActions();

    public boolean isFirstForm();

    public String getPSDEFormId();

    public String getPSDEFormName();
}

