/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="35036e9cf0dd69712323e8d5858f66c5", name="\u4efb\u52a1\u65f6\u523b\u7b56\u7565\u5929\u65f6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="EVERY", text="\u6bcf\u5c0f\u65f6", realtext="\u6bcf\u5c0f\u65f6"), @CodeItem(value="SOME", text="\u6307\u5b9a\u5c0f\u65f6", realtext="\u6307\u5b9a\u5c0f\u65f6")})
public abstract class TSDayTypeCodeListModelBase
extends StaticCodeListModelBase {
    public static final String EVERY = "EVERY";
    public static final String SOME = "SOME";

    public TSDayTypeCodeListModelBase() {
        this.initAnnotation(TSDayTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.TSDayTypeCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.TSDayTypeCodeListModel");
    }
}

