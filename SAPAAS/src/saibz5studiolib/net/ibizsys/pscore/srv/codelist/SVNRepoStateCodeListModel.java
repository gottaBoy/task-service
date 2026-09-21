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

@CodeList(id="d85f55058b715ec36401dd14d41de99d", name="SVN\u4ed3\u5e93\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u672a\u521d\u59cb\u5316", realtext="\u672a\u521d\u59cb\u5316"), @CodeItem(value="20", text="\u5df2\u521d\u59cb\u5316", realtext="\u5df2\u521d\u59cb\u5316"), @CodeItem(value="30", text="\u5df2\u4f7f\u7528", realtext="\u5df2\u4f7f\u7528"), @CodeItem(value="40", text="\u5df2\u4f5c\u5e9f", realtext="\u5df2\u4f5c\u5e9f")})
public class SVNRepoStateCodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM_10 = "10";
    public static final String ITEM_20 = "20";
    public static final String ITEM_30 = "30";
    public static final String ITEM_40 = "40";

    public SVNRepoStateCodeListModel() {
        this.initAnnotation(SVNRepoStateCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SVNRepoStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SVNRepoStateCodeListModel");
    }
}

