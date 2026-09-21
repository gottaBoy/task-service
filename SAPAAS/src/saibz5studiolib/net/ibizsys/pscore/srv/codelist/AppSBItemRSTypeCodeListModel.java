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

@CodeList(id="8A185F62-51C2-4C93-AB0E-D30A1F832DAD", name="\u5e94\u7528\u6545\u4e8b\u677f\u6545\u4e8b\u9879\u5173\u7cfb\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="UIACTION", text="\u754c\u9762\u884c\u4e3a", realtext="\u754c\u9762\u884c\u4e3a", userdata="\u901a\u8fc7\u754c\u9762\u884c\u4e3a\u6253\u5f00\u76ee\u6807\u5e94\u7528\u89c6\u56fe"), @CodeItem(value="APPFUNC", text="\u5e94\u7528\u529f\u80fd", realtext="\u5e94\u7528\u529f\u80fd", userdata="\u901a\u8fc7\u5e94\u7528\u529f\u80fd\u6253\u5f00\u76ee\u6807\u5e94\u7528\u89c6\u56fe"), @CodeItem(value="APPVIEWREF", text="\u5e94\u7528\u89c6\u56fe\u5f15\u7528", realtext="\u5e94\u7528\u89c6\u56fe\u5f15\u7528", userdata="\u5e94\u7528\u89c6\u56fe\u5f15\u7528\u4f7f\u7528\u76ee\u6807\u89c6\u56fe"), @CodeItem(value="APPVIEWEMBED", text="\u5e94\u7528\u89c6\u56fe\u5d4c\u5165", realtext="\u5e94\u7528\u89c6\u56fe\u5d4c\u5165", userdata="\u5e94\u7528\u89c6\u56fe\u5d4c\u5165\u76ee\u6807\u89c6\u56fe")})
public class AppSBItemRSTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String UIACTION = "UIACTION";
    public static final String APPFUNC = "APPFUNC";
    public static final String APPVIEWREF = "APPVIEWREF";
    public static final String APPVIEWEMBED = "APPVIEWEMBED";

    public AppSBItemRSTypeCodeListModel() {
        this.initAnnotation(AppSBItemRSTypeCodeListModel.class);
        this.setUserData2("AppStoryBoardItemRSType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppSBItemRSTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppSBItemRSTypeCodeListModel");
    }
}

