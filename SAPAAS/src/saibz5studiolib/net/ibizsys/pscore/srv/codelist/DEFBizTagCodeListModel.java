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

@CodeList(id="3ebab78a91f9547c597f2f470815ada6", name="\u5b9e\u4f53\u5c5e\u6027\u4e1a\u52a1\u6807\u8bb0", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="WFINSTANCEID", text="\u6d41\u7a0b\u5b9e\u4f8b\u6807\u8bc6", realtext="\u6d41\u7a0b\u5b9e\u4f8b\u6807\u8bc6"), @CodeItem(value="WFSTEP", text="\u6d41\u7a0b\u5b9e\u4f8b\u6b65\u9aa4\u503c", realtext="\u6d41\u7a0b\u5b9e\u4f8b\u6b65\u9aa4\u503c", userdata="\u6d41\u7a0b\u5b9e\u4f8b\u5728\u6d41\u7a0b\u4e2d\u7684\u6b65\u9aa4\u503c"), @CodeItem(value="WFUSERSTATE", text="\u6d41\u7a0b\u5b9e\u4f8b\u4e1a\u52a1\u72b6\u6001", realtext="\u6d41\u7a0b\u5b9e\u4f8b\u4e1a\u52a1\u72b6\u6001"), @CodeItem(value="WFVERSION", text="\u6d41\u7a0b\u5b9e\u4f8b\u7248\u672c", realtext="\u6d41\u7a0b\u5b9e\u4f8b\u7248\u672c", userdata="\u6d41\u7a0b\u5b9e\u4f8b\u4f7f\u7528\u7684\u5de5\u4f5c\u6d41\u7248\u672c"), @CodeItem(value="WFSTATE", text="\u6d41\u7a0b\u5b9e\u4f8b\u72b6\u6001", realtext="\u6d41\u7a0b\u5b9e\u4f8b\u72b6\u6001", userdata="\u6d41\u7a0b\u5b9e\u4f8b\u7684\u7cfb\u7edf\u7ea7\u72b6\u6001"), @CodeItem(value="BEGINTIME", text="\u5f00\u59cb\u65f6\u95f4", realtext="\u5f00\u59cb\u65f6\u95f4"), @CodeItem(value="ENDTIME", text="\u7ed3\u675f\u65f6\u95f4", realtext="\u7ed3\u675f\u65f6\u95f4"), @CodeItem(value="DURATION", text="\u6301\u7eed\u65f6\u95f4", realtext="\u6301\u7eed\u65f6\u95f4"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494"), @CodeItem(value="USER5", text="\u7528\u6237\u81ea\u5b9a\u4e495", realtext="\u7528\u6237\u81ea\u5b9a\u4e495"), @CodeItem(value="USER6", text="\u7528\u6237\u81ea\u5b9a\u4e496", realtext="\u7528\u6237\u81ea\u5b9a\u4e496"), @CodeItem(value="USER7", text="\u7528\u6237\u81ea\u5b9a\u4e497", realtext="\u7528\u6237\u81ea\u5b9a\u4e497"), @CodeItem(value="USER8", text="\u7528\u6237\u81ea\u5b9a\u4e498", realtext="\u7528\u6237\u81ea\u5b9a\u4e498"), @CodeItem(value="USER9", text="\u7528\u6237\u81ea\u5b9a\u4e499", realtext="\u7528\u6237\u81ea\u5b9a\u4e499")})
public class DEFBizTagCodeListModel
extends StaticCodeListModelBase {
    public static final String WFINSTANCEID = "WFINSTANCEID";
    public static final String WFSTEP = "WFSTEP";
    public static final String WFUSERSTATE = "WFUSERSTATE";
    public static final String WFVERSION = "WFVERSION";
    public static final String WFSTATE = "WFSTATE";
    public static final String BEGINTIME = "BEGINTIME";
    public static final String ENDTIME = "ENDTIME";
    public static final String DURATION = "DURATION";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";
    public static final String USER5 = "USER5";
    public static final String USER6 = "USER6";
    public static final String USER7 = "USER7";
    public static final String USER8 = "USER8";
    public static final String USER9 = "USER9";

    public DEFBizTagCodeListModel() {
        this.initAnnotation(DEFBizTagCodeListModel.class);
        this.setUserData2("DEFBizTag");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFBizTagCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFBizTagCodeListModel");
    }
}

