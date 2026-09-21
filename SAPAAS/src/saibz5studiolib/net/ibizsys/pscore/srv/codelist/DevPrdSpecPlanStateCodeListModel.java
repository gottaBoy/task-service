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

@CodeList(id="b31e8b3b5d367a42e2fb578f11698540", name="\u5f00\u53d1\u4ea7\u54c1\u89c4\u8303\u53d1\u5e03\u8ba1\u5212\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u8ba1\u5212\u4e2d", realtext="\u8ba1\u5212\u4e2d"), @CodeItem(value="20", text="\u5df2\u53d1\u5e03", realtext="\u5df2\u53d1\u5e03"), @CodeItem(value="30", text="\u5df2\u53d6\u6d88", realtext="\u5df2\u53d6\u6d88")})
public class DevPrdSpecPlanStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer PLAN = 10;
    public static final int INT_PLAN = 10;
    public static final Integer PUBLISH = 20;
    public static final int INT_PUBLISH = 20;
    public static final Integer CANCEL = 30;
    public static final int INT_CANCEL = 30;

    public DevPrdSpecPlanStateCodeListModel() {
        this.initAnnotation(DevPrdSpecPlanStateCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevPrdSpecPlanStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevPrdSpecPlanStateCodeListModel");
    }
}

