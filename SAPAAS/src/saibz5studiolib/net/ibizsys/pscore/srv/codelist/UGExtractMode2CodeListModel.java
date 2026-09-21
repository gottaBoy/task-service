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

@CodeList(id="4B8B6B60-D51A-475B-B3F5-38E0FD781D9B", name="\u754c\u9762\u884c\u4e3a\u7ec4\u5c55\u5f00\u6a21\u5f0f\uff08\u63d0\u4f9b\u65b0\u5206\u7ec4\u5c55\u5f00\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="ITEM", text="\u6309\u9879\u5c55\u5f00\uff08\u9ed8\u8ba4\uff09", realtext="\u6309\u9879\u5c55\u5f00\uff08\u9ed8\u8ba4\uff09", userdata="\u754c\u9762\u4e0a\u9010\u9879\u5c55\u5f00"), @CodeItem(value="ITEMS", text="\u6309\u5206\u7ec4\u5c55\u5f00", realtext="\u6309\u5206\u7ec4\u5c55\u5f00", userdata="\u754c\u9762\u4e0a\u4ec5\u63d0\u4f9b\u76ee\u5f55\u64cd\u4f5c\uff0c\u5982\u4e0b\u62c9\u663e\u793a\u754c\u9762\u884c\u4e3a\u7ec4\u7684\u884c\u4e3a\u96c6\u5408"), @CodeItem(value="ITEMX", text="\u9996\u9879+\u5206\u7ec4\u5c55\u5f00", realtext="\u9996\u9879+\u5206\u7ec4\u5c55\u5f00"), @CodeItem(value="ITEMS_NEW", text="\u6309\u5206\u7ec4\u5c55\u5f00\uff08\u65b0\uff09", realtext="\u6309\u5206\u7ec4\u5c55\u5f00\uff08\u65b0\uff09", userdata="\u754c\u9762\u4e0a\u4ec5\u63d0\u4f9b\u76ee\u5f55\u64cd\u4f5c\uff0c\u5982\u4e0b\u62c9\u663e\u793a\u754c\u9762\u884c\u4e3a\u7ec4\u7684\u884c\u4e3a\u96c6\u5408")})
public class UGExtractMode2CodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM = "ITEM";
    public static final String ITEMS = "ITEMS";
    public static final String ITEMX = "ITEMX";
    public static final String ITEMS_NEW = "ITEMS_NEW";

    public UGExtractMode2CodeListModel() {
        this.initAnnotation(UGExtractMode2CodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.UGExtractMode2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.UGExtractMode2CodeListModel");
    }
}

