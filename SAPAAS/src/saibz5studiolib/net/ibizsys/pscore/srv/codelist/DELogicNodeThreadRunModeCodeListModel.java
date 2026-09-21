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

@CodeList(id="FC7BADC6-A14E-4432-8E98-5E56929EEA62", name="\u5b9e\u4f53\u903b\u8f91\u8282\u70b9\u7ebf\u7a0b\u8fd0\u884c\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u542f\u7528", realtext="\u4e0d\u542f\u7528"), @CodeItem(value="1", text="\u7ebf\u7a0b\u6267\u884c", realtext="\u7ebf\u7a0b\u6267\u884c"), @CodeItem(value="2", text="\u5b9a\u65f6\u6267\u884c", realtext="\u5b9a\u65f6\u6267\u884c")})
public class DELogicNodeThreadRunModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer THREAD = 1;
    public static final int INT_THREAD = 1;
    public static final Integer TIMER = 2;
    public static final int INT_TIMER = 2;

    public DELogicNodeThreadRunModeCodeListModel() {
        this.initAnnotation(DELogicNodeThreadRunModeCodeListModel.class);
        this.setUserData2("DELogicNodeThreadRunMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicNodeThreadRunModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicNodeThreadRunModeCodeListModel");
    }
}

