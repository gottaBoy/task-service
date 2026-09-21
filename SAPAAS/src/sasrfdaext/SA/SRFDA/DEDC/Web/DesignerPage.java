/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.IDEDCProcTypeDataCtrl
 *  SA.SRFDA.Ctrl.Data.DEDCProcType
 *  SA.SRFDA.Web.Default.CommonDialogPage
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.DEDC.Web;

import SA.SRFDA.Ctrl.DEDataCtrl.IDEDCProcTypeDataCtrl;
import SA.SRFDA.Ctrl.Data.DEDCProcType;
import SA.SRFDA.Web.Default.CommonDialogPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Vector;

public class DesignerPage
extends CommonDialogPage {
    protected void OnInitComponents() {
        super.OnInitComponents();
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
    }

    protected void OnInit() {
        super.OnInit();
    }

    public String OutputJSCode(String strType) {
        block4: {
            Vector list;
            StringBuilderEx script;
            block5: {
                script = new StringBuilderEx();
                if (StringHelper.Compare((String)strType, (String)"getprocesseditpath", (boolean)true) != 0) break block4;
                IDEDCProcTypeDataCtrl procTypeDataCtrl = (IDEDCProcTypeDataCtrl)this.getDAModelStorage().FindDEDataCtrl("DE0213", (ISRFDAWebContext)this.getWebContext());
                CallResult callResult = procTypeDataCtrl.GetProcessTypes(list = new Vector());
                if (!callResult.IsError()) break block5;
                this.PageLog((Object)this, 2, StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u64cd\u4f5c\u5904\u7406\u7c7b\u578b\u96c6\u5408\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return "";
            }
            try {
                for (DEDCProcType procType : list) {
                    script.Append("if(varprocesstype=='%1$s'){return '%2$s';}\r\n", (Object)procType.getPROCESSTYPE(), (Object)procType.getEDITPATH());
                }
                return script.toString();
            }
            catch (Exception ex) {
                this.PageLog((Object)this, 2, "\u8f93\u51fa\u811a\u672c\u4ee3\u7801\u51fa\u9519\u9519\u8bef", ex);
            }
        }
        return "";
    }
}

