/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.wizard;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.wizard.IPSDEWizard;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;

public interface IPSDEWizardStep
extends IPSModelObject {
    public IPSDEWizard getPSDEWizard();

    public String getStepTag();

    public boolean isEnableLink();

    public String getTitle();

    public String getSubTitle();

    public IPSSysCss getTitlePSSysCss();

    public IPSSysImage getPSSysImage();
}

