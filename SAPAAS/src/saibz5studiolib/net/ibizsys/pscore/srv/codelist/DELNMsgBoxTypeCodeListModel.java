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

@CodeList(id="745F22AF-79C1-4071-87DD-46692C5131BA", name="\u6d88\u606f\u6846\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="INFO", text="\u5e38\u89c4", realtext="\u5e38\u89c4"), @CodeItem(value="QUESTION", text="\u8be2\u95ee", realtext="\u8be2\u95ee"), @CodeItem(value="WARNING", text="\u8b66\u544a", realtext="\u8b66\u544a"), @CodeItem(value="ERROR", text="\u9519\u8bef", realtext="\u9519\u8bef"), @CodeItem(value="PROMPT", text="\u63d0\u793a\u8f93\u5165", realtext="\u63d0\u793a\u8f93\u5165")})
public class DELNMsgBoxTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String INFO = "INFO";
    public static final String QUESTION = "QUESTION";
    public static final String WARNING = "WARNING";
    public static final String ERROR = "ERROR";
    public static final String PROMPT = "PROMPT";

    public DELNMsgBoxTypeCodeListModel() {
        this.initAnnotation(DELNMsgBoxTypeCodeListModel.class);
        this.setUserData2("DELNMsgBoxType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DELNMsgBoxTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DELNMsgBoxTypeCodeListModel");
    }
}

