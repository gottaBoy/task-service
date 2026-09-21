/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.menu.IPSMenuItem
 *  net.ibizsys.paas.control.menu.IMenuItemFiller
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.menu;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.control.menu.IPSMenuItem;
import net.ibizsys.paas.control.menu.IMenuItemFiller;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSMenuItemImpl
extends PSObjectImpl
implements IPSMenuItem {
    private IPSMenuItem parentPSMenuItem = null;
    private String strCaption = null;
    private String strAccessKey = null;
    private String strTooltip = null;

    @PSModelRTMeta(description="\u6807\u9898")
    public String getCaption() {
        return this.strCaption;
    }

    protected void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    public IPSMenuItem getParentPSMenuItem() {
        return this.parentPSMenuItem;
    }

    protected void setParentPSMenuItem(IPSMenuItem parentPSMenuItem) {
        this.parentPSMenuItem = parentPSMenuItem;
    }

    public String getPId() {
        if (this.getParentPSMenuItem() != null) {
            return this.getParentPSMenuItem().getId();
        }
        return "";
    }

    public String getText() {
        return this.getCaption();
    }

    public boolean isExpanded() {
        return false;
    }

    public String getTextCls() {
        return null;
    }

    public String getIconCls() {
        return null;
    }

    public String getIconPath() {
        return null;
    }

    public String getCounterId() {
        return null;
    }

    public void setAttribute(String strName, Object objValue) {
    }

    public Object getAttribute(String strName) {
        return null;
    }

    public String getAccessKey() {
        return this.strAccessKey;
    }

    protected void setAccessKey(String strAccessKey) {
        this.strAccessKey = strAccessKey;
    }

    public String getTextLanResTag() {
        return "";
    }

    @PSModelRTMeta(description="\u64cd\u4f5c\u63d0\u793a\u4fe1\u606f")
    public String getTooltip() {
        if (StringHelper.isNullOrEmpty((String)this.strTooltip)) {
            return this.getCaption();
        }
        return this.strTooltip;
    }

    protected void setTooltip(String strTooltip) {
        this.strTooltip = strTooltip;
    }

    public String getTooltipLanResTag() {
        return "";
    }

    public String getFillerObj() {
        return null;
    }

    public IMenuItemFiller getFiller() throws Exception {
        return null;
    }
}

