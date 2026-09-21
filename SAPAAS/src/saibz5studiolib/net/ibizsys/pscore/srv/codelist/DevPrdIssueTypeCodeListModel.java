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

@CodeList(id="d3e318934c56ad57e05645adc265ecce", name="\u5f00\u53d1\u4ea7\u54c1\u95ee\u9898\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="100", text="\u754c\u9762\u95ee\u9898", realtext="\u754c\u9762\u95ee\u9898"), @CodeItem(value="500", text="\u5904\u7406\u9519\u8bef", realtext="\u5904\u7406\u9519\u8bef"), @CodeItem(value="900", text="\u5173\u952e\u9519\u8bef", realtext="\u5173\u952e\u9519\u8bef")})
public class DevPrdIssueTypeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer UI = 100;
    public static final int INT_UI = 100;
    public static final Integer LOGIC = 500;
    public static final int INT_LOGIC = 500;
    public static final Integer CRITICLE = 900;
    public static final int INT_CRITICLE = 900;

    public DevPrdIssueTypeCodeListModel() {
        this.initAnnotation(DevPrdIssueTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevPrdIssueTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevPrdIssueTypeCodeListModel");
    }
}

