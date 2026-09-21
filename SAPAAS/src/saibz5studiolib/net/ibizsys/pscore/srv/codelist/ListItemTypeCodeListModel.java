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

@CodeList(id="9cb4a0b815452fb67f3c0bc2a290bf54", name="\u4e91\u5e73\u53f0\u5217\u8868\u9879\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TEXTITEM", text="\u663e\u793a\u5185\u5bb9\u9879", realtext="\u663e\u793a\u5185\u5bb9\u9879", userdata="\u5217\u8868\u4e2d\u7684\u5185\u5bb9\u5217"), @CodeItem(value="ACTIONITEM", text="\u64cd\u4f5c\u9879", realtext="\u64cd\u4f5c\u9879", userdata="\u5217\u8868\u4e2d\u7684\u64cd\u4f5c\u5217"), @CodeItem(value="DATAITEM", text="\u6570\u636e\u9879", realtext="\u6570\u636e\u9879", userdata="\u4ec5\u63d0\u4f9b\u6570\u636e\uff0c\u65e0\u663e\u793a")})
public class ListItemTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String TEXTITEM = "TEXTITEM";
    public static final String ACTIONITEM = "ACTIONITEM";
    public static final String DATAITEM = "DATAITEM";

    public ListItemTypeCodeListModel() {
        this.initAnnotation(ListItemTypeCodeListModel.class);
        this.setUserData2("ListItemType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ListItemTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ListItemTypeCodeListModel");
    }
}

