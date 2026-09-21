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

@CodeList(id="91a0c8153d5a3811ca0b134aa1b21c08", name="\u6d41\u7a0b\u5904\u7406\u8fde\u63a5\u4e3b\u7ebf\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0", realtext="\u65e0"), @CodeItem(value="1", text="\u4e1a\u52a1\u4e3b\u7ebf", realtext="\u4e1a\u52a1\u4e3b\u7ebf"), @CodeItem(value="2", text="\u4e1a\u52a1\u8f85\u7ebf", realtext="\u4e1a\u52a1\u8f85\u7ebf")})
public class WFLinkThreadModeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "0";
    public static final String MAJOR = "1";
    public static final String MINOR = "2";

    public WFLinkThreadModeCodeListModel() {
        this.initAnnotation(WFLinkThreadModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WFLinkThreadModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WFLinkThreadModeCodeListModel");
    }
}

