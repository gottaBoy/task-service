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

@CodeList(id="35C2B115-4C94-4A4F-BAE0-0324E0F1CE2E", name="\u7cfb\u7edf\u8fd0\u884c\u7ec4\u4ef6\u90e8\u7f72\u76ee\u6807", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SLN", text="\u5f00\u53d1\u65b9\u6848\u4ed3\u5e93\uff08\u9ed8\u8ba4\uff09", realtext="\u5f00\u53d1\u65b9\u6848\u4ed3\u5e93\uff08\u9ed8\u8ba4\uff09"), @CodeItem(value="DC", text="\u5e94\u7528\u4e2d\u5fc3\u4ed3\u5e93", realtext="\u5e94\u7528\u4e2d\u5fc3\u4ed3\u5e93")})
public class SysRunPkgDeployTargetCodeListModel
extends StaticCodeListModelBase {
    public static final String SLN = "SLN";
    public static final String DC = "DC";

    public SysRunPkgDeployTargetCodeListModel() {
        this.initAnnotation(SysRunPkgDeployTargetCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysRunPkgDeployTargetCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysRunPkgDeployTargetCodeListModel");
    }
}

