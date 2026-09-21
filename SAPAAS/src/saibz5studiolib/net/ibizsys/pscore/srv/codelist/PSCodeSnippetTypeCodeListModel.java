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

@CodeList(id="7b6630bde2929fbe20ee7c384a0c5609", name="\u5e94\u7528\u4e2d\u5fc3\u4ee3\u7801\u76ee\u6807\u6a21\u677f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0", realtext="\u65e0"), @CodeItem(value="PSDATAENTITY", text="\u5b9e\u4f53", realtext="\u5b9e\u4f53"), @CodeItem(value="PSSYSTEM", text="\u7cfb\u7edf", realtext="\u7cfb\u7edf"), @CodeItem(value="PSSYSAPP", text="\u5e94\u7528", realtext="\u5e94\u7528"), @CodeItem(value="PSAPPVIEW", text="\u5e94\u7528\u89c6\u56fe", realtext="\u5e94\u7528\u89c6\u56fe"), @CodeItem(value="PSSYSTEMDBCFG", text="\u7cfb\u7edf\u6570\u636e\u5e93", realtext="\u7cfb\u7edf\u6570\u636e\u5e93"), @CodeItem(value="PSCODELIST", text="\u4ee3\u7801\u8868", realtext="\u4ee3\u7801\u8868"), @CodeItem(value="PSDEACTION", text="\u5b9e\u4f53\u884c\u4e3a", realtext="\u5b9e\u4f53\u884c\u4e3a")})
public class PSCodeSnippetTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String PSDATAENTITY = "PSDATAENTITY";
    public static final String PSSYSTEM = "PSSYSTEM";
    public static final String PSSYSAPP = "PSSYSAPP";
    public static final String PSAPPVIEW = "PSAPPVIEW";
    public static final String PSSYSTEMDBCFG = "PSSYSTEMDBCFG";
    public static final String PSCODELIST = "PSCODELIST";
    public static final String PSDEACTION = "PSDEACTION";

    public PSCodeSnippetTypeCodeListModel() {
        this.initAnnotation(PSCodeSnippetTypeCodeListModel.class);
        this.setUserData2("CodeSnippetTarget");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PSCodeSnippetTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PSCodeSnippetTypeCodeListModel");
    }
}

