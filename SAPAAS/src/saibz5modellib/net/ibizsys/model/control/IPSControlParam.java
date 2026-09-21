/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control;

import java.util.Iterator;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSControlParam
extends IPSModelObject {
    public IPSAppView getPSAppView();

    public Object getCtrlParam(String var1);

    public boolean containsCtrlParam(String var1);

    public String getCtrlParam(String var1, String var2);

    public boolean getCtrlParam(String var1, boolean var2);

    public int getCtrlParam(String var1, int var2);

    public Iterator<String> getCtrlParamNames();

    public Double getWidth();

    public Double getHeight();

    public Integer getOrderValue();

    public String getCtrlParam();

    public String getCtrlParam2();

    public Boolean isDefaultCtrl();

    public Boolean isDynamicCtrl();

    public String getPSSysCssId();
}

