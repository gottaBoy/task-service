/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  net.ibizsys.paas.data.IDataItem
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTO;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTOField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodReturn;
import SA.SRFDA.PS.Core.App.ValueRule.IPSAppValueRule;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.PSAppViewLogicImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewUIActionProxy;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEFGridColumn;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeDataItem;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeEditItem;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeEditItemUpdate;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeFieldColumn;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeNodeColumnImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEFUIMode;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupObjectDEField;
import SA.SRFDA.PS.Core.Data.PSDataItemImpl;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERCustom;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERNN;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTOField;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysEditorStyle;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroupDetail;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDETreeNodeFieldColumnImpl
extends PSDETreeNodeColumnImpl
implements IPSDETreeNodeFieldColumn,
IPSDETreeNodeEditItem {
    private static final Log log = LogFactory.getLog(PSDETreeNodeFieldColumnImpl.class);
    protected IPSDEFGridColumn iPSDEFGridColumn = null;
    protected IPSDEField iPSDEField = null;
    private IPSAppDEField iPSAppDEField = null;
    protected String strPSCodeListId = "";
    protected IPSCodeList iPSCodeList = null;
    private String strValueFormat = "";
    private String[] fields = null;
    protected String strEditorType = "";
    protected String strEditorStyle = "";
    private boolean bEditable = false;
    private boolean bRowEditable = false;
    private Properties editorParams = null;
    private boolean bDefineEditorType = false;
    protected boolean bHidden = false;
    private IPSEditorType iPSEditorType = null;
    protected boolean bAllowEmpty = true;
    private String strValueProcessor = "";
    private String strResetItemName = null;
    private String strPlaceHolder = null;
    private IPSSysEditorStyle iPSSysEditorStyle = null;
    private String strPSSysValueRuleId = null;
    private int nIgnoreInput = 0;
    private int nEnableCond = 3;
    private String strCreateDVT = "";
    private String strCreateDV = "";
    private String strUpdateDVT = "";
    private String strUpdateDV = "";
    private String strEditorCssStyle = "";
    private ArrayList<String> resetItemNameList = null;
    private ArrayList<String> valueItemNameList = null;
    private boolean bNeedCodeListConfig = false;
    private int nOutputCodeListConfigMode = 0;
    private String strValueItemName = "";
    private boolean bEnableItemPriv = false;
    private String strItemPrivId = null;
    protected PSDataItemImpl psDataItemImpl = new PSDataItemImpl();
    protected ArrayList<IPSDETreeNodeDataItem> psDETreeNodeDataItemList = null;
    private String strDataItemName = null;
    private String strItemHandlerType = null;
    private IPSDEUIAction iPSDEUIAction = null;
    private String strCLConvertMode = null;
    private IPSEditor iPSEditor = null;
    private int nEnableLink = 2;
    private IPSAppView linkPSAppView = null;
    private boolean bEnableLinkView = false;
    private String strPSSysDictCatId = "";
    private String strUnitName = null;
    private int nUnitNameWidth = 0;
    private boolean bEnableUnitName = false;
    private IPSDEUIActionGroup iPSDEUIActionGroup = null;

    /*
     * WARNING - void declaration
     */
    @Override
    protected void onInit() throws Exception {
        IPSAppView linkPSAppView;
        if (StringHelper.IsNullOrEmpty((String)this.psDETreeNodeColumn.getPSDEFID())) {
            throw new Exception(StringHelper.Format((String)"\u6811\u8868\u683c\u5c5e\u6027\u5217[%1$s]\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027", (Object)this.getName()));
        }
        boolean bUseDTO = false;
        if (this.getPSDETree().getPSAppView() != null && this.getPSDETree().getPSAppView().getPSApplication() != null) {
            bUseDTO = this.getPSDETree().getPSAppView().getPSApplication().isUseServiceApi();
        }
        if (!bUseDTO) {
            if (this.getPSSystemSetting() != null) {
                this.psDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
            }
        } else {
            this.psDataItemImpl.setFormat("");
        }
        if (this.getPSDETreeNode().getPSDataEntity() == null) {
            throw new Exception("\u6811\u8282\u70b9\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5bf9\u8c61");
        }
        this.iPSDEField = this.getPSDETreeNode().getPSDataEntity().getPSDEField(this.psDETreeNodeColumn.getPSDEFID(), false);
        if (this.iPSDEField != null && this.getPSDETreeNode().getPSAppDataEntity() != null) {
            this.iPSAppDEField = this.getPSDETreeNode().getPSAppDataEntity().getPSAppDEField(this.iPSDEField.getId(), true);
        }
        IPSDEFUIMode iPSDEFUIMode = null;
        if (StringHelper.IsNullOrEmpty((String)this.psDETreeNodeColumn.getPSDEFUIMODEID())) {
            String strDEFUIMode = StringHelper.Format((String)"APPDEFAULT:%1$s", (Object)this.getPSDETree().getPSAppView().getPSApplication().getId());
            iPSDEFUIMode = this.getPSDEField().getPSDEFUIMode(strDEFUIMode, true);
            if (iPSDEFUIMode == null) {
                iPSDEFUIMode = this.iPSDEField.getPSDEFUIMode("DEFAULT");
            }
        } else {
            iPSDEFUIMode = this.iPSDEField.getPSDEFUIMode(this.psDETreeNodeColumn.getPSDEFUIMODEID());
        }
        this.iPSDEFGridColumn = iPSDEFUIMode.getPSDEFGridColumn();
        if (!this.psDETreeNodeColumn.isENABLELINKNull()) {
            this.nEnableLink = this.psDETreeNodeColumn.getENABLELINK();
        } else if (this.getPSDETreeColumn() != null) {
            this.nEnableLink = this.getPSDETreeColumn().getEnableLink();
        }
        this.strPSCodeListId = this.psDETreeNodeColumn.getPSCODELISTID();
        this.strCLConvertMode = this.psDETreeNodeColumn.getCLCONVERTMODE();
        if (this.iPSDEFGridColumn != null) {
            if (StringHelper.IsNullOrEmpty((String)this.strPSCodeListId)) {
                this.strPSCodeListId = this.iPSDEFGridColumn.getPSCodeListId();
            }
            if (StringHelper.IsNullOrEmpty((String)this.strCLConvertMode)) {
                this.strCLConvertMode = this.iPSDEFGridColumn.getCLConvertMode();
            }
            if (this.getRenderPSSysPFPlugin() == null) {
                this.setRenderPSSysPFPlugin(this.iPSDEFGridColumn.getRenderPSSysPFPlugin());
            }
        }
        if (StringHelper.Compare((String)this.getCLConvertMode(), (String)"NONE", (boolean)true) == 0) {
            this.strPSCodeListId = "";
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getPSCodeListId())) {
            this.iPSCodeList = this.getPSDETreeNode().getPSDataEntity().getPSSystem().getPSCodeList(this.getPSCodeListId());
            if (this.iPSCodeList != null) {
                this.iPSCodeList = this.getPSDETree().getPSAppView().getPSApplication().getPSCodeList(this.iPSCodeList, true);
            }
            if (StringHelper.IsNullOrEmpty((String)this.getCLConvertMode())) {
                this.strCLConvertMode = this.getPSDETree().getPSAppView().getPSApplication().isUseServiceApi() ? "FRONT" : (this.iPSCodeList.isEnableDynaSys() || StringHelper.Compare((String)this.iPSCodeList.getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0 ? "BACKEND" : "FRONT");
            }
        }
        if (this.iPSCodeList == null) {
            this.strCLConvertMode = "NONE";
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDETreeNodeColumn.getVALUEFORMAT())) {
            this.strValueFormat = this.psDETreeNodeColumn.getVALUEFORMAT();
        }
        if (StringHelper.IsNullOrEmpty((String)this.strValueFormat) && this.iPSDEFGridColumn != null) {
            this.strValueFormat = !bUseDTO ? this.iPSDEFGridColumn.getValueFormat() : this.iPSDEFGridColumn.getOriginValueFormat();
        }
        if (StringHelper.IsNullOrEmpty((String)this.strValueFormat) && bUseDTO && this.iPSAppDEField != null) {
            this.strValueFormat = this.iPSAppDEField.getValueFormat();
        }
        this.editorParams = PropertiesHelper.load((String)this.psDETreeNodeColumn.getEDITORPARAMS());
        if (!this.psDETreeNodeColumn.isENABLEROWEDITNull() && (this.psDETreeNodeColumn.getENABLEROWEDIT() & 1) == 1) {
            void var5_18;
            String string;
            int n;
            this.bRowEditable = true;
            this.strEditorType = this.psDETreeNodeColumn.getEDITORTYPE();
            this.strEditorStyle = this.psDETreeNodeColumn.getPSSYSEDITORSTYLEID();
            if (!StringHelper.IsNullOrEmpty((String)this.strEditorType)) {
                this.bDefineEditorType = true;
            }
            String strItemPSACHandlerId = null;
            if (this.getPSDEFGridColumn() != null) {
                strItemPSACHandlerId = this.getPSDEFGridColumn().getPSAjaxHandlerId();
                boolean bAppendParam = false;
                if (StringHelper.IsNullOrEmpty((String)this.strEditorType)) {
                    this.strEditorType = this.iPSDEFGridColumn.getEditorType();
                    bAppendParam = true;
                } else if (StringHelper.Compare((String)this.strEditorType, (String)this.iPSDEFGridColumn.getEditorType(), (boolean)true) == 0) {
                    bAppendParam = true;
                }
                if (bAppendParam) {
                    for (Object object : this.iPSDEFGridColumn.getEditorParams().keySet()) {
                        if (this.editorParams.containsKey(object)) continue;
                        this.editorParams.put(object, this.iPSDEFGridColumn.getEditorParams().get(object));
                    }
                }
                if (StringHelper.IsNullOrEmpty((String)this.strEditorStyle)) {
                    this.strEditorStyle = this.iPSDEFGridColumn.getEditorStyle();
                }
            }
            if (this.isDesignMode() && StringHelper.Compare((String)this.getEditorType(), (String)"USERCONTROL", (boolean)true) == 0) {
                this.strEditorType = "SPAN";
                this.bDefineEditorType = true;
                this.strEditorStyle = "";
            }
            if (StringHelper.IsNullOrEmpty((String)this.strEditorType)) {
                this.strEditorType = "TEXTBOX";
                if (this.getPSDETree().getPSAppView() != null && this.getPSDETree().getPSAppView().getPSApplication() != null && this.getPSDETree().getPSAppView().getPSApplication().isMobileApp()) {
                    this.strEditorType = "MOBTEXT";
                }
            }
            boolean bl = this.bHidden = StringHelper.Compare((String)this.strEditorType, (String)"HIDDEN", (boolean)true) == 0;
            if (!StringHelper.IsNullOrEmpty((String)this.getEditorType())) {
                this.iPSEditorType = this.getPSModelStorage().getPSEditorType(this.getEditorType());
                this.bEditable = this.iPSEditorType.isEditable();
                if (!this.iPSEditorType.isEditable()) {
                    this.bAllowEmpty = true;
                }
                this.strValueProcessor = this.iPSEditorType.getValueProcessor();
                if (!StringHelper.IsNullOrEmpty((String)this.strEditorStyle)) {
                    this.iPSSysEditorStyle = this.getPSDETree().getPSAppView().getPSApplication().getPSSysEditorStyle(this.strEditorStyle, "GRIDCOLUMN");
                } else if (!this.isDesignMode()) {
                    this.iPSSysEditorStyle = this.getPSDETree().getPSAppView().getPSApplication().getDefaultPSSysEditorStyle(this.getEditorType(), "GRIDCOLUMN");
                }
                if (this.getPSSysEditorStyle() != null) {
                    this.strItemHandlerType = this.getPSSysEditorStyle().getAjaxHandlerType();
                    if (StringHelper.IsNullOrEmpty((String)strItemPSACHandlerId)) {
                        strItemPSACHandlerId = this.getPSSysEditorStyle().getPSAjaxHandlerId();
                    }
                    for (Object objKey : this.getPSSysEditorStyle().getEditorParams().keySet()) {
                        if (this.editorParams.containsKey(objKey)) continue;
                        this.editorParams.put(objKey, this.getPSSysEditorStyle().getEditorParams().get(objKey));
                    }
                }
                if (StringHelper.IsNullOrEmpty((String)this.strItemHandlerType)) {
                    this.strItemHandlerType = this.getPSEditorType().getAjaxHandlerType();
                }
                for (Object objKey : this.iPSEditorType.getEditorParams().keySet()) {
                    if (this.editorParams.containsKey(objKey)) continue;
                    this.editorParams.put(objKey, this.iPSEditorType.getEditorParams().get(objKey));
                }
            }
            if (!this.psDETreeNodeColumn.isENABLECONDNull()) {
                this.nEnableCond = this.psDETreeNodeColumn.getENABLECOND();
            } else if (this.iPSDEFGridColumn != null) {
                this.nEnableCond = this.iPSDEFGridColumn.getEnableCond();
            }
            this.strPSCodeListId = this.psDETreeNodeColumn.getPSCODELISTID();
            if (StringHelper.IsNullOrEmpty((String)this.strPSCodeListId) && this.iPSDEFGridColumn != null) {
                this.strPSCodeListId = this.iPSDEFGridColumn.getPSCodeListId();
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psDETreeNodeColumn.getPLACEHOLDER())) {
                this.strPlaceHolder = this.psDETreeNodeColumn.getPLACEHOLDER();
            } else if (this.getPSDEFGridColumn() != null) {
                this.strPlaceHolder = this.getPSDEFGridColumn().getPlaceHolder();
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psDETreeNodeColumn.getPSSYSDICTCATID())) {
                this.strPSSysDictCatId = this.psDETreeNodeColumn.getPSSYSDICTCATID();
            } else if (this.getPSDEFGridColumn() != null) {
                this.strPSSysDictCatId = this.getPSDEFGridColumn().getPSSysDictCatId();
            }
            if (this.iPSDEFGridColumn != null) {
                this.strPSSysValueRuleId = this.iPSDEFGridColumn.getPSSysValueRuleId();
            }
            if (this.iPSDEFGridColumn != null) {
                this.iPSDEFGridColumn.getPSGEIDEFValueRules();
            }
            if (!StringHelper.IsNullOrEmpty((String)this.getPSCodeListId())) {
                this.iPSCodeList = this.getPSDETreeNode().getPSDataEntity().getPSSystem().getPSCodeList(this.getPSCodeListId());
                if (this.iPSCodeList != null) {
                    this.iPSCodeList = this.getPSDETree().getPSAppView().getPSApplication().getPSCodeList(this.iPSCodeList, true);
                }
            }
            this.strCreateDVT = this.psDETreeNodeColumn.getCREATEDVT();
            this.strCreateDV = this.psDETreeNodeColumn.getCREATEDV();
            this.strUpdateDVT = this.psDETreeNodeColumn.getUPDATEDVT();
            this.strUpdateDV = this.psDETreeNodeColumn.getUPDATEDV();
            if (this.iPSDEFGridColumn != null) {
                if (StringHelper.IsNullOrEmpty((String)this.strCreateDVT)) {
                    this.strCreateDVT = this.iPSDEFGridColumn.getCreateDVT();
                }
                if (StringHelper.IsNullOrEmpty((String)this.strCreateDV)) {
                    this.strCreateDV = this.iPSDEFGridColumn.getCreateDV();
                }
                if (StringHelper.IsNullOrEmpty((String)this.strUpdateDVT)) {
                    this.strUpdateDVT = this.iPSDEFGridColumn.getUpdateDVT();
                }
                if (StringHelper.IsNullOrEmpty((String)this.strUpdateDV)) {
                    this.strUpdateDV = this.iPSDEFGridColumn.getUpdateDV();
                }
            }
            if (!this.psDETreeNodeColumn.isIGNOREINPUTNull()) {
                this.nIgnoreInput = this.psDETreeNodeColumn.getIGNOREINPUT();
            } else if (this.iPSDEFGridColumn != null) {
                this.nIgnoreInput = this.iPSDEFGridColumn.getIgnoreInput();
            }
            if (this.isConvertToCodeItemText()) {
                this.nIgnoreInput = 3;
            }
            if (!this.isDesignMode()) {
                if (!this.psDETreeNodeColumn.isNEEDCODELISTCONFIGNull()) {
                    this.bNeedCodeListConfig = this.psDETreeNodeColumn.getNEEDCODELISTCONFIG();
                } else {
                    this.bNeedCodeListConfig = this.getPSEditorType().isNeedCodeListConfig();
                    if (this.getPSDEFGridColumn() != null && StringHelper.Compare((String)this.strEditorType, (String)this.getPSDEFGridColumn().getEditorType(), (boolean)true) == 0) {
                        this.bNeedCodeListConfig = this.getPSDEFGridColumn().isNeedCodeListConfig();
                    }
                }
                if (!this.psDETreeNodeColumn.isCODELISTCONFIGMODENull()) {
                    this.nOutputCodeListConfigMode = this.psDETreeNodeColumn.getCODELISTCONFIGMODE();
                } else {
                    this.nOutputCodeListConfigMode = this.getPSEditorType().getOutputCodeListConfigMode();
                    if (this.getPSDEFGridColumn() != null && StringHelper.Compare((String)this.strEditorType, (String)this.getPSDEFGridColumn().getEditorType(), (boolean)true) == 0) {
                        this.nOutputCodeListConfigMode = this.getPSDEFGridColumn().getOutputCodeListConfigMode();
                    }
                }
            }
            this.strEditorCssStyle = this.calcEditorCssStyle();
            String strValueItemName = this.psDETreeNodeColumn.getVALUEITEMNAME();
            if (StringHelper.IsNullOrEmpty((String)strValueItemName) && this.iPSDEFGridColumn != null) {
                strValueItemName = this.iPSDEFGridColumn.getValueItemName(this);
            }
            if (!StringHelper.IsNullOrEmpty((String)strValueItemName)) {
                String[] stringArray;
                this.valueItemNameList = new ArrayList();
                String[] stringArray2 = stringArray = StringHelper.SplitEx((String)strValueItemName);
                n = stringArray.length;
                int n2 = 0;
                while (n2 < n) {
                    String strItem = stringArray2[n2];
                    if (!this.valueItemNameList.contains(strItem = strItem.trim())) {
                        this.valueItemNameList.add(strItem);
                    }
                    ++n2;
                }
                if (this.valueItemNameList.size() > 0) {
                    this.strValueItemName = this.valueItemNameList.get(0);
                }
            }
            if (StringHelper.IsNullOrEmpty((String)(string = this.psDETreeNodeColumn.getRESETITEMNAME())) && this.getPSDEField() != null && this.getPSDEField().getRestrictedPSDEField() != null) {
                String string2 = this.getPSDEField().getRestrictedPSDEField().getName().toLowerCase();
            }
            if (!StringHelper.IsNullOrEmpty((String)var5_18)) {
                String[] items;
                this.resetItemNameList = new ArrayList();
                String[] stringArray = items = StringHelper.SplitEx((String)var5_18);
                int n3 = items.length;
                n = 0;
                while (n < n3) {
                    String strItem = stringArray[n];
                    if (!this.resetItemNameList.contains(strItem = strItem.trim())) {
                        this.resetItemNameList.add(strItem);
                    }
                    ++n;
                }
                if (this.resetItemNameList.size() > 0) {
                    this.strResetItemName = this.resetItemNameList.get(0);
                }
            }
            if (!this.psDETreeNodeColumn.isALLOWEMPTYNull()) {
                this.bAllowEmpty = this.psDETreeNodeColumn.getALLOWEMPTY();
            } else if (!this.bHidden && this.iPSDEFGridColumn != null && this.bAllowEmpty) {
                this.bAllowEmpty = this.iPSDEFGridColumn.getAllowEmpty(this);
            }
            if (!this.bAllowEmpty && this.iPSDEFGridColumn != null && this.iPSDEFGridColumn.getPSDEField().isKeyDEField()) {
                this.bAllowEmpty = true;
            }
            this.getRefPickupPSAppView();
            this.getRefLinkPSAppView();
        }
        if (this.iPSDEField != null) {
            this.bEnableItemPriv = this.iPSDEField.isEnablePrivilege();
        }
        if (!this.psDETreeNodeColumn.isENABLEITEMPRIVNull()) {
            this.bEnableItemPriv = this.psDETreeNodeColumn.getENABLEITEMPRIV();
        }
        if (this.bEnableItemPriv && this.iPSDEField != null) {
            this.strItemPrivId = StringHelper.Format((String)"%1$s|%2$s", (Object)this.iPSDEField.getPSDataEntity().getName(), (Object)this.iPSDEField.getName());
        }
        this.psDETreeNodeDataItemList = this.iPSDEFGridColumn.getPSDETreeNodeDataItems(this);
        this.strDataItemName = this.iPSDEFGridColumn.getDataItemName(this);
        if (this.getEnableLink() == 1) {
            linkPSAppView = this.onGetLinkPSAppView(false);
            if (linkPSAppView == null) {
                throw new Exception("\u8868\u683c\u5217\u542f\u7528\u94fe\u63a5\uff0c\u4f46\u6ca1\u6709\u6307\u5b9a\u94fe\u63a5\u89c6\u56fe");
            }
            this.bEnableLinkView = true;
            this.linkPSAppView = linkPSAppView;
        } else if (this.getEnableLink() == 2 && (linkPSAppView = this.onGetLinkPSAppView(true)) != null) {
            this.bEnableLinkView = true;
            this.linkPSAppView = linkPSAppView;
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDETreeNodeColumn.getPSDEUIACTIONID())) {
            if (this.iPSDEUIAction == null && this.getPSDETreeNode().getPSAppDataEntity() != null) {
                this.iPSDEUIAction = this.getPSDETreeNode().getPSAppDataEntity().getPSAppDEUIAction(this.psDETreeNodeColumn.getPSDEUIACTIONID(), true, this.getOwnedPSControl());
            }
            if (this.iPSDEUIAction == null) {
                this.iPSDEUIAction = this.getPSDETreeNode().getPSDataEntity().getPSDEUIAction(this.psDETreeNodeColumn.getPSDEUIACTIONID());
            }
            if (this.getPSDETree().isPrepareTemplV2logic()) {
                PSAppViewUIActionProxy iPSAppViewUIAction = new PSAppViewUIActionProxy(this, this.iPSDEUIAction, this.getPSDETree());
                this.getPSDETree().registerPSAppViewUIAction(iPSAppViewUIAction);
                this.registerPSAppViewLogic(iPSAppViewUIAction);
            } else {
                this.getPSDETree().getPSAppView().registerPSUIAction(this.iPSDEUIAction);
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDETreeNodeColumn.getPSDEUAGROUPID())) {
            Iterator psUIActionGroupDetails;
            if (this.iPSDEUIActionGroup == null && this.getPSDETreeNode().getPSAppDataEntity() != null) {
                this.iPSDEUIActionGroup = this.getPSDETreeNode().getPSAppDataEntity().getPSAppDEUIActionGroup(this.psDETreeNodeColumn.getPSDEUAGROUPID(), true, this.getOwnedPSControl());
            }
            if (this.iPSDEUIActionGroup == null) {
                this.iPSDEUIActionGroup = this.getPSDETreeNode().getPSDataEntity().getPSDEUIActionGroup(this.psDETreeNodeColumn.getPSDEUAGROUPID());
            }
            if ((psUIActionGroupDetails = this.iPSDEUIActionGroup.getPSUIActionGroupDetails()) != null) {
                while (psUIActionGroupDetails.hasNext()) {
                    IPSUIActionGroupDetail iPSUIActionGroupDetail = (IPSUIActionGroupDetail)psUIActionGroupDetails.next();
                    IPSUIAction iPSUIAction = iPSUIActionGroupDetail.getPSUIAction();
                    if (iPSUIAction == null) continue;
                    if (this.getPSDETree().isPrepareTemplV2logic()) {
                        PSAppViewUIActionProxy iPSAppViewUIAction = new PSAppViewUIActionProxy(this, iPSUIAction, this.getPSDETree());
                        this.getPSDETree().registerPSAppViewUIAction(iPSAppViewUIAction);
                        this.registerPSAppViewLogic(iPSAppViewUIAction, iPSUIActionGroupDetail);
                        continue;
                    }
                    this.getPSDETree().getPSAppView().registerPSUIAction(iPSUIAction);
                }
            }
        }
        this.bEnableUnitName = true;
        if (this.iPSDEFGridColumn != null) {
            if (StringHelper.IsNullOrEmpty((String)this.strUnitName)) {
                this.strUnitName = this.iPSDEFGridColumn.getUnitName();
            }
            if (this.nUnitNameWidth <= 0) {
                this.nUnitNameWidth = this.iPSDEFGridColumn.getUnitNameWidth();
            }
        }
        if (StringHelper.IsNullOrEmpty((String)this.strUnitName)) {
            this.bEnableUnitName = false;
        }
        super.onInit();
        this.preparePSEditor();
    }

    protected void preparePSEditor() throws Exception {
        this.getPSEditor();
    }

    @Override
    @PSModelRTMeta(description="\u5217\u6570\u636e\u9879\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDETreeNodeDataItem> getPSDETreeNodeDataItems() {
        return this.psDETreeNodeDataItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5217\u6570\u636e\u9879\u540d\u79f0")
    public String getDataItemName() {
        return this.strDataItemName;
    }

    @Override
    @PSModelRTMeta(description="\u5217\u5b9e\u4f53\u5c5e\u6027", outputdoc="false")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5217\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, fields={"PSDEFID"})
    public IPSAppDEField getPSAppDEField() {
        return this.iPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u5bf9\u8c61", hideempty=true, dump=false)
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u4ee3\u7801\u8868", hideempty=true, dumpref=true, fields={"PSCODELISTID"})
    public IPSAppCodeList getPSAppCodeList() {
        if (this.getPSCodeList() != null && this.getPSCodeList() instanceof IPSAppCodeList) {
            return (IPSAppCodeList)this.getPSCodeList();
        }
        return null;
    }

    @Override
    public String getPSCodeListId() {
        return this.strPSCodeListId;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u683c\u5f0f\u5316", fields={"VALUEFORMAT"})
    public String getValueFormat() {
        return this.strValueFormat;
    }

    @Override
    public String[] getFields() {
        return this.fields;
    }

    protected String calcEditorCssStyle() throws Exception {
        StringBuilderEx editorCssStyle = new StringBuilderEx();
        return editorCssStyle.toString();
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u7c7b\u578b", dump=false)
    public String getEditorType() {
        return this.strEditorType;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u6837\u5f0f", dump=false)
    public String getEditorStyle() {
        if (this.getPSSysEditorStyle() != null && this.getPSDETree().getPSAppView().getPSPFStyle().isEnableEditorStyleCode()) {
            return this.getPSSysEditorStyle().getStyleCode();
        }
        return this.strEditorStyle;
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u503c\u8f93\u5165", fields={"ALLOWEMPTY"})
    public boolean isAllowEmpty() {
        if (this.isEditable()) {
            return this.bAllowEmpty;
        }
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u9879\u540d\u79f0", fields={"VALUEITEMNAME"}, ignorert=3)
    public String getValueItemName() {
        return this.strValueItemName;
    }

    public IPSDEFGridColumn getPSDEFGridColumn() {
        return this.iPSDEFGridColumn;
    }

    protected void setPSDEFGridColumn(IPSDEFGridColumn iPSDEFGridColumn) {
        this.iPSDEFGridColumn = iPSDEFGridColumn;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        IPSAppView iPSAppView = this.getRefPickupPSAppView();
        if (iPSAppView != null) {
            relatedAppViewList.add(iPSAppView);
        }
        if ((iPSAppView = this.getRefLinkPSAppView()) != null) {
            relatedAppViewList.add(iPSAppView);
        }
        if (this.getPSDEUIAction() != null && this.getPSDEUIAction().getFrontPSAppView(this) != null) {
            relatedAppViewList.add(this.getPSDEUIAction().getFrontPSAppView(this));
        }
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u9009\u62e9\u89c6\u56fe", hideempty=true)
    public IPSAppView getRefPickupPSAppView() throws Exception {
        if (!this.getPSDETreeNode().isEnableRowEdit() || !this.isEnableRowEdit()) {
            return null;
        }
        String strPickupPSDEViewId = this.psDETreeNodeColumn.getPICKUPPSDEVIEWID();
        if (StringHelper.IsNullOrEmpty((String)strPickupPSDEViewId) && this.getPSEditorType().hasPickupView() && this.iPSDEFGridColumn != null) {
            strPickupPSDEViewId = this.iPSDEFGridColumn.getRefPickupPSDEViewId(this.getPSDETree().getPSAppView().getPSApplication());
        }
        if (!StringHelper.IsNullOrEmpty((String)strPickupPSDEViewId)) {
            String strPSAppViewId = Helper.GenUniqueId((String)this.getPSDETree().getPSAppView().getPSApplication().getId(), (String)strPickupPSDEViewId);
            return this.getPSDETree().getPSAppView().getPSApplication().getPSAppView(strPSAppViewId, strPickupPSDEViewId, this.getPSDETree().getPSAppView());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u6570\u636e\u94fe\u63a5\u89c6\u56fe", hideempty=true)
    public IPSAppView getRefLinkPSAppView() throws Exception {
        if (!this.getPSDETreeNode().isEnableRowEdit() || !this.isEnableRowEdit()) {
            return null;
        }
        String strLinkPSDEViewId = this.psDETreeNodeColumn.getLINKPSDEVIEWID();
        if (StringHelper.IsNullOrEmpty((String)strLinkPSDEViewId) && this.getPSEditorType().hasLinkView() && this.iPSDEFGridColumn != null) {
            strLinkPSDEViewId = this.iPSDEFGridColumn.getRefLinkPSDEViewId(this.getPSDETree().getPSAppView().getPSApplication());
        }
        if (!StringHelper.IsNullOrEmpty((String)strLinkPSDEViewId)) {
            String strPSAppViewId = Helper.GenUniqueId((String)this.getPSDETree().getPSAppView().getPSApplication().getId(), (String)strLinkPSDEViewId);
            return this.getPSDETree().getPSAppView().getPSApplication().getPSAppView(strPSAppViewId, strLinkPSDEViewId, this.getPSDETree().getPSAppView());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u9879\u5f02\u6b65\u5904\u7406\u5668\u7c7b\u578b", hideempty=true, dump=false)
    public String getItemHandlerType() {
        if (!this.getPSDETreeNode().isEnableRowEdit() || !this.isEnableRowEdit()) {
            return "";
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strItemHandlerType)) {
            if (StringHelper.Compare((String)this.strItemHandlerType, (String)"None", (boolean)true) == 0) {
                return "";
            }
            return this.strItemHandlerType;
        }
        if (this.iPSDEFGridColumn != null) {
            return this.iPSDEFGridColumn.getItemHandlerType(this);
        }
        if (StringHelper.Compare((String)this.getPSEditorType().getStandardPSEditorType(), (String)"DROPDOWNLIST", (boolean)true) == 0 && this.getPSCodeList() != null && StringHelper.Compare((String)this.getPSCodeList().getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0) {
            return "CodeList";
        }
        if (StringHelper.Compare((String)this.getPSEditorType().getStandardPSEditorType(), (String)"AC", (boolean)true) == 0) {
            return "AC";
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u6761\u4ef6", codelist="FormItemEnableCond", fields={"ENABLECOND"})
    public int getEnableCond() {
        return this.nEnableCond;
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acb\u9ed8\u8ba4\u503c\u7c7b\u578b", codelist="FieldDefaultValueType", fields={"CREATEDVT"})
    public String getCreateDVT() {
        return this.strCreateDVT;
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acb\u9ed8\u8ba4\u503c", fields={"CREATEDV"})
    public String getCreateDV() {
        return this.strCreateDV;
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u9ed8\u8ba4\u503c\u7c7b\u578b", codelist="FieldDefaultValueType", fields={"UPDATEDVT"})
    public String getUpdateDVT() {
        return this.strUpdateDVT;
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u9ed8\u8ba4\u503c", fields={"UPDATEDV"})
    public String getUpdateDV() {
        return this.strUpdateDV;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u7f16\u8f91", dump=false)
    public boolean isEditable() {
        return this.bEditable;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u53c2\u6570", hideempty=true, dump=false)
    public JSONObject getItemParam() throws Exception {
        if (this.iPSDEFGridColumn != null) {
            return this.iPSDEFGridColumn.getItemParam(this);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6", hideempty=true)
    public IPSDEDataSet getRefPSDEDataSet() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psDETreeNodeColumn.getREFPSDEID())) {
            IPSDataEntity refPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psDETreeNodeColumn.getREFPSDEID());
            if (!StringHelper.IsNullOrEmpty((String)this.psDETreeNodeColumn.getREFPSDEDATASETID())) {
                return refPSDataEntity.getPSDEDataSet(this.psDETreeNodeColumn.getREFPSDEDATASETID());
            }
            if (this.getPSDETree().isRegisterToPSAppDataEntity()) {
                return refPSDataEntity.getDefaultPSDEDataSet();
            }
            return null;
        }
        if (this.iPSDEFGridColumn != null && this.iPSDEFGridColumn.getRefPSDataEntity() != null) {
            if (!StringHelper.IsNullOrEmpty((String)this.iPSDEFGridColumn.getRefPSDEDataSetId())) {
                return this.iPSDEFGridColumn.getRefPSDataEntity().getPSDEDataSet(this.iPSDEFGridColumn.getRefPSDEDataSetId());
            }
            if (this.getPSDETree().isRegisterToPSAppDataEntity()) {
                return this.iPSDEFGridColumn.getRefPSDataEntity().getDefaultPSDEDataSet();
            }
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u81ea\u52a8\u586b\u5145\u6a21\u5f0f", hideempty=true)
    public IPSDEACMode getRefPSDEACMode() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psDETreeNodeColumn.getREFPSDEID())) {
            IPSDataEntity refPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psDETreeNodeColumn.getREFPSDEID());
            if (!StringHelper.IsNullOrEmpty((String)this.psDETreeNodeColumn.getREFPSDEACMODEID())) {
                return refPSDataEntity.getPSDEACMode(this.psDETreeNodeColumn.getREFPSDEACMODEID());
            }
            if (this.getPSDETree().isRegisterToPSAppDataEntity()) {
                return refPSDataEntity.getDefaultPSDEACMode();
            }
            return null;
        }
        if (this.iPSDEFGridColumn != null && this.iPSDEFGridColumn.getRefPSDataEntity() != null) {
            if (!StringHelper.IsNullOrEmpty((String)this.iPSDEFGridColumn.getRefPSDEACModeId())) {
                return this.iPSDEFGridColumn.getRefPSDataEntity().getPSDEACMode(this.iPSDEFGridColumn.getRefPSDEACModeId());
            }
            if (this.getPSDETree().isRegisterToPSAppDataEntity()) {
                return this.iPSDEFGridColumn.getRefPSDataEntity().getDefaultPSDEACMode();
            }
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u7c7b\u578b")
    public IPSEditorType getPSEditorType() {
        return this.iPSEditorType;
    }

    @Override
    public String getPSDETEIUpdateId() {
        return this.psDETreeNodeColumn.getPSDETEIUPDATEID();
    }

    @Override
    @PSModelRTMeta(description="\u6811\u8868\u7f16\u8f91\u9879\u66f4\u65b0\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDETreeNode", fields={"PSDETEIUPDATEID"})
    public IPSDETreeNodeEditItemUpdate getPSDETreeNodeEditItemUpdate() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getPSDETEIUpdateId())) {
            return null;
        }
        return this.getPSDETreeNode().getPSDETreeNodeEditItemUpdate(this.getPSDETEIUpdateId());
    }

    @Override
    @PSModelRTMeta(description="\u6811\u8868\u683c\u7f16\u8f91\u9879\u5bf9\u8c61", hideempty=true, modelcls="SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeEditItem")
    public IPSDETreeNodeEditItem getPSDETreeNodeEditItem() {
        if (this.isEnableRowEdit()) {
            return this;
        }
        return super.getPSDETreeNodeEditItem();
    }

    @Override
    public Properties getEditorParams() {
        return this.editorParams;
    }

    @Override
    public int getEditorParam(String strParam, int nDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (int)nDefault);
    }

    @Override
    public String getEditorParam(String strParam, String strDefault) {
        String strValue = PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (String)strDefault);
        if (!this.isHiddenDataItem() && StringHelper.IsNullOrEmpty((String)strDefault) && StringHelper.IsNullOrEmpty((String)strValue) && strDefault != null && (StringHelper.Compare((String)strParam, (String)"DEFAULTVALUETYPE", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTOBJECTIDFIELD", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTOBJECTNAMEFIELD", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTOBJECTVALUEFIELD", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTTEXTSEPARATOR", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTVALUESEPARATOR", (boolean)false) == 0)) {
            String strValue2 = PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, null);
            if (strValue2 != null) {
                return strValue2;
            }
            if (StringHelper.IsNullOrEmpty((String)this.getDataItemName())) {
                return strValue;
            }
            IPSDETreeNodeDataItem iPSDETreeNodeDataItem = null;
            try {
                iPSDETreeNodeDataItem = this.getPSDETreeNode().getPSDETreeNodeDataItem(this.getDataItemName(), true);
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
            if (iPSDETreeNodeDataItem == null || iPSDETreeNodeDataItem.getPSAppDEField() == null) {
                return strValue;
            }
            IPSAppDEField iPSAppDEField = iPSDETreeNodeDataItem.getPSAppDEField();
            if (StringHelper.Compare((String)strParam, (String)"DEFAULTVALUETYPE", (boolean)false) == 0) {
                return iPSDETreeNodeDataItem.getValueType();
            }
            if (StringHelper.Compare((String)strParam, (String)"DEFAULTOBJECTIDFIELD", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTOBJECTNAMEFIELD", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTOBJECTVALUEFIELD", (boolean)false) == 0) {
                block62: {
                    try {
                        IPSAppDEMethodDTOField dstPSAppDEMethodDTOField;
                        IPSAppDEField dstPSAppDEField;
                        IPSDEMethodDTOField iPSDEMethodDTOField;
                        IPSAppDEMethodDTOField iPSAppDEMethodDTOField;
                        IPSAppDEMethodDTO iPSAppDEMethodDTO = this.getPSAppDEMethodDTO();
                        if (iPSAppDEMethodDTO == null || (iPSAppDEMethodDTOField = iPSAppDEMethodDTO.getPSAppDEMethodDTOField(iPSAppDEField, true)) == null || iPSAppDEMethodDTOField.getPSDEMethodDTOField() == null || (iPSDEMethodDTOField = iPSAppDEMethodDTOField.getPSDEMethodDTOField()).getPSDER() == null || !"DTO".equals(iPSAppDEMethodDTOField.getType()) && !"DTOS".equals(iPSAppDEMethodDTOField.getType()) || iPSAppDEMethodDTOField.getRefPSAppDEMethodDTO() == null || iPSAppDEMethodDTOField.getRefPSAppDataEntity() == null) break block62;
                        IPSDER1N iPSDER1N = null;
                        IPSDERCustom iPSDERCustom = null;
                        IPSDEField pickupPSDEField = null;
                        IPSDEField pickupTextPSDEField = null;
                        IPSPickupObjectDEField pickupObjectPSDEField = null;
                        IPSDataEntity dstPSDataEntity = iPSAppDEMethodDTOField.getRefPSAppDataEntity().getPSDataEntity();
                        IPSDataEntity refPSDataEntity = this.getRefPSDataEntity();
                        if (refPSDataEntity != null) {
                            Iterator<IPSDERBase> psDERs = dstPSDataEntity.getMinorPSDERs();
                            if (psDERs != null) {
                                while (psDERs.hasNext()) {
                                    IPSDERBase iPSDERBase = psDERs.next();
                                    if (StringHelper.Compare((String)refPSDataEntity.getId(), (String)iPSDERBase.getMajorDEId(), (boolean)false) != 0) continue;
                                    if ("DER1N".equals(iPSDERBase.getDERType())) {
                                        iPSDER1N = (IPSDER1N)iPSDERBase;
                                    } else if ("DER11".equals(iPSDERBase.getDERType())) {
                                        iPSDER1N = (IPSDER1N)iPSDERBase;
                                    } else {
                                        if (!"DERCUSTOM".equals(iPSDERBase.getDERType()) || ((IPSDERCustom)iPSDERBase).getPickupPSDEField() == null) continue;
                                        iPSDERCustom = (IPSDERCustom)iPSDERBase;
                                    }
                                    break;
                                }
                            }
                        } else if (dstPSDataEntity.getDEType() == 3) {
                            IPSDERNN iPSDERNN = dstPSDataEntity.getPSDERNN();
                            if (StringHelper.Compare((String)iPSDERNN.getFirstPSDER().getMajorDEId(), (String)iPSAppDEField.getPSAppDataEntity().getPSDataEntity().getId(), (boolean)false) == 0) {
                                if (iPSDERNN.getSecondPSDER() instanceof IPSDER1N) {
                                    iPSDER1N = (IPSDER1N)iPSDERNN.getSecondPSDER();
                                } else {
                                    iPSDERCustom = (IPSDERCustom)iPSDERNN.getSecondPSDER();
                                }
                            } else if (iPSDERNN.getFirstPSDER() instanceof IPSDER1N) {
                                iPSDER1N = (IPSDER1N)iPSDERNN.getFirstPSDER();
                            } else {
                                iPSDERCustom = (IPSDERCustom)iPSDERNN.getFirstPSDER();
                            }
                        }
                        if (iPSDER1N != null) {
                            pickupPSDEField = iPSDER1N.getPickupPSDEField();
                            pickupTextPSDEField = iPSDER1N.getPSPickupTextDEField();
                            pickupObjectPSDEField = iPSDER1N.getPSPickupObjectDEField();
                        } else if (iPSDERCustom != null) {
                            iPSDERCustom = (IPSDERCustom)iPSDEMethodDTOField.getPSDER();
                            pickupPSDEField = iPSDERCustom.getPickupPSDEField();
                            pickupTextPSDEField = iPSDERCustom.getPickupTextPSDEField();
                        } else {
                            pickupPSDEField = dstPSDataEntity.getKeyPSDEField();
                            pickupTextPSDEField = dstPSDataEntity.getMajorPSDEField();
                        }
                        if (pickupPSDEField != null && pickupTextPSDEField == null) {
                            pickupTextPSDEField = dstPSDataEntity.getMajorPSDEField();
                        }
                        IPSDEField dstPSDEField = null;
                        if (StringHelper.Compare((String)strParam, (String)"DEFAULTOBJECTIDFIELD", (boolean)false) == 0) {
                            dstPSDEField = pickupPSDEField;
                        } else if (StringHelper.Compare((String)strParam, (String)"DEFAULTOBJECTNAMEFIELD", (boolean)false) == 0) {
                            dstPSDEField = pickupTextPSDEField;
                        } else if (StringHelper.Compare((String)strParam, (String)"DEFAULTOBJECTVALUEFIELD", (boolean)false) == 0) {
                            dstPSDEField = pickupObjectPSDEField;
                        }
                        if (dstPSDEField != null && (dstPSAppDEField = iPSAppDEMethodDTOField.getRefPSAppDataEntity().getPSAppDEField(dstPSDEField, true)) != null && (dstPSAppDEMethodDTOField = iPSAppDEMethodDTOField.getRefPSAppDEMethodDTO().getPSAppDEMethodDTOField(dstPSAppDEField, true)) != null) {
                            return dstPSAppDEMethodDTOField.getName();
                        }
                    }
                    catch (Exception ex) {
                        log.error((Object)ex);
                    }
                }
                return strValue;
            }
            return strValue;
        }
        if (this.isEditable() && StringHelper.IsNullOrEmpty((String)strDefault) && StringHelper.IsNullOrEmpty((String)strValue) && strDefault != null) {
            if (StringHelper.Compare((String)strParam, (String)"DEFAULTMAXLENGTH", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTMINLENGTH", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTMAXVALUE", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTMINVALUE", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTPRECISION", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTARRAY", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTARRAYDATATYPE", (boolean)false) == 0) {
                String strValue2 = PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, null);
                if (strValue2 != null) {
                    return strValue2;
                }
                IPSDETreeNodeDataItem iPSDETreeNodeDataItem = null;
                try {
                    iPSDETreeNodeDataItem = this.getPSDETreeNode().getPSDETreeNodeDataItem(this.getDataItemName(), true);
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
                if (iPSDETreeNodeDataItem == null || iPSDETreeNodeDataItem.getPSAppDEField() == null) {
                    return strValue;
                }
                IPSAppDEField iPSDEFieldBase = iPSDETreeNodeDataItem.getPSAppDEField();
                if (this.getPSDEFGridColumn() == null && iPSDEFieldBase == null) {
                    return strValue;
                }
                if (StringHelper.Compare((String)strParam, (String)"DEFAULTMAXLENGTH", (boolean)false) == 0) {
                    int nLength = -1;
                    nLength = this.getPSDEFGridColumn() != null ? this.getPSDEFGridColumn().getStringLength(iPSDEFieldBase) : iPSDEFieldBase.getStringLength();
                    if (nLength <= 0) {
                        return null;
                    }
                    return String.format("%1$s", nLength);
                }
                if (StringHelper.Compare((String)strParam, (String)"DEFAULTMINLENGTH", (boolean)false) == 0) {
                    int nLength = -1;
                    nLength = this.getPSDEFGridColumn() != null ? this.getPSDEFGridColumn().getMinStringLength(iPSDEFieldBase) : iPSDEFieldBase.getMinStringLength();
                    if (nLength <= 0) {
                        return null;
                    }
                    return String.format("%1$s", nLength);
                }
                if (StringHelper.Compare((String)strParam, (String)"DEFAULTMAXVALUE", (boolean)false) == 0) {
                    if (this.getPSDEFGridColumn() != null) {
                        return this.getPSDEFGridColumn().getMaxValueString(iPSDEFieldBase);
                    }
                    return iPSDEFieldBase.getMaxValueString();
                }
                if (StringHelper.Compare((String)strParam, (String)"DEFAULTMINVALUE", (boolean)false) == 0) {
                    if (this.getPSDEFGridColumn() != null) {
                        return this.getPSDEFGridColumn().getMinValueString(iPSDEFieldBase);
                    }
                    return iPSDEFieldBase.getMinValueString();
                }
                if (StringHelper.Compare((String)strParam, (String)"DEFAULTPRECISION", (boolean)false) == 0) {
                    int nLength = -1;
                    nLength = this.getPSDEFGridColumn() != null ? this.getPSDEFGridColumn().getPrecision(iPSDEFieldBase) : iPSDEFieldBase.getPrecision();
                    if (nLength <= 0) {
                        return null;
                    }
                    return String.format("%1$s", nLength);
                }
                if (this.getPSAppDEField() != null && StringHelper.Compare((String)strParam, (String)"DEFAULTARRAYDATATYPE", (boolean)false) == 0) {
                    block64: {
                        IPSAppDEMethodDTOField iPSAppDEMethodDTOField;
                        block65: {
                            IPSAppDEMethodDTO iPSAppDEMethodDTO = this.getPSAppDEMethodDTO();
                            if (iPSAppDEMethodDTO == null || (iPSAppDEMethodDTOField = iPSAppDEMethodDTO.getPSAppDEMethodDTOField(this.getPSAppDEField(), true)) == null || !"SIMPLES".equals(iPSAppDEMethodDTOField.getType())) break block64;
                            if (!DataTypeHelper.isBigIntType((int)iPSAppDEMethodDTOField.getStdDataType()) && !DataTypeHelper.isBigDecimalType((int)iPSAppDEMethodDTOField.getStdDataType()) && !DataTypeHelper.isDoubleType((int)iPSAppDEMethodDTOField.getStdDataType())) break block65;
                            return "NUMBER";
                        }
                        try {
                            if (DataTypeHelper.isIntType((int)iPSAppDEMethodDTOField.getStdDataType())) {
                                return "INTEGER";
                            }
                            return "STRING";
                        }
                        catch (Exception ex) {
                            log.error((Object)ex);
                        }
                    }
                    return strValue;
                }
                if (this.getPSAppDEField() != null && StringHelper.Compare((String)strParam, (String)"DEFAULTARRAY", (boolean)false) == 0) {
                    try {
                        IPSAppDEMethodDTOField iPSAppDEMethodDTOField;
                        IPSAppDEMethodDTO iPSAppDEMethodDTO = this.getPSAppDEMethodDTO();
                        if (iPSAppDEMethodDTO != null && (iPSAppDEMethodDTOField = iPSAppDEMethodDTO.getPSAppDEMethodDTOField(this.getPSAppDEField(), true)) != null && "SIMPLES".equals(iPSAppDEMethodDTOField.getType())) {
                            return "true";
                        }
                    }
                    catch (Exception ex) {
                        log.error((Object)ex);
                    }
                    return strValue;
                }
            }
            return strValue;
        }
        return strValue;
    }

    @Override
    public double getEditorParam(String strParam, double fDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (double)fDefault);
    }

    @Override
    public boolean getEditorParam(String strParam, boolean bDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (boolean)bDefault);
    }

    @Override
    public String getPSSysValueRuleId() {
        return this.strPSSysValueRuleId;
    }

    @Override
    @PSModelRTMeta(description="\u5ffd\u7565\u8f93\u5165\u6a21\u5f0f", codelist="FormItemEnableCond", fields={"IGNOREINPUT"})
    public int getIgnoreInput() {
        return this.nIgnoreInput;
    }

    @Override
    @PSModelRTMeta(description="\u8f6c\u5316\u4e3a\u4ee3\u7801\u9879\u6587\u672c", ignoredumpvalues="false")
    public boolean isConvertToCodeItemText() {
        if (StringHelper.IsNullOrEmpty((String)this.getPSCodeListId())) {
            return false;
        }
        if (this.getPSEditorType() != null) {
            return this.getPSEditorType().isConvertToCodeItemText();
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u9700\u8981\u4ee3\u7801\u8868\u914d\u7f6e", ignoredumpvalues="false", fields={"NEEDCODELISTCONFIG"})
    public boolean isNeedCodeListConfig() {
        return this.bNeedCodeListConfig;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u4ee3\u7801\u8868\u914d\u7f6e\u6a21\u5f0f", codelist="OutputCodeListConfigMode", ignoredumpvalues="0", fields={"CODELISTCONFIGMODE"})
    public int getOutputCodeListConfigMode() {
        return this.nOutputCodeListConfigMode;
    }

    @Override
    public String getEditorCssStyle() {
        return this.strEditorCssStyle;
    }

    @Override
    public String getValueTranslator() {
        return this.strValueProcessor;
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u7f6e\u9879\u540d\u79f0", ignorert=3, hideempty2=true, fields={"RESETITEMNAME"})
    public String getResetItemName() {
        return this.strResetItemName;
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u7f6e\u9879\u96c6\u5408", hideempty2=true, child=true, outputdoc="false", fields={"RESETITEMNAME"})
    public Iterator<String> getResetItemNames() {
        if (this.resetItemNameList == null || this.resetItemNameList.size() == 0) {
            return null;
        }
        return this.resetItemNameList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u63d0\u793a\u4fe1\u606f", dump=false)
    public String getPlaceHolder() {
        return this.strPlaceHolder;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u7f16\u8f91\u5668\u6837\u5f0f")
    public IPSSysEditorStyle getPSSysEditorStyle() {
        return this.iPSSysEditorStyle;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u884c\u7f16\u8f91", ignoredumpvalues="false", fields={"ENABLEROWEDIT"})
    public boolean isEnableRowEdit() {
        return this.bRowEditable;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u9879")
    public IDataItem getDataItem() {
        if (this.psDETreeNodeDataItemList != null && this.psDETreeNodeDataItemList.size() > 0) {
            return this.psDETreeNodeDataItemList.get(0);
        }
        return this.psDataItemImpl;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u9879\u6743\u9650\u63a7\u5236", ignoredumpvalues="false", fields={"ENABLEITEMPRIV"})
    public boolean isEnableItemPriv() {
        return this.bEnableItemPriv;
    }

    protected void setEnableItemPriv(boolean bEnableItemPriv) {
        this.bEnableItemPriv = bEnableItemPriv;
    }

    @Override
    public String getItemPrivId() {
        return this.strItemPrivId;
    }

    protected void setItemPrivId(String strItemPrivId) {
        this.strItemPrivId = strItemPrivId;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u7f6e\u754c\u9762\u884c\u4e3a", hideempty2=true, child=true, fields={"PSDEUIACTIONID"})
    public IPSDEUIAction getPSDEUIAction() {
        return this.iPSDEUIAction;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4", child=true, fields={"PSDEUAGROUPID"})
    public IPSDEUIActionGroup getPSDEUIActionGroup() {
        return this.iPSDEUIActionGroup;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u8f93\u51fa\u6a21\u5f0f", codelist="CLConvertModes", hideempty2=true, fields={"CLCONVERTMODE"})
    public String getCLConvertMode() {
        return this.strCLConvertMode;
    }

    protected boolean isFixColDataItemBug() {
        return (this.getPSSystemSetting().getEngineBugFixs() & 2) == 2;
    }

    @Override
    @PSModelRTMeta(description="\u7ed1\u5b9a\u503c\u9879\u540d\u79f0\u96c6\u5408", fields={"VALUEITEMNAME"})
    public String[] getValueItemNames() {
        if (this.valueItemNameList == null || this.valueItemNameList.size() == 0) {
            return null;
        }
        return this.valueItemNameList.toArray(new String[this.valueItemNameList.size()]);
    }

    @Override
    public String getEditorContainer() {
        return "GRIDCOLUMN";
    }

    @Override
    public double getEditorHeight() {
        return 0.0;
    }

    @Override
    public double getEditorWidth() {
        return 0.0;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true)
    public IPSDataEntity getRefPSDataEntity() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psDETreeNodeColumn.getREFPSDEID())) {
            return this.getPSSystem().getPSDataEntity2(this.psDETreeNodeColumn.getREFPSDEID());
        }
        if (this.iPSDEFGridColumn != null) {
            return this.iPSDEFGridColumn.getRefPSDataEntity();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u5bf9\u8c61", hideempty=true, child=true)
    public IPSEditor getPSEditor() throws Exception {
        if (this.iPSEditor == null && this.getPSEditorType() != null) {
            this.iPSEditor = this.getPSEditorType().createPSEditor(this);
        }
        return this.iPSEditor;
    }

    @Override
    public String getEditorName() {
        return this.getCodeName();
    }

    @Override
    public IPSControlContainer getPSControlContainer() {
        return this.getPSDETree();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u94fe\u63a5\u89c6\u56fe", ignoredumpvalues="false")
    public boolean isEnableLinkView() {
        return this.bEnableLinkView;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u94fe\u63a5\u6a21\u5f0f", codelist="DEGridColLinkMode", dump=false)
    public int getEnableLink() {
        return this.nEnableLink;
    }

    @Override
    @PSModelRTMeta(description="\u94fe\u63a5\u503c\u9879", fields={"VALUEITEMNAME"})
    public String getLinkValueItem() {
        if (!this.isEnableLinkView()) {
            return "";
        }
        String strLinkValueItem = this.psDETreeNodeColumn.getVALUEITEMNAME();
        if (!StringHelper.IsNullOrEmpty((String)strLinkValueItem)) {
            return strLinkValueItem;
        }
        if (this.iPSDEFGridColumn != null && !StringHelper.IsNullOrEmpty((String)(strLinkValueItem = this.iPSDEFGridColumn.getLinkValueItem(this)))) {
            return strLinkValueItem;
        }
        if (this.getPSDEField() != null && this.getPSDEField().isMajorDEField()) {
            return "srfkey";
        }
        return this.getDataItemName();
    }

    @Override
    @PSModelRTMeta(description="\u94fe\u63a5\u89c6\u56fe", dumpref=true, fields={"LINKPSDEVIEWID"})
    public IPSAppView getLinkPSAppView() throws Exception {
        if (!this.isEnableLinkView()) {
            return null;
        }
        if (this.linkPSAppView == null) {
            this.linkPSAppView = this.onGetLinkPSAppView(false);
        }
        return this.linkPSAppView;
    }

    protected IPSAppView onGetLinkPSAppView(boolean bTryMode) throws Exception {
        String strLinkPSDEViewId = this.psDETreeNodeColumn.getLINKPSDEVIEWID();
        if (StringHelper.IsNullOrEmpty((String)strLinkPSDEViewId) && this.getPSDEFGridColumn() != null) {
            strLinkPSDEViewId = this.getPSDEFGridColumn().getRefLinkPSDEViewId(this.getPSDETree().getPSAppView().getPSApplication());
        }
        if (StringHelper.IsNullOrEmpty((String)strLinkPSDEViewId) && this.getPSCodeList() != null) {
            strLinkPSDEViewId = this.getPSCodeList().getLinkPSDEViewId();
        }
        if (StringHelper.IsNullOrEmpty((String)strLinkPSDEViewId) && this.getPSDEField() != null && this.getPSDEField().isMajorDEField() && this.getPSDETreeNode().getPSAppDataEntity() != null) {
            strLinkPSDEViewId = this.getPSDETreeNode().getPSAppDataEntity().getRefLinkPSDEViewId();
        }
        if (!StringHelper.IsNullOrEmpty((String)strLinkPSDEViewId)) {
            return this.getPSDETree().getPSAppView().getPSApplication().getPSAppViewByDEViewId(strLinkPSDEViewId, bTryMode);
        }
        return null;
    }

    protected void registerPSAppViewLogic(IPSAppViewUIAction iPSAppViewUIAction) throws Exception {
        String strCtrlName = this.getPSDETree().getName();
        String strLogicTag = StringHelper.Format((String)"%1$s_%2$s_%3$s_click", (Object)strCtrlName, (Object)this.getPSDETreeNode().getNodeType(), (Object)this.getName()).toLowerCase();
        PSAppViewLogic psAppViewLogic = new PSAppViewLogic();
        psAppViewLogic.setPSAPPVIEWLOGICID(strLogicTag);
        psAppViewLogic.setPSAPPVIEWLOGICNAME(strLogicTag);
        psAppViewLogic.setDSTLOGICTYPE("APPVIEWUIACTION");
        psAppViewLogic.setPSAPPVIEWLOGICTYPE("CUSTOM");
        PSAppViewLogicImpl psAppDEViewLogicImpl = new PSAppViewLogicImpl();
        psAppDEViewLogicImpl.init(this.getDAGlobalHelper(), (Object)this.getPSDETree(), psAppViewLogic, iPSAppViewUIAction);
        this.getPSDETree().registerPSAppViewLogic(psAppDEViewLogicImpl);
    }

    protected void registerPSAppViewLogic(IPSAppViewUIAction iPSAppViewUIAction, IPSUIActionGroupDetail iPSUIActionGroupDetail) throws Exception {
        String strCtrlName = this.getPSDETree().getName();
        String strLogicTag = StringHelper.Format((String)"%1$s_%2$s_%3$s_%4$s_click", (Object)strCtrlName, (Object)this.getPSDETreeNode().getNodeType(), (Object)this.getName(), (Object)iPSUIActionGroupDetail.getName()).toLowerCase();
        PSAppViewLogic psAppViewLogic = new PSAppViewLogic();
        psAppViewLogic.setPSAPPVIEWLOGICID(strLogicTag);
        psAppViewLogic.setPSAPPVIEWLOGICNAME(strLogicTag);
        psAppViewLogic.setDSTLOGICTYPE("APPVIEWUIACTION");
        psAppViewLogic.setPSAPPVIEWLOGICTYPE("CUSTOM");
        PSAppViewLogicImpl psAppDEViewLogicImpl = new PSAppViewLogicImpl();
        psAppDEViewLogicImpl.init(this.getDAGlobalHelper(), (Object)this.getPSDETree(), psAppViewLogic, iPSAppViewUIAction);
        this.getPSDETree().registerPSAppViewLogic(psAppDEViewLogicImpl);
    }

    @Override
    public String getPSSysDictCatId() {
        return this.strPSSysDictCatId;
    }

    @Override
    protected String onGetRenderPSSysPFPluginId() {
        String strRenderPSSysPFPluginId = super.onGetRenderPSSysPFPluginId();
        if (StringHelper.IsNullOrEmpty((String)strRenderPSSysPFPluginId) && this.getPSDEFGridColumn() != null && this.getPSDEFGridColumn().getRenderPSSysPFPlugin() != null) {
            return this.getPSDEFGridColumn().getRenderPSSysPFPlugin().getId();
        }
        return strRenderPSSysPFPluginId;
    }

    @Override
    public IPSSysValueRule getPSSysValueRule() throws Exception {
        if (!this.isEditable()) {
            return null;
        }
        IPSSysValueRule iPSSysValueRule = this.onGetPSSysValueRule();
        if (iPSSysValueRule != null) {
            if (iPSSysValueRule instanceof IPSAppValueRule) {
                return iPSSysValueRule;
            }
            return this.getPSDETree().getPSAppView().getPSApplication().getPSAppValueRule(iPSSysValueRule.getId());
        }
        return iPSSysValueRule;
    }

    protected IPSSysValueRule onGetPSSysValueRule() throws Exception {
        if (this.getPSDEFGridColumn() != null) {
            if (this.getPSAppDEField() != null) {
                return this.getPSDEFGridColumn().getPSSysValueRule(this.getPSAppDEField());
            }
            if (this.getPSDEField() != null) {
                return this.getPSDEFGridColumn().getPSSysValueRule(this.getPSDEField());
            }
        } else {
            if (this.getPSAppDEField() != null) {
                return this.getPSAppDEField().getPSSysValueRule();
            }
            if (this.getPSDEField() != null) {
                return this.getPSDEField().getPSSysValueRule();
            }
        }
        return null;
    }

    @Override
    public String getEditorDynaClass() {
        return null;
    }

    @Override
    public String getEditorCssStyle2() {
        return null;
    }

    @Override
    public IPSSysCss getEditorPSSysCss() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5355\u4f4d\u540d\u79f0")
    public String getUnitName() {
        return this.strUnitName;
    }

    @Override
    @PSModelRTMeta(description="\u5355\u4f4d\u5bbd\u5ea6", ignoredumpvalues="0")
    public int getUnitNameWidth() {
        return this.nUnitNameWidth;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5355\u4f4d", ignoredumpvalues="false")
    public boolean isEnableUnitName() {
        return this.bEnableUnitName;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u7c7b\u578b[VALUETYPE]{SIMPLE|SIMPLES|OBJECT|OBJECTS}", codelist="EditorValueType", ignoredumpvalues="SIMPLE")
    public String getValueType() {
        return this.getEditorParam("VALUETYPE", this.getDefaultValueType());
    }

    protected String getDefaultValueType() {
        String strValue = this.getEditorParam("DEFAULTVALUETYPE", "");
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
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
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
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
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
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
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
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
        if (!"SIMPLE".equalsIgnoreCase(strValueType) && !StringHelper.IsNullOrEmpty((String)strValueType)) {
            return null;
        }
        String strValue = this.getEditorParam("DEFAULTVALUESEPARATOR", "");
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
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
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            return null;
        }
        return strValue;
    }

    protected IPSAppDEMethodDTO getPSAppDEMethodDTO() throws Exception {
        if (this.getPSDETree().getFetchPSControlAction() == null || this.getPSDETree().getFetchPSControlAction().getPSAppDEMethod() == null || this.getPSDETree().getFetchPSControlAction().getPSAppDEMethod().getPSAppDEMethodReturn() == null) {
            return null;
        }
        IPSAppDEMethodReturn iPSAppDEMethodReturn = this.getPSDETree().getFetchPSControlAction().getPSAppDEMethod().getPSAppDEMethodReturn();
        if ("DTO".equals(iPSAppDEMethodReturn.getType()) || "DTOS".equals(iPSAppDEMethodReturn.getType()) || "PAGE".equals(iPSAppDEMethodReturn.getType())) {
            return iPSAppDEMethodReturn.getPSAppDEMethodDTO();
        }
        return null;
    }

    @Override
    protected void onFillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        Iterator<IPSDEUIAction> psDEUIActions;
        if (this.getPSDEUIActionGroup() != null && (psDEUIActions = this.getPSDEUIActionGroup().getPSDEUIActions()) != null) {
            while (psDEUIActions.hasNext()) {
                IPSDEUIAction iPSDEUIAction = psDEUIActions.next();
                if (iPSDEUIAction.getFrontPSAppView(this) == null) continue;
                relatedAppViewList.add(iPSDEUIAction.getFrontPSAppView(this));
            }
        }
        if (this.getPSDEUIAction() != null && this.getPSDEUIAction().getFrontPSAppView(this) != null) {
            relatedAppViewList.add(this.getPSDEUIAction().getFrontPSAppView(this));
        }
        super.onFillRelatedPSAppViews(relatedAppViewList);
    }

    @Override
    public IPSAjaxHandler getItemPSAjaxHandler() {
        return null;
    }
}

