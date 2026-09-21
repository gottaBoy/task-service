/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.drctrl;

import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.drctrl.IPSDRCtrl;
import net.ibizsys.model.res.IPSLanguageRes;

public interface IPSDRBar
extends IPSDRCtrl,
IPSControlContainer {
    public String getTitle();

    public IPSLanguageRes getTitlePSLanguageRes();

    public boolean isShowTitle();
}

