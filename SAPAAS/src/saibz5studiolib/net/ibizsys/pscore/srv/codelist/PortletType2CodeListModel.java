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

@CodeList(id="EAF78874-6C8B-452A-9912-BA751EE41BE5", name="\u4e91\u5e73\u53f0\u95e8\u6237\u90e8\u4ef6\u7c7b\u578b\uff08\u9759\u6001\uff0c\u65e0\u5e94\u7528\u83dc\u5355\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="LIST", text="\u5217\u8868", realtext="\u5217\u8868"), @CodeItem(value="CHART", text="\u56fe\u8868", realtext="\u56fe\u8868"), @CodeItem(value="HTML", text="\u7f51\u9875\u5730\u5740", realtext="\u7f51\u9875\u5730\u5740"), @CodeItem(value="VIEW", text="\u7cfb\u7edf\u89c6\u56fe", realtext="\u7cfb\u7edf\u89c6\u56fe"), @CodeItem(value="INFO", text="\u4fe1\u606f", realtext="\u4fe1\u606f"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49")})
public class PortletType2CodeListModel
extends StaticCodeListModelBase {
    public static final String LIST = "LIST";
    public static final String CHART = "CHART";
    public static final String HTML = "HTML";
    public static final String VIEW = "VIEW";
    public static final String INFO = "INFO";
    public static final String CUSTOM = "CUSTOM";

    public PortletType2CodeListModel() {
        this.initAnnotation(PortletType2CodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PortletType2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PortletType2CodeListModel");
    }
}

