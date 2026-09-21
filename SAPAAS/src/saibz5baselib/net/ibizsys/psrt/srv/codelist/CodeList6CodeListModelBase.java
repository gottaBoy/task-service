/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="82dce2142d49fbdeaf68cd418a3d6f3c", name="\u7f51\u9875\u90e8\u4ef6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="CHART", text="\u56fe\u5f62\u90e8\u4ef6", realtext="\u56fe\u5f62\u90e8\u4ef6"), @CodeItem(value="LIST", text="\u5217\u8868", realtext="\u5217\u8868"), @CodeItem(value="CUSTOMWP", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49")})
public abstract class CodeList6CodeListModelBase
extends StaticCodeListModelBase {
    public static final String CHART = "CHART";
    public static final String LIST = "LIST";
    public static final String CUSTOMWP = "CUSTOMWP";

    public CodeList6CodeListModelBase() {
        this.initAnnotation(CodeList6CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList6CodeListModel", this);
    }
}

