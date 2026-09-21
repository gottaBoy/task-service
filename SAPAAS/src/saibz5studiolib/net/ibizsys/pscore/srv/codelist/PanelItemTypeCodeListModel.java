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

@CodeList(id="a79cd2e6c938fd2d1e35e5825bd3cfca", name="\u9762\u677f\u9879\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="CONTAINER", text="\u9762\u677f\u5bb9\u5668", realtext="\u9762\u677f\u5bb9\u5668", userdata="\u9762\u677f\u4e2d\u7684\u57fa\u672c\u5e03\u5c40\u9762\u677f\uff0c\u8f93\u51fa\u6807\u9898\u7684\u9762\u677f\u627f\u62c5\u5206\u7c7b\u6570\u636e\u5448\u73b0\uff0c\u4e0d\u8f93\u51fa\u6807\u9898\u7684\u9762\u677f\u66f4\u591a\u627f\u62c5\u5e03\u5c40\u529f\u80fd\uff08\u9ed8\u8ba4\u65e0\u5185\u3001\u5916\u8fb9\u6846\uff09\u3002\u652f\u6301\u5b50\u6210\u5458"), @CodeItem(value="CONTROL", text="\u90e8\u4ef6", realtext="\u90e8\u4ef6", userdata="\u9762\u677f\u4e2d\u7684\u90e8\u4ef6\u6210\u5458\uff0c\u6302\u8f7d\u7cfb\u7edf\u6216\u5b9e\u4f53\u5b9a\u4e49\u7684\u754c\u9762\u90e8\u4ef6\u3002\u4e0d\u652f\u6301\u5b50\u6210\u5458"), @CodeItem(value="CTRLPOS", text="\u90e8\u4ef6\u5360\u4f4d", realtext="\u90e8\u4ef6\u5360\u4f4d", userdata="\u89c6\u56fe\u5e03\u5c40\u9762\u677f\u4e2d\u7684\u90e8\u4ef6\u5360\u4f4d\u6210\u5458\uff0c\u9ed8\u8ba4\u4e0e\u90e8\u4ef6\u5360\u4f4d\u9879\u540c\u540d\u7684\u89c6\u56fe\u90e8\u4ef6\u5c06\u88ab\u653e\u7f6e\u5230\u5f53\u524d\u4f4d\u7f6e\u3002\u4e0d\u652f\u6301\u5b50\u6210\u5458"), @CodeItem(value="RAWITEM", text="\u76f4\u63a5\u5185\u5bb9", realtext="\u76f4\u63a5\u5185\u5bb9", userdata="\u9762\u677f\u4e2d\u7684\u76f4\u63a5\u5185\u5bb9\u9879\uff0c\u8f93\u51fa\u6587\u672c\u6216\u56fe\u7247\u3002\u4e0d\u652f\u6301\u5b50\u6210\u5458"), @CodeItem(value="TABPANEL", text="\u5206\u9875\u90e8\u4ef6", realtext="\u5206\u9875\u90e8\u4ef6", userdata="\u9762\u677f\u4e2d\u7684\u5206\u9875\u90e8\u4ef6\uff0c\u63d0\u4f9b\u5206\u9875\u754c\u9762\u5bb9\u5668\u3002\u5206\u9875\u90e8\u4ef6\u53ea\u80fd\u5305\u542b\u5206\u9875\u9762\u677f\uff08TABPAGE\uff09"), @CodeItem(value="TAGPAGE", text="\u5206\u9875\u9762\u677f", realtext="\u5206\u9875\u9762\u677f", userdata="\u9762\u677f\u5206\u9875\u90e8\u4ef6\u7684\u6210\u5458\u90e8\u4ef6\uff0c\u662f\u57fa\u7840\u7684\u5e03\u5c40\u5bb9\u5668\u3002\u53ea\u5141\u8bb8\u653e\u7f6e\u5728\u5206\u9875\u90e8\u4ef6\uff08TABPANEL\uff09\u4e2d\u3002\u652f\u6301\u5b50\u6210\u5458"), @CodeItem(value="FIELD", text="\u9762\u677f\u5c5e\u6027", realtext="\u9762\u677f\u5c5e\u6027", userdata="\u9762\u677f\u6a21\u578b\u7684\u8f7d\u4f53\uff0c\u901a\u8fc7\u7f16\u8f91\u5668\u63a7\u4ef6\u5c06\u6a21\u578b\u6570\u636e\u8fdb\u884c\u5448\u73b0\u3002\u4e0d\u652f\u6301\u5b50\u6210\u5458"), @CodeItem(value="BUTTON", text="\u9762\u677f\u6309\u94ae", realtext="\u9762\u677f\u6309\u94ae", userdata="\u9762\u677f\u4e2d\u7684\u6309\u94ae\u5bf9\u8c61\uff0c\u4e3a\u9762\u677f\u63d0\u4f9b\u547d\u4ee4\u80fd\u529b\u3002\u4e0d\u652f\u6301\u5b50\u6210\u5458"), @CodeItem(value="USERCONTROL", text="\u7528\u6237\u63a7\u4ef6", realtext="\u7528\u6237\u63a7\u4ef6", userdata="\u9762\u677f\u4e2d\u7684\u81ea\u5b9a\u4e49\u7528\u6237\u90e8\u4ef6\uff0c\u9700\u6307\u5b9a\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u8fdb\u884c\u5185\u5bb9\u8f93\u51fa\u3002\u4e0d\u652f\u6301\u5b50\u6210\u5458")})
public class PanelItemTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String CONTAINER = "CONTAINER";
    public static final String CONTROL = "CONTROL";
    public static final String CTRLPOS = "CTRLPOS";
    public static final String RAWITEM = "RAWITEM";
    public static final String TABPANEL = "TABPANEL";
    public static final String TAGPAGE = "TAGPAGE";
    public static final String FIELD = "FIELD";
    public static final String BUTTON = "BUTTON";
    public static final String USERCONTROL = "USERCONTROL";

    public PanelItemTypeCodeListModel() {
        this.initAnnotation(PanelItemTypeCodeListModel.class);
        this.setUserData("IGNOREMODELDSL2");
        this.setUserData2("PanelItemType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelItemTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelItemTypeCodeListModel");
    }
}

