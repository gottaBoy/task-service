/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEActionWizard;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.demodel.IDEActionWizardItemModel;
import net.ibizsys.paas.view.IViewWizardModel;

public interface IDEActionWizardModel
extends IDEActionWizard,
IViewWizardModel,
IModelBase3 {
    public void registerDEActionWizardItemModel(IDEActionWizardItemModel var1) throws Exception;
}

