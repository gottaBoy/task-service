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

@CodeList(id="fd3623156225dc671ad2ecfffda0f830", name="\u5f00\u53d1\u4ea7\u54c1\u7cfb\u7edf\u540c\u6b65\u9879\u64cd\u4f5c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SYNCMODEL", text="\u540c\u6b65\u6a21\u578b", realtext="\u540c\u6b65\u6a21\u578b"), @CodeItem(value="SYNCUSERCODE", text="\u540c\u6b65\u7528\u6237\u4ee3\u7801", realtext="\u540c\u6b65\u7528\u6237\u4ee3\u7801")})
public class DevPrdSysSyncActionCodeListModel
extends StaticCodeListModelBase {
    public static final String SYNCMODEL = "SYNCMODEL";
    public static final String SYNCUSERCODE = "SYNCUSERCODE";

    public DevPrdSysSyncActionCodeListModel() {
        this.initAnnotation(DevPrdSysSyncActionCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevPrdSysSyncActionCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevPrdSysSyncActionCodeListModel");
    }
}

