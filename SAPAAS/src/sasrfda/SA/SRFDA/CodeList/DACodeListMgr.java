/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.CodeList.CodeListMgr
 */
package SA.SRFDA.CodeList;

import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.CodeList.CodeListMgr;

public class DACodeListMgr
extends CodeListMgr {
    protected GlobalHelperEx globalhelperEx = null;

    public void setGlobalHelperEx(GlobalHelperEx globalhelperEx) {
        this.globalhelperEx = globalhelperEx;
        this.setGlobalHelper(globalhelperEx);
    }

    public CodeListConfig GetCodeListConfig(String strCodeListId) {
        return this.globalhelperEx.getDAModelStorage().FindCodeListConfig(strCodeListId);
    }

    public void ResetAllCodeList() {
        if (this.globalhelperEx != null) {
            this.globalhelperEx.getDAModelStorage().ResetAllCodeList();
        }
        super.ResetAllCodeList();
    }

    public CodeListConfig GetOriginCodeListConfig(String strCodeListId) {
        return super.GetCodeListConfig(strCodeListId);
    }
}

