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

@CodeList(id="7204898A-6CC7-40D8-9F25-E5CB4C481E29", name="\u9884\u5b9a\u4e49\u5c5e\u6027\u7c7b\u578b", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="NONE", text="\uff08\u975e\u9884\u7f6e\u5c5e\u6027\uff09", realtext="\uff08\u975e\u9884\u7f6e\u5c5e\u6027\uff09", userdata="\u6307\u5b9a\u5f53\u524d\u5c5e\u6027\u975e\u9884\u7f6e\u5c5e\u6027\uff0c\u4e0e\u9884\u5b9a\u4e49\u7c7b\u578b\u6807\u8bc6\u540c\u540d\u7684\u5c5e\u6027\u5f15\u64ce\u4f1a\u9ed8\u8ba4\u5c06\u8be5\u5c5e\u6027\u8bbe\u7f6e\u6b64\u9884\u5b9a\u4e49\u7c7b\u578b\uff0c\u8bbe\u7f6e\u4e3a\u3010\u975e\u9884\u7f6e\u5c5e\u6027\u3011\u5c06\u5173\u95ed\u8fd9\u4e2a\u7279\u6027"), @CodeItem(value="LOGICVALID", text="\u903b\u8f91\u6709\u6548\u6807\u8bc6", realtext="\u903b\u8f91\u6709\u6548\u6807\u8bc6", userdata="\u6570\u636e\u903b\u8f91\u6709\u6548\u6807\u8bc6\u7684\u5b58\u50a8\u5c5e\u6027\uff0c\u4ec5\u5728\u5b9e\u4f53\u542f\u7528\u903b\u8f91\u5220\u9664\u65f6\u4f7f\u7528"), @CodeItem(value="ORDERVALUE", text="\u6392\u5e8f\u503c", realtext="\u6392\u5e8f\u503c", userdata="\u6307\u5b9a\u5c5e\u6027\u5b58\u50a8\u6570\u636e\u7684\u6392\u5e8f\u503c"), @CodeItem(value="VERSION", text="\u6570\u636e\u7248\u672c", realtext="\u6570\u636e\u7248\u672c", userdata="\u6307\u5b9a\u5c5e\u6027\u5b58\u50a8\u6570\u636e\u7684\u7248\u672c"), @CodeItem(value="VERSIONID", text="\u6570\u636e\u7248\u672c\u6807\u8bc6", realtext="\u6570\u636e\u7248\u672c\u6807\u8bc6", userdata="\u6307\u5b9a\u5c5e\u6027\u5b58\u50a8\u6570\u636e\u7684\u7248\u672c\u6807\u8bc6"), @CodeItem(value="CREATEMAN", text="\u5efa\u7acb\u4eba\u6807\u8bc6", realtext="\u5efa\u7acb\u4eba\u6807\u8bc6", userdata="\u6307\u5b9a\u5c5e\u6027\u5b58\u50a8\u6570\u636e\u7684\u5efa\u7acb\u4eba\u6807\u8bc6"), @CodeItem(value="CREATEMANNAME", text="\u5efa\u7acb\u4eba\u540d\u79f0", realtext="\u5efa\u7acb\u4eba\u540d\u79f0", userdata="\u6307\u5b9a\u5c5e\u6027\u5b58\u50a8\u6570\u636e\u7684\u5efa\u7acb\u4eba\u540d\u79f0"), @CodeItem(value="CREATEDATE", text="\u5efa\u7acb\u65f6\u95f4", realtext="\u5efa\u7acb\u65f6\u95f4", userdata="\u6307\u5b9a\u5c5e\u6027\u5b58\u50a8\u6570\u636e\u7684\u5efa\u7acb\u65f6\u95f4"), @CodeItem(value="UPDATEMAN", text="\u66f4\u65b0\u4eba\u6807\u8bc6", realtext="\u66f4\u65b0\u4eba\u6807\u8bc6", userdata="\u6307\u5b9a\u5c5e\u6027\u5b58\u50a8\u6570\u636e\u7684\u66f4\u65b0\u4eba\u6807\u8bc6"), @CodeItem(value="UPDATEMANNAME", text="\u66f4\u65b0\u4eba\u540d\u79f0", realtext="\u66f4\u65b0\u4eba\u540d\u79f0", userdata="\u6307\u5b9a\u5c5e\u6027\u5b58\u50a8\u6570\u636e\u7684\u66f4\u65b0\u4eba\u540d\u79f0"), @CodeItem(value="UPDATEDATE", text="\u66f4\u65b0\u65f6\u95f4", realtext="\u66f4\u65b0\u65f6\u95f4", userdata="\u6307\u5b9a\u5c5e\u6027\u5b58\u50a8\u6570\u636e\u7684\u66f4\u65b0\u65f6\u95f4"), @CodeItem(value="ORGID", text="\u7ec4\u7ec7\u673a\u6784\u6807\u8bc6", realtext="\u7ec4\u7ec7\u673a\u6784\u6807\u8bc6", userdata="\u6307\u5b9a\u5c5e\u6027\u5b58\u50a8\u6570\u636e\u7684\u6240\u5728\u7ec4\u7ec7\u6807\u8bc6"), @CodeItem(value="ORGNAME", text="\u7ec4\u7ec7\u673a\u6784\u540d\u79f0", realtext="\u7ec4\u7ec7\u673a\u6784\u540d\u79f0", userdata="\u6307\u5b9a\u5c5e\u6027\u5b58\u50a8\u6570\u636e\u7684\u6240\u5728\u7ec4\u7ec7\u540d\u79f0"), @CodeItem(value="ORGSECTORID", text="\u90e8\u95e8\u6807\u8bc6", realtext="\u90e8\u95e8\u6807\u8bc6", userdata="\u6307\u5b9a\u5c5e\u6027\u5b58\u50a8\u6570\u636e\u7684\u6240\u5728\u90e8\u95e8\u6807\u8bc6"), @CodeItem(value="ORGSECTORNAME", text="\u90e8\u95e8\u540d\u79f0", realtext="\u90e8\u95e8\u540d\u79f0", userdata="\u6307\u5b9a\u5c5e\u6027\u5b58\u50a8\u6570\u636e\u7684\u6240\u5728\u90e8\u95e8\u540d\u79f0"), @CodeItem(value="PARENTTYPE", text="\u52a8\u6001\u7236\u7c7b\u578b", realtext="\u52a8\u6001\u7236\u7c7b\u578b"), @CodeItem(value="PARENTSUBTYPE", text="\u52a8\u6001\u7236\u5b50\u7c7b\u578b", realtext="\u52a8\u6001\u7236\u5b50\u7c7b\u578b"), @CodeItem(value="PARENTID", text="\u52a8\u6001\u7236\u6807\u8bc6", realtext="\u52a8\u6001\u7236\u6807\u8bc6"), @CodeItem(value="PARENTNAME", text="\u52a8\u6001\u7236\u540d\u79f0", realtext="\u52a8\u6001\u7236\u540d\u79f0"), @CodeItem(value="PARENTDATA", text="\u52a8\u6001\u7236\u6570\u636e", realtext="\u52a8\u6001\u7236\u6570\u636e"), @CodeItem(value="PARENTVERSIONID", text="\u52a8\u6001\u7236\u7248\u672c\u6807\u8bc6", realtext="\u52a8\u6001\u7236\u7248\u672c\u6807\u8bc6"), @CodeItem(value="PARENTIDPATH", text="\u7236\u6807\u8bc6\u8def\u5f84", realtext="\u7236\u6807\u8bc6\u8def\u5f84"), @CodeItem(value="PARENTNAMEPATH", text="\u7236\u540d\u79f0\u8def\u5f84", realtext="\u7236\u540d\u79f0\u8def\u5f84"), @CodeItem(value="CHILDTYPE", text="\u52a8\u6001\u5b50\u7c7b\u578b", realtext="\u52a8\u6001\u5b50\u7c7b\u578b"), @CodeItem(value="CHILDID", text="\u52a8\u6001\u5b50\u6807\u8bc6", realtext="\u52a8\u6001\u5b50\u6807\u8bc6"), @CodeItem(value="TIMESTAMP", text="\u65f6\u95f4\u6233", realtext="\u65f6\u95f4\u6233"), @CodeItem(value="DYNASTORAGE", text="\u52a8\u6001\u5b58\u50a8", realtext="\u52a8\u6001\u5b58\u50a8", userdata="\u6307\u5b9a\u5c5e\u6027\u662f\u5f53\u524d\u5b9e\u4f53\u52a8\u6001\u6269\u5c55\u5c5e\u6027\u7684\u5b58\u50a8\u5c5e\u6027"), @CodeItem(value="CLOSEFLAG", text="\u5173\u95ed\u6807\u5fd7", realtext="\u5173\u95ed\u6807\u5fd7", userdata="\u6307\u5b9a\u5c5e\u6027\u662f\u5f53\u524d\u5b9e\u4f53\u6570\u636e\u5173\u95ed\u6807\u5fd7\u7684\u5b58\u50a8\u5c5e\u6027"), @CodeItem(value="LOCKFLAG", text="\u9501\u5b9a\u6807\u5fd7", realtext="\u9501\u5b9a\u6807\u5fd7", userdata="\u6307\u5b9a\u5c5e\u6027\u662f\u5f53\u524d\u5b9e\u4f53\u6570\u636e\u9501\u5b9a\u6807\u5fd7\u7684\u5b58\u50a8\u5c5e\u6027")})
public class PredefinedFieldTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String LOGICVALID = "LOGICVALID";
    public static final String ORDERVALUE = "ORDERVALUE";
    public static final String VERSION = "VERSION";
    public static final String VERSIONID = "VERSIONID";
    public static final String CREATEMAN = "CREATEMAN";
    public static final String CREATEMANNAME = "CREATEMANNAME";
    public static final String CREATEDATE = "CREATEDATE";
    public static final String UPDATEMAN = "UPDATEMAN";
    public static final String UPDATEMANNAME = "UPDATEMANNAME";
    public static final String UPDATEDATE = "UPDATEDATE";
    public static final String ORGID = "ORGID";
    public static final String ORGNAME = "ORGNAME";
    public static final String ORGSECTORID = "ORGSECTORID";
    public static final String ORGSECTORNAME = "ORGSECTORNAME";
    public static final String PARENTTYPE = "PARENTTYPE";
    public static final String PARENTSUBTYPE = "PARENTSUBTYPE";
    public static final String PARENTID = "PARENTID";
    public static final String PARENTNAME = "PARENTNAME";
    public static final String PARENTDATA = "PARENTDATA";
    public static final String PARENTVERSIONID = "PARENTVERSIONID";
    public static final String PARENTIDPATH = "PARENTIDPATH";
    public static final String PARENTNAMEPATH = "PARENTNAMEPATH";
    public static final String CHILDTYPE = "CHILDTYPE";
    public static final String CHILDID = "CHILDID";
    public static final String TIMESTAMP = "TIMESTAMP";
    public static final String DYNASTORAGE = "DYNASTORAGE";
    public static final String CLOSEFLAG = "CLOSEFLAG";
    public static final String LOCKFLAG = "LOCKFLAG";

    public PredefinedFieldTypeCodeListModel() {
        this.initAnnotation(PredefinedFieldTypeCodeListModel.class);
        this.setUserData2("PredefinedFieldType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PredefinedFieldTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PredefinedFieldTypeCodeListModel");
    }
}

