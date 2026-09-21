/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.view;

import java.util.ArrayList;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.view.IViewWizard;
import net.ibizsys.paas.view.IViewWizardGroup;

public interface IViewWizardGroupModel
extends IViewWizardGroup {
    public void fillViewWizards(IViewController var1, String var2, ArrayList<IViewWizard> var3) throws Exception;

    public IViewWizard getViewWizard(String var1) throws Exception;
}

