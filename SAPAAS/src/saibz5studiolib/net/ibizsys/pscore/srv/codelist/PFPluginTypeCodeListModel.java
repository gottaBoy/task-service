/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.CodeItem
 *  net.ibizsys.paas.codelist.CodeItems
 *  net.ibizsys.paas.codelist.CodeList
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 *  net.ibizsys.paas.sysmodel.StaticCodeListModelBase
 */
package net.ibizsys.pscore.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="9faad616f1cf4a596ecdf5b603b38870", name="\u4e91\u5e73\u53f0\u5e94\u7528\u6846\u67b6\u63d2\u4ef6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="AC_ITEM", text="\u81ea\u586b\u5217\u8868\u9879\u7ed8\u5236\u63d2\u4ef6", realtext="\u81ea\u586b\u5217\u8868\u9879\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="CHART_RENDER", text="\u56fe\u8868\u7ed8\u5236\u63d2\u4ef6", realtext="\u56fe\u8868\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="CHART_AXISRENDER", text="\u56fe\u8868\u5750\u6807\u8f74\u7ed8\u5236\u63d2\u4ef6", realtext="\u56fe\u8868\u5750\u6807\u8f74\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="CHART_SERIESRENDER", text="\u56fe\u8868\u5e8f\u5217\u7ed8\u5236\u63d2\u4ef6", realtext="\u56fe\u8868\u5e8f\u5217\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="CHART_CSRENDER", text="\u56fe\u8868\u5750\u6807\u7cfb\u7ec4\u4ef6\u7ed8\u5236\u63d2\u4ef6", realtext="\u56fe\u8868\u5750\u6807\u7cfb\u7ec4\u4ef6\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49\u90e8\u4ef6\u7ed8\u5236\u63d2\u4ef6", realtext="\u81ea\u5b9a\u4e49\u90e8\u4ef6\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="DATAVIEW_ITEM", text="\u6570\u636e\u89c6\u56fe\u9879\u7ed8\u5236\u63d2\u4ef6", realtext="\u6570\u636e\u89c6\u56fe\u9879\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="DATAVIEW_RENDER", text="\u6570\u636e\u89c6\u56fe\u7ed8\u5236\u63d2\u4ef6", realtext="\u6570\u636e\u89c6\u56fe\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="EDITFORM_RENDER", text="\u7f16\u8f91\u8868\u5355\u7ed8\u5236\u63d2\u4ef6", realtext="\u7f16\u8f91\u8868\u5355\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="EDITOR_CUSTOMSTYLE", text="\u7f16\u8f91\u5668\u81ea\u5b9a\u4e49\u7ed8\u5236\u63d2\u4ef6", realtext="\u7f16\u8f91\u5668\u81ea\u5b9a\u4e49\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="FORM_USERCONTROL", text="\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6", realtext="\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="GRID_COLRENDER", text="\u6570\u636e\u8868\u683c\u5217\u7ed8\u5236\u63d2\u4ef6", realtext="\u6570\u636e\u8868\u683c\u5217\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="GRID_RENDER", text="\u6570\u636e\u8868\u683c\u7ed8\u5236\u63d2\u4ef6", realtext="\u6570\u636e\u8868\u683c\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="LIST_ITEMRENDER", text="\u5217\u8868\u9879\u7ed8\u5236\u63d2\u4ef6", realtext="\u5217\u8868\u9879\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="LIST_RENDER", text="\u5217\u8868\u7ed8\u5236\u63d2\u4ef6", realtext="\u5217\u8868\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="PORTLET_CUSTOM", text="\u81ea\u5b9a\u4e49\u95e8\u6237\u90e8\u4ef6\u7ed8\u5236\u63d2\u4ef6", realtext="\u81ea\u5b9a\u4e49\u95e8\u6237\u90e8\u4ef6\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="PORTLET_TITLEBAR", text="\u95e8\u6237\u90e8\u4ef6\u6807\u9898\u680f\u7ed8\u5236\u63d2\u4ef6", realtext="\u95e8\u6237\u90e8\u4ef6\u6807\u9898\u680f\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="SEARCHFORM_RENDER", text="\u641c\u7d22\u8868\u5355\u7ed8\u5236\u63d2\u4ef6", realtext="\u641c\u7d22\u8868\u5355\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="TOOLBAR_ITEM", text="\u5de5\u5177\u680f\u9879\u7ed8\u5236\u63d2\u4ef6", realtext="\u5de5\u5177\u680f\u9879\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="TOOLBAR_RENDER", text="\u5de5\u5177\u680f\u7ed8\u5236\u63d2\u4ef6", realtext="\u5de5\u5177\u680f\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="TREEEXPBAR_RENDER", text="\u6811\u5bfc\u822a\u680f\u7ed8\u5236\u63d2\u4ef6", realtext="\u6811\u5bfc\u822a\u680f\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="TREE_RENDER", text="\u6811\u89c6\u56fe\u7ed8\u5236\u63d2\u4ef6", realtext="\u6811\u89c6\u56fe\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="UIENGINE", text="\u754c\u9762\u5f15\u64ce", realtext="\u754c\u9762\u5f15\u64ce"), @CodeItem(value="UILOGICNODE", text="\u754c\u9762\u903b\u8f91\u8282\u70b9", realtext="\u754c\u9762\u903b\u8f91\u8282\u70b9"), @CodeItem(value="VIEW_CUSTOM", text="\u5b9e\u4f53\u89c6\u56fe\u7ed8\u5236\u63d2\u4ef6", realtext="\u5b9e\u4f53\u89c6\u56fe\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="DEMETHOD", text="\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5\u63d2\u4ef6", realtext="\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5\u63d2\u4ef6"), @CodeItem(value="APPUTIL", text="\u5e94\u7528\u529f\u80fd\u63d2\u4ef6", realtext="\u5e94\u7528\u529f\u80fd\u63d2\u4ef6"), @CodeItem(value="APPCOUNTER", text="\u5e94\u7528\u8ba1\u6570\u5668\u63d2\u4ef6", realtext="\u5e94\u7528\u8ba1\u6570\u5668\u63d2\u4ef6"), @CodeItem(value="DEDATAIMPORT", text="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u5bfc\u5165", realtext="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u5bfc\u5165"), @CodeItem(value="DEDATAEXPORT", text="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa", realtext="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa"), @CodeItem(value="DEFVALUERULE", text="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219", realtext="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219"), @CodeItem(value="APPVALUERULE", text="\u5e94\u7528\u503c\u89c4\u5219", realtext="\u5e94\u7528\u503c\u89c4\u5219"), @CodeItem(value="SEARCHBAR_ITEM", text="\u641c\u7d22\u680f\u9879\u7ed8\u5236\u63d2\u4ef6", realtext="\u641c\u7d22\u680f\u9879\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="SEARCHBAR_RENDER", text="\u641c\u7d22\u680f\u7ed8\u5236\u63d2\u4ef6", realtext="\u641c\u7d22\u680f\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="WIZARDPANEL_RENDER", text="\u5411\u5bfc\u9762\u677f\u7ed8\u5236\u63d2\u4ef6", realtext="\u5411\u5bfc\u9762\u677f\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="DEUIACTION", text="\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u884c\u4e3a", realtext="\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u884c\u4e3a"), @CodeItem(value="CALENDAR_ITEM", text="\u65e5\u5386\u90e8\u4ef6\u9879\u7ed8\u5236\u63d2\u4ef6", realtext="\u65e5\u5386\u90e8\u4ef6\u9879\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="CALENDAR_RENDER", text="\u65e5\u5386\u90e8\u4ef6\u7ed8\u5236\u63d2\u4ef6", realtext="\u65e5\u5386\u90e8\u4ef6\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="MAPVIEW_ITEM", text="\u5730\u56fe\u90e8\u4ef6\u9879\u7ed8\u5236\u63d2\u4ef6", realtext="\u5730\u56fe\u90e8\u4ef6\u9879\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="MAPVIEW_RENDER", text="\u5730\u56fe\u90e8\u4ef6\u7ed8\u5236\u63d2\u4ef6", realtext="\u5730\u56fe\u90e8\u4ef6\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="PANEL_ITEM", text="\u9762\u677f\u90e8\u4ef6\u6210\u5458\u7ed8\u5236\u63d2\u4ef6", realtext="\u9762\u677f\u90e8\u4ef6\u6210\u5458\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="PANEL_RENDER", text="\u9762\u677f\u90e8\u4ef6\u7ed8\u5236\u63d2\u4ef6", realtext="\u9762\u677f\u90e8\u4ef6\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="DASHBOARD_ITEM", text="\u6570\u636e\u770b\u677f\u6210\u5458\u7ed8\u5236\u63d2\u4ef6", realtext="\u6570\u636e\u770b\u677f\u6210\u5458\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="DASHBOARD_RENDER", text="\u6570\u636e\u770b\u677f\u7ed8\u5236\u63d2\u4ef6", realtext="\u6570\u636e\u770b\u677f\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="APPUILOGIC", text="\u7cfb\u7edf\u754c\u9762\u903b\u8f91\u63d2\u4ef6", realtext="\u7cfb\u7edf\u754c\u9762\u903b\u8f91\u63d2\u4ef6"), @CodeItem(value="APPMENU_ITEM", text="\u5e94\u7528\u83dc\u5355\u9879\u7ed8\u5236\u63d2\u4ef6", realtext="\u5e94\u7528\u83dc\u5355\u9879\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="APPMENU_RENDER", text="\u5e94\u7528\u83dc\u5355\u7ed8\u5236\u63d2\u4ef6", realtext="\u5e94\u7528\u83dc\u5355\u7ed8\u5236\u63d2\u4ef6"), @CodeItem(value="TITLEBAR_RENDER", text="\u6807\u9898\u680f\u7ed8\u5236\u63d2\u4ef6", realtext="\u6807\u9898\u680f\u7ed8\u5236\u63d2\u4ef6")})
public class PFPluginTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String AC_ITEM = "AC_ITEM";
    public static final String CHART_RENDER = "CHART_RENDER";
    public static final String CHART_AXISRENDER = "CHART_AXISRENDER";
    public static final String CHART_SERIESRENDER = "CHART_SERIESRENDER";
    public static final String CHART_CSRENDER = "CHART_CSRENDER";
    public static final String CUSTOM = "CUSTOM";
    public static final String DATAVIEW_ITEM = "DATAVIEW_ITEM";
    public static final String DATAVIEW_RENDER = "DATAVIEW_RENDER";
    public static final String EDITFORM_RENDER = "EDITFORM_RENDER";
    public static final String EDITOR_CUSTOMSTYLE = "EDITOR_CUSTOMSTYLE";
    public static final String FORM_USERCONTROL = "FORM_USERCONTROL";
    public static final String GRID_COLRENDER = "GRID_COLRENDER";
    public static final String GRID_RENDER = "GRID_RENDER";
    public static final String LIST_ITEMRENDER = "LIST_ITEMRENDER";
    public static final String LIST_RENDER = "LIST_RENDER";
    public static final String PORTLET_CUSTOM = "PORTLET_CUSTOM";
    public static final String PORTLET_TITLEBAR = "PORTLET_TITLEBAR";
    public static final String SEARCHFORM_RENDER = "SEARCHFORM_RENDER";
    public static final String TOOLBAR_ITEM = "TOOLBAR_ITEM";
    public static final String TOOLBAR_RENDER = "TOOLBAR_RENDER";
    public static final String TREEEXPBAR_RENDER = "TREEEXPBAR_RENDER";
    public static final String TREE_RENDER = "TREE_RENDER";
    public static final String UIENGINE = "UIENGINE";
    public static final String UILOGICNODE = "UILOGICNODE";
    public static final String VIEW_CUSTOM = "VIEW_CUSTOM";
    public static final String DEMETHOD = "DEMETHOD";
    public static final String APPUTIL = "APPUTIL";
    public static final String APPCOUNTER = "APPCOUNTER";
    public static final String DEDATAIMPORT = "DEDATAIMPORT";
    public static final String DEDATAEXPORT = "DEDATAEXPORT";
    public static final String DEFVALUERULE = "DEFVALUERULE";
    public static final String APPVALUERULE = "APPVALUERULE";
    public static final String SEARCHBAR_ITEM = "SEARCHBAR_ITEM";
    public static final String SEARCHBAR_RENDER = "SEARCHBAR_RENDER";
    public static final String WIZARDPANEL_RENDER = "WIZARDPANEL_RENDER";
    public static final String DEUIACTION = "DEUIACTION";
    public static final String CALENDAR_ITEM = "CALENDAR_ITEM";
    public static final String CALENDAR_RENDER = "CALENDAR_RENDER";
    public static final String MAPVIEW_ITEM = "MAPVIEW_ITEM";
    public static final String MAPVIEW_RENDER = "MAPVIEW_RENDER";
    public static final String PANEL_ITEM = "PANEL_ITEM";
    public static final String PANEL_RENDER = "PANEL_RENDER";
    public static final String DASHBOARD_ITEM = "DASHBOARD_ITEM";
    public static final String DASHBOARD_RENDER = "DASHBOARD_RENDER";
    public static final String APPUILOGIC = "APPUILOGIC";
    public static final String APPMENU_ITEM = "APPMENU_ITEM";
    public static final String APPMENU_RENDER = "APPMENU_RENDER";
    public static final String TITLEBAR_RENDER = "TITLEBAR_RENDER";

    public PFPluginTypeCodeListModel() {
        this.initAnnotation(PFPluginTypeCodeListModel.class);
        this.setUserData2("PFPluginType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PFPluginTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PFPluginTypeCodeListModel");
    }
}

