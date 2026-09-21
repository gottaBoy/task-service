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

@CodeList(id="1aaac0b14f2ec862217e76780c1726ae", name="\u754c\u9762\u884c\u4e3a\u64cd\u4f5c\u76ee\u6807", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SINGLEDATA", text="\u5355\u9879\u6570\u636e", realtext="\u5355\u9879\u6570\u636e", userdata="\u754c\u9762\u4e0a\u7684\u5355\u4e2a\u6570\u636e\uff08\u8868\u5355\u7b49\u5355\u6570\u636e\u754c\u9762\u4e3a\u5f53\u524d\u754c\u9762\u6570\u636e\uff0c\u8868\u683c\u7b49\u591a\u6570\u636e\u754c\u9762\u4e3a\u7b2c\u4e00\u4e2a\u9009\u4e2d\u6570\u636e\uff09\uff0c\u4ee5\u5bf9\u8c61\u7684\u5f62\u5f0f\u4f20\u53c2"), @CodeItem(value="SINGLEKEY", text="\u5355\u9879\u6570\u636e\uff08\u4e3b\u952e\uff09", realtext="\u5355\u9879\u6570\u636e\uff08\u4e3b\u952e\uff09", userdata="\u754c\u9762\u4e0a\u7684\u5355\u4e2a\u6570\u636e\u4e3b\u952e\uff08\u8868\u5355\u7b49\u5355\u6570\u636e\u754c\u9762\u4e3a\u5f53\u524d\u754c\u9762\u6570\u636e\u4e3b\u952e\uff0c\u8868\u683c\u7b49\u591a\u6570\u636e\u754c\u9762\u4e3a\u7b2c\u4e00\u4e2a\u9009\u4e2d\u6570\u636e\u4e3b\u952e\uff09\uff0c\u4ee5\u5b57\u7b26\u4e32\u7684\u5f62\u5f0f\u4f20\u53c2"), @CodeItem(value="MULTIDATA", text="\u591a\u9879\u6570\u636e", realtext="\u591a\u9879\u6570\u636e", userdata="\u754c\u9762\u4e0a\u7684\u591a\u4e2a\u6570\u636e\uff08\u8868\u5355\u7b49\u5355\u6570\u636e\u754c\u9762\u4e3a\u5f53\u524d\u754c\u9762\u6570\u636e\uff0c\u8868\u683c\u7b49\u591a\u6570\u636e\u754c\u9762\u4e3a\u9009\u4e2d\u6570\u636e\uff09\uff0c\u4ee5\u5bf9\u8c61\u6570\u7ec4\u7684\u5f62\u5f0f\u4f20\u53c2"), @CodeItem(value="MULTIKEY", text="\u591a\u9879\u6570\u636e\uff08\u4e3b\u952e\uff09", realtext="\u591a\u9879\u6570\u636e\uff08\u4e3b\u952e\uff09", userdata="\u754c\u9762\u4e0a\u7684\u591a\u4e2a\u6570\u636e\u4e3b\u952e\uff08\u8868\u5355\u7b49\u5355\u6570\u636e\u754c\u9762\u4e3a\u5f53\u524d\u754c\u9762\u6570\u636e\u4e3b\u952e\uff0c\u8868\u683c\u7b49\u591a\u6570\u636e\u754c\u9762\u4e3a\u9009\u4e2d\u6570\u636e\u4e3b\u952e\uff09\uff0c\u4f7f\u7528\u5206\u53f7\u3010;\u3011\u5206\u9694\u7684\u5b57\u7b26\u4e32\u5f62\u5f0f\u4f20\u53c2"), @CodeItem(value="NONE", text="\u65e0\u6570\u636e", realtext="\u65e0\u6570\u636e", userdata="\u65e0\u76ee\u6807\u6570\u636e\uff0c\u4e00\u822c\u4e3a\u5904\u7406\u903b\u8f91\u6839\u636e\u4e0a\u4e0b\u6587\u73af\u5883\u81ea\u884c\u8ba1\u7b97\u64cd\u4f5c\u53c2\u6570")})
public class DEUIActionDataRangeCodeListModel
extends StaticCodeListModelBase {
    public static final String SINGLEDATA = "SINGLEDATA";
    public static final String SINGLEKEY = "SINGLEKEY";
    public static final String MULTIDATA = "MULTIDATA";
    public static final String MULTIKEY = "MULTIKEY";
    public static final String NONE = "NONE";

    public DEUIActionDataRangeCodeListModel() {
        this.initAnnotation(DEUIActionDataRangeCodeListModel.class);
        this.setUserData2("UIActionTarget");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEUIActionDataRangeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEUIActionDataRangeCodeListModel");
    }
}

