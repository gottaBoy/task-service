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

@CodeList(id="c59d8132dd946cdf9a681a0c969aa95e", name="\u5de5\u4f5c\u6d41\u64cd\u4f5c\u8005\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="USER", text="\u7528\u6237", realtext="\u7528\u6237"), @CodeItem(value="USERGROUP", text="\u7528\u6237\u7ec4", realtext="\u7528\u6237\u7ec4"), @CodeItem(value="SYSTEMUSER", text="\u7cfb\u7edf\u4fdd\u7559\u7528\u6237", realtext="\u7cfb\u7edf\u4fdd\u7559\u7528\u6237"), @CodeItem(value="DYNAMICUSER", text="\u52a8\u6001\u7528\u6237", realtext="\u52a8\u6001\u7528\u6237")})
public abstract class WFActorTypeCodeListModelBase
extends StaticCodeListModelBase {
    public static final String USER = "USER";
    public static final String USERGROUP = "USERGROUP";
    public static final String SYSTEMUSER = "SYSTEMUSER";
    public static final String DYNAMICUSER = "DYNAMICUSER";

    public WFActorTypeCodeListModelBase() {
        this.initAnnotation(WFActorTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.WFActorTypeCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.WFActorTypeCodeListModel");
    }
}

