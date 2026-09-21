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

@CodeList(id="cb12bf0d753b07837b4626a4803b7d7d", name="\u5c5e\u6027\u5b57\u7b26\u4e32\u8f6c\u6362\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="UCASE", text="\u8f6c\u6362\u4e3a\u5927\u5199", realtext="\u8f6c\u6362\u4e3a\u5927\u5199"), @CodeItem(value="LCASE", text="\u8f6c\u6362\u4e3a\u5c0f\u5199", realtext="\u8f6c\u6362\u4e3a\u5c0f\u5199"), @CodeItem(value="PASSWORD", text="\u5bc6\u7801\u6a21\u5f0f", realtext="\u5bc6\u7801\u6a21\u5f0f", userdata="\u5bc6\u7801\u6a21\u5f0f\uff0c\u4f7f\u7528\u9884\u7f6e\u5185\u5bb9\u5411\u524d\u7aef\u8f93\u51fa\uff0c\u5982\u679c\u63d0\u4ea4\u7684\u5185\u5bb9\u7b49\u4e8e\u9884\u7f6e\u5185\u5bb9\uff0c\u5219\u5ffd\u7565\u66f4\u65b0"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class StringCaseModeCodeListModel
extends StaticCodeListModelBase {
    public static final String UCASE = "UCASE";
    public static final String LCASE = "LCASE";
    public static final String PASSWORD = "PASSWORD";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public StringCaseModeCodeListModel() {
        this.initAnnotation(StringCaseModeCodeListModel.class);
        this.setUserData2("StringCaseMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.StringCaseModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.StringCaseModeCodeListModel");
    }
}

