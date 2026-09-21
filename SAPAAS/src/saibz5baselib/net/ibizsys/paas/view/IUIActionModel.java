/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.view;

import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.view.IUIAction;

public interface IUIActionModel
extends IUIAction,
IModelBase3 {
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
}

