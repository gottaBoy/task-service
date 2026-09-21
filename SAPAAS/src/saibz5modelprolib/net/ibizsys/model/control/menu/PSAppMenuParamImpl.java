/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.menu.IPSAppMenuParam
 */
package net.ibizsys.model.control.menu;

import net.ibizsys.model.control.PSAjaxControlParamImpl;
import net.ibizsys.model.control.menu.IPSAppMenuParam;

public class PSAppMenuParamImpl
extends PSAjaxControlParamImpl
implements IPSAppMenuParam {
    private String strPSAppMenuId = "";

    public String getPSAppMenuId() {
        return this.strPSAppMenuId;
    }

    public void setPSAppMenuId(String strPSAppMenuId) {
        this.strPSAppMenuId = strPSAppMenuId;
    }
}

