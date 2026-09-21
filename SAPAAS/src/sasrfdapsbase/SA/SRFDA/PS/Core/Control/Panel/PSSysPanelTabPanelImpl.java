/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.Control.PSNavigateContextImpl;
import SA.SRFDA.PS.Core.Control.PSNavigateParamImpl;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelDetailType;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelField;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelTabPage;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelItem;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelTabPanel;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelItemImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSSysPanelItem;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.pscore.srv.util.PropertiesHelper;

@PSModelImplementMeta(implement="IPSPanelItem", typevalues={"TABPANEL"})
public class PSSysPanelTabPanelImpl
extends PSSysPanelItemImpl
implements IPSSysPanelTabPanel {
    protected ArrayList<IPSPanelTabPage> psPanelTabPageList = new ArrayList();
    private String strDataRegionType = "INHERIT";
    private String strDataSourceType = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSAppDEAction iPSAppDEAction = null;
    private IPSAppDEDataSet iPSAppDEDataSet = null;
    private IPSAppDELogic iPSAppDELogic = null;
    private int nReloadTimer = -1;
    private String strDataName = null;
    private String strScriptCode = null;
    private boolean bShowBusyIndicator = false;
    private Map<String, IPSNavigateContext> psNavigateContextMap = null;
    private Map<String, IPSNavigateParam> psNavigateParamMap = null;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getDATAPANELMODE())) {
            this.strDataRegionType = this.psSysPanelItem.getDATAPANELMODE();
            if (StringHelper.Compare((String)this.getDataRegionType(), (String)"NONE", (boolean)false) != 0 && StringHelper.Compare((String)this.getDataRegionType(), (String)"INHERIT", (boolean)false) != 0) {
                this.strDataSourceType = this.psSysPanelItem.getDATASOURCE();
                if (!this.psSysPanelItem.isBUSYINDICATORNull()) {
                    this.bShowBusyIndicator = this.psSysPanelItem.getBUSYINDICATOR();
                }
                if (StringHelper.Compare((String)this.getDataSourceType(), (String)"DEACTION", (boolean)false) == 0 || StringHelper.Compare((String)this.getDataSourceType(), (String)"DEDATASET", (boolean)false) == 0 || StringHelper.Compare((String)this.getDataSourceType(), (String)"DELOGIC", (boolean)false) == 0) {
                    if (StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getPSDEID())) throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u6e90\u5b9e\u4f53\u5bf9\u8c61");
                    this.iPSAppDataEntity = this.getPSSysPanel().getPSAppView().getPSApplication().getPSAppDataEntityByDEId(this.psSysPanelItem.getPSDEID(), false);
                    if (StringHelper.Compare((String)this.getDataSourceType(), (String)"DEACTION", (boolean)false) == 0) {
                        if (StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getPSDEACTIONID())) throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u6e90\u884c\u4e3a\u5bf9\u8c61");
                        this.iPSAppDEAction = this.getPSAppDataEntity().getPSAppDEAction(this.psSysPanelItem.getPSDEACTIONID(), false);
                    }
                    if (StringHelper.Compare((String)this.getDataSourceType(), (String)"DEDATASET", (boolean)false) == 0) {
                        if (StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getPSDEDATASETID())) throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u6e90\u6570\u636e\u96c6\u5bf9\u8c61");
                        this.iPSAppDEDataSet = this.getPSAppDataEntity().getPSAppDEDataSet(this.psSysPanelItem.getPSDEDATASETID(), false);
                    }
                    if (StringHelper.Compare((String)this.getDataSourceType(), (String)"DELOGIC", (boolean)false) == 0) {
                        if (StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getPSDELOGICID())) throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u6e90\u5904\u7406\u903b\u8f91\u5bf9\u8c61");
                        this.iPSAppDELogic = this.getPSAppDataEntity().getPSAppDELogic(this.psSysPanelItem.getPSDELOGICID(), false);
                    }
                    if (!this.psSysPanelItem.isGETDATATIMERNull() && this.psSysPanelItem.getGETDATATIMER() > 0) {
                        this.nReloadTimer = this.psSysPanelItem.getGETDATATIMER();
                    }
                    this.onPreparePSNavViewParams();
                } else if (StringHelper.Compare((String)this.getDataSourceType(), (String)"APPGLOBALPARAM", (boolean)false) == 0 || StringHelper.Compare((String)this.getDataSourceType(), (String)"TOPVIEWSESSIONPARAM", (boolean)false) == 0 || StringHelper.Compare((String)this.getDataSourceType(), (String)"VIEWSESSIONPARAM", (boolean)false) == 0 || StringHelper.Compare((String)this.getDataSourceType(), (String)"ACTIVEDATAPARAM", (boolean)false) == 0) {
                    this.strDataName = this.psSysPanelItem.getFIELDNAME();
                    if (StringHelper.IsNullOrEmpty((String)this.strDataName)) {
                        throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u5bf9\u8c61\u540d\u79f0");
                    }
                } else if (StringHelper.Compare((String)this.getDataSourceType(), (String)"CUSTOM", (boolean)false) == 0) {
                    this.strScriptCode = this.psSysPanelItem.getCUSTOMCODE();
                    if (StringHelper.IsNullOrEmpty((String)this.strScriptCode)) {
                        throw new Exception("\u672a\u6307\u5b9a\u81ea\u5b9a\u4e49\u4ee3\u7801");
                    }
                }
            }
        }
        this.onPreparePSPanelTabPages();
    }

    protected void onPreparePSNavViewParams() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getITEMPARAMS())) {
            return;
        }
        Properties navViewParams = PropertiesHelper.load((String)this.psSysPanelItem.getITEMPARAMS());
        if (navViewParams != null) {
            for (Object objKey : navViewParams.keySet()) {
                PSNavigateParamImpl PSNavigateParamImpl2;
                boolean bRawValue;
                String strKey = objKey.toString();
                String strValue = PropertiesHelper.getProperty((Properties)navViewParams, (String)strKey);
                String strTag = strKey.toUpperCase();
                if (strTag.indexOf("SRFNAVCTX.") == 0) {
                    bRawValue = true;
                    strTag = strKey.substring("SRFNAVCTX.".length()).toUpperCase();
                    if (!StringHelper.IsNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    PSNavigateContextImpl PSNavigateContextImpl2 = new PSNavigateContextImpl();
                    PSNavigateContextImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateContextMap == null) {
                        this.psNavigateContextMap = new LinkedHashMap<String, IPSNavigateContext>();
                    }
                    this.psNavigateContextMap.put(strTag, PSNavigateContextImpl2);
                    continue;
                }
                if (strTag.indexOf("SRFNAVPARAM.") == 0) {
                    bRawValue = true;
                    strTag = strKey.substring("SRFNAVPARAM.".length()).toLowerCase();
                    if (!StringHelper.IsNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    PSNavigateParamImpl2 = new PSNavigateParamImpl();
                    PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateParamMap == null) {
                        this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                    }
                    this.psNavigateParamMap.put(strTag, PSNavigateParamImpl2);
                    continue;
                }
                bRawValue = true;
                strTag = strKey.toLowerCase();
                if (!StringHelper.IsNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                    strValue = strValue.replace("%", "");
                    bRawValue = false;
                }
                PSNavigateParamImpl2 = new PSNavigateParamImpl();
                PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                if (this.psNavigateParamMap == null) {
                    this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                }
                this.psNavigateParamMap.put(strTag, PSNavigateParamImpl2);
            }
        }
    }

    protected void onPreparePSPanelTabPages() throws Exception {
        this.psPanelTabPageList.clear();
        ArrayList<PSSysPanelItem> psPanelItemList = this.psSysPanelItem.getChildPSSysPanelItems(false);
        if (psPanelItemList == null) {
            return;
        }
        for (PSSysPanelItem psPanelItem : psPanelItemList) {
            if (StringHelper.Compare((String)psPanelItem.getITEMTYPE(), (String)"PARAM", (boolean)false) == 0) continue;
            IPSPanelDetailType iPSPanelItemType = this.getPSModelStorage().getPSPanelDetailType(psPanelItem.getITEMTYPE());
            IPSSysPanelItem iPSSysPanelItem = iPSPanelItemType.createPSSysPanelItem(psPanelItem);
            if (iPSSysPanelItem instanceof IPSPanelTabPage) {
                iPSSysPanelItem.init(this.getDAGlobalHelper(), this.getPSSysPanel(), this, psPanelItem);
                this.psPanelTabPageList.add((IPSPanelTabPage)((Object)iPSSysPanelItem));
                continue;
            }
            throw new Exception(String.format("\u6210\u5458[%1$s]\u7c7b\u578b[%2$s]\u4e0d\u6b63\u786e\uff0c\u65e0\u6cd5\u9644\u52a0\u81f3\u5206\u9875\u90e8\u4ef6", psPanelItem.getPSSYSVIEWPANELITEMNAME(), psPanelItem.getITEMTYPE()));
        }
    }

    @Override
    @PSModelRTMeta(description="\u5206\u9875\u9762\u677f\u96c6\u5408", child=true)
    public Iterator<IPSPanelTabPage> getPSPanelTabPages() {
        return this.psPanelTabPageList.iterator();
    }

    @Override
    public boolean isShowCaption() {
        return false;
    }

    @Override
    public void fillPSPanelItems(ArrayList<IPSPanelItem> psPanelItemList) {
        for (IPSPanelTabPage iPSPanelTabPage : this.psPanelTabPageList) {
            iPSPanelTabPage.fillPSPanelItems(psPanelItemList);
        }
        super.fillPSPanelItems(psPanelItemList);
    }

    @Override
    public void fillPSPanelFields(ArrayList<IPSPanelField> psSysViewPanelFieldList) {
        for (IPSPanelTabPage iPSPanelTabPage : this.psPanelTabPageList) {
            iPSPanelTabPage.fillPSPanelFields(psSysViewPanelFieldList);
        }
    }

    @Override
    public void fillPSControls(ArrayList<IPSControl> psControlList) {
        for (IPSPanelTabPage iPSPanelTabPage : this.psPanelTabPageList) {
            iPSPanelTabPage.fillPSControls(psControlList);
        }
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        for (IPSPanelItem iPSPanelItem : this.psPanelTabPageList) {
            iPSPanelItem.fillRelatedPSAppViews(relatedAppViewList);
        }
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        for (IPSPanelItem iPSPanelItem : this.psPanelTabPageList) {
            iPSPanelItem.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        }
    }

    @Override
    protected void onLayout() throws Exception {
        super.onLayout();
        for (IPSPanelItem iPSPanelItem : this.psPanelTabPageList) {
            iPSPanelItem.layout();
        }
    }

    @Override
    public String getModelType() {
        return "PSSYSVIEWPANELITEM_TABPANEL";
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u533a\u57df\u7c7b\u578b", hideempty=true, codelist="DataPanelMode", ignoredumpvalues="INHERIT", fields={"DATAPANELMODE"})
    public String getDataRegionType() {
        return this.strDataRegionType;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u6e90\u7c7b\u578b", hideempty=true, codelist="DataPanelSource", fields={"DATASOURCE"})
    public String getDataSourceType() {
        return this.strDataSourceType;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53", hideempty=true, dumpref=true, fields={"PSDEID"})
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5904\u7406\u903b\u8f91", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"PSDELOGICID"})
    public IPSAppDELogic getPSAppDELogic() {
        return this.iPSAppDELogic;
    }

    @Override
    public IPSAppDEAction getPSAppDEAction() {
        return this.iPSAppDEAction;
    }

    @Override
    public IPSAppDEDataSet getPSAppDEDataSet() {
        return this.iPSAppDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5237\u65b0\u6a21\u5f0f", ignoredumpvalues="-1", fields={"GETDATATIMER"})
    public int getReloadTimer() {
        return this.nReloadTimer;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5", dumpref=true, from="IPSAppDataEntity", fields={"PSDEACTIONID", "PSDEDATASETID"})
    public IPSAppDEMethod getPSAppDEMethod() {
        if (this.getPSAppDEAction() != null) {
            return this.getPSAppDEAction();
        }
        if (this.getPSAppDEDataSet() != null) {
            return this.getPSAppDEDataSet();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u53c2\u6570\u96c6\u5408", child=true, group="\u903b\u8f91", order=216)
    public Iterator<? extends IPSNavigateParam> getPSNavigateParams() throws Exception {
        if (this.psNavigateParamMap == null || this.psNavigateParamMap.size() == 0) {
            return null;
        }
        return this.psNavigateParamMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u4e0a\u4e0b\u6587\u96c6\u5408", child=true, group="\u903b\u8f91", order=215)
    public Iterator<? extends IPSNavigateContext> getPSNavigateContexts() throws Exception {
        if (this.psNavigateContextMap == null || this.psNavigateContextMap.size() == 0) {
            return null;
        }
        return this.psNavigateContextMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5bf9\u8c61\u540d\u79f0", hideempty2=true, fields={"FIELDNAME"})
    public String getDataName() {
        return this.strDataName;
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", hideempty2=true)
    public String getScriptCode() {
        return this.strScriptCode;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u5904\u7406\u63d0\u793a", ignoredumpvalues="false", fields={"BUSYINDICATOR"})
    public boolean isShowBusyIndicator() {
        return this.bShowBusyIndicator;
    }
}

