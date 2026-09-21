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

@CodeList(id="000D2D6B-0786-48A8-A58A-2AD8997EAB23", name="\u5de5\u5177\u680f\u6309\u94ae\u884c\u4e3a\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="UIACTION", text="\u754c\u9762\u884c\u4e3a", realtext="\u754c\u9762\u884c\u4e3a", userdata="\u6309\u94ae\u70b9\u51fb\u89e6\u53d1\u754c\u9762\u884c\u4e3a\u5904\u7406"), @CodeItem(value="UILOGIC", text="\u754c\u9762\u903b\u8f91", realtext="\u754c\u9762\u903b\u8f91"), @CodeItem(value="OPENVIEW", text="\u6253\u5f00\u5e94\u7528\u89c6\u56fe", realtext="\u6253\u5f00\u5e94\u7528\u89c6\u56fe"), @CodeItem(value="OPENDEVIEW", text="\u6253\u5f00\u5b9e\u4f53\u89c6\u56fe", realtext="\u6253\u5f00\u5b9e\u4f53\u89c6\u56fe"), @CodeItem(value="OPENSYSPDTVIEW", text="\u6253\u5f00\u7cfb\u7edf\u9884\u7f6e\u89c6\u56fe", realtext="\u6253\u5f00\u7cfb\u7edf\u9884\u7f6e\u89c6\u56fe"), @CodeItem(value="OPENHTMLPAGE", text="\u6253\u5f00\u94fe\u63a5", realtext="\u6253\u5f00\u94fe\u63a5"), @CodeItem(value="DATA_CREATEOBJECT", text="\u5efa\u7acb\u6570\u636e", realtext="\u5efa\u7acb\u6570\u636e"), @CodeItem(value="DATA_SAVECHANGES", text="\u4fdd\u5b58\u53d8\u66f4", realtext="\u4fdd\u5b58\u53d8\u66f4"), @CodeItem(value="DATA_CANCELCHANGES", text="\u53d6\u6d88\u53d8\u66f4", realtext="\u53d6\u6d88\u53d8\u66f4"), @CodeItem(value="DATA_REMOVEOBJECT", text="\u5220\u9664\u6570\u636e", realtext="\u5220\u9664\u6570\u636e"), @CodeItem(value="DATA_SYNCHRONIZE", text="\u540c\u6b65\u6570\u636e", realtext="\u540c\u6b65\u6570\u636e"), @CodeItem(value="APP_LOGIN", text="\u767b\u5f55\u64cd\u4f5c", realtext="\u767b\u5f55\u64cd\u4f5c"), @CodeItem(value="APP_LOGOUT", text="\u767b\u51fa\u64cd\u4f5c", realtext="\u767b\u51fa\u64cd\u4f5c"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49\u4ee3\u7801", realtext="\u81ea\u5b9a\u4e49\u4ee3\u7801")})
public class ToolbarButtonActionTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String UIACTION = "UIACTION";
    public static final String UILOGIC = "UILOGIC";
    public static final String OPENVIEW = "OPENVIEW";
    public static final String OPENDEVIEW = "OPENDEVIEW";
    public static final String OPENSYSPDTVIEW = "OPENSYSPDTVIEW";
    public static final String OPENHTMLPAGE = "OPENHTMLPAGE";
    public static final String DATA_CREATEOBJECT = "DATA_CREATEOBJECT";
    public static final String DATA_SAVECHANGES = "DATA_SAVECHANGES";
    public static final String DATA_CANCELCHANGES = "DATA_CANCELCHANGES";
    public static final String DATA_REMOVEOBJECT = "DATA_REMOVEOBJECT";
    public static final String DATA_SYNCHRONIZE = "DATA_SYNCHRONIZE";
    public static final String APP_LOGIN = "APP_LOGIN";
    public static final String APP_LOGOUT = "APP_LOGOUT";
    public static final String CUSTOM = "CUSTOM";

    public ToolbarButtonActionTypeCodeListModel() {
        this.initAnnotation(ToolbarButtonActionTypeCodeListModel.class);
        this.setUserData2("ToolbarButtonActionType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ToolbarButtonActionTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ToolbarButtonActionTypeCodeListModel");
    }
}

