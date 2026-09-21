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

@CodeList(id="d85d40ea0cd39d21c18212637f8a2f18", name="\u5217\u8868\u9879\u4ee3\u7801\u8868\u8f6c\u6362\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="NONE", text="\u76f4\u63a5\u503c", realtext="\u76f4\u63a5\u503c", userdata="\u4e0d\u505a\u4efb\u4f55\u8f6c\u6362\uff0c\u754c\u9762\u4e0a\u76f4\u63a5\u8f93\u51fa\u6e90\u503c"), @CodeItem(value="FRONT", text="\u7ed8\u5236\u65f6\u8f6c\u6362\uff08\u524d\u53f0\uff09", realtext="\u7ed8\u5236\u65f6\u8f6c\u6362\uff08\u524d\u53f0\uff09", userdata="\u4ee3\u7801\u8868\u5728\u7ed8\u5236\u65f6\u8fdb\u884c\u8f6c\u6362\uff0c\u63a7\u5236\u5668\u8f93\u51fa\u6e90\u503c"), @CodeItem(value="BACKEND", text="\u63a7\u5236\u5668\u8f6c\u6362\uff08\u540e\u53f0\uff09", realtext="\u63a7\u5236\u5668\u8f6c\u6362\uff08\u540e\u53f0\uff09", userdata="\u4ee3\u7801\u8868\u5728\u63a7\u5236\u5668\u8fdb\u884c\u8f6c\u6362\uff0c\u7ed8\u5236\u65f6\u76f4\u63a5\u8f93\u51fa")})
public class CLConvertModesCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String FRONT = "FRONT";
    public static final String BACKEND = "BACKEND";

    public CLConvertModesCodeListModel() {
        this.initAnnotation(CLConvertModesCodeListModel.class);
        this.setUserData2("CodeListConvertMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.CLConvertModesCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.CLConvertModesCodeListModel");
    }
}

