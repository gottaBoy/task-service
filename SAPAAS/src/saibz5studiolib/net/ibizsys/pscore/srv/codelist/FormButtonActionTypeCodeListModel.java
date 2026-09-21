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

@CodeList(id="301d7b2a0cd6dbf42eb75808278bcb7a", name="\u8868\u5355\u6309\u94ae\u884c\u4e3a\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="UIACTION", text="\u754c\u9762\u884c\u4e3a", realtext="\u754c\u9762\u884c\u4e3a", userdata="\u89e6\u53d1\u754c\u9762\u884c\u4e3a\u5904\u7406"), @CodeItem(value="FIUPDATE", text="\u8868\u5355\u9879\u66f4\u65b0", realtext="\u8868\u5355\u9879\u66f4\u65b0", userdata="\u89e6\u53d1\u8868\u5355\u9879\u66f4\u65b0\u5904\u7406")})
public class FormButtonActionTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String UIACTION = "UIACTION";
    public static final String FIUPDATE = "FIUPDATE";

    public FormButtonActionTypeCodeListModel() {
        this.initAnnotation(FormButtonActionTypeCodeListModel.class);
        this.setUserData2("FormButtonActionType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FormButtonActionTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FormButtonActionTypeCodeListModel");
    }
}

