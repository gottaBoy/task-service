/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="47c76377e18ef3bf9c6addef69400fce", name="\u6570\u636e\u901a\u77e5_\u65f6\u95f4\u6761\u4ef6", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="BEFORE", text="\u4e4b\u524d", realtext="\u4e4b\u524d"), @CodeItem(value="AFTER", text="\u4e4b\u540e", realtext="\u4e4b\u540e")})
public abstract class CodeList62CodeListModelBase
extends StaticCodeListModelBase {
    public static final String BEFORE = "BEFORE";
    public static final String AFTER = "AFTER";

    public CodeList62CodeListModelBase() {
        this.initAnnotation(CodeList62CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList62CodeListModel", this);
    }
}

