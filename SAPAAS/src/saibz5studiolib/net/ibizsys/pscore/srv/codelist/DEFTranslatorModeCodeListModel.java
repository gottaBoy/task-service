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

@CodeList(id="eb5d3107c8140f283d197705579f81d5", name="\u5c5e\u6027\u503c\u8f6c\u6362\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0", realtext="\u65e0"), @CodeItem(value="DIGEST", text="\u5bc6\u7801", realtext="\u5bc6\u7801"), @CodeItem(value="ENCRYPT", text="\u52a0\u5bc6", realtext="\u52a0\u5bc6"), @CodeItem(value="TRANSLATE", text="\u8f6c\u6362\u5668\u5904\u7406", realtext="\u8f6c\u6362\u5668\u5904\u7406"), @CodeItem(value="TRANSLATE2", text="\u8f6c\u6362\u5668\u5904\u7406\uff08\u53cc\u5411\uff09", realtext="\u8f6c\u6362\u5668\u5904\u7406\uff08\u53cc\u5411\uff09"), @CodeItem(value="UCASE", text="\u8f6c\u6362\u4e3a\u5927\u5199", realtext="\u8f6c\u6362\u4e3a\u5927\u5199"), @CodeItem(value="LCASE", text="\u8f6c\u6362\u4e3a\u5c0f\u5199", realtext="\u8f6c\u6362\u4e3a\u5c0f\u5199"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class DEFTranslatorModeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String DIGEST = "DIGEST";
    public static final String ENCRYPT = "ENCRYPT";
    public static final String TRANSLATE = "TRANSLATE";
    public static final String TRANSLATE2 = "TRANSLATE2";
    public static final String UCASE = "UCASE";
    public static final String LCASE = "LCASE";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public DEFTranslatorModeCodeListModel() {
        this.initAnnotation(DEFTranslatorModeCodeListModel.class);
        this.setUserData2("DEFTranslatorMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFTranslatorModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFTranslatorModeCodeListModel");
    }
}

