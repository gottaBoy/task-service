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

@CodeList(id="df3b29c0236f7c2b50920f00a54bb199", name="\u7cfb\u7edf\u6a21\u578b\u4ed3\u5e93\u540c\u6b65", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u4e0d\u540c\u6b65", realtext="\u4e0d\u540c\u6b65"), @CodeItem(value="NOTEXISTS", text="\u4e0d\u5b58\u5728\u65f6\u540c\u6b65", realtext="\u4e0d\u5b58\u5728\u65f6\u540c\u6b65"), @CodeItem(value="ALWAYS", text="\u603b\u662f\u540c\u6b65", realtext="\u603b\u662f\u540c\u6b65")})
public class SysModelSyncModeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String NOTEXISTS = "NOTEXISTS";
    public static final String ALWAYS = "ALWAYS";

    public SysModelSyncModeCodeListModel() {
        this.initAnnotation(SysModelSyncModeCodeListModel.class);
        this.setUserData2("ModelSyncMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysModelSyncModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysModelSyncModeCodeListModel");
    }
}

