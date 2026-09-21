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

@CodeList(id="4ae9312b2206487cc70a7cd194b6ada8", name="\u7cfb\u7edf\u8fd0\u884c\u4f1a\u8bdd\u6253\u5305\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEBUG", text="\u5f00\u53d1\u6a21\u5f0f", realtext="\u5f00\u53d1\u6a21\u5f0f"), @CodeItem(value="RELEASE", text="\u751f\u4ea7\u6a21\u5f0f", realtext="\u751f\u4ea7\u6a21\u5f0f")})
public class SysRunPackModeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEBUG = "DEBUG";
    public static final String RELEASE = "RELEASE";

    public SysRunPackModeCodeListModel() {
        this.initAnnotation(SysRunPackModeCodeListModel.class);
        this.setUserData2("SysRunPackMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysRunPackModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysRunPackModeCodeListModel");
    }
}

