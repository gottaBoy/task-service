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

@CodeList(id="c7299694c1f1fb892fe215634a8a79dc", name="\u7cfb\u7edf\u9762\u677f\u903b\u8f91\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TIMER", text="\u5b9a\u65f6\u5668\u89e6\u53d1", realtext="\u5b9a\u65f6\u5668\u89e6\u53d1", userdata="\u5b9a\u65f6\u5668\u5b9a\u65f6\u89e6\u53d1\u903b\u8f91\uff0c\u9700\u6307\u5b9a\u5b9a\u65f6\u5668\u65f6\u95f4\u95f4\u9694"), @CodeItem(value="PANELEVENT", text="\u9762\u677f\u4e8b\u4ef6\u89e6\u53d1", realtext="\u9762\u677f\u4e8b\u4ef6\u89e6\u53d1", userdata="\u9762\u677f\u4e8b\u4ef6\u89e6\u53d1\u903b\u8f91\uff0c\u9700\u6307\u5b9a\u4e8b\u4ef6\u540d\u79f0\uff0c\u5982\u521d\u59cb\u5316\u3001\u52a0\u8f7d\u7b49"), @CodeItem(value="CTRLEVENT", text="\u90e8\u4ef6\u4e8b\u4ef6\u89e6\u53d1", realtext="\u90e8\u4ef6\u4e8b\u4ef6\u89e6\u53d1", userdata="\u6307\u5b9a\u90e8\u4ef6\u4e8b\u4ef6\u89e6\u53d1\u903b\u8f91\uff0c\u9700\u540c\u65f6\u6307\u5b9a\u90e8\u4ef6\u6807\u8bc6\u53ca\u4e8b\u4ef6\u540d\u79f0"), @CodeItem(value="ITEMVISIBLE", text="\u9879\u663e\u793a\u903b\u8f91", realtext="\u9879\u663e\u793a\u903b\u8f91", userdata="\u6210\u5458\u9879\u52a8\u6001\u663e\u793a\u903b\u8f91\uff0c\u63a7\u5236\u6210\u5458\u662f\u5426\u663e\u793a"), @CodeItem(value="ITEMENABLE", text="\u9879\u542f\u7528\u903b\u8f91", realtext="\u9879\u542f\u7528\u903b\u8f91", userdata="\u6210\u5458\u9879\u7684\u52a8\u6001\u542f\u7528\u903b\u8f91\uff0c\u63a7\u6210\u5458\u53ca\u5176\u7f16\u8f91\u5668\u542f\u7528\u7981\u7528\u72b6\u6001"), @CodeItem(value="ITEMBLANK", text="\u9879\u7a7a\u8f93\u5165\u903b\u8f91", realtext="\u9879\u7a7a\u8f93\u5165\u903b\u8f91", userdata="\u6210\u5458\u9879\u7684\u52a8\u6001\u7a7a\u8f93\u5165\u903b\u8f91\uff0c\u63a7\u5236\u6210\u5458\u9879\u53ca\u5176\u7f16\u8f91\u5668\u662f\u5426\u5141\u8bb8\u7a7a\u8f93\u5165"), @CodeItem(value="ITEMDYNACLASS", text="\u9879\u52a8\u6001\u6837\u5f0f\u8868", realtext="\u9879\u52a8\u6001\u6837\u5f0f\u8868", userdata="\u6210\u5458\u9879\u7684\u52a8\u6001\u6837\u5f0f\u8868\u903b\u8f91\uff0c\u63a7\u5236\u6210\u5458\u9879\u7684\u6837\u5f0f\u8868"), @CodeItem(value="RENDER", text="\u7ed8\u5236\u5668", realtext="\u7ed8\u5236\u5668", userdata="\u5411\u5bb9\u5668\u6216\u76f8\u5173\u6210\u5458\u6307\u5b9a\u7ed8\u5236\u5668\uff0c\u7ed8\u5236\u5668\u5305\u62ec\u76f4\u63a5\u9762\u677f\uff0c\u9762\u677f\u6a21\u578b\uff08DSL\u6216\u8fd0\u884c\u65f6\u6a21\u578b\uff09\u4ee5\u53ca\u524d\u7aef\u63d2\u4ef6"), @CodeItem(value="ATTRIBUTE", text="\u6ce8\u5165\u5c5e\u6027", realtext="\u6ce8\u5165\u5c5e\u6027", userdata="\u5411\u5bb9\u5668\u6216\u76f8\u5173\u6210\u5458\u6ce8\u5165\u5c5e\u6027"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49", userdata="\u4ec5\u53d1\u5e03\u903b\u8f91\uff0c\u4e0d\u6302\u63a5\u4efb\u4f55\u4e8b\u4ef6\uff0c\u7531\u5176\u5b83\u903b\u8f91\u9a71\u52a8\u6216\u81ea\u5b9a\u4e49\u4ee3\u7801\u8c03\u7528"), @CodeItem(value="VUE_DIRECTIVE", text="VUE\u6307\u4ee4", realtext="VUE\u6307\u4ee4")})
public class PanelLogicTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String TIMER = "TIMER";
    public static final String PANELEVENT = "PANELEVENT";
    public static final String CTRLEVENT = "CTRLEVENT";
    public static final String ITEMVISIBLE = "ITEMVISIBLE";
    public static final String ITEMENABLE = "ITEMENABLE";
    public static final String ITEMBLANK = "ITEMBLANK";
    public static final String ITEMDYNACLASS = "ITEMDYNACLASS";
    public static final String RENDER = "RENDER";
    public static final String ATTRIBUTE = "ATTRIBUTE";
    public static final String CUSTOM = "CUSTOM";
    public static final String VUE_DIRECTIVE = "VUE_DIRECTIVE";

    public PanelLogicTypeCodeListModel() {
        this.initAnnotation(PanelLogicTypeCodeListModel.class);
        this.setUserData2("PanelLogicType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelLogicTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelLogicTypeCodeListModel");
    }
}

