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

@CodeList(id="AB6BAE03-9E95-463D-8CB8-B84E52901D16", name="\u6a21\u578b\u9501\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\u65e0\u9501\u5b9a")
@CodeItems(value={@CodeItem(value="0", text="\u65e0\u9501\u5b9a\uff08\u9ed8\u8ba4\uff09", realtext="\u65e0\u9501\u5b9a\uff08\u9ed8\u8ba4\uff09"), @CodeItem(value="1", text="\u7981\u6b62\u7528\u6237\u4fee\u6539", realtext="\u7981\u6b62\u7528\u6237\u4fee\u6539"), @CodeItem(value="2", text="\u7981\u6b62\u5b50\u7cfb\u7edf\u5bfc\u5165", realtext="\u7981\u6b62\u5b50\u7cfb\u7edf\u5bfc\u5165"), @CodeItem(value="3", text="\u7981\u6b62\u7528\u6237\u4fee\u6539\u53ca\u5b50\u7cfb\u7edf\u5bfc\u5165", realtext="\u7981\u6b62\u7528\u6237\u4fee\u6539\u53ca\u5b50\u7cfb\u7edf\u5bfc\u5165")})
public class ModelLockModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer NOUSER = 1;
    public static final int INT_NOUSER = 1;
    public static final Integer NOSUBSYS = 2;
    public static final int INT_NOSUBSYS = 2;
    public static final Integer NOUSERANDNOSUBSYS = 3;
    public static final int INT_NOUSERANDNOSUBSYS = 3;

    public ModelLockModeCodeListModel() {
        this.initAnnotation(ModelLockModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelLockModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelLockModeCodeListModel");
    }
}

