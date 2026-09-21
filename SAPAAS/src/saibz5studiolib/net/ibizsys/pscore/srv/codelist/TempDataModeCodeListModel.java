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

@CodeList(id="9ebebb17a1d9089cd9717dbdd7554075", name="\u5e73\u53f0\u90e8\u4ef6\u5904\u7406\u5668\u4e34\u65f6\u6570\u636e\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="0", text="\u65e0\u4e34\u65f6\u6570\u636e\u6a21\u5f0f", realtext="\u65e0\u4e34\u65f6\u6570\u636e\u6a21\u5f0f"), @CodeItem(value="1", text="\u4e3b\u6570\u636e\u6a21\u5f0f", realtext="\u4e3b\u6570\u636e\u6a21\u5f0f", userdata="\u4e3b\u6570\u636e\u6a21\u5f0f\u5b8c\u6210\n\uff081\uff09\u4ece\u771f\u5b9e\u6570\u636e\u5efa\u7acb\u4e34\u65f6\u6570\u636e\u7684\u529f\u80fd\uff08\u5305\u62ec\u76f8\u5173\u5b50\u6570\u636e\uff09\n\uff082\uff09\u4ece\u4e34\u65f6\u6570\u636e\u8fd8\u539f\u771f\u5b9e\u6570\u636e\u7684\u529f\u80fd\uff08\u5305\u62ec\u76f8\u5173\u5b50\u6570\u636e\uff09"), @CodeItem(value="2", text="\u4ece\u6570\u636e\u6a21\u5f0f", realtext="\u4ece\u6570\u636e\u6a21\u5f0f", userdata="\u529f\u80fd\u64cd\u4f5c\u76f4\u63a5\u9762\u5411\u4e34\u65f6\u6570\u636e")})
public class TempDataModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer MAJOR = 1;
    public static final int INT_MAJOR = 1;
    public static final Integer MINOR = 2;
    public static final int INT_MINOR = 2;

    public TempDataModeCodeListModel() {
        this.initAnnotation(TempDataModeCodeListModel.class);
        this.setUserData2("TempDataMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.TempDataModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.TempDataModeCodeListModel");
    }
}

