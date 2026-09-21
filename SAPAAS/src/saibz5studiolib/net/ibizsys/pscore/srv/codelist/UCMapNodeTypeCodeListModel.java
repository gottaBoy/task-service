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

@CodeList(id="aa813f23907f916142603695071e0835", name="\u7528\u4f8b\u56fe\u8282\u70b9\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="\u64cd\u4f5c\u8005", text="ACTOR", realtext="ACTOR"), @CodeItem(value="\u7528\u4f8b", text="USECASE", realtext="USECASE"), @CodeItem(value="ACTOR", text="\u64cd\u4f5c\u8005", realtext="\u64cd\u4f5c\u8005"), @CodeItem(value="USECASE", text="\u7528\u4f8b", realtext="\u7528\u4f8b")})
public class UCMapNodeTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM_1 = "\u64cd\u4f5c\u8005";
    public static final String ITEM_2 = "\u7528\u4f8b";
    public static final String ACTOR = "ACTOR";
    public static final String USECASE = "USECASE";

    public UCMapNodeTypeCodeListModel() {
        this.initAnnotation(UCMapNodeTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.UCMapNodeTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.UCMapNodeTypeCodeListModel");
    }
}

