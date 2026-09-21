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

@CodeList(id="1CD4AD6A-0514-4163-A22C-B9A3EC68B15C", name="\u5b9e\u4f53\u8868\u683c\u5217\u6837\u5f0f\uff08\u754c\u9762\u884c\u4e3a\u5217\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="EXPAND", text="\u5c55\u5f00\u6a21\u5f0f", realtext="\u5c55\u5f00\u6a21\u5f0f"), @CodeItem(value="MENU", text="\u83dc\u5355\u6a21\u5f0f", realtext="\u83dc\u5355\u6a21\u5f0f"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class DEGridColStype2CodeListModel
extends StaticCodeListModelBase {
    public static final String EXPAND = "EXPAND";
    public static final String MENU = "MENU";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public DEGridColStype2CodeListModel() {
        this.initAnnotation(DEGridColStype2CodeListModel.class);
        this.setUserData2("GridColStype");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEGridColStype2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEGridColStype2CodeListModel");
    }
}

