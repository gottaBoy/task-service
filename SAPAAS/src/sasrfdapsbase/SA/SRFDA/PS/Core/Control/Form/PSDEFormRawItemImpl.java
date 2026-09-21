/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormRawItem;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormDetailImpl;
import SA.SRFDA.PS.Core.Control.IPSRawItemBase;
import SA.SRFDA.PS.Core.Control.IPSRawItemContainer;
import SA.SRFDA.PS.Core.Control.IPSRawItemParam;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.PS.Core.Util.PSRawItemHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.pscore.srv.util.PropertiesHelper;

public class PSDEFormRawItemImpl
extends PSDEFormDetailImpl
implements IPSDEFormRawItem,
IPSRawItemContainer {
    private String strRawContent = "";
    private double fRawContentHeight = -1.0;
    private double fRawContentWidth = -1.0;
    private String strContentType = "RAW";
    private String strHtmlContent = "";
    private IPSSysResource iPSSysResource = null;
    private Properties rawItemParams = null;
    private IPSRawItemBase iPSRawItemBase = null;

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getEDITORPARAMS())) {
            this.rawItemParams = PropertiesHelper.load((String)this.psDEFormDetail.getEDITORPARAMS());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getCONTENTTYPE())) {
            this.strContentType = this.psDEFormDetail.getCONTENTTYPE();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getPSSYSRESOURCEID())) {
            this.iPSSysResource = this.getPSSystem().getPSSysResource(this.psDEFormDetail.getPSSYSRESOURCEID());
        }
        if (StringHelper.Compare((String)this.getContentType(), (String)"RAW", (boolean)false) == 0) {
            if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getRAWCONTENT())) {
                this.strRawContent = this.psDEFormDetail.getRAWCONTENT();
            }
        } else if (StringHelper.Compare((String)this.getContentType(), (String)"HTML", (boolean)false) == 0) {
            if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getHTMLCONTENT())) {
                this.strHtmlContent = this.psDEFormDetail.getHTMLCONTENT();
            }
        } else if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getRAWCONTENT())) {
            this.strRawContent = this.psDEFormDetail.getRAWCONTENT();
        }
        if (!this.psDEFormDetail.isCTRLHEIGHTNull()) {
            this.fRawContentHeight = this.psDEFormDetail.getCTRLHEIGHT();
        }
        if (!this.psDEFormDetail.isCTRLWIDTHNull()) {
            this.fRawContentWidth = this.psDEFormDetail.getCTRLWIDTH();
        }
        super.onInit();
    }

    @Override
    public void fillPSDEFormItems(ArrayList<IPSDEFormItem> psDEFormItemList) {
    }

    @Override
    public double getRawContentHeight() {
        return this.fRawContentHeight;
    }

    @Override
    public double getRawContentWidth() {
        return this.fRawContentWidth;
    }

    @Override
    public String getModelType() {
        return "PSDEFORMDETAIL_RAWITEM";
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u7c7b\u578b", ignorert=3, codelist="ContentType", fields={"CONTENTTYPE"})
    public String getContentType() {
        return this.strContentType;
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u9879\u9ad8\u5ea6", ignorert=3, ignoredumpvalues="0.0", fields={"CTRLHEIGHT"})
    public double getRawItemHeight() {
        return this.getRawContentHeight();
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u9879\u5bbd\u5ea6", ignorert=3, ignoredumpvalues="0.0", fields={"CTRLWIDTH"})
    public double getRawItemWidth() {
        return this.getRawContentWidth();
    }

    @Override
    @PSModelRTMeta(description="Html\u5185\u5bb9", ignorert=3, fields={"HTMLCONTENT"})
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
    @PSModelRTMeta(description="\u76f4\u63a5\u5185\u5bb9", ignorert=3, fields={"RAWCONTENT"})
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
        return this.getDetailStyle();
    }

    @Override
    public String getRawItemCssStyle() {
        return this.psDEFormDetail.getRAWCSSSTYLE();
    }

    @Override
    public String getRawItemDynaClass() {
        return this.psDEFormDetail.getDYNACLASS();
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
        if (StringHelper.IsNullOrEmpty((String)strDefault) && StringHelper.IsNullOrEmpty((String)strValue) && strDefault != null) {
            if (StringHelper.Compare((String)"WRAPMODE", (String)strRawItemParam, (boolean)false) == 0) {
                return this.psDEFormDetail.getSWAPMODE();
            }
            if (StringHelper.Compare((String)"HALIGN", (String)strRawItemParam, (boolean)false) == 0) {
                return this.psDEFormDetail.getHALIGN();
            }
            if (StringHelper.Compare((String)"VALIGN", (String)strRawItemParam, (boolean)false) == 0) {
                return this.psDEFormDetail.getVALIGN();
            }
        }
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
        return this.psDEFormDetail.getTEMPLATEMODE() == 1;
    }

    @Override
    public String getTooltip() {
        return this.psDEFormDetail.getTOOLTIPINFO();
    }
}

