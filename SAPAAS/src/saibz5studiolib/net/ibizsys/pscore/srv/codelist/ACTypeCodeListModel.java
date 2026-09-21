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

@CodeList(id="D4F9CD61-3357-44CB-A557-B05B26231D70", name="\u81ea\u52a8\u586b\u5145\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="AUTOCOMPLETE", text="\u81ea\u52a8\u586b\u5145", realtext="\u81ea\u52a8\u586b\u5145"), @CodeItem(value="CHATCOMPLETION", text="\u804a\u5929\u8865\u5168", realtext="\u804a\u5929\u8865\u5168")})
public class ACTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String AUTOCOMPLETE = "AUTOCOMPLETE";
    public static final String CHATCOMPLETION = "CHATCOMPLETION";

    public ACTypeCodeListModel() {
        this.initAnnotation(ACTypeCodeListModel.class);
        this.setUserData2("DEACType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ACTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ACTypeCodeListModel");
    }
}

