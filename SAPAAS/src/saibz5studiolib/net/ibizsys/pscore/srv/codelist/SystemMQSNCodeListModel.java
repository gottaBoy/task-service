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

@CodeList(id="f0324fedbf48ec9864782f3b130c37f4", name="\u4e91\u7cfb\u7edfMQ\u6807\u8bc6", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="MQ01", text="MQ01", realtext="MQ01"), @CodeItem(value="MQ02", text="MQ02", realtext="MQ02"), @CodeItem(value="MQ03", text="MQ03", realtext="MQ03"), @CodeItem(value="MQ04", text="MQ04", realtext="MQ04"), @CodeItem(value="MQ05", text="MQ05", realtext="MQ05"), @CodeItem(value="MQ06", text="MQ06", realtext="MQ06"), @CodeItem(value="MQ07", text="MQ07", realtext="MQ07"), @CodeItem(value="MQ08", text="MQ08", realtext="MQ08"), @CodeItem(value="MQ09", text="MQ09", realtext="MQ09"), @CodeItem(value="MQ10", text="MQ10", realtext="MQ10")})
public class SystemMQSNCodeListModel
extends StaticCodeListModelBase {
    public static final String MQ01 = "MQ01";
    public static final String MQ02 = "MQ02";
    public static final String MQ03 = "MQ03";
    public static final String MQ04 = "MQ04";
    public static final String MQ05 = "MQ05";
    public static final String MQ06 = "MQ06";
    public static final String MQ07 = "MQ07";
    public static final String MQ08 = "MQ08";
    public static final String MQ09 = "MQ09";
    public static final String MQ10 = "MQ10";

    public SystemMQSNCodeListModel() {
        this.initAnnotation(SystemMQSNCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SystemMQSNCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SystemMQSNCodeListModel");
    }
}

