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

@CodeList(id="71a25c45297b517535f9ed7b987c4499", name="\u8868\u5355\u9879\u503c\u5ffd\u7565\u6761\u4ef6", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0", realtext="\u65e0", userdata="\u4e0d\u5ffd\u7565\uff0c\u4efb\u4f55\u60c5\u51b5\u90fd\u5bf9\u503c\u8fdb\u884c\u5904\u7406"), @CodeItem(value="1", text="\u5efa\u7acb", realtext="\u5efa\u7acb", userdata="\u6570\u636e\u5efa\u7acb\u65f6\u5ffd\u7565"), @CodeItem(value="2", text="\u66f4\u65b0", realtext="\u66f4\u65b0", userdata="\u6570\u636e\u66f4\u65b0\u65f6\u5ffd\u7565"), @CodeItem(value="3", text="\u5efa\u7acb\u53ca\u66f4\u65b0", realtext="\u5efa\u7acb\u53ca\u66f4\u65b0", userdata="\u6570\u636e\u5efa\u7acb\u53ca\u66f4\u65b0\u65f6\u90fd\u5ffd\u7565"), @CodeItem(value="18", text="\u66f4\u65b0\uff08\u8bbe\u7f6e\u56de\u539f\u503c\uff09", realtext="\u66f4\u65b0\uff08\u8bbe\u7f6e\u56de\u539f\u503c\uff09", userdata="\u6570\u636e\u66f4\u65b0\u65f6\u5ffd\u7565\uff0c\u5e76\u4e14\u5c06\u8bbe\u7f6e\u56de\u539f\u503c"), @CodeItem(value="19", text="\u5efa\u7acb\u53ca\u66f4\u65b0\uff08\u8bbe\u7f6e\u56de\u539f\u503c\uff09", realtext="\u5efa\u7acb\u53ca\u66f4\u65b0\uff08\u8bbe\u7f6e\u56de\u539f\u503c\uff09", userdata="\u6570\u636e\u5efa\u7acb\u53ca\u66f4\u65b0\u65f6\u90fd\u5ffd\u7565\uff0c\u5e76\u4e14\u5c06\u8bbe\u7f6e\u56de\u539f\u503c"), @CodeItem(value="4", text="\u8868\u5355\u9879\u7981\u7528", realtext="\u8868\u5355\u9879\u7981\u7528", userdata="\u8868\u5355\u9879\u5904\u4e8e\u7981\u7528\u72b6\u6001\u65f6\u5ffd\u7565"), @CodeItem(value="12", text="\u8868\u5355\u9879\u7981\u7528\uff08\u540c\u65f6\u4e0d\u8f93\u51fa\u5230\u524d\u7aef\uff09", realtext="\u8868\u5355\u9879\u7981\u7528\uff08\u540c\u65f6\u4e0d\u8f93\u51fa\u5230\u524d\u7aef\uff09", userdata="\u8868\u5355\u9879\u5904\u4e8e\u7981\u7528\u72b6\u6001\u65f6\u5ffd\u7565\uff0c\u5e76\u4e14\u4e0d\u586b\u5145\u8868\u5355\u9879")})
public class FIValueIgnoreModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer CREATE = 1;
    public static final int INT_CREATE = 1;
    public static final Integer UPDATE = 2;
    public static final int INT_UPDATE = 2;
    public static final Integer ALL = 3;
    public static final int INT_ALL = 3;
    public static final Integer UPDATE_AND_SETORIGIN = 18;
    public static final int INT_UPDATE_AND_SETORIGIN = 18;
    public static final Integer ALL_AND_SETORIGIN = 19;
    public static final int INT_ALL_AND_SETORIGIN = 19;
    public static final Integer DISABLE = 4;
    public static final int INT_DISABLE = 4;
    public static final Integer DISABLE_AND_NOTSETOUTPUT = 12;
    public static final int INT_DISABLE_AND_NOTSETOUTPUT = 12;

    public FIValueIgnoreModeCodeListModel() {
        this.initAnnotation(FIValueIgnoreModeCodeListModel.class);
        this.setUserData2("EditItemIgnoreMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FIValueIgnoreModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FIValueIgnoreModeCodeListModel");
    }
}

