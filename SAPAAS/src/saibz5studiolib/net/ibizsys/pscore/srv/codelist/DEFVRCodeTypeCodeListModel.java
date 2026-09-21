/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.CodeItem
 *  net.ibizsys.paas.codelist.CodeItems
 *  net.ibizsys.paas.codelist.CodeList
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 *  net.ibizsys.paas.sysmodel.StaticCodeListModelBase
 */
package net.ibizsys.pscore.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="2f0f96b9b7819cfefda204926c2406db", name="\u4e91\u5e73\u53f0\u5c5e\u6027\u89c4\u5219\u4ee3\u7801\u5927\u7c7b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PF", text="\u5e94\u7528\u6846\u67b6", realtext="\u5e94\u7528\u6846\u67b6"), @CodeItem(value="SF", text="\u670d\u52a1\u6846\u67b6", realtext="\u670d\u52a1\u6846\u67b6"), @CodeItem(value="DB", text="\u6570\u636e\u5e93", realtext="\u6570\u636e\u5e93")})
public class DEFVRCodeTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String PF = "PF";
    public static final String SF = "SF";
    public static final String DB = "DB";

    public DEFVRCodeTypeCodeListModel() {
        this.initAnnotation(DEFVRCodeTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFVRCodeTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFVRCodeTypeCodeListModel");
    }
}

