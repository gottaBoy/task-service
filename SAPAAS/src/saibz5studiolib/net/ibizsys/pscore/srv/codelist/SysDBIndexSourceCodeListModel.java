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

@CodeList(id="F5BAFC77-F2EA-4B32-958D-BC9C27809B74", name="\u7cfb\u7edf\u6570\u636e\u5e93\u7d22\u5f15\u6765\u6e90", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEDBINDEX", text="\u5b9e\u4f53\u6570\u636e\u7d22\u5f15", realtext="\u5b9e\u4f53\u6570\u636e\u7d22\u5f15"), @CodeItem(value="DER", text="\u5b9e\u4f53\u5173\u7cfb", realtext="\u5b9e\u4f53\u5173\u7cfb")})
public class SysDBIndexSourceCodeListModel
extends StaticCodeListModelBase {
    public static final String DEDBINDEX = "DEDBINDEX";
    public static final String DER = "DER";

    public SysDBIndexSourceCodeListModel() {
        this.initAnnotation(SysDBIndexSourceCodeListModel.class);
        this.setUserData2("DBIndexSource");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDBIndexSourceCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDBIndexSourceCodeListModel");
    }
}

