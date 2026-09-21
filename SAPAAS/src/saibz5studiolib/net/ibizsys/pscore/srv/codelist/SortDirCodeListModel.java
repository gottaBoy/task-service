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

@CodeList(id="a133fc1392d74d495f238af9eb326785", name="\u5b57\u6bb5\u6392\u5e8f\u65b9\u5411", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="ASC", text="\u5347\u5e8f", realtext="\u5347\u5e8f"), @CodeItem(value="DESC", text="\u964d\u5e8f", realtext="\u964d\u5e8f")})
public class SortDirCodeListModel
extends StaticCodeListModelBase {
    public static final String ASC = "ASC";
    public static final String DESC = "DESC";

    public SortDirCodeListModel() {
        this.initAnnotation(SortDirCodeListModel.class);
        this.setUserData("IGNOREMODELDSLNAME");
        this.setUserData2("SortDir");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SortDirCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SortDirCodeListModel");
    }
}

