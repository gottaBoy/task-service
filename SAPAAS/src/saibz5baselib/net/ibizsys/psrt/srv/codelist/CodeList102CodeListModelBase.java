/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="062feef8cc2886829c4838c8c2e1242a", name="\u8f93\u5165\u8f85\u52a9_\u6d88\u606f\u6a21\u677f\u5b8f", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="CARETTEMPLGROUP_SRFMSG_MSGTEMPLATE", text="\u6d88\u606f\u6a21\u677f", realtext="\u6d88\u606f\u6a21\u677f"), @CodeItem(value="CARETTEMPLGROUP_SRFDA_FILLENTITYPARAM", text="\u7cfb\u7edf\u5c5e\u6027", realtext="\u7cfb\u7edf\u5c5e\u6027")})
public abstract class CodeList102CodeListModelBase
extends StaticCodeListModelBase {
    public static final String CARETTEMPLGROUP_SRFMSG_MSGTEMPLATE = "CARETTEMPLGROUP_SRFMSG_MSGTEMPLATE";
    public static final String CARETTEMPLGROUP_SRFDA_FILLENTITYPARAM = "CARETTEMPLGROUP_SRFDA_FILLENTITYPARAM";

    public CodeList102CodeListModelBase() {
        this.initAnnotation(CodeList102CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList102CodeListModel", this);
    }
}

