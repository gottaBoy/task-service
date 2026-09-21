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

@CodeList(id="1FB56840-81DE-480F-8826-4CEBFD8168A1", name="\u5b9e\u4f53\u903b\u8f91\u8282\u70b9\u4e8b\u52a1\u8fd0\u884c\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u5f00\u542f", realtext="\u5f00\u542f"), @CodeItem(value="3", text="\u5f00\u542f\u65b0\u4e8b\u52a1", realtext="\u5f00\u542f\u65b0\u4e8b\u52a1")})
public class DELogicNodeTSModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer REQUIRED = 0;
    public static final int INT_REQUIRED = 0;
    public static final Integer REQUIREDNEW = 3;
    public static final int INT_REQUIREDNEW = 3;

    public DELogicNodeTSModeCodeListModel() {
        this.initAnnotation(DELogicNodeTSModeCodeListModel.class);
        this.setUserData2("DELogicNodeTSMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicNodeTSModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicNodeTSModeCodeListModel");
    }
}

