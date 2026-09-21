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

@CodeList(id="D55B8C4E-45A5-494E-ACA5-00B7BAB5BA86", name="Pipeline\u6b65\u9aa4\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="CODEGEN", text="\u4ee3\u7801\u751f\u6210", realtext="\u4ee3\u7801\u751f\u6210"), @CodeItem(value="CODEGEN_APP", text="\u4ee3\u7801\u751f\u6210\uff08\u524d\u7aef\u5e94\u7528\uff09", realtext="\u4ee3\u7801\u751f\u6210\uff08\u524d\u7aef\u5e94\u7528\uff09"), @CodeItem(value="PACKAGE", text="\u6253\u5305", realtext="\u6253\u5305"), @CodeItem(value="PACKAGE_APP", text="\u6253\u5305\uff08\u524d\u7aef\u5e94\u7528\uff09", realtext="\u6253\u5305\uff08\u524d\u7aef\u5e94\u7528\uff09"), @CodeItem(value="DEPLOY", text="\u90e8\u7f72", realtext="\u90e8\u7f72"), @CodeItem(value="DEPLOY_MSDEPFUNC", text="\u90e8\u7f72\uff08\u5fae\u670d\u52a1\u5e73\u53f0\u529f\u80fd\uff09", realtext="\u90e8\u7f72\uff08\u5fae\u670d\u52a1\u5e73\u53f0\u529f\u80fd\uff09"), @CodeItem(value="DEPLOY_MSDEPAPI", text="\u90e8\u7f72\uff08\u5fae\u670d\u52a1\u5e73\u53f0\u63a5\u53e3\uff09", realtext="\u90e8\u7f72\uff08\u5fae\u670d\u52a1\u5e73\u53f0\u63a5\u53e3\uff09"), @CodeItem(value="DEPLOY_MSDEPAPP", text="\u90e8\u7f72\uff08\u5fae\u670d\u52a1\u5e73\u53f0\u5e94\u7528\uff09", realtext="\u90e8\u7f72\uff08\u5fae\u670d\u52a1\u5e73\u53f0\u5e94\u7528\uff09"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49")})
public class PipelineStepTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String CODEGEN = "CODEGEN";
    public static final String CODEGEN_APP = "CODEGEN_APP";
    public static final String PACKAGE = "PACKAGE";
    public static final String PACKAGE_APP = "PACKAGE_APP";
    public static final String DEPLOY = "DEPLOY";
    public static final String DEPLOY_MSDEPFUNC = "DEPLOY_MSDEPFUNC";
    public static final String DEPLOY_MSDEPAPI = "DEPLOY_MSDEPAPI";
    public static final String DEPLOY_MSDEPAPP = "DEPLOY_MSDEPAPP";
    public static final String CUSTOM = "CUSTOM";

    public PipelineStepTypeCodeListModel() {
        this.initAnnotation(PipelineStepTypeCodeListModel.class);
        this.setUserData2("PipelineStepType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PipelineStepTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PipelineStepTypeCodeListModel");
    }
}

