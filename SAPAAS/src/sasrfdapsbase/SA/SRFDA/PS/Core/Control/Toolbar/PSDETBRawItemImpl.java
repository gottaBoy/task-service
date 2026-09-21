/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 */
package SA.SRFDA.PS.Core.Control.Toolbar;

import SA.SRFDA.PS.Core.Control.IPSRawItemBase;
import SA.SRFDA.PS.Core.Control.IPSRawItemContainer;
import SA.SRFDA.PS.Core.Control.IPSRawItemParam;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDECMRawItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDETBRawItem;
import SA.SRFDA.PS.Core.Control.Toolbar.PSDEToolbarItemImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.PS.Core.Util.PSRawItemHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.pscore.srv.util.PropertiesHelper;

public class PSDETBRawItemImpl
extends PSDEToolbarItemImpl
implements IPSDETBRawItem,
IPSDECMRawItem,
IPSRawItemContainer {
    private String strContentType = "RAW";
    private String strHtmlContent = "";
    private String strRawContent = "";
    private IPSSysResource iPSSysResource = null;
    private Properties rawItemParams = null;
    private IPSRawItemBase iPSRawItemBase = null;

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psDEToolbarItem.getCONTENTTYPE())) {
            this.strContentType = this.psDEToolbarItem.getCONTENTTYPE();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEToolbarItem.getPSSYSRESOURCEID())) {
            this.iPSSysResource = this.getPSDEToolbar().getPSAppView().getPSSystem().getPSSysResource(this.psDEToolbarItem.getPSSYSRESOURCEID());
        }
        if (StringHelper.Compare((String)this.getContentType(), (String)"RAW", (boolean)false) == 0) {
            if (!StringHelper.IsNullOrEmpty((String)this.psDEToolbarItem.getRAWCONTENT())) {
                this.strRawContent = this.psDEToolbarItem.getRAWCONTENT();
            }
        } else if (StringHelper.Compare((String)this.getContentType(), (String)"HTML", (boolean)false) == 0) {
            if (!StringHelper.IsNullOrEmpty((String)this.psDEToolbarItem.getHTMLCONTENT())) {
                this.strHtmlContent = this.psDEToolbarItem.getHTMLCONTENT();
            }
        } else if (!StringHelper.IsNullOrEmpty((String)this.psDEToolbarItem.getRAWCONTENT())) {
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
        return this.psDEToolbarItem.getTOOLTIPINFO();
    }

    @Override
    public String getModelType() {
        return "PSDEFORMDETAIL_RAWITEM";
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u7c7b\u578b", ignorert=3)
    public String getContentType() {
        return this.strContentType;
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u9879\u9ad8\u5ea6", ignorert=3, ignoredumpvalues="0.0", outputdoc="(%1$s.getRawItemHeight() gt 0)")
    public double getRawItemHeight() {
        return this.getHeight();
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u9879\u5bbd\u5ea6", ignorert=3, ignoredumpvalues="0.0", outputdoc="(%1$s.getRawItemWidth() gt 0)")
    public double getRawItemWidth() {
        return this.getWidth();
    }

    @Override
    @PSModelRTMeta(description="Html\u5185\u5bb9", ignorert=3)
    public String getHtmlContent() {
        if (!StringHelper.IsNullOrEmpty((String)this.getOriHtmlContent())) {
            return this.getOriHtmlContent();
        }
        if (this.getPSSysResource() != null) {
            return this.getPSSysResource().getContent();
        }
        return "";
    }

    @Override
    public String getOriHtmlContent() {
        return this.strHtmlContent;
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u5185\u5bb9", ignorert=3)
    public String getRawContent() {
        if (!StringHelper.IsNullOrEmpty((String)this.getOriRawContent())) {
            return this.getOriRawContent();
        }
        if (this.getPSSysResource() != null) {
            return this.getPSSysResource().getContent();
        }
        return "";
    }

    @Override
    public String getOriRawContent() {
        return this.strRawContent;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8d44\u6e90")
    public IPSSysResource getPSSysResource() {
        return this.iPSSysResource;
    }

    @Override
    public String getRawItemStyle() {
        return null;
    }

    @Override
    public String getRawItemCssStyle() {
        return this.psDEToolbarItem.getRAWCSSSTYLE();
    }

    @Override
    public String getRawItemDynaClass() {
        return this.psDEToolbarItem.getDYNACLASS();
    }

    @Override
    public String getDynaClass() {
        return super.getDynaClass();
    }

    @Override
    public String getCssStyle() {
        return super.getCssStyle();
    }

    @Override
    public Properties getRawItemParams() {
        return this.rawItemParams;
    }

    @Override
    public int getRawItemParam(String strRawItemParam, int nDefault) {
        return PropertiesHelper.getProperty((Properties)this.getRawItemParams(), (String)strRawItemParam, (int)nDefault);
    }

    @Override
    public String getRawItemParam(String strRawItemParam, String strDefault) {
        String strValue = PropertiesHelper.getProperty((Properties)this.getRawItemParams(), (String)strRawItemParam, (String)strDefault);
        return strValue;
    }

    @Override
    public double getRawItemParam(String strRawItemParam, double fDefault) {
        return PropertiesHelper.getProperty((Properties)this.getRawItemParams(), (String)strRawItemParam, (double)fDefault);
    }

    @Override
    public boolean getRawItemParam(String strRawItemParam, boolean bDefault) {
        return PropertiesHelper.getProperty((Properties)this.getRawItemParams(), (String)strRawItemParam, (boolean)bDefault);
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u5185\u5bb9\u5bf9\u8c61", child=true)
    public IPSRawItemBase getPSRawItem() throws Exception {
        if (this.iPSRawItemBase == null) {
            this.iPSRawItemBase = PSRawItemHelper.createPSRawItemBase(this.getDAGlobalHelper(), this, null);
        }
        return this.iPSRawItemBase;
    }

    @Override
    public String getRawItemName() {
        return this.getName();
    }

    @Override
    public String getContent() {
        if (!StringHelper.IsNullOrEmpty((String)this.getOriRawContent())) {
            return this.getOriRawContent();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getOriHtmlContent())) {
            return this.getOriHtmlContent();
        }
        return null;
    }

    @Override
    public Iterator<? extends IPSRawItemParam> getPSRawItemParams() {
        return null;
    }

    @Override
    public boolean isTemplateMode() {
        return this.psDEToolbarItem.getTEMPLATEMODE() == 1;
    }
}

