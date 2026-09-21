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

@CodeList(id="C888EF7A-18A7-4526-9E71-77102E4C6030", name="\u8868\u5355\u81ea\u52a8\u4fdd\u5b58\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u7981\u7528", realtext="\u7981\u7528"), @CodeItem(value="1", text="\u542f\u7528", realtext="\u542f\u7528"), @CodeItem(value="2", text="\u542f\u7528\uff08\u63d0\u4ea4\u5168\u90e8\uff09", realtext="\u542f\u7528\uff08\u63d0\u4ea4\u5168\u90e8\uff09"), @CodeItem(value="3", text="\u542f\u7528\uff08\u63d0\u4ea4\u53d8\u5316\uff09", realtext="\u542f\u7528\uff08\u63d0\u4ea4\u53d8\u5316\uff09")})
public class FormAutoSaveModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer DISABLED = 0;
    public static final int INT_DISABLED = 0;
    public static final Integer ENABLED = 1;
    public static final int INT_ENABLED = 1;
    public static final Integer ALL = 2;
    public static final int INT_ALL = 2;
    public static final Integer CHANGED = 3;
    public static final int INT_CHANGED = 3;

    public FormAutoSaveModeCodeListModel() {
        this.initAnnotation(FormAutoSaveModeCodeListModel.class);
        this.setUserData2("FormAutoSaveMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FormAutoSaveModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FormAutoSaveModeCodeListModel");
    }
}

