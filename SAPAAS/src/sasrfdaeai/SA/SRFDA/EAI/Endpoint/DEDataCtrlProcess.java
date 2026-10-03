package SA.SRFDA.EAI.Endpoint;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import org.mule.api.MuleEventContext;

public class DEDataCtrlProcess extends DEPrepareProcess {
    protected IDEDataCtrl iDEDataCtrl;
    public static final String TAG_DEID = "DEID";
    public static final String TAG_ACTION = "ACTION";
    public static final String TAG_ACTION_INSERT = "INSERT";
    public static final String TAG_ACTION_UPDATE = "UPDATE";
    public static final String TAG_ACTION_DELETE = "DELETE";
    public static final String TAG_ACTION_CUSTOM = "CUSTOM";
    public static final String TAG_ACTION_PROC = "PROC";
    public static final String TAG_ACTIONMODE = "ACTIONMODE";

    public void setDEDataCtrl(IDEDataCtrl ctrl) {
        this.iDEDataCtrl = ctrl;
    }

    @Override
    public Object onCall(MuleEventContext event) throws Exception {
        Object original = EndpointRuntime.payload(event);
        BaseDataEntity entity = GetDataEntity(super.onCall(event));
        IDEDataCtrl ctrl = iDEDataCtrl;
        if (ctrl == null) {
            String deId = strDEId == null ? EndpointRuntime.setting(event, TAG_DEID) : strDEId;
            if (deId == null || deId.length() == 0) {
                throw new IllegalArgumentException("DEID is required");
            }
            ctrl = GetGlobalHelper(event).getDAModelStorage()
                    .FindDEDataCtrl(deId, "SYSTEM", null);
        }
        if (ctrl == null) {
            throw new IllegalArgumentException("No data controller for " + strDEId);
        }
        DEDataCtrlEndpoint.execute(ctrl, EndpointRuntime.setting(event, TAG_ACTION),
                EndpointRuntime.setting(event, TAG_ACTIONMODE), entity);
        return bReturnPayloadAsMap ? EndpointRuntime.output(original, entity) : entity;
    }
}
