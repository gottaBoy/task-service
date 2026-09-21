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

@CodeList(id="1b748a0f68805f9d3a28ba163f4697ff", name="\u5fae\u4fe1\u4f01\u4e1a\u5e94\u7528\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="H5", text="H5\u4e3b\u9875\u578b", realtext="H5\u4e3b\u9875\u578b"), @CodeItem(value="MSG", text="\u6d88\u606f\u54cd\u5e94\u578b", realtext="\u6d88\u606f\u54cd\u5e94\u578b")})
public abstract class WXEntAppTypeCodeListModelBase
extends StaticCodeListModelBase {
    public static final String H5 = "H5";
    public static final String MSG = "MSG";

    public WXEntAppTypeCodeListModelBase() {
        this.initAnnotation(WXEntAppTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.WXEntAppTypeCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.WXEntAppTypeCodeListModel");
    }
}

