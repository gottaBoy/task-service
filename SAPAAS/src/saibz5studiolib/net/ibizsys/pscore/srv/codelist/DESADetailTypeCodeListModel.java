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

@CodeList(id="a66a3539cf6e35a2cbb85d6ae648b675", name="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u6210\u5458\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEACTION", text="\u5b9e\u4f53\u884c\u4e3a", realtext="\u5b9e\u4f53\u884c\u4e3a", userdata="\u5b9e\u4f53\u884c\u4e3a\u7684\u63a5\u53e3\u65b9\u6cd5"), @CodeItem(value="FETCH", text="\u5b9e\u4f53\u6570\u636e\u96c6\u5408", realtext="\u5b9e\u4f53\u6570\u636e\u96c6\u5408", userdata="\u5b9e\u4f53\u6570\u636e\u96c6\u7684\u63a5\u53e3\u65b9\u6cd5"), @CodeItem(value="SELECT", text="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\uff08SELECT\uff09", realtext="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\uff08SELECT\uff09", userdata="\u7b80\u5355\u67e5\u8be2\u7684\u63a5\u53e3\u65b9\u6cd5"), @CodeItem(value="FETCHTEMP", text="\u5b9e\u4f53\u6570\u636e\u96c6\u5408\uff08\u4e34\u65f6\uff09", realtext="\u5b9e\u4f53\u6570\u636e\u96c6\u5408\uff08\u4e34\u65f6\uff09", userdata="\u5b9e\u4f53\u6570\u636e\u96c6\u7684\u63a5\u53e3\u65b9\u6cd5\uff0c\u4f7f\u7528\u4e34\u65f6\u6570\u636e\u6a21\u5f0f"), @CodeItem(value="SELECTTEMP", text="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\uff08SELECT\uff09\uff08\u4e34\u65f6\uff09", realtext="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\uff08SELECT\uff09\uff08\u4e34\u65f6\uff09", userdata="\u7b80\u5355\u67e5\u8be2\u7684\u63a5\u53e3\u65b9\u6cd5\uff0c\u4f7f\u7528\u4e34\u65f6\u6570\u636e\u6a21\u5f0f"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class DESADetailTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEACTION = "DEACTION";
    public static final String FETCH = "FETCH";
    public static final String SELECT = "SELECT";
    public static final String FETCHTEMP = "FETCHTEMP";
    public static final String SELECTTEMP = "SELECTTEMP";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public DESADetailTypeCodeListModel() {
        this.initAnnotation(DESADetailTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DESADetailTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DESADetailTypeCodeListModel");
    }
}

