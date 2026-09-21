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

@CodeList(id="831f55fdc6ee94e38d63d2cb03d5dd9b", name="\u6d41\u7a0b\u5904\u7406\u903b\u8f91\u8fde\u63a5\u6761\u4ef6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="GROUP", text="\u7ec4\u903b\u8f91", realtext="\u7ec4\u903b\u8f91"), @CodeItem(value="SINGLE", text="\u5355\u9879\u903b\u8f91", realtext="\u5355\u9879\u903b\u8f91"), @CodeItem(value="CUSTOM", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49")})
public class WFLinkCondTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String GROUP = "GROUP";
    public static final String SINGLE = "SINGLE";
    public static final String CUSTOM = "CUSTOM";

    public WFLinkCondTypeCodeListModel() {
        this.initAnnotation(WFLinkCondTypeCodeListModel.class);
        this.setUserData2("WFLinkCondType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WFLinkCondTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WFLinkCondTypeCodeListModel");
    }
}

