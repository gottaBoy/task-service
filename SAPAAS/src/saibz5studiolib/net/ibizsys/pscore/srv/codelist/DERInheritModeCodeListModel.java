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

@CodeList(id="6de490c7dd4ea87842a239be6e88d2fe", name="\u7ee7\u627f\u5173\u7cfb\u5904\u7406\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u5b58\u50a8\u7ee7\u627f", realtext="\u5b58\u50a8\u7ee7\u627f", userdata="\u4ec5\u5bf9\u4e3b\u5b9e\u4f53\u7684\u5b58\u50a8\u7ed3\u6784\u8fdb\u884c\u7ee7\u627f\uff0c\u5904\u7406\u903b\u8f91\u7531\u6269\u5c55\u5b9e\u4f53\u81ea\u6301"), @CodeItem(value="2", text="\u903b\u8f91\u7ee7\u627f\u3001\u5b58\u50a8\u9644\u52a0", realtext="\u903b\u8f91\u7ee7\u627f\u3001\u5b58\u50a8\u9644\u52a0", userdata="\u5bf9\u4e3b\u5b9e\u4f53\u7684\u5904\u7406\u903b\u8f91\u8fdb\u884c\u7ee7\u627f\uff0c\u5982\u5b58\u5728\u6269\u5c55\u7684\u6570\u636e\u7ed3\u6784\uff0c\u5219\u5728\u8c03\u7528\u4e3b\u5b9e\u4f53\u903b\u8f91\u540e\u518d\u8fdb\u884c\u9644\u52a0\u5904\u7406")})
public class DERInheritModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer STORAGE = 1;
    public static final int INT_STORAGE = 1;
    public static final Integer LOGIC = 2;
    public static final int INT_LOGIC = 2;

    public DERInheritModeCodeListModel() {
        this.initAnnotation(DERInheritModeCodeListModel.class);
        this.setUserData2("DERInheritMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DERInheritModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DERInheritModeCodeListModel");
    }
}

