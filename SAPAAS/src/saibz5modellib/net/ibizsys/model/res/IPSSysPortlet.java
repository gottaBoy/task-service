/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.res;

import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSPortletType;

public interface IPSSysPortlet
extends IPSSystemObject {
    public String getTitle();

    public String getPortletType();

    public int getReloadTimer();

    public boolean isShowTitleBar();

    @Deprecated
    public IPSLanguageRes getTitlePSIpsLanguageRes();

    public IPSLanguageRes getTitlePSLanguageRes();

    public int getHeight();

    public IPSPortletType getPSPortletType();

    public IPSLanguageRes getEmptyTextPSLanguageRes();

    public String getEmptyText();

    public String getPSACHandlerId();
}

