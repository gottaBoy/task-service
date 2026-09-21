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

@CodeList(id="81b3d0045290fe4a1aa4f602b2e6ed3b", name="\u8bbf\u95ee\u63a7\u5236\u4f53\u7cfb", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u8fd0\u884c\u5b50\u7cfb\u7edf\u89d2\u8272\u4f53\u7cfb\uff08\u9ed8\u8ba4\uff09", realtext="\u8fd0\u884c\u5b50\u7cfb\u7edf\u89d2\u8272\u4f53\u7cfb\uff08\u9ed8\u8ba4\uff09", userdata="\u7531\u8fd0\u884c\u5b50\u7cfb\u7edf\u63d0\u4f9b\u57fa\u4e8e\u89d2\u8272\u7684\u8bbf\u95ee\u63a7\u5236\u4f53\u7cfb\uff08BRAC\uff09\u8fdb\u884c\u7ba1\u7406\uff0c\u6a21\u5f0f\u901a\u7528"), @CodeItem(value="2", text="\u5f53\u524d\u7cfb\u7edf\u89d2\u8272\u53ca\u5b9e\u4f53\u89d2\u8272", realtext="\u5f53\u524d\u7cfb\u7edf\u89d2\u8272\u53ca\u5b9e\u4f53\u89d2\u8272", userdata="\u5b9e\u4f53\u64cd\u4f5c\u89d2\u8272\u5b9a\u4e49\u4e86\u5b9e\u4f53\u5177\u4f53\u7684\u80fd\u529b\u6a21\u5f0f\uff0c\u7cfb\u7edf\u89d2\u8272\u5bf9\u5b9e\u4f53\u64cd\u4f5c\u89d2\u8272\u8fdb\u884c\u7ec4\u88c5\u3002\u5728\u8fd0\u884c\u73af\u5883\u4e2d\u53ea\u9700\u8981\u628a\u7528\u6237\u52a0\u5230\u7cfb\u7edf\u89d2\u8272\u4e2d\u5c31\u53ef\u4ee5\u5b8c\u6210\u7cfb\u7edf\u7684\u8d4b\u6743\u3002\u8fd9\u79cd\u6a21\u5f0f\u8d34\u8fd1\u4e1a\u52a1\uff0c\u7ba1\u7406\u7b80\u5355\uff0c\u4f46\u7531\u4e8e\u5927\u91cf\u7684\u5904\u7406\u673a\u5236\u90fd\u5185\u7f6e\u5728\u7cfb\u7edf\u4e2d\uff0c\u9700\u8981\u7cfb\u7edf\u7684\u4e1a\u52a1\u53ca\u7ba1\u7406\u6a21\u5f0f\u90fd\u5177\u5907\u76f8\u5f53\u7684\u6210\u719f\u5ea6")})
public class AccCtrlArchCodeListModel
extends StaticCodeListModelBase {
    public static final Integer RTSYSROLE = 1;
    public static final int INT_RTSYSROLE = 1;
    public static final Integer SYSROLEANDDEROLE = 2;
    public static final int INT_SYSROLEANDDEROLE = 2;

    public AccCtrlArchCodeListModel() {
        this.initAnnotation(AccCtrlArchCodeListModel.class);
        this.setUserData("IGNOREMODELDSL2");
        this.setUserData2("AccCtrlArch");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AccCtrlArchCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AccCtrlArchCodeListModel");
    }
}

