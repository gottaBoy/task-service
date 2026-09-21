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

@CodeList(id="21050e9cbb582c050527a02cf43e3b0a", name="\u4e91\u5e94\u7528\u4e2d\u5fc3\u540e\u53f0\u4efb\u52a1\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PACKDEVSLNSYS", text="\u6253\u5305\u5f00\u53d1\u7cfb\u7edf", realtext="\u6253\u5305\u5f00\u53d1\u7cfb\u7edf"), @CodeItem(value="CREATEDEVSLNSYS", text="\u5efa\u7acb\u5f00\u53d1\u7cfb\u7edf", realtext="\u5efa\u7acb\u5f00\u53d1\u7cfb\u7edf"), @CodeItem(value="BACKUPDCDBINST", text="\u5907\u4efd\u5e94\u7528\u4e2d\u5fc3\u6570\u636e\u5e93\u5b9e\u4f8b", realtext="\u5907\u4efd\u5e94\u7528\u4e2d\u5fc3\u6570\u636e\u5e93\u5b9e\u4f8b"), @CodeItem(value="RESTOREDCDBINST", text="\u6062\u590d\u5e94\u7528\u4e2d\u5fc3\u6570\u636e\u5e93\u5b9e\u4f8b", realtext="\u6062\u590d\u5e94\u7528\u4e2d\u5fc3\u6570\u636e\u5e93\u5b9e\u4f8b"), @CodeItem(value="IMPPFSTYLE", text="\u5bfc\u5165\u524d\u7aef\u6837\u5f0f\u6a21\u677f", realtext="\u5bfc\u5165\u524d\u7aef\u6837\u5f0f\u6a21\u677f"), @CodeItem(value="IMPSFSTYLEVER", text="\u5bfc\u5165\u540e\u53f0\u670d\u52a1\u6846\u67b6\u6a21\u677f", realtext="\u5bfc\u5165\u540e\u53f0\u670d\u52a1\u6846\u67b6\u6a21\u677f"), @CodeItem(value="BACKUPDEVSLNSYS", text="\u5907\u4efd\u5f00\u53d1\u7cfb\u7edf", realtext="\u5907\u4efd\u5f00\u53d1\u7cfb\u7edf"), @CodeItem(value="RESTOREDEVSLNSYS", text="\u6062\u590d\u5f00\u53d1\u7cfb\u7edf", realtext="\u6062\u590d\u5f00\u53d1\u7cfb\u7edf"), @CodeItem(value="ONLINEDEVSLNSYS", text="\u8fde\u7ebf\u5f00\u53d1\u7cfb\u7edf", realtext="\u8fde\u7ebf\u5f00\u53d1\u7cfb\u7edf"), @CodeItem(value="OFFLINEDEVSLNSYS", text="\u79bb\u7ebf\u5f00\u53d1\u7cfb\u7edf", realtext="\u79bb\u7ebf\u5f00\u53d1\u7cfb\u7edf"), @CodeItem(value="CREATEDEVSLNSYS2", text="\u5efa\u7acb\u5f00\u53d1\u7cfb\u7edf\u5206\u652f", realtext="\u5efa\u7acb\u5f00\u53d1\u7cfb\u7edf\u5206\u652f"), @CodeItem(value="CREATEDEVSLNSYSDEPINST", text="\u5efa\u7acb\u7cfb\u7edf\u90e8\u7f72\u6a21\u578b\u4ed3\u5e93", realtext="\u5efa\u7acb\u7cfb\u7edf\u90e8\u7f72\u6a21\u578b\u4ed3\u5e93"), @CodeItem(value="EXPORTDEVSYSMODEL", text="\u5bfc\u51fa\u7cfb\u7edf\u6a21\u578b", realtext="\u5bfc\u51fa\u7cfb\u7edf\u6a21\u578b"), @CodeItem(value="IMPORTDEVSYSMODEL", text="\u5bfc\u5165\u7cfb\u7edf\u6a21\u578b", realtext="\u5bfc\u5165\u7cfb\u7edf\u6a21\u578b"), @CodeItem(value="UPGRATEDEVSYSMODEL", text="\u5347\u7ea7\u6a21\u578b\u4ed3\u5e93", realtext="\u5347\u7ea7\u6a21\u578b\u4ed3\u5e93"), @CodeItem(value="WORKSPACEACTION", text="\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u4f5c\u4e1a", realtext="\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u4f5c\u4e1a"), @CodeItem(value="UWPROJECT", text="\u5efa\u7acb\u9879\u76ee\u5411\u5bfc", realtext="\u5efa\u7acb\u9879\u76ee\u5411\u5bfc"), @CodeItem(value="IBIZCENTRAL", text="iBizCentral\uff08\u4e2d\u53f0\uff09", realtext="iBizCentral\uff08\u4e2d\u53f0\uff09"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49")})
public class DCBKTaskTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String PACKDEVSLNSYS = "PACKDEVSLNSYS";
    public static final String CREATEDEVSLNSYS = "CREATEDEVSLNSYS";
    public static final String BACKUPDCDBINST = "BACKUPDCDBINST";
    public static final String RESTOREDCDBINST = "RESTOREDCDBINST";
    public static final String IMPPFSTYLE = "IMPPFSTYLE";
    public static final String IMPSFSTYLEVER = "IMPSFSTYLEVER";
    public static final String BACKUPDEVSLNSYS = "BACKUPDEVSLNSYS";
    public static final String RESTOREDEVSLNSYS = "RESTOREDEVSLNSYS";
    public static final String ONLINEDEVSLNSYS = "ONLINEDEVSLNSYS";
    public static final String OFFLINEDEVSLNSYS = "OFFLINEDEVSLNSYS";
    public static final String CREATEDEVSLNSYS2 = "CREATEDEVSLNSYS2";
    public static final String CREATEDEVSLNSYSDEPINST = "CREATEDEVSLNSYSDEPINST";
    public static final String EXPORTDEVSYSMODEL = "EXPORTDEVSYSMODEL";
    public static final String IMPORTDEVSYSMODEL = "IMPORTDEVSYSMODEL";
    public static final String UPGRATEDEVSYSMODEL = "UPGRATEDEVSYSMODEL";
    public static final String WORKSPACEACTION = "WORKSPACEACTION";
    public static final String UWPROJECT = "UWPROJECT";
    public static final String IBIZCENTRAL = "IBIZCENTRAL";
    public static final String USER = "USER";

    public DCBKTaskTypeCodeListModel() {
        this.initAnnotation(DCBKTaskTypeCodeListModel.class);
        this.setUserData2("DCBKTaskType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DCBKTaskTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DCBKTaskTypeCodeListModel");
    }
}

