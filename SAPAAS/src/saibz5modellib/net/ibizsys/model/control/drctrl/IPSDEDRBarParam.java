/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.drctrl;

import net.ibizsys.model.control.drctrl.IPSDEDRCtrlParam;

public interface IPSDEDRBarParam
extends IPSDEDRCtrlParam {
    @Override
    public String getPSSysCounterId();

    public String getTitle();

    public String getTitlePSLanguageResId();

    public Boolean isShowTitle();
}

