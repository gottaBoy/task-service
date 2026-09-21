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

@CodeList(id="859a6c8381d7b2c7151a742c6cb50c6f", name="\u8868\u5355\u9879\u503c\u89c4\u5219\u6821\u9a8c\u65b9\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\u524d\u540e\u53f0\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u524d\u53f0", realtext="\u524d\u53f0", userdata="\u4ec5\u5728\u524d\u7aef\u5e94\u7528\u8fdb\u884c\u503c\u89c4\u5219\u6821\u9a8c"), @CodeItem(value="2", text="\u540e\u53f0", realtext="\u540e\u53f0", userdata="\u4ec5\u5728\u540e\u7aef\u670d\u52a1\u8fdb\u884c\u503c\u89c4\u5219\u6821\u9a8c"), @CodeItem(value="3", text="\u524d\u540e\u53f0", realtext="\u524d\u540e\u53f0", userdata="\u540c\u65f6\u5728\u524d\u7aef\u5e94\u7528\u53ca\u540e\u53f0\u670d\u52a1\u8fdb\u884c\u6821\u9a8c")})
public class DEFIVRCheckModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer FRONT = 1;
    public static final int INT_FRONT = 1;
    public static final Integer BACKEND = 2;
    public static final int INT_BACKEND = 2;
    public static final Integer ALL = 3;
    public static final int INT_ALL = 3;

    public DEFIVRCheckModeCodeListModel() {
        this.initAnnotation(DEFIVRCheckModeCodeListModel.class);
        this.setUserData2("EditItemVRCheckMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFIVRCheckModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFIVRCheckModeCodeListModel");
    }
}

