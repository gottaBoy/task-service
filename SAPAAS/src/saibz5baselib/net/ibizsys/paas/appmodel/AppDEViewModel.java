/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.appmodel;

import net.ibizsys.paas.appmodel.AppViewModel;
import net.ibizsys.paas.appmodel.IAppDEViewModel;

public class AppDEViewModel
extends AppViewModel
implements IAppDEViewModel {
    private String strDEViewId = null;

    @Override
    public String getDEViewId() {
        return this.strDEViewId;
    }

    public void setDEViewId(String strDEViewId) {
        this.strDEViewId = strDEViewId;
    }
}

