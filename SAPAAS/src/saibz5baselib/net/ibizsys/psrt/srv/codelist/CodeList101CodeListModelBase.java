/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="e4d7ca43e89e3362ff779839d3226867", name="\u8f93\u5165\u8f85\u52a9_\u63a7\u4ef6\u53c2\u6570", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="CARETTEMPLGROUP_SRFDA_CONTROLPARAM", text="\u63a7\u4ef6\u57fa\u672c\u53c2\u6570", realtext="\u63a7\u4ef6\u57fa\u672c\u53c2\u6570"), @CodeItem(value="CARETTEMPLGROUP_SRFDA_CONTROLPARAM_CARET", text="\u8f85\u52a9\u8f93\u5165\u63a7\u4ef6\u53c2\u6570", realtext="\u8f85\u52a9\u8f93\u5165\u63a7\u4ef6\u53c2\u6570"), @CodeItem(value="CARETTEMPLGROUP_SRFDA_CONTROLPARAM_PICKUP", text="\u9009\u62e9\u63a7\u4ef6\u53c2\u6570", realtext="\u9009\u62e9\u63a7\u4ef6\u53c2\u6570"), @CodeItem(value="CARETTEMPLGROUP_SRFDA_CONTROLPARAM_TEXTBOX", text="\u6587\u672c\u63a7\u4ef6\u53c2\u6570", realtext="\u6587\u672c\u63a7\u4ef6\u53c2\u6570"), @CodeItem(value="CARETTEMPLGROUP_SRFDA_CONTROLPARAM_PICKUPLISTBOX", text="\u9009\u62e9\u5217\u8868\u63a7\u4ef6\u53c2\u6570", realtext="\u9009\u62e9\u5217\u8868\u63a7\u4ef6\u53c2\u6570")})
public abstract class CodeList101CodeListModelBase
extends StaticCodeListModelBase {
    public static final String CARETTEMPLGROUP_SRFDA_CONTROLPARAM = "CARETTEMPLGROUP_SRFDA_CONTROLPARAM";
    public static final String CARETTEMPLGROUP_SRFDA_CONTROLPARAM_CARET = "CARETTEMPLGROUP_SRFDA_CONTROLPARAM_CARET";
    public static final String CARETTEMPLGROUP_SRFDA_CONTROLPARAM_PICKUP = "CARETTEMPLGROUP_SRFDA_CONTROLPARAM_PICKUP";
    public static final String CARETTEMPLGROUP_SRFDA_CONTROLPARAM_TEXTBOX = "CARETTEMPLGROUP_SRFDA_CONTROLPARAM_TEXTBOX";
    public static final String CARETTEMPLGROUP_SRFDA_CONTROLPARAM_PICKUPLISTBOX = "CARETTEMPLGROUP_SRFDA_CONTROLPARAM_PICKUPLISTBOX";

    public CodeList101CodeListModelBase() {
        this.initAnnotation(CodeList101CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList101CodeListModel", this);
    }
}

