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

@CodeList(id="BEEB8A9F-CE4E-446F-8C44-B7E281AEFBFE", name="\u6d41\u7a0b\u8d85\u65f6\u7c7b\u578b2", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="MINUTE", text="\u5206\u949f", realtext="\u5206\u949f"), @CodeItem(value="HOUR", text="\u5c0f\u65f6", realtext="\u5c0f\u65f6"), @CodeItem(value="DAY", text="\u5929", realtext="\u5929"), @CodeItem(value="WORKDAY", text="\u5de5\u4f5c\u65e5", realtext="\u5de5\u4f5c\u65e5"), @CodeItem(value="DATETIME", text="\u6307\u5b9a\u65e5\u671f\u65f6\u95f4", realtext="\u6307\u5b9a\u65e5\u671f\u65f6\u95f4")})
public class WFTimeoutType2CodeListModel
extends StaticCodeListModelBase {
    public static final String MINUTE = "MINUTE";
    public static final String HOUR = "HOUR";
    public static final String DAY = "DAY";
    public static final String WORKDAY = "WORKDAY";
    public static final String DATETIME = "DATETIME";

    public WFTimeoutType2CodeListModel() {
        this.initAnnotation(WFTimeoutType2CodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WFTimeoutType2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WFTimeoutType2CodeListModel");
    }
}

