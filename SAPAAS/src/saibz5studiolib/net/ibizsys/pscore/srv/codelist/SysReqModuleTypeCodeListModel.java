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

@CodeList(id="15EAB578-93AF-419F-ABBC-5D3EABDBD21D", name="\u7cfb\u7edf\u9700\u6c42\u6a21\u5757\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NORMAL", text="\u5e38\u89c4", realtext="\u5e38\u89c4"), @CodeItem(value="AIAGENT", text="AI\u4ee3\u7406", realtext="AI\u4ee3\u7406")})
public class SysReqModuleTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String NORMAL = "NORMAL";
    public static final String AIAGENT = "AIAGENT";

    public SysReqModuleTypeCodeListModel() {
        this.initAnnotation(SysReqModuleTypeCodeListModel.class);
        this.setUserData2("SysReqModuleType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysReqModuleTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysReqModuleTypeCodeListModel");
    }
}

