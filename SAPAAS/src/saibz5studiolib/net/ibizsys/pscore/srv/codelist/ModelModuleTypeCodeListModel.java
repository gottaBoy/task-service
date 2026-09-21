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

@CodeList(id="04ec4ccc53c73b6770695ba4b1bedcbe", name="\u6a21\u578b\u6a21\u5757\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="MODULE", text="\u7cfb\u7edf\u6a21\u5757", realtext="\u7cfb\u7edf\u6a21\u5757"), @CodeItem(value="MODEL", text="\u6a21\u578b\u529f\u80fd", realtext="\u6a21\u578b\u529f\u80fd"), @CodeItem(value="SUBSYS", text="\u5b50\u7cfb\u7edf", realtext="\u5b50\u7cfb\u7edf"), @CodeItem(value="CAT", text="\u5206\u7c7b", realtext="\u5206\u7c7b")})
public class ModelModuleTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String MODULE = "MODULE";
    public static final String MODEL = "MODEL";
    public static final String SUBSYS = "SUBSYS";
    public static final String CAT = "CAT";

    public ModelModuleTypeCodeListModel() {
        this.initAnnotation(ModelModuleTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelModuleTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelModuleTypeCodeListModel");
    }
}

