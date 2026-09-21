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

@CodeList(id="85a487097d8723ec15d6427a2affca4c", name="\u6807\u51c6\u6570\u636e\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="UNKNOWN", realtext="UNKNOWN"), @CodeItem(value="1", text="BIGINT", realtext="BIGINT"), @CodeItem(value="2", text="BINARY", realtext="BINARY"), @CodeItem(value="3", text="BIT", realtext="BIT"), @CodeItem(value="4", text="CHAR", realtext="CHAR"), @CodeItem(value="5", text="DATETIME", realtext="DATETIME"), @CodeItem(value="6", text="DECIMAL", realtext="DECIMAL"), @CodeItem(value="7", text="FLOAT", realtext="FLOAT"), @CodeItem(value="8", text="IMAGE", realtext="IMAGE"), @CodeItem(value="9", text="INT", realtext="INT"), @CodeItem(value="10", text="MONEY", realtext="MONEY"), @CodeItem(value="11", text="NCHAR", realtext="NCHAR"), @CodeItem(value="12", text="NTEXT", realtext="NTEXT"), @CodeItem(value="13", text="NVARCHAR", realtext="NVARCHAR"), @CodeItem(value="14", text="NUMERIC", realtext="NUMERIC"), @CodeItem(value="15", text="REAL", realtext="REAL"), @CodeItem(value="16", text="SMALLDATETIME", realtext="SMALLDATETIME"), @CodeItem(value="17", text="SMALLINT", realtext="SMALLINT"), @CodeItem(value="18", text="SMALLMONEY", realtext="SMALLMONEY"), @CodeItem(value="19", text="SQL_VARIANT", realtext="SQL_VARIANT"), @CodeItem(value="20", text="SYSNAME", realtext="SYSNAME"), @CodeItem(value="21", text="TEXT", realtext="TEXT"), @CodeItem(value="22", text="TIMESTAMP", realtext="TIMESTAMP"), @CodeItem(value="23", text="TINYINT", realtext="TINYINT"), @CodeItem(value="24", text="VARBINARY", realtext="VARBINARY"), @CodeItem(value="25", text="VARCHAR", realtext="VARCHAR"), @CodeItem(value="26", text="UNIQUEIDENTIFIER", realtext="UNIQUEIDENTIFIER"), @CodeItem(value="27", text="DATE", realtext="DATE"), @CodeItem(value="28", text="TIME", realtext="TIME"), @CodeItem(value="29", text="BIGDECIMAL", realtext="BIGDECIMAL")})
public class StdDataTypeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer UNKNOWN = 0;
    public static final int INT_UNKNOWN = 0;
    public static final Integer BIGINT = 1;
    public static final int INT_BIGINT = 1;
    public static final Integer BINARY = 2;
    public static final int INT_BINARY = 2;
    public static final Integer BIT = 3;
    public static final int INT_BIT = 3;
    public static final Integer CHAR = 4;
    public static final int INT_CHAR = 4;
    public static final Integer DATETIME = 5;
    public static final int INT_DATETIME = 5;
    public static final Integer DECIMAL = 6;
    public static final int INT_DECIMAL = 6;
    public static final Integer FLOAT = 7;
    public static final int INT_FLOAT = 7;
    public static final Integer IMAGE = 8;
    public static final int INT_IMAGE = 8;
    public static final Integer INT = 9;
    public static final int INT_INT = 9;
    public static final Integer MONEY = 10;
    public static final int INT_MONEY = 10;
    public static final Integer NCHAR = 11;
    public static final int INT_NCHAR = 11;
    public static final Integer NTEXT = 12;
    public static final int INT_NTEXT = 12;
    public static final Integer NVARCHAR = 13;
    public static final int INT_NVARCHAR = 13;
    public static final Integer NUMERIC = 14;
    public static final int INT_NUMERIC = 14;
    public static final Integer REAL = 15;
    public static final int INT_REAL = 15;
    public static final Integer SMALLDATETIME = 16;
    public static final int INT_SMALLDATETIME = 16;
    public static final Integer SMALLINT = 17;
    public static final int INT_SMALLINT = 17;
    public static final Integer SMALLMONEY = 18;
    public static final int INT_SMALLMONEY = 18;
    public static final Integer SQL_VARIANT = 19;
    public static final int INT_SQL_VARIANT = 19;
    public static final Integer SYSNAME = 20;
    public static final int INT_SYSNAME = 20;
    public static final Integer TEXT = 21;
    public static final int INT_TEXT = 21;
    public static final Integer TIMESTAMP = 22;
    public static final int INT_TIMESTAMP = 22;
    public static final Integer TINYINT = 23;
    public static final int INT_TINYINT = 23;
    public static final Integer VARBINARY = 24;
    public static final int INT_VARBINARY = 24;
    public static final Integer VARCHAR = 25;
    public static final int INT_VARCHAR = 25;
    public static final Integer UNIQUEIDENTIFIER = 26;
    public static final int INT_UNIQUEIDENTIFIER = 26;
    public static final Integer DATE = 27;
    public static final int INT_DATE = 27;
    public static final Integer TIME = 28;
    public static final int INT_TIME = 28;
    public static final Integer BIGDECIMAL = 29;
    public static final int INT_BIGDECIMAL = 29;

    public StdDataTypeCodeListModel() {
        this.initAnnotation(StdDataTypeCodeListModel.class);
        this.setUserData2("StdDataType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.StdDataTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.StdDataTypeCodeListModel");
    }
}

