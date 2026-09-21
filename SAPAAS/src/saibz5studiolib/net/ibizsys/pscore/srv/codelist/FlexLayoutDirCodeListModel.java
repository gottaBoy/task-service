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

@CodeList(id="48dc6845ed411e081f07b9016163f50b", name="Flex\u5e03\u5c40\u65b9\u5411", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="row", text="\u6c34\u5e73\u5c45\u5de6", realtext="\u6c34\u5e73\u5c45\u5de6"), @CodeItem(value="row-reverse", text="\u6c34\u5e73\u5c45\u53f3", realtext="\u6c34\u5e73\u5c45\u53f3"), @CodeItem(value="column", text="\u5782\u76f4\u4ece\u4e0a\u5f80\u4e0b", realtext="\u5782\u76f4\u4ece\u4e0a\u5f80\u4e0b"), @CodeItem(value="column-reverse", text="\u5782\u76f4\u4ece\u4e0b\u5f80\u4e0a", realtext="\u5782\u76f4\u4ece\u4e0b\u5f80\u4e0a")})
public class FlexLayoutDirCodeListModel
extends StaticCodeListModelBase {
    public static final String ROW = "row";
    public static final String ROW_REVERSE = "row-reverse";
    public static final String COLUMN = "column";
    public static final String COLUMN_REVERSE = "column-reverse";

    public FlexLayoutDirCodeListModel() {
        this.initAnnotation(FlexLayoutDirCodeListModel.class);
        this.setUserData("IGNOREMODELDSLNAME");
        this.setUserData2("FlexLayoutDir");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FlexLayoutDirCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FlexLayoutDirCodeListModel");
    }
}

