/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.wizard;

import java.util.Iterator;
import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.wizard.IPSDEWizardForm;
import net.ibizsys.model.dataentity.wizard.IPSDEWizardStep;

public interface IPSDEWizard
extends IPSDataEntityObject {
    public Iterator<IPSDEWizardStep> getPSDEWizardSteps();

    public IPSDEWizardStep getPSDEWizardStep(String var1) throws Exception;

    public Iterator<IPSDEWizardForm> getPSDEWizardForms();

    public String getCodeName();

    public IPSDEAction getInitPSDEAction();

    public IPSDEAction getFinishPSDEAction();

    public String getPrevCaption();

    public String getNextCaption();

    public String getFinishCaption();

    public String getPrevCapLanResTag();

    public String getNextCapLanResTag();

    public String getFinishCapLanResTag();
}

