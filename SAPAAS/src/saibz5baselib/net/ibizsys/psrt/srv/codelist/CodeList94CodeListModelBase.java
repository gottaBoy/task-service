/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="20bce8400b92312729a0be0766058bb7", name="\u6811\u89c6\u56fe\u8282\u70b9\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="STATIC", text="\u9759\u6001", realtext="\u9759\u6001"), @CodeItem(value="DE", text="\u52a8\u6001\uff08\u5b9e\u4f53\uff09", realtext="\u52a8\u6001\uff08\u5b9e\u4f53\uff09"), @CodeItem(value="CODELIST", text="\u52a8\u6001\uff08\u4ee3\u7801\u8868\uff09", realtext="\u52a8\u6001\uff08\u4ee3\u7801\u8868\uff09")})
public abstract class CodeList94CodeListModelBase
extends StaticCodeListModelBase {
    public static final String STATIC = "STATIC";
    public static final String DE = "DE";
    public static final String CODELIST = "CODELIST";

    public CodeList94CodeListModelBase() {
        this.initAnnotation(CodeList94CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList94CodeListModel", this);
    }
}

