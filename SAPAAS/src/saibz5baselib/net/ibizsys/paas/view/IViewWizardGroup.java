/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.view;

import java.util.Iterator;
import net.ibizsys.paas.core.IModelBase2;
import net.ibizsys.paas.view.IViewWizard;

public interface IViewWizardGroup
extends IModelBase2 {
    public Iterator<IViewWizard> getViewWizards();
}

