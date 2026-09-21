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

@CodeList(id="BB6789CE-E32F-46B6-B504-A247E5D5D5E5", name="\u90e8\u4ef6\u903b\u8f91\u76ee\u6807\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="APPDEUILOGIC", text="\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u903b\u8f91", realtext="\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u903b\u8f91"), @CodeItem(value="APPDEUIACTION", text="\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u884c\u4e3a", realtext="\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u884c\u4e3a"), @CodeItem(value="APPUILOGIC", text="\u5e94\u7528\u9884\u7f6e\u754c\u9762\u903b\u8f91", realtext="\u5e94\u7528\u9884\u7f6e\u754c\u9762\u903b\u8f91"), @CodeItem(value="APPVIEWLOGIC", text="\u89c6\u56fe\u903b\u8f91", realtext="\u89c6\u56fe\u903b\u8f91"), @CodeItem(value="APPVIEWENGINE", text="\u89c6\u56fe\u5f15\u64ce", realtext="\u89c6\u56fe\u5f15\u64ce"), @CodeItem(value="PFPLUGIN", text="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", realtext="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", userdata="\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u5b9a\u4e49\u7684\u76f4\u63a5\u4ee3\u7801\u903b\u8f91"), @CodeItem(value="SCRIPT", text="\u811a\u672c\u4ee3\u7801", realtext="\u811a\u672c\u4ee3\u7801", userdata="\u8fd0\u884c\u65f6\u89e3\u91ca\u6267\u884c\u7684\u811a\u672c\u4ee3\u7801"), @CodeItem(value="DEUILOGIC", text="\u5b9e\u4f53\u754c\u9762\u903b\u8f91\uff08\u517c\u5bb9\uff09", realtext="\u5b9e\u4f53\u754c\u9762\u903b\u8f91\uff08\u517c\u5bb9\uff09", userdata="\u5b9e\u4f53\u5b9a\u4e49\u7684\u754c\u9762\u5904\u7406\u903b\u8f91"), @CodeItem(value="DEUIACTION", text="\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\uff08\u517c\u5bb9\uff09", realtext="\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\uff08\u517c\u5bb9\uff09", userdata="\u5b9e\u4f53\u5b9a\u4e49\u7684\u754c\u9762\u884c\u4e3a\u903b\u8f91"), @CodeItem(value="SYSVIEWLOGIC", text="\u7cfb\u7edf\u9884\u7f6e\u754c\u9762\u903b\u8f91\uff08\u517c\u5bb9\uff09", realtext="\u7cfb\u7edf\u9884\u7f6e\u754c\u9762\u903b\u8f91\uff08\u517c\u5bb9\uff09", userdata="\u7cfb\u7edf\u5b9a\u4e49\u7684\u754c\u9762\u5904\u7406\u903b\u8f91")})
public class ControlLogicTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String APPDEUILOGIC = "APPDEUILOGIC";
    public static final String APPDEUIACTION = "APPDEUIACTION";
    public static final String APPUILOGIC = "APPUILOGIC";
    public static final String APPVIEWLOGIC = "APPVIEWLOGIC";
    public static final String APPVIEWENGINE = "APPVIEWENGINE";
    public static final String PFPLUGIN = "PFPLUGIN";
    public static final String SCRIPT = "SCRIPT";
    public static final String DEUILOGIC = "DEUILOGIC";
    public static final String DEUIACTION = "DEUIACTION";
    public static final String SYSVIEWLOGIC = "SYSVIEWLOGIC";

    public ControlLogicTypeCodeListModel() {
        this.initAnnotation(ControlLogicTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ControlLogicTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ControlLogicTypeCodeListModel");
    }
}

