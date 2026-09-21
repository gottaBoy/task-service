/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.toolbar.IPSDECMRawItem
 *  net.ibizsys.model.control.toolbar.IPSDETBRawItem
 */
package net.ibizsys.model.control.toolbar;

import net.ibizsys.model.control.toolbar.IPSDECMRawItem;
import net.ibizsys.model.control.toolbar.IPSDETBRawItem;
import net.ibizsys.model.control.toolbar.PSDEToolbarItemImpl;

public class PSDETBRawItemImpl
extends PSDEToolbarItemImpl
implements IPSDETBRawItem,
IPSDECMRawItem {
    private String strRawContent;

    @Override
    protected void onInit() throws Exception {
        if (!this.psDEToolbarItem.isRAWCONTENTNull()) {
            this.strRawContent = this.psDEToolbarItem.getRAWCONTENT();
        }
        super.onInit();
    }

    @Override
    public boolean isShowIcon() {
        return false;
    }

    @Override
    public String getTooltip() {
        return null;
    }

    public String getRawContent() {
        return this.strRawContent;
    }
}

