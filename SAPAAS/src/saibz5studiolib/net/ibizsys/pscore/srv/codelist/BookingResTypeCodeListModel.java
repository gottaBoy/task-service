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

@CodeList(id="339ca10d1ab870d84cf9b14839f0d4c0", name="\u8d44\u6e90\u65f6\u95f4\u8d44\u6e90\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="AS_TOMCAT7_MYSQL5", text="\u5e94\u7528\u5bb9\u5668\uff08Tomcat7+MySQL5\uff09", realtext="\u5e94\u7528\u5bb9\u5668\uff08Tomcat7+MySQL5\uff09"), @CodeItem(value="DS", text="\u5f00\u53d1\u4e3b\u673a", realtext="\u5f00\u53d1\u4e3b\u673a")})
public class BookingResTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String AS_TOMCAT7_MYSQL5 = "AS_TOMCAT7_MYSQL5";
    public static final String DS = "DS";

    public BookingResTypeCodeListModel() {
        this.initAnnotation(BookingResTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.BookingResTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.BookingResTypeCodeListModel");
    }
}

