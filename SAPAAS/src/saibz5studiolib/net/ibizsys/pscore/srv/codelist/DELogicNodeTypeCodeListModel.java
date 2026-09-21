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

@CodeList(id="6a5419134a0f0474ea5cef4f3fd7de10", name="\u4e91\u5b9e\u4f53\u903b\u8f91\u5904\u7406\u8282\u70b9\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="BEGIN", text="\u5f00\u59cb", realtext="\u5f00\u59cb", iconpath="psdelntype/icon_beginprocess.png", iconpathx="psdelntype/icon_beginprocess@{0}x.png"), @CodeItem(value="DEACTION", text="\u5b9e\u4f53\u884c\u4e3a", realtext="\u5b9e\u4f53\u884c\u4e3a", iconpath="psdelntype/icon_deaction.png", iconpathx="psdelntype/icon_deaction@{0}x.png"), @CodeItem(value="PREPAREPARAM", text="\u51c6\u5907\u53c2\u6570", realtext="\u51c6\u5907\u53c2\u6570", iconpath="psdelntype/icon_prepareparam.png", iconpathx="psdelntype/icon_prepareparam@{0}x.png"), @CodeItem(value="RESETPARAM", text="\u91cd\u7f6e\u53c2\u6570", realtext="\u91cd\u7f6e\u53c2\u6570", userdata="\u91cd\u7f6e\u76ee\u6807\u53c2\u6570\u5bf9\u8c61"), @CodeItem(value="COPYPARAM", text="\u62f7\u8d1d\u53c2\u6570", realtext="\u62f7\u8d1d\u53c2\u6570", userdata="\u5c06\u6e90\u53c2\u6570\u5bf9\u8c61\u62f7\u8d1d\u81f3\u76ee\u6807\u53c2\u6570\u5bf9\u8c61"), @CodeItem(value="BINDPARAM", text="\u7ed1\u5b9a\u53c2\u6570", realtext="\u7ed1\u5b9a\u53c2\u6570", userdata="\u5904\u7406\u903b\u8f91\u53d8\u91cf\u7ed1\u5b9a\u6307\u5b9a\u53d8\u91cf"), @CodeItem(value="APPENDPARAM", text="\u9644\u52a0\u5230\u6570\u7ec4\u53c2\u6570", realtext="\u9644\u52a0\u5230\u6570\u7ec4\u53c2\u6570"), @CodeItem(value="SORTPARAM", text="\u6392\u5e8f\u6570\u7ec4\u53c2\u6570", realtext="\u6392\u5e8f\u6570\u7ec4\u53c2\u6570"), @CodeItem(value="RENEWPARAM", text="\u91cd\u65b0\u5efa\u7acb\u53c2\u6570", realtext="\u91cd\u65b0\u5efa\u7acb\u53c2\u6570"), @CodeItem(value="FILTERPARAM", text="\u8fc7\u6ee4\u6570\u7ec4\u53c2\u6570", realtext="\u8fc7\u6ee4\u6570\u7ec4\u53c2\u6570", userdata="\u4f7f\u7528\u6570\u636e\u67e5\u8be2\u903b\u8f91\u8fdb\u884c\u8fc7\u6ee4"), @CodeItem(value="FILTERPARAM2", text="\u8fc7\u6ee4\u6570\u7ec4\u53c2\u65702", realtext="\u8fc7\u6ee4\u6570\u7ec4\u53c2\u65702", userdata="\u4f7f\u7528\u6570\u636e\u96c6\u903b\u8f91\u8fdb\u884c\u8fc7\u6ee4\uff0c\u6570\u636e\u96c6\u5305\u542b\u591a\u4e2a\u6570\u636e\u67e5\u8be2\uff0c\u6570\u636e\u67e5\u8be2\u4e4b\u95f4\u4f7f\u7528OR\u903b\u8f91"), @CodeItem(value="MERGEPARAM", text="\u5408\u5e76\u6570\u7ec4\u53c2\u6570", realtext="\u5408\u5e76\u6570\u7ec4\u53c2\u6570", userdata="\u5408\u5e76\u4e24\u4e2a\u6570\u7ec4\u5bf9\u8c61\uff0c\u5c06\u6e90\u6570\u7ec4\u5408\u5e76\u81f3\u76ee\u6807\u6570\u7ec4\uff0c\u5982\u6307\u5b9a\u8fd4\u56de\u53c2\u6570\u5219\u5c06\u7ed3\u679c\u653e\u5165\u8fd4\u56de\u53c2\u6570\u4e2d"), @CodeItem(value="AGGREGATEPARAM", text="\u805a\u5408\u6570\u7ec4\u53c2\u6570", realtext="\u805a\u5408\u6570\u7ec4\u53c2\u6570", userdata="\u805a\u5408\u6e90\u6570\u7ec4\u53c2\u6570\u5408\u5e76\u81f3\u76ee\u6807\u6570\u7ec4"), @CodeItem(value="RAWSQLCALL", text="\u76f4\u63a5SQL\u8c03\u7528", realtext="\u76f4\u63a5SQL\u8c03\u7528", iconpath="psdelntype/icon_rawsqlcall.png", iconpathx="psdelntype/icon_rawsqlcall@{0}x.png"), @CodeItem(value="RAWSQLANDLOOPCALL", text="\u76f4\u63a5SQL\u5e76\u5faa\u73af\u8c03\u7528", realtext="\u76f4\u63a5SQL\u5e76\u5faa\u73af\u8c03\u7528", iconpath="psdelntype/icon_rawsqlandloopcall.png", iconpathx="psdelntype/icon_rawsqlandloopcall@{0}x.png"), @CodeItem(value="RAWWEBCALL", text="\u76f4\u63a5Web\u8c03\u7528", realtext="\u76f4\u63a5Web\u8c03\u7528"), @CodeItem(value="STARTWF", text="\u542f\u52a8\u6d41\u7a0b", realtext="\u542f\u52a8\u6d41\u7a0b", iconpath="psdelntype/icon_startwf.png", iconpathx="psdelntype/icon_startwf@{0}x.png"), @CodeItem(value="CANCELWF", text="\u53d6\u6d88\u6d41\u7a0b", realtext="\u53d6\u6d88\u6d41\u7a0b"), @CodeItem(value="SUBMITWF", text="\u63d0\u4ea4\u6d41\u7a0b\u64cd\u4f5c", realtext="\u63d0\u4ea4\u6d41\u7a0b\u64cd\u4f5c"), @CodeItem(value="THROWEXCEPTION", text="\u629b\u51fa\u5f02\u5e38", realtext="\u629b\u51fa\u5f02\u5e38", iconpath="psdelntype/icon_throwexception.png", iconpathx="psdelntype/icon_throwexception@{0}x.png"), @CodeItem(value="SFPLUGIN", text="\u7cfb\u7edf\u670d\u52a1\u63d2\u4ef6", realtext="\u7cfb\u7edf\u670d\u52a1\u63d2\u4ef6", iconpath="psdelntype/icon_sfplugin.png", iconpathx="psdelntype/icon_sfplugin@{0}x.png"), @CodeItem(value="RAWSFCODE", text="\u76f4\u63a5\u540e\u53f0\u4ee3\u7801", realtext="\u76f4\u63a5\u540e\u53f0\u4ee3\u7801", iconpath="psdelntype/icon_rawsfcode.png", iconpathx="psdelntype/icon_rawsfcode@{0}x.png"), @CodeItem(value="SYSLOGIC", text="\u7cfb\u7edf\u903b\u8f91\u5904\u7406", realtext="\u7cfb\u7edf\u903b\u8f91\u5904\u7406", iconpath="psdelntype/icon_syslogic.png", iconpathx="psdelntype/icon_syslogic@{0}x.png"), @CodeItem(value="SYSUTIL", text="\u7cfb\u7edf\u529f\u80fd\u7ec4\u4ef6\u5904\u7406", realtext="\u7cfb\u7edf\u529f\u80fd\u7ec4\u4ef6\u5904\u7406"), @CodeItem(value="DEDATASET", text="\u5b9e\u4f53\u6570\u636e\u96c6", realtext="\u5b9e\u4f53\u6570\u636e\u96c6"), @CodeItem(value="DENOTIFY", text="\u5b9e\u4f53\u901a\u77e5", realtext="\u5b9e\u4f53\u901a\u77e5"), @CodeItem(value="DELOGIC", text="\u5b9e\u4f53\u903b\u8f91", realtext="\u5b9e\u4f53\u903b\u8f91"), @CodeItem(value="DEDATAFLOW", text="\u5b9e\u4f53\u6570\u636e\u6d41", realtext="\u5b9e\u4f53\u6570\u636e\u6d41"), @CodeItem(value="DEDATAQUERY", text="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2", realtext="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2"), @CodeItem(value="DEPRINT", text="\u5b9e\u4f53\u6253\u5370", realtext="\u5b9e\u4f53\u6253\u5370"), @CodeItem(value="DEREPORT", text="\u5b9e\u4f53\u62a5\u8868", realtext="\u5b9e\u4f53\u62a5\u8868"), @CodeItem(value="DEDATASYNC", text="\u5b9e\u4f53\u6570\u636e\u540c\u6b65", realtext="\u5b9e\u4f53\u6570\u636e\u540c\u6b65"), @CodeItem(value="DEDATAIMP", text="\u5b9e\u4f53\u6570\u636e\u5bfc\u5165", realtext="\u5b9e\u4f53\u6570\u636e\u5bfc\u5165"), @CodeItem(value="DEDATAEXP", text="\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa", realtext="\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa"), @CodeItem(value="DEDATAAUDIT", text="\u5b9e\u4f53\u8bbf\u95ee\u5ba1\u8ba1", realtext="\u5b9e\u4f53\u8bbf\u95ee\u5ba1\u8ba1"), @CodeItem(value="DEDTSQUEUE", text="\u5b9e\u4f53\u5f02\u6b65\u5904\u7406\u961f\u5217", realtext="\u5b9e\u4f53\u5f02\u6b65\u5904\u7406\u961f\u5217"), @CodeItem(value="COMMIT", text="\u63d0\u4ea4\u4e8b\u52a1", realtext="\u63d0\u4ea4\u4e8b\u52a1"), @CodeItem(value="ROLLBACK", text="\u56de\u6eda\u4e8b\u52a1", realtext="\u56de\u6eda\u4e8b\u52a1"), @CodeItem(value="SUBSYSSAMETHOD", text="\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u65b9\u6cd5", realtext="\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u65b9\u6cd5"), @CodeItem(value="SYSDATASYNCAGENTOUT", text="\u7cfb\u7edf\u6570\u636e\u540c\u6b65\u4ee3\u7406\u8f93\u51fa", realtext="\u7cfb\u7edf\u6570\u636e\u540c\u6b65\u4ee3\u7406\u8f93\u51fa"), @CodeItem(value="SYSDBTABLEACTION", text="\u7cfb\u7edf\u6570\u636e\u5e93\u8868\u64cd\u4f5c", realtext="\u7cfb\u7edf\u6570\u636e\u5e93\u8868\u64cd\u4f5c"), @CodeItem(value="SYSBDTABLEACTION", text="\u7cfb\u7edf\u5927\u6570\u636e\u8868\u64cd\u4f5c", realtext="\u7cfb\u7edf\u5927\u6570\u636e\u8868\u64cd\u4f5c"), @CodeItem(value="SYSSEARCHDOCACTION", text="\u7cfb\u7edf\u68c0\u7d22\u6587\u6863\u64cd\u4f5c", realtext="\u7cfb\u7edf\u68c0\u7d22\u6587\u6863\u64cd\u4f5c"), @CodeItem(value="SYSBIREPORT", text="\u7cfb\u7edf\u667a\u80fd\u62a5\u8868", realtext="\u7cfb\u7edf\u667a\u80fd\u62a5\u8868"), @CodeItem(value="SYSAICHATAGENT", text="\u7cfb\u7edfAI\u4ea4\u8c08", realtext="\u7cfb\u7edfAI\u4ea4\u8c08"), @CodeItem(value="SYSAIPIPELINEAGENT", text="\u7cfb\u7edfAI\u751f\u4ea7\u7ebf", realtext="\u7cfb\u7edfAI\u751f\u4ea7\u7ebf"), @CodeItem(value="DEBUGPARAM", text="\u8c03\u8bd5\u903b\u8f91\u53c2\u6570", realtext="\u8c03\u8bd5\u903b\u8f91\u53c2\u6570"), @CodeItem(value="END", text="\u7ed3\u675f", realtext="\u7ed3\u675f", iconpath="pswfprocesstype/icon_end@{0}2.png", iconpathx="pswfprocesstype/icon_end@{0}2.png")})
public class DELogicNodeTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String BEGIN = "BEGIN";
    public static final String DEACTION = "DEACTION";
    public static final String PREPAREPARAM = "PREPAREPARAM";
    public static final String RESETPARAM = "RESETPARAM";
    public static final String COPYPARAM = "COPYPARAM";
    public static final String BINDPARAM = "BINDPARAM";
    public static final String APPENDPARAM = "APPENDPARAM";
    public static final String SORTPARAM = "SORTPARAM";
    public static final String RENEWPARAM = "RENEWPARAM";
    public static final String FILTERPARAM = "FILTERPARAM";
    public static final String FILTERPARAM2 = "FILTERPARAM2";
    public static final String MERGEPARAM = "MERGEPARAM";
    public static final String AGGREGATEPARAM = "AGGREGATEPARAM";
    public static final String RAWSQLCALL = "RAWSQLCALL";
    public static final String RAWSQLANDLOOPCALL = "RAWSQLANDLOOPCALL";
    public static final String RAWWEBCALL = "RAWWEBCALL";
    public static final String STARTWF = "STARTWF";
    public static final String CANCELWF = "CANCELWF";
    public static final String SUBMITWF = "SUBMITWF";
    public static final String THROWEXCEPTION = "THROWEXCEPTION";
    public static final String SFPLUGIN = "SFPLUGIN";
    public static final String RAWSFCODE = "RAWSFCODE";
    public static final String SYSLOGIC = "SYSLOGIC";
    public static final String SYSUTIL = "SYSUTIL";
    public static final String DEDATASET = "DEDATASET";
    public static final String DENOTIFY = "DENOTIFY";
    public static final String DELOGIC = "DELOGIC";
    public static final String DEDATAFLOW = "DEDATAFLOW";
    public static final String DEDATAQUERY = "DEDATAQUERY";
    public static final String DEPRINT = "DEPRINT";
    public static final String DEREPORT = "DEREPORT";
    public static final String DEDATASYNC = "DEDATASYNC";
    public static final String DEDATAIMP = "DEDATAIMP";
    public static final String DEDATAEXP = "DEDATAEXP";
    public static final String DEDATAAUDIT = "DEDATAAUDIT";
    public static final String DEDTSQUEUE = "DEDTSQUEUE";
    public static final String COMMIT = "COMMIT";
    public static final String ROLLBACK = "ROLLBACK";
    public static final String SUBSYSSAMETHOD = "SUBSYSSAMETHOD";
    public static final String SYSDATASYNCAGENTOUT = "SYSDATASYNCAGENTOUT";
    public static final String SYSDBTABLEACTION = "SYSDBTABLEACTION";
    public static final String SYSBDTABLEACTION = "SYSBDTABLEACTION";
    public static final String SYSSEARCHDOCACTION = "SYSSEARCHDOCACTION";
    public static final String SYSBIREPORT = "SYSBIREPORT";
    public static final String SYSAICHATAGENT = "SYSAICHATAGENT";
    public static final String SYSAIPIPELINEAGENT = "SYSAIPIPELINEAGENT";
    public static final String DEBUGPARAM = "DEBUGPARAM";
    public static final String END = "END";

    public DELogicNodeTypeCodeListModel() {
        this.initAnnotation(DELogicNodeTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicNodeTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicNodeTypeCodeListModel");
    }
}

