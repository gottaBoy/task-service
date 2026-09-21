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

@CodeList(id="5984a3d7b73883f77ab5f85456f40523", name="\u9884\u7ea6\u8d44\u6e90\u5927\u7c7b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="APPSERVER", text="\u5e94\u7528\u5bb9\u5668", realtext="\u5e94\u7528\u5bb9\u5668"), @CodeItem(value="DEVSERVER", text="\u5f00\u53d1\u684c\u9762", realtext="\u5f00\u53d1\u684c\u9762")})
public class BookingResCatCodeListModel
extends StaticCodeListModelBase {
    public static final String APPSERVER = "APPSERVER";
    public static final String DEVSERVER = "DEVSERVER";

    public BookingResCatCodeListModel() {
        this.initAnnotation(BookingResCatCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.BookingResCatCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.BookingResCatCodeListModel");
    }
}

