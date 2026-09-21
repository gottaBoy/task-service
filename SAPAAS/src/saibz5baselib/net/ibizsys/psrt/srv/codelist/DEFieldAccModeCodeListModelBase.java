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

@CodeList(id="0fc12871fdb34f9175e0b596e64d3d65", name="\u5b9e\u4f53\u5c5e\u6027\u8bbf\u95ee\u63a7\u5236", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0", realtext="\u65e0"), @CodeItem(value="READ", text="\u8bfb\u53d6", realtext="\u8bfb\u53d6"), @CodeItem(value="UPDATE", text="\u66f4\u65b0", realtext="\u66f4\u65b0")})
public abstract class DEFieldAccModeCodeListModelBase
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String READ = "READ";
    public static final String UPDATE = "UPDATE";

    public DEFieldAccModeCodeListModelBase() {
        this.initAnnotation(DEFieldAccModeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.DEFieldAccModeCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.DEFieldAccModeCodeListModel");
    }
}

