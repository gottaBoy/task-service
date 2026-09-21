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

@CodeList(id="C6AC1EC1-748C-4E41-8319-DA6C7217C59F", name="\u5e94\u7528\u754c\u9762\u6a21\u5f0f\uff08\u6837\u5f0f2\uff0c3\uff0c4\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="STYLE2", text="\u6837\u5f0f2", realtext="\u6837\u5f0f2"), @CodeItem(value="STYLE3", text="\u6837\u5f0f3", realtext="\u6837\u5f0f3"), @CodeItem(value="STYLE4", text="\u6837\u5f0f4", realtext="\u6837\u5f0f4"), @CodeItem(value="STYLE5", text="\u6837\u5f0f5", realtext="\u6837\u5f0f5"), @CodeItem(value="STYLE6", text="\u6837\u5f0f6", realtext="\u6837\u5f0f6"), @CodeItem(value="STYLE7", text="\u6837\u5f0f7", realtext="\u6837\u5f0f7"), @CodeItem(value="STYLE8", text="\u6837\u5f0f8", realtext="\u6837\u5f0f8"), @CodeItem(value="STYLE9", text="\u6837\u5f0f9", realtext="\u6837\u5f0f9"), @CodeItem(value="STYLE10", text="\u6837\u5f0f10", realtext="\u6837\u5f0f10")})
public class AppUIStyle3CodeListModel
extends StaticCodeListModelBase {
    public static final String STYLE2 = "STYLE2";
    public static final String STYLE3 = "STYLE3";
    public static final String STYLE4 = "STYLE4";
    public static final String STYLE5 = "STYLE5";
    public static final String STYLE6 = "STYLE6";
    public static final String STYLE7 = "STYLE7";
    public static final String STYLE8 = "STYLE8";
    public static final String STYLE9 = "STYLE9";
    public static final String STYLE10 = "STYLE10";

    public AppUIStyle3CodeListModel() {
        this.initAnnotation(AppUIStyle3CodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppUIStyle3CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppUIStyle3CodeListModel");
    }
}

