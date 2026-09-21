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

@CodeList(id="8a9b6d56c3ae787438cf568a904129f2", name="\u5de5\u4f5c\u6d41\u5f15\u64ce\u7c7b\u578b", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="EMBEDDED", text="iBiz\u5185\u7f6e\uff08\u9ed8\u8ba4\uff09", realtext="iBiz\u5185\u7f6e\uff08\u9ed8\u8ba4\uff09"), @CodeItem(value="ACTIVITI", text="Java Activiti", realtext="Java Activiti")})
public class WFEngineTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String EMBEDDED = "EMBEDDED";
    public static final String ACTIVITI = "ACTIVITI";

    public WFEngineTypeCodeListModel() {
        this.initAnnotation(WFEngineTypeCodeListModel.class);
        this.setUserData2("WFEngineType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WFEngineTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WFEngineTypeCodeListModel");
    }
}

