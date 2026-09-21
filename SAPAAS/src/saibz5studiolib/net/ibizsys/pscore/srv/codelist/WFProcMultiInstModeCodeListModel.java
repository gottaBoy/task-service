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

@CodeList(id="76a708776b020f43b105f70889afe73b", name="\u6d41\u7a0b\u5904\u7406\u591a\u5b9e\u4f8b\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0", realtext="\u65e0"), @CodeItem(value="PARALLEL", text="\u5e76\u884c\u591a\u5b9e\u4f8b", realtext="\u5e76\u884c\u591a\u5b9e\u4f8b"), @CodeItem(value="SEQUENTIAL", text="\u4e32\u884c\u591a\u5b9e\u4f8b", realtext="\u4e32\u884c\u591a\u5b9e\u4f8b")})
public class WFProcMultiInstModeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String PARALLEL = "PARALLEL";
    public static final String SEQUENTIAL = "SEQUENTIAL";

    public WFProcMultiInstModeCodeListModel() {
        this.initAnnotation(WFProcMultiInstModeCodeListModel.class);
        this.setUserData2("WFProcMultiInstMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WFProcMultiInstModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WFProcMultiInstModeCodeListModel");
    }
}

