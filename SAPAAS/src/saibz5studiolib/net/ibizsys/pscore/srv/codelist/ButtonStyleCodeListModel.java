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

@CodeList(id="D6839A13-1C22-41F1-9446-84C5EB1D8D2F", name="\u6309\u94ae\u6837\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEFAULT", text="\u9ed8\u8ba4", realtext="\u9ed8\u8ba4"), @CodeItem(value="INVERSE", text="\u53cd\u5411", realtext="\u53cd\u5411"), @CodeItem(value="PRIMARY", text="\u4e3b\u8981", realtext="\u4e3b\u8981"), @CodeItem(value="INFO", text="\u4fe1\u606f", realtext="\u4fe1\u606f"), @CodeItem(value="SUCCESS", text="\u6210\u529f", realtext="\u6210\u529f"), @CodeItem(value="WARNING", text="\u8b66\u544a", realtext="\u8b66\u544a"), @CodeItem(value="DANGER", text="\u5371\u9669", realtext="\u5371\u9669"), @CodeItem(value="STYLE2", text="\u6837\u5f0f2", realtext="\u6837\u5f0f2"), @CodeItem(value="STYLE3", text="\u6837\u5f0f3", realtext="\u6837\u5f0f3"), @CodeItem(value="STYLE4", text="\u6837\u5f0f4", realtext="\u6837\u5f0f4")})
public class ButtonStyleCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFAULT = "DEFAULT";
    public static final String INVERSE = "INVERSE";
    public static final String PRIMARY = "PRIMARY";
    public static final String INFO = "INFO";
    public static final String SUCCESS = "SUCCESS";
    public static final String WARNING = "WARNING";
    public static final String DANGER = "DANGER";
    public static final String STYLE2 = "STYLE2";
    public static final String STYLE3 = "STYLE3";
    public static final String STYLE4 = "STYLE4";

    public ButtonStyleCodeListModel() {
        this.initAnnotation(ButtonStyleCodeListModel.class);
        this.setUserData2("ButtonStyle");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ButtonStyleCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ButtonStyleCodeListModel");
    }
}

