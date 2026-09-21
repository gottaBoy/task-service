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

@CodeList(id="e657266734788974551d0afca283352a", name="\u5b50\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u6765\u6e90", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0", realtext="\u65e0"), @CodeItem(value="SYSAPI", text="\u5f53\u524d\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3", realtext="\u5f53\u524d\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3", userdata="\u5916\u90e8\u63a5\u53e3\u6765\u81ea\u5f53\u524d\u7cfb\u7edf\u7684\u670d\u52a1\u63a5\u53e3"), @CodeItem(value="DEVSYSAPI", text="\u5916\u90e8\u5f00\u53d1\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3", realtext="\u5916\u90e8\u5f00\u53d1\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3", userdata="\u5916\u90e8\u63a5\u53e3\u6765\u81ea\u5f53\u524d\u5f00\u53d1\u65b9\u6848\u7684\u5f00\u53d1\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3"), @CodeItem(value="PREDEFINED", text="\u9884\u5b9a\u4e49\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3", realtext="\u9884\u5b9a\u4e49\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3", userdata="\u5916\u90e8\u63a5\u53e3\u6765\u81ea\u5e73\u53f0\u9884\u7f6e\u7684\u670d\u52a1\u63a5\u53e3")})
public class SubSysAPISourceCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String SYSAPI = "SYSAPI";
    public static final String DEVSYSAPI = "DEVSYSAPI";
    public static final String PREDEFINED = "PREDEFINED";

    public SubSysAPISourceCodeListModel() {
        this.initAnnotation(SubSysAPISourceCodeListModel.class);
        this.setUserData2("SubSysAPISource");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SubSysAPISourceCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SubSysAPISourceCodeListModel");
    }
}

