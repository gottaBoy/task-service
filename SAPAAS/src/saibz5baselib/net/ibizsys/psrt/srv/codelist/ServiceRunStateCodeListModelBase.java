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

@CodeList(id="2970295eebeaab891a13f1634eadb668", name="\u670d\u52a1\u8fd0\u884c\u72b6\u6001", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="START", text="\u5df2\u542f\u52a8", realtext="\u5df2\u542f\u52a8"), @CodeItem(value="STOP", text="\u5df2\u505c\u6b62", realtext="\u5df2\u505c\u6b62"), @CodeItem(value="STARTERROR", text="\u542f\u52a8\u9519\u8bef", realtext="\u542f\u52a8\u9519\u8bef")})
public abstract class ServiceRunStateCodeListModelBase
extends StaticCodeListModelBase {
    public static final String START = "START";
    public static final String STOP = "STOP";
    public static final String STARTERROR = "STARTERROR";

    public ServiceRunStateCodeListModelBase() {
        this.initAnnotation(ServiceRunStateCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.ServiceRunStateCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.ServiceRunStateCodeListModel");
    }
}

