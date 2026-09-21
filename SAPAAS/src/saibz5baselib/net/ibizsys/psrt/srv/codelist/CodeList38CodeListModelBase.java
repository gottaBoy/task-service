/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="2970295eebeaab891a13f1634eadb668", name="\u670d\u52a1\u8fd0\u884c\u72b6\u6001", type="STATIC", userscope=false)
@CodeItems(value={@CodeItem(value="START", text="\u542f\u52a8", realtext="\u542f\u52a8"), @CodeItem(value="STOP", text="\u505c\u6b62", realtext="\u505c\u6b62")})
public abstract class CodeList38CodeListModelBase
extends StaticCodeListModelBase {
    public static final String START = "START";
    public static final String STOP = "STOP";

    public CodeList38CodeListModelBase() {
        this.initAnnotation(CodeList38CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList38CodeListModel", this);
    }
}

