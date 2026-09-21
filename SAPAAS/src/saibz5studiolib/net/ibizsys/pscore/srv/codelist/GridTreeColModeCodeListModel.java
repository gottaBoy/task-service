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

@CodeList(id="53a1852e482aa214e3b597ce2fbe6589", name="\u5b9e\u4f53\u8868\u683c\u6811\u5217\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="0", text="\u65e0", realtext="\u65e0"), @CodeItem(value="1", text="\u6587\u672c", realtext="\u6587\u672c"), @CodeItem(value="2", text="\u503c", realtext="\u503c"), @CodeItem(value="3", text="\u6587\u672c\u53ca\u503c", realtext="\u6587\u672c\u53ca\u503c"), @CodeItem(value="8", text="\u7236\u6587\u672c", realtext="\u7236\u6587\u672c"), @CodeItem(value="4", text="\u7236\u503c", realtext="\u7236\u503c"), @CodeItem(value="12", text="\u7236\u6587\u672c\u53ca\u7236\u503c", realtext="\u7236\u6587\u672c\u53ca\u7236\u503c")})
public class GridTreeColModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer TEXT = 1;
    public static final int INT_TEXT = 1;
    public static final Integer VALUE = 2;
    public static final int INT_VALUE = 2;
    public static final Integer TEXTVALUE = 3;
    public static final int INT_TEXTVALUE = 3;
    public static final Integer PTEXT = 8;
    public static final int INT_PTEXT = 8;
    public static final Integer PVALUE = 4;
    public static final int INT_PVALUE = 4;
    public static final Integer PTEXTPVALUE = 12;
    public static final int INT_PTEXTPVALUE = 12;

    public GridTreeColModeCodeListModel() {
        this.initAnnotation(GridTreeColModeCodeListModel.class);
        this.setUserData2("GridTreeColMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.GridTreeColModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.GridTreeColModeCodeListModel");
    }
}

