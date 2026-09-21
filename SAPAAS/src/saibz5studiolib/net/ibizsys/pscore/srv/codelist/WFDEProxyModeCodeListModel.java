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

@CodeList(id="F3A6540A-7397-4688-8382-10B2DF01D204", name="\u5de5\u4f5c\u6d41\u5b9e\u4f53\u4ee3\u7406\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u4e0d\u4f7f\u7528\uff09")
@CodeItems(value={@CodeItem(value="0", text="\uff08\u4e0d\u4f7f\u7528\uff09", realtext="\uff08\u4e0d\u4f7f\u7528\uff09"), @CodeItem(value="1", text="\u4f7f\u7528\u6d41\u7a0b\u4ee3\u7406\u670d\u52a1\uff08\u5ba2\u6237\u7aef\uff09", realtext="\u4f7f\u7528\u6d41\u7a0b\u4ee3\u7406\u670d\u52a1\uff08\u5ba2\u6237\u7aef\uff09", userdata="\u5de5\u4f5c\u6d41\u63d0\u4f9b\u542f\u52a8\u3001\u7ed3\u675f\u7b49\u754c\u9762\u64cd\u4f5c\uff0c\u8c03\u7528\u5916\u90e8\u7cfb\u7edf\u63d0\u4f9b\u7684\u529f\u80fd\u8fdb\u884c\u542f\u52a8\u3001\u7ed3\u675f\u6d41\u7a0b\u7b49\u64cd\u4f5c\uff0c\u6d41\u7a0b\u5b9e\u9645\u7684\u6d41\u8f6c\u5904\u7406\u5728\u5916\u90e8\u7cfb\u7edf\u5b8c\u6210"), @CodeItem(value="2", text="\u63d0\u4f9b\u6d41\u7a0b\u4ee3\u7406\u670d\u52a1\uff08\u670d\u52a1\u7aef\uff09", realtext="\u63d0\u4f9b\u6d41\u7a0b\u4ee3\u7406\u670d\u52a1\uff08\u670d\u52a1\u7aef\uff09", userdata="\u5de5\u4f5c\u6d41\u63d0\u4f9b\u63a5\u53e3\u63a5\u6536\u542f\u52a8\u3001\u7ed3\u675f\u7b49\u6307\u4ee4\uff0c\u5b8c\u6210\u6d41\u7a0b\u5b9e\u9645\u7684\u6d41\u8f6c\u5904\u7406")})
public class WFDEProxyModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer CLIENT = 1;
    public static final int INT_CLIENT = 1;
    public static final Integer SERVER = 2;
    public static final int INT_SERVER = 2;

    public WFDEProxyModeCodeListModel() {
        this.initAnnotation(WFDEProxyModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WFDEProxyModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WFDEProxyModeCodeListModel");
    }
}

