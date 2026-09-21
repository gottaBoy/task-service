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

@CodeList(id="4e6d5919337ddd3e23b18612110a219d", name="\u5f00\u53d1\u7cfb\u7edf\u5f15\u7528\u4f7f\u7528\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="LIB", text="\u7ec4\u4ef6", realtext="\u7ec4\u4ef6"), @CodeItem(value="CLOUD", text="\u4e91\u670d\u52a1", realtext="\u4e91\u670d\u52a1"), @CodeItem(value="CLOUDHUBSUBAPP", text="Cloud\u96c6\u6210\u5b50\u5e94\u7528", realtext="Cloud\u96c6\u6210\u5b50\u5e94\u7528"), @CodeItem(value="ETLEXTRACT", text="ETL\u5c55\u5f00\u903b\u8f91", realtext="ETL\u5c55\u5f00\u903b\u8f91"), @CodeItem(value="ETLTRANSFORM", text="ETL\u8f6c\u6362\u903b\u8f91", realtext="ETL\u8f6c\u6362\u903b\u8f91"), @CodeItem(value="ETLLOAD", text="ETL\u52a0\u8f7d\u903b\u8f91", realtext="ETL\u52a0\u8f7d\u903b\u8f91"), @CodeItem(value="ETLSOURCE", text="ETL\u6570\u636e\u6e90\uff08\u6a21\u578b\u540c\u6b65\uff09", realtext="ETL\u6570\u636e\u6e90\uff08\u6a21\u578b\u540c\u6b65\uff09"), @CodeItem(value="ETLMODEL", text="ETL\u6a21\u578b\uff08\u6a21\u578b\u540c\u6b65\uff09", realtext="ETL\u6a21\u578b\uff08\u6a21\u578b\u540c\u6b65\uff09"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class DevSysRefUsageCodeListModel
extends StaticCodeListModelBase {
    public static final String LIB = "LIB";
    public static final String CLOUD = "CLOUD";
    public static final String CLOUDHUBSUBAPP = "CLOUDHUBSUBAPP";
    public static final String ETLEXTRACT = "ETLEXTRACT";
    public static final String ETLTRANSFORM = "ETLTRANSFORM";
    public static final String ETLLOAD = "ETLLOAD";
    public static final String ETLSOURCE = "ETLSOURCE";
    public static final String ETLMODEL = "ETLMODEL";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public DevSysRefUsageCodeListModel() {
        this.initAnnotation(DevSysRefUsageCodeListModel.class);
        this.setUserData2("DevSysRefUsage");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSysRefUsageCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSysRefUsageCodeListModel");
    }
}

