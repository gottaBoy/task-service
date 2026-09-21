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

@CodeList(id="6421a3f352ea42251ba1c5c5d5779268", name="\u4e91\u5e73\u53f0\u4ea7\u54c1\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u672a\u4e0a\u67b6", realtext="\u672a\u4e0a\u67b6"), @CodeItem(value="11", text="\u7533\u8bf7\u4e0a\u67b6", realtext="\u7533\u8bf7\u4e0a\u67b6"), @CodeItem(value="12", text="\u4e0a\u67b6\u7533\u8bf7\u88ab\u62d2\u7edd", realtext="\u4e0a\u67b6\u7533\u8bf7\u88ab\u62d2\u7edd"), @CodeItem(value="20", text="\u5df2\u4e0a\u67b6", realtext="\u5df2\u4e0a\u67b6"), @CodeItem(value="40", text="\u5df2\u4e0b\u67b6", realtext="\u5df2\u4e0b\u67b6")})
public class ProductStateCodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM_10 = "10";
    public static final String ITEM_11 = "11";
    public static final String ITEM_12 = "12";
    public static final String ITEM_20 = "20";
    public static final String ITEM_40 = "40";

    public ProductStateCodeListModel() {
        this.initAnnotation(ProductStateCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ProductStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ProductStateCodeListModel");
    }
}

