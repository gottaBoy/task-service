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

@CodeList(id="70666AB7-2E19-4C15-BA8C-5AC11A042F50", name="\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEACTION", text="\u5b9e\u4f53\u884c\u4e3a", realtext="\u5b9e\u4f53\u884c\u4e3a"), @CodeItem(value="SELECT", text="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\uff08\u7b80\u5355\uff09", realtext="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\uff08\u7b80\u5355\uff09"), @CodeItem(value="FETCH", text="\u83b7\u53d6\u6570\u636e\u96c6", realtext="\u83b7\u53d6\u6570\u636e\u96c6"), @CodeItem(value="OTHER", text="\u5176\u5b83", realtext="\u5176\u5b83"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class DESADetailType2CodeListModel
extends StaticCodeListModelBase {
    public static final String DEACTION = "DEACTION";
    public static final String SELECT = "SELECT";
    public static final String FETCH = "FETCH";
    public static final String OTHER = "OTHER";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public DESADetailType2CodeListModel() {
        this.initAnnotation(DESADetailType2CodeListModel.class);
        this.setUserData2("SADEMethodType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DESADetailType2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DESADetailType2CodeListModel");
    }
}

