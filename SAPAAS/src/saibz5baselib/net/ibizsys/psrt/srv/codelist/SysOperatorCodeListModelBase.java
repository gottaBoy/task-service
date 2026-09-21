/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;

@CodeList(id="14030ff9a11f791829108b42be032ab2", name="\u4e91\u7cfb\u7edf\u64cd\u4f5c\u8005", type="DYNAMIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={})
public abstract class SysOperatorCodeListModelBase
extends net.ibizsys.paas.sysmodel.SysOperatorCodeListModelBase {
    public SysOperatorCodeListModelBase() {
        this.initAnnotation(SysOperatorCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel");
    }
}

