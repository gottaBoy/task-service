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

@CodeList(id="FCA36FA1-630A-41AE-B653-8BEA4EACE96C", name="\u6570\u636e\u9762\u677f\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0", realtext="\u65e0"), @CodeItem(value="LOGINFORM", text="\u767b\u5f55\u8868\u5355", realtext="\u767b\u5f55\u8868\u5355", userdata="\u6307\u5b9a\u9762\u677f\u533a\u57df\u6570\u636e\u6a21\u5f0f\u4e3a\u767b\u5f55\u8868\u5355\uff0c\u533a\u57df\u4e2d\u5b9a\u4e49\u767b\u5f55\u540d\u79f0\uff0c\u767b\u5f55\u5bc6\u7801\u7b49\u76f8\u5173\u5c5e\u6027"), @CodeItem(value="SINGLEDATA", text="\u5355\u9879\u6570\u636e", realtext="\u5355\u9879\u6570\u636e", userdata="\u9762\u677f\u6570\u636e\u533a\u57df\u4e3a\u5355\u9879\u6570\u636e\u533a\u57df\uff0c\u4f7f\u7528\u6307\u5b9a\u7684\u6570\u636e\u6e90"), @CodeItem(value="MULTIDATA", text="\u591a\u9879\u6570\u636e\uff08\u91cd\u590d\u5668\uff09", realtext="\u591a\u9879\u6570\u636e\uff08\u91cd\u590d\u5668\uff09", userdata="\u9762\u677f\u6570\u636e\u533a\u57df\u4e3a\u591a\u9879\u6570\u636e\u533a\u57df\uff0c\u5b50\u9879\u5185\u5bb9\u5c06\u6309\u7167\u91cd\u590d\u5c55\u5f00\uff0c\u4f7f\u7528\u6307\u5b9a\u7684\u6570\u636e\u6e90"), @CodeItem(value="MULTIDATA_RAW", text="\u591a\u9879\u6570\u636e\uff08\u4ec5\u6570\u636e\uff09", realtext="\u591a\u9879\u6570\u636e\uff08\u4ec5\u6570\u636e\uff09", userdata="\u9762\u677f\u6570\u636e\u533a\u57df\u4e3a\u591a\u9879\u6570\u636e\u533a\u57df\uff0c\u4f7f\u7528\u6307\u5b9a\u7684\u6570\u636e\u6e90"), @CodeItem(value="INHERIT", text="\u7ee7\u627f", realtext="\u7ee7\u627f", userdata="\u9762\u677f\u533a\u57df\u6570\u636e\u6a21\u5f0f\u7ee7\u627f\u7236\u9879\u5b9a\u4e49"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49")})
public class DataPanelModeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String LOGINFORM = "LOGINFORM";
    public static final String SINGLEDATA = "SINGLEDATA";
    public static final String MULTIDATA = "MULTIDATA";
    public static final String MULTIDATA_RAW = "MULTIDATA_RAW";
    public static final String INHERIT = "INHERIT";
    public static final String USER = "USER";

    public DataPanelModeCodeListModel() {
        this.initAnnotation(DataPanelModeCodeListModel.class);
        this.setUserData2("DataPanelMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DataPanelModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DataPanelModeCodeListModel");
    }
}

