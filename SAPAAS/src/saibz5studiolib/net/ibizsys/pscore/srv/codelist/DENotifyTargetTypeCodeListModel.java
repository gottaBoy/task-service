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

@CodeList(id="6da957ecb99da27a6c7fe1a79b74c9c5", name="\u5b9e\u4f53\u901a\u77e5\u76ee\u6807\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEFIELD", text="\u5f53\u524d\u5b9e\u4f53\u5c5e\u6027", realtext="\u5f53\u524d\u5b9e\u4f53\u5c5e\u6027"), @CodeItem(value="SYSMSGTARGET", text="\u7cfb\u7edf\u6d88\u606f\u76ee\u6807", realtext="\u7cfb\u7edf\u6d88\u606f\u76ee\u6807"), @CodeItem(value="EVENTDATAFIELD", text="\u4e8b\u4ef6\u6570\u636e\u5c5e\u6027\uff08\u8fd0\u884c\u65f6\u652f\u6301\uff09", realtext="\u4e8b\u4ef6\u6570\u636e\u5c5e\u6027\uff08\u8fd0\u884c\u65f6\u652f\u6301\uff09"), @CodeItem(value="DSTUSER", text="\u76ee\u6807\u7528\u6237\uff08\u8fd0\u884c\u65f6\u652f\u6301\uff09", realtext="\u76ee\u6807\u7528\u6237\uff08\u8fd0\u884c\u65f6\u652f\u6301\uff09"), @CodeItem(value="DSTDEPARTMENT", text="\u76ee\u6807\u90e8\u95e8\uff08\u8fd0\u884c\u65f6\u652f\u6301\uff09", realtext="\u76ee\u6807\u90e8\u95e8\uff08\u8fd0\u884c\u65f6\u652f\u6301\uff09"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class DENotifyTargetTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFIELD = "DEFIELD";
    public static final String SYSMSGTARGET = "SYSMSGTARGET";
    public static final String EVENTDATAFIELD = "EVENTDATAFIELD";
    public static final String DSTUSER = "DSTUSER";
    public static final String DSTDEPARTMENT = "DSTDEPARTMENT";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public DENotifyTargetTypeCodeListModel() {
        this.initAnnotation(DENotifyTargetTypeCodeListModel.class);
        this.setUserData("IGNOREMODELDSL2");
        this.setUserData2("DENotifyTargetType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DENotifyTargetTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DENotifyTargetTypeCodeListModel");
    }
}

