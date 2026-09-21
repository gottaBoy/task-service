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

@CodeList(id="3c4c97e6b4af06aaf23ff7006cd934f5", name="\u5b9e\u4f53\u89c6\u56fe\u64cd\u4f5c\u63a7\u5236", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u652f\u6301\u5efa\u7acb", realtext="\u652f\u6301\u5efa\u7acb"), @CodeItem(value="2", text="\u652f\u6301\u7f16\u8f91", realtext="\u652f\u6301\u7f16\u8f91"), @CodeItem(value="4", text="\u652f\u6301\u67e5\u770b", realtext="\u652f\u6301\u67e5\u770b"), @CodeItem(value="8", text="\u652f\u6301\u5220\u9664", realtext="\u652f\u6301\u5220\u9664"), @CodeItem(value="16", text="\u652f\u6301\u62f7\u8d1d", realtext="\u652f\u6301\u62f7\u8d1d"), @CodeItem(value="32", text="\u652f\u6301\u884c\u7f16\u8f91", realtext="\u652f\u6301\u884c\u7f16\u8f91"), @CodeItem(value="64", text="\u652f\u6301\u5bfc\u51fa", realtext="\u652f\u6301\u5bfc\u51fa"), @CodeItem(value="1024", text="\u652f\u6301\u5bfc\u5165", realtext="\u652f\u6301\u5bfc\u5165"), @CodeItem(value="128", text="\u652f\u6301\u6253\u5370", realtext="\u652f\u6301\u6253\u5370"), @CodeItem(value="256", text="\u652f\u6301\u8fc7\u6ee4", realtext="\u652f\u6301\u8fc7\u6ee4"), @CodeItem(value="512", text="\u652f\u6301\u5e2e\u52a9", realtext="\u652f\u6301\u5e2e\u52a9"), @CodeItem(value="2048", text="\u652f\u6301\u542f\u52a8\u6d41\u7a0b", realtext="\u652f\u6301\u542f\u52a8\u6d41\u7a0b")})
public class DEViewActionsCodeListModel
extends StaticCodeListModelBase {
    public static final Integer CREATE = 1;
    public static final int INT_CREATE = 1;
    public static final Integer EDIT = 2;
    public static final int INT_EDIT = 2;
    public static final Integer VIEW = 4;
    public static final int INT_VIEW = 4;
    public static final Integer REMOVE = 8;
    public static final int INT_REMOVE = 8;
    public static final Integer COPY = 16;
    public static final int INT_COPY = 16;
    public static final Integer ROWEDIT = 32;
    public static final int INT_ROWEDIT = 32;
    public static final Integer EXPORT = 64;
    public static final int INT_EXPORT = 64;
    public static final Integer IMPORT = 1024;
    public static final int INT_IMPORT = 1024;
    public static final Integer PRINT = 128;
    public static final int INT_PRINT = 128;
    public static final Integer FILTER = 256;
    public static final int INT_FILTER = 256;
    public static final Integer HELP = 512;
    public static final int INT_HELP = 512;
    public static final Integer STARTWF = 2048;
    public static final int INT_STARTWF = 2048;

    public DEViewActionsCodeListModel() {
        this.initAnnotation(DEViewActionsCodeListModel.class);
        this.setUserData2("DEViewAction");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEViewActionsCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEViewActionsCodeListModel");
    }
}

