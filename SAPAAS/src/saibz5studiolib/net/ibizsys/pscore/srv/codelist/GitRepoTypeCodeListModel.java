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

@CodeList(id="f90a3d5c44f7ba4c2c2e5794badad5cf", name="GIT\u4ed3\u5e93", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="IBIZ", text="iBiz\u4ed3\u5e93", realtext="iBiz\u4ed3\u5e93"), @CodeItem(value="GITHUB", text="https://github.com/", realtext="https://github.com/"), @CodeItem(value="GITEE", text="https://gitee.com/", realtext="https://gitee.com/"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class GitRepoTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String IBIZ = "IBIZ";
    public static final String GITHUB = "GITHUB";
    public static final String GITEE = "GITEE";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public GitRepoTypeCodeListModel() {
        this.initAnnotation(GitRepoTypeCodeListModel.class);
        this.setUserData2("GitRepoType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.GitRepoTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.GitRepoTypeCodeListModel");
    }
}

