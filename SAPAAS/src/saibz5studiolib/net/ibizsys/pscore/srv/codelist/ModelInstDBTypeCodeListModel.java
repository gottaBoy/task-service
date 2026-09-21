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

@CodeList(id="9713d9a973345b1a22b49939f2d3edc3", name="\u6a21\u578b\u5e93\u6570\u636e\u5e93\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DB2", text="DB2", realtext="DB2"), @CodeItem(value="MYSQL5", text="MySQL5", realtext="MySQL5"), @CodeItem(value="ORACLE", text="Oracle", realtext="Oracle"), @CodeItem(value="HBASE", text="HBase", realtext="HBase")})
public class ModelInstDBTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DB2 = "DB2";
    public static final String MYSQL5 = "MYSQL5";
    public static final String ORACLE = "ORACLE";
    public static final String HBASE = "HBASE";

    public ModelInstDBTypeCodeListModel() {
        this.initAnnotation(ModelInstDBTypeCodeListModel.class);
        this.setUserData2("ModelInstDBType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelInstDBTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelInstDBTypeCodeListModel");
    }
}

