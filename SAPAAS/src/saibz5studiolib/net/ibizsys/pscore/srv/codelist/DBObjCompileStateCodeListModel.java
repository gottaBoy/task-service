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

@CodeList(id="85451790956748f31268a6bb2a91bcdc", name="\u7f16\u8bd1\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="99", text="\u672a\u7f16\u8bd1", realtext="\u672a\u7f16\u8bd1"), @CodeItem(value="1", text="\u7f16\u8bd1\u5931\u8d25", realtext="\u7f16\u8bd1\u5931\u8d25"), @CodeItem(value="0", text="\u7f16\u8bd1\u6210\u529f", realtext="\u7f16\u8bd1\u6210\u529f")})
public class DBObjCompileStateCodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM_99 = "99";
    public static final String ITEM_1 = "1";
    public static final String ITEM_0 = "0";

    public DBObjCompileStateCodeListModel() {
        this.initAnnotation(DBObjCompileStateCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DBObjCompileStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DBObjCompileStateCodeListModel");
    }
}

