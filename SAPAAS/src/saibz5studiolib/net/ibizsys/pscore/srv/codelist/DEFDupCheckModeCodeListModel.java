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

@CodeList(id="47113c47f930776ff6848126f2aabc1b", name="\u5c5e\u6027\u91cd\u590d\u503c\u68c0\u67e5\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u4e0d\u68c0\u67e5", realtext="\u4e0d\u68c0\u67e5"), @CodeItem(value="ALL", text="\u5168\u90e8\u68c0\u67e5", realtext="\u5168\u90e8\u68c0\u67e5"), @CodeItem(value="NOTNULL", text="\u975e\u7a7a\u68c0\u67e5", realtext="\u975e\u7a7a\u68c0\u67e5"), @CodeItem(value="CHECKVALUES", text="\u6307\u5b9a\u503c\u8303\u56f4", realtext="\u6307\u5b9a\u503c\u8303\u56f4"), @CodeItem(value="EXCLUDEVALUES", text="\u6392\u9664\u503c\u8303\u56f4", realtext="\u6392\u9664\u503c\u8303\u56f4")})
public class DEFDupCheckModeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String ALL = "ALL";
    public static final String NOTNULL = "NOTNULL";
    public static final String CHECKVALUES = "CHECKVALUES";
    public static final String EXCLUDEVALUES = "EXCLUDEVALUES";

    public DEFDupCheckModeCodeListModel() {
        this.initAnnotation(DEFDupCheckModeCodeListModel.class);
        this.setUserData2("DEFDupCheckMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFDupCheckModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFDupCheckModeCodeListModel");
    }
}

