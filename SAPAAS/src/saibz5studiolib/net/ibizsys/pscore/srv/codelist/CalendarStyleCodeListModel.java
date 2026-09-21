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

@CodeList(id="7936449aff0d6528661e4d38f616d5cb", name="\u65e5\u5386\u6837\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DAY", text="\u5929", realtext="\u5929"), @CodeItem(value="WEEK", text="\u5468", realtext="\u5468"), @CodeItem(value="MONTH", text="\u6708", realtext="\u6708"), @CodeItem(value="TIMELINE", text="\u65f6\u95f4\u8f74", realtext="\u65f6\u95f4\u8f74"), @CodeItem(value="WEEK_TIMELINE", text="\u5468\uff08\u590d\u5408\u65f6\u95f4\u8f74\uff09", realtext="\u5468\uff08\u590d\u5408\u65f6\u95f4\u8f74\uff09"), @CodeItem(value="MONTH_TIMELINE", text="\u6708\uff08\u590d\u5408\u65f6\u95f4\u8f74\uff09", realtext="\u6708\uff08\u590d\u5408\u65f6\u95f4\u8f74\uff09"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class CalendarStyleCodeListModel
extends StaticCodeListModelBase {
    public static final String DAY = "DAY";
    public static final String WEEK = "WEEK";
    public static final String MONTH = "MONTH";
    public static final String TIMELINE = "TIMELINE";
    public static final String WEEK_TIMELINE = "WEEK_TIMELINE";
    public static final String MONTH_TIMELINE = "MONTH_TIMELINE";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public CalendarStyleCodeListModel() {
        this.initAnnotation(CalendarStyleCodeListModel.class);
        this.setUserData2("CalendarStyle");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.CalendarStyleCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.CalendarStyleCodeListModel");
    }
}

