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

@CodeList(id="bc62a1b18d14cc11b680901013e0a239", name="\u7f16\u8f91\u5668\u5e94\u7528\u573a\u5408", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="FORMITEM", text="\u8868\u5355\u9879\u7f16\u8f91\u5668", realtext="\u8868\u5355\u9879\u7f16\u8f91\u5668"), @CodeItem(value="GRIDCOLUMN", text="\u8868\u683c\u5355\u5143\u683c\u7f16\u8f91\u5668", realtext="\u8868\u683c\u5355\u5143\u683c\u7f16\u8f91\u5668"), @CodeItem(value="PANELFIELD", text="\u9762\u677f\u5c5e\u6027\u7f16\u8f91\u5668", realtext="\u9762\u677f\u5c5e\u6027\u7f16\u8f91\u5668")})
public class EditorContainersCodeListModel
extends StaticCodeListModelBase {
    public static final String FORMITEM = "FORMITEM";
    public static final String GRIDCOLUMN = "GRIDCOLUMN";
    public static final String PANELFIELD = "PANELFIELD";

    public EditorContainersCodeListModel() {
        this.initAnnotation(EditorContainersCodeListModel.class);
        this.setUserData2("EditorContainer");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.EditorContainersCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.EditorContainersCodeListModel");
    }
}

