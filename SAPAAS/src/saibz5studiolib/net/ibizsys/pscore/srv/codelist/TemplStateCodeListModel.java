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

@CodeList(id="b81a364e7c596bf2677457a2d6a10a38", name="\u5e73\u53f0\u6a21\u677f\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="20", text="\u521d\u59cb\u5316\u4e2d", realtext="\u521d\u59cb\u5316\u4e2d"), @CodeItem(value="25", text="\u672a\u5ba1\u6838", realtext="\u672a\u5ba1\u6838"), @CodeItem(value="27", text="\u5ba1\u6838\u5931\u8d25", realtext="\u5ba1\u6838\u5931\u8d25"), @CodeItem(value="30", text="\u6b63\u5e38", realtext="\u6b63\u5e38"), @CodeItem(value="40", text="\u9519\u8bef", realtext="\u9519\u8bef")})
public class TemplStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer INIT = 20;
    public static final int INT_INIT = 20;
    public static final Integer NOTAPPROVED = 25;
    public static final int INT_NOTAPPROVED = 25;
    public static final Integer APPROVEFAILED = 27;
    public static final int INT_APPROVEFAILED = 27;
    public static final Integer OK = 30;
    public static final int INT_OK = 30;
    public static final Integer ERROR = 40;
    public static final int INT_ERROR = 40;

    public TemplStateCodeListModel() {
        this.initAnnotation(TemplStateCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.TemplStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.TemplStateCodeListModel");
    }
}

