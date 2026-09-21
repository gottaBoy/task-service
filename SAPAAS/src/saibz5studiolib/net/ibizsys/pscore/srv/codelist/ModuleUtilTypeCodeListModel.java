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

@CodeList(id="72B0F184-8B2D-451C-ADFF-7927A865A9F4", name="\u7cfb\u7edf\u6a21\u5757\u529f\u80fd\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="ADMIN", text="\u7ba1\u7406\u6a21\u5757", realtext="\u7ba1\u7406\u6a21\u5757"), @CodeItem(value="EXTENSION", text="\u6269\u5c55\u6a21\u5757", realtext="\u6269\u5c55\u6a21\u5757"), @CodeItem(value="EAI", text="\u5e94\u7528\u96c6\u6210", realtext="\u5e94\u7528\u96c6\u6210"), @CodeItem(value="BI", text="\u667a\u80fd\u62a5\u8868", realtext="\u667a\u80fd\u62a5\u8868"), @CodeItem(value="MAINSYSPROXY", text="\u4e3b\u7cfb\u7edf\u4ee3\u7406", realtext="\u4e3b\u7cfb\u7edf\u4ee3\u7406"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49")})
public class ModuleUtilTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String ADMIN = "ADMIN";
    public static final String EXTENSION = "EXTENSION";
    public static final String EAI = "EAI";
    public static final String BI = "BI";
    public static final String MAINSYSPROXY = "MAINSYSPROXY";
    public static final String USER = "USER";

    public ModuleUtilTypeCodeListModel() {
        this.initAnnotation(ModuleUtilTypeCodeListModel.class);
        this.setUserData2("ModuleUtilType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ModuleUtilTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ModuleUtilTypeCodeListModel");
    }
}

