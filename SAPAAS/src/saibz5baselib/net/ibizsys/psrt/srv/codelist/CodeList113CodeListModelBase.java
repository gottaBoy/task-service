/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="c821c14e8cbf700654b01dbe618ec7b5", name="\u9875\u9762\u8df3\u8f6c\u5904\u7406_\u9875\u9762\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="PAGE", text="\u5185\u7f6e\u9875\u9762", realtext="\u5185\u7f6e\u9875\u9762"), @CodeItem(value="URL", text="\u7f51\u9875\u8def\u5f84", realtext="\u7f51\u9875\u8def\u5f84"), @CodeItem(value="SCRIPT", text="\u811a\u672c", realtext="\u811a\u672c")})
public abstract class CodeList113CodeListModelBase
extends StaticCodeListModelBase {
    public static final String PAGE = "PAGE";
    public static final String URL = "URL";
    public static final String SCRIPT = "SCRIPT";

    public CodeList113CodeListModelBase() {
        this.initAnnotation(CodeList113CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList113CodeListModel", this);
    }
}

