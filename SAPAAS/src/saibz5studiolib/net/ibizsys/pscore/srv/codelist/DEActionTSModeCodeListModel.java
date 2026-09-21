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

@CodeList(id="8e3b5c5ebdf2f16a0b12b68fd6b8fe0b", name="\u5b9e\u4f53\u884c\u4e3a\u4e8b\u52a1\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEFAULT", text="\u9ed8\u8ba4", realtext="\u9ed8\u8ba4"), @CodeItem(value="REQUIRED", text="\u9700\u8981\u4e8b\u52a1\uff08\u6ca1\u6709\u65b0\u5efa\uff09", realtext="\u9700\u8981\u4e8b\u52a1\uff08\u6ca1\u6709\u65b0\u5efa\uff09"), @CodeItem(value="MANDATORY", text="\u9700\u8981\u4e8b\u52a1\uff08\u6ca1\u6709\u5f02\u5e38\uff09", realtext="\u9700\u8981\u4e8b\u52a1\uff08\u6ca1\u6709\u5f02\u5e38\uff09"), @CodeItem(value="NESTED", text="\u5d4c\u5957\u4e8b\u52a1\uff08\u6ca1\u6709\u65b0\u5efa\uff09", realtext="\u5d4c\u5957\u4e8b\u52a1\uff08\u6ca1\u6709\u65b0\u5efa\uff09"), @CodeItem(value="REQUIRES_NEW", text="\u6302\u8d77\u5f53\u524d\u4e8b\u52a1\uff08\u6ca1\u6709\u65b0\u5efa\uff09", realtext="\u6302\u8d77\u5f53\u524d\u4e8b\u52a1\uff08\u6ca1\u6709\u65b0\u5efa\uff09"), @CodeItem(value="NOT_SUPPORTED", text="\u65e0\u4e8b\u52a1\uff08\u5b58\u5728\u5219\u6302\u8d77\uff09", realtext="\u65e0\u4e8b\u52a1\uff08\u5b58\u5728\u5219\u6302\u8d77\uff09"), @CodeItem(value="SUPPORTS", text="\u652f\u6301\u4e8b\u52a1\uff08\u6ca1\u6709\u65e0\u4e8b\u52a1\uff09", realtext="\u652f\u6301\u4e8b\u52a1\uff08\u6ca1\u6709\u65e0\u4e8b\u52a1\uff09"), @CodeItem(value="NONE", text="\u65e0\u4e8b\u52a1", realtext="\u65e0\u4e8b\u52a1"), @CodeItem(value="GLOBAL", text="\u5206\u5e03\u5f0f\u4e8b\u52a1", realtext="\u5206\u5e03\u5f0f\u4e8b\u52a1"), @CodeItem(value="USER", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u81ea\u5b9a\u4e492", realtext="\u81ea\u5b9a\u4e492")})
public class DEActionTSModeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFAULT = "DEFAULT";
    public static final String REQUIRED = "REQUIRED";
    public static final String MANDATORY = "MANDATORY";
    public static final String NESTED = "NESTED";
    public static final String REQUIRES_NEW = "REQUIRES_NEW";
    public static final String NOT_SUPPORTED = "NOT_SUPPORTED";
    public static final String SUPPORTS = "SUPPORTS";
    public static final String NONE = "NONE";
    public static final String GLOBAL = "GLOBAL";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public DEActionTSModeCodeListModel() {
        this.initAnnotation(DEActionTSModeCodeListModel.class);
        this.setUserData2("DEActionTSMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionTSModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionTSModeCodeListModel");
    }
}

