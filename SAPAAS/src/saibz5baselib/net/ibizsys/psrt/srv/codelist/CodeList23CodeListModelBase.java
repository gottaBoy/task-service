/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="e2dfb10528565db08a337a4fa25ce1b2", name="DA\u65e5\u5fd7\u5bf9\u8c61\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="DATAENTITY", text="\u5b9e\u4f53", realtext="\u5b9e\u4f53"), @CodeItem(value="DEFIELD", text="\u5b9e\u4f53\u5c5e\u6027", realtext="\u5b9e\u4f53\u5c5e\u6027"), @CodeItem(value="DER1N", text="\u5b9e\u4f53\u5173\u7cfb", realtext="\u5b9e\u4f53\u5173\u7cfb")})
public abstract class CodeList23CodeListModelBase
extends StaticCodeListModelBase {
    public static final String DATAENTITY = "DATAENTITY";
    public static final String DEFIELD = "DEFIELD";
    public static final String DER1N = "DER1N";

    public CodeList23CodeListModelBase() {
        this.initAnnotation(CodeList23CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList23CodeListModel", this);
    }
}

