/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDETreeGridView
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.app.view.IPSAppDETreeGridView;
import net.ibizsys.model.app.view.PSAppDEMultiDataViewImpl;

public class PSAppDETreeGridViewImpl
extends PSAppDEMultiDataViewImpl
implements IPSAppDETreeGridView {
    @Override
    protected void onInit() throws Exception {
        this.setEnableQuickSearchDefault(false);
        super.onInit();
    }
}

