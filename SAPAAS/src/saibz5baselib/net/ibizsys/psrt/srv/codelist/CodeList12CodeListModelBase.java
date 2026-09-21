/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="04ebb2b1d0136afcf85aea204da79ef0", name="\u62a5\u8868\u5206\u7c7b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="REPORTFOLDER_1", text="\u7ecf\u8425\u6027\u62a5\u8868", realtext="\u7ecf\u8425\u6027\u62a5\u8868"), @CodeItem(value="REPORTFOLDER_2", text="\u8d22\u52a1\u62a5\u8868", realtext="\u8d22\u52a1\u62a5\u8868")})
public abstract class CodeList12CodeListModelBase
extends StaticCodeListModelBase {
    public static final String REPORTFOLDER_1 = "REPORTFOLDER_1";
    public static final String REPORTFOLDER_2 = "REPORTFOLDER_2";

    public CodeList12CodeListModelBase() {
        this.initAnnotation(CodeList12CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList12CodeListModel", this);
    }
}

