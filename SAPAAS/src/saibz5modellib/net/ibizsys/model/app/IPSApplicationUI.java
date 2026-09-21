/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.app;

import net.ibizsys.model.core.IPSModelObject;

public interface IPSApplicationUI
extends IPSModelObject {
    public static final int GRIDROWACTIVEMODE_NONE = 0;
    public static final int GRIDROWACTIVEMODE_CLCIK = 1;
    public static final int GRIDROWACTIVEMODE_DBCLICK = 2;

    public Object getPFStyleParam(String var1) throws Exception;

    public boolean getPFStyleParam(String var1, boolean var2) throws Exception;

    public String getPFStyleParam(String var1, String var2) throws Exception;

    public int getPFStyleParam(String var1, int var2) throws Exception;

    public double getPFStyleParam(String var1, double var2) throws Exception;

    public String getMainMenuAlign();

    public int getButtonNoPrivDisplayMode();

    public boolean isEnableCol12ToCol24();

    public boolean isGridForceFit();

    public int getGridRowActiveMode();

    public String getFormLayoutMode();

    public int getEditFormLabelWidth();
}

