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

@CodeList(id="be2e99ec5ab27e9ff7e94962be7fa54a", name="\u5e2e\u52a9\u6587\u7ae0\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEMODEL", text="\u5b9e\u4f53\u5e2e\u52a9", realtext="\u5b9e\u4f53\u5e2e\u52a9", iconpath="default/pshelparticle/icon_articletype_demodel.png", iconpathx="default/pshelparticle/icon_articletype_demodel@{0}x.png"), @CodeItem(value="MANUAL", text="\u64cd\u4f5c\u5e2e\u52a9", realtext="\u64cd\u4f5c\u5e2e\u52a9", iconpath="default/pshelparticle/icon_articletype_manual.png", iconpathx="default/pshelparticle/icon_articletype_manual@{0}x.png"), @CodeItem(value="COMMON", text="\u5e38\u89c4", realtext="\u5e38\u89c4", iconpath="default/pshelparticle/icon_articletype_common.png", iconpathx="default/pshelparticle/icon_articletype_common@{0}x.png"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49", iconpath="helparticletype/icon_user.png", iconpathx="helparticletype/icon_user@{0}x.png"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492", iconpath="helparticletype/icon_user2.png", iconpathx="helparticletype/icon_user2@{0}x.png")})
public class HelpArticleTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEMODEL = "DEMODEL";
    public static final String MANUAL = "MANUAL";
    public static final String COMMON = "COMMON";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public HelpArticleTypeCodeListModel() {
        this.initAnnotation(HelpArticleTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.HelpArticleTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.HelpArticleTypeCodeListModel");
    }
}

