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

@CodeList(id="498fa82821f08be05817385f9de1a571", name="\u5de5\u7a0b\u9879\u76ee\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u53d1\u5e03\u9879\u76ee", realtext="\u53d1\u5e03\u9879\u76ee"), @CodeItem(value="2", text="\u7528\u6237\u9879\u76ee", realtext="\u7528\u6237\u9879\u76ee"), @CodeItem(value="3", text="\u53d1\u5e03\u53ca\u7528\u6237\u9879\u76ee", realtext="\u53d1\u5e03\u53ca\u7528\u6237\u9879\u76ee")})
public class WorkshopPrjTypeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer PUB = 1;
    public static final int INT_PUB = 1;
    public static final Integer USER = 2;
    public static final int INT_USER = 2;
    public static final Integer PUBANDUSER = 3;
    public static final int INT_PUBANDUSER = 3;

    public WorkshopPrjTypeCodeListModel() {
        this.initAnnotation(WorkshopPrjTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WorkshopPrjTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WorkshopPrjTypeCodeListModel");
    }
}

