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

@CodeList(id="63748958-1A41-4576-89B9-1372F0121833", name="\u670d\u52a1\u5bb9\u5668", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="SC01", text="\u670d\u52a1\u5bb9\u566801", realtext="\u670d\u52a1\u5bb9\u566801"), @CodeItem(value="SC02", text="\u670d\u52a1\u5bb9\u566802", realtext="\u670d\u52a1\u5bb9\u566802"), @CodeItem(value="SC03", text="\u670d\u52a1\u5bb9\u566803", realtext="\u670d\u52a1\u5bb9\u566803"), @CodeItem(value="SC04", text="\u670d\u52a1\u5bb9\u566804", realtext="\u670d\u52a1\u5bb9\u566804")})
public abstract class ServiceContainerCodeListModelBase
extends StaticCodeListModelBase {
    public static final String SC01 = "SC01";
    public static final String SC02 = "SC02";
    public static final String SC03 = "SC03";
    public static final String SC04 = "SC04";

    public ServiceContainerCodeListModelBase() {
        this.initAnnotation(ServiceContainerCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.ServiceContainerCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.ServiceContainerCodeListModel");
    }
}

