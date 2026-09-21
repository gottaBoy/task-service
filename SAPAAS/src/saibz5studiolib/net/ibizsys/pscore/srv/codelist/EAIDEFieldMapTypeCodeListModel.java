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

@CodeList(id="2b805020976678757a65279ec4ba3185", name="\u5e94\u7528\u96c6\u6210\u5b9e\u4f53\u5c5e\u6027\u6620\u5c04\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="ATTRIBUTE", text="\u5c5e\u6027", realtext="\u5c5e\u6027"), @CodeItem(value="ELEMENT", text="\u7b80\u5355\u5143\u7d20", realtext="\u7b80\u5355\u5143\u7d20")})
public class EAIDEFieldMapTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String ATTRIBUTE = "ATTRIBUTE";
    public static final String ELEMENT = "ELEMENT";

    public EAIDEFieldMapTypeCodeListModel() {
        this.initAnnotation(EAIDEFieldMapTypeCodeListModel.class);
        this.setUserData2("EAIDEFieldMapType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.EAIDEFieldMapTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.EAIDEFieldMapTypeCodeListModel");
    }
}

