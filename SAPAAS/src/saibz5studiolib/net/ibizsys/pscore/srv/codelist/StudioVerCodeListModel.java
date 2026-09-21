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

@CodeList(id="40f19dc6f216def01b25cfee04f92dcc", name="Studio\u5de5\u5177\u7248\u672c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="S0500", text="\u6807\u51c65.0", realtext="\u6807\u51c65.0"), @CodeItem(value="S0600", text="\u6807\u51c66.0", realtext="\u6807\u51c66.0"), @CodeItem(value="S0600M1", text="\u6807\u51c66.0\uff08\u517c\u5bb95.0\uff09", realtext="\u6807\u51c66.0\uff08\u517c\u5bb95.0\uff09")})
public class StudioVerCodeListModel
extends StaticCodeListModelBase {
    public static final String S0500 = "S0500";
    public static final String S0600 = "S0600";
    public static final String S0600M1 = "S0600M1";

    public StudioVerCodeListModel() {
        this.initAnnotation(StudioVerCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.StudioVerCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.StudioVerCodeListModel");
    }
}

