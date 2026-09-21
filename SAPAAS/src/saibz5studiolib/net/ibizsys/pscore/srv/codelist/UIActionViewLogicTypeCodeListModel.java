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

@CodeList(id="0FB97123-0AB9-4871-AD65-EAC95F1184F5", name="\u754c\u9762\u884c\u4e3a\u89e6\u53d1\u903b\u8f91\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEUILOGIC", text="\u5b9e\u4f53\u754c\u9762\u903b\u8f91", realtext="\u5b9e\u4f53\u754c\u9762\u903b\u8f91", userdata="\u5b9e\u4f53\u754c\u9762\u903b\u8f91"), @CodeItem(value="SYSVIEWLOGIC", text="\u7cfb\u7edf\u754c\u9762\u903b\u8f91", realtext="\u7cfb\u7edf\u754c\u9762\u903b\u8f91", userdata="\u7cfb\u7edf\u9884\u7f6e\u7684\u754c\u9762\u903b\u8f91")})
public class UIActionViewLogicTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEUILOGIC = "DEUILOGIC";
    public static final String SYSVIEWLOGIC = "SYSVIEWLOGIC";

    public UIActionViewLogicTypeCodeListModel() {
        this.initAnnotation(UIActionViewLogicTypeCodeListModel.class);
        this.setUserData2("UIActionTargetUILogic");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.UIActionViewLogicTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.UIActionViewLogicTypeCodeListModel");
    }
}

