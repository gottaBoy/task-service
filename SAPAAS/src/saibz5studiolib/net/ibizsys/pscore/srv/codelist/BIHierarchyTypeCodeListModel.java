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

@CodeList(id="f4a612930e17c5a9c54bdaaa6fc04eba", name="\u5206\u6790\u7ef4\u5ea6\u4f53\u7cfb\u7c7b\u578b", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="DE", text="\u5b9e\u4f53\u5bf9\u8c61", realtext="\u5b9e\u4f53\u5bf9\u8c61"), @CodeItem(value="TIME", text="\u65f6\u95f4", realtext="\u65f6\u95f4")})
public class BIHierarchyTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DE = "DE";
    public static final String TIME = "TIME";

    public BIHierarchyTypeCodeListModel() {
        this.initAnnotation(BIHierarchyTypeCodeListModel.class);
        this.setUserData2("BIHierarchyType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.BIHierarchyTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.BIHierarchyTypeCodeListModel");
    }
}

