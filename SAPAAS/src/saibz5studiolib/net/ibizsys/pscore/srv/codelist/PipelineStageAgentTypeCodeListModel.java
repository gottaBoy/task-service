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

@CodeList(id="541C3410-A32A-4F74-A01F-BDB156DDF25B", name="Pipeline\u9636\u6bb5\u4ee3\u7406\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u672a\u6307\u5b9a", realtext="\u672a\u6307\u5b9a"), @CodeItem(value="TAGS", text="\u6307\u5b9a\u4ee3\u7406\u6807\u8bb0", realtext="\u6307\u5b9a\u4ee3\u7406\u6807\u8bb0"), @CodeItem(value="IMAGE", text="\u6307\u5b9a\u4ee3\u7406\u955c\u50cf", realtext="\u6307\u5b9a\u4ee3\u7406\u955c\u50cf"), @CodeItem(value="REGISTRYITEM", text="\u6307\u5b9a\u4ee3\u7406\u955c\u50cf\uff08\u9884\u7f6e\uff09", realtext="\u6307\u5b9a\u4ee3\u7406\u955c\u50cf\uff08\u9884\u7f6e\uff09")})
public class PipelineStageAgentTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String TAGS = "TAGS";
    public static final String IMAGE = "IMAGE";
    public static final String REGISTRYITEM = "REGISTRYITEM";

    public PipelineStageAgentTypeCodeListModel() {
        this.initAnnotation(PipelineStageAgentTypeCodeListModel.class);
        this.setUserData2("PipelineStageAgentType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PipelineStageAgentTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PipelineStageAgentTypeCodeListModel");
    }
}

