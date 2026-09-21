/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.grid;

import net.ibizsys.paas.web.IWebContext;

public interface IGridColumn {
    public static final String GRIDCOLTYPE_DEFGRIDCOLUMN = "DEFGRIDCOLUMN";
    public static final String GRIDCOLTYPE_DEFTREEGRIDCOLUMN = "DEFTREEGRIDCOLUMN";
    public static final String WIDTHUNIT_PX = "PX";
    public static final String WIDTHUNIT_STAR = "STAR";
    public static final String ALIGN_LEFT = "LEFT";
    public static final String ALIGN_CENTER = "CENTER";
    public static final String ALIGN_RIGHT = "RIGHT";

    public String getCaption();

    public String getDataItemName();

    public String getExcelCaption();

    public String getCodeListId();

    public String getExcelText(IWebContext var1, Object var2) throws Exception;

    public String getExcelText(IWebContext var1, Object var2, boolean var3) throws Exception;

    public String getAlign();

    public String getCapLanResTag();

    public String getExcelCapLanResTag();
}

