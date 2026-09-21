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

@CodeList(id="739eb845a95f96c683f97f24b153c1b4", name="\u5bfc\u822a\u680f\u4f4d\u7f6e", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TOPLEFT", text="\u5de6\u4e0a\u89d2", realtext="\u5de6\u4e0a\u89d2"), @CodeItem(value="TOPRIGHT", text="\u53f3\u4e0a\u89d2", realtext="\u53f3\u4e0a\u89d2"), @CodeItem(value="BOTTOMLEFT", text="\u5de6\u4e0b\u89d2", realtext="\u5de6\u4e0b\u89d2"), @CodeItem(value="BOTTOMRIGHT", text="\u53f3\u4e0b\u89d2", realtext="\u53f3\u4e0b\u89d2"), @CodeItem(value="MIDDLELEFT", text="\u5de6\u4fa7\u4e2d\u95f4", realtext="\u5de6\u4fa7\u4e2d\u95f4"), @CodeItem(value="MIDDLERIGHT", text="\u53f3\u4fa7\u4e2d\u95f4", realtext="\u53f3\u4fa7\u4e2d\u95f4"), @CodeItem(value="TOP", text="\u4e0a\u65b9", realtext="\u4e0a\u65b9"), @CodeItem(value="BOTTOM", text="\u4e0b\u65b9", realtext="\u4e0b\u65b9"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class FormNavBarPosCodeListModel
extends StaticCodeListModelBase {
    public static final String TOPLEFT = "TOPLEFT";
    public static final String TOPRIGHT = "TOPRIGHT";
    public static final String BOTTOMLEFT = "BOTTOMLEFT";
    public static final String BOTTOMRIGHT = "BOTTOMRIGHT";
    public static final String MIDDLELEFT = "MIDDLELEFT";
    public static final String MIDDLERIGHT = "MIDDLERIGHT";
    public static final String TOP = "TOP";
    public static final String BOTTOM = "BOTTOM";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public FormNavBarPosCodeListModel() {
        this.initAnnotation(FormNavBarPosCodeListModel.class);
        this.setUserData("IGNOREMODELDSL2");
        this.setUserData2("NavBarPos");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FormNavBarPosCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FormNavBarPosCodeListModel");
    }
}

