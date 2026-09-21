/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.CommonDialogPage
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.EAI.Web;

import SA.SRFDA.EAI.Ctrl.Data.EAIEndPoint;
import SA.SRFDA.EAI.Ctrl.Data.EAIProcessType;
import SA.SRFDA.EAI.Ctrl.DataCtrl.IEAIEndPointDataCtrl;
import SA.SRFDA.EAI.Ctrl.DataCtrl.IEAIProcessTypeDataCtrl;
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

    /*
     * Enabled aggressive exception aggregation
     */
    public String OutputJSCode(String strType) {
        try {
            StringBuilderEx script = new StringBuilderEx();
            if (StringHelper.Compare((String)strType, (String)"getinboundeditpath", (boolean)true) == 0) {
                Vector<EAIEndPoint> list;
                IEAIEndPointDataCtrl epDataCtrl = (IEAIEndPointDataCtrl)this.getDAModelStorage().FindDEDataCtrl("EAI0011", (ISRFDAWebContext)this.getWebContext());
                CallResult callResult = epDataCtrl.GetInboundEndPoints(list = new Vector<EAIEndPoint>());
                if (callResult.IsError()) {
                    this.PageLog((Object)this, 2, StringHelper.Format((String)"\u83b7\u53d6\u7cfb\u7edf\u5165\u7ad9\u7aef\u70b9\u96c6\u5408\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return "";
                }
                for (EAIEndPoint ep : list) {
                    script.Append("if(varinboundtype=='%1$s'){return '%2$s';}\r\n", (Object)ep.getEPTYPE(), (Object)ep.getEDITPATH());
                }
                return script.toString();
            }
            if (StringHelper.Compare((String)strType, (String)"getoutboundeditpath", (boolean)true) == 0) {
                Vector<EAIEndPoint> list;
                IEAIEndPointDataCtrl epDataCtrl = (IEAIEndPointDataCtrl)this.getDAModelStorage().FindDEDataCtrl("EAI0011", (ISRFDAWebContext)this.getWebContext());
                CallResult callResult = epDataCtrl.GetOutboundEndPoints(list = new Vector<EAIEndPoint>());
                if (callResult.IsError()) {
                    this.PageLog((Object)this, 2, StringHelper.Format((String)"\u83b7\u53d6\u7cfb\u7edf\u51fa\u7ad9\u7aef\u70b9\u96c6\u5408\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return "";
                }
                for (EAIEndPoint ep : list) {
                    script.Append("if(varoutboundtype=='%1$s'){return '%2$s';}\r\n", (Object)ep.getEPTYPE(), (Object)ep.getEDITPATH());
                }
                return script.toString();
            }
            if (StringHelper.Compare((String)strType, (String)"getprocesseditpath", (boolean)true) == 0) {
                Vector<EAIProcessType> processTypeList = new Vector<EAIProcessType>();
                IEAIProcessTypeDataCtrl processTypeDataCtrl = (IEAIProcessTypeDataCtrl)this.getDAModelStorage().FindDEDataCtrl("EAI0020", (ISRFDAWebContext)this.getWebContext());
                CallResult callResult = processTypeDataCtrl.GetProcessTypes(processTypeList);
                if (callResult.IsError()) {
                    this.PageLog((Object)this, 2, StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u5904\u7406\u7c7b\u578b\u96c6\u5408\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return "";
                }
                for (EAIProcessType processType : processTypeList) {
                    script.Append("if(varprocesstype=='%1$s'){return '%2$s';}\r\n", (Object)processType.getEAIPROCESSTYPEID(), (Object)processType.getEDITPATH());
                }
                return script.toString();
            }
        }
        catch (Exception ex) {
            this.PageLog((Object)this, 2, "\u8f93\u51fa\u811a\u672c\u4ee3\u7801\u51fa\u9519\u9519\u8bef", ex);
        }
        return "";
    }
}

