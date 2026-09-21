/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="68dd60d14c29a2fc32023733a3dc4e33", name="\u9875\u9762\u8d44\u6e90\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0\u8d44\u6e90", realtext="\u65e0\u8d44\u6e90"), @CodeItem(value="DEDATA", text="\u6570\u636e\u64cd\u4f5c", realtext="\u6570\u636e\u64cd\u4f5c"), @CodeItem(value="PAGE", text="\u9875\u9762\u5bf9\u8c61", realtext="\u9875\u9762\u5bf9\u8c61"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49")})
public abstract class CodeList17CodeListModelBase
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String DEDATA = "DEDATA";
    public static final String PAGE = "PAGE";
    public static final String CUSTOM = "CUSTOM";

    public CodeList17CodeListModelBase() {
        this.initAnnotation(CodeList17CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList17CodeListModel", this);
    }
}

