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

@CodeList(id="0e369a74cece229a72db4a840dd660c1", name="\u8868\u683c\u5217\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEFGRIDCOLUMN", text="\u5c5e\u6027\u5217", realtext="\u5c5e\u6027\u5217", userdata="\u7ed1\u5b9a\u5c5e\u6027\u6570\u636e\u7684\u5217"), @CodeItem(value="UAGRIDCOLUMN", text="\u64cd\u4f5c\u5217", realtext="\u64cd\u4f5c\u5217", userdata="\u4e3a\u884c\u6570\u636e\u63d0\u4f9b\u64cd\u4f5c\u80fd\u529b\u7684\u5217"), @CodeItem(value="GROUPGRIDCOLUMN", text="\u5c5e\u6027\u5206\u7ec4\u5217", realtext="\u5c5e\u6027\u5206\u7ec4\u5217", userdata="\u5305\u542b\u8868\u683c\u5217\u7684\u5217\uff0c\u63d0\u4f9b\u5217\u7684\u5206\u7ec4\u529f\u80fd")})
public class DEGridColTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFGRIDCOLUMN = "DEFGRIDCOLUMN";
    public static final String UAGRIDCOLUMN = "UAGRIDCOLUMN";
    public static final String GROUPGRIDCOLUMN = "GROUPGRIDCOLUMN";

    public DEGridColTypeCodeListModel() {
        this.initAnnotation(DEGridColTypeCodeListModel.class);
        this.setUserData2("GridColType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEGridColTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEGridColTypeCodeListModel");
    }
}

