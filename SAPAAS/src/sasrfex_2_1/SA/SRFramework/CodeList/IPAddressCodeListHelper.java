/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.BaseDBCallerHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.CodeList;

import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.CodeList.ICodeListFiller;
import SA.SRFramework.CodeList.ICodeListFiller2;
import SA.SRFramework.CodeList.ICodeListQuery;
import SA.SRFramework.Data.BaseDBCallerHelper;
import SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IPAddressCodeListHelper
implements ICodeListFiller,
ICodeListQuery,
ICodeListFiller2 {
    private static final Log log = LogFactory.getLog(IPAddressCodeListHelper.class);
    private ISRFExGlobalHelper iGlobalHelper = null;

    @Override
    public boolean Fill(BaseDBCallerHelper dbCallerHelper, CodeListConfig codeListConfig) {
        return true;
    }

    @Override
    public CodeItemConfig Query(BaseDBCallerHelper dbCallerHelper, String strValue) {
        try {
            CodeItemConfig codeItemConfig = new CodeItemConfig();
            codeItemConfig.setText(strValue);
            codeItemConfig.setValue(strValue);
            return codeItemConfig;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void setGlobalHelper(ISRFExGlobalHelper iGlobalHelper) {
        this.iGlobalHelper = iGlobalHelper;
    }
}

