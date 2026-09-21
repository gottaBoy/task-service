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

@CodeList(id="6ca4c89f9bb2b1a391ce047eb908e0f3", name="\u4e91\u5b9e\u4f53\u8868\u683c\u6837\u5f0f", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="TREEGRID", text="\u6811\u8868\u683c", realtext="\u6811\u8868\u683c", userdata="\u663e\u793a\u4e3a\u5e26\u5c42\u7ea7\u7684\u6811\u8868"), @CodeItem(value="GROUPGRID", text="\u5206\u7ec4\u8868\u683c", realtext="\u5206\u7ec4\u8868\u683c", userdata="\u663e\u793a\u5206\u7ec4\u663e\u793a\u7684\u8868\u683c"), @CodeItem(value="AUTOGRID", text="\u81ea\u52a8\u8868\u683c", realtext="\u81ea\u52a8\u8868\u683c", userdata="\u6839\u636eJsonSchema\u7684\u5c5e\u6027\u4fe1\u606f\u81ea\u52a8\u5448\u73b0\u7684\u8868\u683c"), @CodeItem(value="LIST", text="\u5355\u5217\u65e0\u5934\u8868\u683c\uff08\u5217\u8868\uff09", realtext="\u5355\u5217\u65e0\u5934\u8868\u683c\uff08\u5217\u8868\uff09"), @CodeItem(value="LIST_SORT", text="\u5355\u5217\u65e0\u5934\u8868\u683c\uff08\u5217\u8868\uff09\uff0c\u652f\u6301\u6392\u5e8f", realtext="\u5355\u5217\u65e0\u5934\u8868\u683c\uff08\u5217\u8868\uff09\uff0c\u652f\u6301\u6392\u5e8f"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class DEGridStyleCodeListModel
extends StaticCodeListModelBase {
    public static final String TREEGRID = "TREEGRID";
    public static final String GROUPGRID = "GROUPGRID";
    public static final String AUTOGRID = "AUTOGRID";
    public static final String LIST = "LIST";
    public static final String LIST_SORT = "LIST_SORT";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public DEGridStyleCodeListModel() {
        this.initAnnotation(DEGridStyleCodeListModel.class);
        this.setUserData2("GridStyle");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEGridStyleCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEGridStyleCodeListModel");
    }
}

