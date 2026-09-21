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

@CodeList(id="a5e83c9500a2daceb530ea7972fc62a3", name="\u5173\u7cfb\u754c\u9762\u7ec4\u6210\u5458\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DRITEM", text="\u5173\u7cfb\u754c\u9762", realtext="\u5173\u7cfb\u754c\u9762", userdata="\u5f53\u524d\u5b9e\u4f53\u7684\u5173\u7cfb\u754c\u9762"), @CodeItem(value="PDTVIEW", text="\u9884\u7f6e\u89c6\u56fe", realtext="\u9884\u7f6e\u89c6\u56fe", userdata="\u5f53\u524d\u7cfb\u7edf\u7684\u9884\u5b9a\u4e49\u89c6\u56fe")})
public class DEDRDetailTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DRITEM = "DRITEM";
    public static final String PDTVIEW = "PDTVIEW";

    public DEDRDetailTypeCodeListModel() {
        this.initAnnotation(DEDRDetailTypeCodeListModel.class);
        this.setUserData2("DEDRDetailType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDRDetailTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDRDetailTypeCodeListModel");
    }
}

