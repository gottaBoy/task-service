/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="86C55C56-0AD9-45BD-B914-AD21DE1E1479", name="\u95e8\u6237\u89c6\u56fe\u90e8\u4ef6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="LIST", text="\u5217\u8868", realtext="\u5217\u8868"), @CodeItem(value="CHART", text="\u56fe\u8868", realtext="\u56fe\u8868")})
public abstract class PVPartTypeCodeListModelBase
extends StaticCodeListModelBase {
    public static final String LIST = "LIST";
    public static final String CHART = "CHART";

    public PVPartTypeCodeListModelBase() {
        this.initAnnotation(PVPartTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.PVPartTypeCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.PVPartTypeCodeListModel");
    }
}

