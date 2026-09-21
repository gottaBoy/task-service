/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.drctrl;

import java.util.ArrayList;
import java.util.Iterator;

public interface IDRCtrlItem {
    public static final String ENABLEMODE_ALL = "ALL";
    public static final String ENABLEMODE_ALLWF = "ALLWF";
    public static final String ENABLEMODE_INWF = "INWF";
    public static final String ENABLEMODE_EDIT = "EDIT";
    public static final String ENABLEMODE_DEOPPRIV = "DEOPPRIV";
    public static final String ENABLEMODE_CUSTOM = "CUSTOM";

    public String getId();

    public String getPId();

    public String getText();

    public boolean isExpanded();

    public ArrayList<IDRCtrlItem> getItems();

    public String getTextCls();

    public String getIconCls();

    public String getIconPath();

    public String getIconClsX();

    public String getIconPathX();

    public String getCounterId();

    public void setAttribute(String var1, Object var2);

    public Object getAttribute(String var1);

    public String getDRViewId();

    public void setViewParam(String var1, String var2);

    public String getViewParam(String var1);

    public Iterator<String> getViewParamNames();

    public int getAccUserMode();

    public String getAccessKey();

    public String getEnableMode();

    public String getTestEnableDEActionName();

    public String getTestEnableDEOPPriv();

    public String getTextLanResTag();

    public String getDataTreeId();
}

