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

@CodeList(id="cbff783010beae081bf802d7f0e6a49a", name="\u5e94\u7528\u4e2d\u5fc3\u6587\u4ef6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u5b58\u50a8\u533a\u57df", realtext="\u5b58\u50a8\u533a\u57df"), @CodeItem(value="20", text="\u6587\u4ef6\u5939", realtext="\u6587\u4ef6\u5939"), @CodeItem(value="30", text="\u6587\u4ef6", realtext="\u6587\u4ef6")})
public class DevCenterFileTypeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer DISK = 10;
    public static final int INT_DISK = 10;
    public static final Integer FOLDER = 20;
    public static final int INT_FOLDER = 20;
    public static final Integer FILE = 30;
    public static final int INT_FILE = 30;

    public DevCenterFileTypeCodeListModel() {
        this.initAnnotation(DevCenterFileTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevCenterFileTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevCenterFileTypeCodeListModel");
    }
}

