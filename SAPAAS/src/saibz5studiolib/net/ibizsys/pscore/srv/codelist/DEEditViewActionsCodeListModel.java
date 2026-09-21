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

@CodeList(id="838c3c6131f419a90202e49b8c6e1688", name="\u4e91\u5b9e\u4f53\u89c6\u56fe\u64cd\u4f5c\u63a7\u5236\uff08\u7f16\u8f91\u89c6\u56fe\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u652f\u6301\u5efa\u7acb", realtext="\u652f\u6301\u5efa\u7acb"), @CodeItem(value="2", text="\u652f\u6301\u7f16\u8f91", realtext="\u652f\u6301\u7f16\u8f91"), @CodeItem(value="4", text="\u652f\u6301\u67e5\u770b", realtext="\u652f\u6301\u67e5\u770b"), @CodeItem(value="8", text="\u652f\u6301\u5220\u9664", realtext="\u652f\u6301\u5220\u9664"), @CodeItem(value="16", text="\u652f\u6301\u62f7\u8d1d", realtext="\u652f\u6301\u62f7\u8d1d"), @CodeItem(value="128", text="\u652f\u6301\u6253\u5370", realtext="\u652f\u6301\u6253\u5370"), @CodeItem(value="512", text="\u652f\u6301\u5e2e\u52a9", realtext="\u652f\u6301\u5e2e\u52a9"), @CodeItem(value="2048", text="\u652f\u6301\u542f\u52a8\u6d41\u7a0b", realtext="\u652f\u6301\u542f\u52a8\u6d41\u7a0b")})
public class DEEditViewActionsCodeListModel
extends StaticCodeListModelBase {
    public static final Integer ITEM_1 = 1;
    public static final int INT_ITEM_1 = 1;
    public static final Integer ITEM_2 = 2;
    public static final int INT_ITEM_2 = 2;
    public static final Integer ITEM_4 = 4;
    public static final int INT_ITEM_4 = 4;
    public static final Integer ITEM_8 = 8;
    public static final int INT_ITEM_8 = 8;
    public static final Integer ITEM_16 = 16;
    public static final int INT_ITEM_16 = 16;
    public static final Integer ITEM_128 = 128;
    public static final int INT_ITEM_128 = 128;
    public static final Integer ITEM_512 = 512;
    public static final int INT_ITEM_512 = 512;
    public static final Integer ITEM_2048 = 2048;
    public static final int INT_ITEM_2048 = 2048;

    public DEEditViewActionsCodeListModel() {
        this.initAnnotation(DEEditViewActionsCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEEditViewActionsCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEEditViewActionsCodeListModel");
    }
}

