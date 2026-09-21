/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.menu;

import net.ibizsys.paas.control.menu.IMenuItemFiller;

public interface IMenuItem {
    public static final String MENUITEMTYPE_SEPERATOR = "SEPERATOR";
    public static final String MENUITEMTYPE_MENUITEM = "MENUITEM";
    public static final String MENUITEMTYPE_USERITEM = "USERITEM";

    public String getItemType();

    public String getId();

    public String getPId();

    public String getText();

    public boolean isExpanded();

    public String getTextCls();

    public String getIconCls();

    public String getIconPath();

    public String getCounterId();

    public void setAttribute(String var1, Object var2);

    public Object getAttribute(String var1);

    public int getAccUserMode();

    public String getAccessKey();

    public String getTextLanResTag();

    public String getTooltip();

    public String getTooltipLanResTag();

    public boolean isHidden();

    public String getFillerObj();

    public IMenuItemFiller getFiller() throws Exception;
}

