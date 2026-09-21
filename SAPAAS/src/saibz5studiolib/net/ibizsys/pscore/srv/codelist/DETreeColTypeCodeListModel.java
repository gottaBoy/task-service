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

@CodeList(id="719F88FF-28D1-489D-98A6-B3B20D3EB107", name="\u5b9e\u4f53\u6811\u8868\u683c\u5217\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEFGRIDCOLUMN", text="\u5c5e\u6027\u5217", realtext="\u5c5e\u6027\u5217", userdata="\u7ed1\u5b9a\u5c5e\u6027\u6570\u636e\u7684\u5217"), @CodeItem(value="UAGRIDCOLUMN", text="\u64cd\u4f5c\u5217", realtext="\u64cd\u4f5c\u5217", userdata="\u4e3a\u884c\u6570\u636e\u63d0\u4f9b\u64cd\u4f5c\u80fd\u529b\u7684\u5217")})
public class DETreeColTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFGRIDCOLUMN = "DEFGRIDCOLUMN";
    public static final String UAGRIDCOLUMN = "UAGRIDCOLUMN";

    public DETreeColTypeCodeListModel() {
        this.initAnnotation(DETreeColTypeCodeListModel.class);
        this.setUserData2("TreeColType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DETreeColTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DETreeColTypeCodeListModel");
    }
}

