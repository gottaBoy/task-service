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

@CodeList(id="c81af3b3cc5775c3f156ef9c5e0190ed", name="\u903b\u8f91\u6240\u6709\u8005", type="STATIC", userscope=false, emptytext="\uff08\u540e\u53f0\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u540e\u53f0", realtext="\u540e\u53f0", userdata="\u6307\u5b9a\u903b\u8f91\u5177\u5907\u5728\u524d\u7aef\u6a21\u677f\u6267\u884c\u7684\u80fd\u529b"), @CodeItem(value="2", text="\u524d\u53f0", realtext="\u524d\u53f0", userdata="\u6307\u5b9a\u903b\u8f91\u5177\u5907\u5728\u540e\u53f0\u6a21\u677f\u6267\u884c\u7684\u80fd\u529b"), @CodeItem(value="3", text="\u540e\u53f0\u53ca\u524d\u53f0", realtext="\u540e\u53f0\u53ca\u524d\u53f0", userdata="\u6307\u5b9a\u903b\u8f91\u540c\u65f6\u5177\u5907\u5728\u524d\u7aef\u53ca\u540e\u53f0\u6a21\u677f\u6267\u884c\u7684\u80fd\u529b")})
public class DELogicHolderCodeListModel
extends StaticCodeListModelBase {
    public static final Integer BACKEND = 1;
    public static final int INT_BACKEND = 1;
    public static final Integer FRONT = 2;
    public static final int INT_FRONT = 2;
    public static final Integer BACKENDANDFRONT = 3;
    public static final int INT_BACKENDANDFRONT = 3;

    public DELogicHolderCodeListModel() {
        this.initAnnotation(DELogicHolderCodeListModel.class);
        this.setUserData2("DELogicHolder");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicHolderCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicHolderCodeListModel");
    }
}

