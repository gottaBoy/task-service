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

@CodeList(id="6976053095a20b4edb73733ef6fc230d", name="\u7cfb\u7edf\u5f00\u53d1\u4efb\u52a1\u7c7b\u578b", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="10", text="\u7cfb\u7edf\u9700\u6c42", realtext="\u7cfb\u7edf\u9700\u6c42"), @CodeItem(value="20", text="\u7cfb\u7edf\u8bbe\u8ba1", realtext="\u7cfb\u7edf\u8bbe\u8ba1"), @CodeItem(value="30", text="\u7cfb\u7edf\u5b9e\u73b0", realtext="\u7cfb\u7edf\u5b9e\u73b0"), @CodeItem(value="40", text="\u7cfb\u7edf\u6d4b\u8bd5", realtext="\u7cfb\u7edf\u6d4b\u8bd5"), @CodeItem(value="50", text="\u7cfb\u7edf\u90e8\u7f72", realtext="\u7cfb\u7edf\u90e8\u7f72")})
public class SysTaskTypeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer ITEM_10 = 10;
    public static final int INT_ITEM_10 = 10;
    public static final Integer ITEM_20 = 20;
    public static final int INT_ITEM_20 = 20;
    public static final Integer ITEM_30 = 30;
    public static final int INT_ITEM_30 = 30;
    public static final Integer ITEM_40 = 40;
    public static final int INT_ITEM_40 = 40;
    public static final Integer ITEM_50 = 50;
    public static final int INT_ITEM_50 = 50;

    public SysTaskTypeCodeListModel() {
        this.initAnnotation(SysTaskTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysTaskTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysTaskTypeCodeListModel");
    }
}

