/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAConfigHelper
 *  SA.SRFDA.Ctrl.ConfigPathHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DESubWF
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ViewModel.PageModel
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExTreePanel
 *  SA.SRFramework.WebEx.UI.TabViewConfig
 *  SA.SRFramework.WebEx.UI.TabViewPageConfig
 *  SA.SRFramework.WebEx.UI.TreeNodeConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  SA.SRFramework.XML.XMLNode
 *  SRFWF.Ctrl.Data.WFWorkflow
 *  SRFWF.Model.WFBaseProcessConfig
 *  SRFWF.Model.WFConfig
 *  SRFWF.Model.WFParallelSubWFConfig
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.WF.Web;

import SA.SRFDA.Ctrl.BaseDAConfigHelper;
import SA.SRFDA.Ctrl.ConfigPathHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DESubWF;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.WF.Ctrl.Data.PP.PPWFWorkTreeBar;
import SA.SRFDA.WF.Ctrl.Data.PP.PPWFWorkTreeNode;
import SA.SRFDA.WF.Web.ViewModel.WFTreeGridViewModel;
import SA.SRFDA.WF.Web.WFBaseTreeGridViewPage;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExTreePanel;
import SA.SRFramework.WebEx.UI.TabViewConfig;
import SA.SRFramework.WebEx.UI.TabViewPageConfig;
import SA.SRFramework.WebEx.UI.TreeNodeConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SA.SRFramework.XML.XMLNode;
import SRFWF.Ctrl.Data.WFWorkflow;
import SRFWF.Model.WFBaseProcessConfig;
import SRFWF.Model.WFConfig;
import SRFWF.Model.WFParallelSubWFConfig;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.json.JSONObject;

