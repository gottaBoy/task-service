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

@CodeList(id="6ddc089cc80cb28ba5f1a88351d454b4", name="\u8bbf\u95ee\u6807\u8bc6\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u6b63\u5e38", realtext="\u6b63\u5e38"), @CodeItem(value="20", text="\u5230\u671f", realtext="\u5230\u671f"), @CodeItem(value="30", text="\u53d6\u6d88", realtext="\u53d6\u6d88")})
public class DevSlnSysKeyStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer OK = 10;
    public static final int INT_OK = 10;
    public static final Integer EXPIRED = 20;
    public static final int INT_EXPIRED = 20;
    public static final Integer CANCELLED = 30;
    public static final int INT_CANCELLED = 30;

    public DevSlnSysKeyStateCodeListModel() {
        this.initAnnotation(DevSlnSysKeyStateCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSlnSysKeyStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSlnSysKeyStateCodeListModel");
    }
}

