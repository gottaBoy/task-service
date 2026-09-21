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

@CodeList(id="34626cd94d048a68bf2da67d2a489657", name="\u5e2e\u52a9\u7ae0\u8282\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DECONCEPTS", text="\u5b9e\u4f53\u6982\u5ff5\u96c6\u5408", realtext="\u5b9e\u4f53\u6982\u5ff5\u96c6\u5408", iconpath="default/pshelpsection/icon_sectiontype_deconcepts.png", iconpathx="default/pshelpsection/icon_sectiontype_deconcepts@{0}x.png"), @CodeItem(value="DECONCEPT", text="\u5b9e\u4f53\u6982\u5ff5\u9879", realtext="\u5b9e\u4f53\u6982\u5ff5\u9879", iconpath="default/pshelpsection/icon_sectiontype_deconcept.png", iconpathx="default/pshelpsection/icon_sectiontype_deconcept@{0}x.png"), @CodeItem(value="DEFDESCS", text="\u5c5e\u6027\u8bf4\u660e\u96c6\u5408", realtext="\u5c5e\u6027\u8bf4\u660e\u96c6\u5408", iconpath="default/pshelpsection/icon_sectiontype_defdescs.png", iconpathx="default/pshelpsection/icon_sectiontype_defdescs@{0}x.png"), @CodeItem(value="DEFDESC", text="\u5c5e\u6027\u8bf4\u660e\u9879", realtext="\u5c5e\u6027\u8bf4\u660e\u9879", iconpath="default/pshelpsection/icon_sectiontype_defdesc.png", iconpathx="default/pshelpsection/icon_sectiontype_defdesc@{0}x.png"), @CodeItem(value="DEMANUALS", text="\u5b9e\u4f53\u64cd\u4f5c\u96c6\u5408", realtext="\u5b9e\u4f53\u64cd\u4f5c\u96c6\u5408", iconpath="default/pshelpsection/icon_sectiontype_demanuals.png", iconpathx="default/pshelpsection/icon_sectiontype_demanuals@{0}x.png"), @CodeItem(value="DEMANUALCAT", text="\u5b9e\u4f53\u64cd\u4f5c\u5206\u7c7b", realtext="\u5b9e\u4f53\u64cd\u4f5c\u5206\u7c7b", iconpath="default/pshelpsection/icon_sectiontype_demanualcat.png", iconpathx="default/pshelpsection/icon_sectiontype_demanualcat@{0}x.png"), @CodeItem(value="DEMANUAL", text="\u5b9e\u4f53\u64cd\u4f5c\u9879", realtext="\u5b9e\u4f53\u64cd\u4f5c\u9879", iconpath="default/pshelpsection/icon_sectiontype_demanual.png", iconpathx="default/pshelpsection/icon_sectiontype_demanual@{0}x.png"), @CodeItem(value="DEUIACTIONS", text="\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u96c6\u5408", realtext="\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u96c6\u5408", iconpath="default/pshelpsection/icon_sectiontype_deuiactions.png", iconpathx="default/pshelpsection/icon_sectiontype_deuiactions@{0}x.png"), @CodeItem(value="DEUIACTION", text="\u5b9e\u4f53\u754c\u9762\u884c\u4e3a", realtext="\u5b9e\u4f53\u754c\u9762\u884c\u4e3a", iconpath="default/pshelpsection/icon_sectiontype_deuiaction.png", iconpathx="default/pshelpsection/icon_sectiontype_deuiaction@{0}x.png"), @CodeItem(value="EXAMPLE", text="\u793a\u4f8b\u9879", realtext="\u793a\u4f8b\u9879", iconpath="default/pshelpsection/icon_sectiontype_example.png", iconpathx="default/pshelpsection/icon_sectiontype_example@{0}x.png"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494"), @CodeItem(value="USER5", text="\u7528\u6237\u81ea\u5b9a\u4e495", realtext="\u7528\u6237\u81ea\u5b9a\u4e495"), @CodeItem(value="USER6", text="\u7528\u6237\u81ea\u5b9a\u4e496", realtext="\u7528\u6237\u81ea\u5b9a\u4e496"), @CodeItem(value="USER7", text="\u7528\u6237\u81ea\u5b9a\u4e497", realtext="\u7528\u6237\u81ea\u5b9a\u4e497"), @CodeItem(value="USER8", text="\u7528\u6237\u81ea\u5b9a\u4e498", realtext="\u7528\u6237\u81ea\u5b9a\u4e498"), @CodeItem(value="USER9", text="\u7528\u6237\u81ea\u5b9a\u4e499", realtext="\u7528\u6237\u81ea\u5b9a\u4e499")})
public class HelpSectionTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DECONCEPTS = "DECONCEPTS";
    public static final String DECONCEPT = "DECONCEPT";
    public static final String DEFDESCS = "DEFDESCS";
    public static final String DEFDESC = "DEFDESC";
    public static final String DEMANUALS = "DEMANUALS";
    public static final String DEMANUALCAT = "DEMANUALCAT";
    public static final String DEMANUAL = "DEMANUAL";
    public static final String DEUIACTIONS = "DEUIACTIONS";
    public static final String DEUIACTION = "DEUIACTION";
    public static final String EXAMPLE = "EXAMPLE";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";
    public static final String USER5 = "USER5";
    public static final String USER6 = "USER6";
    public static final String USER7 = "USER7";
    public static final String USER8 = "USER8";
    public static final String USER9 = "USER9";

    public HelpSectionTypeCodeListModel() {
        this.initAnnotation(HelpSectionTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.HelpSectionTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.HelpSectionTypeCodeListModel");
    }
}

