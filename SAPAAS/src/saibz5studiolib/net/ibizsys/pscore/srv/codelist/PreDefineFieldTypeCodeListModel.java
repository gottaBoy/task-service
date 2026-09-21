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

@CodeList(id="597d076b1662a58d8187f5001572aff0", name="\u4e91\u5c5e\u6027\u9884\u5b9a\u4e49\u5c5e\u6027\u7c7b\u578b\uff08\u62fc\u5199\u6709\u8bef\uff09", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="NONE", text="\uff08\u975e\u9884\u7f6e\u5c5e\u6027\uff09", realtext="\uff08\u975e\u9884\u7f6e\u5c5e\u6027\uff09"), @CodeItem(value="LOGICVALID", text="\u903b\u8f91\u6709\u6548\u6807\u8bc6", realtext="\u903b\u8f91\u6709\u6548\u6807\u8bc6"), @CodeItem(value="CREATEMAN", text="\u5efa\u7acb\u4eba\u6807\u8bc6", realtext="\u5efa\u7acb\u4eba\u6807\u8bc6"), @CodeItem(value="CREATEMANNAME", text="\u5efa\u7acb\u4eba\u540d\u79f0", realtext="\u5efa\u7acb\u4eba\u540d\u79f0"), @CodeItem(value="CREATEDATE", text="\u5efa\u7acb\u65f6\u95f4", realtext="\u5efa\u7acb\u65f6\u95f4"), @CodeItem(value="UPDATEMAN", text="\u66f4\u65b0\u4eba\u6807\u8bc6", realtext="\u66f4\u65b0\u4eba\u6807\u8bc6"), @CodeItem(value="UPDATEMANNAME", text="\u66f4\u65b0\u4eba\u540d\u79f0", realtext="\u66f4\u65b0\u4eba\u540d\u79f0"), @CodeItem(value="UPDATEDATE", text="\u66f4\u65b0\u65f6\u95f4", realtext="\u66f4\u65b0\u65f6\u95f4"), @CodeItem(value="ORGID", text="\u7ec4\u7ec7\u673a\u6784\u6807\u8bc6", realtext="\u7ec4\u7ec7\u673a\u6784\u6807\u8bc6"), @CodeItem(value="ORGNAME", text="\u7ec4\u7ec7\u673a\u6784\u540d\u79f0", realtext="\u7ec4\u7ec7\u673a\u6784\u540d\u79f0"), @CodeItem(value="ORGSECTORID", text="\u90e8\u95e8\u6807\u8bc6", realtext="\u90e8\u95e8\u6807\u8bc6"), @CodeItem(value="ORGSECTORNAME", text="\u90e8\u95e8\u540d\u79f0", realtext="\u90e8\u95e8\u540d\u79f0")})
public class PreDefineFieldTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String LOGICVALID = "LOGICVALID";
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

    public PreDefineFieldTypeCodeListModel() {
        this.initAnnotation(PreDefineFieldTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PreDefineFieldTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PreDefineFieldTypeCodeListModel");
    }
}

