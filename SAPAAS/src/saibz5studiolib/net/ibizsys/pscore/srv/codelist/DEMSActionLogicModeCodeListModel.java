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

@CodeList(id="c4dfe58a57479e2fa418df289a0d10eb", name="\u4e3b\u72b6\u6001\u884c\u4e3a\u63a7\u5236\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u542f\u7528", realtext="\u4e0d\u542f\u7528"), @CodeItem(value="1", text="\u540e\u53f0", realtext="\u540e\u53f0", userdata="\u5c06\u4e3b\u72b6\u6001\u884c\u4e3a\u63a7\u5236\u903b\u8f91\u9644\u52a0\u5230\u540e\u53f0\u4ee3\u7801\u4e0a\uff0c\u7531\u540e\u53f0\u8fdb\u884c\u9650\u5236"), @CodeItem(value="2", text="\u524d\u53f0", realtext="\u524d\u53f0", userdata="\u5c06\u4e3b\u72b6\u6001\u884c\u4e3a\u63a7\u5236\u903b\u8f91\u9644\u52a0\u5230\u524d\u7aef\u4ee3\u7801\u4e0a\uff0c\u7531\u524d\u7aef\u8fdb\u884c\u9650\u5236"), @CodeItem(value="3", text="\u540e\u53f0\u53ca\u524d\u53f0", realtext="\u540e\u53f0\u53ca\u524d\u53f0", userdata="\u5c06\u4e3b\u72b6\u6001\u884c\u4e3a\u63a7\u5236\u903b\u8f91\u540c\u65f6\u9644\u52a0\u5230\u540e\u53f0\u53ca\u524d\u7aef\u4ee3\u7801\u4e0a\uff0c\u540c\u65f6\u9650\u5236")})
public class DEMSActionLogicModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer BACKEND = 1;
    public static final int INT_BACKEND = 1;
    public static final Integer FRONT = 2;
    public static final int INT_FRONT = 2;
    public static final Integer BACKENDANDFRONT = 3;
    public static final int INT_BACKENDANDFRONT = 3;

    public DEMSActionLogicModeCodeListModel() {
        this.initAnnotation(DEMSActionLogicModeCodeListModel.class);
        this.setUserData2("DEMSActionLogicMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMSActionLogicModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMSActionLogicModeCodeListModel");
    }
}

