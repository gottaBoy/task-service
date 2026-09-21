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

@CodeList(id="30aced0f9b99f355814e8c017c6e1672", name="\u9ed8\u8ba4\u7528\u6237\u64cd\u4f5c", type="STATIC", userscope=false, emptytext="", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u65b0\u5efa", realtext="\u65b0\u5efa", userdata="\u5141\u8bb8\u7528\u6237\u5728\u6570\u636e\u65b0\u5efa\u65f6\u8f93\u5165\u503c"), @CodeItem(value="2", text="\u66f4\u65b0", realtext="\u66f4\u65b0", userdata="\u5141\u8bb8\u7528\u6237\u5728\u6570\u636e\u66f4\u65b0\u65f6\u8f93\u5165\u503c"), @CodeItem(value="4", text="\u4e0d\u53ef\u89c1\uff08\u4e0d\u8f93\u51fa\uff09", realtext="\u4e0d\u53ef\u89c1\uff08\u4e0d\u8f93\u51fa\uff09"), @CodeItem(value="256", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49"), @CodeItem(value="512", text="\u81ea\u5b9a\u4e492", realtext="\u81ea\u5b9a\u4e492")})
public class UserInputModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer CREATE = 1;
    public static final int INT_CREATE = 1;
    public static final Integer UPDATE = 2;
    public static final int INT_UPDATE = 2;
    public static final Integer INVISIBLE = 4;
    public static final int INT_INVISIBLE = 4;
    public static final Integer USER = 256;
    public static final int INT_USER = 256;
    public static final Integer USER2 = 512;
    public static final int INT_USER2 = 512;

    public UserInputModeCodeListModel() {
        this.initAnnotation(UserInputModeCodeListModel.class);
        this.setUserData2("UserInputMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.UserInputModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.UserInputModeCodeListModel");
    }
}

