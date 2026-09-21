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

@CodeList(id="afafee96c13d6aae9f99309f5ffdf4ff", name="\u8868\u5355\u6210\u5458\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="FORMPAGE", text="\u8868\u5355\u5206\u9875", realtext="\u8868\u5355\u5206\u9875", userdata="\u8868\u5355\u7684\u6839\u6210\u5458\uff0c\u5176\u5b83\u6210\u5458\u90fd\u5fc5\u987b\u5728\u8868\u5355\u5206\u9875\u4e2d\uff0c\u5982\u8868\u5355\u4e2d\u53ea\u6709\u4e00\u4e2a\u8868\u5355\u5206\u9875\uff0c\u5219\u9ed8\u8ba4\u4e0d\u8f93\u51fa\u5206\u9875\u5934"), @CodeItem(value="TABPANEL", text="\u5206\u9875\u90e8\u4ef6", realtext="\u5206\u9875\u90e8\u4ef6", userdata="\u63d0\u4f9b\u9664\u8868\u5355\u5206\u9875\u5916\u7684\u5206\u9875\u5bb9\u5668\u3002\u5206\u9875\u90e8\u4ef6\u4ec5\u652f\u6301\u5206\u9875\u9762\u677f\uff08TABPAGE\uff09\u6210\u5458"), @CodeItem(value="TABPAGE", text="\u5206\u9875\u9762\u677f", realtext="\u5206\u9875\u9762\u677f", userdata="\u57fa\u7840\u5e03\u5c40\u5bb9\u5668\uff0c\u53ea\u5141\u8bb8\u653e\u7f6e\u5728\u5206\u9875\u90e8\u4ef6\uff08TABPANEL\uff09\u4e2d"), @CodeItem(value="FORMITEM", text="\u8868\u5355\u9879", realtext="\u8868\u5355\u9879", userdata="\u8868\u5355\u6570\u636e\u9879\u7684\u8f7d\u4f53\uff0c\u5305\u62ec\u4e86\u6807\u7b7e\u53ca\u7f16\u8f91\u5668\u63a7\u4ef6\uff0c\u8d1f\u8d23\u8868\u5355\u6570\u636e\u7684\u8f93\u5165\u8f93\u51fa\u3002\u8868\u5355\u6210\u5458\u7684\u53f6\u5b50\u8282\u70b9"), @CodeItem(value="USERCONTROL", text="\u7528\u6237\u63a7\u4ef6", realtext="\u7528\u6237\u63a7\u4ef6", userdata="\u81ea\u5b9a\u4e49\u7528\u6237\u90e8\u4ef6\uff0c\u9700\u6307\u5b9a\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u3002\u8868\u5355\u6210\u5458\u53f6\u5b50\u8282\u70b9"), @CodeItem(value="FORMPART", text="\u8868\u5355\u90e8\u4ef6", realtext="\u8868\u5355\u90e8\u4ef6", userdata="\u8868\u5355\u90e8\u4ef6\u5f15\u7528\u6210\u5458\uff0c\u5f15\u7528\u6709\u4e24\u79cd\u6a21\u5f0f\uff0c\u4e00\u79cd\u662f\u5f15\u5165\u8bbe\u8ba1\u65f6\u7684\u5176\u5b83\u8868\u5355\uff0c\u4f1a\u5c06\u5f15\u7528\u8868\u5355\u7684\u5185\u5bb9\u76f4\u63a5\u9644\u52a0\u5230\u5f53\u524d\u8868\u5355\uff08\u4e0d\u5b58\u5728\u8868\u5355\u5f15\u7528\u90e8\u4ef6\uff09\uff0c\u53e6\u4e00\u4e2a\u662f\u8fd0\u884c\u65f6\u5f15\u7528\uff0c\u5f15\u5165\u52a8\u6001\u5b50\u7cfb\u7edf\u7684\u52a8\u6001\u8868\u5355\uff0c\u8fd9\u79cd\u8868\u5355\u5f15\u7528\u90e8\u4ef6\u5c06\u88ab\u8f93\u51fa\u5230\u8868\u5355\u4e2d\u3002\u8868\u5355\u6210\u5458\u53f6\u5b50\u8282\u70b9"), @CodeItem(value="GROUPPANEL", text="\u5206\u7ec4\u9762\u677f", realtext="\u5206\u7ec4\u9762\u677f", userdata="\u57fa\u672c\u5e03\u5c40\u5bb9\u5668\uff0c\u8f93\u51fa\u6807\u9898\u7684\u9762\u677f\u627f\u62c5\u5206\u7c7b\u6570\u636e\u5448\u73b0\uff0c\u4e0d\u8f93\u51fa\u6807\u9898\u7684\u9762\u677f\u627f\u62c5\u5e03\u5c40\u529f\u80fd"), @CodeItem(value="DRUIPART", text="\u6570\u636e\u5173\u7cfb\u754c\u9762", realtext="\u6570\u636e\u5173\u7cfb\u754c\u9762", userdata="\u5173\u7cfb\u6570\u636e\u754c\u9762\u6210\u5458\uff0c\u5d4c\u5165\u5b9e\u4f53\u89c6\u56fe\u5e76\u8fdb\u63d0\u4f9b\u52a0\u8f7d\u3001\u5237\u65b0\u7b49\u529f\u80fd\u3002\u8868\u5355\u6210\u5458\u53f6\u5b50\u8282\u70b9\u3002"), @CodeItem(value="RAWITEM", text="\u76f4\u63a5\u5185\u5bb9", realtext="\u76f4\u63a5\u5185\u5bb9", userdata="\u76f4\u63a5\u5185\u5bb9\u90e8\u4ef6\uff0c\u9700\u8fdb\u4e00\u6b65\u6307\u5b9a\u5185\u5bb9\u7c7b\u578b\u3002\u8868\u5355\u6210\u5458\u53f6\u5b50\u8282\u70b9"), @CodeItem(value="BUTTON", text="\u8868\u5355\u6309\u94ae", realtext="\u8868\u5355\u6309\u94ae", userdata="\u8868\u5355\u6309\u94ae\u90e8\u4ef6\uff0c\u9700\u6307\u5b9a\u6309\u94ae\u884c\u4e3a\u7c7b\u578b\u3002\u8868\u5355\u6210\u5458\u53f6\u5b50\u8282\u70b9"), @CodeItem(value="IFRAME", text="\u76f4\u63a5\u9875\u9762\u5d4c\u5165", realtext="\u76f4\u63a5\u9875\u9762\u5d4c\u5165", userdata="\u8868\u5355\u7684\u7f51\u9875\u5bb9\u5668\uff0c\u76f4\u63a5\u6307\u5b9a\u9875\u9762\u8def\u5f84\u3002\u8868\u5355\u6210\u5458\u53f6\u5b50\u8282\u70b9"), @CodeItem(value="FORMITEMEX", text="\u590d\u5408\u8868\u5355\u9879", realtext="\u590d\u5408\u8868\u5355\u9879", userdata="\u590d\u5408\u8868\u5355\u9879\u5c06\u591a\u4e2a\u8868\u5355\u9879\u8054\u5408\u8fdb\u884c\u8f93\u5165\u53ca\u8f93\u51fa\u3002\u53ea\u5141\u8bb8\u5305\u542b\u8868\u5355\u9879\u6210\u5458\uff08FORMITEM\uff09"), @CodeItem(value="MDCTRL", text="\u591a\u6570\u636e\u90e8\u4ef6", realtext="\u591a\u6570\u636e\u90e8\u4ef6", userdata="\u8f7b\u91cf\u5448\u73b0\u8868\u5355\u4e2d\u6570\u7ec4\u6570\u636e\uff0c\u652f\u6301\u5217\u8868\u3001\u8868\u683c\u3001\u8868\u5355\u3001\u5361\u7247\u89c6\u56fe\u548c\u91cd\u590d\u5668\u7c7b\u578b\u3002\u7c7b\u578b\u4e3a\u91cd\u590d\u5668\u53ef\u653e\u5165\u5176\u5b83\u8868\u5355\u6210\u5458\uff0c\u5176\u5b83\u5219\u4e3a\u53f6\u5b50\u8282\u70b9")})
public class FormDetailType2CodeListModel
extends StaticCodeListModelBase {
    public static final String FORMPAGE = "FORMPAGE";
    public static final String TABPANEL = "TABPANEL";
    public static final String TABPAGE = "TABPAGE";
    public static final String FORMITEM = "FORMITEM";
    public static final String USERCONTROL = "USERCONTROL";
    public static final String FORMPART = "FORMPART";
    public static final String GROUPPANEL = "GROUPPANEL";
    public static final String DRUIPART = "DRUIPART";
    public static final String RAWITEM = "RAWITEM";
    public static final String BUTTON = "BUTTON";
    public static final String IFRAME = "IFRAME";
    public static final String FORMITEMEX = "FORMITEMEX";
    public static final String MDCTRL = "MDCTRL";

    public FormDetailType2CodeListModel() {
        this.initAnnotation(FormDetailType2CodeListModel.class);
        this.setUserData2("FormDetailType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FormDetailType2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FormDetailType2CodeListModel");
    }
}

