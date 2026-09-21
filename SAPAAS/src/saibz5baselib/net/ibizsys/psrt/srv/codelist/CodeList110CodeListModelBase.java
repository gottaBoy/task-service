/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="cb40f89c998132ba192bca103ba680ef", name="\u5b9e\u4f53\u89c4\u5219\u5904\u7406_\u503c\u5904\u7406\u51fd\u6570", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="DATE_DIFF_D", text="\u8ddd\u4eca\u5929\u6570\uff08\u65e5\u671f\uff09", realtext="\u8ddd\u4eca\u5929\u6570\uff08\u65e5\u671f\uff09"), @CodeItem(value="DATE_DIFF_W", text="\u8ddd\u4eca\u5468\u6570\uff08\u65e5\u671f\uff09", realtext="\u8ddd\u4eca\u5468\u6570\uff08\u65e5\u671f\uff09"), @CodeItem(value="DATE_DIFF_M", text="\u8ddd\u4eca\u6708\u4efd\u6570\uff08\u65e5\u671f\uff09", realtext="\u8ddd\u4eca\u6708\u4efd\u6570\uff08\u65e5\u671f\uff09"), @CodeItem(value="DATE_DIFF_Q", text="\u8ddd\u4eca\u5b63\u5ea6\u6570\uff08\u65e5\u671f\uff09", realtext="\u8ddd\u4eca\u5b63\u5ea6\u6570\uff08\u65e5\u671f\uff09"), @CodeItem(value="DATE_DIFF_Y", text="\u8ddd\u4eca\u5e74\u6570\uff08\u65e5\u671f\uff09", realtext="\u8ddd\u4eca\u5e74\u6570\uff08\u65e5\u671f\uff09")})
public abstract class CodeList110CodeListModelBase
extends StaticCodeListModelBase {
    public static final String DATE_DIFF_D = "DATE_DIFF_D";
    public static final String DATE_DIFF_W = "DATE_DIFF_W";
    public static final String DATE_DIFF_M = "DATE_DIFF_M";
    public static final String DATE_DIFF_Q = "DATE_DIFF_Q";
    public static final String DATE_DIFF_Y = "DATE_DIFF_Y";

    public CodeList110CodeListModelBase() {
        this.initAnnotation(CodeList110CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList110CodeListModel", this);
    }
}

