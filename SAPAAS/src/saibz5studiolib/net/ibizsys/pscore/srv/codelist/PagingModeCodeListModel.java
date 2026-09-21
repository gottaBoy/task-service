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

@CodeList(id="D48FC5A9-4A10-4849-99BD-68430B974247", name="\u6570\u636e\u5206\u9875\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u5206\u9875", realtext="\u4e0d\u5206\u9875"), @CodeItem(value="1", text="\u5206\u9875\u680f", realtext="\u5206\u9875\u680f"), @CodeItem(value="2", text="\u6eda\u52a8\u52a0\u8f7d", realtext="\u6eda\u52a8\u52a0\u8f7d"), @CodeItem(value="3", text="\u52a0\u8f7d\u66f4\u591a", realtext="\u52a0\u8f7d\u66f4\u591a")})
public class PagingModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer PAGINGBAR = 1;
    public static final int INT_PAGINGBAR = 1;
    public static final Integer INFINITESCROLL = 2;
    public static final int INT_INFINITESCROLL = 2;
    public static final Integer LOADMORE = 3;
    public static final int INT_LOADMORE = 3;

    public PagingModeCodeListModel() {
        this.initAnnotation(PagingModeCodeListModel.class);
        this.setUserData2("PagingMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PagingModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PagingModeCodeListModel");
    }
}

