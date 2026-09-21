/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.dashboard;

import net.ibizsys.paas.control.IControl;

public interface IPortlet
extends IControl {
    public static final String PORTLETTYPE_CHART = "CHART";
    public static final String PORTLETTYPE_LIST = "LIST";
    public static final String PORTLETTYPE_CUSTOM = "CUSTOM";
    public static final String PORTLETTYPE_HTML = "HTML";
    public static final String PORTLETTYPE_VIEW = "VIEW";
    public static final String PORTLETTYPE_APPMENU = "APPMENU";
    public static final String PORTLETTYPE_FORM = "FORM";
    public static final String PORTLETTYPE_SEARCHFORM = "SEARCHFORM";
    public static final String PORTLETTYPE_CONTAINER = "CONTAINER";
    public static final String PORTLETTYPE_RAWITEM = "RAWITEM";

    public String getPortletType();

    public String getTitle();
}

