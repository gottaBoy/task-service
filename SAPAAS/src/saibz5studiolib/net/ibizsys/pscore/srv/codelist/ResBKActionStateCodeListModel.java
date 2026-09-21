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

@CodeList(id="cd48e3bdfcdeeebb764e91a0e86d3ac9", name="\u8d44\u6e90\u5907\u4efd/\u6062\u590d\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u672a\u8fdb\u884c", realtext="\u672a\u8fdb\u884c"), @CodeItem(value="1", text="\u5904\u7406\u6210\u529f", realtext="\u5904\u7406\u6210\u529f"), @CodeItem(value="2", text="\u5904\u7406\u5931\u8d25", realtext="\u5904\u7406\u5931\u8d25")})
public class ResBKActionStateCodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM_0 = "0";
    public static final String ITEM_1 = "1";
    public static final String ITEM_2 = "2";

    public ResBKActionStateCodeListModel() {
        this.initAnnotation(ResBKActionStateCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ResBKActionStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ResBKActionStateCodeListModel");
    }
}

