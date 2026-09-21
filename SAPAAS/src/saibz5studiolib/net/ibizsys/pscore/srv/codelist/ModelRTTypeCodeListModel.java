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

@CodeList(id="c8395d0049ebfd650a097a4e72b5b497", name="\u8fd0\u884c\u65f6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PSOBJECT", text="\u6a21\u578b\u5bf9\u8c61", realtext="\u6a21\u578b\u5bf9\u8c61"), @CodeItem(value="METHOD", text="\u6a21\u578b\u65b9\u6cd5", realtext="\u6a21\u578b\u65b9\u6cd5"), @CodeItem(value="VALUE", text="\u6a21\u578b\u503c", realtext="\u6a21\u578b\u503c")})
public class ModelRTTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String PSOBJECT = "PSOBJECT";
    public static final String METHOD = "METHOD";
    public static final String VALUE = "VALUE";

    public ModelRTTypeCodeListModel() {
        this.initAnnotation(ModelRTTypeCodeListModel.class);
        this.setUserData2("ModelRTType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelRTTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelRTTypeCodeListModel");
    }
}

