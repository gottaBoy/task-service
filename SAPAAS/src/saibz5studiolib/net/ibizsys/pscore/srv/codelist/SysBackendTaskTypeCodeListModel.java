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

@CodeList(id="8e83bbdd392c6d83a35cf0f08c97d89d", name="\u4e91\u7cfb\u7edf\u540e\u53f0\u4efb\u52a1\u4f5c\u4e1a\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PREDEFINED", text="\u9884\u5b9a\u4e49", realtext="\u9884\u5b9a\u4e49"), @CodeItem(value="DEACTION", text="\u89e6\u53d1\u5b9e\u4f53\u884c\u4e3a", realtext="\u89e6\u53d1\u5b9e\u4f53\u884c\u4e3a"), @CodeItem(value="USER", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49")})
public class SysBackendTaskTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String PREDEFINED = "PREDEFINED";
    public static final String DEACTION = "DEACTION";
    public static final String USER = "USER";

    public SysBackendTaskTypeCodeListModel() {
        this.initAnnotation(SysBackendTaskTypeCodeListModel.class);
        this.setUserData2("BackendTaskType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysBackendTaskTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysBackendTaskTypeCodeListModel");
    }
}

