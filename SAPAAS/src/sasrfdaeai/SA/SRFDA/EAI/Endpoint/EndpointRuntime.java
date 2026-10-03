package SA.SRFDA.EAI.Endpoint;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import java.util.Map;
import org.mule.api.MuleEventContext;

final class EndpointRuntime {
    private EndpointRuntime() {
    }

    static Object payload(MuleEventContext event) {
        return event.getMessage().getPayload();
    }

    static String setting(MuleEventContext event, String key) {
        if (event.getService() != null && event.getMuleContext() != null) {
            Object bean = event.getMuleContext().getRegistry()
                    .lookupObject("cfg_" + event.getService().getName());
            if (bean instanceof ProcessConfig) {
                Map<String, String> config = ((ProcessConfig) bean).getConfig();
                if (config != null && config.get(key) != null) {
                    return config.get(key);
                }
            }
        }
        Object value = event.getMessage().getProperty(key);
        return value == null ? null : value.toString();
    }

    static Object output(Object original, BaseDataEntity entity) throws Exception {
        if (original instanceof Map || original instanceof BaseDataEntity) {
            return BaseProcessEndpoint.GetPayload(original, entity);
        }
        return entity;
    }

    static void check(CallResult result) throws Exception {
        if (result == null) {
            throw new IllegalStateException("Data controller returned no result");
        }
        if (result.IsError()) {
            throw new Exception("Data controller error " + result.getRetCode() + ": "
                    + result.getErrorInfo());
        }
    }
}
