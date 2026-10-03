package SA.SRFDA.EAI.Endpoint;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.ValueError;
import java.util.Vector;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class DEDataCtrlEndpoint extends BaseProcessEndpoint implements Callable {
    public static final String TAG_DEID = "DEID";
    public static final String TAG_ACTION = "ACTION";
    public static final String TAG_ACTION_INSERT = "INSERT";
    public static final String TAG_ACTION_UPDATE = "UPDATE";
    public static final String TAG_ACTION_DELETE = "DELETE";
    public static final String TAG_ACTION_CUSTOM = "CUSTOM";
    public static final String TAG_ACTION_PROC = "PROC";
    public static final String TAG_ACTIONMODE = "ACTIONMODE";

    public Object onCall(MuleEventContext event) throws Exception {
        String deId = EndpointRuntime.setting(event, TAG_DEID);
        if (deId == null || deId.trim().length() == 0) {
            throw new IllegalArgumentException("DEID is required");
        }
        IDEDataCtrl ctrl = GetGlobalHelper(event).getDAModelStorage()
                .FindDEDataCtrl(deId, "SYSTEM", null);
        if (ctrl == null) {
            throw new IllegalArgumentException("No data controller for " + deId);
        }
        Object payload = EndpointRuntime.payload(event);
        BaseDataEntity entity = GetDataEntity(payload);
        execute(ctrl, EndpointRuntime.setting(event, TAG_ACTION),
                EndpointRuntime.setting(event, TAG_ACTIONMODE), entity);
        return EndpointRuntime.output(payload, entity);
    }

    static void execute(IDEDataCtrl ctrl, String action, String mode, BaseDataEntity entity)
            throws Exception {
        if (action == null) {
            throw new IllegalArgumentException("ACTION is required");
        }
        CallResult result;
        if (TAG_ACTION_INSERT.equalsIgnoreCase(action)) {
            EndpointRuntime.check(mode == null || mode.length() == 0
                    ? ctrl.TestSave(true, entity, new Vector<ValueError>())
                    : ctrl.TestSave(true, mode, entity, new Vector<ValueError>()));
            result = mode == null || mode.length() == 0
                    ? ctrl.Save(true, entity) : ctrl.Save(true, mode, entity);
        } else if (TAG_ACTION_UPDATE.equalsIgnoreCase(action)) {
            EndpointRuntime.check(mode == null || mode.length() == 0
                    ? ctrl.TestSave(false, entity, new Vector<ValueError>())
                    : ctrl.TestSave(false, mode, entity, new Vector<ValueError>()));
            result = mode == null || mode.length() == 0
                    ? ctrl.Save(false, entity) : ctrl.Save(false, mode, entity);
        } else if (TAG_ACTION_DELETE.equalsIgnoreCase(action)) {
            result = mode == null || mode.length() == 0
                    ? ctrl.Remove(entity) : ctrl.Remove(mode, entity);
        } else if (TAG_ACTION_CUSTOM.equalsIgnoreCase(action)) {
            if (mode == null || mode.length() == 0) {
                throw new IllegalArgumentException("ACTIONMODE is required for CUSTOM");
            }
            result = ctrl.CustomCall(mode, entity);
        } else if (TAG_ACTION_PROC.equalsIgnoreCase(action)) {
            if (mode == null || mode.length() == 0) {
                throw new IllegalArgumentException("ACTIONMODE is required for PROC");
            }
            result = ctrl.CustomProcCall(mode, entity);
        } else {
            throw new IllegalArgumentException("Unsupported ACTION: " + action);
        }
        EndpointRuntime.check(result);
    }
}
