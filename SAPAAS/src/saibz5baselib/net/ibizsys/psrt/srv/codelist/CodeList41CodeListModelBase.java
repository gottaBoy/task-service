/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="05db5e133118bf8919ebfbb39b13f1a3", name="\u5b9e\u4f53\u5feb\u6377\u5e94\u7528\u8303\u56f4", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="1", text="\u62fe\u53d6\u94fe\u63a5", realtext="\u62fe\u53d6\u94fe\u63a5")})
public abstract class CodeList41CodeListModelBase
extends StaticCodeListModelBase {
    public static final String ITEM_1 = "1";

    public CodeList41CodeListModelBase() {
        this.initAnnotation(CodeList41CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList41CodeListModel", this);
    }
}

