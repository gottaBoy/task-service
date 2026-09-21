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

@CodeList(id="557d8913d7473e544ee914ab806ebed8", name="\u516c\u544a\u76ee\u6807\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="ALL", text="\u5168\u90e8", realtext="\u5168\u90e8"), @CodeItem(value="\u6307\u5b9a\u5e94\u7528\u4e2d\u5fc3", text="DC", realtext="DC")})
public class DCBulletinTargetTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String ALL = "ALL";
    public static final String ITEM_2 = "\u6307\u5b9a\u5e94\u7528\u4e2d\u5fc3";

    public DCBulletinTargetTypeCodeListModel() {
        this.initAnnotation(DCBulletinTargetTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DCBulletinTargetTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DCBulletinTargetTypeCodeListModel");
    }
}

