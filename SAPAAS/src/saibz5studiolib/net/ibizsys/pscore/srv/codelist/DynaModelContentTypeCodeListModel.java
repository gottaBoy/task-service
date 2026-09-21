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

@CodeList(id="37ef20170a0be532bd2f68f67094fce1", name="\u52a8\u6001\u6a21\u578b\u5185\u5bb9\u683c\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="JSON", text="JSON", realtext="JSON"), @CodeItem(value="PROPERTIES", text="Properties", realtext="Properties")})
public class DynaModelContentTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String JSON = "JSON";
    public static final String PROPERTIES = "PROPERTIES";

    public DynaModelContentTypeCodeListModel() {
        this.initAnnotation(DynaModelContentTypeCodeListModel.class);
        this.setUserData2("DynaModelContentType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DynaModelContentTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DynaModelContentTypeCodeListModel");
    }
}

