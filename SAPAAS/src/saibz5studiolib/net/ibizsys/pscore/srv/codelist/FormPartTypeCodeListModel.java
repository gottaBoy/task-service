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

@CodeList(id="3C353160-EC79-4695-896B-126A50EC5EAB", name="\u8868\u5355\u90e8\u4ef6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="FORMRF", text="\u8868\u5355\u5f15\u7528", realtext="\u8868\u5355\u5f15\u7528", userdata="\u8868\u5355\u90e8\u4ef6\u6765\u81ea\u8bbe\u8ba1\u65f6\u7684\u5176\u5b83\u8868\u5355"), @CodeItem(value="DYNASYS", text="\u52a8\u6001\u7cfb\u7edf", realtext="\u52a8\u6001\u7cfb\u7edf", userdata="\u8868\u5355\u90e8\u4ef6\u6765\u81ea\u52a8\u6001\u7cfb\u7edf\uff0c\u5728\u8fd0\u884c\u65f6\u5f15\u7528")})
public class FormPartTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String FORMRF = "FORMRF";
    public static final String DYNASYS = "DYNASYS";

    public FormPartTypeCodeListModel() {
        this.initAnnotation(FormPartTypeCodeListModel.class);
        this.setUserData2("FormPartType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FormPartTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FormPartTypeCodeListModel");
    }
}

