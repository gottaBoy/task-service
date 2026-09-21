/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="bd51ee96a28f95295901e9ba2c42091f", name="\u5b9e\u4f53\u6570\u636e\u5904\u7406_\u6570\u636e\u5bf9\u8c61\u64cd\u4f5c", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="CREATENEW", text="\u65b0\u5efa\u6570\u636e\u5bf9\u8c61", realtext="\u65b0\u5efa\u6570\u636e\u5bf9\u8c61"), @CodeItem(value="CREATEFROM", text="\u62f7\u8d1d\u65b0\u5efa\u6570\u636e\u5bf9\u8c61", realtext="\u62f7\u8d1d\u65b0\u5efa\u6570\u636e\u5bf9\u8c61"), @CodeItem(value="COPY", text="\u62f7\u8d1d\u6570\u636e\u5bf9\u8c61", realtext="\u62f7\u8d1d\u6570\u636e\u5bf9\u8c61"), @CodeItem(value="COPYRESET", text="\u62f7\u8d1d\u6570\u636e\u5bf9\u8c61(\u91cd\u7f6e)", realtext="\u62f7\u8d1d\u6570\u636e\u5bf9\u8c61(\u91cd\u7f6e)")})
public abstract class CodeList107CodeListModelBase
extends StaticCodeListModelBase {
    public static final String CREATENEW = "CREATENEW";
    public static final String CREATEFROM = "CREATEFROM";
    public static final String COPY = "COPY";
    public static final String COPYRESET = "COPYRESET";

    public CodeList107CodeListModelBase() {
        this.initAnnotation(CodeList107CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList107CodeListModel", this);
    }
}

