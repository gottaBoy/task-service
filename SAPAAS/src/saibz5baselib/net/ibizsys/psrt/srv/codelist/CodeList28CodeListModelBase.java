/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="35054a044be2d6284067b280814c7788", name="\u5217\u7f16\u8f91\u5668\u6837\u5f0f", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="DROPDOWNLIST", text="\u4e0b\u62c9\u5217\u8868\u6846", realtext="\u4e0b\u62c9\u5217\u8868\u6846"), @CodeItem(value="PICKER", text="\u6570\u636e\u9009\u62e9\u6846", realtext="\u6570\u636e\u9009\u62e9\u6846")})
public abstract class CodeList28CodeListModelBase
extends StaticCodeListModelBase {
    public static final String DROPDOWNLIST = "DROPDOWNLIST";
    public static final String PICKER = "PICKER";

    public CodeList28CodeListModelBase() {
        this.initAnnotation(CodeList28CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList28CodeListModel", this);
    }
}

