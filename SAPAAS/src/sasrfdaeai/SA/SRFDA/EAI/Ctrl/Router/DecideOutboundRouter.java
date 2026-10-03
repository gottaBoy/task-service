package SA.SRFDA.EAI.Ctrl.Router;

import SA.SRFDA.EAI.Ctrl.DefaultEAIDataCtrl;
import SA.SRFDA.EAI.Ctrl.InstanceMgr;
import SA.SRFDA.EAI.Ctrl.Data.EAIService;
import SA.SRFDA.EAI.Model.EAIConfig;
import SA.SRFDA.EAI.Model.EAIConnectionConfig;
import SA.SRFDA.EAI.Model.EAIDecideProcessConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.DateParser;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.mule.api.MessagingException;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.MuleSession;
import org.mule.api.endpoint.OutboundEndpoint;
import org.mule.config.i18n.MessageFactory;
import org.mule.routing.outbound.AbstractOutboundRouter;
import org.mule.transport.NullPayload;

public class DecideOutboundRouter extends AbstractOutboundRouter {
    protected String processId;
    protected String paramId;
    protected Object realObjectValue;
    protected EAIDecideProcessConfig decideProcessConfig;
    protected String strEAIServiceId;

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getParamId() {
        return paramId;
    }

    public void setParamId(String paramId) {
        this.paramId = paramId;
    }

    @Override
    public boolean isMatch(MuleMessage muleMessage) throws MessagingException {
        return muleMessage != null;
    }

    @Override
    public MuleMessage route(MuleMessage muleMessage, MuleSession muleSession) throws MessagingException {
        if (muleMessage == null || muleSession == null) {
            throw failure(muleMessage, "Decision routing requires a message and session");
        }
        EAIDecideProcessConfig config = resolveConfig(muleMessage);
        String field = paramId == null || paramId.length() == 0 ? config.getParamId() : paramId;
        if (field == null || field.length() == 0) {
            throw failure(muleMessage, "Decision parameter is missing for " + processId);
        }
        Object value = GetReferValue(muleMessage.getPayload(), field);
        int dataType = value == null ? 0 : GetObjectDataType(value);
        EAIConnectionConfig fallback = null;
        EAIConnectionConfig selected = null;
        for (EAIConnectionConfig connection : config.getConnectionsConfig()) {
            if (connection.getDefaultMode()) {
                fallback = connection;
            } else if (TestConnection(muleMessage, value, dataType, connection)) {
                selected = connection;
                break;
            }
        }
        if (selected == null) {
            selected = fallback;
        }
        if (selected == null) {
            throw failure(muleMessage, "No matching decision connection for " + processId);
        }
        OutboundEndpoint endpoint = getEndpoint(selected.getID());
        if (endpoint == null) {
            throw failure(muleMessage, "Decision endpoint not found: " + selected.getID());
        }
        try {
            if (endpoint.isSynchronous()) {
                return send(muleSession, muleMessage, endpoint);
            }
            dispatch(muleSession, muleMessage, endpoint);
            return null;
        } catch (MuleException ex) {
            throw new MessagingException(MessageFactory.createStaticMessage(
                    "Decision endpoint failed: " + selected.getID()), muleMessage, ex);
        }
    }

    private synchronized EAIDecideProcessConfig resolveConfig(MuleMessage message) throws MessagingException {
        if (decideProcessConfig != null) {
            return decideProcessConfig;
        }
        if (processId == null || processId.length() == 0 || getMuleContext() == null
                || getMuleContext().getRegistry() == null) {
            throw failure(message, "Decision router is not configured");
        }
        Object instance = getMuleContext().getRegistry().lookupObject("EAISERVICE");
        Object helper = getMuleContext().getRegistry().lookupObject("SRFDACONTEXTHELPER");
        if (!(instance instanceof InstanceMgr) || !(helper instanceof ISRFDAGlobalHelper)) {
            throw failure(message, "EAI service and global helper are required for " + processId);
        }
        Map<String, String> settings = ((InstanceMgr) instance).getConfig();
        strEAIServiceId = settings == null ? null : settings.get("SERVICEID");
        if (strEAIServiceId == null || strEAIServiceId.length() == 0) {
            throw failure(message, "EAI service ID is missing for " + processId);
        }
        DefaultEAIDataCtrl dataCtrl = new DefaultEAIDataCtrl();
        CallResult result = dataCtrl.Init((ISRFDAGlobalHelper) helper);
        if (result == null || result.IsError()) {
            throw failure(message, "Cannot initialise EAI data controller for " + strEAIServiceId);
        }
        EAIService service = new EAIService();
        result = dataCtrl.GetService(strEAIServiceId, service);
        if (result == null || result.IsError()) {
            throw failure(message, "Cannot load EAI service " + strEAIServiceId);
        }
        EAIConfig model = new EAIConfig();
        if (service.getSVRMODEL() == null || !model.LoadXML(service.getSVRMODEL())) {
            throw failure(message, "Invalid EAI service model for " + strEAIServiceId);
        }
        Object process = model.getProcessesConfig().FindProcessConfig(processId);
        if (!(process instanceof EAIDecideProcessConfig)) {
            throw failure(message, "Decision process not found: " + processId);
        }
        decideProcessConfig = (EAIDecideProcessConfig) process;
        return decideProcessConfig;
    }

    protected Object GetReferValue(Object object) throws MessagingException {
        return GetReferValue(object, paramId);
    }

    protected static Object GetReferValue(Object object, String field) throws MessagingException {
        if (object instanceof BaseDataEntity) {
            return ((BaseDataEntity) object).GetParamValue(field);
        }
        if (object instanceof Map) {
            return ((Map) object).get(field);
        }
        if (object == null || object instanceof NullPayload) {
            return null;
        }
        throw new MessagingException(MessageFactory.createStaticMessage(
                "Unsupported decision payload: " + object.getClass().getName()), object);
    }

