/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="d2a0cb8de72772d12d793c7c8f860866", name="\u7269\u7406\u4fe1\u606f\u66f4\u65b0\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="UPDATEWHENMODIFY", text="\u53d8\u66f4\u65f6\u66f4\u65b0", realtext="\u53d8\u66f4\u65f6\u66f4\u65b0")})
public abstract class CodeList57CodeListModelBase
extends StaticCodeListModelBase {
    public static final String UPDATEWHENMODIFY = "UPDATEWHENMODIFY";

    public CodeList57CodeListModelBase() {
        this.initAnnotation(CodeList57CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList57CodeListModel", this);
    }
}

