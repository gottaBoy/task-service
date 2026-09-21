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

@CodeList(id="809dac5c323a3c3c60647ebd52bb9f14", name="\u5b9e\u4f53\u884c\u4e3a\u6279\u64cd\u4f5c\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u652f\u6301", realtext="\u4e0d\u652f\u6301"), @CodeItem(value="1", text="\u652f\u6301", realtext="\u652f\u6301"), @CodeItem(value="2", text="\u4ec5\u652f\u6301\u6279\u64cd\u4f5c", realtext="\u4ec5\u652f\u6301\u6279\u64cd\u4f5c"), @CodeItem(value="5", text="\u652f\u6301\uff08\u4e8b\u52a1\uff09", realtext="\u652f\u6301\uff08\u4e8b\u52a1\uff09", userdata="\u652f\u6301\u6279\u64cd\u4f5c\uff0c\u5e76\u4e14\u8981\u6c42\u6279\u64cd\u4f5c\u518d\u540c\u4e00\u4e2a\u4e8b\u52a1\u4e2d"), @CodeItem(value="6", text="\u4ec5\u652f\u6301\u6279\u64cd\u4f5c\uff08\u4e8b\u52a1\uff09", realtext="\u4ec5\u652f\u6301\u6279\u64cd\u4f5c\uff08\u4e8b\u52a1\uff09")})
public class DEActionBatchModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOTSUPPORTED = 0;
    public static final int INT_NOTSUPPORTED = 0;
    public static final Integer ENABLE = 1;
    public static final int INT_ENABLE = 1;
    public static final Integer BATCHONLY = 2;
    public static final int INT_BATCHONLY = 2;
    public static final Integer ENABLEEX = 5;
    public static final int INT_ENABLEEX = 5;
    public static final Integer BATCHONLYEX = 6;
    public static final int INT_BATCHONLYEX = 6;

    public DEActionBatchModeCodeListModel() {
        this.initAnnotation(DEActionBatchModeCodeListModel.class);
        this.setUserData2("DEActionBatchMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionBatchModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionBatchModeCodeListModel");
    }
}

