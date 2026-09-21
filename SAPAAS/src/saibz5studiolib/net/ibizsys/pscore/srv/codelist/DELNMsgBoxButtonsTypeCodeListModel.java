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

@CodeList(id="F1A94D87-FAD8-4164-A31A-23D7B01BB927", name="\u6d88\u606f\u6846\u6309\u94ae\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="YESNO", text="\u662f\u3001\u5426", realtext="\u662f\u3001\u5426"), @CodeItem(value="YESNOCANCEL", text="\u662f\u3001\u5426\u3001\u53d6\u6d88", realtext="\u662f\u3001\u5426\u3001\u53d6\u6d88"), @CodeItem(value="OK", text="\u786e\u5b9a", realtext="\u786e\u5b9a"), @CodeItem(value="OKCANCEL", text="\u786e\u5b9a\u3001\u53d6\u6d88", realtext="\u786e\u5b9a\u3001\u53d6\u6d88")})
public class DELNMsgBoxButtonsTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String YESNO = "YESNO";
    public static final String YESNOCANCEL = "YESNOCANCEL";
    public static final String OK = "OK";
    public static final String OKCANCEL = "OKCANCEL";

    public DELNMsgBoxButtonsTypeCodeListModel() {
        this.initAnnotation(DELNMsgBoxButtonsTypeCodeListModel.class);
        this.setUserData2("DELNMsgBoxButtonsType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DELNMsgBoxButtonsTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DELNMsgBoxButtonsTypeCodeListModel");
    }
}

