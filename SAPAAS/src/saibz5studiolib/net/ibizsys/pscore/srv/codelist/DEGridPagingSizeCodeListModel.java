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

@CodeList(id="7c110188101d7b8baa9b675fa91ff275", name="\u4e91\u5b9e\u4f53\u8868\u683c\u5206\u9875\u5927\u5c0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="10\u884c", realtext="10\u884c"), @CodeItem(value="20", text="20\u884c", realtext="20\u884c"), @CodeItem(value="30", text="30\u884c", realtext="30\u884c"), @CodeItem(value="40", text="40\u884c", realtext="40\u884c"), @CodeItem(value="50", text="50\u884c", realtext="50\u884c"), @CodeItem(value="60", text="60\u884c", realtext="60\u884c"), @CodeItem(value="70", text="70\u884c", realtext="70\u884c"), @CodeItem(value="80", text="80\u884c", realtext="80\u884c"), @CodeItem(value="90", text="90\u884c", realtext="90\u884c"), @CodeItem(value="100", text="100\u884c", realtext="100\u884c"), @CodeItem(value="500", text="500\u884c\uff08\u7a0b\u5e8f\u4f7f\u7528\uff09", realtext="500\u884c\uff08\u7a0b\u5e8f\u4f7f\u7528\uff09"), @CodeItem(value="1000", text="1000\u884c\uff08\u7a0b\u5e8f\u4f7f\u7528\uff09", realtext="1000\u884c\uff08\u7a0b\u5e8f\u4f7f\u7528\uff09")})
public class DEGridPagingSizeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer SIZE_10 = 10;
    public static final int INT_SIZE_10 = 10;
    public static final Integer SIZE_20 = 20;
    public static final int INT_SIZE_20 = 20;
    public static final Integer SIZE_30 = 30;
    public static final int INT_SIZE_30 = 30;
    public static final Integer SIZE_40 = 40;
    public static final int INT_SIZE_40 = 40;
    public static final Integer SIZE_50 = 50;
    public static final int INT_SIZE_50 = 50;
    public static final Integer SIZE_60 = 60;
    public static final int INT_SIZE_60 = 60;
    public static final Integer SIZE_70 = 70;
    public static final int INT_SIZE_70 = 70;
    public static final Integer SIZE_80 = 80;
    public static final int INT_SIZE_80 = 80;
    public static final Integer SIZE_90 = 90;
    public static final int INT_SIZE_90 = 90;
    public static final Integer SIZE_100 = 100;
    public static final int INT_SIZE_100 = 100;
    public static final Integer SIZE_500 = 500;
    public static final int INT_SIZE_500 = 500;
    public static final Integer SIZE_1000 = 1000;
    public static final int INT_SIZE_1000 = 1000;

    public DEGridPagingSizeCodeListModel() {
        this.initAnnotation(DEGridPagingSizeCodeListModel.class);
        this.setUserData("RESERVEMODELV2");
        this.setUserData2("PagingSize");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEGridPagingSizeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEGridPagingSizeCodeListModel");
    }
}

