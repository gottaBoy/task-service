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

@CodeList(id="FC0DCF38-99FE-4AF2-A0E7-23E3A7316B84", name="\u5e94\u7528\u903b\u8f91\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TIMER", text="\u5b9a\u65f6\u5668\u89e6\u53d1", realtext="\u5b9a\u65f6\u5668\u89e6\u53d1", userdata="\u5b9a\u65f6\u5668\u5b9a\u65f6\u89e6\u53d1\u903b\u8f91\uff0c\u9700\u6307\u5b9a\u5b9a\u65f6\u5668\u65f6\u95f4\u95f4\u9694"), @CodeItem(value="APPEVENT", text="\u5e94\u7528\u4e8b\u4ef6\u89e6\u53d1", realtext="\u5e94\u7528\u4e8b\u4ef6\u89e6\u53d1", userdata="\u5e94\u7528\u4e8b\u4ef6\u89e6\u53d1\u903b\u8f91\uff0c\u9700\u6307\u5b9a\u4e8b\u4ef6\u540d\u79f0\uff0c\u5982\u521d\u59cb\u5316\u3001\u52a0\u8f7d\u7b49"), @CodeItem(value="CUSTOM", text="\u53ea\u6302\u63a5\uff08\u5916\u90e8\u8c03\u7528\uff09", realtext="\u53ea\u6302\u63a5\uff08\u5916\u90e8\u8c03\u7528\uff09", userdata="\u4ec5\u53d1\u5e03\u903b\u8f91\uff0c\u4e0d\u6302\u63a5\u4efb\u4f55\u4e8b\u4ef6\uff0c\u7531\u5176\u5b83\u903b\u8f91\u9a71\u52a8\u6216\u81ea\u5b9a\u4e49\u4ee3\u7801\u8c03\u7528")})
public class AppLogicTriggerCodeListModel
extends StaticCodeListModelBase {
    public static final String TIMER = "TIMER";
    public static final String APPEVENT = "APPEVENT";
    public static final String CUSTOM = "CUSTOM";

    public AppLogicTriggerCodeListModel() {
        this.initAnnotation(AppLogicTriggerCodeListModel.class);
        this.setUserData2("AppLogicTrigger");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppLogicTriggerCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppLogicTriggerCodeListModel");
    }
}

