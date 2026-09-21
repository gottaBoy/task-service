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

@CodeList(id="2294e6e70725a36684f875fde9ea0d94", name="\u754c\u9762\u884c\u4e3a\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SYS", text="\u7cfb\u7edf\u9884\u5b9a\u4e49", realtext="\u7cfb\u7edf\u9884\u5b9a\u4e49", userdata="\u7cfb\u7edf\u9884\u7f6e\u754c\u9762\u884c\u4e3a"), @CodeItem(value="FRONT", text="\u524d\u53f0\u8c03\u7528", realtext="\u524d\u53f0\u8c03\u7528", userdata="\u6253\u5f00\u89c6\u56fe\u5b8c\u6210\u5904\u7406"), @CodeItem(value="BACKEND", text="\u540e\u53f0\u8c03\u7528", realtext="\u540e\u53f0\u8c03\u7528", userdata="\u8c03\u7528\u5b9e\u4f53\u884c\u4e3a\u5b8c\u6210\u5904\u7406"), @CodeItem(value="WFFRONT", text="\u5de5\u4f5c\u6d41\u524d\u53f0\u8c03\u7528", realtext="\u5de5\u4f5c\u6d41\u524d\u53f0\u8c03\u7528", userdata="\u6253\u5f00\u5de5\u4f5c\u6d41\u89c6\u56fe\u5b8c\u6210\u5904\u7406"), @CodeItem(value="WFBACKEND", text="\u5de5\u4f5c\u6d41\u540e\u53f0\u8c03\u7528", realtext="\u5de5\u4f5c\u6d41\u540e\u53f0\u8c03\u7528", userdata="\u8c03\u7528\u5de5\u4f5c\u6d41\u5f15\u64ce\u670d\u52a1\u5b8c\u6210\u5904\u7406"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49\u4ee3\u7801", realtext="\u81ea\u5b9a\u4e49\u4ee3\u7801")})
public class DEUIActionTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SYS = "SYS";
    public static final String FRONT = "FRONT";
    public static final String BACKEND = "BACKEND";
    public static final String WFFRONT = "WFFRONT";
    public static final String WFBACKEND = "WFBACKEND";
    public static final String CUSTOM = "CUSTOM";

    public DEUIActionTypeCodeListModel() {
        this.initAnnotation(DEUIActionTypeCodeListModel.class);
        this.setUserData2("UIActionType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEUIActionTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEUIActionTypeCodeListModel");
    }
}

