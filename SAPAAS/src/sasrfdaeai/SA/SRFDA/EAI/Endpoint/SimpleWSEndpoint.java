package SA.SRFDA.EAI.Endpoint;

import org.mule.api.MuleContext;
import org.mule.api.MuleEventContext;
import org.mule.api.context.MuleContextAware;
import org.mule.api.lifecycle.Callable;

public class SimpleWSEndpoint implements ISimpleWebService, MuleContextAware, Callable {
    protected MuleContext context;

    public void setMuleContext(MuleContext muleContext) {
        this.context = muleContext;
    }

    // The RPC result is routed by Mule's outbound router after the component returns.
    public String Call(String input) {
        return input;
    }

    public Object onCall(MuleEventContext event) throws Exception {
        Object payload = event.getMessage().getPayload();
        if (!(payload instanceof String)) {
            throw new IllegalArgumentException("Web service payload must be a String");
        }
        return Call((String) payload);
    }
}
