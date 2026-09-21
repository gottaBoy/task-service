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

@CodeList(id="F16FCC13-05EC-49B3-A906-91D2135126DD", name="\u4e34\u65f6\u6570\u636e\u5904\u7406\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u4e0d\u542f\u7528\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u542f\u7528", realtext="\u4e0d\u542f\u7528"), @CodeItem(value="1", text="\u540e\u53f0", realtext="\u540e\u53f0", userdata="\u540e\u53f0\u63d0\u4f9b\u663e\u5f0f\u4e34\u65f6\u6570\u636e\u5b58\u50a8\u80fd\u529b\uff0c\u524d\u7aef\u53ef\u5bf9\u4e34\u65f6\u6570\u636e\u6216\u771f\u5b9e\u6570\u636e\u8fdb\u884c\u76f4\u63a5\u64cd\u4f5c\uff0c\u540e\u53f0\u63d0\u4f9b\u771f\u5b9e\u6570\u636e\u590d\u5236\u5230\u4e34\u65f6\u6570\u636e\u53ca\u4e34\u65f6\u6570\u636e\u8f6c\u4e3a\u771f\u5b9e\u6570\u636e\u7684\u80fd\u529b"), @CodeItem(value="2", text="\u524d\u7aef", realtext="\u524d\u7aef", userdata="\u524d\u7aef\u63d0\u4f9b\u4e34\u65f6\u6570\u636e\u5b58\u50a8\u80fd\u529b\uff0c\u540e\u53f0\u63d0\u4f9b\u5305\u6570\u636e\u83b7\u53d6\u53ca\u5efa\u7acb\u3001\u66f4\u65b0\u80fd\u529b\u3002\u524d\u7aef\u4e00\u6b21\u6027\u5c06\u6570\u636e\u52a0\u8f7d\u56de\u6765\uff0c\u5728\u524d\u7aef\u5b8c\u6210\u6570\u636e\u7684\u52a0\u5de5\uff0c\u7136\u540e\u518d\u6574\u4f53\u63d0\u4ea4\u5230\u540e\u53f0"), @CodeItem(value="3", text="\u540e\u53f0\u53ca\u524d\u7aef", realtext="\u540e\u53f0\u53ca\u524d\u7aef", userdata="\u540e\u53f0\u53ca\u524d\u7aef\u90fd\u63d0\u4f9b\u4e34\u65f6\u6570\u636e\u5904\u7406\u80fd\u529b\uff0c\u7531\u5904\u7406\u9009\u62e9\u4f7f\u7528\u6a21\u5f0f")})
public class DETempDataHolderCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer BACKEND = 1;
    public static final int INT_BACKEND = 1;
    public static final Integer FRONT = 2;
    public static final int INT_FRONT = 2;
    public static final Integer BACKENDANDFRONT = 3;
    public static final int INT_BACKENDANDFRONT = 3;

    public DETempDataHolderCodeListModel() {
        this.initAnnotation(DETempDataHolderCodeListModel.class);
        this.setUserData2("DETempDataHolder");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DETempDataHolderCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DETempDataHolderCodeListModel");
    }
}

