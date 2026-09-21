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

@CodeList(id="CBB017EE-8341-4E01-B61A-0D389504E89A", name="\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u8fde\u63a5\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u5e38\u89c4", realtext="\u5e38\u89c4", userdata="\u5e38\u89c4\u8fde\u63a5\uff0c\u6ee1\u8db3\u8fde\u63a5\u6761\u4ef6\u65b9\u53ef\u8fdb\u5165"), @CodeItem(value="1", text="\u9ed8\u8ba4\u8fde\u63a5", realtext="\u9ed8\u8ba4\u8fde\u63a5", userdata="\u9ed8\u8ba4\u8fde\u63a5\uff0c\u4e0d\u505a\u6761\u4ef6\u5224\u65ad\u5373\u53ef\u8fdb\u5165"), @CodeItem(value="2", text="\u5f02\u6b65\u7ed3\u675f", realtext="\u5f02\u6b65\u7ed3\u675f", userdata="\u524d\u7aef\u5f02\u6b65\u8c03\u7528\u7ed3\u675f\u65f6\u8fdb\u5165"), @CodeItem(value="3", text="\u5f02\u6b65\u62d2\u7edd", realtext="\u5f02\u6b65\u62d2\u7edd", userdata="\u524d\u7aef\u5f02\u6b65\u8c03\u7528\u88ab\u62d2\u7edd\u65f6\u8fdb\u5165"), @CodeItem(value="9", text="\u5f02\u5e38\u5904\u7406", realtext="\u5f02\u5e38\u5904\u7406", userdata="\u524d\u7aef\u5f02\u6b65\u8c03\u7528\u53d1\u751f\u5f02\u5e38\u65f6\u8fdb\u5165")})
public class DEUILogicLinkModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer COMMON = 0;
    public static final int INT_COMMON = 0;
    public static final Integer DEFAULT = 1;
    public static final int INT_DEFAULT = 1;
    public static final Integer FULFILLED = 2;
    public static final int INT_FULFILLED = 2;
    public static final Integer REJECTED = 3;
    public static final int INT_REJECTED = 3;
    public static final Integer CATCH = 9;
    public static final int INT_CATCH = 9;

    public DEUILogicLinkModeCodeListModel() {
        this.initAnnotation(DEUILogicLinkModeCodeListModel.class);
        this.setUserData2("DEUILogicLinkMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEUILogicLinkModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEUILogicLinkModeCodeListModel");
    }
}

