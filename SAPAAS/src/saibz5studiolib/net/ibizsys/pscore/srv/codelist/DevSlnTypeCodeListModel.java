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

@CodeList(id="02b670dad66f00194311320e827e91d2", name="\u5e94\u7528\u65b9\u6848\u7c7b\u578b", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="DEVSYS", text="\u5f00\u53d1\u7cfb\u7edf", realtext="\u5f00\u53d1\u7cfb\u7edf"), @CodeItem(value="DEPSYS", text="\u53ef\u90e8\u7f72\u7cfb\u7edf", realtext="\u53ef\u90e8\u7f72\u7cfb\u7edf")})
public class DevSlnTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEVSYS = "DEVSYS";
    public static final String DEPSYS = "DEPSYS";

    public DevSlnTypeCodeListModel() {
        this.initAnnotation(DevSlnTypeCodeListModel.class);
        this.setUserData2("DevSlnType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSlnTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSlnTypeCodeListModel");
    }
}

