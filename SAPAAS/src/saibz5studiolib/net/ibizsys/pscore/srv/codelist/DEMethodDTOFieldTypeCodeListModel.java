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

@CodeList(id="EB0921EC-F666-45DF-BD04-389895FFDA52", name="\u5b9e\u4f53\u65b9\u6cd5DTO\u5c5e\u6027\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SIMPLE", text="\u7b80\u5355\u6570\u636e\u7c7b\u578b", realtext="\u7b80\u5355\u6570\u636e\u7c7b\u578b", userdata="\u6307\u5b9aDTO\u5c5e\u6027\u7c7b\u578b\u4e3a\u7b80\u5355\u6570\u636e\u7c7b\u578b"), @CodeItem(value="SIMPLES", text="\u7b80\u5355\u6570\u636e\u7c7b\u578b\u6570\u7ec4", realtext="\u7b80\u5355\u6570\u636e\u7c7b\u578b\u6570\u7ec4", userdata="\u6307\u5b9aDTO\u5c5e\u6027\u7c7b\u578b\u4e3a\u7b80\u5355\u6570\u636e\u7c7b\u578b\u6570\u7ec4"), @CodeItem(value="DTO", text="DTO\u5bf9\u8c61", realtext="DTO\u5bf9\u8c61", userdata="\u6307\u5b9aDTO\u5c5e\u6027\u7c7b\u578b\u4e3aDTO\u5bf9\u8c61"), @CodeItem(value="DTOS", text="DTO\u5bf9\u8c61\u6570\u7ec4", realtext="DTO\u5bf9\u8c61\u6570\u7ec4", userdata="\u6307\u5b9aDTO\u5c5e\u6027\u7c7b\u578b\u4e3aDTO\u5bf9\u8c61\u6570\u7ec4")})
public class DEMethodDTOFieldTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SIMPLE = "SIMPLE";
    public static final String SIMPLES = "SIMPLES";
    public static final String DTO = "DTO";
    public static final String DTOS = "DTOS";

    public DEMethodDTOFieldTypeCodeListModel() {
        this.initAnnotation(DEMethodDTOFieldTypeCodeListModel.class);
        this.setUserData2("DEMethodDTOFieldType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMethodDTOFieldTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMethodDTOFieldTypeCodeListModel");
    }
}

