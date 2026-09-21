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

@CodeList(id="2e323f1a7da30921f0e25d6fdf033ff7", name="\u6d41\u7a0b\u5e38\u89c4\u5904\u7406\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEACTION", text="\u8c03\u7528\u5b9e\u4f53\u884c\u4e3a", realtext="\u8c03\u7528\u5b9e\u4f53\u884c\u4e3a"), @CodeItem(value="NONE", text="\u7a7a\u5904\u7406", realtext="\u7a7a\u5904\u7406")})
public class WFNormalProcTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEACTION = "DEACTION";
    public static final String NONE = "NONE";

    public WFNormalProcTypeCodeListModel() {
        this.initAnnotation(WFNormalProcTypeCodeListModel.class);
        this.setUserData2("WFServiceProcType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WFNormalProcTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WFNormalProcTypeCodeListModel");
    }
}

