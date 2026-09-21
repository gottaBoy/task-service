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

@CodeList(id="b2dc25c6e392d88b0ea2482ad3412666", name="\u7f16\u8f91\u5668\u540e\u53f0\u5904\u7406\u5bf9\u8c61\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="None", text="\u65e0\u5904\u7406", realtext="\u65e0\u5904\u7406"), @CodeItem(value="CodeList", text="\u4ee3\u7801\u8868", realtext="\u4ee3\u7801\u8868", userdata="\u7f16\u8f91\u5668\u9700\u8981\u63d0\u4f9b\u3010\u4ee3\u7801\u8868\u3011\u754c\u9762\u5904\u7406\u6a21\u5f0f\uff0c\u5305\u62ec\u6307\u5b9a\u4ee3\u7801\u8868"), @CodeItem(value="PickupText", text="\u5916\u952e\u6587\u672c", realtext="\u5916\u952e\u6587\u672c", userdata="\u7f16\u8f91\u5668\u9700\u8981\u63d0\u4f9b\u3010\u5916\u952e\u6587\u672c\u3011\u754c\u9762\u5904\u7406\u6a21\u5f0f\uff0c\u5305\u62ec\u6307\u5b9a\u5916\u952e\u503c\u9879\u3001\u5f15\u7528\u7684\u6570\u636e\u96c6\u5408\u3001\u81ea\u52a8\u586b\u5145\u6a21\u5f0f\u7b49"), @CodeItem(value="AC", text="\u81ea\u52a8\u586b\u5145", realtext="\u81ea\u52a8\u586b\u5145", userdata="\u7f16\u8f91\u5668\u9700\u8981\u63d0\u4f9b\u3010\u81ea\u52a8\u586b\u5145\u3011\u754c\u9762\u5904\u7406\u6a21\u5f0f\u7f16\u8f91\u5668\uff0c\u5305\u62ec\u5f15\u7528\u7684\u6570\u636e\u96c6\u5408\u3001\u81ea\u52a8\u586b\u5145\u6a21\u5f0f\u7b49"), @CodeItem(value="Custom", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49")})
public class EditorAjaxHandlerTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "None";
    public static final String CODELIST = "CodeList";
    public static final String PICKUPTEXT = "PickupText";
    public static final String AC = "AC";
    public static final String CUSTOM = "Custom";

    public EditorAjaxHandlerTypeCodeListModel() {
        this.initAnnotation(EditorAjaxHandlerTypeCodeListModel.class);
        this.setUserData2("EditorHandlerType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.EditorAjaxHandlerTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.EditorAjaxHandlerTypeCodeListModel");
    }
}

