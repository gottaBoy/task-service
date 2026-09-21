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

@CodeList(id="7e4d1053d345d98742be62fb85f8bf8b", name="\u8d44\u6e90\u9884\u7ea6\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u672a\u5f00\u59cb", realtext="\u672a\u5f00\u59cb"), @CodeItem(value="15", text="\u51c6\u5907\u5f00\u59cb\u73af\u5883", realtext="\u51c6\u5907\u5f00\u59cb\u73af\u5883"), @CodeItem(value="20", text="\u4f7f\u7528\u4e2d", realtext="\u4f7f\u7528\u4e2d"), @CodeItem(value="25", text="\u51c6\u5907\u7ed3\u675f\u73af\u5883", realtext="\u51c6\u5907\u7ed3\u675f\u73af\u5883"), @CodeItem(value="40", text="\u5df2\u53d6\u6d88", realtext="\u5df2\u53d6\u6d88"), @CodeItem(value="41", text="\u5df2\u8fc7\u671f", realtext="\u5df2\u8fc7\u671f")})
public class BookingStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOTBEGIN = 10;
    public static final int INT_NOTBEGIN = 10;
    public static final Integer READYSTART = 15;
    public static final int INT_READYSTART = 15;
    public static final Integer INUSE = 20;
    public static final int INT_INUSE = 20;
    public static final Integer READYSTOP = 25;
    public static final int INT_READYSTOP = 25;
    public static final Integer CANCEL = 40;
    public static final int INT_CANCEL = 40;
    public static final Integer EXPIRED = 41;
    public static final int INT_EXPIRED = 41;

    public BookingStateCodeListModel() {
        this.initAnnotation(BookingStateCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.BookingStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.BookingStateCodeListModel");
    }
}

