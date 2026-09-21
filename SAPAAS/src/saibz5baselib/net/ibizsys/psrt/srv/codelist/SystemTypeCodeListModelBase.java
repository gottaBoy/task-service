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

@CodeList(id="ef52a3b19ff3d2a3940d2c7b76bd5318", name="\u7cfb\u7edf\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="WEB", text="WEB\u7cfb\u7edf", realtext="WEB\u7cfb\u7edf"), @CodeItem(value="CS", text="C/S\u7cfb\u7edf", realtext="C/S\u7cfb\u7edf")})
public abstract class SystemTypeCodeListModelBase
extends StaticCodeListModelBase {
    public static final String WEB = "WEB";
    public static final String CS = "CS";

    public SystemTypeCodeListModelBase() {
        this.initAnnotation(SystemTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.SystemTypeCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.SystemTypeCodeListModel");
    }
}

