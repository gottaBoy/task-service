package SA.SRFDA.EAI.Endpoint;

import org.mule.api.MuleContext;
import org.mule.api.context.MuleContextAware;
import org.mule.api.lifecycle.Callable;

public abstract class BaseFtpProcess extends BaseProcessEndpoint
        implements Callable, MuleContextAware {
    protected MuleContext muleContet;

    public void setMuleContext(MuleContext muleContext) {
        this.muleContet = muleContext;
    }
}
