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

@CodeList(id="872c0dee59e2085dac9c45b1454f63cb", name="\u6d4b\u8bd5\u7528\u4f8b\u76ee\u6807\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEFVR", text="\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219", realtext="\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219", iconpath="default/pssystestcase/icon_targettype_defvr.png", iconpathx="default/pssystestcase/icon_targettype_defvr@{0}x.png"), @CodeItem(value="DEACTION", text="\u5b9e\u4f53\u884c\u4e3a", realtext="\u5b9e\u4f53\u884c\u4e3a", iconpath="default/pssystestcase/icon_targettype_deaction.png", iconpathx="default/pssystestcase/icon_targettype_deaction@{0}x.png"), @CodeItem(value="DESADETAIL", text="\u5b9e\u4f53\u63a5\u53e3\u65b9\u6cd5", realtext="\u5b9e\u4f53\u63a5\u53e3\u65b9\u6cd5", iconpath="testcasetargettype/icon_desadetail.png", iconpathx="testcasetargettype/icon_desadetail@{0}x.png"), @CodeItem(value="APPVIEW", text="\u5e94\u7528\u89c6\u56fe", realtext="\u5e94\u7528\u89c6\u56fe", iconpath="testcasetargettype/icon_appview.png", iconpathx="testcasetargettype/icon_appview@{0}x.png"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49")})
public class TestCaseTargetTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFVR = "DEFVR";
    public static final String DEACTION = "DEACTION";
    public static final String DESADETAIL = "DESADETAIL";
    public static final String APPVIEW = "APPVIEW";
    public static final String CUSTOM = "CUSTOM";

    public TestCaseTargetTypeCodeListModel() {
        this.initAnnotation(TestCaseTargetTypeCodeListModel.class);
        this.setUserData2("TestCaseTargetType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.TestCaseTargetTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.TestCaseTargetTypeCodeListModel");
    }
}

