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

@CodeList(id="0e5febfd96f41326067515c58b3e44c7", name="\u6d41\u7a0b\u8d85\u65f6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="MINUTE", text="\u5206\u949f", realtext="\u5206\u949f"), @CodeItem(value="HOUR", text="\u5c0f\u65f6", realtext="\u5c0f\u65f6"), @CodeItem(value="DAY", text="\u5929", realtext="\u5929", userdata="\u8d85\u65f6\u5355\u4f4d\u4e3a\u81ea\u7136\u65e5"), @CodeItem(value="WORKDAY", text="\u5de5\u4f5c\u65e5", realtext="\u5de5\u4f5c\u65e5", userdata="\u8d85\u65f6\u5355\u4f4d\u4e3a\u5de5\u4f5c\u65e5\uff0c\u9700\u989d\u5916\u6307\u5b9a\u5de5\u4f5c\u65e5\u89c4\u5219")})
public class WFTimeoutTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String MINUTE = "MINUTE";
    public static final String HOUR = "HOUR";
    public static final String DAY = "DAY";
    public static final String WORKDAY = "WORKDAY";

    public WFTimeoutTypeCodeListModel() {
        this.initAnnotation(WFTimeoutTypeCodeListModel.class);
        this.setUserData2("WFTimeoutType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WFTimeoutTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WFTimeoutTypeCodeListModel");
    }
}

