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

@CodeList(id="9C23163B-9D1A-4822-A190-8072AD93C793", name="\u6570\u636e\u5bf9\u8c61\u80fd\u529b\u673a\u6784\u6570\u636e\u8303\u56f4", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u5f53\u524d\u673a\u6784", realtext="\u5f53\u524d\u673a\u6784"), @CodeItem(value="2", text="\u4e0a\u7ea7\u673a\u6784", realtext="\u4e0a\u7ea7\u673a\u6784"), @CodeItem(value="4", text="\u4e0b\u7ea7\u673a\u6784", realtext="\u4e0b\u7ea7\u673a\u6784")})
public abstract class URDOrgDRCodeListModelBase
extends StaticCodeListModelBase {
    public static final Integer ITEM_1 = 1;
    public static final int INT_ITEM_1 = 1;
    public static final Integer ITEM_2 = 2;
    public static final int INT_ITEM_2 = 2;
    public static final Integer ITEM_4 = 4;
    public static final int INT_ITEM_4 = 4;

    public URDOrgDRCodeListModelBase() {
        this.initAnnotation(URDOrgDRCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.URDOrgDRCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.URDOrgDRCodeListModel");
    }
}

