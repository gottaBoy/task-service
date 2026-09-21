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

@CodeList(id="D1EF8562-B6AF-4956-ABF8-4ABC19B09C41", name="\u591a\u6570\u636e\u90e8\u4ef6\u5185\u7f6e\u5bfc\u822a\u89c6\u56fe\u4f4d\u7f6e", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0", realtext="\u65e0"), @CodeItem(value="RIGHT", text="\u53f3\u4fa7", realtext="\u53f3\u4fa7"), @CodeItem(value="BOTTOM", text="\u4e0b\u65b9", realtext="\u4e0b\u65b9"), @CodeItem(value="ANY_RIGHT", text="\u4efb\u610f\uff08\u9ed8\u8ba4\u53f3\u4fa7\uff09", realtext="\u4efb\u610f\uff08\u9ed8\u8ba4\u53f3\u4fa7\uff09"), @CodeItem(value="ANY_BOTTOM", text="\u4efb\u610f\uff08\u9ed8\u8ba4\u4e0b\u65b9\uff09", realtext="\u4efb\u610f\uff08\u9ed8\u8ba4\u4e0b\u65b9\uff09"), @CodeItem(value="ROWDETAIL", text="\u884c\u660e\u7ec6\u533a", realtext="\u884c\u660e\u7ec6\u533a", userdata="\u8868\u683c\u6216\u5217\u8868\u7684\u884c\u660e\u7ec6\u533a"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class NavViewPosCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String RIGHT = "RIGHT";
    public static final String BOTTOM = "BOTTOM";
    public static final String ANY_RIGHT = "ANY_RIGHT";
    public static final String ANY_BOTTOM = "ANY_BOTTOM";
    public static final String ROWDETAIL = "ROWDETAIL";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public NavViewPosCodeListModel() {
        this.initAnnotation(NavViewPosCodeListModel.class);
        this.setUserData2("NavViewPos");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.NavViewPosCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.NavViewPosCodeListModel");
    }
}

