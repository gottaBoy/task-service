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

@CodeList(id="6cd72007ef15d1970f770e332fc5c660", name="\u4e2d\u5fc3\u6d41\u6c34\u7ebf\u65e5\u5fd7\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u65e0\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\uff08\u65e0\uff09", realtext="\uff08\u65e0\uff09"), @CodeItem(value="INSTALLSYS", text="\u5b89\u88c5\u7cfb\u7edf", realtext="\u5b89\u88c5\u7cfb\u7edf"), @CodeItem(value="UNINSTALLSYS", text="\u5378\u8f7d\u7cfb\u7edf", realtext="\u5378\u8f7d\u7cfb\u7edf"), @CodeItem(value="STARTUP", text="\u542f\u52a8\u751f\u4ea7\u7ebf", realtext="\u542f\u52a8\u751f\u4ea7\u7ebf"), @CodeItem(value="SHUTDOWN", text="\u5173\u95ed\u751f\u4ea7\u7ebf", realtext="\u5173\u95ed\u751f\u4ea7\u7ebf"), @CodeItem(value="ASSIGN", text="\u5206\u914d\u5230\u65b9\u6848", realtext="\u5206\u914d\u5230\u65b9\u6848"), @CodeItem(value="UNASSIGN", text="\u53d6\u6d88\u5206\u914d", realtext="\u53d6\u6d88\u5206\u914d")})
public class DCWorkspaceLogTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String INSTALLSYS = "INSTALLSYS";
    public static final String UNINSTALLSYS = "UNINSTALLSYS";
    public static final String STARTUP = "STARTUP";
    public static final String SHUTDOWN = "SHUTDOWN";
    public static final String ASSIGN = "ASSIGN";
    public static final String UNASSIGN = "UNASSIGN";

    public DCWorkspaceLogTypeCodeListModel() {
        this.initAnnotation(DCWorkspaceLogTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DCWorkspaceLogTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DCWorkspaceLogTypeCodeListModel");
    }
}

