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

@CodeList(id="f6a2fcc55f8bf269af1bac69ea69a4e0", name="\u667a\u80fd\u7acb\u65b9\u4f53\u7ef4\u5ea6\u805a\u5408\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SUM", text="\u5408\u8ba1", realtext="\u5408\u8ba1"), @CodeItem(value="AVG", text="\u5e73\u5747", realtext="\u5e73\u5747"), @CodeItem(value="MAX", text="\u6700\u5927\u503c", realtext="\u6700\u5927\u503c"), @CodeItem(value="MIN", text="\u6700\u5c0f\u503c", realtext="\u6700\u5c0f\u503c"), @CodeItem(value="COUNT", text="\u8ba1\u6570", realtext="\u8ba1\u6570"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class DERDERMapTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SUM = "SUM";
    public static final String AVG = "AVG";
    public static final String MAX = "MAX";
    public static final String MIN = "MIN";
    public static final String COUNT = "COUNT";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public DERDERMapTypeCodeListModel() {
        this.initAnnotation(DERDERMapTypeCodeListModel.class);
        this.setUserData2("BIMeasureAggMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DERDERMapTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DERDERMapTypeCodeListModel");
    }
}

