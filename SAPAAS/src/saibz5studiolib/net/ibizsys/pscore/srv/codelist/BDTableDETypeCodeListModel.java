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

@CodeList(id="ec21fdedd8b618ed26eaf6aeb696a419", name="\u5927\u6570\u636e\u8868\u5b9e\u4f53\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u9ed8\u8ba4\u5b9e\u4f53", realtext="\u9ed8\u8ba4\u5b9e\u4f53"), @CodeItem(value="2", text="\u5173\u7cfb\u4e3b\u5b9e\u4f53", realtext="\u5173\u7cfb\u4e3b\u5b9e\u4f53"), @CodeItem(value="3", text="\u5173\u7cfb\u4ece\u5b9e\u4f53", realtext="\u5173\u7cfb\u4ece\u5b9e\u4f53"), @CodeItem(value="0", text="\u9644\u5c5e\u5b9e\u4f53", realtext="\u9644\u5c5e\u5b9e\u4f53")})
public class BDTableDETypeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer DEFAULT = 1;
    public static final int INT_DEFAULT = 1;
    public static final Integer MAJOR = 2;
    public static final int INT_MAJOR = 2;
    public static final Integer MINOR = 3;
    public static final int INT_MINOR = 3;
    public static final Integer RELATED = 0;
    public static final int INT_RELATED = 0;

    public BDTableDETypeCodeListModel() {
        this.initAnnotation(BDTableDETypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.BDTableDETypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.BDTableDETypeCodeListModel");
    }
}

