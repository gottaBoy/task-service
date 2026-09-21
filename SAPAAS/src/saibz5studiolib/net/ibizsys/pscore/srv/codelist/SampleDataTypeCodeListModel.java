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

@CodeList(id="ae153ea9dc5856340dd4aa89ed7ad522", name="\u5b9e\u4f53\u793a\u4f8b\u6570\u636e\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="JSON", text="JSON\u6570\u636e", realtext="JSON\u6570\u636e"), @CodeItem(value="XML", text="XML\u6570\u636e", realtext="XML\u6570\u636e"), @CodeItem(value="SCRIPT", text="\u811a\u672c", realtext="\u811a\u672c"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49")})
public class SampleDataTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String JSON = "JSON";
    public static final String XML = "XML";
    public static final String SCRIPT = "SCRIPT";
    public static final String USER = "USER";

    public SampleDataTypeCodeListModel() {
        this.initAnnotation(SampleDataTypeCodeListModel.class);
        this.setUserData2("SampleDataType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SampleDataTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SampleDataTypeCodeListModel");
    }
}

