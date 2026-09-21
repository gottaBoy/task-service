/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IDEActionWizard;
import net.ibizsys.paas.core.IModelBase;

public interface IDEActionWizardItem
extends IModelBase {
    public IDEActionWizard getDEActionWizard();

    public String getContent();

    public String getMoreUrl();

    public String getActionValue();
}

