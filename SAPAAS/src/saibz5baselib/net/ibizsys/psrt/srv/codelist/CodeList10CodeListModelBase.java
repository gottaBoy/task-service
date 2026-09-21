/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="163d7a399f7cd62f8854e18bf933d926", name="\u5b9e\u4f53\u6570\u636e\u64cd\u4f5c", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="INSERT", text="\u63d2\u5165", realtext="\u63d2\u5165"), @CodeItem(value="UPDATE", text="\u66f4\u65b0", realtext="\u66f4\u65b0"), @CodeItem(value="DELETE", text="\u5220\u9664", realtext="\u5220\u9664"), @CodeItem(value="SELECT", text="\u7b80\u5355\u67e5\u8be2", realtext="\u7b80\u5355\u67e5\u8be2"), @CodeItem(value="CUSTOMCALL", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49"), @CodeItem(value="CUSTOMPROCCALL", text="\u81ea\u5b9a\u4e49\u5b58\u50a8\u8fc7\u7a0b", realtext="\u81ea\u5b9a\u4e49\u5b58\u50a8\u8fc7\u7a0b")})
public abstract class CodeList10CodeListModelBase
extends StaticCodeListModelBase {
    public static final String INSERT = "INSERT";
    public static final String UPDATE = "UPDATE";
    public static final String DELETE = "DELETE";
    public static final String SELECT = "SELECT";
    public static final String CUSTOMCALL = "CUSTOMCALL";
    public static final String CUSTOMPROCCALL = "CUSTOMPROCCALL";

    public CodeList10CodeListModelBase() {
        this.initAnnotation(CodeList10CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList10CodeListModel", this);
    }
}

