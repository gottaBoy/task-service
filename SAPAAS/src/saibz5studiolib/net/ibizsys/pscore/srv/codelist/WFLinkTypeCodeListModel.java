/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.CodeItem
 *  net.ibizsys.paas.codelist.CodeItems
 *  net.ibizsys.paas.codelist.CodeList
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 *  net.ibizsys.paas.sysmodel.StaticCodeListModelBase
 */
package net.ibizsys.pscore.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="210ca021daeb27435cbd668e769e1a2c", name="\u6d41\u7a0b\u8fde\u63a5\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TIMEOUT", text="\u8d85\u65f6\u8fde\u63a5", realtext="\u8d85\u65f6\u8fde\u63a5"), @CodeItem(value="IAACTION", text="\u4ea4\u4e92\u8fde\u63a5", realtext="\u4ea4\u4e92\u8fde\u63a5"), @CodeItem(value="ROUTE", text="\u5e38\u89c4\u8fde\u63a5", realtext="\u5e38\u89c4\u8fde\u63a5"), @CodeItem(value="WFRETURN", text="\u5d4c\u5165\u6d41\u7a0b\u8fd4\u56de", realtext="\u5d4c\u5165\u6d41\u7a0b\u8fd4\u56de")})
public class WFLinkTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String TIMEOUT = "TIMEOUT";
    public static final String IAACTION = "IAACTION";
    public static final String ROUTE = "ROUTE";
    public static final String WFRETURN = "WFRETURN";

    public WFLinkTypeCodeListModel() {
        this.initAnnotation(WFLinkTypeCodeListModel.class);
        this.setUserData2("WFLinkType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WFLinkTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WFLinkTypeCodeListModel");
    }
}

