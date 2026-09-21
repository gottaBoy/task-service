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

@CodeList(id="92cd66c0e65a71a01438f22bb1d7690a", name="\u7cfb\u7edf\u5f15\u7528\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SUBSYS", text="\u5e73\u53f0\u5b50\u7cfb\u7edf", realtext="\u5e73\u53f0\u5b50\u7cfb\u7edf", userdata="\u5e73\u53f0\u63d0\u4f9b\u7684\u8fd0\u884c\u5b50\u7cfb\u7edf"), @CodeItem(value="DEVSYS", text="\u5f00\u53d1\u7cfb\u7edf\u7ec4\u4ef6", realtext="\u5f00\u53d1\u7cfb\u7edf\u7ec4\u4ef6", userdata="\u5916\u90e8\u7cfb\u7edf\u4ee5\u7ec4\u4ef6\u5305\u5f62\u5f0f\u63d0\u4f9b\u529f\u80fd"), @CodeItem(value="EXTENSION_DEVSYS", text="\u5f00\u53d1\u7cfb\u7edf\u7ec4\u4ef6\uff08\u6269\u5c55\uff09", realtext="\u5f00\u53d1\u7cfb\u7edf\u7ec4\u4ef6\uff08\u6269\u5c55\uff09"), @CodeItem(value="EXTENSION_DEVSYS_PSMODELTOOL", text="\u5f00\u53d1\u7cfb\u7edf\u7ec4\u4ef6\uff08\u6a21\u578b\u5de5\u5177\uff09", realtext="\u5f00\u53d1\u7cfb\u7edf\u7ec4\u4ef6\uff08\u6a21\u578b\u5de5\u5177\uff09"), @CodeItem(value="EXTENSION_DEVSYS_WORKFLOW", text="\u5f00\u53d1\u7cfb\u7edf\u7ec4\u4ef6\uff08\u5de5\u4f5c\u6d41\uff09", realtext="\u5f00\u53d1\u7cfb\u7edf\u7ec4\u4ef6\uff08\u5de5\u4f5c\u6d41\uff09"), @CodeItem(value="MERGENCE_DEVSYS", text="\u5f00\u53d1\u7cfb\u7edf\u7ec4\u4ef6\uff08\u5408\u5e76\uff09", realtext="\u5f00\u53d1\u7cfb\u7edf\u7ec4\u4ef6\uff08\u5408\u5e76\uff09"), @CodeItem(value="DEVSYSCLOUD", text="\u5f00\u53d1\u7cfb\u7edf\u4e91\u670d\u52a1", realtext="\u5f00\u53d1\u7cfb\u7edf\u4e91\u670d\u52a1", userdata="\u5916\u90e8\u7cfb\u7edf\u4ee5\u5fae\u670d\u52a1\u7684\u5f62\u5f0f\u63d0\u4f9b\u529f\u80fd"), @CodeItem(value="CLOUDHUBSUBAPP", text="Cloud\u96c6\u6210\u5b50\u5e94\u7528", realtext="Cloud\u96c6\u6210\u5b50\u5e94\u7528"), @CodeItem(value="ETLEXTRACT", text="ETL\u5c55\u5f00\u903b\u8f91", realtext="ETL\u5c55\u5f00\u903b\u8f91"), @CodeItem(value="ETLTRANSFORM", text="ETL\u8f6c\u6362\u903b\u8f91", realtext="ETL\u8f6c\u6362\u903b\u8f91"), @CodeItem(value="ETLLOAD", text="ETL\u52a0\u8f7d\u903b\u8f91", realtext="ETL\u52a0\u8f7d\u903b\u8f91"), @CodeItem(value="ETLSOURCE", text="ETL\u6570\u636e\u6e90\uff08\u6a21\u578b\u540c\u6b65\uff09", realtext="ETL\u6570\u636e\u6e90\uff08\u6a21\u578b\u540c\u6b65\uff09"), @CodeItem(value="ETLMODEL", text="ETL\u6a21\u578b\uff08\u6a21\u578b\u540c\u6b65\uff09", realtext="ETL\u6a21\u578b\uff08\u6a21\u578b\u540c\u6b65\uff09"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class SysRefTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SUBSYS = "SUBSYS";
    public static final String DEVSYS = "DEVSYS";
    public static final String EXTENSION_DEVSYS = "EXTENSION_DEVSYS";
    public static final String EXTENSION_DEVSYS_PSMODELTOOL = "EXTENSION_DEVSYS_PSMODELTOOL";
    public static final String EXTENSION_DEVSYS_WORKFLOW = "EXTENSION_DEVSYS_WORKFLOW";
    public static final String MERGENCE_DEVSYS = "MERGENCE_DEVSYS";
    public static final String DEVSYSCLOUD = "DEVSYSCLOUD";
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

    public SysRefTypeCodeListModel() {
        this.initAnnotation(SysRefTypeCodeListModel.class);
        this.setUserData2("SysRefType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysRefTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysRefTypeCodeListModel");
    }
}

