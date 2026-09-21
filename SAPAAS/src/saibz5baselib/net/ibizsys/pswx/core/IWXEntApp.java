/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswx.core;

import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.pswx.core.IWXAccount;
import net.ibizsys.pswx.core.IWXMenu;

public interface IWXEntApp
extends IModelBase {
    public static final String APPTYPE_H5 = "H5";
    public static final String APPTYPE_MSG = "MSG";

    public IWXAccount getWXAccount();

    public String getAppURL();

    public String getAppType();

    public boolean isReportLocation();

    public boolean isReportEnter();

    public String getAppSecret();

    public String getToken();

    public String getEncodingAESKey();

    public IWXMenu getDefaultWXMenu();
}

