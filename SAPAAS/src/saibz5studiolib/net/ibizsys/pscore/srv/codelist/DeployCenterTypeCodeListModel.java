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

@CodeList(id="dd14bea4a8e38ccf650dafa9842c0991", name="\u90e8\u7f72\u4e2d\u5fc3\u6301\u7eed\u96c6\u6210\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="JENKINS", text="Jenkins", realtext="Jenkins"), @CodeItem(value="GITLABRUNNER", text="GitLab Runner", realtext="GitLab Runner")})
public class DeployCenterTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String JENKINS = "JENKINS";
    public static final String GITLABRUNNER = "GITLABRUNNER";

    public DeployCenterTypeCodeListModel() {
        this.initAnnotation(DeployCenterTypeCodeListModel.class);
        this.setUserData2("DeployCenterType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DeployCenterTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DeployCenterTypeCodeListModel");
    }
}