public class WFTreeGridViewPage
extends WFBaseTreeGridViewPage {
    protected CodeListConfig wfStepCodeListConfig = null;
    protected CodeListConfig stateCodeListConfig = null;
    protected String strDEWFDataGroup = "";
    protected String strMYWFWork = "";
    public static final String TAG_HISTORYWFWORK = "PAGE.HISTORYWFWORK";
    public static final String TAG_MYEXPAND = "PAGE.MYEXPAND";
    public static final String TAG_MYWFWORKEXPAND = "PAGE.MYWFWORKEXPAND";
    public static final String TAG_HISTORYWFWORKNAME = "PAGE.HISTORYWFWORKNAME";
    public static final String TAG_MYWFWORKTEXTCOLOR = "PAGE.MYWFWORKTEXTCOLOR";
    public static final String TAG_MYWFWORKFIRST = "PAGE.MYWFWORKFIRST";
    public static final String TAG_PAGEWFPARALLELFOLDER = "PAGE.WFPARALLELFOLDER";
    private TreeMap<String, String> wfStateTextMap = new TreeMap();
    private TreeMap<String, String> wfStepTextMap = new TreeMap();
    private TreeMap<String, String> wfStateMap = new TreeMap();
    private TreeMap<String, String> extStateTextMap = new TreeMap();
    private TreeMap<String, String> extCntStateMap = new TreeMap();
    protected WFConfig wfConfig = null;
    protected WFTreeGridViewModel wfTreeGridViewModel = null;
    public static final String PPCTRLID_TREEBAR = "TREEBAR";
    protected PPWFWorkTreeBar ppWFWorkTreeBar = null;
    protected String strDefaultWFGridViewPath = "../srfwf/wfgridview.jsp";

    protected void PreparePageParam() {
        BaseDataEntity pageParam;
        super.PreparePageParam();
        if (this.page != null && (pageParam = this.page.getAdvPageParam(PPCTRLID_TREEBAR, "PP_WFWORKTREEBAR")) != null && pageParam instanceof PPWFWorkTreeBar) {
            this.ppWFWorkTreeBar = (PPWFWorkTreeBar)pageParam;
        }
    }

    @Override
    protected boolean PreparePageEnv() {
        String strPageId;
        String[] wfstates;
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strMYWFWork = this.OnGetMyWFWork();
        this.strDEWFDataGroup = this.OnGetWFDataGroup();
        this.strActiveWFFolder = this.getWebContext().GetParamValue("SRFAF");
        if (StringHelper.IsNullOrEmpty((String)this.strActiveWFFolder)) {
            this.strActiveWFFolder = this.strDEWFDataGroup;
        }
        String strWFState = this.dewf.getWFSTATEVALUE();
        String[] stringArray = wfstates = strWFState.split("[|]");
        int n = wfstates.length;
        int n2 = 0;
        while (n2 < n) {
            String strState = stringArray[n2];
            this.wfStateMap.put(strState, strState);
            ++n2;
        }
        String strExtCntStates = this.dewf.getEXTCNTSTATES();
        if (!StringHelper.IsNullOrEmpty((String)strExtCntStates)) {
            String[] extCntStates;
            String[] stringArray2 = extCntStates = strExtCntStates.split("[|]");
            int n3 = extCntStates.length;
            int n4 = 0;
            while (n4 < n3) {
                String strCntState = stringArray2[n4];
                if (StringHelper.Compare((String)strCntState, (String)"*", (boolean)true) == 0) {
                    this.extCntStateMap.clear();
                    this.extCntStateMap.put(strCntState, strCntState);
                    break;
                }
                this.extCntStateMap.put(strCntState, strCntState);
                ++n4;
            }
        }
        if (this.getDAModelStorage().IsEnableGlobalModel()) {
            Object temp = this.getDAModelStorage().FindGlobalModel("WF0001").FindModel((Object)this.dewf.getWFID());
            if (temp == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e[%2$s]", (Object)"WF0001", (Object)this.dewf.getWFID()));
                return false;
            }
            WFWorkflow workflow = (WFWorkflow)temp;
            this.wfConfig = workflow.getWFConfig();
        }
        if (!this.IsBackEndMode() && !StringHelper.IsNullOrEmpty((String)(strPageId = this.getPageParam("PAGE.WFGRIDVIEW", "")))) {
            Page page = this.getDAModelStorage().FindPage(strPageId);
            if (page == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5185\u7f6e\u9875\u9762[%1$s]", (Object)strPageId));
                return false;
            }
            this.strDefaultWFGridViewPath = page.GetTotalPagePath();
        }
        return true;
    }

    protected PageModel CreatePageModel() {
        return new WFTreeGridViewModel();
    }

    @Override
    protected void PreparePageModel() {
        super.PreparePageModel();
        this.wfTreeGridViewModel = (WFTreeGridViewModel)this.pageModel;
    }

    protected String OnGetMyWFWork() {
        String strMYWFWork = this.dewf.GetMYWFWORK(this.getLanguage());
        if (StringHelper.IsNullOrEmpty((String)strMYWFWork)) {
            strMYWFWork = this.GetLocalization("COMMON.WORKFLOW.MYWORK", "\u6211\u7684\u6d41\u7a0b\u5de5\u4f5c");
        }
        String strKey = StringHelper.Format((String)"%1$s.%2$s", (Object)"PAGE.SECTOR.NAME", (Object)"MYWFWORK");
        return this.getPageParam(strKey, strMYWFWork);
    }

    protected String OnGetWFDataGroup() {
        return this.getPageParam("PAGE.WFDATAGROUP", "MY");
    }

    @Override
    protected boolean OnLoadWFConfig() {
        if (!super.OnLoadWFConfig()) {
            return false;
        }
        IDEHelper deHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper("DE0021");
        if (deHelper == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)"DE0021"));
            return false;
        }
        IDEHelper dewfDEHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper(this.strPageDataEntityId);
        if (dewfDEHelper == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)this.strPageDataEntityId));
            return false;
        }
        IDEFHelper defHelper = dewfDEHelper.GetDEFHelper(this.dewf.getWFSTEPDEFID());
        if (defHelper == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)deHelper.GetFullName(), (Object)this.dewf.getWFSTEPDEFID()));
            return false;
        }
        this.wfStepCodeListConfig = this.getWebContext().getCodeListMgr().GetCodeListConfig(defHelper.GetCodeList(), this.getWebContext().getLocalization());
        if (this.wfStepCodeListConfig == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]\u5931\u8d25", (Object)defHelper.GetCodeList()));
            return false;
        }
        IDEFHelper stateDEFHelper = dewfDEHelper.GetDEFHelper(this.dewf.getSTATEDEFID());
        if (stateDEFHelper == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)deHelper.GetFullName(), (Object)this.dewf.getSTATEDEFID()));
            return false;
        }
        this.stateCodeListConfig = this.getWebContext().getCodeListMgr().GetCodeListConfig(stateDEFHelper.GetCodeList(), this.getWebContext().getLocalization());
        if (this.stateCodeListConfig == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]\u5931\u8d25", (Object)stateDEFHelper.GetCodeList()));
            return false;
        }
        return true;
    }

    @Override
    protected void OnFillTreeMenuConfig(SRFExTreePanel treePanel) {
        if (this.IsOutputWFWorkFirst()) {
            if (this.IsOutputSection("MYWFWORK")) {
                this.OnFillMyWFWorkTreeMenuConfig(treePanel);
            }
            if (this.IsOutputSection(this.strDEWFDataGroup)) {
                this.OnFillTreeMenuConfig(treePanel, this.strDEWFDataGroup);
            }
            if (this.IsOutputHistoryWFWork()) {
                this.OnFillHistoryWFWorkTreeMenuConfig(treePanel);
            }
        } else {
            if (this.IsOutputSection(this.strDEWFDataGroup)) {
                this.OnFillTreeMenuConfig(treePanel, this.strDEWFDataGroup);
            }
            if (this.IsOutputSection("MYWFWORK")) {
                this.OnFillMyWFWorkTreeMenuConfig(treePanel);
            }
            if (this.IsOutputHistoryWFWork()) {
                this.OnFillHistoryWFWorkTreeMenuConfig(treePanel);
            }
        }
    }

    protected void OnFillHistoryWFWorkTreeMenuConfig(SRFExTreePanel treePanel) {
        TreeNodeConfig rootNodeConfig = treePanel.getTreePanelConfig().getRootNodeConfig();
        TreeNodeConfig wfStepTreeNodeConfig = new TreeNodeConfig();
        wfStepTreeNodeConfig.setText(this.OnGetMyHistoryWFWorkName());
        wfStepTreeNodeConfig.setID(StringHelper.Format((String)"%1$s_HISTORY", (Object)"MYWFWORK"));
        rootNodeConfig.AddChildNode(wfStepTreeNodeConfig);
    }

    protected void OnFillMyWFWorkTreeMenuConfig(SRFExTreePanel treePanel) {
        String strMyWFWorkTextColor = this.getPageParam(TAG_MYWFWORKTEXTCOLOR, "red");
        String strNodeTextFormat = "%1$s";
        if (!StringHelper.IsNullOrEmpty((String)strMyWFWorkTextColor)) {
            strNodeTextFormat = String.valueOf(StringHelper.Format((String)"<SPAN style=\"color:%1$s\">", (Object)strMyWFWorkTextColor)) + "%1$s" + "</SPAN>";
        }
        TreeNodeConfig rootNodeConfig = treePanel.getTreePanelConfig().getRootNodeConfig();
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        treeNodeConfig.setText(StringHelper.Format((String)strNodeTextFormat, (Object)this.strMYWFWork));
        treeNodeConfig.setID("MYWFWORK");
        rootNodeConfig.AddChildNode(treeNodeConfig);
        this.wfStateTextMap.put("", StringHelper.Format((String)strNodeTextFormat, (Object)this.strMYWFWork));
        int j = 0;
        while (j < this.wfStepCodeListConfig.getCodeItems().size()) {
            CodeItemConfig wfStepcodeItemConfig = (CodeItemConfig)this.wfStepCodeListConfig.getCodeItems().get(j);
            if (this.IsOutputSection("MYWFWORK", wfStepcodeItemConfig.getValue())) {
                WFBaseProcessConfig baseProcessConfig;
                String strWFStepCodeItemValue = wfStepcodeItemConfig.getValue();
                if (this.wfConfig != null && (baseProcessConfig = this.wfConfig.FindProcessConfigByCodeListItemValue(strWFStepCodeItemValue)) != null && baseProcessConfig instanceof WFParallelSubWFConfig) {
                    this.OnFillMyParallelSubWFWorkTreeMenuConfig(treePanel, treeNodeConfig, wfStepcodeItemConfig, (WFParallelSubWFConfig)baseProcessConfig);
                } else {
                    TreeNodeConfig wfStepTreeNodeConfig = new TreeNodeConfig();
                    wfStepTreeNodeConfig.setText(StringHelper.Format((String)strNodeTextFormat, (Object)wfStepcodeItemConfig.getText()));
                    wfStepTreeNodeConfig.setID(StringHelper.Format((String)"%1$s:%2$s", (Object)"MYWFWORK", (Object)wfStepcodeItemConfig.getValue()));
                    if (!StringHelper.IsNullOrEmpty((String)wfStepcodeItemConfig.getIconCls())) {
                        wfStepTreeNodeConfig.setIconCssClass(wfStepcodeItemConfig.getIconCls());
                    } else if (!StringHelper.IsNullOrEmpty((String)wfStepcodeItemConfig.getIcon())) {
                        wfStepTreeNodeConfig.setIcon(wfStepcodeItemConfig.getIcon());
                    }
                    treeNodeConfig.AddChildNode(wfStepTreeNodeConfig);
                    this.wfStateTextMap.put(wfStepcodeItemConfig.getValue(), StringHelper.Format((String)strNodeTextFormat, (Object)wfStepcodeItemConfig.getText()));
                }
            }
            ++j;
        }
        boolean bExpand = this.getWebContext().getWebExConfig().GetValue("SRFDA.WF", "MYWFWORKEXPAND", true);
        bExpand = this.getPageParam(TAG_MYWFWORKEXPAND, bExpand);
        treeNodeConfig.setExpand(bExpand);
    }

    protected void OnFillMyParallelSubWFWorkTreeMenuConfig(SRFExTreePanel treePanel, TreeNodeConfig treeNodeConfig, CodeItemConfig mainWfStepcodeItemConfig, WFParallelSubWFConfig parallelSubWFConfig) {
        String strMyWFWorkTextColor = this.getPageParam(TAG_MYWFWORKTEXTCOLOR, "red");
        String strNodeTextFormat = "%1$s";
        if (!StringHelper.IsNullOrEmpty((String)strMyWFWorkTextColor)) {
            strNodeTextFormat = String.valueOf(StringHelper.Format((String)"<SPAN style=\"color:%1$s\">", (Object)strMyWFWorkTextColor)) + "%1$s" + "</SPAN>";
        }
        Vector<DESubWF> deSubWFList = new Vector<DESubWF>();
        this.GetDESubWFList(parallelSubWFConfig, deSubWFList);
        boolean bOutputWFParallel = this.IsOutputWFParallelFolder();
        for (DESubWF deSubWf : deSubWFList) {
            IDEFHelper wfStepDEFHelper = this.getDEHelper().GetDEFHelper(deSubWf.getWFSTEPDEFID());
            if (wfStepDEFHelper == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)this.getDEHelper().getId(), (Object)deSubWf.getWFSTEPDEFID()));
                continue;
            }
            String strCodeListId = wfStepDEFHelper.GetCodeList();
            if (StringHelper.IsNullOrEmpty((String)strCodeListId)) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u6ca1\u6709\u627e\u5230\u4ee3\u7801\u8868", (Object)this.getDEHelper().getId(), (Object)deSubWf.getWFSTEPDEFID()));
                continue;
            }
            CodeListConfig codeListConfig = this.getWebContext().getCodeListMgr().GetCodeListConfig(strCodeListId, this.getLanguage());
            if (codeListConfig == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]\u914d\u7f6e", (Object)strCodeListId));
                continue;
            }
            int j = 0;
            while (j < codeListConfig.getCodeItems().size()) {
                CodeItemConfig wfStepcodeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(j);
                TreeNodeConfig wfStepTreeNodeConfig = new TreeNodeConfig();
                if (bOutputWFParallel) {
                    wfStepTreeNodeConfig.setText(StringHelper.Format((String)strNodeTextFormat, (Object)StringHelper.Format((String)"%3$s [%2$s-%1$s]", (Object)mainWfStepcodeItemConfig.getText(), (Object)deSubWf.getDESUBWFNAME(), (Object)wfStepcodeItemConfig.getText())));
                } else {
                    wfStepTreeNodeConfig.setText(StringHelper.Format((String)strNodeTextFormat, (Object)StringHelper.Format((String)"%2$s [%1$s]", (Object)mainWfStepcodeItemConfig.getText(), (Object)wfStepcodeItemConfig.getText())));
                }
                wfStepTreeNodeConfig.setID(StringHelper.Format((String)"%1$s:%2$s:%3$s:%4$s", (Object)"MYWFWORK", (Object)mainWfStepcodeItemConfig.getValue(), (Object)deSubWf.getDESUBWFID(), (Object)wfStepcodeItemConfig.getValue()));
                if (!StringHelper.IsNullOrEmpty((String)wfStepcodeItemConfig.getIconCls())) {
                    wfStepTreeNodeConfig.setIconCssClass(wfStepcodeItemConfig.getIconCls());
                } else if (!StringHelper.IsNullOrEmpty((String)wfStepcodeItemConfig.getIcon())) {
                    wfStepTreeNodeConfig.setIcon(wfStepcodeItemConfig.getIcon());
                }
                treeNodeConfig.AddChildNode(wfStepTreeNodeConfig);
                this.wfStateTextMap.put(StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)mainWfStepcodeItemConfig.getValue(), (Object)deSubWf.getDESUBWFID(), (Object)wfStepcodeItemConfig.getValue()), wfStepTreeNodeConfig.getText());
                ++j;
            }
        }
    }

    @Override
    protected void OnFillTreeMenuConfig(SRFExTreePanel treePanel, String strGroup) {
        TreeNodeConfig rootNodeConfig = treePanel.getTreePanelConfig().getRootNodeConfig();
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        treeNodeConfig.setText(this.OnGetSectorName(strGroup));
        treeNodeConfig.setID(strGroup);
        rootNodeConfig.AddChildNode(treeNodeConfig);
        int i = 0;
        while (i < this.stateCodeListConfig.getCodeItems().size()) {
            CodeItemConfig codeItemConfig = (CodeItemConfig)this.stateCodeListConfig.getCodeItems().get(i);
            if (this.IsOutputSection(strGroup, codeItemConfig.getValue())) {
                TreeNodeConfig stateTreeNodeConfig = new TreeNodeConfig();
                stateTreeNodeConfig.setText(codeItemConfig.getText());
                stateTreeNodeConfig.setID(StringHelper.Format((String)"%1$s:%2$s", (Object)strGroup, (Object)codeItemConfig.getValue()));
                if (!StringHelper.IsNullOrEmpty((String)codeItemConfig.getIconCls())) {
                    stateTreeNodeConfig.setIconCssClass(codeItemConfig.getIconCls());
                } else if (!StringHelper.IsNullOrEmpty((String)codeItemConfig.getIcon())) {
                    stateTreeNodeConfig.setIcon(codeItemConfig.getIcon());
                }
                treeNodeConfig.AddChildNode(stateTreeNodeConfig);
                if (this.wfStateMap.containsKey(codeItemConfig.getValue())) {
                    this.wfStepTextMap.put(StringHelper.Format((String)"%1$s:%2$s", (Object)strGroup, (Object)codeItemConfig.getValue()), codeItemConfig.getText());
                    int j = 0;
                    while (j < this.wfStepCodeListConfig.getCodeItems().size()) {
                        CodeItemConfig wfStepcodeItemConfig = (CodeItemConfig)this.wfStepCodeListConfig.getCodeItems().get(j);
                        if (this.IsOutputSection(strGroup, codeItemConfig.getValue(), wfStepcodeItemConfig.getValue())) {
                            String strWFStepCodeItemValue;
                            WFBaseProcessConfig baseProcessConfig;
                            TreeNodeConfig wfStepTreeNodeConfig = new TreeNodeConfig();
                            wfStepTreeNodeConfig.setText(wfStepcodeItemConfig.getText());
                            wfStepTreeNodeConfig.setID(StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)strGroup, (Object)codeItemConfig.getValue(), (Object)wfStepcodeItemConfig.getValue()));
                            if (!StringHelper.IsNullOrEmpty((String)wfStepcodeItemConfig.getIconCls())) {
                                wfStepTreeNodeConfig.setIconCssClass(wfStepcodeItemConfig.getIconCls());
                            } else if (!StringHelper.IsNullOrEmpty((String)wfStepcodeItemConfig.getIcon())) {
                                wfStepTreeNodeConfig.setIcon(wfStepcodeItemConfig.getIcon());
                            }
                            stateTreeNodeConfig.AddChildNode(wfStepTreeNodeConfig);
                            this.wfStepTextMap.put(StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)strGroup, (Object)codeItemConfig.getValue(), (Object)wfStepcodeItemConfig.getValue()), wfStepcodeItemConfig.getText());
                            if (this.wfConfig != null && (baseProcessConfig = this.wfConfig.FindProcessConfigByCodeListItemValue(strWFStepCodeItemValue = wfStepcodeItemConfig.getValue())) != null && baseProcessConfig instanceof WFParallelSubWFConfig) {
                                this.OnFillWFParallelSubWFTreeMenuConfig(treePanel, wfStepTreeNodeConfig, StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)strGroup, (Object)codeItemConfig.getValue(), (Object)wfStepcodeItemConfig.getValue()), (WFParallelSubWFConfig)baseProcessConfig);
                            }
                        }
                        ++j;
                    }
                    stateTreeNodeConfig.setExpand(true);
                } else if (this.extCntStateMap.size() > 0 && (this.extCntStateMap.containsKey("*") || this.extCntStateMap.containsKey(codeItemConfig.getValue()))) {
                    this.extStateTextMap.put(StringHelper.Format((String)"%1$s:%2$s", (Object)strGroup, (Object)codeItemConfig.getValue()), codeItemConfig.getText());
                }
            }
            ++i;
        }
        boolean bExpand = this.getWebContext().getWebExConfig().GetValue("SRFDA.WF", "MYEXPAND", true);
        bExpand = this.getPageParam(TAG_MYEXPAND, bExpand);
        treeNodeConfig.setExpand(bExpand);
    }

    protected void GetDESubWFList(WFParallelSubWFConfig parallelSubWFConfig, Vector<DESubWF> deSubWFList) {
        DESubWF deSubWF;
        if (parallelSubWFConfig.isEnableSubWF()) {
            deSubWF = this.getDEHelper().GetDESubWF(parallelSubWFConfig.getDESubWFId());
            if (deSubWF != null) {
                deSubWFList.add(deSubWF);
            } else {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7684\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]", (Object)parallelSubWFConfig.getDESubWFId()));
            }
        }
        if (parallelSubWFConfig.isEnableSubWF2()) {
            deSubWF = this.getDEHelper().GetDESubWF(parallelSubWFConfig.getDESubWFId2());
            if (deSubWF != null) {
                deSubWFList.add(deSubWF);
            } else {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7684\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]", (Object)parallelSubWFConfig.getDESubWFId2()));
            }
        }
        if (parallelSubWFConfig.isEnableSubWF3()) {
            deSubWF = this.getDEHelper().GetDESubWF(parallelSubWFConfig.getDESubWFId3());
            if (deSubWF != null) {
                deSubWFList.add(deSubWF);
            } else {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7684\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]", (Object)parallelSubWFConfig.getDESubWFId3()));
            }
        }
        if (parallelSubWFConfig.isEnableSubWF4()) {
            deSubWF = this.getDEHelper().GetDESubWF(parallelSubWFConfig.getDESubWFId4());
            if (deSubWF != null) {
                deSubWFList.add(deSubWF);
            } else {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7684\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]", (Object)parallelSubWFConfig.getDESubWFId4()));
            }
        }
        if (parallelSubWFConfig.isEnableSubWF5()) {
            deSubWF = this.getDEHelper().GetDESubWF(parallelSubWFConfig.getDESubWFId5());
            if (deSubWF != null) {
                deSubWFList.add(deSubWF);
            } else {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7684\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]", (Object)parallelSubWFConfig.getDESubWFId5()));
            }
        }
        if (parallelSubWFConfig.isEnableSubWF6()) {
            deSubWF = this.getDEHelper().GetDESubWF(parallelSubWFConfig.getDESubWFId6());
            if (deSubWF != null) {
                deSubWFList.add(deSubWF);
            } else {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7684\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]", (Object)parallelSubWFConfig.getDESubWFId6()));
            }
        }
        if (parallelSubWFConfig.isEnableSubWF7()) {
            deSubWF = this.getDEHelper().GetDESubWF(parallelSubWFConfig.getDESubWFId7());
            if (deSubWF != null) {
                deSubWFList.add(deSubWF);
            } else {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7684\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]", (Object)parallelSubWFConfig.getDESubWFId7()));
            }
        }
        if (parallelSubWFConfig.isEnableSubWF8()) {
            deSubWF = this.getDEHelper().GetDESubWF(parallelSubWFConfig.getDESubWFId8());
            if (deSubWF != null) {
                deSubWFList.add(deSubWF);
            } else {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7684\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]", (Object)parallelSubWFConfig.getDESubWFId8()));
            }
        }
        if (parallelSubWFConfig.isEnableSubWF9()) {
            deSubWF = this.getDEHelper().GetDESubWF(parallelSubWFConfig.getDESubWFId9());
            if (deSubWF != null) {
                deSubWFList.add(deSubWF);
            } else {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7684\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]", (Object)parallelSubWFConfig.getDESubWFId9()));
            }
        }
    }

    protected void OnFillWFParallelSubWFTreeMenuConfig(SRFExTreePanel treePanel, TreeNodeConfig treeNodeConfig, String strPNodeId, WFParallelSubWFConfig parallelSubWFConfig) {
        Vector<DESubWF> deSubWFList = new Vector<DESubWF>();
        treeNodeConfig.setExpand(true);
        this.GetDESubWFList(parallelSubWFConfig, deSubWFList);
        boolean bOutputWFParallel = this.IsOutputWFParallelFolder();
        for (DESubWF deSubWf : deSubWFList) {
            IDEFHelper wfStepDEFHelper;
            TreeNodeConfig wfParallelSubWfNodeConfig = null;
            if (bOutputWFParallel) {
                wfParallelSubWfNodeConfig = new TreeNodeConfig();
                wfParallelSubWfNodeConfig.setText(deSubWf.getDESUBWFNAME());
                wfParallelSubWfNodeConfig.setID(StringHelper.Format((String)"%1$s:%2$s", (Object)treeNodeConfig.getID(), (Object)deSubWf.getDESUBWFID()));
                treeNodeConfig.AddChildNode(wfParallelSubWfNodeConfig);
                this.wfStepTextMap.put(StringHelper.Format((String)"%1$s:%2$s", (Object)strPNodeId, (Object)deSubWf.getDESUBWFID()), deSubWf.getDESUBWFNAME());
            }
            if ((wfStepDEFHelper = this.getDEHelper().GetDEFHelper(deSubWf.getWFSTEPDEFID())) == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)this.getDEHelper().getId(), (Object)deSubWf.getWFSTEPDEFID()));
                continue;
            }
            String strCodeListId = wfStepDEFHelper.GetCodeList();
            if (StringHelper.IsNullOrEmpty((String)strCodeListId)) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u6ca1\u6709\u627e\u5230\u4ee3\u7801\u8868", (Object)this.getDEHelper().getId(), (Object)deSubWf.getWFSTEPDEFID()));
                continue;
            }
            CodeListConfig codeListConfig = this.getWebContext().getCodeListMgr().GetCodeListConfig(strCodeListId, this.getLanguage());
            if (codeListConfig == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]\u914d\u7f6e", (Object)strCodeListId));
                continue;
            }
            int j = 0;
            while (j < codeListConfig.getCodeItems().size()) {
                CodeItemConfig wfStepcodeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(j);
                TreeNodeConfig wfStepTreeNodeConfig = new TreeNodeConfig();
                wfStepTreeNodeConfig.setText(wfStepcodeItemConfig.getText());
                wfStepTreeNodeConfig.setID(StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)treeNodeConfig.getID(), (Object)deSubWf.getDESUBWFID(), (Object)wfStepcodeItemConfig.getValue()));
                if (!StringHelper.IsNullOrEmpty((String)wfStepcodeItemConfig.getIconCls())) {
                    wfStepTreeNodeConfig.setIconCssClass(wfStepcodeItemConfig.getIconCls());
                } else if (!StringHelper.IsNullOrEmpty((String)wfStepcodeItemConfig.getIcon())) {
                    wfStepTreeNodeConfig.setIcon(wfStepcodeItemConfig.getIcon());
                }
                if (bOutputWFParallel) {
                    wfParallelSubWfNodeConfig.AddChildNode(wfStepTreeNodeConfig);
                } else {
                    treeNodeConfig.AddChildNode(wfStepTreeNodeConfig);
                }
                this.wfStepTextMap.put(StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)strPNodeId, (Object)deSubWf.getDESUBWFID(), (Object)wfStepcodeItemConfig.getValue()), wfStepcodeItemConfig.getText());
                ++j;
            }
        }
    }

    protected void OnFillWFStateDetailTreeMenuConfig(SRFExTreePanel treePanel, TreeNodeConfig treeNodeConfig, String strState) {
    }

    protected String OnGetSectorName(String strGroup) {
        String strKey = StringHelper.Format((String)"%1$s.%2$s.%3$s", (Object)"PAGE.SECTOR.NAME", (Object)strGroup, (Object)this.getWebContext().getLocalization());
        String strName = this.getPageParam(strKey, "");
        if (!StringHelper.IsNullOrEmpty((String)strName)) {
            return strName;
        }
        strKey = StringHelper.Format((String)"%1$s.%2$s", (Object)"PAGE.SECTOR.NAME", (Object)strGroup);
        strName = this.getPageParam(strKey, "");
        if (!StringHelper.IsNullOrEmpty((String)strName)) {
            return strName;
        }
        String strDELogicName = this.getDEHelper().getLogicName(this.getWebContext().getLocalization());
        if (StringHelper.Compare((String)strGroup, (String)"MY", (boolean)true) == 0) {
            return StringHelper.Format((String)this.GetLocalization("PAGE.COMMON.WFEXPLOREVIEW.SECTOR.MY.NAME", "\u6211\u7684%1$s"), (Object)strDELogicName);
        }
        if (StringHelper.Compare((String)strGroup, (String)"ALL", (boolean)true) == 0) {
            return StringHelper.Format((String)this.GetLocalization("PAGE.COMMON.WFEXPLOREVIEW.SECTOR.ALL.NAME", "\u5168\u90e8%1$s"), (Object)strDELogicName);
        }
        return "";
    }

    @Override
    protected void OnFillTabViewConfig(TabViewConfig tabViewConfig) {
        if (this.IsOutputSection(this.strDEWFDataGroup)) {
            this.OnFillTabViewConfig(tabViewConfig, this.strDEWFDataGroup);
        }
        if (this.IsOutputSection("MYWFWORK")) {
            this.OnFillMyWFWorkTabViewConfig(tabViewConfig);
        }
        if (this.IsOutputHistoryWFWork()) {
            this.OnFillHistoryWFWorkTabViewConfig(tabViewConfig);
        }
    }

    protected void OnFillHistoryWFWorkTabViewConfig(TabViewConfig tabViewConfig) {
        try {
            String strIfGridViewPath = "../srfpage/ifgridview2.jsp?REALURL=%1$s";
            TabViewPageConfig wftvpConfig = new TabViewPageConfig();
            wftvpConfig.setID(StringHelper.Format((String)"%1$s_HISTORY", (Object)"MYWFWORK"));
            wftvpConfig.setResourceId("NONE");
            String strPagePath = "../srfpage/gridview.jsp?SRFPAGEID=PAGE_WF0005_G002";
            if (!StringHelper.IsNullOrEmpty((String)strPagePath)) {
                strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"DEID=%1$s&SRFCAPTION=%2$s", (Object)this.getPageDataEntityId(), (Object)URLEncoder.encode(this.OnGetMyHistoryWFWorkName(), "UTF-8"));
                wftvpConfig.setRemoteURL(StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strPagePath, "UTF-8")));
                tabViewConfig.AddTabPage(wftvpConfig);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void OnFillTabViewConfig(TabViewConfig tabViewConfig, String strGroup) {
        try {
            String strIfGridViewPath = "../srfpage/ifgridview2.jsp?REALURL=%1$s";
            TabViewPageConfig tvpConfig = new TabViewPageConfig();
            tvpConfig.setID(strGroup);
            tvpConfig.setResourceId("NONE");
            String strPagePath = this.GetSectorPagePath(strGroup);
            if (!StringHelper.IsNullOrEmpty((String)strPagePath)) {
                strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"SRFSHOWCAP=FALSE&SRFDEID=%1$s&SRFWFDATAGROUP=%2$s&SRFCAPTION=%3$s", (Object)this.getPageDataEntityId(), (Object)strGroup, (Object)URLEncoder.encode(this.OnGetSectorName(strGroup), "UTF-8"));
                tvpConfig.setRemoteURL(StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strPagePath, "UTF-8")));
                tabViewConfig.AddTabPage(tvpConfig);
            }
            int i = 0;
            while (i < this.stateCodeListConfig.getCodeItems().size()) {
                CodeItemConfig codeItemConfig = (CodeItemConfig)this.stateCodeListConfig.getCodeItems().get(i);
                if (this.IsOutputSection(strGroup, codeItemConfig.getValue())) {
                    TabViewPageConfig statetvpConfig = new TabViewPageConfig();
                    statetvpConfig.setID(StringHelper.Format((String)"%1$s:%2$s", (Object)strGroup, (Object)codeItemConfig.getValue()));
                    statetvpConfig.setResourceId("NONE");
                    strPagePath = this.GetSectorPagePath(strGroup, codeItemConfig.getValue());
                    if (!StringHelper.IsNullOrEmpty((String)strPagePath)) {
                        strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                        strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"SRFDEID=%1$s&SRFWFDATAGROUP=%2$s&SRFCAPTION=%3$s&SRFWFSTATEVALUE=%4$s", (Object)this.getPageDataEntityId(), (Object)strGroup, (Object)URLEncoder.encode(codeItemConfig.getText(), "UTF-8"), (Object)codeItemConfig.getValue());
                        statetvpConfig.setRemoteURL(StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strPagePath, "UTF-8")));
                        tabViewConfig.AddTabPage(statetvpConfig);
                    }
                    if (this.wfStateMap.containsKey(codeItemConfig.getValue())) {
                        int j = 0;
                        while (j < this.wfStepCodeListConfig.getCodeItems().size()) {
                            CodeItemConfig wfStepcodeItemConfig = (CodeItemConfig)this.wfStepCodeListConfig.getCodeItems().get(j);
                            if (this.IsOutputSection(strGroup, codeItemConfig.getValue(), wfStepcodeItemConfig.getValue())) {
                                String strWFStepCodeItemValue;
                                WFBaseProcessConfig baseProcessConfig;
                                TabViewPageConfig statesteptvpConfig = new TabViewPageConfig();
                                statesteptvpConfig.setID(StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)strGroup, (Object)codeItemConfig.getValue(), (Object)wfStepcodeItemConfig.getValue()));
                                statesteptvpConfig.setResourceId("NONE");
                                strPagePath = this.GetSectorPagePath(strGroup, codeItemConfig.getValue(), wfStepcodeItemConfig.getValue());
                                if (!StringHelper.IsNullOrEmpty((String)strPagePath)) {
                                    strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                                    strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"SRFDEID=%1$s&SRFWFDATAGROUP=%2$s&SRFCAPTION=%3$s&SRFWFSTATEVALUE=%4$s&SRFWFSTEP=%5$s", (Object)this.getPageDataEntityId(), (Object)strGroup, (Object)URLEncoder.encode(wfStepcodeItemConfig.getText(), "UTF-8"), (Object)codeItemConfig.getValue(), (Object)wfStepcodeItemConfig.getValue());
                                    statesteptvpConfig.setRemoteURL(StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strPagePath, "UTF-8")));
                                    tabViewConfig.AddTabPage(statesteptvpConfig);
                                }
                                if (this.wfConfig != null && (baseProcessConfig = this.wfConfig.FindProcessConfigByCodeListItemValue(strWFStepCodeItemValue = wfStepcodeItemConfig.getValue())) != null && baseProcessConfig instanceof WFParallelSubWFConfig) {
                                    this.OnFillWFParallelSubWFTabViewConfig(tabViewConfig, strGroup, codeItemConfig.getValue(), wfStepcodeItemConfig.getValue(), (WFParallelSubWFConfig)baseProcessConfig);
                                }
                            }
                            ++j;
                        }
                    }
                }
                ++i;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    protected void OnFillMyParallelSubWFWorkTabViewConfig(TabViewConfig tabViewConfig, String strGroup, String strStepValue, WFParallelSubWFConfig parallelSubWFConfig) throws Exception {
        Vector<DESubWF> deSubWFList = new Vector<DESubWF>();
        this.GetDESubWFList(parallelSubWFConfig, deSubWFList);
        String strIfGridViewPath = "../srfpage/ifgridview2.jsp?REALURL=%1$s";
        for (DESubWF deSubWf : deSubWFList) {
            IDEFHelper wfStepDEFHelper = this.getDEHelper().GetDEFHelper(deSubWf.getWFSTEPDEFID());
            if (wfStepDEFHelper == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)this.getDEHelper().getId(), (Object)deSubWf.getWFSTEPDEFID()));
                continue;
            }
            String strCodeListId = wfStepDEFHelper.GetCodeList();
            if (StringHelper.IsNullOrEmpty((String)strCodeListId)) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u6ca1\u6709\u627e\u5230\u4ee3\u7801\u8868", (Object)this.getDEHelper().getId(), (Object)deSubWf.getWFSTEPDEFID()));
                continue;
            }
            CodeListConfig codeListConfig = this.getWebContext().getCodeListMgr().GetCodeListConfig(strCodeListId, this.getLanguage());
            if (codeListConfig == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]\u914d\u7f6e", (Object)strCodeListId));
                continue;
            }
            int j = 0;
            while (j < codeListConfig.getCodeItems().size()) {
                CodeItemConfig wfStepcodeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(j);
                TabViewPageConfig tvpConfig = new TabViewPageConfig();
                tvpConfig.setID(StringHelper.Format((String)"%1$s:%2$s:%3$s:%4$s", (Object)strGroup, (Object)strStepValue, (Object)deSubWf.getDESUBWFID(), (Object)wfStepcodeItemConfig.getValue()));
                tvpConfig.setResourceId("NONE");
                String strPagePath = this.GetSectorPagePath(strGroup, strStepValue, deSubWf.getDESUBWFSN(), wfStepcodeItemConfig.getValue());
                if (!StringHelper.IsNullOrEmpty((String)strPagePath)) {
                    strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                    strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"SRFSHOWCAP=FALSE&SRFDEID=%1$s&SRFWFDATAGROUP=%2$s&SRFCAPTION=%3$s&SRFWFSTEP=%4$s&SRFDESUBWFID=%5$s&SRFWFSUBSTEP=%6$s", (Object)this.getPageDataEntityId(), (Object)strGroup, (Object)URLEncoder.encode(wfStepcodeItemConfig.getText(), "UTF-8"), (Object)strStepValue, (Object)deSubWf.getDESUBWFID(), (Object)wfStepcodeItemConfig.getValue());
                    tvpConfig.setRemoteURL(StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strPagePath, "UTF-8")));
                    tabViewConfig.AddTabPage(tvpConfig);
                }
                ++j;
            }
        }
    }

    protected void OnFillWFParallelSubWFTabViewConfig(TabViewConfig tabViewConfig, String strGroup, String strStateValue, String strStepValue, WFParallelSubWFConfig parallelSubWFConfig) throws Exception {
        Vector<DESubWF> deSubWFList = new Vector<DESubWF>();
        this.GetDESubWFList(parallelSubWFConfig, deSubWFList);
        String strIfGridViewPath = "../srfpage/ifgridview2.jsp?REALURL=%1$s";
        for (DESubWF deSubWf : deSubWFList) {
            IDEFHelper wfStepDEFHelper;
            TabViewPageConfig tvpConfig = new TabViewPageConfig();
            tvpConfig.setID(StringHelper.Format((String)"%1$s:%2$s:%3$s:%4$s", (Object)strGroup, (Object)strStateValue, (Object)strStepValue, (Object)deSubWf.getDESUBWFID()));
            tvpConfig.setResourceId("NONE");
            String strPagePath = this.GetSectorPagePath(strGroup, strStateValue, strStepValue, deSubWf.getDESUBWFSN());
            if (!StringHelper.IsNullOrEmpty((String)strPagePath)) {
                strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"SRFSHOWCAP=FALSE&SRFDEID=%1$s&SRFWFDATAGROUP=%2$s&SRFCAPTION=%3$s&SRFWFSTATEVALUE=%4$s&SRFWFSTEP=%5$s&SRFDESUBWFID=%6$s", (Object)this.getPageDataEntityId(), (Object)strGroup, (Object)URLEncoder.encode(deSubWf.getDESUBWFNAME(), "UTF-8"), (Object)strStateValue, (Object)strStepValue, (Object)deSubWf.getDESUBWFID());
                tvpConfig.setRemoteURL(StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strPagePath, "UTF-8")));
                tabViewConfig.AddTabPage(tvpConfig);
            }
            if ((wfStepDEFHelper = this.getDEHelper().GetDEFHelper(deSubWf.getWFSTEPDEFID())) == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)this.getDEHelper().getId(), (Object)deSubWf.getWFSTEPDEFID()));
                continue;
            }
            String strCodeListId = wfStepDEFHelper.GetCodeList();
            if (StringHelper.IsNullOrEmpty((String)strCodeListId)) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u6ca1\u6709\u627e\u5230\u4ee3\u7801\u8868", (Object)this.getDEHelper().getId(), (Object)deSubWf.getWFSTEPDEFID()));
                continue;
            }
            CodeListConfig codeListConfig = this.getWebContext().getCodeListMgr().GetCodeListConfig(strCodeListId, this.getLanguage());
            if (codeListConfig == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]\u914d\u7f6e", (Object)strCodeListId));
                continue;
            }
            int j = 0;
            while (j < codeListConfig.getCodeItems().size()) {
                CodeItemConfig wfStepcodeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(j);
                TabViewPageConfig tvpConfig2 = new TabViewPageConfig();
                tvpConfig2.setID(StringHelper.Format((String)"%1$s:%2$s:%3$s:%4$s:%5$s", (Object)strGroup, (Object)strStateValue, (Object)strStepValue, (Object)deSubWf.getDESUBWFID(), (Object)wfStepcodeItemConfig.getValue()));
                tvpConfig2.setResourceId("NONE");
                String strPagePath2 = this.GetSectorPagePath(strGroup, strStateValue, strStepValue, deSubWf.getDESUBWFSN(), wfStepcodeItemConfig.getValue());
                if (!StringHelper.IsNullOrEmpty((String)strPagePath2)) {
                    strPagePath2 = URLHelper.AppendURLSeperator((String)strPagePath2);
                    strPagePath2 = String.valueOf(strPagePath2) + StringHelper.Format((String)"SRFSHOWCAP=FALSE&SRFDEID=%1$s&SRFWFDATAGROUP=%2$s&SRFCAPTION=%3$s&SRFWFSTATEVALUE=%4$s&SRFWFSTEP=%5$s&SRFDESUBWFID=%6$s&SRFWFSUBSTEP=%7$s", (Object)this.getPageDataEntityId(), (Object)strGroup, (Object)URLEncoder.encode(wfStepcodeItemConfig.getText(), "UTF-8"), (Object)strStateValue, (Object)strStepValue, (Object)deSubWf.getDESUBWFID(), (Object)wfStepcodeItemConfig.getValue());
                    tvpConfig2.setRemoteURL(StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strPagePath2, "UTF-8")));
                    tabViewConfig.AddTabPage(tvpConfig2);
                }
                ++j;
            }
        }
    }

    protected void OnFillMyWFWorkTabViewConfig(TabViewConfig tabViewConfig) {
        try {
            String strIfGridViewPath = "../srfpage/ifgridview2.jsp?REALURL=%1$s";
            TabViewPageConfig tvpConfig = new TabViewPageConfig();
            tvpConfig.setID("MYWFWORK");
            tvpConfig.setResourceId("NONE");
            String strPagePath = this.GetSectorPagePath("MYWFWORK");
            if (!StringHelper.IsNullOrEmpty((String)strPagePath)) {
                strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"SRFDEID=%1$s&SRFCAPTION=%2$s&SRFWFSTATEVALUE=%3$s&SRFWFDATAGROUP=MYWFWORK", (Object)this.getPageDataEntityId(), (Object)URLEncoder.encode(this.strMYWFWork, "UTF-8"), (Object)this.dewf.getWFSTATEVALUE());
                tvpConfig.setRemoteURL(StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strPagePath, "UTF-8")));
                tabViewConfig.AddTabPage(tvpConfig);
            }
            int j = 0;
            while (j < this.wfStepCodeListConfig.getCodeItems().size()) {
                CodeItemConfig wfStepcodeItemConfig = (CodeItemConfig)this.wfStepCodeListConfig.getCodeItems().get(j);
                if (this.IsOutputSection("MYWFWORK", wfStepcodeItemConfig.getValue())) {
                    String strWFStepCodeItemValue;
                    WFBaseProcessConfig baseProcessConfig;
                    TabViewPageConfig wftvpConfig = new TabViewPageConfig();
                    wftvpConfig.setID(StringHelper.Format((String)"%1$s:%2$s", (Object)"MYWFWORK", (Object)wfStepcodeItemConfig.getValue()));
                    wftvpConfig.setResourceId("NONE");
                    strPagePath = this.GetSectorPagePath("MYWFWORK", wfStepcodeItemConfig.getValue());
                    if (!StringHelper.IsNullOrEmpty((String)strPagePath)) {
                        strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                        strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"SRFDEID=%1$s&SRFCAPTION=%2$s&SRFWFSTATEVALUE=%3$s&SRFWFSTEP=%4$s&SRFWFDATAGROUP=MYWFWORK", (Object)this.getPageDataEntityId(), (Object)URLEncoder.encode(wfStepcodeItemConfig.getText(), "UTF-8"), (Object)this.dewf.getWFSTATEVALUE(), (Object)wfStepcodeItemConfig.getValue());
                        wftvpConfig.setRemoteURL(StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strPagePath, "UTF-8")));
                        tabViewConfig.AddTabPage(wftvpConfig);
                    }
                    if (this.wfConfig != null && (baseProcessConfig = this.wfConfig.FindProcessConfigByCodeListItemValue(strWFStepCodeItemValue = wfStepcodeItemConfig.getValue())) != null && baseProcessConfig instanceof WFParallelSubWFConfig) {
                        this.OnFillMyParallelSubWFWorkTabViewConfig(tabViewConfig, "MYWFWORK", wfStepcodeItemConfig.getValue(), (WFParallelSubWFConfig)baseProcessConfig);
                    }
                }
                ++j;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String GetWFDataName() {
        return this.getDEHelper().getLogicName(this.getWebContext().getLocalization());
    }

    protected boolean IsOutputHistoryWFWork() {
        boolean bOutputHistoryWFWork = false;
        if (this.ppWFWorkTreeBar != null && !this.ppWFWorkTreeBar.isWFHISTORYWORKNull()) {
            bOutputHistoryWFWork = this.ppWFWorkTreeBar.getWFHISTORYWORK();
        }
        return this.getPageParam(TAG_HISTORYWFWORK, bOutputHistoryWFWork);
    }

    protected boolean IsOutputWFWorkFirst() {
        boolean bOutputWFWorkFirst = false;
        if (this.ppWFWorkTreeBar != null && !this.ppWFWorkTreeBar.isMYWFWORKFIRSTNull()) {
            bOutputWFWorkFirst = this.ppWFWorkTreeBar.getMYWFWORKFIRST();
        }
        return this.getPageParam(TAG_MYWFWORKFIRST, bOutputWFWorkFirst);
    }

    protected boolean IsOutputWFParallelFolder() {
        boolean bOutputWFParallelFolder = false;
        if (this.ppWFWorkTreeBar != null && !this.ppWFWorkTreeBar.isWFPARALLELFOLDERNull()) {
            bOutputWFParallelFolder = this.ppWFWorkTreeBar.getWFPARALLELFOLDER();
        }
        return this.getPageParam(TAG_PAGEWFPARALLELFOLDER, bOutputWFParallelFolder);
    }

    protected boolean IsOutputSection(String strGroup) {
        PPWFWorkTreeNode ppWFWorkTreeNode;
        boolean bOutput = true;
        if (this.ppWFWorkTreeBar != null && (ppWFWorkTreeNode = this.ppWFWorkTreeBar.FindPPWFWorkTreeNode(strGroup, "")) != null && !ppWFWorkTreeNode.isOUTPUTFLAGNull()) {
            bOutput = ppWFWorkTreeNode.getOUTPUTFLAG();
        }
        String strParamName = StringHelper.Format((String)"%1$s.%2$s", (Object)"PAGE.SECTOR", (Object)strGroup);
        return this.getPageParam(strParamName, bOutput);
    }

    protected boolean IsOutputSection(String strGroup, String strState) {
        PPWFWorkTreeNode ppWFWorkTreeNode;
        boolean bOutput = true;
        if (this.ppWFWorkTreeBar != null && (ppWFWorkTreeNode = this.ppWFWorkTreeBar.FindPPWFWorkTreeNode(strGroup, strState)) != null && !ppWFWorkTreeNode.isOUTPUTFLAGNull()) {
            bOutput = ppWFWorkTreeNode.getOUTPUTFLAG();
        }
        String strParamName = StringHelper.Format((String)"%1$s.%2$s:%3$s", (Object)"PAGE.SECTOR", (Object)strGroup, (Object)strState);
        return this.getPageParam(strParamName, bOutput);
    }

    protected boolean IsOutputSection(String strGroup, String strState, String strWFStep) {
        String strKey;
        PPWFWorkTreeNode ppWFWorkTreeNode;
        boolean bOutput = true;
        if (this.ppWFWorkTreeBar != null && (ppWFWorkTreeNode = this.ppWFWorkTreeBar.FindPPWFWorkTreeNode(strGroup, strKey = StringHelper.Format((String)"%1$s:%2$s", (Object)strState, (Object)strWFStep))) != null && !ppWFWorkTreeNode.isOUTPUTFLAGNull()) {
            bOutput = ppWFWorkTreeNode.getOUTPUTFLAG();
        }
        String strParamName = StringHelper.Format((String)"%1$s.%2$s:%3$s:%4$s", (Object)"PAGE.SECTOR", (Object)strGroup, (Object)strState, (Object)strWFStep);
        return this.getPageParam(strParamName, bOutput);
    }

    protected String GetSectorPagePath(String strGroup) {
        PPWFWorkTreeNode ppWFWorkTreeNode;
        String strPageId = "";
        if (this.ppWFWorkTreeBar != null && (ppWFWorkTreeNode = this.ppWFWorkTreeBar.FindPPWFWorkTreeNode(strGroup, "")) != null) {
            strPageId = ppWFWorkTreeNode.getPAGEID();
        }
        if (!StringHelper.IsNullOrEmpty((String)(strPageId = this.getPageParam(StringHelper.Format((String)"%1$s.%2$s", (Object)"PAGE.SECTOR.PAGE", (Object)strGroup), strPageId)))) {
            Page page = this.getDAModelStorage().FindPage(strPageId);
            if (page == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strPageId));
                return "";
            }
            return page.GetTotalPagePath();
        }
        return this.strDefaultWFGridViewPath;
    }

    protected String GetSectorPagePath(String strGroup, String strState) {
        PPWFWorkTreeNode ppWFWorkTreeNode;
        String strPageId = "";
        if (this.ppWFWorkTreeBar != null && (ppWFWorkTreeNode = this.ppWFWorkTreeBar.FindPPWFWorkTreeNode(strGroup, strState)) != null) {
            strPageId = ppWFWorkTreeNode.getPAGEID();
        }
        if (!StringHelper.IsNullOrEmpty((String)(strPageId = this.getPageParam(StringHelper.Format((String)"%1$s.%2$s:%3$s", (Object)"PAGE.SECTOR.PAGE", (Object)strGroup, (Object)strState), strPageId)))) {
            Page page = this.getDAModelStorage().FindPage(strPageId);
            if (page == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strPageId));
                return "";
            }
            return page.GetTotalPagePath();
        }
        return this.strDefaultWFGridViewPath;
    }

    protected String GetSectorPagePath(String strGroup, String strState, String strStep) {
        String strKey;
        PPWFWorkTreeNode ppWFWorkTreeNode;
        String strPageId = "";
        if (this.ppWFWorkTreeBar != null && (ppWFWorkTreeNode = this.ppWFWorkTreeBar.FindPPWFWorkTreeNode(strGroup, strKey = StringHelper.Format((String)"%1$s:%2$s", (Object)strState, (Object)strStep))) != null) {
            strPageId = ppWFWorkTreeNode.getPAGEID();
        }
        if (!StringHelper.IsNullOrEmpty((String)(strPageId = this.getPageParam(StringHelper.Format((String)"%1$s.%2$s:%3$s:%4$s", (Object)"PAGE.SECTOR.PAGE", (Object)strGroup, (Object)strState, (Object)strStep), strPageId)))) {
            Page page = this.getDAModelStorage().FindPage(strPageId);
            if (page == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strPageId));
                return "";
            }
            return page.GetTotalPagePath();
        }
        return this.strDefaultWFGridViewPath;
    }

    protected String GetSectorPagePath(String strGroup, String strState, String strStep, String strDESubWfSN) {
        String strKey;
        PPWFWorkTreeNode ppWFWorkTreeNode;
        String strPageId = "";
        if (this.ppWFWorkTreeBar != null && (ppWFWorkTreeNode = this.ppWFWorkTreeBar.FindPPWFWorkTreeNode(strGroup, strKey = StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)strState, (Object)strStep, (Object)strDESubWfSN))) != null) {
            strPageId = ppWFWorkTreeNode.getPAGEID();
        }
        if (!StringHelper.IsNullOrEmpty((String)(strPageId = this.getPageParam(StringHelper.Format((String)"%1$s.%2$s:%3$s:%4$s:%5$s", (Object)"PAGE.SECTOR.PAGE", (Object)strGroup, (Object)strState, (Object)strStep, (Object)strDESubWfSN), strPageId)))) {
            Page page = this.getDAModelStorage().FindPage(strPageId);
            if (page == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strPageId));
                return "";
            }
            return page.GetTotalPagePath();
        }
        return this.strDefaultWFGridViewPath;
    }

    protected String GetSectorPagePath(String strGroup, String strState, String strStep, String strDESubWfSN, String strSubStep) {
        String strKey;
        PPWFWorkTreeNode ppWFWorkTreeNode;
        String strPageId = "";
        if (this.ppWFWorkTreeBar != null && (ppWFWorkTreeNode = this.ppWFWorkTreeBar.FindPPWFWorkTreeNode(strGroup, strKey = StringHelper.Format((String)"%1$s:%2$s:%3$s:%4$s", (Object)strState, (Object)strStep, (Object)strDESubWfSN, (Object)strSubStep))) != null) {
            strPageId = ppWFWorkTreeNode.getPAGEID();
        }
        if (!StringHelper.IsNullOrEmpty((String)(strPageId = this.getPageParam(StringHelper.Format((String)"%1$s.%2$s:%3$s:%4$s:%5$s:%6$s", (Object)"PAGE.SECTOR.PAGE", (Object)strGroup, (Object)strState, (Object)strStep, (Object)strDESubWfSN, (Object)strSubStep), strPageId)))) {
            Page page = this.getDAModelStorage().FindPage(strPageId);
            if (page == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strPageId));
                return "";
            }
            return page.GetTotalPagePath();
        }
        return this.strDefaultWFGridViewPath;
    }

    protected String OnGetMyHistoryWFWorkName() {
        String strMyHistoryWFWorkName = "";
        if (this.ppWFWorkTreeBar != null) {
            strMyHistoryWFWorkName = this.ppWFWorkTreeBar.getHISTORYWFWORKNAME();
        }
        if (StringHelper.IsNullOrEmpty((String)strMyHistoryWFWorkName)) {
            strMyHistoryWFWorkName = "\u5386\u53f2\u6d41\u7a0b\u5de5\u4f5c";
        }
        return this.getPageParam(TAG_HISTORYWFWORKNAME, strMyHistoryWFWorkName);
    }

    @Override
    protected void OnInit() {
        String strStep;
        String[] parts;
        super.OnInit();
        StringBuilderEx script = new StringBuilderEx();
        script.Append("var bupdatewftree=false;\r\n");
        script.Append("function updatewftree(_1){\r\n");
        script.Append("if(bupdatewftree)return;\r\n");
        script.Append("bupdatewftree=true;\r\n");
        script.Append("updatewftree2(_1);");
        script.Append("bupdatewftree=false;\r\n");
        script.Append("}");
        script.Append("function updatewftree2(_1){\r\n");
        script.Append("var tree=$P.tree['%1$s'];\r\n", (Object)this.treePanel.getUniqueID());
        script.Append("if(!tree)return;\r\n");
        script.Append("var cnt='';\r\n");
        script.Append("var text='';\r\n");
        script.Append("var treeNode=null;\r\n");
        for (String strCode : this.wfStateTextMap.keySet()) {
            script.Append("cnt = $V(_1['V%1$s'],'');\r\n", (Object)strCode.replace(":", "_"));
            String strNodeId = "";
            strNodeId = StringHelper.IsNullOrEmpty((String)strCode) ? "MYWFWORK" : StringHelper.Format((String)"%1$s:%2$s", (Object)"MYWFWORK", (Object)strCode);
            script.Append("treeNode=tree.getNodeById('%1$s');if(treeNode!=null){treeNode.setText(gettreenodetext('%2$s',cnt));showtreenode(treeNode,cnt!='');}\r\n", (Object)strNodeId, (Object)this.wfStateTextMap.get(strCode));
        }
        for (String strNodeId : this.wfStepTextMap.keySet()) {
            parts = strNodeId.split("[:]");
            strStep = "";
            if (parts.length == 3) {
                strStep = parts[2];
            }
            if (parts.length > 3) {
                int i = 2;
                while (i < parts.length) {
                    if (!StringHelper.IsNullOrEmpty((String)strStep)) {
                        strStep = String.valueOf(strStep) + "_";
                    }
                    strStep = String.valueOf(strStep) + parts[i];
                    ++i;
                }
            }
            script.Append("cnt = $V(_1['S%1$s'],'');\r\n", (Object)strStep);
            script.Append("treeNode=tree.getNodeById('%1$s');if(treeNode!=null){treeNode.setText(gettreenodetext('%2$s',cnt));}\r\n", (Object)strNodeId, (Object)this.wfStepTextMap.get(strNodeId));
        }
        for (String strNodeId : this.extStateTextMap.keySet()) {
            parts = strNodeId.split("[:]");
            strStep = "";
            if (parts.length == 2) {
                strStep = parts[1];
            }
            script.Append("cnt = $V(_1['E%1$s'],'');\r\n", (Object)strStep);
            script.Append("treeNode=tree.getNodeById('%1$s');if(treeNode!=null){treeNode.setText(gettreenodetext('%2$s',cnt));}\r\n", (Object)strNodeId, (Object)this.extStateTextMap.get(strNodeId));
        }
        script.Append("}");
        script.Append("function refreshwftree(){\r\n");
        script.Append("var varUpdate = new Ext.UpdateManager(\"update\");\r\n");
        script.Append("varUpdate.update({url:'../srfwf/wfhelper.jsp?DEID=%2$s&WFID=%1$s&MAJORACTION=WFSTEPCOUNT',scripts:true,nocache:true});\r\n", (Object)this.dewf.getWFID(), (Object)this.dewf.getDEID());
        script.Append("}");
        this.RegisterScript(1, script.toString());
    }

    @Override
    public String GetUpdateCode() {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("var varUpdate=new Ext.UpdateManager(\"update\");\r\n");
        script.Append("varUpdate.startAutoRefresh(60,{url:'../srfwf/wfhelper.jsp?DEID=%2$s&WFID=%1$s&MAJORACTION=WFSTEPCOUNT',scripts:true,nocache:true},null,null,true);\r\n", (Object)this.dewf.getWFID(), (Object)this.dewf.getDEID());
        return script.toString();
    }

    protected void OnFillTreeMenuModel(XMLNode rootNode) {
        rootNode.setNodeName("SRFEXTREENODE");
        if (this.IsOutputWFWorkFirst()) {
            if (this.IsOutputSection("MYWFWORK")) {
                this.OnFillMyWFWorkTreeMenuModel(rootNode);
            }
            if (this.IsOutputSection(this.strDEWFDataGroup)) {
                this.OnFillTreeMenuModel(rootNode, this.strDEWFDataGroup);
            }
            if (this.IsOutputHistoryWFWork()) {
                XMLNode wfStepTreeNodeConfig = new XMLNode();
                wfStepTreeNodeConfig.setNodeName("SRFEXTREENODE");
                wfStepTreeNodeConfig.SetValue("TEXT", this.OnGetMyHistoryWFWorkName());
                wfStepTreeNodeConfig.setID(StringHelper.Format((String)"%1$s_HISTORY", (Object)"MYWFWORK"));
                rootNode.AddNode(wfStepTreeNodeConfig);
            }
        } else {
            if (this.IsOutputSection(this.strDEWFDataGroup)) {
                this.OnFillTreeMenuModel(rootNode, this.strDEWFDataGroup);
            }
            if (this.IsOutputSection("MYWFWORK")) {
                this.OnFillMyWFWorkTreeMenuModel(rootNode);
            }
            if (this.IsOutputHistoryWFWork()) {
                XMLNode wfStepTreeNodeConfig = new XMLNode();
                wfStepTreeNodeConfig.setNodeName("SRFEXTREENODE");
                wfStepTreeNodeConfig.SetValue("TEXT", this.OnGetMyHistoryWFWorkName());
                wfStepTreeNodeConfig.setID(StringHelper.Format((String)"%1$s_HISTORY", (Object)"MYWFWORK"));
                rootNode.AddNode(wfStepTreeNodeConfig);
            }
        }
    }

    protected void OnFillMyWFWorkTreeMenuModel(XMLNode rootNode) {
        String strNodeTextFormat = "%1$s";
        XMLNode treeNodeConfig = new XMLNode();
        treeNodeConfig.setNodeName("SRFEXTREENODE");
        treeNodeConfig.SetValue("TEXT", StringHelper.Format((String)strNodeTextFormat, (Object)this.strMYWFWork));
        treeNodeConfig.SetValue("CSSCLASS", "WFMyWorkTreeNodeText");
        treeNodeConfig.setID("MYWFWORK");
        treeNodeConfig.SetValue("COUNTERID", "V");
        rootNode.AddNode(treeNodeConfig);
        int j = 0;
        while (j < this.wfStepCodeListConfig.getCodeItems().size()) {
            CodeItemConfig wfStepcodeItemConfig = (CodeItemConfig)this.wfStepCodeListConfig.getCodeItems().get(j);
            if (this.IsOutputSection("MYWFWORK", wfStepcodeItemConfig.getValue())) {
                WFBaseProcessConfig baseProcessConfig;
                String strWFStepCodeItemValue = wfStepcodeItemConfig.getValue();
                if (this.wfConfig != null && (baseProcessConfig = this.wfConfig.FindProcessConfigByCodeListItemValue(strWFStepCodeItemValue)) != null && baseProcessConfig instanceof WFParallelSubWFConfig) {
                    this.OnFillMyParallelSubWFWorkTreeMenuMode(treeNodeConfig, wfStepcodeItemConfig, (WFParallelSubWFConfig)baseProcessConfig);
                } else {
                    XMLNode wfStepTreeNodeConfig = new XMLNode();
                    wfStepTreeNodeConfig.setNodeName("SRFEXTREENODE");
                    wfStepTreeNodeConfig.SetValue("CSSCLASS", "WFMyWorkTreeNodeText");
                    wfStepTreeNodeConfig.SetValue("TEXT", StringHelper.Format((String)strNodeTextFormat, (Object)wfStepcodeItemConfig.getText()));
                    wfStepTreeNodeConfig.setID(StringHelper.Format((String)"%1$s:%2$s", (Object)"MYWFWORK", (Object)wfStepcodeItemConfig.getValue()));
                    if (!StringHelper.IsNullOrEmpty((String)wfStepcodeItemConfig.getIconCls())) {
                        wfStepTreeNodeConfig.SetValue("ICONCSSCLASS", wfStepcodeItemConfig.getIconCls());
                    } else if (!StringHelper.IsNullOrEmpty((String)wfStepcodeItemConfig.getIcon())) {
                        wfStepTreeNodeConfig.SetValue("ICON", wfStepcodeItemConfig.getIcon());
                    }
                    wfStepTreeNodeConfig.SetValue("COUNTERID", StringHelper.Format((String)"V%1$s", (Object)wfStepcodeItemConfig.getValue().replace(":", "_")));
                    treeNodeConfig.AddNode(wfStepTreeNodeConfig);
                }
            }
            ++j;
        }
        boolean bExpand = this.getWebContext().getWebExConfig().GetValue("SRFDA.WF", "MYWFWORKEXPAND", true);
        treeNodeConfig.SetValue("EXPAND", (bExpand = this.getPageParam(TAG_MYWFWORKEXPAND, bExpand)) ? "TRUE" : "FALSE");
    }

    protected void OnFillMyParallelSubWFWorkTreeMenuMode(XMLNode treeNodeConfig, CodeItemConfig mainWfStepcodeItemConfig, WFParallelSubWFConfig parallelSubWFConfig) {
        String strNodeTextFormat = "%1$s";
        Vector<DESubWF> deSubWFList = new Vector<DESubWF>();
        this.GetDESubWFList(parallelSubWFConfig, deSubWFList);
        boolean bOutputWFParallel = this.IsOutputWFParallelFolder();
        for (DESubWF deSubWf : deSubWFList) {
            IDEFHelper wfStepDEFHelper = this.getDEHelper().GetDEFHelper(deSubWf.getWFSTEPDEFID());
            if (wfStepDEFHelper == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)this.getDEHelper().getId(), (Object)deSubWf.getWFSTEPDEFID()));
                continue;
            }
            String strCodeListId = wfStepDEFHelper.GetCodeList();
            if (StringHelper.IsNullOrEmpty((String)strCodeListId)) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u6ca1\u6709\u627e\u5230\u4ee3\u7801\u8868", (Object)this.getDEHelper().getId(), (Object)deSubWf.getWFSTEPDEFID()));
                continue;
            }
            CodeListConfig codeListConfig = this.getWebContext().getCodeListMgr().GetCodeListConfig(strCodeListId, this.getLanguage());
            if (codeListConfig == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]\u914d\u7f6e", (Object)strCodeListId));
                continue;
            }
            int j = 0;
            while (j < codeListConfig.getCodeItems().size()) {
                CodeItemConfig wfStepcodeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(j);
                XMLNode wfStepTreeNodeConfig = new XMLNode();
                wfStepTreeNodeConfig.setNodeName("SRFEXTREENODE");
                wfStepTreeNodeConfig.SetValue("CSSCLASS", "WFMyWorkTreeNodeText");
                if (bOutputWFParallel) {
                    wfStepTreeNodeConfig.SetValue("TEXT", StringHelper.Format((String)strNodeTextFormat, (Object)StringHelper.Format((String)"%3$s [%2$s-%1$s]", (Object)mainWfStepcodeItemConfig.getText(), (Object)deSubWf.getDESUBWFNAME(), (Object)wfStepcodeItemConfig.getText())));
                } else {
                    wfStepTreeNodeConfig.SetValue("TEXT", StringHelper.Format((String)strNodeTextFormat, (Object)StringHelper.Format((String)"%2$s [%1$s]", (Object)mainWfStepcodeItemConfig.getText(), (Object)wfStepcodeItemConfig.getText())));
                }
                wfStepTreeNodeConfig.setID(StringHelper.Format((String)"%1$s:%2$s:%3$s:%4$s", (Object)"MYWFWORK", (Object)mainWfStepcodeItemConfig.getValue(), (Object)deSubWf.getDESUBWFID(), (Object)wfStepcodeItemConfig.getValue()));
                if (!StringHelper.IsNullOrEmpty((String)wfStepcodeItemConfig.getIconCls())) {
                    wfStepTreeNodeConfig.SetValue("ICONCSSCLASS", wfStepcodeItemConfig.getIconCls());
                } else if (!StringHelper.IsNullOrEmpty((String)wfStepcodeItemConfig.getIcon())) {
                    wfStepTreeNodeConfig.SetValue("ICON", wfStepcodeItemConfig.getIcon());
                }
                wfStepTreeNodeConfig.SetValue("COUNTERID", StringHelper.Format((String)"V%1$s", (Object)StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)mainWfStepcodeItemConfig.getValue(), (Object)deSubWf.getDESUBWFID(), (Object)wfStepcodeItemConfig.getValue()).replace(":", "_")));
                treeNodeConfig.AddNode(wfStepTreeNodeConfig);
                ++j;
            }
        }
    }

    protected void OnFillTreeMenuModel(XMLNode rootNode, String strGroup) {
        XMLNode treeNodeConfig = new XMLNode();
        treeNodeConfig.setNodeName("SRFEXTREENODE");
        treeNodeConfig.SetValue("TEXT", this.OnGetSectorName(strGroup));
        treeNodeConfig.setID(strGroup);
        treeNodeConfig.SetValue("CSSCLASS", "WFTreeNodeText");
        rootNode.AddNode(treeNodeConfig);
        int i = 0;
        while (i < this.stateCodeListConfig.getCodeItems().size()) {
            CodeItemConfig codeItemConfig = (CodeItemConfig)this.stateCodeListConfig.getCodeItems().get(i);
            if (this.IsOutputSection(strGroup, codeItemConfig.getValue())) {
                XMLNode stateTreeNodeConfig = new XMLNode();
                stateTreeNodeConfig.setNodeName("SRFEXTREENODE");
                stateTreeNodeConfig.SetValue("TEXT", codeItemConfig.getText());
                stateTreeNodeConfig.setID(StringHelper.Format((String)"%1$s:%2$s", (Object)strGroup, (Object)codeItemConfig.getValue()));
                stateTreeNodeConfig.SetValue("CSSCLASS", "WFTreeNodeText");
                if (!StringHelper.IsNullOrEmpty((String)codeItemConfig.getIconCls())) {
                    stateTreeNodeConfig.SetValue("ICONCSSCLASS", codeItemConfig.getIconCls());
                } else if (!StringHelper.IsNullOrEmpty((String)codeItemConfig.getIcon())) {
                    stateTreeNodeConfig.SetValue("ICON", codeItemConfig.getIcon());
                }
                treeNodeConfig.AddNode(stateTreeNodeConfig);
                if (this.wfStateMap.containsKey(codeItemConfig.getValue())) {
                    stateTreeNodeConfig.SetValue("COUNTERID", WFTreeGridViewPage.GetWFStepCounterId(StringHelper.Format((String)"%1$s:%2$s", (Object)strGroup, (Object)codeItemConfig.getValue())));
                    int j = 0;
                    while (j < this.wfStepCodeListConfig.getCodeItems().size()) {
                        CodeItemConfig wfStepcodeItemConfig = (CodeItemConfig)this.wfStepCodeListConfig.getCodeItems().get(j);
                        if (this.IsOutputSection(strGroup, codeItemConfig.getValue(), wfStepcodeItemConfig.getValue())) {
                            String strWFStepCodeItemValue;
                            WFBaseProcessConfig baseProcessConfig;
                            XMLNode wfStepTreeNodeConfig = new XMLNode();
                            wfStepTreeNodeConfig.setNodeName("SRFEXTREENODE");
                            wfStepTreeNodeConfig.SetValue("TEXT", wfStepcodeItemConfig.getText());
                            wfStepTreeNodeConfig.setID(StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)strGroup, (Object)codeItemConfig.getValue(), (Object)wfStepcodeItemConfig.getValue()));
                            wfStepTreeNodeConfig.SetValue("CSSCLASS", "WFTreeNodeText");
                            if (!StringHelper.IsNullOrEmpty((String)wfStepcodeItemConfig.getIconCls())) {
                                wfStepTreeNodeConfig.SetValue("ICONCSSCLASS", wfStepcodeItemConfig.getIconCls());
                            } else if (!StringHelper.IsNullOrEmpty((String)wfStepcodeItemConfig.getIcon())) {
                                wfStepTreeNodeConfig.SetValue("ICON", wfStepcodeItemConfig.getIcon());
                            }
                            wfStepTreeNodeConfig.SetValue("COUNTERID", WFTreeGridViewPage.GetWFStepCounterId(StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)strGroup, (Object)codeItemConfig.getValue(), (Object)wfStepcodeItemConfig.getValue())));
                            stateTreeNodeConfig.AddNode(wfStepTreeNodeConfig);
                            if (this.wfConfig != null && (baseProcessConfig = this.wfConfig.FindProcessConfigByCodeListItemValue(strWFStepCodeItemValue = wfStepcodeItemConfig.getValue())) != null && baseProcessConfig instanceof WFParallelSubWFConfig) {
                                this.OnFillWFParallelSubWFTreeMenuModel(wfStepTreeNodeConfig, StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)strGroup, (Object)codeItemConfig.getValue(), (Object)wfStepcodeItemConfig.getValue()), (WFParallelSubWFConfig)baseProcessConfig);
                            }
                        }
                        ++j;
                    }
                    stateTreeNodeConfig.SetValue("EXPAND", "TRUE");
                } else if (this.extCntStateMap.size() > 0 && (this.extCntStateMap.containsKey("*") || this.extCntStateMap.containsKey(codeItemConfig.getValue()))) {
                    stateTreeNodeConfig.SetValue("COUNTERID", WFTreeGridViewPage.GetWFStepCounterId2(StringHelper.Format((String)"%1$s:%2$s", (Object)strGroup, (Object)codeItemConfig.getValue())));
                }
            }
            ++i;
        }
        boolean bExpand = this.getWebContext().getWebExConfig().GetValue("SRFDA.WF", "MYEXPAND", true);
        treeNodeConfig.SetValue("EXPAND", (bExpand = this.getPageParam(TAG_MYEXPAND, bExpand)) ? "TRUE" : "FALSE");
    }

    protected void OnFillWFParallelSubWFTreeMenuModel(XMLNode treeNodeConfig, String strPNodeId, WFParallelSubWFConfig parallelSubWFConfig) {
        Vector<DESubWF> deSubWFList = new Vector<DESubWF>();
        treeNodeConfig.SetValue("EXPAND", "TRUE");
        this.GetDESubWFList(parallelSubWFConfig, deSubWFList);
        boolean bOutputWFParallel = this.IsOutputWFParallelFolder();
        for (DESubWF deSubWf : deSubWFList) {
            IDEFHelper wfStepDEFHelper;
            XMLNode wfParallelSubWfNodeConfig = null;
            if (bOutputWFParallel) {
                wfParallelSubWfNodeConfig = new XMLNode();
                wfParallelSubWfNodeConfig.setNodeName("SRFEXTREENODE");
                wfParallelSubWfNodeConfig.SetValue("TEXT", deSubWf.getDESUBWFNAME());
                wfParallelSubWfNodeConfig.setID(StringHelper.Format((String)"%1$s:%2$s", (Object)treeNodeConfig.getID(), (Object)deSubWf.getDESUBWFID()));
                wfParallelSubWfNodeConfig.SetValue("CSSCLASS", "WFTreeNodeText");
                treeNodeConfig.AddNode(wfParallelSubWfNodeConfig);
                wfParallelSubWfNodeConfig.SetValue("COUNTERID", WFTreeGridViewPage.GetWFStepCounterId(StringHelper.Format((String)"%1$s:%2$s", (Object)strPNodeId, (Object)deSubWf.getDESUBWFID())));
            }
            if ((wfStepDEFHelper = this.getDEHelper().GetDEFHelper(deSubWf.getWFSTEPDEFID())) == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)this.getDEHelper().getId(), (Object)deSubWf.getWFSTEPDEFID()));
                continue;
            }
            String strCodeListId = wfStepDEFHelper.GetCodeList();
            if (StringHelper.IsNullOrEmpty((String)strCodeListId)) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u6ca1\u6709\u627e\u5230\u4ee3\u7801\u8868", (Object)this.getDEHelper().getId(), (Object)deSubWf.getWFSTEPDEFID()));
                continue;
            }
            CodeListConfig codeListConfig = this.getWebContext().getCodeListMgr().GetCodeListConfig(strCodeListId, this.getLanguage());
            if (codeListConfig == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]\u914d\u7f6e", (Object)strCodeListId));
                continue;
            }
            int j = 0;
            while (j < codeListConfig.getCodeItems().size()) {
                CodeItemConfig wfStepcodeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(j);
                XMLNode wfStepTreeNodeConfig = new XMLNode();
                wfStepTreeNodeConfig.setNodeName("SRFEXTREENODE");
                wfStepTreeNodeConfig.SetValue("TEXT", wfStepcodeItemConfig.getText());
                wfStepTreeNodeConfig.setID(StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)treeNodeConfig.getID(), (Object)deSubWf.getDESUBWFID(), (Object)wfStepcodeItemConfig.getValue()));
                wfStepTreeNodeConfig.SetValue("CSSCLASS", "WFTreeNodeText");
                if (!StringHelper.IsNullOrEmpty((String)wfStepcodeItemConfig.getIconCls())) {
                    wfStepTreeNodeConfig.SetValue("ICONCSSCLASS", wfStepcodeItemConfig.getIconCls());
                } else if (!StringHelper.IsNullOrEmpty((String)wfStepcodeItemConfig.getIcon())) {
                    wfStepTreeNodeConfig.SetValue("ICON", wfStepcodeItemConfig.getIcon());
                }
                if (bOutputWFParallel) {
                    wfParallelSubWfNodeConfig.AddNode(wfStepTreeNodeConfig);
                } else {
                    treeNodeConfig.AddNode(wfStepTreeNodeConfig);
                }
                wfStepTreeNodeConfig.SetValue("COUNTERID", WFTreeGridViewPage.GetWFStepCounterId(StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)strPNodeId, (Object)deSubWf.getDESUBWFID(), (Object)wfStepcodeItemConfig.getValue())));
                ++j;
            }
        }
    }

    protected static String GetWFStepCounterId(String strNodeId) {
        String[] parts = strNodeId.split("[:]");
        String strStep = "";
        if (parts.length == 3) {
            strStep = parts[2];
        }
        if (parts.length > 3) {
            int i = 2;
            while (i < parts.length) {
                if (!StringHelper.IsNullOrEmpty((String)strStep)) {
                    strStep = String.valueOf(strStep) + "_";
                }
                strStep = String.valueOf(strStep) + parts[i];
                ++i;
            }
        }
        return StringHelper.Format((String)"S%1$s", (Object)strStep);
    }

    protected static String GetWFStepCounterId2(String strNodeId) {
        String[] parts = strNodeId.split("[:]");
        String strStep = "";
        if (parts.length == 2) {
            strStep = parts[1];
        }
        return StringHelper.Format((String)"E%1$s", (Object)strStep);
    }

    protected void OnFillTabViewModel(XMLNode tabViewConfig) {
        if (this.IsOutputSection(this.strDEWFDataGroup)) {
            this.OnFillTabViewModel(tabViewConfig, this.strDEWFDataGroup);
        }
        if (this.IsOutputSection("MYWFWORK")) {
            this.OnFillMyWFWorkTabViewModel(tabViewConfig);
        }
        if (this.IsOutputHistoryWFWork()) {
            this.OnFillHistoryTabViewModel(tabViewConfig);
        }
    }

    protected void OnFillHistoryTabViewModel(XMLNode tabViewConfig) {
        try {
            String strIfGridViewPath = "../srfpage/ifgridview2.jsp?REALURL=%1$s";
            XMLNode wftvpConfig = new XMLNode();
            wftvpConfig.setNodeName("SRFEXTABVIEWPAGE");
            wftvpConfig.setID(StringHelper.Format((String)"%1$s_HISTORY", (Object)"MYWFWORK"));
            wftvpConfig.SetValue("RESOURCEID", "NONE");
            String strPagePath = "../srfpage/gridview.jsp?SRFPAGEID=PAGE_WF0005_G002";
            if (!StringHelper.IsNullOrEmpty((String)strPagePath)) {
                strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"DEID=%1$s&SRFCAPTION=%2$s", (Object)this.getPageDataEntityId(), (Object)URLEncoder.encode(this.OnGetMyHistoryWFWorkName(), "UTF-8"));
                wftvpConfig.SetValue("REMOTEURL", StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strPagePath, "UTF-8")));
                tabViewConfig.AddNode(wftvpConfig);
            }
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    protected void OnFillTabViewModel(XMLNode tabViewConfig, String strGroup) {
        try {
            String strIfGridViewPath = "../srfpage/ifgridview2.jsp?REALURL=%1$s";
            XMLNode tvpConfig = new XMLNode();
            tvpConfig.setNodeName("SRFEXTABVIEWPAGE");
            tvpConfig.setID(strGroup);
            tvpConfig.SetValue("RESOURCEID", "NONE");
            String strPagePath = this.GetSectorPagePath(strGroup);
            if (!StringHelper.IsNullOrEmpty((String)strPagePath)) {
                strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"SRFSHOWCAP=FALSE&SRFDEID=%1$s&SRFWFDATAGROUP=%2$s&SRFCAPTION=%3$s", (Object)this.getPageDataEntityId(), (Object)strGroup, (Object)URLEncoder.encode(this.OnGetSectorName(strGroup), "UTF-8"));
                tvpConfig.SetValue("REMOTEURL", StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strPagePath, "UTF-8")));
                tabViewConfig.AddNode(tvpConfig);
            }
            int i = 0;
            while (i < this.stateCodeListConfig.getCodeItems().size()) {
                CodeItemConfig codeItemConfig = (CodeItemConfig)this.stateCodeListConfig.getCodeItems().get(i);
                if (this.IsOutputSection(strGroup, codeItemConfig.getValue())) {
                    XMLNode statetvpConfig = new XMLNode();
                    statetvpConfig.setNodeName("SRFEXTABVIEWPAGE");
                    statetvpConfig.setID(StringHelper.Format((String)"%1$s:%2$s", (Object)strGroup, (Object)codeItemConfig.getValue()));
                    statetvpConfig.SetValue("RESOURCEID", "NONE");
                    strPagePath = this.GetSectorPagePath(strGroup, codeItemConfig.getValue());
                    if (!StringHelper.IsNullOrEmpty((String)strPagePath)) {
                        strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                        strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"SRFDEID=%1$s&SRFWFDATAGROUP=%2$s&SRFCAPTION=%3$s&SRFWFSTATEVALUE=%4$s", (Object)this.getPageDataEntityId(), (Object)strGroup, (Object)URLEncoder.encode(codeItemConfig.getText(), "UTF-8"), (Object)codeItemConfig.getValue());
                        statetvpConfig.SetValue("REMOTEURL", StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strPagePath, "UTF-8")));
                        tabViewConfig.AddNode(statetvpConfig);
                    }
                    if (this.wfStateMap.containsKey(codeItemConfig.getValue())) {
                        int j = 0;
                        while (j < this.wfStepCodeListConfig.getCodeItems().size()) {
                            CodeItemConfig wfStepcodeItemConfig = (CodeItemConfig)this.wfStepCodeListConfig.getCodeItems().get(j);
                            if (this.IsOutputSection(strGroup, codeItemConfig.getValue(), wfStepcodeItemConfig.getValue())) {
                                String strWFStepCodeItemValue;
                                WFBaseProcessConfig baseProcessConfig;
                                XMLNode statesteptvpConfig = new XMLNode();
                                statesteptvpConfig.setNodeName("SRFEXTABVIEWPAGE");
                                statesteptvpConfig.setID(StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)strGroup, (Object)codeItemConfig.getValue(), (Object)wfStepcodeItemConfig.getValue()));
                                statesteptvpConfig.SetValue("RESOURCEID", "NONE");
                                strPagePath = this.GetSectorPagePath(strGroup, codeItemConfig.getValue(), wfStepcodeItemConfig.getValue());
                                if (!StringHelper.IsNullOrEmpty((String)strPagePath)) {
                                    strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                                    strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"SRFDEID=%1$s&SRFWFDATAGROUP=%2$s&SRFCAPTION=%3$s&SRFWFSTATEVALUE=%4$s&SRFWFSTEP=%5$s", (Object)this.getPageDataEntityId(), (Object)strGroup, (Object)URLEncoder.encode(wfStepcodeItemConfig.getText(), "UTF-8"), (Object)codeItemConfig.getValue(), (Object)wfStepcodeItemConfig.getValue());
                                    statesteptvpConfig.SetValue("REMOTEURL", StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strPagePath, "UTF-8")));
                                    tabViewConfig.AddNode(statesteptvpConfig);
                                }
                                if (this.wfConfig != null && (baseProcessConfig = this.wfConfig.FindProcessConfigByCodeListItemValue(strWFStepCodeItemValue = wfStepcodeItemConfig.getValue())) != null && baseProcessConfig instanceof WFParallelSubWFConfig) {
                                    this.OnFillWFParallelSubWFTabViewModel(tabViewConfig, strGroup, codeItemConfig.getValue(), wfStepcodeItemConfig.getValue(), (WFParallelSubWFConfig)baseProcessConfig);
                                }
                            }
                            ++j;
                        }
                    }
                }
                ++i;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    protected void OnFillMyParallelSubWFWorkTabViewModel(XMLNode tabViewConfig, String strGroup, String strStepValue, WFParallelSubWFConfig parallelSubWFConfig) throws Exception {
        Vector<DESubWF> deSubWFList = new Vector<DESubWF>();
        this.GetDESubWFList(parallelSubWFConfig, deSubWFList);
        String strIfGridViewPath = "../srfpage/ifgridview2.jsp?REALURL=%1$s";
        for (DESubWF deSubWf : deSubWFList) {
            IDEFHelper wfStepDEFHelper = this.getDEHelper().GetDEFHelper(deSubWf.getWFSTEPDEFID());
            if (wfStepDEFHelper == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)this.getDEHelper().getId(), (Object)deSubWf.getWFSTEPDEFID()));
                continue;
            }
            String strCodeListId = wfStepDEFHelper.GetCodeList();
            if (StringHelper.IsNullOrEmpty((String)strCodeListId)) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u6ca1\u6709\u627e\u5230\u4ee3\u7801\u8868", (Object)this.getDEHelper().getId(), (Object)deSubWf.getWFSTEPDEFID()));
                continue;
            }
            CodeListConfig codeListConfig = this.getWebContext().getCodeListMgr().GetCodeListConfig(strCodeListId, this.getLanguage());
            if (codeListConfig == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]\u914d\u7f6e", (Object)strCodeListId));
                continue;
            }
            int j = 0;
            while (j < codeListConfig.getCodeItems().size()) {
                CodeItemConfig wfStepcodeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(j);
                XMLNode tvpConfig = new XMLNode();
                tvpConfig.setNodeName("SRFEXTABVIEWPAGE");
                tvpConfig.setID(StringHelper.Format((String)"%1$s:%2$s:%3$s:%4$s", (Object)strGroup, (Object)strStepValue, (Object)deSubWf.getDESUBWFID(), (Object)wfStepcodeItemConfig.getValue()));
                tvpConfig.SetValue("RESOURCEID", "NONE");
                String strPagePath = this.GetSectorPagePath(strGroup, strStepValue, deSubWf.getDESUBWFSN(), wfStepcodeItemConfig.getValue());
                if (!StringHelper.IsNullOrEmpty((String)strPagePath)) {
                    strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                    strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"SRFSHOWCAP=FALSE&SRFDEID=%1$s&SRFWFDATAGROUP=%2$s&SRFCAPTION=%3$s&SRFWFSTEP=%4$s&SRFDESUBWFID=%5$s&SRFWFSUBSTEP=%6$s", (Object)this.getPageDataEntityId(), (Object)strGroup, (Object)URLEncoder.encode(wfStepcodeItemConfig.getText(), "UTF-8"), (Object)strStepValue, (Object)deSubWf.getDESUBWFID(), (Object)wfStepcodeItemConfig.getValue());
                    tvpConfig.SetValue("REMOTEURL", StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strPagePath, "UTF-8")));
                    tabViewConfig.AddNode(tvpConfig);
                }
                ++j;
            }
        }
    }

    protected void OnFillWFParallelSubWFTabViewModel(XMLNode tabViewConfig, String strGroup, String strStateValue, String strStepValue, WFParallelSubWFConfig parallelSubWFConfig) throws Exception {
        Vector<DESubWF> deSubWFList = new Vector<DESubWF>();
        this.GetDESubWFList(parallelSubWFConfig, deSubWFList);
        String strIfGridViewPath = "../srfpage/ifgridview2.jsp?REALURL=%1$s";
        for (DESubWF deSubWf : deSubWFList) {
            IDEFHelper wfStepDEFHelper;
            XMLNode tvpConfig = new XMLNode();
            tvpConfig.setNodeName("SRFEXTABVIEWPAGE");
            tvpConfig.setID(StringHelper.Format((String)"%1$s:%2$s:%3$s:%4$s", (Object)strGroup, (Object)strStateValue, (Object)strStepValue, (Object)deSubWf.getDESUBWFID()));
            tvpConfig.SetValue("RESOURCEID", "NONE");
            String strPagePath = this.GetSectorPagePath(strGroup, strStateValue, strStepValue, deSubWf.getDESUBWFSN());
            if (!StringHelper.IsNullOrEmpty((String)strPagePath)) {
                strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"SRFSHOWCAP=FALSE&SRFDEID=%1$s&SRFWFDATAGROUP=%2$s&SRFCAPTION=%3$s&SRFWFSTATEVALUE=%4$s&SRFWFSTEP=%5$s&SRFDESUBWFID=%6$s", (Object)this.getPageDataEntityId(), (Object)strGroup, (Object)URLEncoder.encode(deSubWf.getDESUBWFNAME(), "UTF-8"), (Object)strStateValue, (Object)strStepValue, (Object)deSubWf.getDESUBWFID());
                tvpConfig.SetValue("REMOTEURL", StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strPagePath, "UTF-8")));
                tabViewConfig.AddNode(tvpConfig);
            }
            if ((wfStepDEFHelper = this.getDEHelper().GetDEFHelper(deSubWf.getWFSTEPDEFID())) == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)this.getDEHelper().getId(), (Object)deSubWf.getWFSTEPDEFID()));
                continue;
            }
            String strCodeListId = wfStepDEFHelper.GetCodeList();
            if (StringHelper.IsNullOrEmpty((String)strCodeListId)) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u6ca1\u6709\u627e\u5230\u4ee3\u7801\u8868", (Object)this.getDEHelper().getId(), (Object)deSubWf.getWFSTEPDEFID()));
                continue;
            }
            CodeListConfig codeListConfig = this.getWebContext().getCodeListMgr().GetCodeListConfig(strCodeListId, this.getLanguage());
            if (codeListConfig == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]\u914d\u7f6e", (Object)strCodeListId));
                continue;
            }
            int j = 0;
            while (j < codeListConfig.getCodeItems().size()) {
                CodeItemConfig wfStepcodeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(j);
                XMLNode tvpConfig2 = new XMLNode();
                tvpConfig2.setNodeName("SRFEXTABVIEWPAGE");
                tvpConfig2.setID(StringHelper.Format((String)"%1$s:%2$s:%3$s:%4$s:%5$s", (Object)strGroup, (Object)strStateValue, (Object)strStepValue, (Object)deSubWf.getDESUBWFID(), (Object)wfStepcodeItemConfig.getValue()));
                tvpConfig2.SetValue("RESOURCEID", "NONE");
                String strPagePath2 = this.GetSectorPagePath(strGroup, strStateValue, strStepValue, deSubWf.getDESUBWFSN(), wfStepcodeItemConfig.getValue());
                if (!StringHelper.IsNullOrEmpty((String)strPagePath2)) {
                    strPagePath2 = URLHelper.AppendURLSeperator((String)strPagePath2);
                    strPagePath2 = String.valueOf(strPagePath2) + StringHelper.Format((String)"SRFSHOWCAP=FALSE&SRFDEID=%1$s&SRFWFDATAGROUP=%2$s&SRFCAPTION=%3$s&SRFWFSTATEVALUE=%4$s&SRFWFSTEP=%5$s&SRFDESUBWFID=%6$s&SRFWFSUBSTEP=%7$s", (Object)this.getPageDataEntityId(), (Object)strGroup, (Object)URLEncoder.encode(wfStepcodeItemConfig.getText(), "UTF-8"), (Object)strStateValue, (Object)strStepValue, (Object)deSubWf.getDESUBWFID(), (Object)wfStepcodeItemConfig.getValue());
                    tvpConfig2.SetValue("REMOTEURL", StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strPagePath2, "UTF-8")));
                    tabViewConfig.AddNode(tvpConfig2);
                }
                ++j;
            }
        }
    }

    protected void OnFillMyWFWorkTabViewModel(XMLNode tabViewConfig) {
        try {
            String strIfGridViewPath = "../srfpage/ifgridview2.jsp?REALURL=%1$s";
            XMLNode tvpConfig = new XMLNode();
            tvpConfig.setNodeName("SRFEXTABVIEWPAGE");
            tvpConfig.setID("MYWFWORK");
            tvpConfig.SetValue("RESOURCEID", "NONE");
            String strPagePath = this.GetSectorPagePath("MYWFWORK");
            if (!StringHelper.IsNullOrEmpty((String)strPagePath)) {
                strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"SRFDEID=%1$s&SRFCAPTION=%2$s&SRFWFSTATEVALUE=%3$s&SRFWFDATAGROUP=MYWFWORK", (Object)this.getPageDataEntityId(), (Object)URLEncoder.encode(this.strMYWFWork, "UTF-8"), (Object)this.dewf.getWFSTATEVALUE());
                tvpConfig.SetValue("REMOTEURL", StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strPagePath, "UTF-8")));
                tabViewConfig.AddNode(tvpConfig);
            }
            int j = 0;
            while (j < this.wfStepCodeListConfig.getCodeItems().size()) {
                CodeItemConfig wfStepcodeItemConfig = (CodeItemConfig)this.wfStepCodeListConfig.getCodeItems().get(j);
                if (this.IsOutputSection("MYWFWORK", wfStepcodeItemConfig.getValue())) {
                    String strWFStepCodeItemValue;
                    WFBaseProcessConfig baseProcessConfig;
                    XMLNode wftvpConfig = new XMLNode();
                    wftvpConfig.setNodeName("SRFEXTABVIEWPAGE");
                    wftvpConfig.setID(StringHelper.Format((String)"%1$s:%2$s", (Object)"MYWFWORK", (Object)wfStepcodeItemConfig.getValue()));
                    wftvpConfig.SetValue("RESOURCEID", "NONE");
                    strPagePath = this.GetSectorPagePath("MYWFWORK", wfStepcodeItemConfig.getValue());
                    if (!StringHelper.IsNullOrEmpty((String)strPagePath)) {
                        strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
                        strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"SRFDEID=%1$s&SRFCAPTION=%2$s&SRFWFSTATEVALUE=%3$s&SRFWFSTEP=%4$s&SRFWFDATAGROUP=MYWFWORK", (Object)this.getPageDataEntityId(), (Object)URLEncoder.encode(wfStepcodeItemConfig.getText(), "UTF-8"), (Object)this.dewf.getWFSTATEVALUE(), (Object)wfStepcodeItemConfig.getValue());
                        wftvpConfig.SetValue("REMOTEURL", StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strPagePath, "UTF-8")));
                        tabViewConfig.AddNode(wftvpConfig);
                    }
                    if (this.wfConfig != null && (baseProcessConfig = this.wfConfig.FindProcessConfigByCodeListItemValue(strWFStepCodeItemValue = wfStepcodeItemConfig.getValue())) != null && baseProcessConfig instanceof WFParallelSubWFConfig) {
                        this.OnFillMyParallelSubWFWorkTabViewModel(tabViewConfig, "MYWFWORK", wfStepcodeItemConfig.getValue(), (WFParallelSubWFConfig)baseProcessConfig);
                    }
                }
                ++j;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        String strTreeViewConfigId = StringHelper.Format((String)"%1$s.WFTREEVIEW_%2$s", (Object)this.getDEHelper().getId(), (Object)this.getDEHelper().getVersion());
        if (!StringHelper.IsNullOrEmpty((String)this.getLanguage())) {
            strTreeViewConfigId = String.valueOf(strTreeViewConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.getLanguage());
        }
        strTreeViewConfigId = strTreeViewConfigId.toUpperCase();
        String strTreeViewFilePath = ConfigPathHelper.GetRuntimeTreeViewConfigPath((String)this.getWebContext().getGlobalHelper().GetAppRootPath(), (String)strTreeViewConfigId);
        File file = new File(strTreeViewFilePath);
        if (!file.exists()) {
            XMLNode treeNode = new XMLNode();
            treeNode.setNodeName("SRFEXTREEPANEL");
            treeNode.SetValue("ROOTVISIBLE", "FALSE");
            XMLNode rootNode = new XMLNode();
            rootNode.setNodeName("SRFEXTREENODE");
            treeNode.AddNode(rootNode);
            this.OnFillTreeMenuModel(rootNode);
            if (!BaseDAConfigHelper.ExportConfigFile((XMLNode)treeNode, (String)strTreeViewFilePath)) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5bfc\u51fa\u5de5\u4f5c\u6d41\u6811\u83dc\u5355\u914d\u7f6e\u5931\u8d25"));
            }
        }
        this.wfTreeGridViewModel.getTreePanelModel().setConfigId(strTreeViewConfigId);
        String strTabViewConfigId = StringHelper.Format((String)"%1$s.WFTABVIEW_%2$s", (Object)this.getDEHelper().getId(), (Object)this.getDEHelper().getVersion());
        if (!StringHelper.IsNullOrEmpty((String)this.getLanguage())) {
            strTabViewConfigId = String.valueOf(strTabViewConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.getLanguage());
        }
        strTabViewConfigId = strTabViewConfigId.toUpperCase();
        String strTabViewFilePath = ConfigPathHelper.GetRuntimeTVConfigPath((String)this.getWebContext().getGlobalHelper().GetAppRootPath(), (String)strTabViewConfigId);
        File file2 = new File(strTabViewFilePath);
        if (!file2.exists()) {
            XMLNode tabViewNode = new XMLNode();
            tabViewNode.setNodeName("SRFEXTABVIEW");
            this.OnFillTabViewModel(tabViewNode);
            if (!BaseDAConfigHelper.ExportConfigFile((XMLNode)tabViewNode, (String)strTabViewFilePath)) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5bfc\u51fa\u5de5\u4f5c\u6d41\u5206\u9875\u89c6\u56fe\u914d\u7f6e\u5931\u8d25"));
            }
        }
        this.wfTreeGridViewModel.getTabViewModel().setConfigId(strTabViewConfigId);
        this.wfTreeGridViewModel.setWFId(this.dewf.getWFID());
        return true;
    }

    protected String OnGetPageTitle() {
        return this.GetLocalization("PAGE.HEADER.WFEXPLORERVIEW", "\u5de5\u4f5c\u6d41\u5bfc\u822a\u89c6\u56fe");
    }
}

