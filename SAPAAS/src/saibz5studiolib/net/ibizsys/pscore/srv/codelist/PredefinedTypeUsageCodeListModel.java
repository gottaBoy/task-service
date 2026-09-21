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

@CodeList(id="ad792ffa996f1000a2dbb1c49f5bd6bd", name="\u9884\u5b9a\u4e49\u7c7b\u578b\u7528\u9014", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TEXT", text="TEXT", realtext="TEXT"), @CodeItem(value="BUTTON", text="BUTTON", realtext="BUTTON"), @CodeItem(value="IMAGE", text="IMAGE", realtext="IMAGE")})
public class PredefinedTypeUsageCodeListModel
extends StaticCodeListModelBase {
    public static final String TEXT = "TEXT";
    public static final String BUTTON = "BUTTON";
    public static final String IMAGE = "IMAGE";

    public PredefinedTypeUsageCodeListModel() {
        this.initAnnotation(PredefinedTypeUsageCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PredefinedTypeUsageCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PredefinedTypeUsageCodeListModel");
    }
}

