/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="f4eba8faeb176761d0a128944afae743", name="\u4ee3\u7801\u53d1\u5e03\u8def\u5f84", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="DEFAULT", text="\u9ed8\u8ba4", realtext="\u9ed8\u8ba4")})
public abstract class CodeList116CodeListModelBase
extends StaticCodeListModelBase {
    public static final String DEFAULT = "DEFAULT";

    public CodeList116CodeListModelBase() {
        this.initAnnotation(CodeList116CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList116CodeListModel", this);
    }
}

