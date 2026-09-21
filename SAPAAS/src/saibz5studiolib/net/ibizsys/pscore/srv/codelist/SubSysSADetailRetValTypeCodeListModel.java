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

@CodeList(id="2DA8F6E2-6011-4C77-8E2A-DED6E39C268D", name="\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u884c\u4e3a\u8fd4\u56de\u503c\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="VOID", text="\u65e0\uff08void\uff09", realtext="\u65e0\uff08void\uff09"), @CodeItem(value="SIMPLE", text="\u7b80\u5355\u503c", realtext="\u7b80\u5355\u503c"), @CodeItem(value="SIMPLES", text="\u7b80\u5355\u503c\u6570\u7ec4", realtext="\u7b80\u5355\u503c\u6570\u7ec4"), @CodeItem(value="ENTITY", text="\u6570\u636e\u5bf9\u8c61", realtext="\u6570\u636e\u5bf9\u8c61"), @CodeItem(value="ENTITIES", text="\u6570\u636e\u5bf9\u8c61\u6570\u7ec4", realtext="\u6570\u636e\u5bf9\u8c61\u6570\u7ec4"), @CodeItem(value="PAGE", text="\u641c\u7d22\u5206\u9875", realtext="\u641c\u7d22\u5206\u9875"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49\uff08USER\uff09", realtext="\u7528\u6237\u81ea\u5b9a\u4e49\uff08USER\uff09"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492\uff08USER2\uff09", realtext="\u7528\u6237\u81ea\u5b9a\u4e492\uff08USER2\uff09")})
public class SubSysSADetailRetValTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String VOID = "VOID";
    public static final String SIMPLE = "SIMPLE";
    public static final String SIMPLES = "SIMPLES";
    public static final String ENTITY = "ENTITY";
    public static final String ENTITIES = "ENTITIES";
    public static final String PAGE = "PAGE";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public SubSysSADetailRetValTypeCodeListModel() {
        this.initAnnotation(SubSysSADetailRetValTypeCodeListModel.class);
        this.setUserData2("SubSysSADetailRetType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SubSysSADetailRetValTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SubSysSADetailRetValTypeCodeListModel");
    }
}

