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

@CodeList(id="9D4B0DF3-EDE7-4446-9F82-D9710488E01C", name="\u7f16\u8f91\u8868\u5355\u6837\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="INFOPANEL", text="\u4fe1\u606f\u9762\u677f", realtext="\u4fe1\u606f\u9762\u677f"), @CodeItem(value="INFOPANEL2", text="\u4fe1\u606f\u9762\u677f2", realtext="\u4fe1\u606f\u9762\u677f2"), @CodeItem(value="MOBINFOPANEL", text="\u79fb\u52a8\u7aef\u4fe1\u606f\u9762\u677f", realtext="\u79fb\u52a8\u7aef\u4fe1\u606f\u9762\u677f"), @CodeItem(value="MOBINFOPANEL2", text="\u79fb\u52a8\u7aef\u4fe1\u606f\u9762\u677f2", realtext="\u79fb\u52a8\u7aef\u4fe1\u606f\u9762\u677f2"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class EditFormStyleCodeListModel
extends StaticCodeListModelBase {
    public static final String INFOPANEL = "INFOPANEL";
    public static final String INFOPANEL2 = "INFOPANEL2";
    public static final String MOBINFOPANEL = "MOBINFOPANEL";
    public static final String MOBINFOPANEL2 = "MOBINFOPANEL2";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public EditFormStyleCodeListModel() {
        this.initAnnotation(EditFormStyleCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.EditFormStyleCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.EditFormStyleCodeListModel");
    }
}

