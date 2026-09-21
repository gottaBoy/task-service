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

@CodeList(id="BAE3F5EB-CB05-473F-8CA7-FDA539523A68", name="\u52a8\u6001\u7cfb\u7edf\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u4e0d\u542f\u7528\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u542f\u7528", realtext="\u4e0d\u542f\u7528"), @CodeItem(value="1", text="\u542f\u7528", realtext="\u542f\u7528")})
public class DynaSysModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer DISABLED = 0;
    public static final int INT_DISABLED = 0;
    public static final Integer ENABLED = 1;
    public static final int INT_ENABLED = 1;

    public DynaSysModeCodeListModel() {
        this.initAnnotation(DynaSysModeCodeListModel.class);
        this.setUserData2("DynaSysMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DynaSysModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DynaSysModeCodeListModel");
    }
}

