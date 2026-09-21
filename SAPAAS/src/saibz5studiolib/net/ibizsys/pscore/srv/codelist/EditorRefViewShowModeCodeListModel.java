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

@CodeList(id="d4ef436a2ab1f98a10fc3c8e9c3d98a8", name="\u7f16\u8f91\u5668\u5f15\u7528\u89c6\u56fe\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NORMAL", text="\u5e38\u89c4", realtext="\u5e38\u89c4"), @CodeItem(value="MODAL", text="\u6a21\u6001", realtext="\u6a21\u6001", userdata="\u89c6\u56fe\u5df2\u6a21\u6001\u7684\u5f62\u5f0f\u5f39\u51fa\u663e\u793a"), @CodeItem(value="EMBEDDED", text="\u5d4c\u5165", realtext="\u5d4c\u5165", userdata="\u89c6\u56fe\u4ee5\u5d4c\u5165\u5f62\u5f0f\u5728\u7f16\u8f91\u5668\u5bb9\u5668\u5185\u663e\u793a")})
public class EditorRefViewShowModeCodeListModel
extends StaticCodeListModelBase {
    public static final String NORMAL = "NORMAL";
    public static final String MODAL = "MODAL";
    public static final String EMBEDDED = "EMBEDDED";

    public EditorRefViewShowModeCodeListModel() {
        this.initAnnotation(EditorRefViewShowModeCodeListModel.class);
        this.setUserData2("EditorRefViewShowMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.EditorRefViewShowModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.EditorRefViewShowModeCodeListModel");
    }
}

