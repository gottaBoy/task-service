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

@CodeList(id="e395eb25080d31b9dad2d09292866e1f", name="\u8868\u5355\u6837\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="INFOPANEL", text="\u4fe1\u606f\u9762\u677f", realtext="\u4fe1\u606f\u9762\u677f"), @CodeItem(value="INFOPANEL2", text="\u4fe1\u606f\u9762\u677f2", realtext="\u4fe1\u606f\u9762\u677f2"), @CodeItem(value="MOBINFOPANEL", text="\u79fb\u52a8\u7aef\u4fe1\u606f\u9762\u677f", realtext="\u79fb\u52a8\u7aef\u4fe1\u606f\u9762\u677f"), @CodeItem(value="MOBINFOPANEL2", text="\u79fb\u52a8\u7aef\u4fe1\u606f\u9762\u677f2", realtext="\u79fb\u52a8\u7aef\u4fe1\u606f\u9762\u677f2"), @CodeItem(value="SEARCHBAR", text="\u641c\u7d22\u680f", realtext="\u641c\u7d22\u680f"), @CodeItem(value="SEARCHBAR2", text="\u641c\u7d22\u680f2", realtext="\u641c\u7d22\u680f2"), @CodeItem(value="MOBSEARCHBAR", text="\u79fb\u52a8\u7aef\u641c\u7d22\u680f", realtext="\u79fb\u52a8\u7aef\u641c\u7d22\u680f"), @CodeItem(value="MOBSEARCHBAR2", text="\u79fb\u52a8\u7aef\u641c\u7d22\u680f2", realtext="\u79fb\u52a8\u7aef\u641c\u7d22\u680f2")})
public class FormStyleCodeListModel
extends StaticCodeListModelBase {
    public static final String INFOPANEL = "INFOPANEL";
    public static final String INFOPANEL2 = "INFOPANEL2";
    public static final String MOBINFOPANEL = "MOBINFOPANEL";
    public static final String MOBINFOPANEL2 = "MOBINFOPANEL2";
    public static final String SEARCHBAR = "SEARCHBAR";
    public static final String SEARCHBAR2 = "SEARCHBAR2";
    public static final String MOBSEARCHBAR = "MOBSEARCHBAR";
    public static final String MOBSEARCHBAR2 = "MOBSEARCHBAR2";

    public FormStyleCodeListModel() {
        this.initAnnotation(FormStyleCodeListModel.class);
        this.setUserData2("FormStyle");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FormStyleCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FormStyleCodeListModel");
    }
}

