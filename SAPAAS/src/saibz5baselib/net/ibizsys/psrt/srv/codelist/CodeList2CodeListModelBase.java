/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="3266fc1690f0742cc46c0827b2d3f655", name="\u5b9e\u4f53\u5c5e\u6027\u66f4\u65b0\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="VERSION", text="\u7248\u672c\u6a21\u5f0f", realtext="\u7248\u672c\u6a21\u5f0f")})
public abstract class CodeList2CodeListModelBase
extends StaticCodeListModelBase {
    public static final String VERSION = "VERSION";

    public CodeList2CodeListModelBase() {
        this.initAnnotation(CodeList2CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList2CodeListModel", this);
    }
}

