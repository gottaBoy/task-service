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

@CodeList(id="1EEEFB97-9FF8-4E73-822A-DC26CFAD5D80", name="\u7f16\u8f91\u5668\u503c\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SIMPLE", text="\u7b80\u5355\u503c", realtext="\u7b80\u5355\u503c"), @CodeItem(value="SIMPLES", text="\u7b80\u5355\u503c\u6570\u7ec4", realtext="\u7b80\u5355\u503c\u6570\u7ec4"), @CodeItem(value="OBJECT", text="\u5bf9\u8c61\uff08Object\uff09", realtext="\u5bf9\u8c61\uff08Object\uff09"), @CodeItem(value="OBJECTS", text="\u5bf9\u8c61\u6570\u7ec4\uff08Object[]\uff09", realtext="\u5bf9\u8c61\u6570\u7ec4\uff08Object[]\uff09"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49\uff08USER\uff09", realtext="\u7528\u6237\u81ea\u5b9a\u4e49\uff08USER\uff09"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492\uff08USER2\uff09", realtext="\u7528\u6237\u81ea\u5b9a\u4e492\uff08USER2\uff09")})
public class EditorValueTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SIMPLE = "SIMPLE";
    public static final String SIMPLES = "SIMPLES";
    public static final String OBJECT = "OBJECT";
    public static final String OBJECTS = "OBJECTS";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public EditorValueTypeCodeListModel() {
        this.initAnnotation(EditorValueTypeCodeListModel.class);
        this.setUserData2("EditorValueType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.EditorValueTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.EditorValueTypeCodeListModel");
    }
}

