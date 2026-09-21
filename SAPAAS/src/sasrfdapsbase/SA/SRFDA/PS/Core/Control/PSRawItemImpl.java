/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSControlAttribute;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.Control.IPSControlRender;
import SA.SRFDA.PS.Core.Control.IPSRawItem;
import SA.SRFDA.PS.Core.Control.IPSRawItemContainer;
import SA.SRFDA.PS.Core.Control.IPSRawItemParam;
import SA.SRFDA.PS.Core.Control.RawItem.IPSUnkownItem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSRawItemImpl
extends PSObjectImpl
implements IPSRawItem,
IPSUnkownItem {
    private static final Log log = LogFactory.getLog(PSRawItemImpl.class);
    private IPSRawItemContainer iPSRawItemContainer = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSRawItemContainer iPSRawItemContainer, String strName) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSRawItemContainer(iPSRawItemContainer);
        if (StringHelper.isNullOrEmpty((String)strName)) {
            this.setName(iPSRawItemContainer.getRawItemName());
        } else {
            this.setName(strName);
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u5185\u5bb9\u9879\u5bb9\u5668")
    public IPSRawItemContainer getPSRawItemContainer() {
        return this.iPSRawItemContainer;
    }

    protected void setPSRawItemContainer(IPSRawItemContainer iPSRawItemContainer) {
        this.iPSRawItemContainer = iPSRawItemContainer;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSRawItemContainer().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u7c7b\u578b")
    public String getContentType() {
        return this.getPSRawItemContainer().getContentType();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u5bbd\u5ea6", ignoredumpvalues="0.0")
    public double getRawItemWidth() {
        return this.getPSRawItemContainer().getRawItemWidth();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u9ad8\u5ea6", ignoredumpvalues="0.0")
    public double getRawItemHeight() {
        return this.getPSRawItemContainer().getRawItemHeight();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u677f\u6a21\u5f0f", ignoredumpvalues="false")
    public boolean isTemplateMode() {
        return this.getPSRawItemContainer().isTemplateMode();
    }

    @Override
    public String getModelType() {
        return "PSRAWITEM$" + this.getPSRawItemContainer().getModelType();
    }

    @Override
    public String getModelId() {
        return this.getPSRawItemContainer().getModelId();
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u7c7b\u578b")
    public String getPredefinedType() {
        return this.getPSRawItemContainer().getPredefinedType();
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u5185\u5bb9")
    public String getRawContent() {
        return ((IPSRawItem)((Object)this.getPSRawItemContainer())).getRawContent();
    }

    @Override
    @PSModelRTMeta(description="Html\u5185\u5bb9")
    public String getHtmlContent() {
        return ((IPSRawItem)((Object)this.getPSRawItemContainer())).getHtmlContent();
    }

    @Override
    public String getOriRawContent() {
        return ((IPSRawItem)((Object)this.getPSRawItemContainer())).getOriRawContent();
    }

    @Override
    public String getOriHtmlContent() {
        return ((IPSRawItem)((Object)this.getPSRawItemContainer())).getOriHtmlContent();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u7247\u5bf9\u8c61")
    public IPSSysImage getPSSysImage() {
        return ((IPSRawItem)((Object)this.getPSRawItemContainer())).getPSSysImage();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8d44\u6e90")
    public IPSSysResource getPSSysResource() {
        return ((IPSRawItem)((Object)this.getPSRawItemContainer())).getPSSysResource();
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u5185\u5bb9\u9879\u53c2\u6570\u96c6\u5408", child=true, hideempty=true)
    public Iterator<? extends IPSRawItemParam> getPSRawItemParams() {
        return this.getPSRawItemContainer().getPSRawItemParams();
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5Css\u6837\u5f0f")
    public String getCssStyle() {
        return this.getPSRawItemContainer().getRawItemCssStyle();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6837\u5f0f\u8868")
    public String getDynaClass() {
        return this.getPSRawItemContainer().getRawItemDynaClass();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6837\u5f0f\u8868")
    public IPSSysCss getPSSysCss() {
        return this.getPSRawItemContainer().getPSSysCss();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u903b\u8f91\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlLogic> getPSControlLogics() {
        return this.onGetPSControlLogics();
    }

    protected Iterator<? extends IPSControlLogic> onGetPSControlLogics() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u6ce8\u5165\u5c5e\u6027\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlAttribute> getPSControlAttributes() {
        return this.onGetPSControlAttributes();
    }

    protected Iterator<? extends IPSControlAttribute> onGetPSControlAttributes() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u7ed8\u5236\u5668\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlRender> getPSControlRenders() {
        return this.onGetPSControlRenders();
    }

    protected Iterator<? extends IPSControlRender> onGetPSControlRenders() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u63d0\u793a\u4fe1\u606f")
    public String getTooltip() {
        return this.getPSRawItemContainer().getTooltip();
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u63d0\u793a\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getTooltipPSLanguageRes() {
        return this.getPSRawItemContainer().getTooltipPSLanguageRes();
    }
}

