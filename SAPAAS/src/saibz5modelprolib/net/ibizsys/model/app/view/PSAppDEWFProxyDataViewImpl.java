/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEWFProxyDataView
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.app.view.IPSAppDEWFProxyDataView;
import net.ibizsys.model.app.view.PSAppDEViewImpl;

public class PSAppDEWFProxyDataViewImpl
extends PSAppDEViewImpl
implements IPSAppDEWFProxyDataView {
    @Override
    public boolean isEnableWF() {
        return this.getPSDEWF() != null;
    }
}

