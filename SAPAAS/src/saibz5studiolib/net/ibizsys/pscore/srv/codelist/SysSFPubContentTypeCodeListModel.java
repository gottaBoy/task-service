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

@CodeList(id="66af0bda9687fc911715021339eba282", name="\u7cfb\u7edf\u540e\u53f0\u4f53\u7cfb\u53d1\u5e03\u5185\u5bb9\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="CODE", text="\u8fd0\u884c\u4ee3\u7801", realtext="\u8fd0\u884c\u4ee3\u7801", userdata="\u53d1\u5e03\u7684\u5185\u5bb9\u4e3a\u4ee3\u7801"), @CodeItem(value="DOC", text="\u6587\u6863", realtext="\u6587\u6863", userdata="\u53d1\u5e03\u7684\u5185\u5bb9\u4e3a\u6587\u6863")})
public class SysSFPubContentTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String CODE = "CODE";
    public static final String DOC = "DOC";

    public SysSFPubContentTypeCodeListModel() {
        this.initAnnotation(SysSFPubContentTypeCodeListModel.class);
        this.setUserData2("SFPubContentType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysSFPubContentTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysSFPubContentTypeCodeListModel");
    }
}

