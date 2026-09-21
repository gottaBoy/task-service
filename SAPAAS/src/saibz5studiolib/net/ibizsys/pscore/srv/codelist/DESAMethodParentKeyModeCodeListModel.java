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

@CodeList(id="f665df6b190007e0753f86a219da5a97", name="\u4f20\u5165\u7236\u503c\u5904\u7406\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEFAULT", text="\u9ed8\u8ba4", realtext="\u9ed8\u8ba4"), @CodeItem(value="DATACONTEXT", text="\u6570\u636e\u4e0a\u4e0b\u6587\uff08\u67e5\u8be2\uff09", realtext="\u6570\u636e\u4e0a\u4e0b\u6587\uff08\u67e5\u8be2\uff09"), @CodeItem(value="CHILDOF", text="\u9012\u5f52\u5b50\u6570\u636e\uff08\u67e5\u8be2\uff09", realtext="\u9012\u5f52\u5b50\u6570\u636e\uff08\u67e5\u8be2\uff09"), @CodeItem(value="IGNORE", text="\u5ffd\u7565", realtext="\u5ffd\u7565", userdata="\u5ffd\u7565\u4f20\u5165\u7236\u503c"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class DESAMethodParentKeyModeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFAULT = "DEFAULT";
    public static final String DATACONTEXT = "DATACONTEXT";
    public static final String CHILDOF = "CHILDOF";
    public static final String IGNORE = "IGNORE";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public DESAMethodParentKeyModeCodeListModel() {
        this.initAnnotation(DESAMethodParentKeyModeCodeListModel.class);
        this.setUserData2("SADEMethodParentKeyMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DESAMethodParentKeyModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DESAMethodParentKeyModeCodeListModel");
    }
}

