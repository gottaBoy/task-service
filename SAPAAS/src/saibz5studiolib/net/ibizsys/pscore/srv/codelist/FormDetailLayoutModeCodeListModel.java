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

@CodeList(id="6207c782d2a3d84a5ba26971201f17ef", name="\u8868\u5355\u5e03\u5c40\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TABLE_12COL", text="\u6805\u683c\u5e03\u5c40\uff0812\u5217\u5747\u5206\uff09", realtext="\u6805\u683c\u5e03\u5c40\uff0812\u5217\u5747\u5206\uff09", userdata="12\u5217\u6805\u683c\u5e03\u5c40\uff0c\u4e00\u822c\u5e94\u7528\u4e8e\u6d41\u5e03\u5c40\u6a21\u5f0f\uff0c\u6210\u5458\u5360\u4f4d\u8303\u56f41~12"), @CodeItem(value="TABLE_24COL", text="\u6805\u683c\u5e03\u5c40\uff0824\u5217\u5747\u5206\uff09", realtext="\u6805\u683c\u5e03\u5c40\uff0824\u5217\u5747\u5206\uff09", userdata="24\u5217\u6805\u683c\u5e03\u5c40\uff0c\u4e00\u822c\u5e94\u7528\u4e8e\u6d41\u5e03\u5c40\u6a21\u5f0f\uff0c\u6210\u5458\u5360\u4f4d\u8303\u56f41~24"), @CodeItem(value="FLEX", text="Flex\u5e03\u5c40", realtext="Flex\u5e03\u5c40", userdata="\u5f39\u6027\u76d2\u5b50\u5e03\u5c40\u63d0\u4f9b\u4e00\u4e2a\u6709\u6548\u5730\u5e03\u5c40\u3001\u5bf9\u9f50\u65b9\u5f0f\uff0c\u76ee\u6807\u662f\u80fd\u591f\u4f7f\u7236\u5143\u7d20\u80fd\u591f\u8c03\u8282\u5b50\u5143\u7d20\u7684\u9ad8\u5ea6\u3001\u5bbd\u5ea6\u548c\u6392\u5e03\u7684\u987a\u5e8f\uff0c\u6700\u597d\u5730\u9002\u5e94\u53ef\u7528\u5e03\u5c40\u7a7a\u95f4\u3002\u4e0e\u4f20\u7edf\u5e03\u5c40\u4e2d\u5757\u72b6\u5143\u7d20\u6309\u7167\u5782\u76f4\u65b9\u5411\u6446\u653e\uff0c\u884c\u5185\u5143\u7d20\u6309\u7167\u6c34\u5e73\u65b9\u5411\u6446\u653e\u76f8\u6bd4\uff0cflex\u5e03\u5c40\u662f\u65e0\u65b9\u5411\u7684\u3002\u4f20\u7edf\u5e03\u5c40\u5728\u5e94\u5bf9\u5927\u578b\u590d\u6742\u7684\u5e03\u5c40\u65f6\u7f3a\u4e4f\u7075\u6d3b\u6027\uff0c\u7279\u522b\u662f\u5728\u6539\u53d8\u65b9\u5411\u3001\u6539\u53d8\u5927\u5c0f\u3001\u4f38\u5c55\u3001\u6536\u7f29\u7b49\u7b49\u65b9\u9762"), @CodeItem(value="BORDER", text="\u8fb9\u7f18\u5e03\u5c40", realtext="\u8fb9\u7f18\u5e03\u5c40", userdata="\u8fb9\u7f18\u5e03\u5c40\u6307\u6cbf\u56db\u5468\u5e03\u5c40\uff0c\u4e0d\u505c\u7684\u5207\u5272\u5e03\u5c40\u533a\u57df\uff0c\u4e00\u822c\u5e94\u7528\u4e8e\u5168\u5c4f\u5e03\u5c40"), @CodeItem(value="TABLE", text="\u8868\u683c", realtext="\u8868\u683c", userdata="\u5e38\u89c4\u8868\u683c\u5e03\u5c40\uff0c\u6307\u5b9a\u5217\u5206\u5272\u6a21\u5f0f\uff0c\u5185\u5bb9\u6309\u884c\u3001\u5217\u4f4d\u7f6e\u8fdb\u884c\u5360\u4f4d"), @CodeItem(value="AUTOTABLE", text="\u81ea\u52a8\u8868\u683c", realtext="\u81ea\u52a8\u8868\u683c", userdata="\u81ea\u52a8\u8868\u683c\u5e03\u5c40\uff0c\u6307\u5b9a\u5217\u5206\u5272\u6a21\u5f0f\uff0c\u5185\u5bb9\u6309\u6b21\u5e8f\u9010\u4e2a\u5e03\u5c40\uff0c\u5982\u5f53\u524d\u884c\u5269\u4f59\u5355\u5143\u683c\u6570\u91cf\u5c0f\u4e8e\u5185\u5bb9\u9700\u6c42\u5219\u65b0\u8d77\u4e00\u884c")})
public class FormDetailLayoutModeCodeListModel
extends StaticCodeListModelBase {
    public static final String TABLE_12COL = "TABLE_12COL";
    public static final String TABLE_24COL = "TABLE_24COL";
    public static final String FLEX = "FLEX";
    public static final String BORDER = "BORDER";
    public static final String TABLE = "TABLE";
    public static final String AUTOTABLE = "AUTOTABLE";

    public FormDetailLayoutModeCodeListModel() {
        this.initAnnotation(FormDetailLayoutModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FormDetailLayoutModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FormDetailLayoutModeCodeListModel");
    }
}

