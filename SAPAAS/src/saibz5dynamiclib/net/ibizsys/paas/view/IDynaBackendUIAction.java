/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.view.IUIAction
 */
package net.ibizsys.paas.view;

import net.ibizsys.paas.view.IUIAction;

public interface IDynaBackendUIAction
extends IUIAction {
    public boolean isReloadData();

    public String getSuccessMsg();

    public String getDataAccessAction();

    public boolean isCloseEditView();
}

