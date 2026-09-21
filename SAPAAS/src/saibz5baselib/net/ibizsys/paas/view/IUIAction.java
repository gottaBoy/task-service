/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.view;

import net.ibizsys.paas.core.IModelBase;

public interface IUIAction
extends IModelBase {
    public static final int NOPRIVDISPLAYMODE_HIDEDEFAULT = 6;
    public static final String ACTIONTARGET_SINGLE = "SINGLE";
    public static final String ACTIONTARGET_SINGLEKEY = "SINGLEKEY";
    public static final String ACTIONTARGET_MULTI = "MULTI";
    public static final String ACTIONTARGET_ALL = "ALL";
    public static final String ACTIONTARGET_NONE = "NONE";

    public String getUIActionTag();

    public String getUIActionType();

    public String getUIActionMode();

    public String getCaption();

    public String getTooltip();

    public String getCapLanResTag();

    public String getTooltipLanResTag();

    public String getActionTarget();

    public String getIconCls();

    public String getIconPath();

    public String getIconClsX();

    public String getIconPathX();

    public boolean isEnableRuntimeModel();

    public boolean isClosePopupView();
}

