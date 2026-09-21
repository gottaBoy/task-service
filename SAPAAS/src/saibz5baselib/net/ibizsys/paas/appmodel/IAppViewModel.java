/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.appmodel;

import net.ibizsys.paas.core.IModelBase;

public interface IAppViewModel
extends IModelBase {
    public String getTitle();

    public String getModuleName();

    public String getOpenMode();

    public int getWidth();

    public int getHeight();

    public String getViewUrl();

    public String getAppId();

    public Object getUserData();

    public Object getUserData2();
}

