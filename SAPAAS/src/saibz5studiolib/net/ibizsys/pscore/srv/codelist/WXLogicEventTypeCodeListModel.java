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

@CodeList(id="52872328e869562c7533c8f12121d608", name="\u5fae\u4fe1\u903b\u8f91\u4e8b\u4ef6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="app_in", text="\u8fdb\u5165\u5e94\u7528", realtext="\u8fdb\u5165\u5e94\u7528"), @CodeItem(value="location_in", text="\u4e0a\u62a5\u5730\u7406\u4f4d\u7f6e", realtext="\u4e0a\u62a5\u5730\u7406\u4f4d\u7f6e"), @CodeItem(value="asynctask_finish", text="\u5f02\u6b65\u4efb\u52a1\u5b8c\u6210\u4e8b\u4ef6\u63a8\u9001", realtext="\u5f02\u6b65\u4efb\u52a1\u5b8c\u6210\u4e8b\u4ef6\u63a8\u9001"), @CodeItem(value="menu_click", text="\u83dc\u5355\u4e8b\u4ef6", realtext="\u83dc\u5355\u4e8b\u4ef6"), @CodeItem(value="message_in", text="\u6d88\u606f\u8fdb\u5165", realtext="\u6d88\u606f\u8fdb\u5165")})
public class WXLogicEventTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String APP_IN = "app_in";
    public static final String LOCATION_IN = "location_in";
    public static final String ASYNCTASK_FINISH = "asynctask_finish";
    public static final String MENU_CLICK = "menu_click";
    public static final String MESSAGE_IN = "message_in";

    public WXLogicEventTypeCodeListModel() {
        this.initAnnotation(WXLogicEventTypeCodeListModel.class);
        this.setUserData2("WXLogicEventType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WXLogicEventTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WXLogicEventTypeCodeListModel");
    }
}

