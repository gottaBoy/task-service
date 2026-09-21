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

@CodeList(id="d7625c638dec8186c1ba6cedcd637865", name="\u5927\u6570\u636e\u8868\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u4e3b\u6570\u636e\u8868", realtext="\u4e3b\u6570\u636e\u8868"), @CodeItem(value="2", text="\u4ece\u6570\u636e\u8868", realtext="\u4ece\u6570\u636e\u8868"), @CodeItem(value="3", text="\u5173\u7cfb\u6570\u636e\u8868", realtext="\u5173\u7cfb\u6570\u636e\u8868"), @CodeItem(value="9", text="\u7ee7\u627f\u4ece\u6570\u636e\u8868", realtext="\u7ee7\u627f\u4ece\u6570\u636e\u8868")})
public class BDTableTypeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer MAJOR = 1;
    public static final int INT_MAJOR = 1;
    public static final Integer MINOR = 2;
    public static final int INT_MINOR = 2;
    public static final Integer RELATED = 3;
    public static final int INT_RELATED = 3;
    public static final Integer INHERITMINOR = 9;
    public static final int INT_INHERITMINOR = 9;

    public BDTableTypeCodeListModel() {
        this.initAnnotation(BDTableTypeCodeListModel.class);
        this.setUserData2("BDTableType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.BDTableTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.BDTableTypeCodeListModel");
    }
}

