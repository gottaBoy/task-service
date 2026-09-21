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

@CodeList(id="ade55fb2660a2b7e97ecd012575035e1", name="\u96c6\u6210\u5143\u7d20\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="COMPLEX", text="\u590d\u5408\u5143\u7d20", realtext="\u590d\u5408\u5143\u7d20"), @CodeItem(value="ELEMENTGROUP", text="\u5143\u7d20\u7ec4", realtext="\u5143\u7d20\u7ec4"), @CodeItem(value="ATTRIBUTEGROUP", text="\u5c5e\u6027\u7ec4", realtext="\u5c5e\u6027\u7ec4")})
public class EAIElementTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String COMPLEX = "COMPLEX";
    public static final String ELEMENTGROUP = "ELEMENTGROUP";
    public static final String ATTRIBUTEGROUP = "ATTRIBUTEGROUP";

    public EAIElementTypeCodeListModel() {
        this.initAnnotation(EAIElementTypeCodeListModel.class);
        this.setUserData2("EAIElementType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.EAIElementTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.EAIElementTypeCodeListModel");
    }
}

