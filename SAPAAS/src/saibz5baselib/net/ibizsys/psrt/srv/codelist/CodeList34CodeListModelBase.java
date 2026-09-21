/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="967d906284420dd9cb08f63f79846ab1", name="\u9884\u5b9a\u4e49\u5c5e\u6027\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="LOGICVALID", text="\u903b\u8f91\u6709\u6548\u6807\u8bc6", realtext="\u903b\u8f91\u6709\u6548\u6807\u8bc6"), @CodeItem(value="CREATEMAN", text="\u5efa\u7acb\u4eba", realtext="\u5efa\u7acb\u4eba"), @CodeItem(value="CREATEDATE", text="\u5efa\u7acb\u65f6\u95f4", realtext="\u5efa\u7acb\u65f6\u95f4"), @CodeItem(value="UPDATEMAN", text="\u66f4\u65b0\u4eba", realtext="\u66f4\u65b0\u4eba"), @CodeItem(value="UPDATEDATE", text="\u66f4\u65b0\u65f6\u95f4", realtext="\u66f4\u65b0\u65f6\u95f4"), @CodeItem(value="ORGUNITID", text="\u7ec4\u7ec7\u5355\u5143\u6807\u8bc6", realtext="\u7ec4\u7ec7\u5355\u5143\u6807\u8bc6"), @CodeItem(value="ORGUNITNAME", text="\u7ec4\u7ec7\u5355\u5143\u540d\u79f0", realtext="\u7ec4\u7ec7\u5355\u5143\u540d\u79f0")})
public abstract class CodeList34CodeListModelBase
extends StaticCodeListModelBase {
    public static final String LOGICVALID = "LOGICVALID";
    public static final String CREATEMAN = "CREATEMAN";
    public static final String CREATEDATE = "CREATEDATE";
    public static final String UPDATEMAN = "UPDATEMAN";
    public static final String UPDATEDATE = "UPDATEDATE";
    public static final String ORGUNITID = "ORGUNITID";
    public static final String ORGUNITNAME = "ORGUNITNAME";

    public CodeList34CodeListModelBase() {
        this.initAnnotation(CodeList34CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList34CodeListModel", this);
    }
}

