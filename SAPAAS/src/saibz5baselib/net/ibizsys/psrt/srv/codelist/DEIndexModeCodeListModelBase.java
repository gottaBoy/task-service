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

@CodeList(id="99658ab2c11707b73ad6dd240ef4d93d", name="\u6570\u636e\u5b9e\u4f53_\u7d22\u5f15\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="1", text="\u4e3b\u952e\u9644\u52a0\u7c7b\u578b", realtext="\u4e3b\u952e\u9644\u52a0\u7c7b\u578b")})
public abstract class DEIndexModeCodeListModelBase
extends StaticCodeListModelBase {
    public static final String ITEM_1 = "1";

    public DEIndexModeCodeListModelBase() {
        this.initAnnotation(DEIndexModeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.DEIndexModeCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.DEIndexModeCodeListModel");
    }
}

