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

@CodeList(id="f4db95efae82ae7b9afea505bec3deef", name="\u5dee\u5f02\u9879\u540c\u6b65\u7ed3\u679c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="2", text="\u672a\u540c\u6b65", realtext="\u672a\u540c\u6b65"), @CodeItem(value="1", text="\u540c\u6b65\u6210\u529f", realtext="\u540c\u6b65\u6210\u529f"), @CodeItem(value="0", text="\u540c\u6b65\u5931\u8d25", realtext="\u540c\u6b65\u5931\u8d25")})
public class SysDiffItemSyncResultCodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM_2 = "2";
    public static final String ITEM_1 = "1";
    public static final String ITEM_0 = "0";

    public SysDiffItemSyncResultCodeListModel() {
        this.initAnnotation(SysDiffItemSyncResultCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDiffItemSyncResultCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDiffItemSyncResultCodeListModel");
    }
}

