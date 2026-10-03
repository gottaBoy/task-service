package SA.SRFDA.EAI.Endpoint;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.HashMap;
import java.util.Map;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class DEPrepareProcess extends BaseProcessEndpoint implements Callable {
    protected String strDEId;
    protected boolean bReturnPayloadAsMap;
    protected boolean bCloneDataEntity;

    public void setDEId(String deId) {
        this.strDEId = deId;
    }

    public void setReturnPayloadAsMap(boolean returnAsMap) {
        this.bReturnPayloadAsMap = returnAsMap;
    }

    public void setCloneDataEntity(boolean clone) {
        this.bCloneDataEntity = clone;
    }

    public Object onCall(MuleEventContext event) throws Exception {
        BaseDataEntity entity = GetDataEntity(EndpointRuntime.payload(event));
        if (bCloneDataEntity) {
            BaseDataEntity copy = new BaseDataEntity();
            entity.CopyTo(copy, true);
            entity = copy;
        }
        if (bReturnPayloadAsMap) {
            Map result = new HashMap();
            entity.FillMap(result);
            return result;
        }
        return entity;
    }
}
