/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.toolbar.IPSDECMSeperatorItem
 *  net.ibizsys.model.control.toolbar.IPSDETBSeperatorItem
 *  net.ibizsys.model.res.IPSSysCss
 *  net.ibizsys.model.res.IPSSysImage
 */
package net.ibizsys.model.control.toolbar;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.control.toolbar.IPSDECMSeperatorItem;
import net.ibizsys.model.control.toolbar.IPSDETBSeperatorItem;
import net.ibizsys.model.control.toolbar.PSDEToolbarItemImpl;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;

public class PSDETBSeperatorItemImpl
extends PSDEToolbarItemImpl
implements IPSDETBSeperatorItem,
IPSDECMSeperatorItem {
    private boolean bSpanMode = false;

    @Override
    protected void onInit() throws Exception {
        if (!this.psDEToolbarItem.isSPANFLAGNull()) {
            this.bSpanMode = this.psDEToolbarItem.getSPANFLAG();
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

    @PSModelRTMeta(description="\u662f\u5426\u5ef6\u5c55")
    public boolean isSpanMode() {
        return this.bSpanMode;
    }

    @Override
    public String getCaption() {
        return super.getCaption();
    }

    @Override
    public boolean isShowCaption() {
        return super.isShowCaption();
    }

    @Override
    public IPSSysImage getPSSysImage() {
        return super.getPSSysImage();
    }

    @Override
    public IPSSysCss getPSSysCss() {
        return super.getPSSysCss();
    }
}

