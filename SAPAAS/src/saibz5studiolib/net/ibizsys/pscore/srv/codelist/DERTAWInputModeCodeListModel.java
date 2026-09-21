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

@CodeList(id="ebc64865ba0bf3cfb6a9def509f4d93d", name="\u64cd\u4f5c\u5411\u5bfc\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u4e00\u6b21\u8f93\u5165", realtext="\u4e00\u6b21\u8f93\u5165"), @CodeItem(value="2", text="\u9010\u9879\u8f93\u5165", realtext="\u9010\u9879\u8f93\u5165")})
public class DERTAWInputModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer ONCE = 1;
    public static final int INT_ONCE = 1;
    public static final Integer STEP = 2;
    public static final int INT_STEP = 2;

    public DERTAWInputModeCodeListModel() {
        this.initAnnotation(DERTAWInputModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DERTAWInputModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DERTAWInputModeCodeListModel");
    }
}

