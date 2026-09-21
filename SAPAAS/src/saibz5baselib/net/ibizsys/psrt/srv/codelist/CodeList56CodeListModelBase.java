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

@CodeList(id="f9136e01a897256172bd4b56ecc222e0", name="\u672c\u5730\u8bed\u8a00", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="EN", text="\u82f1\u6587", realtext="\u82f1\u6587"), @CodeItem(value="ZH_CN", text="\u4e2d\u6587\u7b80\u4f53", realtext="\u4e2d\u6587\u7b80\u4f53"), @CodeItem(value="ZH_TW", text="\u4e2d\u6587\u7e41\u4f53\uff08\u53f0\u6e7e\uff09", realtext="\u4e2d\u6587\u7e41\u4f53\uff08\u53f0\u6e7e\uff09")})
public abstract class CodeList56CodeListModelBase
extends StaticCodeListModelBase {
    public static final String EN = "EN";
    public static final String ZH_CN = "ZH_CN";
    public static final String ZH_TW = "ZH_TW";

    public CodeList56CodeListModelBase() {
        this.initAnnotation(CodeList56CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList56CodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.CodeList56CodeListModel");
    }
}

