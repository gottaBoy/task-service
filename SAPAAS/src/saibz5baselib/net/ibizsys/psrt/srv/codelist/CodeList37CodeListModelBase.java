/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="0a17383cf8095d9796c32e74a8696e01", name="\u670d\u52a1\u542f\u52a8\u6a21\u5f0f", type="STATIC", userscope=false)
@CodeItems(value={@CodeItem(value="AUTO", text="\u81ea\u52a8", realtext="\u81ea\u52a8"), @CodeItem(value="MANUAL", text="\u624b\u52a8", realtext="\u624b\u52a8")})
public abstract class CodeList37CodeListModelBase
extends StaticCodeListModelBase {
    public static final String AUTO = "AUTO";
    public static final String MANUAL = "MANUAL";

    public CodeList37CodeListModelBase() {
        this.initAnnotation(CodeList37CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList37CodeListModel", this);
    }
}

