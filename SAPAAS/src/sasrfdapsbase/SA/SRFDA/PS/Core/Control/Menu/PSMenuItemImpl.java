/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.control.menu.IMenuItemFiller
 */
package SA.SRFDA.PS.Core.Control.Menu;

import SA.SRFDA.PS.Core.Control.IPSControlAttribute;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.Control.IPSControlRender;
import SA.SRFDA.PS.Core.Control.Menu.IPSMenuItem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import net.ibizsys.paas.control.menu.IMenuItemFiller;

public abstract class PSMenuItemImpl
extends PSObjectImpl
implements IPSMenuItem {
    private IPSMenuItem parentPSMenuItem = null;
    private String strCaption = null;
    private String strAccessKey = null;
    private IPSLanguageRes capPSLanguageRes = null;
    private String strTooltip = null;
    private IPSLanguageRes tooltipPSLanguageRes = null;
    private boolean bExpanded = false;

    @Override
    @PSModelRTMeta(description="\u6807\u9898", fields={"CAPTION"})
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

    @Override
    public String getPId() {
        if (this.getParentPSMenuItem() != null) {
            return this.getParentPSMenuItem().getId();
        }
        return "";
    }

    @Override
    public String getText() {
        return this.getCaption();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5c55\u5f00\u83dc\u5355", ignoredumpvalues="false", fields={"EXPAND"})
    public boolean isExpanded() {
        return this.bExpanded;
    }

    protected void setExpanded(boolean bExpanded) {
        this.bExpanded = bExpanded;
    }

    @Override
    public String getTextCls() {
        return null;
    }

    @Override
    public String getIconCls() {
        return null;
    }

    @Override
    public String getIconPath() {
        return null;
    }

    @Override
    public String getCounterId() {
        return null;
    }

    @Override
    public void setAttribute(String strName, Object objValue) {
    }

    @Override
    public Object getAttribute(String strName) {
        return null;
    }

    @Override
    public String getAccessKey() {
        return this.strAccessKey;
    }

    protected void setAccessKey(String strAccessKey) {
        this.strAccessKey = strAccessKey;
    }

    @Override
    public String getTextLanResTag() {
        if (this.getCapPSLanguageRes() == null) {
            return "";
        }
        return this.getCapPSLanguageRes().getLanResTag();
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u63d0\u793a\u4fe1\u606f", fields={"TOOLTIPINFO"})
    public String getTooltip() {
        if (StringHelper.IsNullOrEmpty((String)this.strTooltip)) {
            return this.getCaption();
        }
        return this.strTooltip;
    }

    protected void setTooltip(String strTooltip) {
        this.strTooltip = strTooltip;
    }

    @Override
    public String getTooltipLanResTag() {
        if (this.getTooltipPSLanguageRes() == null) {
            return "";
        }
        return this.getTooltipPSLanguageRes().getLanResTag();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90", fields={"CAPPSLANRESID"})
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
    }

    protected void setCapPSLanguageRes(IPSLanguageRes capPSLanguageRes) {
        this.capPSLanguageRes = capPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u63d0\u793a\u8bed\u8a00\u8d44\u6e90", fields={"TIPPSLANRESID"})
    public IPSLanguageRes getTooltipPSLanguageRes() {
        return this.tooltipPSLanguageRes;
    }

    protected void setTooltipPSLanguageRes(IPSLanguageRes tooltipPSLanguageRes) {
        this.tooltipPSLanguageRes = tooltipPSLanguageRes;
    }

    public IMenuItemFiller getFiller() throws Exception {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u903b\u8f91\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlLogic> getPSControlLogics() {
        return this.onGetPSControlLogics();
    }

    protected Iterator<? extends IPSControlLogic> onGetPSControlLogics() {
        return this.getOwnedPSControl().getPSControlLogicsByItemName(this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u6ce8\u5165\u5c5e\u6027\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlAttribute> getPSControlAttributes() {
        return this.onGetPSControlAttributes();
    }

    protected Iterator<? extends IPSControlAttribute> onGetPSControlAttributes() {
        return this.getOwnedPSControl().getPSControlAttributesByItemName(this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u7ed8\u5236\u5668\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlRender> getPSControlRenders() {
        return this.onGetPSControlRenders();
    }

    protected Iterator<? extends IPSControlRender> onGetPSControlRenders() {
        return this.getOwnedPSControl().getPSControlRendersByItemName(this.getName());
    }
}

