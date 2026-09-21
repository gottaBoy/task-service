/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="81e4a2fad174062abec0154ca7ee92cc", name="\u5de5\u4f5c\u65f6\u95f4\u4ee3\u7801\u8868", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="WORKTIME_WEEK1", text="\u6bcf\u5468\u4e00\u81f3\u6bcf\u5468\u4e94\uff0c9\uff5e12\uff0c13\uff5e18", realtext="\u6bcf\u5468\u4e00\u81f3\u6bcf\u5468\u4e94\uff0c9\uff5e12\uff0c13\uff5e18")})
public abstract class CodeList49CodeListModelBase
extends StaticCodeListModelBase {
    public static final String WORKTIME_WEEK1 = "WORKTIME_WEEK1";

    public CodeList49CodeListModelBase() {
        this.initAnnotation(CodeList49CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList49CodeListModel", this);
    }
}

