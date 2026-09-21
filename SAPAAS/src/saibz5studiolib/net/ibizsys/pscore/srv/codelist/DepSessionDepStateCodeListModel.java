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

@CodeList(id="3446b9efd94269ff87a97408666fd526", name="\u90e8\u7f72\u65b9\u6848\u90e8\u7f72\u64cd\u4f5c\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u672a\u90e8\u7f72", realtext="\u672a\u90e8\u7f72"), @CodeItem(value="1", text="\u90e8\u7f72\u4e2d", realtext="\u90e8\u7f72\u4e2d"), @CodeItem(value="2", text="\u90e8\u7f72\u6210\u529f", realtext="\u90e8\u7f72\u6210\u529f"), @CodeItem(value="9", text="\u90e8\u7f72\u5931\u8d25", realtext="\u90e8\u7f72\u5931\u8d25")})
public class DepSessionDepStateCodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM_0 = "0";
    public static final String ITEM_1 = "1";
    public static final String ITEM_2 = "2";
    public static final String ITEM_9 = "9";

    public DepSessionDepStateCodeListModel() {
        this.initAnnotation(DepSessionDepStateCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DepSessionDepStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DepSessionDepStateCodeListModel");
    }
}

