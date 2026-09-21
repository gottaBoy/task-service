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

@CodeList(id="12f82bea66fc2962aaed256e7dfb80a1", name="\u6d41\u7a0b\u5904\u7406\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="START", text="\u5f00\u59cb", realtext="\u5f00\u59cb", iconpath="pswfprocesstype/icon_start@{0}2.png", iconpathx="pswfprocesstype/icon_start@{0}2.png", userdata="\u6d41\u7a0b\u7684\u5f00\u59cb\u5904\u7406\u8282\u70b9\uff0c\u4e00\u4e2a\u6d41\u7a0b\u53ea\u5141\u8bb8\u62e5\u6709\u4e00\u4e2a\u5f00\u59cb\u5904\u7406\u8282\u70b9\uff0c\u6d41\u7a0b\u542f\u52a8\u65f6\u5c06\u9ed8\u8ba4\u8fdb\u5165\u8be5\u8282\u70b9"), @CodeItem(value="END", text="\u7ed3\u675f", realtext="\u7ed3\u675f", iconpath="pswfprocesstype/icon_end@{0}2.png", iconpathx="pswfprocesstype/icon_end@{0}2.png", userdata="\u6d41\u7a0b\u7684\u7ed3\u675f\u5904\u7406\u8282\u70b9\uff0c\u4e00\u4e2a\u6d41\u7a0b\u5141\u8bb8\u62e5\u6709\u591a\u4e2a\u5f00\u59cb\u5904\u7406\u8282\u70b9\uff0c\u8fdb\u5165\u8be5\u8282\u70b9\u610f\u5473\u6d41\u7a0b\u7ed3\u675f"), @CodeItem(value="PROCESS", text="\u5e38\u89c4\u5904\u7406", realtext="\u5e38\u89c4\u5904\u7406", iconpath="pswfprocesstype/icon_process.png", iconpathx="pswfprocesstype/icon_process@{0}x.png", userdata="\u6d41\u7a0b\u7684\u529f\u80fd\u5904\u7406\u8282\u70b9\uff0c\u914d\u7f6e\u8c03\u7528\u7684\u5b9e\u4f53\u884c\u4e3a\uff0c\u518d\u901a\u8fc7\u5b9e\u4f53\u884c\u4e3a\u5b8c\u6210\u76f8\u5e94\u7684\u64cd\u4f5c\u3002\u72ec\u7acb\u8fd0\u884c\u7684\u5de5\u4f5c\u6d41\u5f15\u64ce\u5c06\u4f1a\u56de\u8c03\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u7684\u65b9\u6cd5\u5b8c\u6210\u529f\u80fd"), @CodeItem(value="INTERACTIVE", text="\u4ea4\u4e92\u5904\u7406", realtext="\u4ea4\u4e92\u5904\u7406", iconpath="pswfprocesstype/icon_interactive.png", iconpathx="pswfprocesstype/icon_interactive@{0}x.png", userdata="\u6d41\u7a0b\u4e2d\u7684\u7528\u6237\u4ea4\u4e92\u5904\u7406\u8282\u70b9\uff0c\u8fdb\u5165\u8be5\u8282\u70b9\u65f6\u6d41\u7a0b\u6302\u8d77\uff0c\u9700\u6ee1\u8db3\u76f8\u5e94\u7684\u6761\u4ef6\uff08\u7528\u6237\u64cd\u4f5c\u5b8c\u6210\uff09\u624d\u8fdb\u5165\u540e\u7eed\u5904\u7406"), @CodeItem(value="EMBED", text="\u5d4c\u5957\u5b50\u6d41\u7a0b", realtext="\u5d4c\u5957\u5b50\u6d41\u7a0b", iconpath="pswfprocesstype/icon_embed.png", iconpathx="pswfprocesstype/icon_embed@{0}x.png", userdata="\u6d41\u7a0b\u4e2d\u7684\u5b50\u6d41\u7a0b\u4ea4\u4e92\u5904\u7406\u8282\u70b9\uff0c\u8fdb\u5165\u8be5\u8282\u70b9\u65f6\u6d41\u7a0b\u6302\u8d77\uff0c\u9700\u6ee1\u8db3\u76f8\u5e94\u7684\u6761\u4ef6\uff08\u5b50\u6d41\u7a0b\u5b8c\u6210\uff09\u624d\u8fdb\u5165\u540e\u7eed\u5904\u7406"), @CodeItem(value="PARALLELGATEWAY", text="\u5e76\u884c\u7f51\u5173", realtext="\u5e76\u884c\u7f51\u5173"), @CodeItem(value="EXCLUSIVEGATEWAY", text="\u6392\u5b83\u7f51\u5173", realtext="\u6392\u5b83\u7f51\u5173"), @CodeItem(value="INCLUSIVEGATEWAY", text="\u5305\u5bb9\u7f51\u5173", realtext="\u5305\u5bb9\u7f51\u5173"), @CodeItem(value="TIMEREVENT", text="\u5b9a\u65f6\u89e6\u53d1", realtext="\u5b9a\u65f6\u89e6\u53d1"), @CodeItem(value="CALLORGACTIVITY", text="\u8c03\u7528\u7ec4\u7ec7\u6d41\u7a0b", realtext="\u8c03\u7528\u7ec4\u7ec7\u6d41\u7a0b")})
public class WFProcessTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String START = "START";
    public static final String END = "END";
    public static final String PROCESS = "PROCESS";
    public static final String INTERACTIVE = "INTERACTIVE";
    public static final String EMBED = "EMBED";
    public static final String PARALLELGATEWAY = "PARALLELGATEWAY";
    public static final String EXCLUSIVEGATEWAY = "EXCLUSIVEGATEWAY";
    public static final String INCLUSIVEGATEWAY = "INCLUSIVEGATEWAY";
    public static final String TIMEREVENT = "TIMEREVENT";
    public static final String CALLORGACTIVITY = "CALLORGACTIVITY";

    public WFProcessTypeCodeListModel() {
        this.initAnnotation(WFProcessTypeCodeListModel.class);
        this.setUserData2("WFProcessType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WFProcessTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WFProcessTypeCodeListModel");
    }
}

