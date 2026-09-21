/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.PP.PPTreePanel
 *  SA.SRFDA.Ctrl.Data.TreeView
 *  SA.SRFDA.Web.ISRFDATreeActionHelperEx
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExPage
 *  SA.SRFramework.WebEx.SRFExTreeActionHelper
 *  SA.SRFramework.WebEx.SRFExTreePanel
 *  SA.SRFramework.WebEx.Script.TreeJSHelper
 *  SA.SRFramework.WebEx.UI.TreeNodeConfig
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Data.PP.PPTreePanel;
import SA.SRFDA.Ctrl.Data.TreeView;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.Default.ViewModel.TreePageModel;
import SA.SRFDA.Web.ISRFDATreeActionHelperEx;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFDA.Web.ViewModel.TreePanelModel;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.SRFExTreeActionHelper;
import SA.SRFramework.WebEx.SRFExTreePanel;
import SA.SRFramework.WebEx.Script.TreeJSHelper;
import SA.SRFramework.WebEx.UI.TreeNodeConfig;
import net.sf.json.JSONObject;

public class TreePage
extends BaseMainPage {
    public static final String PAGEPARAM_TREENODECLICK = "PAGE.TREENODECLICK";
    public static final String PAGEPARAM_TREENODEFILTER = "PAGE.TREENODEFILTER";
    public static final String PAGEPARAM_TREENODELINK = "PAGE.TREENODELINK";
    public static final String PAGEPARAM_TREEDEFAULTURL = "PAGE.TREEDEFAULTURL";
    public static final String PAGEPARAM_TREEROOTVISIBLE = "PAGE.TREEROOTVISIBLE";
    public static final String PAGEPARAM_TREEROOTTEXT = "PAGE.TREEROOTTEXT";
    protected SRFExTreePanel treePanel = null;
    protected CodeListConfig codeListConfig = null;
    protected String strCodeListId = "";
    protected boolean bMultiSelect = false;
    protected boolean bSelectLeaf = false;
    protected String strTreePanelConfigId = "";
    protected TreePageModel treePageModel = null;
    public static final String PPCTRLID_TREEPANEL = "TREEPANEL";
    protected PPTreePanel ppTreePanel = null;
    protected TreeView treeView = null;

    @Override
    protected void PreparePageParam() {
        BaseDataEntity pageParam;
        super.PreparePageParam();
        if (this.page != null && (pageParam = this.page.getAdvPageParam(PPCTRLID_TREEPANEL, "PP_TREEPANEL")) != null && pageParam instanceof PPTreePanel) {
            this.ppTreePanel = (PPTreePanel)pageParam;
        }
    }

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        String strTreeViewId = this.OnGetTreeView();
        if (!StringHelper.IsNullOrEmpty((String)strTreeViewId)) {
            this.treeView = this.getDAModelStorage().FindTreeView(strTreeViewId);
            if (this.treeView == null) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6811\u89c6\u56fe[%1$s]", (Object)strTreeViewId));
                return false;
            }
            this.setPageParam("TREEVIEW", this.treeView);
            if (!StringHelper.IsNullOrEmpty((String)this.treeView.getDEID())) {
                this.strPageDataEntityId = this.treeView.getDEID();
            }
        }
        if (StringHelper.IsNullOrEmpty((String)this.strPageDataEntityId)) {
            this.strPageDataEntityId = this.GetDefaultPageDataEntityId();
        }
        if (!this.LoadPageDataEntity()) {
            return true;
        }
        this.strCodeListId = this.OnGetCodeListId();
        this.bMultiSelect = this.OnGetTreeMultiSelect();
        this.bSelectLeaf = this.OnGetTreeSelectLeaf();
        return true;
    }

    @Override
    protected PageModel CreatePageModel() {
        return new TreePageModel();
    }

    @Override
    protected void PreparePageModel() {
        super.PreparePageModel();
        this.treePageModel = (TreePageModel)this.pageModel;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.setID(this.getWebContext().getContainerId());
        this.strCodeListId = this.OnGetCodeListId();
        if (!StringHelper.IsNullOrEmpty((String)this.strCodeListId)) {
            this.LoadTreePanel2();
        } else {
            this.LoadTreePanel();
        }
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.strCodeListId = this.OnGetCodeListId();
        if (StringHelper.IsNullOrEmpty((String)this.strCodeListId)) {
            this.RegisterTreeActionHelper(this.treePanel.getUniqueID(), this.GetTreeActionHelper());
        }
    }

    @Override
    protected void OnInit() {
        String strTreeJSName;
        super.OnInit();
        StringBuilderEx script = new StringBuilderEx();
        if (this.getPageParam(PAGEPARAM_TREENODECLICK) != null) {
            script.Append(TreeJSHelper.getOnSelectionchangeEventScript((String)this.treePanel.getUniqueID(), (String)(String.valueOf(this.getID()) + "ontreeclick(_2);")));
            this.RegisterOnReadyScript(5, script.toString());
            script.Reset();
        }
        if (!StringHelper.IsNullOrEmpty((String)(strTreeJSName = this.getPageParam("PAGE.TREEJSNAME", "")))) {
            this.RegisterOnReadyScript(3, StringHelper.Format((String)"%1$s=$P.tree['%2$s'];", (Object)strTreeJSName, (Object)this.treePanel.getUniqueID()));
        }
    }

    protected String GetTreeActionHelper() {
        String strTreeActionHelper = "";
        if (this.ppTreePanel != null && !this.ppTreePanel.isACTIONHELPERNull()) {
            strTreeActionHelper = this.ppTreePanel.getACTIONHELPER();
        }
        if (!StringHelper.IsNullOrEmpty((String)(strTreeActionHelper = this.getPageParam("PAGE.TREEACTIONHELPER", strTreeActionHelper)))) {
            return strTreeActionHelper;
        }
        return this.GetDefaultTreeActionHelper();
    }

    protected String GetDefaultTreeActionHelper() {
        if (this.treeView != null) {
            if (!StringHelper.IsNullOrEmpty((String)this.treeView.getBACKENDCTRL())) {
                return this.treeView.getBACKENDCTRL();
            }
            return "SA.SRFDA.Ctrl.Tree.BaseDATreeActionHelperEx";
        }
        return this.getWebContext().getWebExConfig().GetValue("SRFDA", "TREEACTIONHELPER", "");
    }

    protected void LoadTreePanel() {
        this.strTreePanelConfigId = "SRFDEFAULT.TV_COMMONPANEL";
        if (StringHelper.IsNullOrEmpty((String)this.strTreePanelConfigId)) {
            return;
        }
        this.treePanel = TreePage.CreateTreePanel(this, "treePanel", 100.0, 400.0, this.strTreePanelConfigId);
        if (this.treePanel != null) {
            this.treePanel.getTreePanelConfig().setRootVisible(this.OnGetTreeRootVisible());
            this.treePanel.getTreePanelConfig().setBorder(false);
            this.treePanel.getTreePanelConfig().setShowLine(false);
            String strRootText = "";
            if (!this.IsBackEndMode()) {
                strRootText = this.OnGetTreeRootText();
                if (!StringHelper.IsNullOrEmpty((String)strRootText)) {
                    this.treePanel.getTreePanelConfig().getRootNodeConfig().setText(strRootText);
                }
                int nDefaultLevel = this.OnGetTreeShowNodeLevel();
                String strShowNode = this.OnGetTreeShowNode();
                String strSelectNode = this.OnGetTreeSelectNode();
                if (!(!StringHelper.IsNullOrEmpty((String)this.getPageModel()) || nDefaultLevel <= 0 && StringHelper.IsNullOrEmpty((String)strShowNode) && StringHelper.IsNullOrEmpty((String)strSelectNode))) {
                    this.RegisterTreeActionHelper(this.treePanel.getUniqueID(), this.GetTreeActionHelper());
                    SRFExTreeActionHelper treeActionHelper = this.getTreeActionHelper(this.treePanel.getUniqueID());
                    if (nDefaultLevel > 0) {
                        treeActionHelper.ShowTreeNodeLevel((SRFExPage)this, this.treePanel, nDefaultLevel);
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strShowNode)) {
                        treeActionHelper.ShowTreeNode((SRFExPage)this, this.treePanel, strShowNode);
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strSelectNode)) {
                        if (StringHelper.Compare((String)strSelectNode, (String)strShowNode, (boolean)true) != 0) {
                            treeActionHelper.ShowTreeNode((SRFExPage)this, this.treePanel, strSelectNode);
                        }
                        this.treePanel.getTreePanelConfig().setSelectedValue(strSelectNode);
                    }
                }
                if (this.treePageModel != null && this.treePageModel.getTreePanelModel() != null) {
                    TreePanelModel treePanelModel = this.treePageModel.getTreePanelModel();
                    treePanelModel.setShowRoot(this.OnGetTreeRootVisible());
                    treePanelModel.setCtrlId("treePanel");
                    treePanelModel.setRemoteCtrlId(this.treePanel.getUniqueID());
                    treePanelModel.setConfigId(this.strTreePanelConfigId);
                    treePanelModel.setRootNodeText(strRootText);
                    treePanelModel.setMultiSelect(this.bMultiSelect);
                    treePanelModel.setSelectLeaf(this.bSelectLeaf);
                    treePanelModel.setDefaultLevel(nDefaultLevel);
                    treePanelModel.setActiveNode(strSelectNode);
                }
            }
        }
    }

    protected int OnGetTreeShowNodeLevel() {
        return this.getPageParam("PAGE.TREE.DEFAULTLEVEL", 0);
    }

    protected String OnGetTreeShowNode() {
        if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getPickupValue())) {
            return this.getWebContext().getPickupValue();
        }
        return this.getPageParam("PAGE.TREE.DEFAULTNODE", "");
    }

    protected String OnGetTreeSelectNode() {
        if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getPickupValue())) {
            return this.getWebContext().getPickupValue();
        }
        return this.getPageParam("PAGE.TREE.SELECTNODE", "");
    }

    protected void LoadTreePanel2() {
        this.strTreePanelConfigId = "SRFDEFAULT.TV_COMMONPANEL2";
        if (StringHelper.IsNullOrEmpty((String)this.strTreePanelConfigId)) {
            return;
        }
        this.codeListConfig = this.getWebContext().getCodeListMgr().GetCodeListConfig(this.strCodeListId);
        if (this.codeListConfig == null) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]\u5931\u8d25", (Object)this.strCodeListId));
            return;
        }
        this.treePanel = TreePage.CreateTreePanel(this, "treePanel", 100.0, 450.0, this.strTreePanelConfigId);
        if (this.treePanel != null) {
            this.treePanel.getTreePanelConfig().setBorder(false);
            this.treePanel.getTreePanelConfig().setShowLine(false);
            String strRootText = "";
            if (!this.IsBackEndMode()) {
                strRootText = this.OnGetTreeRootText();
                if (!StringHelper.IsNullOrEmpty((String)strRootText)) {
                    this.treePanel.getTreePanelConfig().getRootNodeConfig().setText(strRootText);
                }
                this.OnFillTreeConfig(this.treePanel, null);
                if (!this.bMultiSelect) {
                    this.treePanel.getTreePanelConfig().setSelectedValue(this.getWebContext().getPickupValue());
                }
            }
            if (this.treePageModel != null && this.treePageModel.getTreePanelModel() != null) {
                TreePanelModel treePanelModel = this.treePageModel.getTreePanelModel();
                treePanelModel.setCtrlId("treePanel");
                treePanelModel.setConfigId(this.strTreePanelConfigId);
                treePanelModel.setRemoteCtrlId(this.treePanel.getUniqueID());
                treePanelModel.setCodeListId(this.strCodeListId);
                treePanelModel.setRootNodeText(strRootText);
                treePanelModel.setMultiSelect(this.bMultiSelect);
                treePanelModel.setSelectLeaf(this.bSelectLeaf);
                treePanelModel.setShowRoot(this.treePanel.getTreePanelConfig().isRootVisible());
                if (!this.bMultiSelect) {
                    treePanelModel.setActiveNode(this.getWebContext().getPickupValue());
                }
            }
        }
    }

    protected void OnFillTreeConfig(SRFExTreePanel treePanel, TreeNodeConfig parentNodeConfig) {
        CodeListConfig curCodeListConfig = new CodeListConfig();
        CodeItemConfig curCodeItemConfig = new CodeItemConfig();
        if (parentNodeConfig == null) {
            parentNodeConfig = treePanel.getTreePanelConfig().getRootNodeConfig();
            parentNodeConfig.setAsyncMode(false);
            curCodeListConfig = this.codeListConfig;
            int i = 0;
            while (i < curCodeListConfig.getCodeItems().size()) {
                CodeItemConfig codeItemConfig = (CodeItemConfig)curCodeListConfig.getCodeItems().get(i);
                TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
                treeNodeConfig.setText(codeItemConfig.getTextWithStyle());
                treeNodeConfig.setID(StringHelper.Format((String)"%1$s", (Object)codeItemConfig.getValue()));
                treeNodeConfig.setIcon(codeItemConfig.getIcon());
                treeNodeConfig.setExpand(true);
                treeNodeConfig.setAsyncMode(false);
                parentNodeConfig.AddChildNode(treeNodeConfig);
                if (codeItemConfig.getCodeItems() != null && codeItemConfig.getCodeItems().size() > 0) {
                    this.OnFillTreeConfig(treePanel, treeNodeConfig);
                }
                ++i;
            }
        } else {
            curCodeItemConfig = this.codeListConfig.FindCodeItemConfigByValue(parentNodeConfig.getID(), true);
            if (curCodeItemConfig == null) {
                return;
            }
            int i = 0;
            while (i < curCodeItemConfig.getCodeItems().size()) {
                CodeItemConfig codeItemConfig = (CodeItemConfig)curCodeItemConfig.getCodeItems().get(i);
                TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
                treeNodeConfig.setText(codeItemConfig.getTextWithStyle());
                treeNodeConfig.setID(StringHelper.Format((String)"%1$s", (Object)codeItemConfig.getValue()));
                treeNodeConfig.setIcon(codeItemConfig.getIcon());
                treeNodeConfig.setExpand(false);
                treeNodeConfig.setAsyncMode(false);
                parentNodeConfig.AddChildNode(treeNodeConfig);
                if (codeItemConfig.getCodeItems() != null && codeItemConfig.getCodeItems().size() > 0) {
                    this.OnFillTreeConfig(treePanel, treeNodeConfig);
                }
                ++i;
            }
        }
    }

    @Override
    public String OutputPageCaption() {
        return String.valueOf(super.OutputPageCaption()) + "\u6811\u7ed3\u6784";
    }

    protected String OnGetTreeRootText() {
        String strText = "";
        if (this.ppTreePanel != null && !this.ppTreePanel.isROOTTEXTNull()) {
            strText = this.ppTreePanel.getROOTTEXT();
        }
        if (!StringHelper.IsNullOrEmpty((String)(strText = this.getPageParam(PAGEPARAM_TREEROOTTEXT, strText)))) {
            return strText;
        }
        if (this.treeView != null) {
            return this.treeView.getRootTreeNode().getTREENODENAME();
        }
        return this.getPageParam("PAGE.TREEACTIONHELPER.ROOTTEXT", "");
    }

    protected boolean OnGetTreeRootVisible() {
        boolean bRootVisible = false;
        if (this.ppTreePanel != null && !this.ppTreePanel.isROOTVISIBLENull()) {
            bRootVisible = this.ppTreePanel.getROOTVISIBLE();
        }
        if (this.treeView != null) {
            return this.treeView.getSHOWROOT();
        }
        return this.getPageParam(PAGEPARAM_TREEROOTVISIBLE, bRootVisible);
    }

    protected String OnGetCodeListId() {
        String strCodeListId = "";
        if (this.ppTreePanel != null && !this.ppTreePanel.isCODELISTIDNull()) {
            strCodeListId = this.ppTreePanel.getCODELISTID();
        }
        return this.getPageParam("PAGE.TREECODELIST", strCodeListId);
    }

    protected boolean OnGetTreeMultiSelect() {
        boolean bMultiSelect = false;
        if (this.ppTreePanel != null && !this.ppTreePanel.isMULTISELECTNull()) {
            bMultiSelect = this.ppTreePanel.getMULTISELECT();
        }
        return this.getPageParam("PAGE.TREE.MULTISELECT", bMultiSelect);
    }

    protected boolean OnGetTreeSelectLeaf() {
        boolean bSelectLeaf = false;
        return this.getPageParam("PAGE.TREE.SELECTLEAF", bSelectLeaf);
    }

    public String GetTreeNodeSelectCode() {
        String strTreeNodeSelectCode = "";
        if (this.ppTreePanel != null && !this.ppTreePanel.isNODECLICKCODENull()) {
            strTreeNodeSelectCode = this.ppTreePanel.getNODECLICKCODE();
        }
        return this.getPageParam(PAGEPARAM_TREENODECLICK, strTreeNodeSelectCode);
    }

    protected SRFExTreeActionHelper getTreeActionHelper(String strTreeId) {
        SRFExTreeActionHelper treeActionHelper = super.getTreeActionHelper(strTreeId);
        if (treeActionHelper != null && treeActionHelper instanceof ISRFDATreeActionHelperEx) {
            ISRFDATreeActionHelperEx iSRFDATreeActionHelperEx = (ISRFDATreeActionHelperEx)treeActionHelper;
            iSRFDATreeActionHelperEx.setTreeView(this.treeView);
        }
        return treeActionHelper;
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        String strTreeNodeFilter = "";
        if (this.ppTreePanel != null && !this.ppTreePanel.isNODEFILTERNull()) {
            strTreeNodeFilter = this.ppTreePanel.getNODEFILTER();
        }
        strTreeNodeFilter = this.getPageParam(PAGEPARAM_TREENODEFILTER, strTreeNodeFilter);
        this.treePageModel.getTreePanelModel().setTreeNodeFilter(strTreeNodeFilter);
        String strTreeNodeLink = "";
        if (this.ppTreePanel != null && !this.ppTreePanel.isNODELINKNull()) {
            strTreeNodeLink = this.ppTreePanel.getNODELINK();
        }
        strTreeNodeLink = this.getPageParam(PAGEPARAM_TREENODELINK, strTreeNodeLink);
        this.treePageModel.getTreePanelModel().setTreeNodeLink(strTreeNodeLink);
        String strTreeDefaultUrl = "";
        if (this.ppTreePanel != null && !this.ppTreePanel.isNODEDEFLINKNull()) {
            strTreeDefaultUrl = this.ppTreePanel.getNODEDEFLINK();
        }
        strTreeDefaultUrl = this.getPageParam(PAGEPARAM_TREEDEFAULTURL, strTreeDefaultUrl);
        this.treePageModel.setDefaultUrl(strTreeDefaultUrl);
        return true;
    }

    protected String OnGetTreeView() {
        String strTreeViewId = SRFDAWebCTXHelper.GetTreeView((ISRFDAWebContext)this.getWebContext());
        if (StringHelper.IsNullOrEmpty((String)strTreeViewId) && this.ppTreePanel != null) {
            strTreeViewId = this.ppTreePanel.getTREEVIEWID();
        }
        return this.getPageParam("PAGE.TREEVIEW", strTreeViewId);
    }
}

