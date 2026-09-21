/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="e8488f575f42929d013c1204ac0708fa", name="\u65e5\u671f\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="1", text="\u6bcf\u5468", realtext="\u6bcf\u5468"), @CodeItem(value="2", text="\u6bcf\u6708", realtext="\u6bcf\u6708")})
public abstract class CodeList48CodeListModelBase
extends StaticCodeListModelBase {
    public static final String ITEM_1 = "1";
    public static final String ITEM_2 = "2";

    public CodeList48CodeListModelBase() {
        this.initAnnotation(CodeList48CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList48CodeListModel", this);
    }
}

