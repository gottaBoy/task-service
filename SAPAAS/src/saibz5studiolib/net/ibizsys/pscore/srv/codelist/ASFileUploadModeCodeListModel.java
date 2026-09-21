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

@CodeList(id="f82cdbc17c94ed14339c092970f236d1", name="\u5e94\u7528\u5bb9\u5668\u4e0a\u4f20\u6587\u4ef6\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SSH", text="SSH", realtext="SSH"), @CodeItem(value="SFTP", text="SFTP", realtext="SFTP"), @CodeItem(value="FTP", text="FTP", realtext="FTP")})
public class ASFileUploadModeCodeListModel
extends StaticCodeListModelBase {
    public static final String SSH = "SSH";
    public static final String SFTP = "SFTP";
    public static final String FTP = "FTP";

    public ASFileUploadModeCodeListModel() {
        this.initAnnotation(ASFileUploadModeCodeListModel.class);
        this.setUserData2("FileUploadMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ASFileUploadModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ASFileUploadModeCodeListModel");
    }
}

