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

@CodeList(id="ca398d1e544c4d034bde01bfa6e82a98", name="\u5173\u7cfb\u754c\u9762\u7ec4\u6210\u5458\u542f\u7528\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="ALL", text="\u5168\u90e8\u542f\u7528", realtext="\u5168\u90e8\u542f\u7528"), @CodeItem(value="INWF", text="\u6d41\u7a0b\u4e2d\u542f\u7528", realtext="\u6d41\u7a0b\u4e2d\u542f\u7528", userdata="\u5173\u7cfb\u754c\u9762\u9879\u4ec5\u5728\u6570\u636e\u5904\u4e8e\u6d41\u7a0b\u6d41\u8f6c\u4e2d\u542f\u7528"), @CodeItem(value="ALLWF", text="\u5168\u90e8\u6d41\u7a0b\u72b6\u6001\u542f\u7528", realtext="\u5168\u90e8\u6d41\u7a0b\u72b6\u6001\u542f\u7528", userdata="\u5173\u7cfb\u754c\u9762\u9879\u5728\u6570\u636e\u5177\u5907\u6d41\u7a0b\u72b6\u6001\u542f\u7528\uff0c\u5305\u62ec\u4e86\u6d41\u7a0b\u7ed3\u675f\u3001\u9519\u8bef\u7b49"), @CodeItem(value="EDIT", text="\u7f16\u8f91\u65f6\u542f\u7528", realtext="\u7f16\u8f91\u65f6\u542f\u7528", userdata="\u5173\u7cfb\u754c\u9762\u5728\u6570\u636e\u5904\u4e8e\u7f16\u8f91\u72b6\u6001\u65f6\u542f\u7528"), @CodeItem(value="DEOPPRIV", text="\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6", realtext="\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6", userdata="\u5173\u7cfb\u754c\u9762\u5728\u5bf9\u5f53\u524d\u6570\u636e\u5177\u5907\u6307\u5b9a\u64cd\u4f5c\u6807\u8bc6\u65f6\u542f\u7528"), @CodeItem(value="DELOGIC", text="\u5b9e\u4f53\u903b\u8f91", realtext="\u5b9e\u4f53\u903b\u8f91"), @CodeItem(value="SCRIPT", text="\u811a\u672c", realtext="\u811a\u672c"), @CodeItem(value="COUNT_GTE_ZERO", text="\u8ba1\u6570\u5927\u4e8e\u7b49\u4e8e0", realtext="\u8ba1\u6570\u5927\u4e8e\u7b49\u4e8e0"), @CodeItem(value="COUNT_GT_ZERO", text="\u8ba1\u6570\u5927\u4e8e0", realtext="\u8ba1\u6570\u5927\u4e8e0"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49\uff08\u6682\u4e0d\u4f7f\u7528\uff09", realtext="\u81ea\u5b9a\u4e49\uff08\u6682\u4e0d\u4f7f\u7528\uff09")})
public class DEDRDetailEnableModeCodeListModel
extends StaticCodeListModelBase {
    public static final String ALL = "ALL";
    public static final String INWF = "INWF";
    public static final String ALLWF = "ALLWF";
    public static final String EDIT = "EDIT";
    public static final String DEOPPRIV = "DEOPPRIV";
    public static final String DELOGIC = "DELOGIC";
    public static final String SCRIPT = "SCRIPT";
    public static final String COUNT_GTE_ZERO = "COUNT_GTE_ZERO";
    public static final String COUNT_GT_ZERO = "COUNT_GT_ZERO";
    public static final String CUSTOM = "CUSTOM";

    public DEDRDetailEnableModeCodeListModel() {
        this.initAnnotation(DEDRDetailEnableModeCodeListModel.class);
        this.setUserData2("DEDRDetailEnableMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDRDetailEnableModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDRDetailEnableModeCodeListModel");
    }
}

