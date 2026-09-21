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

@CodeList(id="66407685-5B31-42EA-90B6-72F7F7A4309D", name="\u9762\u677f\u9879\u652f\u6301\u90e8\u4ef6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TOOLBAR", text="\u5de5\u5177\u680f", realtext="\u5de5\u5177\u680f", iconpath="psctrltype/icon_toolbar.png", iconpathx="psctrltype/icon_toolbar@{0}x.png"), @CodeItem(value="GRID", text="\u6570\u636e\u8868\u683c", realtext="\u6570\u636e\u8868\u683c", iconpath="psctrltype/icon_grid.png", iconpathx="psctrltype/icon_grid@{0}x.png"), @CodeItem(value="FORM", text="\u7f16\u8f91\u8868\u5355", realtext="\u7f16\u8f91\u8868\u5355", iconpath="psctrltype/icon_form.png", iconpathx="psctrltype/icon_form@{0}x.png"), @CodeItem(value="SEARCHFORM", text="\u641c\u7d22\u8868\u5355", realtext="\u641c\u7d22\u8868\u5355", iconpath="psctrltype/icon_searchform.png", iconpathx="psctrltype/icon_searchform@{0}x.png"), @CodeItem(value="DATAVIEW", text="\u6570\u636e\u89c6\u56fe", realtext="\u6570\u636e\u89c6\u56fe", iconpath="psctrltype/icon_dataview.png", iconpathx="psctrltype/icon_dataview@{0}x.png"), @CodeItem(value="TREEVIEW", text="\u6811\u89c6\u56fe", realtext="\u6811\u89c6\u56fe", iconpath="psctrltype/icon_treeview.png", iconpathx="psctrltype/icon_treeview@{0}x.png"), @CodeItem(value="CHART", text="\u6570\u636e\u56fe\u8868", realtext="\u6570\u636e\u56fe\u8868", iconpath="psctrltype/icon_chart.png", iconpathx="psctrltype/icon_chart@{0}x.png"), @CodeItem(value="LIST", text="\u5217\u8868", realtext="\u5217\u8868", iconpath="psctrltype/icon_list.png", iconpathx="psctrltype/icon_list@{0}x.png"), @CodeItem(value="MOBMDCTRL", text="\u79fb\u52a8\u7aef\u591a\u6570\u636e\u89c6\u56fe", realtext="\u79fb\u52a8\u7aef\u591a\u6570\u636e\u89c6\u56fe", iconpath="psctrltype/icon_mobmdctrl.png", iconpathx="psctrltype/icon_mobmdctrl@{0}x.png"), @CodeItem(value="DASHBOARD", text="\u6570\u636e\u770b\u677f", realtext="\u6570\u636e\u770b\u677f", iconpath="psctrltype/icon_dashboard.png", iconpathx="psctrltype/icon_dashboard@{0}x.png"), @CodeItem(value="CALENDAR", text="\u65e5\u5386\u90e8\u4ef6", realtext="\u65e5\u5386\u90e8\u4ef6", iconpath="psctrltype/icon_calendar.png", iconpathx="psctrltype/icon_calendar@{0}x.png"), @CodeItem(value="MAP", text="\u5730\u56fe\u90e8\u4ef6", realtext="\u5730\u56fe\u90e8\u4ef6"), @CodeItem(value="GANTT", text="\u7518\u7279\u90e8\u4ef6", realtext="\u7518\u7279\u90e8\u4ef6"), @CodeItem(value="VIEWPANEL", text="\u89c6\u56fe\u9762\u677f", realtext="\u89c6\u56fe\u9762\u677f")})
public class PanelCtrlTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String TOOLBAR = "TOOLBAR";
    public static final String GRID = "GRID";
    public static final String FORM = "FORM";
    public static final String SEARCHFORM = "SEARCHFORM";
    public static final String DATAVIEW = "DATAVIEW";
    public static final String TREEVIEW = "TREEVIEW";
    public static final String CHART = "CHART";
    public static final String LIST = "LIST";
    public static final String MOBMDCTRL = "MOBMDCTRL";
    public static final String DASHBOARD = "DASHBOARD";
    public static final String CALENDAR = "CALENDAR";
    public static final String MAP = "MAP";
    public static final String GANTT = "GANTT";
    public static final String VIEWPANEL = "VIEWPANEL";

    public PanelCtrlTypeCodeListModel() {
        this.initAnnotation(PanelCtrlTypeCodeListModel.class);
        this.setUserData2("PanelCtrlType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelCtrlTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelCtrlTypeCodeListModel");
    }
}

