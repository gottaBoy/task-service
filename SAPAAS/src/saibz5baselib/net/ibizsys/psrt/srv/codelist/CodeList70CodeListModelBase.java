/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="5bd615c5ef0d39a336b95a76142856b1", name="\u9875\u9762\u5904\u7406\u903b\u8f91\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="AFTERINITPAGEPARAM", text="\u9875\u9762\u53d8\u91cf\u521d\u59cb\u5316\u4e4b\u540e", realtext="\u9875\u9762\u53d8\u91cf\u521d\u59cb\u5316\u4e4b\u540e")})
public abstract class CodeList70CodeListModelBase
extends StaticCodeListModelBase {
    public static final String AFTERINITPAGEPARAM = "AFTERINITPAGEPARAM";

    public CodeList70CodeListModelBase() {
        this.initAnnotation(CodeList70CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList70CodeListModel", this);
    }
}

