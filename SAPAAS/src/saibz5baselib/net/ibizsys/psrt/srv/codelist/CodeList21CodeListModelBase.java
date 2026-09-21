/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="9c4e88e3d0474a60a18770fb4be7aeeb", name="\u4e3b\u5b9e\u4f53\u5220\u9664\u5173\u7cfb\u5b9e\u4f53\u64cd\u4f5c", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="1", text="\u540c\u65f6\u5220\u9664", realtext="\u540c\u65f6\u5220\u9664"), @CodeItem(value="2", text="\u7f6e\u7a7a", realtext="\u7f6e\u7a7a"), @CodeItem(value="3", text="\u9650\u5236\u5220\u9664", realtext="\u9650\u5236\u5220\u9664")})
public abstract class CodeList21CodeListModelBase
extends StaticCodeListModelBase {
    public static final String ITEM_1 = "1";
    public static final String ITEM_2 = "2";
    public static final String ITEM_3 = "3";

    public CodeList21CodeListModelBase() {
        this.initAnnotation(CodeList21CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList21CodeListModel", this);
    }
}

