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

@CodeList(id="BF8B48F1-2216-40E1-BE6E-E3079A8165F7", name="\u5b9e\u4f53\u6a21\u5f0f\u5220\u9664\u6807\u5fd7\uff08\u5b8c\u6574\uff09", type="STATIC", userscope=false, emptytext="\u9650\u5236\u5220\u9664")
@CodeItems(value={@CodeItem(value="0", text="\u9650\u5236\u5220\u9664", realtext="\u9650\u5236\u5220\u9664"), @CodeItem(value="1", text="\u5141\u8bb8\u5220\u9664\uff08\u5220\u9664\u81ea\u8eab\u76f8\u5173\u6570\u636e\uff09", realtext="\u5141\u8bb8\u5220\u9664\uff08\u5220\u9664\u81ea\u8eab\u76f8\u5173\u6570\u636e\uff09"), @CodeItem(value="2", text="\u5141\u8bb8\u5220\u9664\uff08\u5220\u9664\u81ea\u8eab\u53ca\u5916\u90e8\u76f8\u5173\u6570\u636e\uff09", realtext="\u5141\u8bb8\u5220\u9664\uff08\u5220\u9664\u81ea\u8eab\u53ca\u5916\u90e8\u76f8\u5173\u6570\u636e\uff09")})
public class DERemoveMode2CodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM_0 = "0";
    public static final String ITEM_1 = "1";
    public static final String ITEM_2 = "2";

    public DERemoveMode2CodeListModel() {
        this.initAnnotation(DERemoveMode2CodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DERemoveMode2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DERemoveMode2CodeListModel");
    }
}

