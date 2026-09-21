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

@CodeList(id="9805ad6e08285ce6d310841fa5bf5a82", name="\u7cfb\u7edf\u6a21\u578b\u4ed3\u5e93\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="IBIZLAB", text="iBizLab", realtext="iBizLab"), @CodeItem(value="GITEE", text="gitee", realtext="gitee"), @CodeItem(value="CODING", text="coding", realtext="coding"), @CodeItem(value="GITHUB", text="github", realtext="github"), @CodeItem(value="GITLAB", text="gitlab", realtext="gitlab"), @CodeItem(value="OTHER", text="\u5176\u5b83", realtext="\u5176\u5b83")})
public class SysModelRepoTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String IBIZLAB = "IBIZLAB";
    public static final String GITEE = "GITEE";
    public static final String CODING = "CODING";
    public static final String GITHUB = "GITHUB";
    public static final String GITLAB = "GITLAB";
    public static final String OTHER = "OTHER";

    public SysModelRepoTypeCodeListModel() {
        this.initAnnotation(SysModelRepoTypeCodeListModel.class);
        this.setUserData2("SysModelRepoType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysModelRepoTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysModelRepoTypeCodeListModel");
    }
}

