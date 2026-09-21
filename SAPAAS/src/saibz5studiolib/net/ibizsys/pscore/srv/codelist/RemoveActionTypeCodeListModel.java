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

@CodeList(id="ff4e0d11d87e187f5a399ad17b8369c2", name="\u5b9e\u4f531\uff1aN\u5173\u7cfb\u4e3b\u5b9e\u4f53\u5220\u9664\u5173\u7cfb\u5b9e\u4f53\u64cd\u4f5c", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="0", text="\u65e0\u64cd\u4f5c", realtext="\u65e0\u64cd\u4f5c", userdata="\u4ece\u6570\u636e\u65e0\u4efb\u4f55\u64cd\u4f5c\uff0c\u4e00\u822c\u7528\u4e8e\u975e\u5173\u952e\u7684\u65e5\u5fd7\u7c7b\u6570\u636e\uff0c\u5173\u7cfb\u4e0d\u542f\u7528\u5916\u952e\u7ea6\u675f"), @CodeItem(value="1", text="\u540c\u65f6\u5220\u9664", realtext="\u540c\u65f6\u5220\u9664", userdata="\u4ece\u6570\u636e\u540c\u65f6\u5220\u9664\uff0c\u4e00\u822c\u7528\u4e8e\u4e3b\u5b9e\u4f53\u7684\u9644\u5c5e\u5b9e\u4f53"), @CodeItem(value="2", text="\u7f6e\u7a7a", realtext="\u7f6e\u7a7a", userdata="\u7f6e\u7a7a\u4ece\u5b9e\u4f53\u5bf9\u4e3b\u5b9e\u4f53\u7684\u5f15\u7528"), @CodeItem(value="3", text="\u9650\u5236\u5220\u9664", realtext="\u9650\u5236\u5220\u9664", userdata="\u4ece\u5b9e\u4f53\u9650\u5236\u5220\u9664\uff0c\u4e2d\u65ad\u4e3b\u5b9e\u4f53\u7684\u5220\u9664\u64cd\u4f5c")})
public class RemoveActionTypeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer DELETE = 1;
    public static final int INT_DELETE = 1;
    public static final Integer RESET = 2;
    public static final int INT_RESET = 2;
    public static final Integer REJECT = 3;
    public static final int INT_REJECT = 3;

    public RemoveActionTypeCodeListModel() {
        this.initAnnotation(RemoveActionTypeCodeListModel.class);
        this.setUserData2("DER1NRemoveActionType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.RemoveActionTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.RemoveActionTypeCodeListModel");
    }
}

