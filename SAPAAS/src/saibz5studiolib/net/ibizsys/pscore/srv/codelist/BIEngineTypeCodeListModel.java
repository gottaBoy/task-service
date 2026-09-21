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

@CodeList(id="bffa4395167037f42b85d2aa9d4e411a", name="\u667a\u80fd\u62a5\u8868\u5f15\u64ce\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="KYLIN", text="Apache Kylin", realtext="Apache Kylin"), @CodeItem(value="OLAP", text="OLAP", realtext="OLAP"), @CodeItem(value="DB", text="DB", realtext="DB"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class BIEngineTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String KYLIN = "KYLIN";
    public static final String OLAP = "OLAP";
    public static final String DB = "DB";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public BIEngineTypeCodeListModel() {
        this.initAnnotation(BIEngineTypeCodeListModel.class);
        this.setUserData2("BIEngineType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.BIEngineTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.BIEngineTypeCodeListModel");
    }
}

