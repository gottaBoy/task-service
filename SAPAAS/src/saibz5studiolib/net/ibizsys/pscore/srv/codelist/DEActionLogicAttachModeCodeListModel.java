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

@CodeList(id="e629cde160bf9e6e974efd8abad90af6", name="\u5b9e\u4f53\u884c\u4e3a\u903b\u8f91\u9644\u52a0\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PREPARE", text="\u51c6\u5907", realtext="\u51c6\u5907", userdata="\u4f4d\u7f6e1\uff1a\u51c6\u5907\u884c\u4e3a\u6267\u884c\u73af\u5883"), @CodeItem(value="CHECK", text="\u68c0\u67e5", realtext="\u68c0\u67e5", userdata="\u4f4d\u7f6e2\uff1a\u68c0\u67e5\u4f20\u5165\u53c2\u6570\u6216\u73af\u5883\u662f\u5426\u6ee1\u8db3\u6267\u884c\u8981\u6c42"), @CodeItem(value="BEFORE", text="\u6267\u884c\u4e4b\u524d", realtext="\u6267\u884c\u4e4b\u524d", userdata="\u4f4d\u7f6e3\uff1a\u884c\u4e3a\u5b9e\u9645\u4f5c\u4e1a\u4e4b\u524d"), @CodeItem(value="AFTER", text="\u6267\u884c\u4e4b\u540e", realtext="\u6267\u884c\u4e4b\u540e", userdata="\u4f4d\u7f6e4\uff1a\u884c\u4e3a\u5b9e\u9645\u4f5c\u4e1a\u4e4b\u540e")})
public class DEActionLogicAttachModeCodeListModel
extends StaticCodeListModelBase {
    public static final String PREPARE = "PREPARE";
    public static final String CHECK = "CHECK";
    public static final String BEFORE = "BEFORE";
    public static final String AFTER = "AFTER";

    public DEActionLogicAttachModeCodeListModel() {
        this.initAnnotation(DEActionLogicAttachModeCodeListModel.class);
        this.setUserData("IGNOREMODELDSL2");
        this.setUserData2("DEActionLogicAttachMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionLogicAttachModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionLogicAttachModeCodeListModel");
    }
}

