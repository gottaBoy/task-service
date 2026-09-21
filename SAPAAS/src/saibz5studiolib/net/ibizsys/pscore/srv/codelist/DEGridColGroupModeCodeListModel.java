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

@CodeList(id="957d1d8ba9f989f47e58f2b29a208471", name="\u4e91\u5b9e\u4f53\u8868\u683c\u5217\u5206\u7ec4\u9879", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="GROUP1", text="\u5206\u7ec41", realtext="\u5206\u7ec41"), @CodeItem(value="GROUP2", text="\u5206\u7ec42", realtext="\u5206\u7ec42"), @CodeItem(value="GROUP3", text="\u5206\u7ec43", realtext="\u5206\u7ec43"), @CodeItem(value="GROUP4", text="\u5206\u7ec44", realtext="\u5206\u7ec44")})
public class DEGridColGroupModeCodeListModel
extends StaticCodeListModelBase {
    public static final String GROUP1 = "GROUP1";
    public static final String GROUP2 = "GROUP2";
    public static final String GROUP3 = "GROUP3";
    public static final String GROUP4 = "GROUP4";

    public DEGridColGroupModeCodeListModel() {
        this.initAnnotation(DEGridColGroupModeCodeListModel.class);
        this.setUserData2("GridColGroupMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEGridColGroupModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEGridColGroupModeCodeListModel");
    }
}

