/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="411E3062-CE37-4A19-9BBD-782E474249FA", name="\u6570\u636e\u5bf9\u8c61\u80fd\u529b\u90e8\u95e8\u6570\u636e\u8303\u56f4", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u5f53\u524d\u90e8\u95e8", realtext="\u5f53\u524d\u90e8\u95e8"), @CodeItem(value="2", text="\u4e0a\u7ea7\u90e8\u95e8", realtext="\u4e0a\u7ea7\u90e8\u95e8"), @CodeItem(value="4", text="\u4e0b\u7ea7\u90e8\u95e8", realtext="\u4e0b\u7ea7\u90e8\u95e8")})
public abstract class URDSecDRCodeListModelBase
extends StaticCodeListModelBase {
    public static final Integer ITEM_1 = 1;
    public static final int INT_ITEM_1 = 1;
    public static final Integer ITEM_2 = 2;
    public static final int INT_ITEM_2 = 2;
    public static final Integer ITEM_4 = 4;
    public static final int INT_ITEM_4 = 4;

    public URDSecDRCodeListModelBase() {
        this.initAnnotation(URDSecDRCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.URDSecDRCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.URDSecDRCodeListModel");
    }
}

