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

@CodeList(id="04d9f3b1fba109da46d2381b8c8c86a0", name="\u7edf\u4e00\u8d44\u6e90\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="PAGE", text="\u5185\u7f6e\u9875\u9762", realtext="\u5185\u7f6e\u9875\u9762"), @CodeItem(value="REPORT", text="\u62a5\u8868", realtext="\u62a5\u8868"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49")})
public abstract class UniResTypeCodeListModelBase
extends StaticCodeListModelBase {
    public static final String PAGE = "PAGE";
    public static final String REPORT = "REPORT";
    public static final String CUSTOM = "CUSTOM";

    public UniResTypeCodeListModelBase() {
        this.initAnnotation(UniResTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.UniResTypeCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.UniResTypeCodeListModel");
    }
}

