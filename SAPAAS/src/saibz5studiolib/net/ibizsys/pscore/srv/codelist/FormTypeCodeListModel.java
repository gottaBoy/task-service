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

@CodeList(id="2a54ad3d0fc539bb48f92fb5d9e520a9", name="\u8868\u5355\u6837\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="EDITFORM", text="\u7f16\u8f91\u8868\u5355", realtext="\u7f16\u8f91\u8868\u5355", iconcls="fa fa-pencil", iconpath="psformtype/icon_editform.png", iconpathx="psformtype/icon_editform@{0}x.png"), @CodeItem(value="SEARCHFORM", text="\u641c\u7d22\u8868\u5355", realtext="\u641c\u7d22\u8868\u5355", iconcls="fa fa-search", iconpath="psformtype/icon_searchform.png", iconpathx="psformtype/icon_searchform@{0}x.png")})
public class FormTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String EDITFORM = "EDITFORM";
    public static final String SEARCHFORM = "SEARCHFORM";

    public FormTypeCodeListModel() {
        this.initAnnotation(FormTypeCodeListModel.class);
        this.setUserData2("FormType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FormTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FormTypeCodeListModel");
    }
}

