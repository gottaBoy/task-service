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

@CodeList(id="932247A3-B627-4A3B-8B7B-EC8482EADAB3", name="\u5b9e\u4f53\u529f\u80fd\u914d\u7f6e\u7c7b\u578b\uff08\u7cfb\u7edf\u5168\u5c40\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DATAAUDIT", text="\u6570\u636e\u5ba1\u8ba1", realtext="\u6570\u636e\u5ba1\u8ba1", iconpath="default/pssysutilde/icon_utiltype_dataaudit.png", iconpathx="default/pssysutilde/icon_utiltype_dataaudit@{0}x.png", userdata="\u5b9a\u4e49\u7cfb\u7edf\u7684\u6570\u636e\u5ba1\u8ba1\u529f\u80fd\u914d\u7f6e\uff0c\u5305\u62ec\u4e86\u8bb0\u5f55\u5ba1\u8ba1\u4fe1\u606f\u7684\u5b9e\u4f53\u7b49"), @CodeItem(value="FILE", text="\u9644\u4ef6\u5b58\u50a8", realtext="\u9644\u4ef6\u5b58\u50a8", userdata="\u5b9a\u4e49\u7cfb\u7edf\u7684\u9644\u4ef6\u529f\u80fd\u914d\u7f6e\uff0c\u5305\u62ec\u4e86\u9644\u4ef6\u7684\u5b58\u50a8\u5b9e\u4f53\u7b49"), @CodeItem(value="APPCUSTOMIZE", text="\u5e94\u7528\u81ea\u5b9a\u4e49", realtext="\u5e94\u7528\u81ea\u5b9a\u4e49", iconpath="sysdeutiltype/icon_appcustomize.png", iconpathx="sysdeutiltype/icon_appcustomize@{0}x.png", userdata="\u5b9a\u4e49\u7cfb\u7edf\u5e94\u7528\u7684\u81ea\u5b9a\u4e49\u529f\u80fd"), @CodeItem(value="EXTENSION", text="\u7cfb\u7edf\u6269\u5c55", realtext="\u7cfb\u7edf\u6269\u5c55"), @CodeItem(value="ACFACTORY", text="AI\u5de5\u5382", realtext="AI\u5de5\u5382"), @CodeItem(value="SAASADMIN", text="SaaS\u5e94\u7528\u7ba1\u7406", realtext="SaaS\u5e94\u7528\u7ba1\u7406", iconpath="sysdeutiltype/icon_saasadmin.png", iconpathx="sysdeutiltype/icon_saasadmin@{0}x.png"), @CodeItem(value="SAASUSERAUTH", text="SaaS\u7528\u6237\u6388\u6743\uff08\u5185\u7f6e\uff09", realtext="SaaS\u7528\u6237\u6388\u6743\uff08\u5185\u7f6e\uff09", iconpath="sysdeutiltype/icon_saasuserauth.png", iconpathx="sysdeutiltype/icon_saasuserauth@{0}x.png"), @CodeItem(value="SAASUSERAUTHSERVICE", text="SaaS\u7528\u6237\u6388\u6743\u670d\u52a1\uff08\u5bf9\u5916\uff09", realtext="SaaS\u7528\u6237\u6388\u6743\u670d\u52a1\uff08\u5bf9\u5916\uff09", iconpath="sysdeutiltype/icon_saasuserauth.png", iconpathx="sysdeutiltype/icon_saasuserauth@{0}x.png"), @CodeItem(value="SAASORG", text="SaaS\u7ec4\u7ec7\u529f\u80fd\uff08\u5185\u7f6e\uff09", realtext="SaaS\u7ec4\u7ec7\u529f\u80fd\uff08\u5185\u7f6e\uff09", iconpath="sysdeutiltype/icon_saasorgsync.png", iconpathx="sysdeutiltype/icon_saasorgsync@{0}x.png"), @CodeItem(value="SAASORGSERVICE", text="SaaS\u7ec4\u7ec7\u670d\u52a1\uff08\u5bf9\u5916\uff09", realtext="SaaS\u7ec4\u7ec7\u670d\u52a1\uff08\u5bf9\u5916\uff09", iconpath="sysdeutiltype/icon_saasorgservice.png", iconpathx="sysdeutiltype/icon_saasorgservice@{0}x.png"), @CodeItem(value="SAASWF", text="SaaS\u6d41\u7a0b\u5f15\u64ce\u529f\u80fd\uff08\u5185\u7f6e\uff09", realtext="SaaS\u6d41\u7a0b\u5f15\u64ce\u529f\u80fd\uff08\u5185\u7f6e\uff09", iconpath="sysdeutiltype/icon_saaswf.png", iconpathx="sysdeutiltype/icon_saaswf@{0}x.png"), @CodeItem(value="SAASWFSERVICE", text="SaaS\u6d41\u7a0b\u5f15\u64ce\u670d\u52a1\uff08\u5bf9\u5916\uff09", realtext="SaaS\u6d41\u7a0b\u5f15\u64ce\u670d\u52a1\uff08\u5bf9\u5916\uff09", iconpath="sysdeutiltype/icon_saaswfservice.png", iconpathx="sysdeutiltype/icon_saaswfservice@{0}x.png"), @CodeItem(value="SAASCORESERVICE", text="SaaS\u6838\u5fc3\u670d\u52a1\uff08\u5bf9\u5916\uff09", realtext="SaaS\u6838\u5fc3\u670d\u52a1\uff08\u5bf9\u5916\uff09", iconpath="sysdeutiltype/icon_saascoreservice.png", iconpathx="sysdeutiltype/icon_saascoreservice@{0}x.png"), @CodeItem(value="LOGLISTENER", text="\u65e5\u5fd7\u4fa6\u542c", realtext="\u65e5\u5fd7\u4fa6\u542c", userdata="\u5b9a\u4e49\u7cfb\u7edf\u65e5\u5fd7\u4fa6\u542c\u5668\u529f\u80fd\u914d\u7f6e\uff0c\u5305\u62ec\u4e86\u65e5\u5fd7\u7684\u5b58\u50a8\u5b9e\u4f53\u7b49"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49")})
public class SysDEUtilTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DATAAUDIT = "DATAAUDIT";
    public static final String FILE = "FILE";
    public static final String APPCUSTOMIZE = "APPCUSTOMIZE";
    public static final String EXTENSION = "EXTENSION";
    public static final String ACFACTORY = "ACFACTORY";
    public static final String SAASADMIN = "SAASADMIN";
    public static final String SAASUSERAUTH = "SAASUSERAUTH";
    public static final String SAASUSERAUTHSERVICE = "SAASUSERAUTHSERVICE";
    public static final String SAASORG = "SAASORG";
    public static final String SAASORGSERVICE = "SAASORGSERVICE";
    public static final String SAASWF = "SAASWF";
    public static final String SAASWFSERVICE = "SAASWFSERVICE";
    public static final String SAASCORESERVICE = "SAASCORESERVICE";
    public static final String LOGLISTENER = "LOGLISTENER";
    public static final String USER = "USER";

    public SysDEUtilTypeCodeListModel() {
        this.initAnnotation(SysDEUtilTypeCodeListModel.class);
        this.setUserData2("SysUtilType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDEUtilTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDEUtilTypeCodeListModel");
    }
}

