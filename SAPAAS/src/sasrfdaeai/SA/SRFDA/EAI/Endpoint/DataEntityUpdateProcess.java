package SA.SRFDA.EAI.Endpoint;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.HashMap;
import java.util.Map;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class DataEntityUpdateProcess extends BaseProcessEndpoint implements Callable {
    public Object onCall(MuleEventContext event) throws Exception {
        Object original = EndpointRuntime.payload(event);
        BaseDataEntity entity = GetDataEntity(original);
        Object changes = event.getMessage().getProperty("UPDATES");
        if (!(changes instanceof Map) && !(changes instanceof BaseDataEntity)) {
            throw new IllegalArgumentException("UPDATES must be a Map or BaseDataEntity");
        }
        Map values = new HashMap();
        if (changes instanceof Map) {
            values.putAll((Map) changes);
        } else {
            ((BaseDataEntity) changes).FillMap(values);
        }
        for (Object key : values.keySet()) {
            if (!(key instanceof String)) {
                throw new IllegalArgumentException("UPDATES keys must be strings");
            }
            entity.SetParamValue((String) key, values.get(key));
        }
        return EndpointRuntime.output(original, entity);
    }
}
