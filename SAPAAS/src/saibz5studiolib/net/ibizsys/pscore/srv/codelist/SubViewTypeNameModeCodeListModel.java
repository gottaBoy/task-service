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

@CodeList(id="177a26ab455f4967ce2a5ba4bbfb8a3c", name="\u7cfb\u7edf\u89c6\u56fe\u6837\u5f0f\u540d\u79f0\u9644\u52a0\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="APPEND", text="\u540d\u79f0\u9644\u52a0", realtext="\u540d\u79f0\u9644\u52a0", userdata="\u89c6\u56fe\u6837\u5f0f\u6807\u8bb0\u5c06\u9644\u52a0\u53d1\u5e03\u7684\u89c6\u56fe\u540d\u79f0\u540e\u9762"), @CodeItem(value="REPLACE", text="\u540d\u79f0\u66ff\u6362", realtext="\u540d\u79f0\u66ff\u6362", userdata="\u89c6\u56fe\u6837\u5f0f\u6807\u8bb0\u5c06\u66ff\u6362\u53d1\u5e03\u7684\u89c6\u56fe\u540d\u79f0")})
public class SubViewTypeNameModeCodeListModel
extends StaticCodeListModelBase {
    public static final String APPEND = "APPEND";
    public static final String REPLACE = "REPLACE";

    public SubViewTypeNameModeCodeListModel() {
        this.initAnnotation(SubViewTypeNameModeCodeListModel.class);
        this.setUserData2("SubViewTypeNameMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SubViewTypeNameModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SubViewTypeNameModeCodeListModel");
    }
}

