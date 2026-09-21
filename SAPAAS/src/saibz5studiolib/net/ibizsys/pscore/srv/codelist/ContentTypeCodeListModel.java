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

@CodeList(id="1900A48F-1885-490E-9AC5-07A785ACA31D", name="\u76f4\u63a5\u5185\u5bb9\u9879\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="RAW", text="\u76f4\u63a5\u5185\u5bb9", realtext="\u76f4\u63a5\u5185\u5bb9", userdata="\u5185\u5bb9\u4e3a\u76f4\u63a5\u6587\u672c"), @CodeItem(value="HTML", text="Html\u5185\u5bb9", realtext="Html\u5185\u5bb9", userdata="\u5185\u5bb9\u4e3aHTML\u6587\u672c"), @CodeItem(value="IMAGE", text="\u56fe\u7247", realtext="\u56fe\u7247", userdata="\u5185\u5bb9\u4e3a\u56fe\u7247\u5bf9\u8c61"), @CodeItem(value="MARKDOWN", text="Markdown", realtext="Markdown"), @CodeItem(value="VIDEO", text="\u89c6\u9891", realtext="\u89c6\u9891"), @CodeItem(value="PLACEHOLDER", text="\u5360\u4f4d", realtext="\u5360\u4f4d"), @CodeItem(value="DIVIDER", text="\u5206\u5272\u7ebf", realtext="\u5206\u5272\u7ebf"), @CodeItem(value="INFO", text="\u5e38\u89c4\u63d0\u793a", realtext="\u5e38\u89c4\u63d0\u793a"), @CodeItem(value="WARNING", text="\u8b66\u544a\u63d0\u793a", realtext="\u8b66\u544a\u63d0\u793a"), @CodeItem(value="ERROR", text="\u9519\u8bef\u63d0\u793a", realtext="\u9519\u8bef\u63d0\u793a"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class ContentTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String RAW = "RAW";
    public static final String HTML = "HTML";
    public static final String IMAGE = "IMAGE";
    public static final String MARKDOWN = "MARKDOWN";
    public static final String VIDEO = "VIDEO";
    public static final String PLACEHOLDER = "PLACEHOLDER";
    public static final String DIVIDER = "DIVIDER";
    public static final String INFO = "INFO";
    public static final String WARNING = "WARNING";
    public static final String ERROR = "ERROR";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public ContentTypeCodeListModel() {
        this.initAnnotation(ContentTypeCodeListModel.class);
        this.setUserData("IGNOREMODELDSL2");
        this.setUserData2("RawItemContentType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ContentTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ContentTypeCodeListModel");
    }
}

