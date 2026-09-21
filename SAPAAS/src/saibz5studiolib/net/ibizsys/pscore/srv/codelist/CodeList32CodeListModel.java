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

@CodeList(id="c36cd0ab8678bfd55ee194a4e5a9da1e", name="\u65e5\u5fd7\u7ea7\u522b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="50000", text="\u81f4\u547d(FATAL)", realtext="\u81f4\u547d(FATAL)"), @CodeItem(value="40000", text="\u9519\u8bef(ERROR)", realtext="\u9519\u8bef(ERROR)"), @CodeItem(value="30000", text="\u8b66\u544a(WARN)", realtext="\u8b66\u544a(WARN)"), @CodeItem(value="20000", text="\u4fe1\u606f(INFO)", realtext="\u4fe1\u606f(INFO)"), @CodeItem(value="10000", text="\u8c03\u8bd5(DEBUG)", realtext="\u8c03\u8bd5(DEBUG)"), @CodeItem(value="5000", text="\u8c03\u8bd5(TRACE)", realtext="\u8c03\u8bd5(TRACE)")})
public class CodeList32CodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM_50000 = "50000";
    public static final String ITEM_40000 = "40000";
    public static final String ITEM_30000 = "30000";
    public static final String ITEM_20000 = "20000";
    public static final String ITEM_10000 = "10000";
    public static final String ITEM_5000 = "5000";

    public CodeList32CodeListModel() {
        this.initAnnotation(CodeList32CodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.CodeList32CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.CodeList32CodeListModel");
    }
}

