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

@CodeList(id="2DF82870-2B81-4EE2-A53D-95B6A0DA14B1", name="\u6570\u636e\u5bf9\u8c61\u80fd\u529b\u7528\u6237\u6570\u636e\u8303\u56f4", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u5efa\u7acb\u4eba", realtext="\u5efa\u7acb\u4eba"), @CodeItem(value="2", text="\u66f4\u65b0\u4eba", realtext="\u66f4\u65b0\u4eba")})
public abstract class URDUserDRCodeListModelBase
extends StaticCodeListModelBase {
    public static final Integer CREATEMAN = 1;
    public static final int INT_CREATEMAN = 1;
    public static final Integer UPDATEMAN = 2;
    public static final int INT_UPDATEMAN = 2;

    public URDUserDRCodeListModelBase() {
        this.initAnnotation(URDUserDRCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.URDUserDRCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.URDUserDRCodeListModel");
    }
}

