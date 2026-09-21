/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="93712a5199ec3e74c7e45d0bf576d38d", name="\u5b57\u6bb5\u67e5\u8be2\u6269\u5c55\u9009\u9879", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="LIKE", text="LIKE\u5927\u5c0f\u5199\u654f\u611f", realtext="LIKE\u5927\u5c0f\u5199\u654f\u611f"), @CodeItem(value="=", text="=\uff08\u542b\u5176\u5b83\uff09\u5927\u5c0f\u5199\u654f\u611f", realtext="=\uff08\u542b\u5176\u5b83\uff09\u5927\u5c0f\u5199\u654f\u611f"), @CodeItem(value="LIKESPLIT", text="LIKE\u5206\u89e3", realtext="LIKE\u5206\u89e3")})
public abstract class CodeList60CodeListModelBase
extends StaticCodeListModelBase {
    public static final String LIKE = "LIKE";
    public static final String EQ = "=";
    public static final String LIKESPLIT = "LIKESPLIT";

    public CodeList60CodeListModelBase() {
        this.initAnnotation(CodeList60CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList60CodeListModel", this);
    }
}

