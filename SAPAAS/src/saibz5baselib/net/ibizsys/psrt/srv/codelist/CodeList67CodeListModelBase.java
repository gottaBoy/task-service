/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="eb8af7f386769a697bf23b11e4d480b8", name="DB2\u89e6\u53d1\u5668\u4ee3\u7801\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="For Each Row", text="For Each Row", realtext="For Each Row"), @CodeItem(value="For Each Statement", text="For Each Statement", realtext="For Each Statement")})
public abstract class CodeList67CodeListModelBase
extends StaticCodeListModelBase {
    public static final String FOR_EACH_ROW = "For Each Row";
    public static final String FOR_EACH_STATEMENT = "For Each Statement";

    public CodeList67CodeListModelBase() {
        this.initAnnotation(CodeList67CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList67CodeListModel", this);
    }
}

