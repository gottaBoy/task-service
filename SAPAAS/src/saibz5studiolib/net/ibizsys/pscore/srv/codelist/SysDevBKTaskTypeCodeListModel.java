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

@CodeList(id="728b3f9a41aeb39bbb50e396b8c7afc8", name="\u7cfb\u7edf\u5f00\u53d1\u540e\u53f0\u4efb\u52a1\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEPLOYSYS", text="\u90e8\u7f72\u7cfb\u7edf", realtext="\u90e8\u7f72\u7cfb\u7edf"), @CodeItem(value="PACKSFCODE", text="\u6253\u5305\u670d\u52a1\u4ee3\u7801", realtext="\u6253\u5305\u670d\u52a1\u4ee3\u7801"), @CodeItem(value="PACKPFCODE", text="\u6253\u5305\u5e94\u7528\u4ee3\u7801", realtext="\u6253\u5305\u5e94\u7528\u4ee3\u7801"), @CodeItem(value="PUBSFCODE", text="\u53d1\u5e03\u670d\u52a1\u4ee3\u7801", realtext="\u53d1\u5e03\u670d\u52a1\u4ee3\u7801"), @CodeItem(value="PUBPFCODE", text="\u53d1\u5e03\u5e94\u7528\u4ee3\u7801", realtext="\u53d1\u5e03\u5e94\u7528\u4ee3\u7801"), @CodeItem(value="STARTUPAS", text="\u542f\u52a8\u5e94\u7528\u670d\u52a1\u5668", realtext="\u542f\u52a8\u5e94\u7528\u670d\u52a1\u5668"), @CodeItem(value="SYNCDBMODEL", text="\u540c\u6b65\u6570\u636e\u7ed3\u6784", realtext="\u540c\u6b65\u6570\u636e\u7ed3\u6784"), @CodeItem(value="SHUTDOWNAS", text="\u5173\u95ed\u5e94\u7528\u670d\u52a1\u5668", realtext="\u5173\u95ed\u5e94\u7528\u670d\u52a1\u5668"), @CodeItem(value="STARTUPEX", text="\u4e00\u952e\u7cfb\u7edf\u542f\u52a8", realtext="\u4e00\u952e\u7cfb\u7edf\u542f\u52a8"), @CodeItem(value="SYNCSUBSYSDBMODEL", text="\u540c\u6b65\u5b50\u7cfb\u7edf\u6570\u636e\u7ed3\u6784", realtext="\u540c\u6b65\u5b50\u7cfb\u7edf\u6570\u636e\u7ed3\u6784"), @CodeItem(value="SYNCSUBSYSMODEL", text="\u540c\u6b65\u5b50\u7cfb\u7edf\u6a21\u578b", realtext="\u540c\u6b65\u5b50\u7cfb\u7edf\u6a21\u578b"), @CodeItem(value="INITSYSMODEL", text="\u521d\u59cb\u5316\u7cfb\u7edf\u6a21\u578b", realtext="\u521d\u59cb\u5316\u7cfb\u7edf\u6a21\u578b"), @CodeItem(value="INITSYSDEDBCFG", text="\u521d\u59cb\u5316\u7cfb\u7edf\u5b9e\u4f53\u6570\u636e\u5e93\u914d\u7f6e", realtext="\u521d\u59cb\u5316\u7cfb\u7edf\u5b9e\u4f53\u6570\u636e\u5e93\u914d\u7f6e"), @CodeItem(value="RESETSFCODE", text="\u91cd\u7f6e\u670d\u52a1\u4ee3\u7801\uff08\u524d\uff09", realtext="\u91cd\u7f6e\u670d\u52a1\u4ee3\u7801\uff08\u524d\uff09"), @CodeItem(value="RESETPFCODE", text="\u91cd\u7f6e\u5e94\u7528\u4ee3\u7801", realtext="\u91cd\u7f6e\u5e94\u7528\u4ee3\u7801"), @CodeItem(value="IMPSUBSYSMODEL", text="\u5bfc\u5165\u5b50\u7cfb\u7edf\u6a21\u578b", realtext="\u5bfc\u5165\u5b50\u7cfb\u7edf\u6a21\u578b"), @CodeItem(value="INITAPPMODEL", text="\u521d\u59cb\u5316\u5e94\u7528\u6a21\u578b", realtext="\u521d\u59cb\u5316\u5e94\u7528\u6a21\u578b"), @CodeItem(value="CHECKSYSMODEL", text="\u68c0\u67e5\u7cfb\u7edf\u6a21\u578b", realtext="\u68c0\u67e5\u7cfb\u7edf\u6a21\u578b"), @CodeItem(value="CHECKSYSAPPMODEL", text="\u68c0\u67e5\u7cfb\u7edf\u5e94\u7528\u6a21\u578b", realtext="\u68c0\u67e5\u7cfb\u7edf\u5e94\u7528\u6a21\u578b"), @CodeItem(value="RESETSFCODE2", text="\u91cd\u7f6e\u670d\u52a1\u4ee3\u7801\uff08\u540e\uff09", realtext="\u91cd\u7f6e\u670d\u52a1\u4ee3\u7801\uff08\u540e\uff09"), @CodeItem(value="STARTUPEX2", text="\u4e00\u952e\u4ee3\u7801\u53d1\u5e03", realtext="\u4e00\u952e\u4ee3\u7801\u53d1\u5e03"), @CodeItem(value="STARTUPEX3", text="\u4e00\u952e\u7248\u672c\u6253\u5305", realtext="\u4e00\u952e\u7248\u672c\u6253\u5305"), @CodeItem(value="PACKSYSVER", text="\u6253\u5305\u7cfb\u7edf\u7248\u672c", realtext="\u6253\u5305\u7cfb\u7edf\u7248\u672c"), @CodeItem(value="PUBSYSDBMODEL", text="\u91cd\u65b0\u53d1\u5e03\u7cfb\u7edf\u6570\u636e\u5e93\u7ed3\u6784", realtext="\u91cd\u65b0\u53d1\u5e03\u7cfb\u7edf\u6570\u636e\u5e93\u7ed3\u6784"), @CodeItem(value="DIFFSYSMODEL", text="\u5bf9\u6bd4\u7cfb\u7edf\u6a21\u578b\u5dee\u5f02", realtext="\u5bf9\u6bd4\u7cfb\u7edf\u6a21\u578b\u5dee\u5f02"), @CodeItem(value="CREATESYS", text="\u5efa\u7acb\u7cfb\u7edf", realtext="\u5efa\u7acb\u7cfb\u7edf"), @CodeItem(value="INSTALLRTDATA", text="\u5b89\u88c5\u7cfb\u7edf\u8fd0\u884c\u6570\u636e", realtext="\u5b89\u88c5\u7cfb\u7edf\u8fd0\u884c\u6570\u636e"), @CodeItem(value="STARTUPEX4", text="\u4e00\u952e\u79fb\u52a8\u5e94\u7528\u6253\u5305", realtext="\u4e00\u952e\u79fb\u52a8\u5e94\u7528\u6253\u5305"), @CodeItem(value="PACKANDROIDAPP", text="\u6253\u5305Android\u5e94\u7528", realtext="\u6253\u5305Android\u5e94\u7528"), @CodeItem(value="PACKIOSAPP", text="\u6253\u5305iOS\u5e94\u7528", realtext="\u6253\u5305iOS\u5e94\u7528"), @CodeItem(value="REMOTEPACKSYS", text="\u8fdc\u7a0b\u7cfb\u7edf\u6253\u5305", realtext="\u8fdc\u7a0b\u7cfb\u7edf\u6253\u5305"), @CodeItem(value="STARTUPEX5", text="\u4e00\u952e\u5fae\u670d\u52a1\u63a5\u53e3\u90e8\u7f72", realtext="\u4e00\u952e\u5fae\u670d\u52a1\u63a5\u53e3\u90e8\u7f72"), @CodeItem(value="STARTUPEX6", text="\u4e00\u952e\u5fae\u670d\u52a1\u5e94\u7528\u90e8\u7f72", realtext="\u4e00\u952e\u5fae\u670d\u52a1\u5e94\u7528\u90e8\u7f72"), @CodeItem(value="STARTUPEX7", text="\u4e00\u952e\u90e8\u7f72\u7ec4\u4ef6\u5305", realtext="\u4e00\u952e\u90e8\u7f72\u7ec4\u4ef6\u5305"), @CodeItem(value="DEPLOYPKG", text="\u90e8\u7f72\u7ec4\u4ef6\u5305\u5230\u4ed3\u5e93", realtext="\u90e8\u7f72\u7ec4\u4ef6\u5305\u5230\u4ed3\u5e93"), @CodeItem(value="CLONEDEMODEL", text="\u514b\u9686\u5b9e\u4f53\u6a21\u578b", realtext="\u514b\u9686\u5b9e\u4f53\u6a21\u578b"), @CodeItem(value="SYNCSERVICEAPICLIENTMODEL", text="\u514b\u9686\u670d\u52a1\u63a5\u53e3\u5ba2\u6237\u7aef\u6a21\u578b", realtext="\u514b\u9686\u670d\u52a1\u63a5\u53e3\u5ba2\u6237\u7aef\u6a21\u578b"), @CodeItem(value="STARTUPEX8", text="\u4e00\u952e\u5fae\u670d\u52a1\u529f\u80fd\u90e8\u7f72", realtext="\u4e00\u952e\u5fae\u670d\u52a1\u529f\u80fd\u90e8\u7f72"), @CodeItem(value="BEGINPUBCODE", text="\u51c6\u5907\u53d1\u5e03\u4ee3\u7801", realtext="\u51c6\u5907\u53d1\u5e03\u4ee3\u7801"), @CodeItem(value="ENDPUBCODE", text="\u7ed3\u675f\u53d1\u5e03\u4ee3\u7801", realtext="\u7ed3\u675f\u53d1\u5e03\u4ee3\u7801"), @CodeItem(value="RESETPUBCODE", text="\u91cd\u7f6e\u53d1\u5e03\u4ee3\u7801", realtext="\u91cd\u7f6e\u53d1\u5e03\u4ee3\u7801"), @CodeItem(value="PFPREVIEWACTION", text="\u524d\u7aef\u9884\u89c8\u4f5c\u4e1a", realtext="\u524d\u7aef\u9884\u89c8\u4f5c\u4e1a"), @CodeItem(value="SFPREVIEWACTION", text="\u540e\u53f0\u9884\u89c8\u4f5c\u4e1a", realtext="\u540e\u53f0\u9884\u89c8\u4f5c\u4e1a"), @CodeItem(value="CODEPREVIEWACTION", text="\u4ee3\u7801\u9884\u89c8\u4f5c\u4e1a", realtext="\u4ee3\u7801\u9884\u89c8\u4f5c\u4e1a"), @CodeItem(value="SYNCSUBSYSSADEMODEL", text="\u540c\u6b65\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u6a21\u578b", realtext="\u540c\u6b65\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u6a21\u578b"), @CodeItem(value="SYNCAPPSBMODEL", text="\u540c\u6b65\u5e94\u7528\u6545\u4e8b\u677f", realtext="\u540c\u6b65\u5e94\u7528\u6545\u4e8b\u677f"), @CodeItem(value="STARTUPEX9", text="\u4e00\u952e\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u53d1\u5e03", realtext="\u4e00\u952e\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u53d1\u5e03"), @CodeItem(value="PUBDYNAINSTMODEL", text="\u53d1\u5e03\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b", realtext="\u53d1\u5e03\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b"), @CodeItem(value="DYNAINSTPREVIEWACTION", text="\u52a8\u6001\u5b9e\u4f8b\u9884\u89c8\u4f5c\u4e1a", realtext="\u52a8\u6001\u5b9e\u4f8b\u9884\u89c8\u4f5c\u4e1a"), @CodeItem(value="SYNCSYSDBSCHEMAMODEL", text="\u540c\u6b65\u7cfb\u7edf\u6570\u636e\u5e93\u6a21\u578b", realtext="\u540c\u6b65\u7cfb\u7edf\u6570\u636e\u5e93\u6a21\u578b"), @CodeItem(value="IMPORTJSONSCHEMAMODEL", text="\u5bfc\u5165JsonSchema\u6a21\u578b", realtext="\u5bfc\u5165JsonSchema\u6a21\u578b"), @CodeItem(value="IBIZCENTRAL", text="iBizCentral\uff08\u4e2d\u53f0\uff09", realtext="iBizCentral\uff08\u4e2d\u53f0\uff09"), @CodeItem(value="IBIZMODELINGIA", text="iBizModelingIA\uff08\u5efa\u6a21\u52a9\u624b\uff09", realtext="iBizModelingIA\uff08\u5efa\u6a21\u52a9\u624b\uff09"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49")})
public class SysDevBKTaskTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEPLOYSYS = "DEPLOYSYS";
    public static final String PACKSFCODE = "PACKSFCODE";
    public static final String PACKPFCODE = "PACKPFCODE";
    public static final String PUBSFCODE = "PUBSFCODE";
    public static final String PUBPFCODE = "PUBPFCODE";
    public static final String STARTUPAS = "STARTUPAS";
    public static final String SYNCDBMODEL = "SYNCDBMODEL";
    public static final String SHUTDOWNAS = "SHUTDOWNAS";
    public static final String STARTUPEX = "STARTUPEX";
    public static final String SYNCSUBSYSDBMODEL = "SYNCSUBSYSDBMODEL";
    public static final String SYNCSUBSYSMODEL = "SYNCSUBSYSMODEL";
    public static final String INITSYSMODEL = "INITSYSMODEL";
    public static final String INITSYSDEDBCFG = "INITSYSDEDBCFG";
    public static final String RESETSFCODE = "RESETSFCODE";
    public static final String RESETPFCODE = "RESETPFCODE";
    public static final String IMPSUBSYSMODEL = "IMPSUBSYSMODEL";
    public static final String INITAPPMODEL = "INITAPPMODEL";
    public static final String CHECKSYSMODEL = "CHECKSYSMODEL";
    public static final String CHECKSYSAPPMODEL = "CHECKSYSAPPMODEL";
    public static final String RESETSFCODE2 = "RESETSFCODE2";
    public static final String STARTUPEX2 = "STARTUPEX2";
    public static final String STARTUPEX3 = "STARTUPEX3";
    public static final String PACKSYSVER = "PACKSYSVER";
    public static final String PUBSYSDBMODEL = "PUBSYSDBMODEL";
    public static final String DIFFSYSMODEL = "DIFFSYSMODEL";
    public static final String CREATESYS = "CREATESYS";
    public static final String INSTALLRTDATA = "INSTALLRTDATA";
    public static final String STARTUPEX4 = "STARTUPEX4";
    public static final String PACKANDROIDAPP = "PACKANDROIDAPP";
    public static final String PACKIOSAPP = "PACKIOSAPP";
    public static final String REMOTEPACKSYS = "REMOTEPACKSYS";
    public static final String STARTUPEX5 = "STARTUPEX5";
    public static final String STARTUPEX6 = "STARTUPEX6";
    public static final String STARTUPEX7 = "STARTUPEX7";
    public static final String DEPLOYPKG = "DEPLOYPKG";
    public static final String CLONEDEMODEL = "CLONEDEMODEL";
    public static final String SYNCSERVICEAPICLIENTMODEL = "SYNCSERVICEAPICLIENTMODEL";
    public static final String STARTUPEX8 = "STARTUPEX8";
    public static final String BEGINPUBCODE = "BEGINPUBCODE";
    public static final String ENDPUBCODE = "ENDPUBCODE";
    public static final String RESETPUBCODE = "RESETPUBCODE";
    public static final String PFPREVIEWACTION = "PFPREVIEWACTION";
    public static final String SFPREVIEWACTION = "SFPREVIEWACTION";
    public static final String CODEPREVIEWACTION = "CODEPREVIEWACTION";
    public static final String SYNCSUBSYSSADEMODEL = "SYNCSUBSYSSADEMODEL";
    public static final String SYNCAPPSBMODEL = "SYNCAPPSBMODEL";
    public static final String STARTUPEX9 = "STARTUPEX9";
    public static final String PUBDYNAINSTMODEL = "PUBDYNAINSTMODEL";
    public static final String DYNAINSTPREVIEWACTION = "DYNAINSTPREVIEWACTION";
    public static final String SYNCSYSDBSCHEMAMODEL = "SYNCSYSDBSCHEMAMODEL";
    public static final String IMPORTJSONSCHEMAMODEL = "IMPORTJSONSCHEMAMODEL";
    public static final String IBIZCENTRAL = "IBIZCENTRAL";
    public static final String IBIZMODELINGIA = "IBIZMODELINGIA";
    public static final String USER = "USER";

    public SysDevBKTaskTypeCodeListModel() {
        this.initAnnotation(SysDevBKTaskTypeCodeListModel.class);
        this.setUserData2("SysDevBKTaskType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDevBKTaskTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDevBKTaskTypeCodeListModel");
    }
}

