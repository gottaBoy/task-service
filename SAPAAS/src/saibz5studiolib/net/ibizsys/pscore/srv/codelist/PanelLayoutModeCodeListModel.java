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

@CodeList(id="f5522fb005b09a6276d8d9372b5efbac", name="\u89c6\u56fe\u9762\u677f\u5e03\u5c40\u65b9\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="BOX", text="Box", realtext="Box"), @CodeItem(value="ABSOLUTE", text="Absolute", realtext="Absolute"), @CodeItem(value="ACCORDION", text="Accordion", realtext="Accordion"), @CodeItem(value="ANCHOR", text="Anchor", realtext="Anchor"), @CodeItem(value="AUTO", text="Auto", realtext="Auto"), @CodeItem(value="BORDER", text="Border", realtext="Border"), @CodeItem(value="CARD", text="Card", realtext="Card"), @CodeItem(value="CENTER", text="Center", realtext="Center"), @CodeItem(value="COLUMN", text="Column", realtext="Column"), @CodeItem(value="FIT", text="Fit", realtext="Fit"), @CodeItem(value="HBOX", text="HBox", realtext="HBox"), @CodeItem(value="TABLE", text="Table", realtext="Table"), @CodeItem(value="VBOX", text="VBox", realtext="VBox")})
public class PanelLayoutModeCodeListModel
extends StaticCodeListModelBase {
    public static final String BOX = "BOX";
    public static final String ABSOLUTE = "ABSOLUTE";
    public static final String ACCORDION = "ACCORDION";
    public static final String ANCHOR = "ANCHOR";
    public static final String AUTO = "AUTO";
    public static final String BORDER = "BORDER";
    public static final String CARD = "CARD";
    public static final String CENTER = "CENTER";
    public static final String COLUMN = "COLUMN";
    public static final String FIT = "FIT";
    public static final String HBOX = "HBOX";
    public static final String TABLE = "TABLE";
    public static final String VBOX = "VBOX";

    public PanelLayoutModeCodeListModel() {
        this.initAnnotation(PanelLayoutModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelLayoutModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelLayoutModeCodeListModel");
    }
}

