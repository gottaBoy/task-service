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

@CodeList(id="90192271d9d5ec48537b9c030e59bed7", name="\u8fb9\u6846\u6837\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0\u8fb9\u6846", realtext="\u65e0\u8fb9\u6846"), @CodeItem(value="SOLID", text="\u5b9e\u7ebf\u8fb9\u6846", realtext="\u5b9e\u7ebf\u8fb9\u6846"), @CodeItem(value="DOTTED", text="\u70b9\u72b6\u8fb9\u6846", realtext="\u70b9\u72b6\u8fb9\u6846"), @CodeItem(value="DASHED", text="\u865a\u7ebf\u8fb9\u6846", realtext="\u865a\u7ebf\u8fb9\u6846"), @CodeItem(value="DOUBLE", text="\u53cc\u7ebf\u8fb9\u6846", realtext="\u53cc\u7ebf\u8fb9\u6846")})
public class BorderStyleCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String SOLID = "SOLID";
    public static final String DOTTED = "DOTTED";
    public static final String DASHED = "DASHED";
    public static final String DOUBLE = "DOUBLE";

    public BorderStyleCodeListModel() {
        this.initAnnotation(BorderStyleCodeListModel.class);
        this.setUserData2("BorderStyle");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.BorderStyleCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.BorderStyleCodeListModel");
    }
}

