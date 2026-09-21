/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.util.Iterator;
import net.ibizsys.paas.core.IDEActionWizardItem;
import net.ibizsys.paas.core.IDataEntityObject;
import net.ibizsys.paas.view.IViewWizard;

public interface IDEActionWizard
extends IViewWizard,
IDataEntityObject {
    public static final int DYNAMICMODE_STATIC = 0;
    public static final int DYNAMICMODE_DEDATASET = 1;

    public Iterator<IDEActionWizardItem> getDEActionWizardItems();

    public String getKeywords();
}

