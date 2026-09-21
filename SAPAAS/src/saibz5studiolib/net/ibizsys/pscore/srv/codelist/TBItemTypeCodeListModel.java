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

@CodeList(id="bec752d28ad3badbcfe1eeed8a4f181a", name="\u5e73\u53f0\u5de5\u5177\u680f\u9879\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEUIACTION", text="\u754c\u9762\u884c\u4e3a\u9879", realtext="\u754c\u9762\u884c\u4e3a\u9879", userdata="\u7ed1\u5b9a\u754c\u9762\u884c\u4e3a\u7684\u9879\uff0c\u63d0\u4f9b\u547d\u4ee4\u529f\u80fd"), @CodeItem(value="SEPERATOR", text="\u5206\u9694\u9879", realtext="\u5206\u9694\u9879"), @CodeItem(value="ITEMS", text="\u5206\u7ec4\u9879", realtext="\u5206\u7ec4\u9879", userdata="\u5305\u542b\u5b50\u9879\u7684\u96c6\u5408\u9879"), @CodeItem(value="RAWITEM", text="\u76f4\u63a5\u9879", realtext="\u76f4\u63a5\u9879", userdata="\u8f93\u51fa\u76f4\u63a5\u5185\u5bb9\u7684\u9879")})
public class TBItemTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEUIACTION = "DEUIACTION";
    public static final String SEPERATOR = "SEPERATOR";
    public static final String ITEMS = "ITEMS";
    public static final String RAWITEM = "RAWITEM";

    public TBItemTypeCodeListModel() {
        this.initAnnotation(TBItemTypeCodeListModel.class);
        this.setUserData2("TBItemType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.TBItemTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.TBItemTypeCodeListModel");
    }
}

