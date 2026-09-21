/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="4610c74bc5c254392112c4e93c3bc88b", name="\u65e5\u5386\u3001\u90ae\u4ef6\u91cd\u8981\u7a0b\u5ea6", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="HIGH", text="\u9ad8", realtext="\u9ad8"), @CodeItem(value="NORMAL", text="\u666e\u901a", realtext="\u666e\u901a"), @CodeItem(value="LOW", text="\u4f4e", realtext="\u4f4e")})
public abstract class CodeList8CodeListModelBase
extends StaticCodeListModelBase {
    public static final String HIGH = "HIGH";
    public static final String NORMAL = "NORMAL";
    public static final String LOW = "LOW";

    public CodeList8CodeListModelBase() {
        this.initAnnotation(CodeList8CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList8CodeListModel", this);
    }
}

