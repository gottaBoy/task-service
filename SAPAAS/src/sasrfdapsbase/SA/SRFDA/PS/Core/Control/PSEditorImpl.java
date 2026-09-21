/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.PSAppViewLogicImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewUIActionProxy;
import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItem;
import SA.SRFDA.PS.Core.Control.IPSControlAttribute;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.Control.IPSControlRender;
import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.Control.IPSEditorContainer;
import SA.SRFDA.PS.Core.Control.IPSEditorContainerEx;
import SA.SRFDA.PS.Core.Control.IPSEditorItem;
import SA.SRFDA.PS.Core.Control.IPSEditorParam;
import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.Control.IPSNavigateParamContainer;
import SA.SRFDA.PS.Core.Control.PSEditorItemImpl;
import SA.SRFDA.PS.Core.Control.PSNavigateContextImpl;
import SA.SRFDA.PS.Core.Control.PSNavigateParamImpl;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelField;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBarFilter;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSysSearchBar;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysDictCat;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Core.View.IPSUIActionGroupDetail;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSEditorImpl
extends PSObjectImpl
implements IPSEditor,
IPSNavigateParamContainer {
    private static final Log log = LogFactory.getLog(PSEditorImpl.class);
    private IPSEditorContainer iPSEditorContainer = null;
    private IPSEditorParam iPSEditorParam = null;
    private Map<String, IPSNavigateContext> psNavigateContextMap = null;
    private Map<String, IPSNavigateParam> psNavigateParamMap = null;
    private IPSSysDictCat iPSSysDictCat = null;
    private IPSPFXCodeObject iPSPFXCodeObject = null;
    private List<IPSEditorItem> psEditorItemList = null;
    private boolean bPreparePSEditorItems = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSEditorContainer iPSEditorContainer, String strName, IPSEditorParam iPSEditorParam) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSEditorContainer(iPSEditorContainer);
        if (StringHelper.isNullOrEmpty((String)strName)) {
            this.setName(iPSEditorContainer.getEditorName());
        } else {
            this.setName(strName);
        }
        this.iPSEditorParam = iPSEditorParam;
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        if (this.getPSSysPFPlugin() != null) {
            this.getPSEditorContainer().getPSControlContainer().getPSAppView().registerPSSysPFPlugin(this.getPSSysPFPlugin());
            String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPlugin().getId(), (String)this.getPSEditorContainer().getPSControlContainer().getPSAppView().getPSApplication().getPSPF().getId());
            IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSEditorContainer().getPSControlContainer().getPSAppView().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
            if (iPSSysPFPluginTempl != null) {
                this.iPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, (Object)this.getPSEditorContainer().getPSControlContainer().getPSAppView(), (Object)this.getPSEditorContainer().getPSControlContainer(), (Object)this);
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSEditorContainer().getPSSysDictCatId())) {
            this.iPSSysDictCat = this.getPSEditorContainer().getPSControlContainer().getPSAppView().getPSSystem().getPSSysDictCat(this.getPSEditorContainer().getPSSysDictCatId());
        }
        this.onPreparePSNavViewParams();
        super.onInit();
    }

    protected IPSEditorItem createPSEditorItem(IPSEditorContainer iPSEditorContainer) throws Exception {
        return new PSEditorItemImpl();
    }

    private synchronized void preparePSEditorItems() throws Exception {
        if (this.bPreparePSEditorItems) {
            return;
        }
        this.bPreparePSEditorItems = true;
        this.onPreparePSEditorItems();
    }

    protected void onPreparePSEditorItems() throws Exception {
        if (this.getPSEditorContainer() instanceof IPSEditorContainerEx) {
            IPSEditorContainerEx iPSEditorContainerEx = (IPSEditorContainerEx)((Object)this.getPSEditorContainer());
            Iterator<? extends IPSEditorContainer> psEditorContainers = iPSEditorContainerEx.getPSEditorContainers();
            if (psEditorContainers != null) {
                this.psEditorItemList = new ArrayList<IPSEditorItem>();
                while (psEditorContainers.hasNext()) {
                    IPSEditorContainer iPSEditorContainer = psEditorContainers.next();
                    IPSEditorItem iPSEditorItem = this.createPSEditorItem(iPSEditorContainer);
                    iPSEditorItem.init(this.getDAGlobalHelper(), this, iPSEditorContainer, null, this.isEditorItemSimpleMode());
                    this.psEditorItemList.add(iPSEditorItem);
                }
            }
            return;
        }
        String[] valueItemNames = this.getPSEditorContainer().getValueItemNames();
        if (valueItemNames == null || valueItemNames.length == 0) {
            return;
        }
        this.psEditorItemList = new ArrayList<IPSEditorItem>();
        if (this.getPSEditorContainer().getPSControlContainer() instanceof IPSDEForm) {
            IPSDEForm iPSDEForm = (IPSDEForm)this.getPSEditorContainer().getPSControlContainer();
            String[] stringArray = valueItemNames;
            int n = valueItemNames.length;
            int n2 = 0;
            while (n2 < n) {
                String strValueItemName = stringArray[n2];
                IPSDEFormItem iPSDEFormItem = iPSDEForm.getPSDEFormItem(strValueItemName, true);
                if (iPSDEFormItem instanceof IPSEditorContainer) {
                    IPSDEFormItem iPSEditorContainer = iPSDEFormItem;
                    IPSEditorItem iPSEditorItem = this.createPSEditorItem(iPSEditorContainer);
                    iPSEditorItem.init(this.getDAGlobalHelper(), this, iPSEditorContainer, null, this.isEditorItemSimpleMode());
                    this.psEditorItemList.add(iPSEditorItem);
                }
                ++n2;
            }
            return;
        }
        if (this.getPSEditorContainer().getPSControlContainer() instanceof IPSDEGrid) {
            IPSDEGrid iPSDEGrid = (IPSDEGrid)this.getPSEditorContainer().getPSControlContainer();
            String[] stringArray = valueItemNames;
            int n = valueItemNames.length;
            int n3 = 0;
            while (n3 < n) {
                String strValueItemName = stringArray[n3];
                IPSDEGridEditItem iPSDEGridEditItem = iPSDEGrid.getPSDEGridEditItem(strValueItemName, true);
                if (iPSDEGridEditItem instanceof IPSEditorContainer) {
                    IPSDEGridEditItem iPSEditorContainer = iPSDEGridEditItem;
                    IPSEditorItem iPSEditorItem = this.createPSEditorItem(iPSEditorContainer);
                    iPSEditorItem.init(this.getDAGlobalHelper(), this, iPSEditorContainer, null, this.isEditorItemSimpleMode());
                    this.psEditorItemList.add(iPSEditorItem);
                }
                ++n3;
            }
            return;
        }
        if (this.getPSEditorContainer().getPSControlContainer() instanceof IPSPanel) {
            IPSPanel iPSPanel = (IPSPanel)this.getPSEditorContainer().getPSControlContainer();
            String[] stringArray = valueItemNames;
            int n = valueItemNames.length;
            int n4 = 0;
            while (n4 < n) {
                String strValueItemName = stringArray[n4];
                IPSPanelField iPSPanelField = iPSPanel.getPSPanelField(strValueItemName, true);
                if (iPSPanelField instanceof IPSEditorContainer) {
                    IPSPanelField iPSEditorContainer = iPSPanelField;
                    IPSEditorItem iPSEditorItem = this.createPSEditorItem(iPSEditorContainer);
                    iPSEditorItem.init(this.getDAGlobalHelper(), this, iPSEditorContainer, null, this.isEditorItemSimpleMode());
                    this.psEditorItemList.add(iPSEditorItem);
                }
                ++n4;
            }
            return;
        }
        if (this.getPSEditorContainer().getPSControlContainer() instanceof IPSSysSearchBar) {
            IPSSysSearchBar iPSSysSearchBar = (IPSSysSearchBar)this.getPSEditorContainer().getPSControlContainer();
            String[] stringArray = valueItemNames;
            int n = valueItemNames.length;
            int n5 = 0;
            while (n5 < n) {
                String strValueItemName = stringArray[n5];
                IPSSearchBarFilter iPSSearchBarFilter = iPSSysSearchBar.getPSSearchBarFilter(strValueItemName, true);
                if (iPSSearchBarFilter instanceof IPSEditorContainer) {
                    IPSSearchBarFilter iPSEditorContainer = iPSSearchBarFilter;
                    IPSEditorItem iPSEditorItem = this.createPSEditorItem(iPSEditorContainer);
                    iPSEditorItem.init(this.getDAGlobalHelper(), this, iPSEditorContainer, null, this.isEditorItemSimpleMode());
                    this.psEditorItemList.add(iPSEditorItem);
                }
                ++n5;
            }
            return;
        }
    }

    protected boolean isEditorItemSimpleMode() {
        return false;
    }

    protected void onPreparePSNavViewParams() throws Exception {
        Enumeration<Object> names;
        JSONObject itemParamJO = this.getPSEditorContainer().getItemParam();
        if (itemParamJO != null) {
            String strContextJOString;
            String strTag;
            boolean bRawValue;
            String strValue;
            String strKey;
            JSONObject jo;
            Iterator keys;
            String strParamJOString = PSEditorImpl.calcParamJOString(itemParamJO);
            if (!StringHelper.isNullOrEmpty((String)strParamJOString) && (keys = (jo = JSONObjectHelper.fromString2((String)strParamJOString)).keys()) != null) {
                while (keys.hasNext()) {
                    strKey = (String)keys.next();
                    strValue = jo.optString(strKey, "");
                    bRawValue = true;
                    strTag = strKey.toLowerCase();
                    if (!StringHelper.isNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    PSNavigateParamImpl PSNavigateParamImpl2 = new PSNavigateParamImpl();
                    PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateParamMap == null) {
                        this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                    }
                    this.psNavigateParamMap.put(strTag, PSNavigateParamImpl2);
                }
            }
            if (!StringHelper.isNullOrEmpty((String)(strContextJOString = PSEditorImpl.calcContextJOString(itemParamJO))) && (keys = (jo = JSONObjectHelper.fromString2((String)strContextJOString)).keys()) != null) {
                while (keys.hasNext()) {
                    strKey = (String)keys.next();
                    strValue = jo.optString(strKey, "");
                    bRawValue = true;
                    strTag = strKey.toUpperCase();
                    if (!StringHelper.isNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    PSNavigateContextImpl PSNavigateContextImpl2 = new PSNavigateContextImpl();
                    PSNavigateContextImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateContextMap == null) {
                        this.psNavigateContextMap = new LinkedHashMap<String, IPSNavigateContext>();
                    }
                    this.psNavigateContextMap.put(strTag, PSNavigateContextImpl2);
                }
            }
        }
        if (this.getEditorParams() != null && (names = this.getEditorParams().keys()) != null) {
            while (names.hasMoreElements()) {
                String strKey = (String)names.nextElement();
                String strValue = PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strKey, (String)"");
                String strTag = strKey.toUpperCase();
                if (strTag.indexOf("SRFNAVCTX.") == 0) {
                    boolean bRawValue = true;
                    strTag = strKey.substring("SRFNAVCTX.".length()).toUpperCase();
                    if (!StringHelper.isNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    PSNavigateContextImpl PSNavigateContextImpl3 = new PSNavigateContextImpl();
                    PSNavigateContextImpl3.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateContextMap == null) {
                        this.psNavigateContextMap = new LinkedHashMap<String, IPSNavigateContext>();
                    }
                    this.psNavigateContextMap.put(strTag, PSNavigateContextImpl3);
                    continue;
                }
                if (strTag.indexOf("SRFNAVPARAM.") != 0) continue;
                boolean bRawValue = true;
                strTag = strKey.substring("SRFNAVPARAM.".length()).toLowerCase();
                if (!StringHelper.isNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                    strValue = strValue.replace("%", "");
                    bRawValue = false;
                }
                PSNavigateParamImpl PSNavigateParamImpl3 = new PSNavigateParamImpl();
                PSNavigateParamImpl3.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                if (this.psNavigateParamMap == null) {
                    this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                }
                this.psNavigateParamMap.put(strTag, PSNavigateParamImpl3);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u5bb9\u5668")
    public IPSEditorContainer getPSEditorContainer() {
        return this.iPSEditorContainer;
    }

    protected void setPSEditorContainer(IPSEditorContainer iPSEditorContainer) {
        this.iPSEditorContainer = iPSEditorContainer;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSEditorContainer().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u6837\u5f0f")
    public String getEditorStyle() {
        return this.getPSEditorContainer().getEditorStyle();
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u7c7b\u578b")
    public String getEditorType() {
        return this.getPSEditorContainer().getEditorType();
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u5bbd\u5ea6", ignoredumpvalues="0.0")
    public double getEditorWidth() {
        return this.getPSEditorContainer().getEditorWidth();
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u9ad8\u5ea6", ignoredumpvalues="0.0")
    public double getEditorHeight() {
        return this.getPSEditorContainer().getEditorHeight();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u7f16\u8f91", ignoredumpvalues="true")
    public boolean isEditable() {
        if (this.getPSEditorContainer().getPSEditorType() != null) {
            return this.getEditorParam("EDITABLE", this.getPSEditorContainer().getPSEditorType().isEditable());
        }
        return this.getEditorParam("EDITABLE", true);
    }

    @Override
    public String getEditorCssStyle() {
        return this.getPSEditorContainer().getEditorCssStyle();
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u53c2\u6570\u96c6\u5408")
    public Properties getEditorParams() {
        return this.getPSEditorContainer().getEditorParams();
    }

    @Override
    public Integer getEditorParam(String strEditorParam, Integer nDefault) {
        String strValue = this.getPSEditorContainer().getEditorParam(strEditorParam, null);
        if (StringHelper.isNullOrEmpty((String)strValue)) {
            return nDefault;
        }
        try {
            return Integer.parseInt(strValue);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return nDefault;
        }
    }

    @Override
    public String getEditorParam(String strEditorParam) {
        String strValue = this.getPSEditorContainer().getEditorParam(strEditorParam, null);
        if (StringHelper.isNullOrEmpty((String)strValue)) {
            return null;
        }
        return strValue;
    }

    @Override
    public String getEditorParam(String strEditorParam, String strDefault) {
        return this.getPSEditorContainer().getEditorParam(strEditorParam, strDefault);
    }

    @Override
    public Double getEditorParam(String strEditorParam, Double fDefault) {
        String strValue = this.getPSEditorContainer().getEditorParam(strEditorParam, null);
        if (StringHelper.isNullOrEmpty((String)strValue)) {
            return fDefault;
        }
        try {
            return Double.parseDouble(strValue);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return fDefault;
        }
    }

    @Override
    public Boolean getEditorParam(String strEditorParam, Boolean bDefault) {
        String strValue = this.getPSEditorContainer().getEditorParam(strEditorParam, null);
        if (StringHelper.isNullOrEmpty((String)strValue)) {
            return bDefault;
        }
        try {
            return Boolean.parseBoolean(strValue);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return bDefault;
        }
    }

    @Override
    public String getModelType() {
        return "PSEDITOR$" + this.getPSEditorContainer().getModelType();
    }

    @Override
    public String getModelId() {
        return this.getPSEditorContainer().getModelId();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysPFPlugin getPSSysPFPlugin() {
        if (this.getPSEditorContainer().getPSSysEditorStyle() != null) {
            return this.getPSEditorContainer().getPSSysEditorStyle().getPSSysPFPlugin();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u8f93\u5165\u63d0\u793a", hideempty=true)
    public String getPlaceHolder() {
        return this.getPSEditorContainer().getPlaceHolder();
    }

    public static String calcParamJOString(JSONObject itemParamJO) throws Exception {
        if (itemParamJO != null) {
            JSONObject paramJO = itemParamJO.optJSONObject("param");
            if (paramJO != null) {
                return paramJO.toString();
            }
            JSONObject fetchCondJO = itemParamJO.optJSONObject("fetchcond");
            if (fetchCondJO == null) {
                return "";
            }
            paramJO = new JSONObject();
            Iterator it = fetchCondJO.keys();
            while (it.hasNext()) {
                String strKey = (String)it.next();
                String strValue = fetchCondJO.optString(strKey);
                if (StringHelper.isNullOrEmpty((String)strValue)) continue;
                JSONObjectHelper.put((JSONObject)paramJO, (String)strKey, (Object)("%" + strValue + "%"));
            }
            return paramJO.toString();
        }
        return "";
    }

    public static String calcContextJOString(JSONObject itemParamJO) throws Exception {
        if (itemParamJO != null) {
            JSONObject contextJO = itemParamJO.optJSONObject("context");
            if (contextJO != null) {
                return contextJO.toString();
            }
            JSONObject parentDataJO = itemParamJO.optJSONObject("parentdata");
            if (parentDataJO == null) {
                return "";
            }
            String strParentDEName = parentDataJO.optString("srfparentdename");
            if (StringHelper.isNullOrEmpty((String)strParentDEName)) {
                return "";
            }
            String strParentKey = parentDataJO.optString("srfparentkey");
            if (StringHelper.isNullOrEmpty((String)strParentKey)) {
                return "";
            }
            contextJO = new JSONObject();
            JSONObjectHelper.put((JSONObject)contextJO, (String)strParentDEName, (Object)strParentKey);
            return contextJO.toString();
        }
        return "";
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

    protected void registerPSUIActionGroup(String strLogicTagFormat, IPSUIActionGroup iPSUIActionGroup) throws Exception {
        Iterator<IPSUIActionGroupDetail> psUIActionGroupDetails = iPSUIActionGroup.getPSUIActionGroupDetails();
        if (psUIActionGroupDetails != null) {
            while (psUIActionGroupDetails.hasNext()) {
                IPSUIActionGroupDetail iPSUIActionGroupDetail = psUIActionGroupDetails.next();
                IPSUIAction iPSUIAction = iPSUIActionGroupDetail.getPSUIAction();
                if (iPSUIAction == null) continue;
                if (this.getPSEditorContainer().getPSControlContainer().isPrepareTemplV2logic()) {
                    PSAppViewUIActionProxy iPSAppViewUIAction = new PSAppViewUIActionProxy(this, iPSUIAction, null);
                    this.getPSEditorContainer().getPSControlContainer().registerPSAppViewUIAction(iPSAppViewUIAction);
                    this.registerPSAppViewLogic(strLogicTagFormat, iPSAppViewUIAction, iPSUIActionGroupDetail);
                    continue;
                }
                this.getPSEditorContainer().getPSControlContainer().getPSAppView().registerPSUIAction(iPSUIAction);
            }
        }
    }

    protected void registerPSAppViewLogic(String strLogicTagFormat, IPSAppViewUIAction iPSAppViewUIAction, IPSUIActionGroupDetail iPSUIActionGroupDetail) throws Exception {
        String strLogicTag = "";
        strLogicTag = StringHelper.isNullOrEmpty((String)strLogicTagFormat) ? StringHelper.format((String)"%1$s_editor_%2$s_click", (Object)this.getName(), (Object)iPSUIActionGroupDetail.getName()).toLowerCase() : StringHelper.format((String)strLogicTagFormat, (Object)this.getName(), (Object)iPSUIActionGroupDetail.getName()).toLowerCase();
        PSAppViewLogic psAppViewLogic = new PSAppViewLogic();
        psAppViewLogic.setPSAPPVIEWLOGICID(strLogicTag);
        psAppViewLogic.setPSAPPVIEWLOGICNAME(strLogicTag);
        psAppViewLogic.setDSTLOGICTYPE("APPVIEWUIACTION");
        psAppViewLogic.setPSAPPVIEWLOGICTYPE("CUSTOM");
        PSAppViewLogicImpl psAppDEViewLogicImpl = new PSAppViewLogicImpl();
        psAppDEViewLogicImpl.init(this.getDAGlobalHelper(), (Object)this, psAppViewLogic, iPSAppViewUIAction);
        this.getPSEditorContainer().getPSControlContainer().registerPSAppViewLogic(psAppDEViewLogicImpl);
    }

    @Override
    @PSModelRTMeta(description="\u8f85\u52a9\u8f93\u5165\u8bcd\u6761\u5206\u7c7b", child=true)
    public IPSSysDictCat getPSSysDictCat() {
        return this.iPSSysDictCat;
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u63d2\u4ef6")
    public IPSPFXCodeObject getRender() {
        return this.iPSPFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u6837\u5f0f\u8868")
    public IPSSysCss getPSSysCss() {
        if (this.getPSEditorContainer().getEditorPSSysCss() != null) {
            return this.getPSEditorContainer().getEditorPSSysCss();
        }
        if (this.getPSEditorContainer().getPSSysEditorStyle() != null) {
            return this.getPSEditorContainer().getPSSysEditorStyle().getPSSysCss();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u53ea\u8bfb\u72b6\u6001[READONLY]", ignoredumpvalues="false")
    public boolean isReadOnly() {
        Boolean bRet = this.getEditorParam("READONLY", this.getDefaultReadOnly());
        if (bRet == null) {
            return false;
        }
        return bRet;
    }

    protected Boolean getDefaultReadOnly() {
        String strValue = this.getEditorParam("DEFAULTREADONLY", "");
        if (StringHelper.isNullOrEmpty((String)strValue)) {
            return false;
        }
        try {
            return strValue.equalsIgnoreCase("TRUE");
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    @PSModelRTMeta(description="\u7981\u7528\u72b6\u6001[DISABLED]", ignoredumpvalues="false")
    public boolean isDisabled() {
        Boolean bRet = this.getEditorParam("DISABLED", this.getDefaultDisabled());
        if (bRet == null) {
            return false;
        }
        return bRet;
    }

    protected Boolean getDefaultDisabled() {
        String strValue = this.getEditorParam("DEFAULTDISABLED", "");
        if (StringHelper.isNullOrEmpty((String)strValue)) {
            return false;
        }
        try {
            return strValue.equalsIgnoreCase("TRUE");
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u7c7b\u578b")
    public String getPredefinedType() {
        return this.getPSEditorContainer().getPredefinedType();
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5Css\u6837\u5f0f")
    public String getCssStyle() {
        return this.getPSEditorContainer().getEditorCssStyle2();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6837\u5f0f\u8868")
    public String getDynaClass() {
        return this.getPSEditorContainer().getEditorDynaClass();
    }

    @Override
    @PSModelRTMeta(description="\u590d\u5408\u7f16\u8f91\u5668\u9879\u96c6\u5408", child=true)
    public Iterator<? extends IPSEditorItem> getPSEditorItems() throws Exception {
        this.preparePSEditorItems();
        if (this.psEditorItemList == null || this.psEditorItemList.size() == 0) {
            return null;
        }
        return this.psEditorItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u7c7b\u578b[VALUETYPE]{SIMPLE|SIMPLES|OBJECT|OBJECTS}", codelist="EditorValueType", ignoredumpvalues="SIMPLE")
    public String getValueType() {
        return this.getEditorParam("VALUETYPE", this.getDefaultValueType());
    }

    protected String getDefaultValueType() {
        String strValue = this.getEditorParam("DEFAULTVALUETYPE", "");
        if (StringHelper.isNullOrEmpty((String)strValue)) {
            return null;
        }
        return strValue;
    }

    @Override
    @PSModelRTMeta(description="\u5bf9\u8c61\u6807\u8bc6\u5c5e\u6027[OBJECTIDFIELD]")
    public String getObjectIdField() {
        return this.getEditorParam("OBJECTIDFIELD", this.getDefaultObjectIdField());
    }

    protected String getDefaultObjectIdField() {
        String strValueType = this.getValueType();
        if (!"OBJECT".equalsIgnoreCase(strValueType) && !"OBJECTS".equalsIgnoreCase(strValueType)) {
            return null;
        }
        String strValue = this.getEditorParam("DEFAULTOBJECTIDFIELD", "");
        if (StringHelper.isNullOrEmpty((String)strValue)) {
            return null;
        }
        return strValue;
    }

    @Override
    @PSModelRTMeta(description="\u5bf9\u8c61\u540d\u79f0\u5c5e\u6027[OBJECTNAMEFIELD]")
    public String getObjectNameField() {
        return this.getEditorParam("OBJECTNAMEFIELD", this.getDefaultObjectNameField());
    }

    protected String getDefaultObjectNameField() {
        String strValueType = this.getValueType();
        if (!"OBJECT".equalsIgnoreCase(strValueType) && !"OBJECTS".equalsIgnoreCase(strValueType)) {
            return null;
        }
        String strValue = this.getEditorParam("DEFAULTOBJECTNAMEFIELD", "");
        if (StringHelper.isNullOrEmpty((String)strValue)) {
            return null;
        }
        return strValue;
    }

    @Override
    @PSModelRTMeta(description="\u5bf9\u8c61\u503c\u5c5e\u6027[OBJECTVALUEFIELD]")
    public String getObjectValueField() {
        return this.getEditorParam("OBJECTVALUEFIELD", this.getDefaultObjectValueField());
    }

    protected String getDefaultObjectValueField() {
        String strValueType = this.getValueType();
        if (!"OBJECT".equalsIgnoreCase(strValueType) && !"OBJECTS".equalsIgnoreCase(strValueType)) {
            return null;
        }
        String strValue = this.getEditorParam("DEFAULTOBJECTVALUEFIELD", "");
        if (StringHelper.isNullOrEmpty((String)strValue)) {
            return null;
        }
        return strValue;
    }

    @Override
    @PSModelRTMeta(description="\u591a\u9879\u503c\u5206\u9694\u7b26[VALUESEPARATOR]")
    public String getValueSeparator() {
        return this.getEditorParam("VALUESEPARATOR", this.getDefaultValueSeparator());
    }

    protected String getDefaultValueSeparator() {
        String strValueType = this.getValueType();
        if (!"SIMPLE".equalsIgnoreCase(strValueType) && !StringHelper.isNullOrEmpty((String)strValueType)) {
            return null;
        }
        String strValue = this.getEditorParam("DEFAULTVALUESEPARATOR", "");
        if (StringHelper.isNullOrEmpty((String)strValue)) {
            return null;
        }
        return strValue;
    }

    @Override
    @PSModelRTMeta(description="\u591a\u9879\u6587\u672c\u5206\u9694\u7b26[TEXTSEPARATOR]")
    public String getTextSeparator() {
        return this.getEditorParam("TEXTSEPARATOR", this.getDefaultTextSeparator());
    }

    protected String getDefaultTextSeparator() {
        String strValue = this.getEditorParam("DEFAULTTEXTSEPARATOR", "");
        if (StringHelper.isNullOrEmpty((String)strValue)) {
            return null;
        }
        return strValue;
    }

    public boolean isEnableUIModelEx() {
        return this.getPSEditorContainer().getPSControlContainer().getPSAppView().isEnableUIModelEx();
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
}

