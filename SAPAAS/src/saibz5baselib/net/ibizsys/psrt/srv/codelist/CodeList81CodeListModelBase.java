/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="662096d0067cbc4ce9f66c6956ee998f", name="\u5e74\u4efd\uff082010\uff5e2020\uff09", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="2010", text="2010\u5e74", realtext="2010\u5e74"), @CodeItem(value="2011", text="2011\u5e74", realtext="2011\u5e74"), @CodeItem(value="2012", text="2012\u5e74", realtext="2012\u5e74"), @CodeItem(value="2013", text="2013\u5e74", realtext="2013\u5e74"), @CodeItem(value="2014", text="2014\u5e74", realtext="2014\u5e74"), @CodeItem(value="2015", text="2015\u5e74", realtext="2015\u5e74"), @CodeItem(value="2016", text="2016\u5e74", realtext="2016\u5e74"), @CodeItem(value="2017", text="2017\u5e74", realtext="2017\u5e74"), @CodeItem(value="2018", text="2018\u5e74", realtext="2018\u5e74"), @CodeItem(value="2019", text="2019\u5e74", realtext="2019\u5e74"), @CodeItem(value="2020", text="2020\u5e74", realtext="2020\u5e74")})
public abstract class CodeList81CodeListModelBase
extends StaticCodeListModelBase {
    public static final String ITEM_2010 = "2010";
    public static final String ITEM_2011 = "2011";
    public static final String ITEM_2012 = "2012";
    public static final String ITEM_2013 = "2013";
    public static final String ITEM_2014 = "2014";
    public static final String ITEM_2015 = "2015";
    public static final String ITEM_2016 = "2016";
    public static final String ITEM_2017 = "2017";
    public static final String ITEM_2018 = "2018";
    public static final String ITEM_2019 = "2019";
    public static final String ITEM_2020 = "2020";

    public CodeList81CodeListModelBase() {
        this.initAnnotation(CodeList81CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList81CodeListModel", this);
    }
}

