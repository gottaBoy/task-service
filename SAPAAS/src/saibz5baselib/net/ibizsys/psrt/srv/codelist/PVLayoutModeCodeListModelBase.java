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

@CodeList(id="418F1DBE-278E-46A8-9A0D-2A6B603FAA81", name="\u95e8\u6237\u89c6\u56fe\u81ea\u5b9a\u4e49\u5e03\u5c40", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="70P_30P", text="\u5de6\u53f3\u5e03\u5c40\uff0870%;30%\uff09", realtext="\u5de6\u53f3\u5e03\u5c40\uff0870%;30%\uff09"), @CodeItem(value="30P_70P", text="\u5de6\u53f3\u5e03\u5c40\uff0830%;70%\uff09", realtext="\u5de6\u53f3\u5e03\u5c40\uff0830%;70%\uff09"), @CodeItem(value="50P_50P", text="\u5de6\u53f3\u5e03\u5c40\uff0850%;50%\uff09", realtext="\u5de6\u53f3\u5e03\u5c40\uff0850%;50%\uff09")})
public abstract class PVLayoutModeCodeListModelBase
extends StaticCodeListModelBase {
    public static final String ITEM_1 = "70P_30P";
    public static final String ITEM_2 = "30P_70P";
    public static final String ITEM_3 = "50P_50P";

    public PVLayoutModeCodeListModelBase() {
        this.initAnnotation(PVLayoutModeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.PVLayoutModeCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.PVLayoutModeCodeListModel");
    }
}

