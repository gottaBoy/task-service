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

@CodeList(id="163df83d558d4bf97b7855c4194ea690", name="\u8fb9\u754c\u5e03\u5c40\u4f4d\u7f6e", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NORTH", text="\u4e0a\u65b9", realtext="\u4e0a\u65b9"), @CodeItem(value="WEST", text="\u5de6\u4fa7", realtext="\u5de6\u4fa7"), @CodeItem(value="EAST", text="\u53f3\u4fa7", realtext="\u53f3\u4fa7"), @CodeItem(value="SOUTH", text="\u4e0b\u65b9", realtext="\u4e0b\u65b9"), @CodeItem(value="CENTER", text="\u4e2d\u95f4", realtext="\u4e2d\u95f4")})
public class BorderLayoutPosCodeListModel
extends StaticCodeListModelBase {
    public static final String NORTH = "NORTH";
    public static final String WEST = "WEST";
    public static final String EAST = "EAST";
    public static final String SOUTH = "SOUTH";
    public static final String CENTER = "CENTER";

    public BorderLayoutPosCodeListModel() {
        this.initAnnotation(BorderLayoutPosCodeListModel.class);
        this.setUserData2("BorderLayoutPos");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.BorderLayoutPosCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.BorderLayoutPosCodeListModel");
    }
}

