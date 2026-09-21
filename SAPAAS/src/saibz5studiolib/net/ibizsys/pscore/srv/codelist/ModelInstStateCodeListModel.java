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

@CodeList(id="0ad24147d319c61e81081ee853efb364", name="\u6a21\u578b\u5b9e\u4f8b\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u672a\u521d\u59cb\u5316", realtext="\u672a\u521d\u59cb\u5316"), @CodeItem(value="20", text="\u5df2\u521d\u59cb\u5316", realtext="\u5df2\u521d\u59cb\u5316"), @CodeItem(value="30", text="\u5df2\u4f7f\u7528", realtext="\u5df2\u4f7f\u7528"), @CodeItem(value="31", text="\u8fd0\u7ef4\u4e2d", realtext="\u8fd0\u7ef4\u4e2d"), @CodeItem(value="35", text="\u5df2\u79bb\u7ebf", realtext="\u5df2\u79bb\u7ebf"), @CodeItem(value="40", text="\u5df2\u4f5c\u5e9f", realtext="\u5df2\u4f5c\u5e9f"), @CodeItem(value="15", text="\u6b63\u5728\u514b\u9686", realtext="\u6b63\u5728\u514b\u9686"), @CodeItem(value="41", text="\u514b\u9686\u5931\u8d25", realtext="\u514b\u9686\u5931\u8d25")})
public class ModelInstStateCodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM_10 = "10";
    public static final String ITEM_20 = "20";
    public static final String ITEM_30 = "30";
    public static final String ITEM_31 = "31";
    public static final String ITEM_35 = "35";
    public static final String ITEM_40 = "40";
    public static final String ITEM_15 = "15";
    public static final String ITEM_41 = "41";

    public ModelInstStateCodeListModel() {
        this.initAnnotation(ModelInstStateCodeListModel.class);
        this.setUserData2("ModelInstState");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelInstStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelInstStateCodeListModel");
    }
}

