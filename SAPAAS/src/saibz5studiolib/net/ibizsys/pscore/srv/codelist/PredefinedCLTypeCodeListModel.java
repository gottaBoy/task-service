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

@CodeList(id="fa1e6ea6ddb4b603f913156a13d7c418", name="\u4ee3\u7801\u8868\u9884\u7f6e\u7c7b\u578b", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="OPERATOR", text="\u7cfb\u7edf\u64cd\u4f5c\u8005", realtext="\u7cfb\u7edf\u64cd\u4f5c\u8005", userdata="\u7cfb\u7edf\u64cd\u4f5c\u8005"), @CodeItem(value="RUNTIME", text="\u8fd0\u884c\u65f6\u4ee3\u7801\u8868", realtext="\u8fd0\u884c\u65f6\u4ee3\u7801\u8868", userdata="\u8fd0\u884c\u5b50\u7cfb\u7edf\u4ee3\u7801\u8868"), @CodeItem(value="MODULEINST", text="\u6a21\u5757\u526f\u672c", realtext="\u6a21\u5757\u526f\u672c", userdata="\u52a8\u6001\u5b9e\u4f8b\u6a21\u5757\u526f\u672c"), @CodeItem(value="DEMAINSTATE", text="\u5b9e\u4f53\u4e3b\u72b6\u6001", realtext="\u5b9e\u4f53\u4e3b\u72b6\u6001"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class PredefinedCLTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String OPERATOR = "OPERATOR";
    public static final String RUNTIME = "RUNTIME";
    public static final String MODULEINST = "MODULEINST";
    public static final String DEMAINSTATE = "DEMAINSTATE";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public PredefinedCLTypeCodeListModel() {
        this.initAnnotation(PredefinedCLTypeCodeListModel.class);
        this.setUserData2("PredefinedCodeListType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PredefinedCLTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PredefinedCLTypeCodeListModel");
    }
}

