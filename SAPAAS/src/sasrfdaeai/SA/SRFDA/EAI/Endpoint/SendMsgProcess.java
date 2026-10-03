package SA.SRFDA.EAI.Endpoint;

import SA.SRFDA.Ctrl.Data.MsgTemplate;
import SA.SRFDA.Ctrl.Data.MsgSendQueue;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.Utility.DETemplateLoader;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import freemarker.template.Configuration;
import java.io.StringWriter;
import java.util.Map;
import java.util.TreeMap;
import org.mule.api.MuleEventContext;

public class SendMsgProcess extends DEPrepareProcess {
    protected MsgTemplate msgTemplate;
    protected IDEDataCtrl iMsgSendQueueDataCtrl;

    public void setMsgTemplate(MsgTemplate template) {
        this.msgTemplate = template;
    }

    public void setMsgSendQueueDataCtrl(IDEDataCtrl ctrl) {
        this.iMsgSendQueueDataCtrl = ctrl;
    }

    @Override
    public Object onCall(MuleEventContext event) throws Exception {
        Object payload = super.onCall(event);
        BaseDataEntity data = GetDataEntity(payload);
        String type = EndpointRuntime.setting(event, "MSGTYPE");
        if (!"1".equals(type) && !"2".equals(type) && !"4".equals(type)
                && !"8".equals(type) && !"16".equals(type)) {
            throw new IllegalArgumentException("Unsupported MSGTYPE: " + type);
        }
        MsgTemplate template = msgTemplate;
        if (template == null) {
            String id = EndpointRuntime.setting(event, "MSGTEMPLATEID");
            if (id == null || id.length() == 0) {
                throw new IllegalArgumentException("MSGTEMPLATEID is required");
            }
            IDEDataCtrl templateCtrl = GetGlobalHelper(event).getDAModelStorage()
                    .FindDEDataCtrl("DE0076", "SYSTEM", null);
            if (templateCtrl == null) {
                throw new IllegalStateException("No message template controller");
            }
            template = new MsgTemplate();
            template.setMSGTEMPLATEID(id);
            EndpointRuntime.check(templateCtrl.Get(template));
        }
        Map<String, Object> params = new TreeMap<String, Object>();
        SA.SRFDA.Ctrl.IDEHelper deHelper = null;
        if (template.getDEID().length() != 0) {
            deHelper = GetGlobalHelper(event).getDAModelStorage().FindDEHelper(template.getDEID());
            if (deHelper == null) {
                throw new IllegalArgumentException("No entity helper for " + template.getDEID());
            }
        }
        MacroHelper.FillMacroParams(params, null, GetGlobalHelper(event), "SYSTEM", deHelper, data, "");
        params.put("username", "");
        params.put("userid", "");
        Configuration configuration = new Configuration();
        configuration.setTemplateLoader(new DETemplateLoader(template));
        MsgSendQueue queued = new MsgSendQueue();
        queued.setMSGTYPE(Integer.parseInt(type));
        if ("1".equals(type) || "2".equals(type)) {
            queued.setCONTENTTYPE(template.getCONTENTTYPE());
            queued.setSUBJECT(render(configuration, "SUBJECT", params));
            queued.setCONTENT(render(configuration, "CONTENT", params));
        } else {
            queued.setCONTENTTYPE("TEXT");
            String field = "4".equals(type) ? "SMSCONTENT" : "IMCONTENT";
            String value = "4".equals(type) ? template.getSMSCONTENT() : template.getIMCONTENT();
            queued.setCONTENT(render(configuration, value.length() == 0 ? "CONTENT" : field, params));
        }
        queued.setMSGSENDQUEUENAME(queued.getSUBJECT());
        queued.setDSTUSERS(data.GetParamStringValue("DSTUSERS", ""));
        queued.setDSTADDRESSES(data.GetParamStringValue("DSTADDRESSES", ""));
        queued.setFILEAT(data.GetParamStringValue("FILEAT", ""));
        queued.setFILEAT2(data.GetParamStringValue("FILEAT2", ""));
        queued.setFILEAT3(data.GetParamStringValue("FILEAT3", ""));
        queued.setFILEAT4(data.GetParamStringValue("FILEAT4", ""));
        if (queued.getDSTUSERS().length() == 0 && queued.getDSTADDRESSES().length() == 0) {
            throw new IllegalArgumentException("DSTUSERS or DSTADDRESSES is required");
        }
        IDEDataCtrl queueCtrl = iMsgSendQueueDataCtrl;
        if (queueCtrl == null) {
            queueCtrl = GetGlobalHelper(event).getDAModelStorage()
                    .FindDEDataCtrl("DE0077", "SYSTEM", null);
        }
        if (queueCtrl == null) {
            throw new IllegalStateException("No message queue controller");
        }
        EndpointRuntime.check(queueCtrl.Save(true, queued));
        return payload;
    }

    private static String render(Configuration configuration, String name, Map<String, Object> params)
            throws Exception {
        StringWriter writer = new StringWriter();
        configuration.getTemplate(name).process(params, writer);
        return writer.toString();
    }
}
