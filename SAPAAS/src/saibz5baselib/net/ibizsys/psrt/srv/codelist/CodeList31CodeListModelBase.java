/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="4b18fc77eaf8c1661becc3b67b1067f2", name="\u5f00\u53d1\u5e2e\u52a9\u91cd\u8981\u7a0b\u5ea6", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="LOW", text="\u4f4e", realtext="\u4f4e"), @CodeItem(value="NORMAIL", text="\u4e2d", realtext="\u4e2d"), @CodeItem(value="HIGH", text="\u9ad8", realtext="\u9ad8")})
public abstract class CodeList31CodeListModelBase
extends StaticCodeListModelBase {
    public static final String LOW = "LOW";
    public static final String NORMAIL = "NORMAIL";
    public static final String HIGH = "HIGH";

    public CodeList31CodeListModelBase() {
        this.initAnnotation(CodeList31CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList31CodeListModel", this);
    }
}

