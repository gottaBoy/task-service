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

@CodeList(id="48f5741c5ddbf1396590e6c5d308300b", name="\u9762\u677f\u5e03\u5c40\u6a21\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TABLE", text="\u8868\u683c", realtext="\u8868\u683c"), @CodeItem(value="TABLE_12COL", text="\u6805\u683c\u5e03\u5c40\uff0812\u5217\uff09", realtext="\u6805\u683c\u5e03\u5c40\uff0812\u5217\uff09"), @CodeItem(value="TABLE_24COL", text="\u6805\u683c\u5e03\u5c40\uff0824\u5217\uff09", realtext="\u6805\u683c\u5e03\u5c40\uff0824\u5217\uff09"), @CodeItem(value="FLEX", text="Flex\u5e03\u5c40", realtext="Flex\u5e03\u5c40"), @CodeItem(value="BORDER", text="\u8fb9\u7f18\u5e03\u5c40", realtext="\u8fb9\u7f18\u5e03\u5c40"), @CodeItem(value="ABSOLUTE", text="\u7edd\u5bf9\u5e03\u5c40", realtext="\u7edd\u5bf9\u5e03\u5c40")})
public class PanelLayoutMode2CodeListModel
extends StaticCodeListModelBase {
    public static final String TABLE = "TABLE";
    public static final String TABLE_12COL = "TABLE_12COL";
    public static final String TABLE_24COL = "TABLE_24COL";
    public static final String FLEX = "FLEX";
    public static final String BORDER = "BORDER";
    public static final String ABSOLUTE = "ABSOLUTE";

    public PanelLayoutMode2CodeListModel() {
        this.initAnnotation(PanelLayoutMode2CodeListModel.class);
        this.setUserData2("LayoutMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelLayoutMode2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelLayoutMode2CodeListModel");
    }
}

