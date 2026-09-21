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

@CodeList(id="c38ab8b4fac07786226212ab156c88e2", name="\u5f00\u53d1\u7cfb\u7edf\u5f53\u524d\u64cd\u4f5c", type="STATIC", userscope=false, emptytext="\u65e0")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0", realtext="\u65e0"), @CodeItem(value="BACKUP", text="\u7cfb\u7edf\u6a21\u578b\u5907\u4efd", realtext="\u7cfb\u7edf\u6a21\u578b\u5907\u4efd"), @CodeItem(value="RECOVER", text="\u7cfb\u7edf\u6a21\u578b\u6062\u590d", realtext="\u7cfb\u7edf\u6a21\u578b\u6062\u590d"), @CodeItem(value="CREATE", text="\u5efa\u7acb\u7cfb\u7edf", realtext="\u5efa\u7acb\u7cfb\u7edf"), @CodeItem(value="ONLINE", text="\u8fde\u7ebf\u7cfb\u7edf", realtext="\u8fde\u7ebf\u7cfb\u7edf"), @CodeItem(value="OFFLINE", text="\u79bb\u7ebf\u7cfb\u7edf", realtext="\u79bb\u7ebf\u7cfb\u7edf"), @CodeItem(value="CREATEDEPINST", text="\u5efa\u7acb\u90e8\u7f72\u6a21\u578b\u4ed3\u5e93", realtext="\u5efa\u7acb\u90e8\u7f72\u6a21\u578b\u4ed3\u5e93"), @CodeItem(value="EXPORT", text="\u7cfb\u7edf\u6a21\u578b\u5bfc\u51fa", realtext="\u7cfb\u7edf\u6a21\u578b\u5bfc\u51fa"), @CodeItem(value="IMPORT", text="\u7cfb\u7edf\u6a21\u578b\u5bfc\u5165", realtext="\u7cfb\u7edf\u6a21\u578b\u5bfc\u5165"), @CodeItem(value="UPGRATE", text="\u5347\u7ea7\u6a21\u578b\u4ed3\u5e93", realtext="\u5347\u7ea7\u6a21\u578b\u4ed3\u5e93")})
public class DevSysActionCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String BACKUP = "BACKUP";
    public static final String RECOVER = "RECOVER";
    public static final String CREATE = "CREATE";
    public static final String ONLINE = "ONLINE";
    public static final String OFFLINE = "OFFLINE";
    public static final String CREATEDEPINST = "CREATEDEPINST";
    public static final String EXPORT = "EXPORT";
    public static final String IMPORT = "IMPORT";
    public static final String UPGRATE = "UPGRATE";

    public DevSysActionCodeListModel() {
        this.initAnnotation(DevSysActionCodeListModel.class);
        this.setUserData2("DevSysAction");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSysActionCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSysActionCodeListModel");
    }
}

