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

@CodeList(id="ba65bef8a979c769a9f8029c109cdfcd", name="\u5b9e\u4f53\u5173\u7cfb\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DER1N", text="1:N\u5173\u7cfb", realtext="1:N\u5173\u7cfb", iconpath="psdertype/icon_der1n.png", iconpathx="psdertype/icon_der1n@{0}x.png", userdata="\u4e3b\u5b9e\u4f53\u4e0e\u4ece\u5b9e\u4f53\u662f\u4e00\u5bf9\u591a\u7684\u5173\u7cfb\uff0c\u4ece\u5b9e\u4f53\u5efa\u7acb\u8fde\u63a5\u5230\u4e3b\u5b9e\u4f53\u7684\u5c5e\u6027\uff08\u5916\u952e\uff09"), @CodeItem(value="DERINHERIT", text="\u7ee7\u627f\u5173\u7cfb", realtext="\u7ee7\u627f\u5173\u7cfb", iconpath="psdertype/icon_derinherit.png", iconpathx="psdertype/icon_derinherit@{0}x.png", userdata="\u7ee7\u627f\u5173\u7cfb\u4e0d\u7b97\u4e25\u683c\u7684\u4e00\u5bf9\u4e00\u5173\u7cfb\uff0c\u4ece\u5b9e\u4f53\u4e0e\u4e3b\u5b9e\u4f53\u4e4b\u95f4\u662f\u7279\u5b9a\u7c7b\u578b\u6570\u636e\u7684\u4e00\u5bf9\u4e00\u5173\u7cfb\u3002\u4ece\u5b9e\u4f53\u53ea\u5141\u8bb8\u5b58\u5728\u4e00\u4e2a\u7ee7\u627f\u5173\u7cfb\uff0c\u4ece\u5b9e\u4f53\u9700\u8981\u7ee7\u627f\u4e3b\u5b9e\u4f53\u7684\u5b58\u50a8\u80fd\u529b\u6216\u903b\u8f91\u80fd\u529b\u624d\u80fd\u63d0\u4f9b\u529f\u80fd\uff0c\u6267\u884c\u529f\u80fd\u65f6\u4ece\u5b9e\u4f53\u9700\u5148\u64cd\u4f5c\u4e3b\u5b9e\u4f53\uff08\u76f4\u63a5\u5b58\u50a8\u6216\u8c03\u7528\u903b\u8f91\uff09\u518d\u8fdb\u884c\u81ea\u8eab\u7684\u5b58\u50a8\u6216\u903b\u8f91\u5904\u7406"), @CodeItem(value="DERINDEX", text="\u7d22\u5f15\u5173\u7cfb", realtext="\u7d22\u5f15\u5173\u7cfb", iconpath="psdertype/icon_derindex.png", iconpathx="psdertype/icon_derindex@{0}x.png", userdata="\u4ece\u5b9e\u4f53\u5141\u8bb8\u5efa\u7acb\u591a\u4e2a\u7d22\u5f15\u5173\u7cfb\uff0c\u4ece\u5b9e\u4f53\u72ec\u7acb\u63d0\u4f9b\u529f\u80fd\uff0c\u529f\u80fd\u6267\u884c\u540e\u518d\u540c\u6b65\u81f3\u4e3b\u5b9e\u4f53"), @CodeItem(value="DER11", text="1:1 \u5173\u7cfb", realtext="1:1 \u5173\u7cfb", iconpath="psdertype/icon_der11.png", iconpathx="psdertype/icon_der11@{0}x.png", userdata="\u4e3b\u5b9e\u4f53\u4e0e\u4ece\u5b9e\u4f53\u662f\u4e00\u5bf9\u4e00\u7684\u5173\u7cfb\uff0c\u4ece\u5b9e\u4f53\u7684\u4e3b\u952e\u662f\u8fde\u63a5\u5230\u4e3b\u5b9e\u4f53\u7684\u5c5e\u6027\uff08\u5916\u952e\uff09"), @CodeItem(value="DERMULINH", text="\u591a\u7ee7\u627f\u5173\u7cfb\uff08\u865a\u62df\u5b9e\u4f53\uff09", realtext="\u591a\u7ee7\u627f\u5173\u7cfb\uff08\u865a\u62df\u5b9e\u4f53\uff09", iconpath="psdertype/icon_derminherit.png", iconpathx="psdertype/icon_derminherit@{0}x.png", userdata="\u865a\u62df\u5b9e\u4f53\u5efa\u7acb\u591a\u4e2a\u5230\u4e3b\u5b9e\u4f53\u7684\u865a\u62df\u7ee7\u627f\u5173\u7cfb\uff0c\u4ece\u6bcf\u4e2a\u4e3b\u5b9e\u4f53\u9009\u62e9\u76f8\u5e94\u7684\u6570\u636e\u4f7f\u7528\u4e00\u5bf9\u4e00\u7684\u8fde\u63a5\u62fc\u88c5\u51fa\u65b0\u7684\u5b9e\u4f53"), @CodeItem(value="DERCUSTOM", text="\u81ea\u5b9a\u4e49\u5173\u7cfb", realtext="\u81ea\u5b9a\u4e49\u5173\u7cfb", userdata="\u4e3b\u5b9e\u4f53\u548c\u4ece\u5b9e\u4f53\u5efa\u7acb\u81ea\u5b9a\u4e49\u7684\u5173\u7cfb\uff0c\u901a\u8fc7\u6307\u5b9a\u5173\u7cfb\u5b50\u7c7b\u578b\u8fdb\u4e00\u6b65\u6307\u5b9a\u81ea\u5b9a\u4e49\u5173\u7cfb\u7684\u6a21\u5f0f"), @CodeItem(value="DERAGGDATA", text="\u805a\u5408\u6570\u636e\u5173\u7cfb", realtext="\u805a\u5408\u6570\u636e\u5173\u7cfb", userdata="\u805a\u5408\u6570\u636e\u5173\u7cfb\u4e3b\u5b9e\u4f53\u4e00\u822c\u4e3a\u7edf\u8ba1\u6570\u636e\u6e90\uff0c\u4ece\u5b9e\u4f53\u4e3a\u4e1a\u52a1\u6570\u636e\u3002\u5c06\u4e1a\u52a1\u6570\u636e\u6309\u7167\u7edf\u8ba1\u7ef4\u5ea6\u8fdb\u884c\u6c47\u805a")})
public class DERTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DER1N = "DER1N";
    public static final String DERINHERIT = "DERINHERIT";
    public static final String DERINDEX = "DERINDEX";
    public static final String DER11 = "DER11";
    public static final String DERMULINH = "DERMULINH";
    public static final String DERCUSTOM = "DERCUSTOM";
    public static final String DERAGGDATA = "DERAGGDATA";

    public DERTypeCodeListModel() {
        this.initAnnotation(DERTypeCodeListModel.class);
        this.setUserData("IGNOREMODELDSL2");
        this.setUserData2("DERType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DERTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DERTypeCodeListModel");
    }
}

