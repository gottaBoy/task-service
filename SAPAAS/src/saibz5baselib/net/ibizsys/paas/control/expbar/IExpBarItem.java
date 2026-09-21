/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.expbar;

import java.util.ArrayList;
import java.util.Iterator;

public interface IExpBarItem {
    public static final int COUNTERMODE_NONE = 0;
    public static final int COUNTERMODE_HIDEZERO = 1;

    public String getId();

    public String getPId();

    public String getText();

    public boolean isExpanded();

    public ArrayList<IExpBarItem> getItems();

    public String getTextCls();

    public String getIconCls();

    public String getIconPath();

    public String getCounterId();

    public int getCounterMode();

    public void setAttribute(String var1, Object var2);

    public Object getAttribute(String var1);

    public String getExpViewId();

    public void setViewParam(String var1, String var2);

    public String getViewParam(String var1);

    public Iterator<String> getViewParamNames();

    public String getTextLanResTag();
}

