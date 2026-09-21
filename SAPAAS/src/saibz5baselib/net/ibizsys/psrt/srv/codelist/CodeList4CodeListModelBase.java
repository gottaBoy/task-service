/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="156dff28186d169365fb4a646c58607a", name="\u529f\u80fd\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="DEDATAGRID", text="\u9ed8\u8ba4\u5b9e\u4f53\u8868\u683c\u89c6\u56fe", realtext="\u9ed8\u8ba4\u5b9e\u4f53\u8868\u683c\u89c6\u56fe"), @CodeItem(value="PAGELINK", text="\u9875\u9762\u94fe\u63a5", realtext="\u9875\u9762\u94fe\u63a5"), @CodeItem(value="JSCODE", text="\u7eafJS\u4ee3\u7801", realtext="\u7eafJS\u4ee3\u7801"), @CodeItem(value="DEGRIDVIEW", text="\u6307\u5b9a\u5b9e\u4f53\u8868\u683c\u89c6\u56fe", realtext="\u6307\u5b9a\u5b9e\u4f53\u8868\u683c\u89c6\u56fe"), @CodeItem(value="PAGE", text="\u5185\u7f6e\u9875\u9762", realtext="\u5185\u7f6e\u9875\u9762")})
public abstract class CodeList4CodeListModelBase
extends StaticCodeListModelBase {
    public static final String DEDATAGRID = "DEDATAGRID";
    public static final String PAGELINK = "PAGELINK";
    public static final String JSCODE = "JSCODE";
    public static final String DEGRIDVIEW = "DEGRIDVIEW";
    public static final String PAGE = "PAGE";

    public CodeList4CodeListModelBase() {
        this.initAnnotation(CodeList4CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList4CodeListModel", this);
    }
}

