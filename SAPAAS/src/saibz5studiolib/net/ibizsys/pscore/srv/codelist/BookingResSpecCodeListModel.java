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

@CodeList(id="d0f9819f8e31fbf914b1055addea205a", name="\u8d44\u6e90\u65f6\u95f4\u8d44\u6e90\u89c4\u683c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="C1_M1G", text="1\u68381G", realtext="1\u68381G"), @CodeItem(value="C1_M2G", text="1\u68382G", realtext="1\u68382G"), @CodeItem(value="C2_M2G", text="2\u68382G", realtext="2\u68382G"), @CodeItem(value="C2_M4G", text="2\u68384G", realtext="2\u68384G"), @CodeItem(value="C4_M4G", text="4\u68384G", realtext="4\u68384G")})
public class BookingResSpecCodeListModel
extends StaticCodeListModelBase {
    public static final String C1_M1G = "C1_M1G";
    public static final String C1_M2G = "C1_M2G";
    public static final String C2_M2G = "C2_M2G";
    public static final String C2_M4G = "C2_M4G";
    public static final String C4_M4G = "C4_M4G";

    public BookingResSpecCodeListModel() {
        this.initAnnotation(BookingResSpecCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.BookingResSpecCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.BookingResSpecCodeListModel");
    }
}

