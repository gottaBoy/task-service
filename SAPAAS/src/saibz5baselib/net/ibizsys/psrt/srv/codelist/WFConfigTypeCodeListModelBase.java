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

@CodeList(id="d771544aaf079482d32250d80bc4d9b2", name="\u6d41\u7a0b\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="STATIC", text="\u9759\u6001\u6d41\u7a0b", realtext="\u9759\u6001\u6d41\u7a0b"), @CodeItem(value="DYNAMIC", text="\u52a8\u6001\u6d41\u7a0b", realtext="\u52a8\u6001\u6d41\u7a0b")})
public abstract class WFConfigTypeCodeListModelBase
extends StaticCodeListModelBase {
    public static final String STATIC = "STATIC";
    public static final String DYNAMIC = "DYNAMIC";

    public WFConfigTypeCodeListModelBase() {
        this.initAnnotation(WFConfigTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.WFConfigTypeCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.WFConfigTypeCodeListModel");
    }
}

