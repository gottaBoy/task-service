/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.control.map;

import net.ibizsys.paas.core.IModelBase;
import net.sf.json.JSONObject;

public interface IMapItem
extends IModelBase {
    public static final String ITEMSTYLE_POINT = "POINT";
    public static final String ITEMSTYLE_POINT2 = "POINT2";
    public static final String ITEMSTYLE_POINT3 = "POINT3";
    public static final String ITEMSTYLE_POINT4 = "POINT4";
    public static final String ITEMSTYLE_LINE = "LINE";
    public static final String ITEMSTYLE_LINE2 = "LINE2";
    public static final String ITEMSTYLE_LINE3 = "LINE3";
    public static final String ITEMSTYLE_LINE4 = "LINE4";
    public static final String ITEMSTYLE_REGION = "REGION";
    public static final String ITEMSTYLE_REGION2 = "REGION2";
    public static final String ITEMSTYLE_REGION3 = "REGION3";
    public static final String ITEMSTYLE_REGION4 = "REGION4";
    public static final String ITEMSTYLE_USER = "USER";
    public static final String ITEMSTYLE_USER2 = "USER2";
    public static final String ITEMSTYLE_USER3 = "USER3";
    public static final String ITEMSTYLE_USER4 = "USER4";

    public String getItemType();

    public boolean isDisabled();

    public String getCssClass();

    public String getIconCssClass();

    public String getIcon();

    public String getHref();

    public String getHrefTarget();

    public String getTips();

    public String getText();

    public String getContent();

    public String getColor();

    public String getBKColor();

    public String getBorderColor();

    public int getBorderWidth();

    public int getRadius();

    public Double getLongitude();

    public Double getLatitude();

    public Double getAltitude();

    public Object getTagValue(String var1);

    public JSONObject getTag();

    public Object getDataSource();
}

