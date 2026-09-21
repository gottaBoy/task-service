/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.IPSRawItemBase;
import SA.SRFDA.PS.Core.Control.IPSRawItemContainer;
import SA.SRFDA.PS.Core.Control.IPSRawItemParam;
import SA.SRFDA.PS.Core.Control.PSRawItemParamProxy;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelField;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelRawItem;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelItemImpl;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelRawItemParamImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.PS.Core.Util.PSRawItemHelper;
import SA.SRFDA.PS.Data.PSSysPanelItem;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import net.ibizsys.pscore.srv.util.PropertiesHelper;

@PSModelImplementMeta(implement="IPSPanelItem", typevalues={"RAWITEM"})
public class PSSysPanelRawItemImpl
extends PSSysPanelItemImpl
implements IPSSysPanelRawItem,
IPSRawItemContainer {
    private String strRawContent = "";
    private String strContentType = "";
    private String strHtmlContent = "";
    private IPSSysResource iPSSysResource = null;
    private Properties rawItemParams = null;
    private IPSRawItemBase iPSRawItemBase = null;
    private List<IPSRawItemParam> psRawItemParamList = null;

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getITEMPARAMS())) {
            this.rawItemParams = PropertiesHelper.load((String)this.psSysPanelItem.getITEMPARAMS());
        }
        this.strContentType = this.psSysPanelItem.getCONTENTTYPE();
        if (!StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getPSSYSRESOURCEID())) {
            this.iPSSysResource = this.getPSSystem().getPSSysResource(this.psSysPanelItem.getPSSYSRESOURCEID());
        }
        if (StringHelper.Compare((String)this.strContentType, (String)"RAW", (boolean)true) == 0) {
            if (!StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getRAWCONTENT())) {
                this.strRawContent = this.psSysPanelItem.getRAWCONTENT();
            }
        } else if (StringHelper.Compare((String)this.strContentType, (String)"HTML", (boolean)true) == 0) {
            if (!StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getHTMLCONTENT())) {
                this.strHtmlContent = this.psSysPanelItem.getHTMLCONTENT();
            }
        } else if (!StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getRAWCONTENT())) {
            this.strRawContent = this.psSysPanelItem.getRAWCONTENT();
        }
        super.onInit();
        this.onPreparePSSysPanelRawItemParams();
    }

    protected void onPreparePSSysPanelRawItemParams() throws Exception {
        this.psRawItemParamList = null;
        ArrayList<PSSysPanelItem> psPanelItemList = this.psSysPanelItem.getChildPSSysPanelItems(false);
        if (psPanelItemList == null && this.getRawItemParams() == null) {
            return;
        }
        this.psRawItemParamList = new ArrayList<IPSRawItemParam>();
        if (psPanelItemList != null) {
            for (PSSysPanelItem psSysPanelItem : psPanelItemList) {
                if (StringHelper.Compare((String)psSysPanelItem.getITEMTYPE(), (String)"PARAM", (boolean)false) != 0) continue;
                PSSysPanelRawItemParamImpl psSysPanelRawItemParamImpl = new PSSysPanelRawItemParamImpl();
                psSysPanelRawItemParamImpl.init(this.getDAGlobalHelper(), this.iPSSysPanel, this, psSysPanelItem);
                this.psRawItemParamList.add(PSRawItemParamProxy.from(this, psSysPanelRawItemParamImpl));
            }
        }
        if (this.getRawItemParams() != null) {
            for (Object objKey : this.getRawItemParams().keySet()) {
                String strContent = PropertiesHelper.getProperty((Properties)this.getRawItemParams(), (String)((String)objKey));
                PSSysPanelItem psSysPanelItem = new PSSysPanelItem();
                psSysPanelItem.setPSSYSVIEWPANELITEMID((String)objKey);
                psSysPanelItem.setPREDEFINEDTYPE((String)objKey);
                psSysPanelItem.setRAWCONTENT(strContent);
                PSSysPanelRawItemParamImpl psSysPanelRawItemParamImpl = new PSSysPanelRawItemParamImpl();
                psSysPanelRawItemParamImpl.init(this.getDAGlobalHelper(), this.iPSSysPanel, this, psSysPanelItem);
                this.psRawItemParamList.add(PSRawItemParamProxy.from(this, psSysPanelRawItemParamImpl));
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u7c7b\u578b", ignorert=3)
    public String getContentType() {
        return this.strContentType;
    }

    @Override
    public void fillPSPanelFields(ArrayList<IPSPanelField> psSysViewPanelFieldList) {
    }

    @Override
    public String getModelType() {
        return "PSSYSVIEWPANELITEM_RAWITEM";
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u9879\u9ad8\u5ea6", ignorert=3, ignoredumpvalues="0.0")
    public double getRawItemHeight() {
        return this.getHeight();
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u9879\u5bbd\u5ea6", ignorert=3, ignoredumpvalues="0.0")
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
        return this.getItemStyle();
    }

    @Override
    public String getRawItemCssStyle() {
        return this.psSysPanelItem.getRAWCSSSTYLE();
    }

    @Override
    public String getRawItemDynaClass() {
        return this.psSysPanelItem.getDYNACLASS();
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
                return this.psSysPanelItem.getSWAPMODE();
            }
            if (StringHelper.Compare((String)"HALIGN", (String)strRawItemParam, (boolean)false) == 0) {
                return this.psSysPanelItem.getHALIGN();
            }
            if (StringHelper.Compare((String)"VALIGN", (String)strRawItemParam, (boolean)false) == 0) {
                return this.psSysPanelItem.getVALIGN();
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
        if (this.psRawItemParamList == null || this.psRawItemParamList.size() == 0) {
            return null;
        }
        return this.psRawItemParamList.iterator();
    }

    @Override
    public boolean isTemplateMode() {
        return this.psSysPanelItem.getTEMPLATEMODE() == 1;
    }

    @Override
    public String getTooltip() {
        return this.psSysPanelItem.getTOOLTIPINFO();
    }
}

