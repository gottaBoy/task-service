/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEActionWizardGroup;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.demodel.IDEActionWizardModel;
import net.ibizsys.paas.view.IViewWizardGroupModel;

public interface IDEActionWizardGroupModel
extends IDEActionWizardGroup,
IViewWizardGroupModel,
IModelBase3 {
    public void registerDEActionWizardModel(IDEActionWizardModel var1) throws Exception;
}

