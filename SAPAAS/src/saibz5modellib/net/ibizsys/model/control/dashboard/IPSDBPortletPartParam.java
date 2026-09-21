/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.dashboard;

import net.ibizsys.model.control.IPSAjaxControlParam;

public interface IPSDBPortletPartParam
extends IPSAjaxControlParam {
    public String getPortletType();

    public int getColumnId();

    public int getColumnSpan();

    public int getColXS();

    public int getColSM();

    public int getColMD();

    public int getColLG();

    public int getColXSOffset();

    public int getColSMOffset();

    public int getColMDOffset();

    public int getColLGOffset();

    public boolean isNewRowMode();

    public String getTitle();

    public String getTitlePSLanguageResId();

    public Boolean getShowTitleBar();
}

