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

@CodeList(id="b3915f41fda0b70a2f44cc4a01ae69c6", name="\u7cfb\u7edf\u6a21\u578b\u4ed3\u5e93\u6e90", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0", realtext="\u65e0"), @CodeItem(value="PS", text="\u5e73\u53f0\u7cfb\u7edf\u6a21\u578b\u5e93", realtext="\u5e73\u53f0\u7cfb\u7edf\u6a21\u578b\u5e93"), @CodeItem(value="DC", text="\u4e2d\u5fc3\u7cfb\u7edf\u6a21\u578b\u5e93", realtext="\u4e2d\u5fc3\u7cfb\u7edf\u6a21\u578b\u5e93")})
public class SysModelRepoFromCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String PS = "PS";
    public static final String DC = "DC";

    public SysModelRepoFromCodeListModel() {
        this.initAnnotation(SysModelRepoFromCodeListModel.class);
        this.setUserData2("ModelRepoFrom");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysModelRepoFromCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysModelRepoFromCodeListModel");
    }
}

