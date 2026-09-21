/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.view.IUIAction
 */
package net.ibizsys.paas.view;

import net.ibizsys.paas.core.IDynaModelJsonExporter;
import net.ibizsys.paas.core.IDynaModelJsonLoader;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.view.IUIAction;

public interface IDynaUIActionModel
extends IUIAction,
IDynaModelJsonLoader,
IDynaModelJsonExporter {
    public static final String ATTR_ACTIONTARGET = "actiontarget";
    public static final String ATTR_ENABLETOGGLE = "enabletoggle";
    public static final String ATTR_ACTIONMODE = "actionmode";
    public static final String ACTIONMODE_SYS = "SYS";
    public static final String ACTIONMODE_FRONT = "FRONT";
    public static final String ACTIONMODE_BACKEND = "BACKEND";
    public static final String ACTIONMODE_WFFRONT = "WFFRONT";
    public static final String ACTIONMODE_WFBACKEND = "WFBACKEND";
    public static final String ACTIONTARGET_SINGLE = "SINGLE";
    public static final String ACTIONTARGET_SINGLEKEY = "SINGLEKEY";
    public static final String ACTIONTARGET_MULTI = "MULTI";
    public static final String ACTIONTARGET_ALL = "ALL";
    public static final String ACTIONTARGET_NONE = "NONE";
    public static final String ACTIONTYPE_DEUIACTION = "DEUIACTION";
    public static final String ACTIONTYPE_WFUIACTION = "WFUIACTION";

    public void init(IDataEntityModel var1, Object var2) throws Exception;
}

