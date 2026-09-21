/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IDataEntityObject;
import net.ibizsys.paas.view.IUIAction;

public interface IDEUIAction
extends IDataEntityObject,
IUIAction {
    public static final String ACTIONTARGET_SINGLEDATA = "SINGLEDATA";
    public static final String ACTIONTARGET_SINGLEKEY = "SINGLEKEY";
    public static final String ACTIONTARGET_MULTIDATA = "MULTIDATA";
    public static final String ACTIONTARGET_MULTIKEY = "MULTIKEY";
    public static final String ACTIONTARGET_NONE = "NONE";

    public void init(IDataEntity var1) throws Exception;

    @Override
    public String getActionTarget();

    public boolean isReloadData();

    public String getSuccessMsg();

    public String getDataAccessAction();

    public boolean isCloseEditView();

    public boolean isGlobalUIAction();
}

