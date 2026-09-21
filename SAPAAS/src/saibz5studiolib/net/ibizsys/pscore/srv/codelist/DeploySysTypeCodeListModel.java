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

@CodeList(id="9a678a66407325d6ab2037cf9cc6039f", name="\u90e8\u7f72\u7cfb\u7edf\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="MS_PSMODELTOOL", text="\u5408\u5e76\u7cfb\u7edf\uff08\u6a21\u578b\u8bbe\u8ba1\u5de5\u5177\uff09", realtext="\u5408\u5e76\u7cfb\u7edf\uff08\u6a21\u578b\u8bbe\u8ba1\u5de5\u5177\uff09"), @CodeItem(value="MS_SERVICEHUB", text="\u5408\u5e76\u7cfb\u7edf\uff08\u670d\u52a1\u603b\u7ebf\uff09", realtext="\u5408\u5e76\u7cfb\u7edf\uff08\u670d\u52a1\u603b\u7ebf\uff09"), @CodeItem(value="MS_EMBEDED", text="\u5408\u5e76\u7cfb\u7edf\uff08\u6a21\u578b\u5d4c\u5165\uff09", realtext="\u5408\u5e76\u7cfb\u7edf\uff08\u6a21\u578b\u5d4c\u5165\uff09"), @CodeItem(value="ORGWFSYS", text="\u673a\u6784\u6d41\u7a0b\u8fd0\u884c\u7cfb\u7edf\uff08\u5e9f\u5f03\uff09", realtext="\u673a\u6784\u6d41\u7a0b\u8fd0\u884c\u7cfb\u7edf\uff08\u5e9f\u5f03\uff09"), @CodeItem(value="ORGSECTORWFSYS", text="\u90e8\u95e8\u6d41\u7a0b\u8fd0\u884c\u7cfb\u7edf\uff08\u5e9f\u5f03\uff09", realtext="\u90e8\u95e8\u6d41\u7a0b\u8fd0\u884c\u7cfb\u7edf\uff08\u5e9f\u5f03\uff09"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class DeploySysTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String MS_PSMODELTOOL = "MS_PSMODELTOOL";
    public static final String MS_SERVICEHUB = "MS_SERVICEHUB";
    public static final String MS_EMBEDED = "MS_EMBEDED";
    public static final String ORGWFSYS = "ORGWFSYS";
    public static final String ORGSECTORWFSYS = "ORGSECTORWFSYS";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public DeploySysTypeCodeListModel() {
        this.initAnnotation(DeploySysTypeCodeListModel.class);
        this.setUserData2("DeploySysType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DeploySysTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DeploySysTypeCodeListModel");
    }
}

