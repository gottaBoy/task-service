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

@CodeList(id="FF9B0FDA-D745-4697-9F38-D77B3700E115", name="\u90e8\u4ef6\u5206\u7ec4\u6837\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\u6837\u5f0f\uff09")
@CodeItems(value={@CodeItem(value="DEFAULT", text="\u9ed8\u8ba4\u6837\u5f0f", realtext="\u9ed8\u8ba4\u6837\u5f0f"), @CodeItem(value="STYLE2", text="\u6837\u5f0f2", realtext="\u6837\u5f0f2"), @CodeItem(value="STYLE3", text="\u6837\u5f0f3", realtext="\u6837\u5f0f3"), @CodeItem(value="STYLE4", text="\u6837\u5f0f4", realtext="\u6837\u5f0f4")})
public class CtrlGroupStyleCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFAULT = "DEFAULT";
    public static final String STYLE2 = "STYLE2";
    public static final String STYLE3 = "STYLE3";
    public static final String STYLE4 = "STYLE4";

    public CtrlGroupStyleCodeListModel() {
        this.initAnnotation(CtrlGroupStyleCodeListModel.class);
        this.setUserData2("CtrlGroupStyle");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.CtrlGroupStyleCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.CtrlGroupStyleCodeListModel");
    }
}

