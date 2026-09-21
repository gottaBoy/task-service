/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="d423ad45d077876d562a796f3056c030", name="\u5e73\u53f0\u5185\u7f6e\u5904\u7406\u7ec4\u4ef6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="CODELISTFILLER", text="\u4ee3\u7801\u8868\u586b\u5145\u5668", realtext="\u4ee3\u7801\u8868\u586b\u5145\u5668"), @CodeItem(value="WFPROCESS", text="\u5de5\u4f5c\u6d41\u5d4c\u5165\u5904\u7406", realtext="\u5de5\u4f5c\u6d41\u5d4c\u5165\u5904\u7406"), @CodeItem(value="DGACTIONHELPER", text="\u8868\u683c\u540e\u53f0\u5904\u7406\u5bf9\u8c61", realtext="\u8868\u683c\u540e\u53f0\u5904\u7406\u5bf9\u8c61"), @CodeItem(value="FORMACTIONHELPER", text="\u8868\u5355\u540e\u53f0\u5904\u7406\u7c7b", realtext="\u8868\u5355\u540e\u53f0\u5904\u7406\u7c7b"), @CodeItem(value="PAGE", text="\u9875\u9762\u5bf9\u8c61", realtext="\u9875\u9762\u5bf9\u8c61")})
public abstract class CodeList118CodeListModelBase
extends StaticCodeListModelBase {
    public static final String CODELISTFILLER = "CODELISTFILLER";
    public static final String WFPROCESS = "WFPROCESS";
    public static final String DGACTIONHELPER = "DGACTIONHELPER";
    public static final String FORMACTIONHELPER = "FORMACTIONHELPER";
    public static final String PAGE = "PAGE";

    public CodeList118CodeListModelBase() {
        this.initAnnotation(CodeList118CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList118CodeListModel", this);
    }
}

