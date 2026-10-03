/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.ISRFExDataGridDSItem
 *  SA.SRFramework.WebEx.ISRFExDataGridDSItem2
 *  SA.SRFramework.WebEx.ISRFExDataGridDSItem3
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.UI.DataGridDSItemConfig
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.ND.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.ND.Ctrl.INDFSOTypeHelper;
import SA.SRFDA.ND.Ctrl.INDModelStorage;
import SA.SRFDA.ND.Ctrl.NDActionContext;
import SA.SRFDA.ND.Ctrl.NDModelStorageFactory;
import SA.SRFDA.ND.Data.NDFSObject;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem2;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem3;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.DataGridDSItemConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NDShareFullPathDSItem
implements ISRFExDataGridDSItem,
ISRFExDataGridDSItem2,
ISRFExDataGridDSItem3 {
    private static final Log log = LogFactory.getLog(NDShareFullPathDSItem.class);

    public String GetValue(DataGridDSItemConfig dsItemConfig, DataRow dr, boolean bExcelMode) {
        return "";
    }

    public String GetValue(DataGridDSItemConfig dsItemConfig, BaseDataEntity baseDataEntity) {
        return "";
    }

    public String GetValue(SRFExWebContext webContext, DataGridDSItemConfig dsItemConfig, DataRow dr, boolean bExcelMode) {
        String strDataRow;
        block4: {
            try {
                strDataRow = "NDFSOBJECTID";
                if (!dr.IsDBNull(strDataRow)) break block4;
                return "";
            }
            catch (Exception ex) {
                log.error((Object)ex.getMessage(), (Throwable)ex);
                return ex.getMessage();
            }
        }
        SRFDAPage srfDAPage = (SRFDAPage)webContext.getPage();
        String strValue;
        try {
            strValue = dr.Get(strDataRow).toString();
        }
        catch (Exception exception) {
            return "";
        }
        try {
        IDEDataCtrl ndFSODataCtrl = srfDAPage.GetDEDataCtrl("ND0010");
        NDFSObject ndFSObject = new NDFSObject();
        ndFSObject.setNDFSOBJECTID(strValue);
        CallResult callResult = ndFSODataCtrl.Get((BaseDataEntity)ndFSObject);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6587\u4ef6\u5bf9\u8c61[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strValue, (Object)callResult.getErrorInfo()));
        }
        NDActionContext iNDActionContext = new NDActionContext(ndFSODataCtrl);
        INDModelStorage iNDModelStorage = NDModelStorageFactory.Create((ISRFDAGlobalHelper)webContext.getGlobalHelper());
        INDFSOTypeHelper iNDFSOTypeHelper = iNDModelStorage.FindNDFSOType(ndFSObject.getNDFSOBJECTTYPE());
        String strFolderPath = iNDFSOTypeHelper.CalcFSOFullPath(iNDActionContext, ndFSObject);
        return strFolderPath;
        }
        catch (Exception exception) {
            log.error((Object)exception.getMessage(), (Throwable)exception);
            return "";
        }
    }
}

