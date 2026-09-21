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

@CodeList(id="54ea8fadb0aa1547fe329bc3a18237dd", name="Android\u7248\u672c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="400", text="4.0\u4ee5\u4e0a", realtext="4.0\u4ee5\u4e0a"), @CodeItem(value="500", text="5.0\u4ee5\u4e0a", realtext="5.0\u4ee5\u4e0a"), @CodeItem(value="600", text="6.0\u4ee5\u4e0a", realtext="6.0\u4ee5\u4e0a")})
public class AndroidVerCodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM_400 = "400";
    public static final String ITEM_500 = "500";
    public static final String ITEM_600 = "600";

    public AndroidVerCodeListModel() {
        this.initAnnotation(AndroidVerCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AndroidVerCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AndroidVerCodeListModel");
    }
}

