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

@CodeList(id="15c169056deced1fb22577edd5ffaac5", name="\u90e8\u4ef6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TOOLBAR", text="\u5de5\u5177\u680f", realtext="\u5de5\u5177\u680f", iconpath="psctrltype/icon_toolbar.png", iconpathx="psctrltype/icon_toolbar@{0}x.png"), @CodeItem(value="GRID", text="\u6570\u636e\u8868\u683c", realtext="\u6570\u636e\u8868\u683c", iconpath="psctrltype/icon_grid.png", iconpathx="psctrltype/icon_grid@{0}x.png"), @CodeItem(value="FORM", text="\u7f16\u8f91\u8868\u5355", realtext="\u7f16\u8f91\u8868\u5355", iconpath="psctrltype/icon_form.png", iconpathx="psctrltype/icon_form@{0}x.png"), @CodeItem(value="SEARCHFORM", text="\u641c\u7d22\u8868\u5355", realtext="\u641c\u7d22\u8868\u5355", iconpath="psctrltype/icon_searchform.png", iconpathx="psctrltype/icon_searchform@{0}x.png"), @CodeItem(value="DRBAR", text="\u6570\u636e\u5173\u7cfb\u680f", realtext="\u6570\u636e\u5173\u7cfb\u680f", iconpath="psctrltype/icon_drbar.png", iconpathx="psctrltype/icon_drbar@{0}x.png"), @CodeItem(value="VIEWPANEL", text="\u5355\u89c6\u56fe\u9762\u677f", realtext="\u5355\u89c6\u56fe\u9762\u677f", iconpath="psctrltype/icon_viewpanel.png", iconpathx="psctrltype/icon_viewpanel@{0}x.png"), @CodeItem(value="PICKUPVIEWPANEL", text="\u9009\u62e9\u89c6\u56fe\u9762\u677f", realtext="\u9009\u62e9\u89c6\u56fe\u9762\u677f", iconpath="psctrltype/icon_pickupviewpanel.png", iconpathx="psctrltype/icon_pickupviewpanel@{0}x.png"), @CodeItem(value="DATAVIEW", text="\u6570\u636e\u89c6\u56fe", realtext="\u6570\u636e\u89c6\u56fe", iconpath="psctrltype/icon_dataview.png", iconpathx="psctrltype/icon_dataview@{0}x.png"), @CodeItem(value="TREEGRID", text="\u6570\u636e\u6811\u8868\u683c", realtext="\u6570\u636e\u6811\u8868\u683c", iconpath="psctrltype/icon_treegrid.png", iconpathx="psctrltype/icon_treegrid@{0}x.png"), @CodeItem(value="WFEXPBAR", text="\u6d41\u7a0b\u5bfc\u822a\u680f", realtext="\u6d41\u7a0b\u5bfc\u822a\u680f", iconpath="psctrltype/icon_wfexpbar.png", iconpathx="psctrltype/icon_wfexpbar@{0}x.png"), @CodeItem(value="TREEVIEW", text="\u6811\u89c6\u56fe", realtext="\u6811\u89c6\u56fe", iconpath="psctrltype/icon_treeview.png", iconpathx="psctrltype/icon_treeview@{0}x.png"), @CodeItem(value="TREEEXPBAR", text="\u6811\u89c6\u56fe\u5bfc\u822a\u680f", realtext="\u6811\u89c6\u56fe\u5bfc\u822a\u680f", iconpath="psctrltype/icon_treeexpbar.png", iconpathx="psctrltype/icon_treeexpbar@{0}x.png"), @CodeItem(value="TABVIEWPANEL", text="\u5206\u9875\u89c6\u56fe\u9762\u677f", realtext="\u5206\u9875\u89c6\u56fe\u9762\u677f", iconpath="psctrltype/icon_tabviewpanel.png", iconpathx="psctrltype/icon_tabviewpanel@{0}x.png"), @CodeItem(value="DRTAB", text="\u6570\u636e\u5173\u7cfb\u5206\u9875\u90e8\u4ef6", realtext="\u6570\u636e\u5173\u7cfb\u5206\u9875\u90e8\u4ef6", iconpath="psctrltype/icon_drtab.png", iconpathx="psctrltype/icon_drtab@{0}x.png"), @CodeItem(value="CHART", text="\u6570\u636e\u56fe\u8868", realtext="\u6570\u636e\u56fe\u8868", iconpath="psctrltype/icon_chart.png", iconpathx="psctrltype/icon_chart@{0}x.png"), @CodeItem(value="REPORTPANEL", text="\u62a5\u8868\u9762\u677f", realtext="\u62a5\u8868\u9762\u677f", iconpath="psctrltype/icon_reportpanel.png", iconpathx="psctrltype/icon_reportpanel@{0}x.png"), @CodeItem(value="LIST", text="\u5217\u8868", realtext="\u5217\u8868", iconpath="psctrltype/icon_list.png", iconpathx="psctrltype/icon_list@{0}x.png"), @CodeItem(value="MOBMDCTRL", text="\u79fb\u52a8\u7aef\u591a\u6570\u636e\u89c6\u56fe", realtext="\u79fb\u52a8\u7aef\u591a\u6570\u636e\u89c6\u56fe", iconpath="psctrltype/icon_mobmdctrl.png", iconpathx="psctrltype/icon_mobmdctrl@{0}x.png"), @CodeItem(value="MULTIEDITVIEWPANEL", text="\u591a\u7f16\u8f91\u89c6\u56fe\u9762\u677f", realtext="\u591a\u7f16\u8f91\u89c6\u56fe\u9762\u677f", iconpath="psctrltype/icon_multieditviewpanel.png", iconpathx="psctrltype/icon_multieditviewpanel@{0}x.png"), @CodeItem(value="WIZARDPANEL", text="\u5411\u5bfc\u9762\u677f", realtext="\u5411\u5bfc\u9762\u677f", iconpath="psctrltype/icon_wizardpanel.png", iconpathx="psctrltype/icon_wizardpanel@{0}x.png"), @CodeItem(value="UPDATEPANEL", text="\u66f4\u65b0\u9762\u677f", realtext="\u66f4\u65b0\u9762\u677f", iconpath="psctrltype/icon_updatepanel.png", iconpathx="psctrltype/icon_updatepanel@{0}x.png"), @CodeItem(value="SEARCHBAR", text="\u641c\u7d22\u680f", realtext="\u641c\u7d22\u680f", iconpath="psctrltype/icon_searchbar.png", iconpathx="psctrltype/icon_searchbar@{0}x.png"), @CodeItem(value="DASHBOARD", text="\u6570\u636e\u770b\u677f", realtext="\u6570\u636e\u770b\u677f", iconpath="psctrltype/icon_dashboard.png", iconpathx="psctrltype/icon_dashboard@{0}x.png"), @CodeItem(value="CALENDAR", text="\u65e5\u5386\u90e8\u4ef6", realtext="\u65e5\u5386\u90e8\u4ef6", iconpath="psctrltype/icon_calendar.png", iconpathx="psctrltype/icon_calendar@{0}x.png"), @CodeItem(value="PANEL", text="\u9762\u677f\u90e8\u4ef6", realtext="\u9762\u677f\u90e8\u4ef6", iconpath="ctrltype/icon_panel.png", iconpathx="ctrltype/icon_panel@{0}x.png"), @CodeItem(value="MAP", text="\u5730\u56fe\u90e8\u4ef6", realtext="\u5730\u56fe\u90e8\u4ef6"), @CodeItem(value="GANTT", text="\u7518\u7279\u90e8\u4ef6", realtext="\u7518\u7279\u90e8\u4ef6"), @CodeItem(value="TREEGRIDEX", text="\u6811\u8868\u683c\uff08\u589e\u5f3a\uff09", realtext="\u6811\u8868\u683c\uff08\u589e\u5f3a\uff09"), @CodeItem(value="KANBAN", text="\u770b\u677f", realtext="\u770b\u677f"), @CodeItem(value="CALENDAREXPBAR", text="\u65e5\u5386\u89c6\u56fe\u5bfc\u822a\u680f", realtext="\u65e5\u5386\u89c6\u56fe\u5bfc\u822a\u680f"), @CodeItem(value="CHARTEXPBAR", text="\u56fe\u8868\u89c6\u56fe\u5bfc\u822a\u680f", realtext="\u56fe\u8868\u89c6\u56fe\u5bfc\u822a\u680f"), @CodeItem(value="DATAVIEWEXPBAR", text="\u5361\u7247\u89c6\u56fe\u5bfc\u822a\u680f", realtext="\u5361\u7247\u89c6\u56fe\u5bfc\u822a\u680f"), @CodeItem(value="GANTTEXPBAR", text="\u7518\u7279\u89c6\u56fe\u5bfc\u822a\u680f", realtext="\u7518\u7279\u89c6\u56fe\u5bfc\u822a\u680f"), @CodeItem(value="GRIDEXPBAR", text="\u8868\u683c\u89c6\u56fe\u5bfc\u822a\u680f", realtext="\u8868\u683c\u89c6\u56fe\u5bfc\u822a\u680f"), @CodeItem(value="LISTEXPBAR", text="\u5217\u8868\u89c6\u56fe\u5bfc\u822a\u680f", realtext="\u5217\u8868\u89c6\u56fe\u5bfc\u822a\u680f"), @CodeItem(value="MAPEXPBAR", text="\u5730\u56fe\u89c6\u56fe\u5bfc\u822a\u680f", realtext="\u5730\u56fe\u89c6\u56fe\u5bfc\u822a\u680f"), @CodeItem(value="STATEWIZARDPANEL", text="\u72b6\u6001\u5411\u5bfc\u9762\u677f", realtext="\u72b6\u6001\u5411\u5bfc\u9762\u677f"), @CodeItem(value="APPMENU", text="\u5e94\u7528\u83dc\u5355", realtext="\u5e94\u7528\u83dc\u5355"), @CodeItem(value="TABEXPPANEL", text="\u5206\u9875\u5bfc\u822a\u9762\u677f", realtext="\u5206\u9875\u5bfc\u822a\u9762\u677f"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49\u90e8\u4ef6", realtext="\u81ea\u5b9a\u4e49\u90e8\u4ef6", iconpath="psctrltype/icon_custom.png", iconpathx="psctrltype/icon_custom@{0}x.png")})
public class CtrlTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String TOOLBAR = "TOOLBAR";
    public static final String GRID = "GRID";
    public static final String FORM = "FORM";
    public static final String SEARCHFORM = "SEARCHFORM";
    public static final String DRBAR = "DRBAR";
    public static final String VIEWPANEL = "VIEWPANEL";
    public static final String PICKUPVIEWPANEL = "PICKUPVIEWPANEL";
    public static final String DATAVIEW = "DATAVIEW";
    public static final String TREEGRID = "TREEGRID";
    public static final String WFEXPBAR = "WFEXPBAR";
    public static final String TREEVIEW = "TREEVIEW";
    public static final String TREEEXPBAR = "TREEEXPBAR";
    public static final String TABVIEWPANEL = "TABVIEWPANEL";
    public static final String DRTAB = "DRTAB";
    public static final String CHART = "CHART";
    public static final String REPORTPANEL = "REPORTPANEL";
    public static final String LIST = "LIST";
    public static final String MOBMDCTRL = "MOBMDCTRL";
    public static final String MULTIEDITVIEWPANEL = "MULTIEDITVIEWPANEL";
    public static final String WIZARDPANEL = "WIZARDPANEL";
    public static final String UPDATEPANEL = "UPDATEPANEL";
    public static final String SEARCHBAR = "SEARCHBAR";
    public static final String DASHBOARD = "DASHBOARD";
    public static final String CALENDAR = "CALENDAR";
    public static final String PANEL = "PANEL";
    public static final String MAP = "MAP";
    public static final String GANTT = "GANTT";
    public static final String TREEGRIDEX = "TREEGRIDEX";
    public static final String KANBAN = "KANBAN";
    public static final String CALENDAREXPBAR = "CALENDAREXPBAR";
    public static final String CHARTEXPBAR = "CHARTEXPBAR";
    public static final String DATAVIEWEXPBAR = "DATAVIEWEXPBAR";
    public static final String GANTTEXPBAR = "GANTTEXPBAR";
    public static final String GRIDEXPBAR = "GRIDEXPBAR";
    public static final String LISTEXPBAR = "LISTEXPBAR";
    public static final String MAPEXPBAR = "MAPEXPBAR";
    public static final String STATEWIZARDPANEL = "STATEWIZARDPANEL";
    public static final String APPMENU = "APPMENU";
    public static final String TABEXPPANEL = "TABEXPPANEL";
    public static final String CUSTOM = "CUSTOM";

    public CtrlTypeCodeListModel() {
        this.initAnnotation(CtrlTypeCodeListModel.class);
        this.setUserData2("CtrlType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.CtrlTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.CtrlTypeCodeListModel");
    }
}

