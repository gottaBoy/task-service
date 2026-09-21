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

@CodeList(id="8092e07f8282404dd9ad5dbe8fcdec5c", name="\u6d4b\u8bd5\u7528\u4f8b\u7ea7\u522b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="P1", text="P1", realtext="P1"), @CodeItem(value="P2", text="P2", realtext="P2"), @CodeItem(value="P3", text="P3", realtext="P3"), @CodeItem(value="P4", text="P4", realtext="P4"), @CodeItem(value="P5", text="P5", realtext="P5")})
public class TestCaseLevelCodeListModel
extends StaticCodeListModelBase {
    public static final String P1 = "P1";
    public static final String P2 = "P2";
    public static final String P3 = "P3";
    public static final String P4 = "P4";
    public static final String P5 = "P5";

    public TestCaseLevelCodeListModel() {
        this.initAnnotation(TestCaseLevelCodeListModel.class);
        this.setUserData2("TestCaseLevel");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.TestCaseLevelCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.TestCaseLevelCodeListModel");
    }
}

