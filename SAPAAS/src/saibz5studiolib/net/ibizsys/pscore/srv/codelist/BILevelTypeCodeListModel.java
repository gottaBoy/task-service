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

@CodeList(id="38a4e2baca2984afa9e6f00602fae612", name="\u5206\u6790\u7ef4\u5ea6\u4f53\u7cfb\u5c42\u7ea7\u7c7b\u578b", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="COMMON", text="\u5e38\u89c4", realtext="\u5e38\u89c4"), @CodeItem(value="TIME_YEARS", text="\u65f6\u95f4\uff08\u5e74\uff09", realtext="\u65f6\u95f4\uff08\u5e74\uff09"), @CodeItem(value="TIME_HALFYEARS", text="\u65f6\u95f4\uff08\u534a\u5e74\uff09", realtext="\u65f6\u95f4\uff08\u534a\u5e74\uff09"), @CodeItem(value="TIME_QUARTERS", text="\u65f6\u95f4\uff08\u5b63\u5ea6\uff09", realtext="\u65f6\u95f4\uff08\u5b63\u5ea6\uff09"), @CodeItem(value="TIME_MONTHS", text="\u65f6\u95f4\uff08\u6708\u4efd\uff09", realtext="\u65f6\u95f4\uff08\u6708\u4efd\uff09"), @CodeItem(value="TIME_WEEKS", text="\u65f6\u95f4\uff08\u5468\uff09", realtext="\u65f6\u95f4\uff08\u5468\uff09"), @CodeItem(value="TIME_DAYS", text="\u65f6\u95f4\uff08\u5929\uff09", realtext="\u65f6\u95f4\uff08\u5929\uff09"), @CodeItem(value="TIME_HOURS", text="\u65f6\u95f4\uff08\u5c0f\u65f6\uff09", realtext="\u65f6\u95f4\uff08\u5c0f\u65f6\uff09"), @CodeItem(value="TIME_MINUTES", text="\u65f6\u95f4\uff08\u5206\u949f\uff09", realtext="\u65f6\u95f4\uff08\u5206\u949f\uff09")})
public class BILevelTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String COMMON = "COMMON";
    public static final String TIME_YEARS = "TIME_YEARS";
    public static final String TIME_HALFYEARS = "TIME_HALFYEARS";
    public static final String TIME_QUARTERS = "TIME_QUARTERS";
    public static final String TIME_MONTHS = "TIME_MONTHS";
    public static final String TIME_WEEKS = "TIME_WEEKS";
    public static final String TIME_DAYS = "TIME_DAYS";
    public static final String TIME_HOURS = "TIME_HOURS";
    public static final String TIME_MINUTES = "TIME_MINUTES";

    public BILevelTypeCodeListModel() {
        this.initAnnotation(BILevelTypeCodeListModel.class);
        this.setUserData2("BILevelType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.BILevelTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.BILevelTypeCodeListModel");
    }
}

