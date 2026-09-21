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

@CodeList(id="96D51FF6-4935-4459-A54E-BE1232C79331", name="\u5e94\u7528\u83dc\u5355\u9879\u7c7b\u578b\uff08\u9759\u6001\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SEPERATOR", text="\u5206\u9694\u9879", realtext="\u5206\u9694\u9879"), @CodeItem(value="USERITEM", text="\u7528\u6237\u81ea\u5b9a\u4e49\u9879", realtext="\u7528\u6237\u81ea\u5b9a\u4e49\u9879"), @CodeItem(value="APPMENUREF", text="\u83dc\u5355\u5f15\u7528", realtext="\u83dc\u5355\u5f15\u7528"), @CodeItem(value="MENUITEM", text="\u83dc\u5355\u9879", realtext="\u83dc\u5355\u9879"), @CodeItem(value="RAWITEM", text="\u76f4\u63a5\u5185\u5bb9\u9879", realtext="\u76f4\u63a5\u5185\u5bb9\u9879")})
public class AppMenuItemType2CodeListModel
extends StaticCodeListModelBase {
    public static final String SEPERATOR = "SEPERATOR";
    public static final String USERITEM = "USERITEM";
    public static final String APPMENUREF = "APPMENUREF";
    public static final String MENUITEM = "MENUITEM";
    public static final String RAWITEM = "RAWITEM";

    public AppMenuItemType2CodeListModel() {
        this.initAnnotation(AppMenuItemType2CodeListModel.class);
        this.setUserData2("AppMenuItemType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppMenuItemType2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppMenuItemType2CodeListModel");
    }
}

