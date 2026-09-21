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

@CodeList(id="A8620AA6-A094-4E76-BAD9-0233D9722696", name="\u8868\u5355\u6309\u94ae\u5217\u8868\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="UIACTIONGROUP", text="\u754c\u9762\u884c\u4e3a\u7ec4", realtext="\u754c\u9762\u884c\u4e3a\u7ec4"), @CodeItem(value="BUTTONS", text="\u6309\u94ae\u96c6\u5408", realtext="\u6309\u94ae\u96c6\u5408")})
public class FormButtonListTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String UIACTIONGROUP = "UIACTIONGROUP";
    public static final String BUTTONS = "BUTTONS";

    public FormButtonListTypeCodeListModel() {
        this.initAnnotation(FormButtonListTypeCodeListModel.class);
        this.setUserData2("ButtonListType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FormButtonListTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FormButtonListTypeCodeListModel");
    }
}

