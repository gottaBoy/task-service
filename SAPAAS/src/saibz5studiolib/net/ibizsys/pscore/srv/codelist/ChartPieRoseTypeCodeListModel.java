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

@CodeList(id="1096E3C2-8D7F-4E67-BF02-F2AB142358C8", name="\u5b9e\u4f53\u56fe\u8868\u997c\u56fe\u5c55\u793a\u5357\u4e01\u683c\u5c14\u56fe\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="true", text="\u662f", realtext="\u662f"), @CodeItem(value="false", text="\u5426", realtext="\u5426"), @CodeItem(value="radius", text="\u5706\u5fc3\u89d2\u53ca\u534a\u5f84", realtext="\u5706\u5fc3\u89d2\u53ca\u534a\u5f84", userdata="\u6247\u533a\u5706\u5fc3\u89d2\u5c55\u73b0\u6570\u636e\u7684\u767e\u5206\u6bd4\uff0c\u534a\u5f84\u5c55\u73b0\u6570\u636e\u7684\u5927\u5c0f"), @CodeItem(value="area", text="\u4ec5\u534a\u5f84", realtext="\u4ec5\u534a\u5f84", userdata="\u6240\u6709\u6247\u533a\u5706\u5fc3\u89d2\u76f8\u540c\uff0c\u4ec5\u901a\u8fc7\u534a\u5f84\u5c55\u73b0\u6570\u636e\u5927\u5c0f")})
public class ChartPieRoseTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    public static final String RADIUS = "radius";
    public static final String AREA = "area";

    public ChartPieRoseTypeCodeListModel() {
        this.initAnnotation(ChartPieRoseTypeCodeListModel.class);
        this.setUserData2("ChartPieRoseType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartPieRoseTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartPieRoseTypeCodeListModel");
    }
}

