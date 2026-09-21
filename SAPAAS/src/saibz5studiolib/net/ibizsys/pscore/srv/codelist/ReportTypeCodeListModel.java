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

@CodeList(id="85cc9ea5441dff26bc4832583a60167a", name="\u62a5\u8868\u683c\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="POI_TL", text="POI\u6a21\u677f\u5f15\u64ce", realtext="POI\u6a21\u677f\u5f15\u64ce"), @CodeItem(value="ANTVG6", text="AntVG6", realtext="AntVG6"), @CodeItem(value="LUCKYSHEET", text="LuckySheet", realtext="LuckySheet"), @CodeItem(value="AVUEDATA", text="AvueData", realtext="AvueData"), @CodeItem(value="AVUEDATA_CLOUD", text="AvueData\uff08Cloud\uff09", realtext="AvueData\uff08Cloud\uff09"), @CodeItem(value="GRAFANA", text="Grafana", realtext="Grafana"), @CodeItem(value="DATAEASE", text="DataEase", realtext="DataEase"), @CodeItem(value="JR", text="JasperReport", realtext="JasperReport"), @CodeItem(value="HTML", text="HTML", realtext="HTML"), @CodeItem(value="MARKDOWN", text="Markdown", realtext="Markdown"), @CodeItem(value="SYSBICUBE", text="\u7cfb\u7edf\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53", realtext="\u7cfb\u7edf\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53"), @CodeItem(value="DESYSBICUBES", text="\u7cfb\u7edf\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53\uff08\u5b9e\u4f53\u76f8\u5173\uff09", realtext="\u7cfb\u7edf\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53\uff08\u5b9e\u4f53\u76f8\u5173\uff09"), @CodeItem(value="ALLSYSBICUBES", text="\u7cfb\u7edf\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53\uff08\u5168\u90e8\uff09", realtext="\u7cfb\u7edf\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53\uff08\u5168\u90e8\uff09"), @CodeItem(value="SYSBIREPORT", text="\u7cfb\u7edf\u667a\u80fd\u62a5\u8868", realtext="\u7cfb\u7edf\u667a\u80fd\u62a5\u8868"), @CodeItem(value="DESYSBIREPORTS", text="\u7cfb\u7edf\u667a\u80fd\u62a5\u8868\uff08\u5b9e\u4f53\u76f8\u5173\uff09", realtext="\u7cfb\u7edf\u667a\u80fd\u62a5\u8868\uff08\u5b9e\u4f53\u76f8\u5173\uff09"), @CodeItem(value="SYSBICUBEREPORTS", text="\u7cfb\u7edf\u667a\u80fd\u62a5\u8868\uff08\u7acb\u65b9\u4f53\u76f8\u5173\uff09", realtext="\u7cfb\u7edf\u667a\u80fd\u62a5\u8868\uff08\u7acb\u65b9\u4f53\u76f8\u5173\uff09"), @CodeItem(value="ALLSYSBIREPORTS", text="\u7cfb\u7edf\u667a\u80fd\u62a5\u8868\uff08\u5168\u90e8\uff09", realtext="\u7cfb\u7edf\u667a\u80fd\u62a5\u8868\uff08\u5168\u90e8\uff09"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class ReportTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String POI_TL = "POI_TL";
    public static final String ANTVG6 = "ANTVG6";
    public static final String LUCKYSHEET = "LUCKYSHEET";
    public static final String AVUEDATA = "AVUEDATA";
    public static final String AVUEDATA_CLOUD = "AVUEDATA_CLOUD";
    public static final String GRAFANA = "GRAFANA";
    public static final String DATAEASE = "DATAEASE";
    public static final String JR = "JR";
    public static final String HTML = "HTML";
    public static final String MARKDOWN = "MARKDOWN";
    public static final String SYSBICUBE = "SYSBICUBE";
    public static final String DESYSBICUBES = "DESYSBICUBES";
    public static final String ALLSYSBICUBES = "ALLSYSBICUBES";
    public static final String SYSBIREPORT = "SYSBIREPORT";
    public static final String DESYSBIREPORTS = "DESYSBIREPORTS";
    public static final String SYSBICUBEREPORTS = "SYSBICUBEREPORTS";
    public static final String ALLSYSBIREPORTS = "ALLSYSBIREPORTS";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public ReportTypeCodeListModel() {
        this.initAnnotation(ReportTypeCodeListModel.class);
        this.setUserData2("ReportType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ReportTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ReportTypeCodeListModel");
    }
}

