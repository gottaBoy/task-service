package SA.SRFDA.EAI.Ctrl;

import SA.SRFramework.DataEx.CallResult;
import org.mule.api.MuleContext;
import org.mule.api.context.MuleContextAware;

public class Server implements IService, MuleContextAware {
    private MuleContext context;

    public void setMuleContext(MuleContext muleContext) {
        this.context = muleContext;
    }

    protected ServiceMgr getServiceMgr() {
        if (this.context == null || this.context.getRegistry() == null) {
            return null;
        }
        Object manager = this.context.getRegistry().lookupObject("EAISERVICEMGR");
        return manager instanceof ServiceMgr ? (ServiceMgr) manager : null;
    }

    public CallResult StartService(String serviceId) {
        ServiceMgr manager = this.getServiceMgr();
        return manager == null ? missingManager() : manager.StartService(serviceId);
    }

    public CallResult StopService(String serviceId) {
        ServiceMgr manager = this.getServiceMgr();
        return manager == null ? missingManager() : manager.StopService(serviceId);
    }

    private static CallResult missingManager() {
        CallResult result = new CallResult();
        result.setRetCode(1);
        result.setErrorInfo("Mule registry has no EAISERVICEMGR");
        return result;
    }
}
