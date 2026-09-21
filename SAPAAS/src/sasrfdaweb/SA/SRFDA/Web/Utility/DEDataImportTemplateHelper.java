/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  jxl.Workbook
 *  jxl.write.Label
 *  jxl.write.WritableCell
 *  jxl.write.WritableSheet
 *  jxl.write.WritableWorkbook
 */
package SA.SRFDA.Web.Utility;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.Vector;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class DEDataImportTemplateHelper {
    public static CallResult Output(ISRFDAGlobalHelper iGlobalHelper, IDEHelper iDEHelper, String strFile) throws Exception {
        CallResult callResult = new CallResult();
        WritableWorkbook workbook = Workbook.createWorkbook((File)new File(strFile));
        WritableSheet s1 = workbook.createSheet(StringHelper.Format((String)"[%1$s]\u5bfc\u5165\u683c\u5f0f", (Object)iDEHelper.getLogicName()), 0);
        WritableSheet s2 = workbook.createSheet("\u5c5e\u6027\u8bf4\u660e", 1);
        Vector<IDEFHelper> list = new Vector<IDEFHelper>();
        int nRowIndex = 0;
        int nCellIndex = 0;
        for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
            if (iDEFHelper.getDEField().getEXCELIMPORDER() == -1) continue;
            int nInsertPos = -1;
            int i = 0;
            while (i < list.size()) {
                if (((IDEFHelper)list.get(i)).getDEField().getEXCELIMPORDER() > iDEFHelper.getDEField().getEXCELIMPORDER()) {
                    nInsertPos = i;
                    break;
                }
                ++i;
            }
            if (nInsertPos == -1) {
                list.add(iDEFHelper);
                continue;
            }
            list.add(nInsertPos, iDEFHelper);
        }
        for (IDEFHelper iDEFHelper : list) {
            Label l = new Label(nCellIndex, nRowIndex, StringHelper.Format((String)"%1$s", (Object)iDEFHelper.getDEField().getEXCELIMPID()));
            s1.addCell((WritableCell)l);
            s1.setColumnView(nCellIndex, 20);
            ++nCellIndex;
        }
        nRowIndex = 0;
        Label l = new Label(0, nRowIndex, "\u5bfc\u5165\u540d\u79f0");
        s2.addCell((WritableCell)l);
        s2.setColumnView(0, 20);
        Label l2 = new Label(1, nRowIndex, "\u6570\u636e\u7c7b\u578b");
        s2.addCell((WritableCell)l2);
        s2.setColumnView(2, 40);
        Label l3 = new Label(2, nRowIndex, "\u8bf4\u660e");
        s2.addCell((WritableCell)l3);
        s2.setColumnView(3, 40);
        CodeListConfig dataTypeCodeListConfig = iGlobalHelper.getCodeListMgr().GetCodeListConfig("SRFDATAENTITY.CODELIST_DEFDATATYPE");
        nRowIndex = 1;
        for (IDEFHelper iDEFHelper : list) {
            if (!iDEFHelper.IsUserVisible()) continue;
            Label l4 = new Label(0, nRowIndex, iDEFHelper.getDEField().getEXCELIMPID());
            s2.addCell((WritableCell)l4);
            CodeItemConfig dataTypeConfig = null;
            if (iDEFHelper instanceof ILinkDEFHelper) {
                ILinkDEFHelper iLinkDEFHelper = (ILinkDEFHelper)iDEFHelper;
                dataTypeConfig = dataTypeCodeListConfig.FindCodeItemConfigByValue(iLinkDEFHelper.GetRealDEFHelper().GetDataType(), true);
            } else {
                dataTypeConfig = dataTypeCodeListConfig.FindCodeItemConfigByValue(iDEFHelper.GetDataType(), true);
            }
            Label l22 = new Label(1, nRowIndex, dataTypeConfig == null ? dataTypeCodeListConfig.getEmptyText() : dataTypeConfig.getText());
            s2.addCell((WritableCell)l22);
            String strDescription = iDEFHelper.getDEField().getDESCRIPTION();
            if (StringHelper.IsNullOrEmpty((String)strDescription)) {
                strDescription = iDEFHelper.getLogicName();
            }
            Label l32 = new Label(2, nRowIndex, strDescription);
            s2.addCell((WritableCell)l32);
            ++nRowIndex;
        }
        workbook.write();
        workbook.close();
        return callResult;
    }
}

