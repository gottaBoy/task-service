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

@CodeList(id="5b06cc64bd55856e9d53d8dac5a03ec5", name="\u6545\u4e8b\u677f\u9879\u76ee\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="APPVIEW", text="\u5e94\u7528\u89c6\u56fe", realtext="\u5e94\u7528\u89c6\u56fe", userdata="\u9879\u76ee\u6307\u5411\u5e94\u7528\u89c6\u56fe"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class AppStoryBoardItemTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String APPVIEW = "APPVIEW";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public AppStoryBoardItemTypeCodeListModel() {
        this.initAnnotation(AppStoryBoardItemTypeCodeListModel.class);
        this.setUserData2("AppStoryBoardItemType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppStoryBoardItemTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppStoryBoardItemTypeCodeListModel");
    }
}

