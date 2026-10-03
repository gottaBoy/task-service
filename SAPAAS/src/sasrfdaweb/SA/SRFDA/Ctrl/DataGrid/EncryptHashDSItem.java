/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.Utility.EncryptHelper
 *  SA.SRFDA.Web.ISRFDAPage
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.UI.DataGridDSItemConfig
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DataGrid.UserDSItem;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.Utility.EncryptHelper;
import SA.SRFDA.Web.ISRFDAPage;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.DataGridDSItemConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EncryptHashDSItem
extends UserDSItem {
    private static final Log log = LogFactory.getLog(EncryptHashDSItem.class);

    @Override
    public String GetValue(DataGridDSItemConfig dsItemConfig, DataRow dr, boolean bExcelMode) {
        return super.GetValue(dsItemConfig, dr, bExcelMode);
    }

    @Override
    public String GetValue(DataGridDSItemConfig dsItemConfig, BaseDataEntity baseDataEntity) {
        return super.GetValue(dsItemConfig, baseDataEntity);
    }

    @Override
    public String GetValue(SRFExWebContext webContext, DataGridDSItemConfig dsItemConfig, DataRow dr, boolean bExcelMode) {
        String strValue;
        block5: {
            block4: {
                try {
                    if (!dr.IsDBNull(dsItemConfig.getID())) break block4;
                    return "";
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    return "";
                }
            }
            try {
                strValue = dr.Get(dsItemConfig.getID()).toString();
            }
            catch (Exception exception) {
                return "";
            }
            CodeListConfig codeListConfig = webContext.getCodeListMgr().GetCodeListConfig("SRFDA.CODELIST_USER");
            if (codeListConfig != null) break block5;
            return "";
        }
        strValue = this.Decode(strValue, webContext, dsItemConfig);
        return strValue;
    }

    @Override
    public String GetValue(SRFExWebContext webContext, DataGridDSItemConfig dsItemConfig, BaseDataEntity baseDataEntity, boolean bExcelMode) {
        String strValue;
        block5: {
            block4: {
                try {
                    strValue = baseDataEntity.GetParamStringValue(dsItemConfig.getID(), "");
                    if (!StringHelper.IsNullOrEmpty((String)strValue)) break block4;
                    return "";
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    return "";
                }
            }
            CodeListConfig codeListConfig = webContext.getCodeListMgr().GetCodeListConfig("SRFDA.CODELIST_USER");
            if (codeListConfig != null) break block5;
            return "";
        }
        strValue = this.Decode(strValue, webContext, dsItemConfig);
        return strValue;
    }

    protected String Decode(String strValue, SRFExWebContext webContext, DataGridDSItemConfig dsItemConfig) {
        if (webContext.getPage() instanceof ISRFDAPage) {
            SRFDAPage page = (SRFDAPage)webContext.getPage();
            IDEHelper iDEHelper = page.getDEHelper();
            if (iDEHelper == null) {
                log.error((Object)StringHelper.Format((String)"[\u7f16\u7801]\u65e0\u6cd5\u83b7\u53d6\u9875\u9762\u5b9e\u4f53[%1$s]\u5bf9\u8c61", (Object)dsItemConfig.getID()));
            } else {
                IDEFHelper iDEFHelper = iDEHelper.GetDEFHelper(dsItemConfig.getID());
                if (iDEFHelper != null && iDEFHelper.getEncryptStorage() == 1) {
                    strValue = EncryptHelper.decode2((String)strValue);
                }
            }
        } else {
            log.error((Object)"[\u7f16\u7801]\u9875\u9762\u672a\u5b9e\u73b0ISRFDAPage\u63a5\u53e3");
        }
        return strValue;
    }
}

