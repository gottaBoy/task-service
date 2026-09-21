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

@CodeList(id="08319352922be3cb50e616c0b1945288", name="\u8d44\u6e90\u9884\u7ea6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="MAINTAIN", text="\u8fd0\u7ef4", realtext="\u8fd0\u7ef4"), @CodeItem(value="DCRES", text="\u5e94\u7528\u4e2d\u5fc3\u8d44\u6e90\u5f15\u7528", realtext="\u5e94\u7528\u4e2d\u5fc3\u8d44\u6e90\u5f15\u7528")})
public class BookingTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String MAINTAIN = "MAINTAIN";
    public static final String DCRES = "DCRES";

    public BookingTypeCodeListModel() {
        this.initAnnotation(BookingTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.BookingTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.BookingTypeCodeListModel");
    }
}

