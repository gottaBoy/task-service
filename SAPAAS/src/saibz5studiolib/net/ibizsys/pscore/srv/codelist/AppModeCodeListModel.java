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

@CodeList(id="a2a107ce0ee9c707173674e1f71ee7c8", name="\u5e94\u7528\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEFAULT", text="\u9ed8\u8ba4\u5e94\u7528", realtext="\u9ed8\u8ba4\u5e94\u7528", userdata="\u5e38\u89c4\u5e94\u7528"), @CodeItem(value="CLOUDHUBAPP", text="Cloud\u96c6\u6210\u5e94\u7528", realtext="Cloud\u96c6\u6210\u5e94\u7528", userdata="\u7528\u4e8e\u63d0\u4f9b\u591a\u5e94\u7528\u96c6\u6210\u5448\u73b0\u7684\u603b\u7ebf\u5e94\u7528"), @CodeItem(value="CLOUDHUBAPP_PLACEHOLDER", text="Cloud\u96c6\u6210\u5e94\u7528\uff08\u5360\u4f4d\uff09", realtext="Cloud\u96c6\u6210\u5e94\u7528\uff08\u5360\u4f4d\uff09", userdata="\u7528\u4e8e\u63d0\u4f9b\u591a\u5e94\u7528\u96c6\u6210\u5448\u73b0\u7684\u603b\u7ebf\u5360\u4f4d\u5e94\u7528\u3002\u5360\u4f4d\u5e94\u7528\u5c06\u88ab\u540c\u540d\u5b50\u5e94\u7528\u66ff\u6362\uff0c\u8fbe\u6210\u96c6\u6210\u5b50\u5e94\u7528\u5f62\u6210\u65b0\u5e94\u7528\u603b\u7ebf\u7684\u80fd\u529b"), @CodeItem(value="CLOUDHUBAPP_PROXY", text="Cloud\u96c6\u6210\u5e94\u7528\uff08\u4ee3\u7406\uff09", realtext="Cloud\u96c6\u6210\u5e94\u7528\uff08\u4ee3\u7406\uff09", userdata="\u7528\u4e8e\u63d0\u4f9b\u591a\u5e94\u7528\u96c6\u6210\u5448\u73b0\u7684\u603b\u7ebf\u4ee3\u7406\u5e94\u7528\u3002\u4ee3\u7406\u5e94\u7528\u4ec5\u52a0\u8f7d\u6307\u5b9a\u7684\u96c6\u6210\u5b50\u5e94\u7528"), @CodeItem(value="CLOUDHUBSUBAPP", text="Cloud\u96c6\u6210\u5b50\u5e94\u7528", realtext="Cloud\u96c6\u6210\u5b50\u5e94\u7528"), @CodeItem(value="CLOUDHUBSUBAPP_EMBEDED", text="Cloud\u96c6\u6210\u5b50\u5e94\u7528\uff08\u5d4c\u5165\uff09", realtext="Cloud\u96c6\u6210\u5b50\u5e94\u7528\uff08\u5d4c\u5165\uff09"), @CodeItem(value="WFAPP", text="\u5de5\u4f5c\u6d41\u5e94\u7528", realtext="\u5de5\u4f5c\u6d41\u5e94\u7528", userdata="\u4e13\u95e8\u7684\u5de5\u4f5c\u6d41\u529f\u80fd\u5e94\u7528\uff0c\u4e3a\u5916\u90e8\u5e94\u7528\u63d0\u4f9b\u6d41\u7a0b\u4ee3\u7406\u529f\u80fd"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class AppModeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFAULT = "DEFAULT";
    public static final String CLOUDHUBAPP = "CLOUDHUBAPP";
    public static final String CLOUDHUBAPP_PLACEHOLDER = "CLOUDHUBAPP_PLACEHOLDER";
    public static final String CLOUDHUBAPP_PROXY = "CLOUDHUBAPP_PROXY";
    public static final String CLOUDHUBSUBAPP = "CLOUDHUBSUBAPP";
    public static final String CLOUDHUBSUBAPP_EMBEDED = "CLOUDHUBSUBAPP_EMBEDED";
    public static final String WFAPP = "WFAPP";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public AppModeCodeListModel() {
        this.initAnnotation(AppModeCodeListModel.class);
        this.setUserData2("AppMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppModeCodeListModel");
    }
}

