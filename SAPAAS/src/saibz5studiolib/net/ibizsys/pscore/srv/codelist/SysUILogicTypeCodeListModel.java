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

@CodeList(id="c48934bf14b090fdebe97face9b7e02f", name="\u7cfb\u7edf\u754c\u9762\u903b\u8f91\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PREDEFINED", text="\u9884\u5b9a\u4e49", realtext="\u9884\u5b9a\u4e49", userdata="\u754c\u9762\u903b\u8f91\u4e3a\u9884\u5b9a\u4e49\u903b\u8f91\uff0c\u9700\u6307\u5b9a\u9884\u5b9a\u4e49\u7684\u903b\u8f91\u7c7b\u578b"), @CodeItem(value="DEUILOGIC", text="\u5b9e\u4f53\u754c\u9762\u903b\u8f91", realtext="\u5b9e\u4f53\u754c\u9762\u903b\u8f91", userdata="\u754c\u9762\u903b\u8f91\u4e3a\u5b9e\u4f53\u754c\u9762\u903b\u8f91\uff0c\u9700\u6307\u5b9a\u5b9e\u4f53\u7684\u754c\u9762\u5904\u7406\u903b\u8f91"), @CodeItem(value="PFPLUGIN", text="\u524d\u7aef\u63d2\u4ef6", realtext="\u524d\u7aef\u63d2\u4ef6", userdata="\u754c\u9762\u903b\u8f91\u4e3a\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u9700\u6307\u5b9a\u76f8\u5e94\u7684\u6a21\u677f\u63d2\u4ef6")})
public class SysUILogicTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String PREDEFINED = "PREDEFINED";
    public static final String DEUILOGIC = "DEUILOGIC";
    public static final String PFPLUGIN = "PFPLUGIN";

    public SysUILogicTypeCodeListModel() {
        this.initAnnotation(SysUILogicTypeCodeListModel.class);
        this.setUserData2("UILogicType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysUILogicTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysUILogicTypeCodeListModel");
    }
}

