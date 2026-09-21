/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswx.core;

import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.pswx.core.IWXAccount;
import net.ibizsys.pswx.core.IWXEntApp;

public interface IWXLogic
extends IModelBase {
    public static final String EVENTTYPE_APP_IN = "app_in";
    public static final String EVENTTYPE_LOCATION_IN = "location_in";
    public static final String EVENTTYPE_ASYNCTASK_FINISH = "asynctask_finish";
    public static final String EVENTTYPE_MENU_CLICK = "menu_click";
    public static final String EVENTTYPE_MESSAGE_IN = "message_in";

    public IWXAccount getWXAccount();

    public IWXEntApp getWXEntApp();

    public String getEventType();

    public String getDEName();

    public String getDEActionName();

    public String getWXFunc();

    public String getClickTag();

    public String getUserTag();
}

