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

@CodeList(id="a017857e1fb8fc93043b02bf228d7d34", name="\u7cfb\u7edf\u6a21\u578b\u52a0\u8f7d\u65e5\u5fd7\u5bf9\u8c61\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PSSYSTEM", text="\u7cfb\u7edf", realtext="\u7cfb\u7edf"), @CodeItem(value="PSSYSAPP", text="\u5e94\u7528", realtext="\u5e94\u7528")})
public class ModelLoadLogObjTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String PSSYSTEM = "PSSYSTEM";
    public static final String PSSYSAPP = "PSSYSAPP";

    public ModelLoadLogObjTypeCodeListModel() {
        this.initAnnotation(ModelLoadLogObjTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelLoadLogObjTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelLoadLogObjTypeCodeListModel");
    }
}

