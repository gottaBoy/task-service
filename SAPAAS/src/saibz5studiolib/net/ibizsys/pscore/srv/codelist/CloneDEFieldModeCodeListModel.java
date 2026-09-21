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

@CodeList(id="5407483F-4039-4A5C-9AB5-C2E8A182783D", name="\u514b\u9686\u5b9e\u4f53\u5c5e\u6027\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u514b\u9686", realtext="\u4e0d\u514b\u9686"), @CodeItem(value="1", text="\u5168\u90e8\uff08\u65e0\u4e3b\u952e\u53ca\u4e3b\u5c5e\u6027\uff09", realtext="\u5168\u90e8\uff08\u65e0\u4e3b\u952e\u53ca\u4e3b\u5c5e\u6027\uff09"), @CodeItem(value="2", text="\u5168\u90e8\u5c5e\u6027", realtext="\u5168\u90e8\u5c5e\u6027")})
public class CloneDEFieldModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer ITEM_0 = 0;
    public static final int INT_ITEM_0 = 0;
    public static final Integer ITEM_1 = 1;
    public static final int INT_ITEM_1 = 1;
    public static final Integer ITEM_2 = 2;
    public static final int INT_ITEM_2 = 2;

    public CloneDEFieldModeCodeListModel() {
        this.initAnnotation(CloneDEFieldModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.CloneDEFieldModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.CloneDEFieldModeCodeListModel");
    }
}

