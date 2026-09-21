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

@CodeList(id="1BED74D3-E635-4DAA-BC35-8C52E857EF2C", name="\u5b9e\u4f53\u96c6\u5408\u8fd4\u56de\u503c\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PAGE", text="\u67e5\u8be2\u5206\u9875\u7ed3\u679c\uff08Page\uff09", realtext="\u67e5\u8be2\u5206\u9875\u7ed3\u679c\uff08Page\uff09"), @CodeItem(value="ENTITY", text="\u6570\u636e\u5bf9\u8c61\uff08Entity\uff09", realtext="\u6570\u636e\u5bf9\u8c61\uff08Entity\uff09"), @CodeItem(value="ENTITIES", text="\u6570\u636e\u5bf9\u8c61\u6570\u7ec4\uff08Entity[]\uff09", realtext="\u6570\u636e\u5bf9\u8c61\u6570\u7ec4\uff08Entity[]\uff09"), @CodeItem(value="ASYNCACTION", text="\u5f02\u6b65\u64cd\u4f5c\u5bf9\u8c61", realtext="\u5f02\u6b65\u64cd\u4f5c\u5bf9\u8c61"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49\uff08USER\uff09", realtext="\u7528\u6237\u81ea\u5b9a\u4e49\uff08USER\uff09"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492\uff08USER2\uff09", realtext="\u7528\u6237\u81ea\u5b9a\u4e492\uff08USER2\uff09")})
public class DEDataSetRetValTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String PAGE = "PAGE";
    public static final String ENTITY = "ENTITY";
    public static final String ENTITIES = "ENTITIES";
    public static final String ASYNCACTION = "ASYNCACTION";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public DEDataSetRetValTypeCodeListModel() {
        this.initAnnotation(DEDataSetRetValTypeCodeListModel.class);
        this.setUserData2("DEDataSetRetType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataSetRetValTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataSetRetValTypeCodeListModel");
    }
}

