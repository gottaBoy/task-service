/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.CodeList.IUserCodeListContext
 *  SA.SRFramework.CodeList.IUserCodeListFiller
 *  SA.SRFramework.CodeList.IUserCodeListQuery
 */
package SA.SRFDA.CodeList;

import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.CodeList.IUserCodeListContext;
import SA.SRFramework.CodeList.IUserCodeListFiller;
import SA.SRFramework.CodeList.IUserCodeListQuery;

public class SimpleUserCodeList
implements IUserCodeListFiller,
IUserCodeListQuery {
    private IUserCodeListContext iUserCodeListContext = null;

    public boolean Fill(IUserCodeListContext iUserCodeListContext, CodeListConfig codeListConfig) {
        String strSPID = (String)iUserCodeListContext.GetUserTag("SPID");
        return false;
    }

    public void Init(IUserCodeListContext iUserCodeListContext) {
        this.iUserCodeListContext = iUserCodeListContext;
    }

    public CodeItemConfig Query(String strValue) {
        return null;
    }
}

