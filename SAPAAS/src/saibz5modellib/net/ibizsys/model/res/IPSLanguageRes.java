/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.res;

import net.ibizsys.model.IPSSystemObject;

public interface IPSLanguageRes
extends IPSSystemObject {
    public static final String LANRESTYPE_DE_LNAME = "DE.LNAME";
    public static final String LANRESTYPE_DEF_LNAME = "DEF.LNAME";
    public static final String LANRESTYPE_CL_ITEM_LNAME = "CL.ITEM.LNAME";
    public static final String LANRESTYPE_TBB_TEXT = "TBB.TEXT";
    public static final String LANRESTYPE_TBB_TOOLTIP = "TBB.TOOLTIP";
    public static final String LANRESTYPE_MENUITEM_CAPTION = "MENUITEM.CAPTION";
    public static final String LANRESTYPE_PAGE_HEADER = "PAGE.HEADER";
    public static final String LANRESTYPE_PAGE_COMMON = "PAGE.COMMON";
    public static final String LANRESTYPE_CONTROL = "CONTROL";
    public static final String LANRESTYPE_ERROR_STD = "ERROR.STD";
    public static final String LANRESTYPE_CTRL = "CTRL";
    public static final String LANRESTYPE_COMMON = "COMMON";
    public static final String LANRESTYPE_OTHER = "OTHER";

    public String getLanResType();

    public String getLanResTag();

    public String getShortLanResTag();

    public String getDefaultContent();

    public String getContent(String var1) throws Exception;

    public String getContent(String var1, boolean var2) throws Exception;

    public boolean hasShortLanResTag();

    public boolean isUserRef();

    public void markSysRef(Object var1, String var2);

    public void markSysRef();

    public boolean getRefFlag();
}

