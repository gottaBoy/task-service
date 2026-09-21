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

@CodeList(id="56ebd850ad820eda5390a8453faddd8d", name="\u9608\u503c\u7ec4\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="STATIC", text="\u9759\u6001", realtext="\u9759\u6001"), @CodeItem(value="DYNAMIC", text="\u52a8\u6001", realtext="\u52a8\u6001")})
public class ThresholdGroupTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String STATIC = "STATIC";
    public static final String DYNAMIC = "DYNAMIC";

    public ThresholdGroupTypeCodeListModel() {
        this.initAnnotation(ThresholdGroupTypeCodeListModel.class);
        this.setUserData2("ThresholdGroupType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ThresholdGroupTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ThresholdGroupTypeCodeListModel");
    }
}

