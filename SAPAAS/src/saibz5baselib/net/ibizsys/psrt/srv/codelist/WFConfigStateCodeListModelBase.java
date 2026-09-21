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

@CodeList(id="02e68ecd17390b6a576481dc2b7105fb", name="\u5de5\u4f5c\u6d41\u914d\u7f6e\u72b6\u6001", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="1", text="\u6b63\u5e38\u72b6\u6001", realtext="\u6b63\u5e38\u72b6\u6001"), @CodeItem(value="2", text="\u6682\u505c\u72b6\u6001", realtext="\u6682\u505c\u72b6\u6001")})
public abstract class WFConfigStateCodeListModelBase
extends StaticCodeListModelBase {
    public static final String ITEM_1 = "1";
    public static final String ITEM_2 = "2";

    public WFConfigStateCodeListModelBase() {
        this.initAnnotation(WFConfigStateCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.WFConfigStateCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.WFConfigStateCodeListModel");
    }
}

