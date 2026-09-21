/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.IPSDataEntityObject;

public interface IPSAppDEView
extends IPSAppView,
IPSDataEntityObject {
    public String getPSDEViewId();

    public String getPSDEViewName();

    @Override
    public IPSDataEntity getPSDataEntity();

    public int getTempMode();

    @Override
    public boolean isEnableWF();
}

