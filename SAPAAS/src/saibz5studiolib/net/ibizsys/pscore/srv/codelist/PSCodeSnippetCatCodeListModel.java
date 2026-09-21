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

@CodeList(id="f8450697c5616d3f5c8185b01d56be55", name="\u4e2d\u5fc3\u4ee3\u7801\u7247\u6bb5\u5206\u7c7b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="EDITOR", text="\u7f16\u8f91\u5668", realtext="\u7f16\u8f91\u5668"), @CodeItem(value="CONTROL", text="\u63a7\u4ef6", realtext="\u63a7\u4ef6"), @CodeItem(value="VIEW", text="\u89c6\u56fe", realtext="\u89c6\u56fe"), @CodeItem(value="DEMODEL", text="\u5b9e\u4f53\u6a21\u578b", realtext="\u5b9e\u4f53\u6a21\u578b"), @CodeItem(value="SYSMODEL", text="\u7cfb\u7edf\u6a21\u578b", realtext="\u7cfb\u7edf\u6a21\u578b"), @CodeItem(value="APPMODEL", text="\u5e94\u7528\u6a21\u578b", realtext="\u5e94\u7528\u6a21\u578b"), @CodeItem(value="USERCAT", text="\u7528\u6237\u5206\u7c7b", realtext="\u7528\u6237\u5206\u7c7b"), @CodeItem(value="USERCAT2", text="\u7528\u6237\u5206\u7c7b2", realtext="\u7528\u6237\u5206\u7c7b2")})
public class PSCodeSnippetCatCodeListModel
extends StaticCodeListModelBase {
    public static final String EDITOR = "EDITOR";
    public static final String CONTROL = "CONTROL";
    public static final String VIEW = "VIEW";
    public static final String DEMODEL = "DEMODEL";
    public static final String SYSMODEL = "SYSMODEL";
    public static final String APPMODEL = "APPMODEL";
    public static final String USERCAT = "USERCAT";
    public static final String USERCAT2 = "USERCAT2";

    public PSCodeSnippetCatCodeListModel() {
        this.initAnnotation(PSCodeSnippetCatCodeListModel.class);
        this.setUserData2("CodeSnippetCat");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PSCodeSnippetCatCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PSCodeSnippetCatCodeListModel");
    }
}

