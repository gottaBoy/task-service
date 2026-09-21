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

@CodeList(id="5084FDFF-379B-47A4-A551-D4B0891C2943", name="\u4e91\u5e73\u53f0\u5b9e\u4f53\u5b58\u50a8\u7c7b\u578b\uff08\u5e94\u7528\u5b9e\u4f53\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0\u5b58\u50a8", realtext="\u65e0\u5b58\u50a8"), @CodeItem(value="1", text="SQL", realtext="SQL"), @CodeItem(value="2", text="NoSQL", realtext="NoSQL")})
public class DEStorageType2CodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer SQL = 1;
    public static final int INT_SQL = 1;
    public static final Integer NOSQL = 2;
    public static final int INT_NOSQL = 2;

    public DEStorageType2CodeListModel() {
        this.initAnnotation(DEStorageType2CodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEStorageType2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEStorageType2CodeListModel");
    }
}

