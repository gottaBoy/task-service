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

@CodeList(id="fe1e33414ef3b91276b90c7bacc8cf61", name="\u7cfb\u7edf\u540c\u6b65\u6e90\u6807\u8bc6", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SOURCE1", text="\u540c\u6b65\u6e901", realtext="\u540c\u6b65\u6e901"), @CodeItem(value="SOURCE2", text="\u540c\u6b65\u6e902", realtext="\u540c\u6b65\u6e902"), @CodeItem(value="SOURCE3", text="\u540c\u6b65\u6e903", realtext="\u540c\u6b65\u6e903"), @CodeItem(value="SOURCE4", text="\u540c\u6b65\u6e904", realtext="\u540c\u6b65\u6e904"), @CodeItem(value="SOURCE5", text="\u540c\u6b65\u6e905", realtext="\u540c\u6b65\u6e905"), @CodeItem(value="SOURCE6", text="\u540c\u6b65\u6e906", realtext="\u540c\u6b65\u6e906"), @CodeItem(value="SOURCE7", text="\u540c\u6b65\u6e907", realtext="\u540c\u6b65\u6e907"), @CodeItem(value="SOURCE8", text="\u540c\u6b65\u6e908", realtext="\u540c\u6b65\u6e908")})
public class SystemSyncSrcCodeListModel
extends StaticCodeListModelBase {
    public static final String SOURCE1 = "SOURCE1";
    public static final String SOURCE2 = "SOURCE2";
    public static final String SOURCE3 = "SOURCE3";
    public static final String SOURCE4 = "SOURCE4";
    public static final String SOURCE5 = "SOURCE5";
    public static final String SOURCE6 = "SOURCE6";
    public static final String SOURCE7 = "SOURCE7";
    public static final String SOURCE8 = "SOURCE8";

    public SystemSyncSrcCodeListModel() {
        this.initAnnotation(SystemSyncSrcCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SystemSyncSrcCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SystemSyncSrcCodeListModel");
    }
}

