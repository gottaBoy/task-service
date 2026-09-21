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

@CodeList(id="237fc5fa8f3ea3b4c813ee8ad6a7d56b", name="\u4e91\u5b9e\u4f53\u6570\u636e\u6a21\u578b\u53d8\u66f4\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="CREATE", text="\u5efa\u7acb", realtext="\u5efa\u7acb"), @CodeItem(value="UPDATE", text="\u66f4\u65b0", realtext="\u66f4\u65b0"), @CodeItem(value="DELETE", text="\u5220\u9664", realtext="\u5220\u9664"), @CodeItem(value="OTHER", text="\u5176\u5b83", realtext="\u5176\u5b83")})
public class PSObjChangeTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String CREATE = "CREATE";
    public static final String UPDATE = "UPDATE";
    public static final String DELETE = "DELETE";
    public static final String OTHER = "OTHER";

    public PSObjChangeTypeCodeListModel() {
        this.initAnnotation(PSObjChangeTypeCodeListModel.class);
        this.setUserData2("PSModelChangeType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PSObjChangeTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PSObjChangeTypeCodeListModel");
    }
}

