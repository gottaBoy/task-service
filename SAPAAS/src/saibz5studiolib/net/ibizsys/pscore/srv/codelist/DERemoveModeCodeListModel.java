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

@CodeList(id="61dabbd35c8570a1a935ed15b1c8f74d", name="\u6a21\u578b\u5220\u9664\u6807\u5fd7", type="STATIC", userscope=false, emptytext="\uff08\u9650\u5236\u5220\u9664\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u9650\u5236\u5220\u9664", realtext="\u9650\u5236\u5220\u9664"), @CodeItem(value="1", text="\u5141\u8bb8\u5220\u9664\uff08\u5220\u9664\u81ea\u8eab\u76f8\u5173\u6570\u636e\uff09", realtext="\u5141\u8bb8\u5220\u9664\uff08\u5220\u9664\u81ea\u8eab\u76f8\u5173\u6570\u636e\uff09")})
public class DERemoveModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer REJECT = 0;
    public static final int INT_REJECT = 0;
    public static final Integer ALLOW = 1;
    public static final int INT_ALLOW = 1;

    public DERemoveModeCodeListModel() {
        this.initAnnotation(DERemoveModeCodeListModel.class);
        this.setUserData2("ModelRemoveMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DERemoveModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DERemoveModeCodeListModel");
    }
}

