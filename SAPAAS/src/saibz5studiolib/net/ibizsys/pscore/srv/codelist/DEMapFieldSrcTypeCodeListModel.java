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

@CodeList(id="cb6940a2fa00fa2d3d0dafc4e771aa0d", name="\u5b9e\u4f53\u6620\u5c04\u5c5e\u6027\u6e90\u503c\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="FIELD", text="\u5c5e\u6027\u7b49\u4ef7", realtext="\u5c5e\u6027\u7b49\u4ef7", userdata="\u6e90\u5c5e\u6027\u4e0e\u76ee\u6807\u5c5e\u6027\u7b49\u4ef7"), @CodeItem(value="VALUE", text="\u76f4\u63a5\u503c\u5230\u76ee\u6807\u5c5e\u6027", realtext="\u76f4\u63a5\u503c\u5230\u76ee\u6807\u5c5e\u6027", userdata="\u76f4\u63a5\u503c\u8bbe\u7f6e\u5230\u76ee\u6807\u5c5e\u6027"), @CodeItem(value="EXPRESSION", text="\u8ba1\u7b97\u503c\u5230\u76ee\u6807\u5c5e\u6027", realtext="\u8ba1\u7b97\u503c\u5230\u76ee\u6807\u5c5e\u6027", userdata="\u8868\u8fbe\u5f0f\u8ba1\u7b97\u503c\u8bbe\u7f6e\u5230\u76ee\u6807\u5c5e\u6027"), @CodeItem(value="VALUE_SRC", text="\u76f4\u63a5\u503c\u5230\u6e90\u5c5e\u6027", realtext="\u76f4\u63a5\u503c\u5230\u6e90\u5c5e\u6027", userdata="\u76f4\u63a5\u503c\u8bbe\u7f6e\u5230\u6e90\u5c5e\u6027"), @CodeItem(value="EXPRESSION_SRC", text="\u8ba1\u7b97\u503c\u5230\u6e90\u5c5e\u6027", realtext="\u8ba1\u7b97\u503c\u5230\u6e90\u5c5e\u6027", userdata="\u8868\u8fbe\u5f0f\u8ba1\u7b97\u503c\u8bbe\u7f6e\u5230\u6e90\u5c5e\u6027")})
public class DEMapFieldSrcTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String FIELD = "FIELD";
    public static final String VALUE = "VALUE";
    public static final String EXPRESSION = "EXPRESSION";
    public static final String VALUE_SRC = "VALUE_SRC";
    public static final String EXPRESSION_SRC = "EXPRESSION_SRC";

    public DEMapFieldSrcTypeCodeListModel() {
        this.initAnnotation(DEMapFieldSrcTypeCodeListModel.class);
        this.setUserData2("DEMapFieldSrcType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMapFieldSrcTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMapFieldSrcTypeCodeListModel");
    }
}

