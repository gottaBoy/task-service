/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.toolbar;

import net.ibizsys.model.control.toolbar.IPSDEToolbar;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;

public interface IPSDEToolbarItem
extends IPSModelObject {
    public static final String TBITEMTYPE_DEUIACTION = "DEUIACTION";
    public static final String TBITEMTYPE_SEPERATOR = "SEPERATOR";
    public static final String TBITEMTYPE_ITEMS = "ITEMS";
    public static final String TBITEMTYPE_RAWITEM = "RAWITEM";
    public static final String SHOWMODE_ICONANDSHORTWORD = "ICONANDSHORTWORD";
    public static final String SHOWMODE_ICON = "ICON";
    public static final String SHOWMODE_SHORTWORD = "SHORTWORD";

    public String getCaption();

    public String getItemType();

    public boolean isValid() throws Exception;

    public IPSDEToolbar getPSDEToolbar();

    public boolean isShowCaption();

    public boolean isShowIcon();

    public String getTooltip();

    public IPSSysImage getPSSysImage();

    public IPSSysCss getPSSysCss();

    public IPSDEToolbarItem getParentPSDEToolbarItem();

    public IPSLanguageRes getCapPSLanguageRes();

    public IPSLanguageRes getTooltipPSLanguageRes();

    public double getWidth();

    public double getHeight();
}

