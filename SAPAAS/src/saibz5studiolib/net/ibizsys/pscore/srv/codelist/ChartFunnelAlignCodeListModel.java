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

@CodeList(id="A408FEB6-81C8-4B16-BFBC-C4C0FAD3B647", name="\u6f0f\u6597\u56fe\u65b9\u5411", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="center", text="\u5267\u4e2d", realtext="\u5267\u4e2d"), @CodeItem(value="left", text="\u5de6\u4fa7", realtext="\u5de6\u4fa7"), @CodeItem(value="right", text="\u53f3\u4fa7", realtext="\u53f3\u4fa7")})
public class ChartFunnelAlignCodeListModel
extends StaticCodeListModelBase {
    public static final String CENTER = "center";
    public static final String LEFT = "left";
    public static final String RIGHT = "right";

    public ChartFunnelAlignCodeListModel() {
        this.initAnnotation(ChartFunnelAlignCodeListModel.class);
        this.setUserData("IGNOREMODELDSLNAME");
        this.setUserData2("ChartFunnelAlign");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartFunnelAlignCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartFunnelAlignCodeListModel");
    }
}

