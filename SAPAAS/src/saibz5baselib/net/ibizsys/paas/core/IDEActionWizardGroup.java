/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.util.Iterator;
import net.ibizsys.paas.core.IDEActionWizard;
import net.ibizsys.paas.core.IDataEntityObject;
import net.ibizsys.paas.view.IViewWizardGroup;

public interface IDEActionWizardGroup
extends IViewWizardGroup,
IDataEntityObject {
    public Iterator<IDEActionWizard> getDEActionWizards();
}

