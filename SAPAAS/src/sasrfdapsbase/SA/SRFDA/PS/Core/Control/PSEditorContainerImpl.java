/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFFormItem;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.Control.IPSEditorContainer;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysEditorStyle;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Properties;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSEditorContainerImpl
extends PSObjectImpl
implements IPSEditorContainer {
    private static final Log log = LogFactory.getLog(PSEditorContainerImpl.class);
    private IPSControlContainer iPSControlContainer = null;
    private IPSDEFFormItem iPSDEFFormItem = null;
    private IPSApplication iPSApplication = null;
    private IPSCodeList iPSCodeList = null;
    private Properties editorParams = null;
    private boolean bEditable = true;
    private IPSEditorType iPSEditorType = null;
    protected boolean bAllowEmpty = true;
    private IPSSysEditorStyle iPSSysEditorStyle = null;
    protected double fEditorWidth = 0.0;
    protected double fEditorHeight = 0.0;
    private IPSEditor iPSEditor = null;
    private IPSModelObject iPSModelObject = null;
    private String strValueItemName = "";
    private ArrayList<String> valueItemNameList = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSModelObject iPSModelObject, IPSControlContainer iPSControlContainer, String strName, IPSDEFFormItem iPSDEFFormItem) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setName(strName);
        this.iPSModelObject = iPSModelObject;
        this.iPSControlContainer = iPSControlContainer;
        this.iPSDEFFormItem = iPSDEFFormItem;
        this.iPSApplication = iPSControlContainer.getPSAppView().getPSApplication();
        String strPSCodeListId = this.getPSDEFFormItem().getPSCodeListId();
        if (!StringHelper.IsNullOrEmpty((String)strPSCodeListId)) {
            this.iPSCodeList = this.getPSSystem().getPSCodeList(strPSCodeListId);
            this.iPSCodeList = this.getPSApplication().getPSCodeList(this.iPSCodeList, false);
        }
        if (StringHelper.IsNullOrEmpty((String)this.strValueItemName) && iPSDEFFormItem != null) {
            this.strValueItemName = iPSDEFFormItem.getValueItemName(null);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strValueItemName)) {
            String[] items;
            this.valueItemNameList = new ArrayList();
            String[] stringArray = items = StringHelper.SplitEx((String)this.strValueItemName);
            int n = items.length;
            int n2 = 0;
            while (n2 < n) {
                String strItem = stringArray[n2];
                if (!this.valueItemNameList.contains(strItem = strItem.trim())) {
                    this.valueItemNameList.add(strItem);
                }
                ++n2;
            }
            if (this.valueItemNameList.size() > 0) {
                this.strValueItemName = this.valueItemNameList.get(0);
            }
        }
        this.editorParams = PropertiesHelper.load((String)"");
        for (Object objKey : iPSDEFFormItem.getEditorParams().keySet()) {
            if (this.editorParams.containsKey(objKey)) continue;
            this.editorParams.put(objKey, iPSDEFFormItem.getEditorParams().get(objKey));
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getEditorStyle())) {
            this.iPSSysEditorStyle = this.getPSApplication().getPSSysEditorStyle(this.getEditorStyle(), "FORMITEM");
            for (Object objKey : this.getPSSysEditorStyle().getEditorParams().keySet()) {
                if (this.editorParams.containsKey(objKey)) continue;
                this.editorParams.put(objKey, this.getPSSysEditorStyle().getEditorParams().get(objKey));
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getEditorType())) {
            this.iPSEditorType = this.getPSModelStorage().getPSEditorType(this.getEditorType());
            this.bEditable = this.iPSEditorType.isEditable();
            if (!this.iPSEditorType.isEditable()) {
                this.bAllowEmpty = true;
            }
            for (Object objKey : this.iPSEditorType.getEditorParams().keySet()) {
                if (this.editorParams.containsKey(objKey)) continue;
                this.editorParams.put(objKey, this.iPSEditorType.getEditorParams().get(objKey));
            }
        }
        this.fEditorWidth = -1.0;
        this.fEditorHeight = -1.0;
        if (this.fEditorWidth < 0.0 && this.fEditorHeight < 0.0 && this.getPSSysEditorStyle() != null) {
            this.fEditorWidth = this.getPSSysEditorStyle().getEditorWidth();
            this.fEditorHeight = this.getPSSysEditorStyle().getEditorHeight();
        }
        if (this.fEditorWidth < 0.0 && this.fEditorHeight < 0.0) {
            boolean bCalc = false;
            if (this.getPSDEFFormItem() != null) {
                this.fEditorWidth = this.getPSDEFFormItem().getEditorWidth();
                this.fEditorHeight = this.getPSDEFFormItem().getEditorHeight();
                bCalc = true;
            }
        }
        if (this.fEditorWidth < 0.0) {
            this.fEditorWidth = 0.0;
        }
        if (this.fEditorHeight < 0.0) {
            this.fEditorHeight = 0.0;
        }
        this.onInit();
    }

    protected IPSModelObject getOwner() {
        return this.iPSModelObject;
    }

    protected IPSDEFFormItem getPSDEFFormItem() {
        return this.iPSDEFFormItem;
    }

    protected IPSApplication getPSApplication() {
        return this.iPSApplication;
    }

    protected IPSSystem getPSSystem() {
        return this.getPSApplication().getPSSystem();
    }

    @Override
    public String getEditorType() {
        return this.getPSDEFFormItem().getEditorType();
    }

    @Override
    public String getEditorStyle() {
        return this.getPSDEFFormItem().getEditorStyle();
    }

    @Override
    public double getEditorWidth() {
        return this.fEditorWidth;
    }

    @Override
    public double getEditorHeight() {
        return this.fEditorHeight;
    }

    @Override
    public String getEditorDynaClass() {
        return null;
    }

    @Override
    public Properties getEditorParams() {
        return this.editorParams;
    }

    @Override
    public int getEditorParam(String strEditorParam, int nDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strEditorParam, (int)nDefault);
    }

    @Override
    public String getEditorParam(String strEditorParam, String strDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strEditorParam, (String)strDefault);
    }

    @Override
    public double getEditorParam(String strEditorParam, double fDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strEditorParam, (double)fDefault);
    }

    @Override
    public boolean getEditorParam(String strEditorParam, boolean bDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strEditorParam, (boolean)bDefault);
    }

    @Override
    public IPSDataEntity getRefPSDataEntity() throws Exception {
        return this.getPSDEFFormItem().getRefPSDataEntity();
    }

    @Override
    public IPSAppView getRefLinkPSAppView() throws Exception {
        String strPSDEViewId = this.getPSDEFFormItem().getRefLinkPSDEViewId(this.getPSApplication());
        if (StringHelper.IsNullOrEmpty((String)strPSDEViewId)) {
            return null;
        }
        return this.getPSApplication().getPSAppViewByDEViewId(strPSDEViewId, false);
    }

    @Override
    public IPSAppView getRefPickupPSAppView() throws Exception {
        String strPSDEViewId = this.getPSDEFFormItem().getRefPickupPSDEViewId(this.getPSApplication());
        if (StringHelper.IsNullOrEmpty((String)strPSDEViewId)) {
            return null;
        }
        return this.getPSApplication().getPSAppViewByDEViewId(strPSDEViewId, false);
    }

    @Override
    public IPSDEDataSet getRefPSDEDataSet() throws Exception {
        return this.getPSDEFFormItem().getRefPSDEDataSet();
    }

    @Override
    public IPSDEACMode getRefPSDEACMode() throws Exception {
        return this.getPSDEFFormItem().getRefPSDEACMode();
    }

    @Override
    public String getItemHandlerType() {
        return null;
    }

    @Override
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    @Override
    public JSONObject getItemParam() throws Exception {
        return null;
    }

    @Override
    public String getEditorContainer() {
        return "FORMITEM";
    }

    @Override
    public IPSEditorType getPSEditorType() {
        return this.iPSEditorType;
    }

    @Override
    public IPSAjaxHandler getItemPSAjaxHandler() {
        return null;
    }

    @Override
    public String getValueItemName() {
        return this.strValueItemName;
    }

    @Override
    public String[] getValueItemNames() {
        if (this.valueItemNameList == null || this.valueItemNameList.size() == 0) {
            return null;
        }
        return this.valueItemNameList.toArray(new String[this.valueItemNameList.size()]);
    }

    @Override
    public IPSSysEditorStyle getPSSysEditorStyle() {
        return this.iPSSysEditorStyle;
    }

    @Override
    public IPSEditor getPSEditor() throws Exception {
        if (this.iPSEditor == null && this.getPSEditorType() != null) {
            this.iPSEditor = this.getPSEditorType().createPSEditor(this);
        }
        return this.iPSEditor;
    }

    @Override
    public String getEditorName() {
        return this.getName();
    }

    @Override
    public IPSControlContainer getPSControlContainer() {
        return this.iPSControlContainer;
    }

    @Override
    public String getPlaceHolder() {
        return this.getPSDEFFormItem().getPlaceHolder();
    }

    @Override
    public String getPSSysDictCatId() {
        return null;
    }

    @Override
    public IPSSysValueRule getPSSysValueRule() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.getPSDEFFormItem().getPSSysValueRuleId())) {
            return this.getPSApplication().getPSAppValueRule(this.getPSDEFFormItem().getPSSysValueRuleId());
        }
        return null;
    }

    @Override
    public String getPredefinedType() {
        return null;
    }

    @Override
    public String getRenderMode() {
        return null;
    }

    @Override
    public String getEditorCssStyle() {
        return null;
    }

    @Override
    public String getEditorCssStyle2() {
        return null;
    }

    @Override
    public IPSSysCss getEditorPSSysCss() {
        if (this.getPSSysEditorStyle() != null) {
            return this.getPSSysEditorStyle().getPSSysCss();
        }
        return null;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSApplication().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return StringHelper.Format((String)"PSEDITORCONTAINER$%1$s", (Object)this.getOwner().getModelType());
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getOwner().getModelId(), (Object)this.getName());
    }
}

