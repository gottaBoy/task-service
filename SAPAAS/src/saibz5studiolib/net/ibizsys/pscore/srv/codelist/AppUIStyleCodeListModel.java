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

@CodeList(id="bccea5903caadc01d0a460592f219d47", name="\u5e94\u7528\u754c\u9762\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEFAULT", text="\u9ed8\u8ba4", realtext="\u9ed8\u8ba4"), @CodeItem(value="STYLE2", text="\u6837\u5f0f2", realtext="\u6837\u5f0f2"), @CodeItem(value="STYLE3", text="\u6837\u5f0f3", realtext="\u6837\u5f0f3"), @CodeItem(value="STYLE4", text="\u6837\u5f0f4", realtext="\u6837\u5f0f4"), @CodeItem(value="STYLE5", text="\u6837\u5f0f5", realtext="\u6837\u5f0f5"), @CodeItem(value="STYLE6", text="\u6837\u5f0f6", realtext="\u6837\u5f0f6"), @CodeItem(value="STYLE7", text="\u6837\u5f0f7", realtext="\u6837\u5f0f7"), @CodeItem(value="STYLE8", text="\u6837\u5f0f8", realtext="\u6837\u5f0f8"), @CodeItem(value="STYLE9", text="\u6837\u5f0f9", realtext="\u6837\u5f0f9"), @CodeItem(value="STYLE10", text="\u6837\u5f0f10", realtext="\u6837\u5f0f10")})
public class AppUIStyleCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFAULT = "DEFAULT";
    public static final String STYLE2 = "STYLE2";
    public static final String STYLE3 = "STYLE3";
    public static final String STYLE4 = "STYLE4";
    public static final String STYLE5 = "STYLE5";
    public static final String STYLE6 = "STYLE6";
    public static final String STYLE7 = "STYLE7";
    public static final String STYLE8 = "STYLE8";
    public static final String STYLE9 = "STYLE9";
    public static final String STYLE10 = "STYLE10";

    public AppUIStyleCodeListModel() {
        this.initAnnotation(AppUIStyleCodeListModel.class);
        this.setUserData2("AppUIStyle");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppUIStyleCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppUIStyleCodeListModel");
    }
}

