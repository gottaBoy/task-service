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

@CodeList(id="1be04a75feff955cdc233c2237b86c2e", name="\u7cfb\u7edf\u6a21\u578b\u52a0\u8f7d\u7ea7\u522b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u672a\u52a0\u8f7d\uff08NONE\uff09", realtext="\u672a\u52a0\u8f7d\uff08NONE\uff09"), @CodeItem(value="10", text="\u90e8\u4ef6\u9884\u89c8\uff08PREVIEW\uff09", realtext="\u90e8\u4ef6\u9884\u89c8\uff08PREVIEW\uff09"), @CodeItem(value="30", text="\u5373\u65f6\u9884\u89c8\uff08JIT\uff09", realtext="\u5373\u65f6\u9884\u89c8\uff08JIT\uff09"), @CodeItem(value="50", text="\u4e00\u952e\u542f\u52a8\uff08STARTUP\uff09", realtext="\u4e00\u952e\u542f\u52a8\uff08STARTUP\uff09"), @CodeItem(value="60", text="\u5168\u90e8\u4ee3\u7801\uff08CODE\uff09", realtext="\u5168\u90e8\u4ee3\u7801\uff08CODE\uff09"), @CodeItem(value="70", text="\u6a21\u578b\u5dee\u5f02\uff08DIFF\uff09", realtext="\u6a21\u578b\u5dee\u5f02\uff08DIFF\uff09"), @CodeItem(value="80", text="\u53d1\u5e03\u6587\u6863\uff08DOC\uff09", realtext="\u53d1\u5e03\u6587\u6863\uff08DOC\uff09"), @CodeItem(value="99", text="\u5168\u90e8\uff08ALL\uff09", realtext="\u5168\u90e8\uff08ALL\uff09")})
public class SystemModelLevelCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer PREVIEW = 10;
    public static final int INT_PREVIEW = 10;
    public static final Integer JIT = 30;
    public static final int INT_JIT = 30;
    public static final Integer STARTUP = 50;
    public static final int INT_STARTUP = 50;
    public static final Integer CODE = 60;
    public static final int INT_CODE = 60;
    public static final Integer DIFF = 70;
    public static final int INT_DIFF = 70;
    public static final Integer DOC = 80;
    public static final int INT_DOC = 80;
    public static final Integer ALL = 99;
    public static final int INT_ALL = 99;

    public SystemModelLevelCodeListModel() {
        this.initAnnotation(SystemModelLevelCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SystemModelLevelCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SystemModelLevelCodeListModel");
    }
}

