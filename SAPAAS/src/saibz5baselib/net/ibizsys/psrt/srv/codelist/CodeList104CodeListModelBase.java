/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="d42252a5abe2deac41dae5f12cd591fc", name="\u8f93\u5165\u8f85\u52a9_\u56fe\u8868\u53c2\u6570", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="CARETTEMPLGROUP_SRFREPORT_CHARTDATA", text="\u56fe\u8868\u6570\u636e\u5b9a\u4e49", realtext="\u56fe\u8868\u6570\u636e\u5b9a\u4e49"), @CodeItem(value="CARETTEMPLGROUP_SRFREPORT_CHART", text="\u56fe\u8868\u8868\u73b0\u5b9a\u4e49", realtext="\u56fe\u8868\u8868\u73b0\u5b9a\u4e49")})
public abstract class CodeList104CodeListModelBase
extends StaticCodeListModelBase {
    public static final String CARETTEMPLGROUP_SRFREPORT_CHARTDATA = "CARETTEMPLGROUP_SRFREPORT_CHARTDATA";
    public static final String CARETTEMPLGROUP_SRFREPORT_CHART = "CARETTEMPLGROUP_SRFREPORT_CHART";

    public CodeList104CodeListModelBase() {
        this.initAnnotation(CodeList104CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList104CodeListModel", this);
    }
}

