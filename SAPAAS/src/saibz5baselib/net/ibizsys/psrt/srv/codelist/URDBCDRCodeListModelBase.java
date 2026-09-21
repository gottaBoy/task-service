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

@CodeList(id="9B2D286D-54EB-4586-BA34-57C963DA276A", name="\u6570\u636e\u5bf9\u8c61\u80fd\u529b\u6761\u7ebf\u6570\u636e\u8303\u56f4", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u5f53\u524d\u6761\u7ebf", realtext="\u5f53\u524d\u6761\u7ebf")})
public abstract class URDBCDRCodeListModelBase
extends StaticCodeListModelBase {
    public static final Integer CURBC = 1;
    public static final int INT_CURBC = 1;

    public URDBCDRCodeListModelBase() {
        this.initAnnotation(URDBCDRCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.URDBCDRCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.URDBCDRCodeListModel");
    }
}

