/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="b2d07f091fbac36e499f4904f56d4b41", name="\u6570\u636e\u901a\u77e5\u76d1\u63a7\u884c\u4e3a", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="1", text="\u65b0\u5efa", realtext="\u65b0\u5efa"), @CodeItem(value="2", text="\u66f4\u65b0", realtext="\u66f4\u65b0"), @CodeItem(value="3", text="\u65b0\u5efa\u6216\u66f4\u65b0", realtext="\u65b0\u5efa\u6216\u66f4\u65b0"), @CodeItem(value="4", text="\u5220\u9664", realtext="\u5220\u9664")})
public abstract class CodeList72CodeListModelBase
extends StaticCodeListModelBase {
    public static final String ITEM_1 = "1";
    public static final String ITEM_2 = "2";
    public static final String ITEM_3 = "3";
    public static final String ITEM_4 = "4";

    public CodeList72CodeListModelBase() {
        this.initAnnotation(CodeList72CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList72CodeListModel", this);
    }
}