    public static Map GetMap(Object object) {
        if (object instanceof Map) {
            return (Map) object;
        }
        Map map = new HashMap();
        if (object instanceof BaseDataEntity) {
            ((BaseDataEntity) object).FillMap(map);
            return map;
        }
        if (object == null || object instanceof NullPayload) {
            return map;
        }
        throw new IllegalArgumentException("Unsupported decision payload: " + object.getClass().getName());
    }

    protected boolean TestConnection(MuleMessage message, Object value, int dataType,
            EAIConnectionConfig connection) throws MessagingException {
        Map ops = connection.getOPList();
        Map params = connection.getOPParamList();
        Map functions = connection.getOpParamAsFuncList();
        boolean and = EAIConnectionConfig.TAG_OPMODE_AND.equalsIgnoreCase(connection.getOpMode());
        if (!and && !EAIConnectionConfig.TAG_OPMODE_OR.equalsIgnoreCase(connection.getOpMode())) {
            throw failure(message, "Invalid decision mode: " + connection.getOpMode());
        }
        boolean hasRule = false;
        for (int i = 0; i < EAIConnectionConfig.MAXPARAMCOUNT; i++) {
            if (!ops.containsKey(i)) {
                continue;
            }
            hasRule = true;
            int op = (Integer) ops.get(i);
            if (op != EAIConnectionConfig.OP_ISNULL && op != EAIConnectionConfig.OP_ISNOTNULL
                    && op != EAIConnectionConfig.OP_GT && op != EAIConnectionConfig.OP_GTANDEQ
                    && op != EAIConnectionConfig.OP_EQ && op != EAIConnectionConfig.OP_LT
                    && op != EAIConnectionConfig.OP_LTANDEQ && op != EAIConnectionConfig.OP_NOTEQ) {
                throw failure(message, "Unknown decision operator: " + op);
            }
            boolean match;
            if (op == EAIConnectionConfig.OP_ISNULL) {
                match = value == null;
            } else if (op == EAIConnectionConfig.OP_ISNOTNULL) {
                match = value != null;
            } else if (value == null) {
                match = false;
            } else {
                if (!params.containsKey(i)) {
                    throw failure(message, "Missing decision operand for rule " + (i + 1));
                }
                Object target = GetParamValue(message, dataType, (String) params.get(i),
                        Boolean.TRUE.equals(functions.get(i)));
                if (target == null) {
                    throw failure(message, "Decision operand is null for rule " + (i + 1));
                }
                try {
                    match = DataTypeHelper.IsStringType(dataType)
                            ? CheckStringValueRule(message, op, value.toString(), target.toString())
                            : CheckNumberValueRule(message, dataType, op, value, target);
                } catch (IllegalArgumentException ex) {
                    throw new MessagingException(MessageFactory.createStaticMessage(
                            "Cannot compare decision values for rule " + (i + 1)), message, ex);
                }
            }
            if (and && !match) {
                return false;
            }
            if (!and && match) {
                return true;
            }
        }
        return hasRule && and;
    }

    public static Object GetParamValue(MuleMessage message, int dataType, String operand,
            boolean asFunction) throws MessagingException {
        if (operand == null) {
            throw failure(message, "Decision operand is missing");
        }
        if (asFunction) {
            if ("@@DATETIME".equalsIgnoreCase(operand)) {
                return DataTypeParse.Parse(5, DateParser.toDateTimeString(new Date()));
            }
            if ("@@DATE".equalsIgnoreCase(operand)) {
                return DataTypeParse.Parse(27, DateParser.toDateString(new Date()));
            }
            if ("@@TIME".equalsIgnoreCase(operand)) {
                return DataTypeParse.Parse(28, DateParser.toTimeString(new Date()));
            }
            if (!operand.startsWith("##")) {
                throw failure(message, "Unknown decision operand function: " + operand);
            }
            return GetReferValue(message.getPayload(), operand.substring(2));
        }
        Object parsed = DataTypeParse.Parse(dataType, operand);
        if (parsed == null) {
            throw failure(message, "Invalid decision operand: " + operand);
        }
        return parsed;
    }

    public static boolean CheckStringValueRule(MuleMessage message, int op, String source,
            String target) throws MessagingException {
        return compare(message, op, DataTypeParse.Compare(25, source, target));
    }

    public static boolean CheckNumberValueRule(MuleMessage message, int dataType, int op,
            Object source, Object target) throws MessagingException {
        return compare(message, op, DataTypeParse.Compare(dataType, source, target));
    }

    private static boolean compare(MuleMessage message, int op, long result) throws MessagingException {
        switch (op) {
            case EAIConnectionConfig.OP_GT: return result > 0;
            case EAIConnectionConfig.OP_GTANDEQ: return result >= 0;
            case EAIConnectionConfig.OP_EQ: return result == 0;
            case EAIConnectionConfig.OP_LT: return result < 0;
            case EAIConnectionConfig.OP_LTANDEQ: return result <= 0;
            case EAIConnectionConfig.OP_NOTEQ: return result != 0;
            default: throw failure(message, "Unknown decision operator: " + op);
        }
    }

    private int GetObjectDataType(Object value) throws MessagingException {
        if (value == null) {
            throw new MessagingException(MessageFactory.createStaticMessage(
                    "Decision value has no data type"), value);
        }
        return DataTypeHelper.GetObjectDataType(value);
    }

    private static MessagingException failure(MuleMessage message, String description) {
        return new MessagingException(MessageFactory.createStaticMessage(description), message);
    }
}
