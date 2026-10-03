package SA.SRFDA.EAI.Endpoint;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class SimpleProcess implements Callable {
    public Object onCall(MuleEventContext event) throws Exception {
        return event.getMessage().getPayload();
    }
}
