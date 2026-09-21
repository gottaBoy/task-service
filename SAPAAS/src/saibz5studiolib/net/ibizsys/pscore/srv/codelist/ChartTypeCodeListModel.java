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

@CodeList(id="94a0b9373ca0c847d0368be44a92345d", name="\u5b9e\u4f53\u56fe\u8868\u5e8f\u5217\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="area", text="\u533a\u57df\u56fe(Area)", realtext="\u533a\u57df\u56fe(Area)"), @CodeItem(value="bar", text="\u6761\u5f62\u56fe(Bar)", realtext="\u6761\u5f62\u56fe(Bar)"), @CodeItem(value="bar3d", text="\u6761\u5f62\u56fe3D(\u65e7)(Bar3D)", realtext="\u6761\u5f62\u56fe3D(\u65e7)(Bar3D)"), @CodeItem(value="candlestick", text="K\u7ebf\u56fe(Candlestick)", realtext="K\u7ebf\u56fe(Candlestick)"), @CodeItem(value="gauge", text="\u4eea\u8868\u76d8(Gauge)", realtext="\u4eea\u8868\u76d8(Gauge)"), @CodeItem(value="line", text="\u6298\u7ebf\u56fe(Line)", realtext="\u6298\u7ebf\u56fe(Line)"), @CodeItem(value="pie", text="\u997c\u56fe(Pie)", realtext="\u997c\u56fe(Pie)"), @CodeItem(value="pie3d", text="\u997c\u56fe3D(\u65e7)(Pie3D)", realtext="\u997c\u56fe3D(\u65e7)(Pie3D)"), @CodeItem(value="radar", text="\u96f7\u8fbe\u56fe(Radar)", realtext="\u96f7\u8fbe\u56fe(Radar)"), @CodeItem(value="scatter", text="\u6563\u70b9\u56fe(Scatter)", realtext="\u6563\u70b9\u56fe(Scatter)"), @CodeItem(value="column", text="\u67f1\u72b6\u56fe(Column)", realtext="\u67f1\u72b6\u56fe(Column)"), @CodeItem(value="funnel", text="\u6f0f\u6597\u56fe(Funnel)", realtext="\u6f0f\u6597\u56fe(Funnel)"), @CodeItem(value="map", text="\u5730\u56fe(Map)", realtext="\u5730\u56fe(Map)"), @CodeItem(value="custom", text="\u81ea\u5b9a\u4e49(Custom)", realtext="\u81ea\u5b9a\u4e49(Custom)")})
public class ChartTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String AREA = "area";
    public static final String BAR = "bar";
    public static final String BAR3D = "bar3d";
    public static final String CANDLESTICK = "candlestick";
    public static final String GAUGE = "gauge";
    public static final String LINE = "line";
    public static final String PIE = "pie";
    public static final String PIE3D = "pie3d";
    public static final String RADAR = "radar";
    public static final String SCATTER = "scatter";
    public static final String COLUMN = "column";
    public static final String FUNNEL = "funnel";
    public static final String MAP = "map";
    public static final String CUSTOM = "custom";

    public ChartTypeCodeListModel() {
        this.initAnnotation(ChartTypeCodeListModel.class);
        this.setUserData2("ChartType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartTypeCodeListModel");
    }
}

