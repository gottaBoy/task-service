/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="516d0e18b9dcabdf1f789d5af32b8ec1", name="\u5b9e\u4f53\u6570\u636e\u5904\u7406_\u6570\u636e\u64cd\u4f5c", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="INSERT", text="\u65b0\u5efa", realtext="\u65b0\u5efa"), @CodeItem(value="UPDATE", text="\u66f4\u65b0", realtext="\u66f4\u65b0"), @CodeItem(value="SAVE", text="\u4fdd\u5b58\uff08\u81ea\u52a8\u5224\u65ad\uff09", realtext="\u4fdd\u5b58\uff08\u81ea\u52a8\u5224\u65ad\uff09"), @CodeItem(value="DELETE", text="\u5220\u9664", realtext="\u5220\u9664"), @CodeItem(value="CUSTOMCALL", text="\u81ea\u5b9a\u4e49\u8c03\u7528", realtext="\u81ea\u5b9a\u4e49\u8c03\u7528"), @CodeItem(value="CUSTOMPROCCALL", text="\u81ea\u5b9a\u4e49\u5b58\u50a8\u8fc7\u7a0b\u8c03\u7528", realtext="\u81ea\u5b9a\u4e49\u5b58\u50a8\u8fc7\u7a0b\u8c03\u7528"), @CodeItem(value="CUSTOMRAWPROCCALL", text="\u81ea\u5b9a\u4e49\u5b58\u50a8\u8fc7\u7a0b\u8c03\u7528\uff08\u5168\u79f0\uff09", realtext="\u81ea\u5b9a\u4e49\u5b58\u50a8\u8fc7\u7a0b\u8c03\u7528\uff08\u5168\u79f0\uff09"), @CodeItem(value="GET", text="\u83b7\u53d6(GET)", realtext="\u83b7\u53d6(GET)"), @CodeItem(value="CHECKKEYSTATE", text="\u68c0\u67e5\u4e3b\u952e\u72b6\u6001(CHECKKEYSTATE)", realtext="\u68c0\u67e5\u4e3b\u952e\u72b6\u6001(CHECKKEYSTATE)")})
public abstract class CodeList108CodeListModelBase
extends StaticCodeListModelBase {
    public static final String INSERT = "INSERT";
    public static final String UPDATE = "UPDATE";
    public static final String SAVE = "SAVE";
    public static final String DELETE = "DELETE";
    public static final String CUSTOMCALL = "CUSTOMCALL";
    public static final String CUSTOMPROCCALL = "CUSTOMPROCCALL";
    public static final String CUSTOMRAWPROCCALL = "CUSTOMRAWPROCCALL";
    public static final String GET = "GET";
    public static final String CHECKKEYSTATE = "CHECKKEYSTATE";

    public CodeList108CodeListModelBase() {
        this.initAnnotation(CodeList108CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList108CodeListModel", this);
    }
}

