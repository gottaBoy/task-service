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

@CodeList(id="01b5cae3a58541eeab40e519a998850d", name="\u7cfb\u7edf\u503c\u8f6c\u6362\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DIGEST", text="\u5bc6\u7801\uff08\u4e0d\u53ef\u9006\uff09", realtext="\u5bc6\u7801\uff08\u4e0d\u53ef\u9006\uff09"), @CodeItem(value="ENCRYPT", text="\u52a0\u5bc6\uff08\u53ef\u9006\uff09", realtext="\u52a0\u5bc6\uff08\u53ef\u9006\uff09"), @CodeItem(value="DESTORAGE", text="\u5b9e\u4f53\u6269\u5c55\u5b58\u50a8", realtext="\u5b9e\u4f53\u6269\u5c55\u5b58\u50a8"), @CodeItem(value="CODELIST", text="\u4ee3\u7801\u8868", realtext="\u4ee3\u7801\u8868"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class TranslatorTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DIGEST = "DIGEST";
    public static final String ENCRYPT = "ENCRYPT";
    public static final String DESTORAGE = "DESTORAGE";
    public static final String CODELIST = "CODELIST";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public TranslatorTypeCodeListModel() {
        this.initAnnotation(TranslatorTypeCodeListModel.class);
        this.setUserData2("TranslatorType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.TranslatorTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.TranslatorTypeCodeListModel");
    }
}

