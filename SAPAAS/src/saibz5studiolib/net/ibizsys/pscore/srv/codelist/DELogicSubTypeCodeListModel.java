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

@CodeList(id="1d4dfa1aa8a24f80c1f86c4dd35c39a1", name="\u5b9e\u4f53\u5904\u903b\u8f91\u5b50\u7c7b", type="STATIC", userscope=false, emptytext="\uff08\u65e0\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0", realtext="\u65e0"), @CodeItem(value="DEFIELD", text="\u5c5e\u6027\u903b\u8f91", realtext="\u5c5e\u6027\u903b\u8f91", userdata="\u9762\u5411\u5c5e\u6027\u7684\u5904\u7406\u903b\u8f91\u5b50\u7c7b\u578b\uff0c"), @CodeItem(value="DEOPPRIV", text="\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6\u8ba1\u7b97\u903b\u8f91", realtext="\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6\u8ba1\u7b97\u903b\u8f91", userdata="\u8ba1\u7b97\u4f20\u5165\u6570\u636e\u7684\u64cd\u4f5c\u6807\u8bc6\uff0c\u8fd4\u56deEntity\u6216Map"), @CodeItem(value="ATTACHTODEACTION", text="\u9644\u52a0\u5230\u884c\u4e3a\uff08\u8fd0\u884c\u65f6\u652f\u6301\uff09", realtext="\u9644\u52a0\u5230\u884c\u4e3a\uff08\u8fd0\u884c\u65f6\u652f\u6301\uff09", userdata="\u9644\u52a0\u5230\u6307\u5b9a\u884c\u4e3a"), @CodeItem(value="ATTACHTODEDATASET", text="\u9644\u52a0\u5230\u6570\u636e\u96c6\uff08\u8fd0\u884c\u65f6\u652f\u6301\uff09", realtext="\u9644\u52a0\u5230\u6570\u636e\u96c6\uff08\u8fd0\u884c\u65f6\u652f\u6301\uff09", userdata="\u9644\u52a0\u5230\u6307\u5b9a\u6570\u636e\u96c6"), @CodeItem(value="WEBHOOK", text="WebHook\uff08\u8fd0\u884c\u65f6\u652f\u6301\uff09", realtext="WebHook\uff08\u8fd0\u884c\u65f6\u652f\u6301\uff09", userdata="WEB\u94a9\u5b50"), @CodeItem(value="TIMERTASK", text="\u5b9a\u65f6\u4f5c\u4e1a\uff08\u8fd0\u884c\u65f6\u652f\u6301\uff09", realtext="\u5b9a\u65f6\u4f5c\u4e1a\uff08\u8fd0\u884c\u65f6\u652f\u6301\uff09", userdata="\u540e\u53f0\u5b9a\u65f6\u4f5c\u4e1a"), @CodeItem(value="EVENTHOOK", text="\u4e8b\u4ef6\u5904\u7406\uff08\u8fd0\u884c\u65f6\u652f\u6301\uff09", realtext="\u4e8b\u4ef6\u5904\u7406\uff08\u8fd0\u884c\u65f6\u652f\u6301\uff09"), @CodeItem(value="FIELDCHANGEHOOK", text="\u5c5e\u6027\u53d8\u5316\u5904\u7406\uff08\u8fd0\u884c\u65f6\u652f\u6301\uff09", realtext="\u5c5e\u6027\u53d8\u5316\u5904\u7406\uff08\u8fd0\u884c\u65f6\u652f\u6301\uff09"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class DELogicSubTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String DEFIELD = "DEFIELD";
    public static final String DEOPPRIV = "DEOPPRIV";
    public static final String ATTACHTODEACTION = "ATTACHTODEACTION";
    public static final String ATTACHTODEDATASET = "ATTACHTODEDATASET";
    public static final String WEBHOOK = "WEBHOOK";
    public static final String TIMERTASK = "TIMERTASK";
    public static final String EVENTHOOK = "EVENTHOOK";
    public static final String FIELDCHANGEHOOK = "FIELDCHANGEHOOK";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public DELogicSubTypeCodeListModel() {
        this.initAnnotation(DELogicSubTypeCodeListModel.class);
        this.setUserData("IGNOREMODELDSL2");
        this.setUserData2("LogicSubType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicSubTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicSubTypeCodeListModel");
    }
}

