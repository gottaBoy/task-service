/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.Data.DEMSMA;
import SA.SRFDA.Ctrl.Data.DEMSMap;
import SA.SRFDA.Ctrl.Data.DEMainState;
import SA.SRFDA.Ctrl.Data.QueryModel;
import SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDEMainActionHelper;
import SA.SRFDA.Ctrl.IDEMainStateHelper;
import SA.SRFDA.Model.DGModelMainQueryConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DEMainStateHelper
extends BaseDAObjectHelper
implements IDEMainStateHelper {
    private static final Log log = LogFactory.getLog(DEMainStateHelper.class);
    private String strLogicName = "";
    private String strQueryModelId = "";
    private String strSDPageId = "";
    private String strMDPageId = "";
    private boolean bDefaultState = false;
    private String strDERGroupId = "";
    private DEMainState deMainState = null;
    private Vector<DEMSMA> deMSMAs = new Vector();
    private String strStateTestSql = "";
    private String strEditDEMainActionId = "";
    private Hashtable<String, DEMSMap> deMSMapMap = null;
    private Hashtable<String, String> deMSMapMap2 = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IDEHelper iDEHelper, DEMainState deMainState) throws Exception {
        this.setId(deMainState.getDEMAINSTATEID());
        this.setName(deMainState.getDEMAINSTATENAME());
        this.setDEHelper(iDEHelper);
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.deMainState = deMainState;
        this.InitModel(deMainState);
        CallResult callResult = this.getDAModelHelper().GetDEMSMAs(this.getId(), this.deMSMAs);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u4e3b\u72b6\u6001\u5173\u8054\u64cd\u4f5c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<DEMSMap> deMSMaps = new Vector<DEMSMap>();
        callResult = this.getDAModelHelper().GetDEMSMaps(this.getId(), deMSMaps);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u4e3b\u72b6\u6001\u6620\u5c04\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (deMSMaps.size() > 0) {
            this.deMSMapMap = new Hashtable();
            this.deMSMapMap2 = new Hashtable();
            for (DEMSMap deMSMap : deMSMaps) {
                String strMapId = StringHelper.Format((String)"%1$s:%2$s", (Object)deMSMap.getPDEID(), (Object)deMSMap.getPDEMAINSTATEID());
                this.deMSMapMap.put(strMapId, deMSMap);
                this.deMSMapMap2.put(deMSMap.getPDEID(), "");
            }
        }
        this.OnInit();
    }

    private void InitModel(DEMainState item) {
        if (!item.isLOGICNAMENull()) {
            this.setLogicName(item.getLOGICNAME());
        }
        if (!item.isQUERYMODELIDNull()) {
            this.setQueryModelId(item.getQUERYMODELID());
        }
        if (!item.isSDPAGEIDNull()) {
            this.setSDPageId(item.getSDPAGEID());
        }
        if (!item.isMDPAGEIDNull()) {
            this.setMDPageId(item.getMDPAGEID());
        }
        if (!item.isEDITDEMAIDNull()) {
            this.setEditDEMainActionId(item.getEDITDEMAID());
        }
        if (!this.deMainState.isDEFAULTSTATENull()) {
            this.setDefaultState(this.deMainState.getDEFAULTSTATE());
        }
        if (!this.deMainState.isDERGROUPIDNull()) {
            this.setDERGroupId(this.deMainState.getDERGROUPID());
        }
    }

    @Override
    public String getLogicName(String strLanguage) {
        return this.strLogicName;
    }

    protected void setLogicName(String strValue) {
        this.strLogicName = strValue;
    }

    @Override
    public String getQueryModelId() {
        return this.strQueryModelId;
    }

    protected void setQueryModelId(String strValue) {
        this.strQueryModelId = strValue;
    }

    @Override
    public String getSDPageId() {
        if (StringHelper.IsNullOrEmpty((String)this.strSDPageId)) {
            try {
                return this.getDEHelper().GetEditPageId();
            }
            catch (Exception e) {
                log.error((Object)e);
            }
        }
        return this.strSDPageId;
    }

    protected void setSDPageId(String strValue) {
        this.strSDPageId = strValue;
    }

    @Override
    public String getMDPageId() {
        return this.strMDPageId;
    }

    protected void setMDPageId(String strValue) {
        this.strMDPageId = strValue;
    }

    @Override
    public boolean isEnableUserCreate() {
        try {
            if (this.deMainState.isENABLECREATENull()) {
                return this.getDEHelper().IsEnableUserCreate();
            }
            return this.deMainState.getENABLECREATE();
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean isEnableUserUpdate() {
        try {
            if (this.deMainState.isENABLEUPDATENull()) {
                return this.getDEHelper().IsEnableUserUpdate();
            }
            return this.deMainState.getENABLEUPDATE();
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean isEnableUserDelete() {
        try {
            if (this.deMainState.isENABLEDELETENull()) {
                return this.getDEHelper().IsEnableUserDelete();
            }
            return this.deMainState.getENABLEDELETE();
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean isEnableUserView() {
        try {
            if (this.deMainState.isENABLEVIEWNull()) {
                return this.getDEHelper().IsEnableUserView();
            }
            return this.deMainState.getENABLEVIEW();
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Enumeration<DEMSMA> getDEMainActions() {
        return this.deMSMAs.elements();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String getStateTestSql() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.strStateTestSql)) {
            return this.strStateTestSql;
        }
        String string = this.strStateTestSql;
        synchronized (string) {
            if (!StringHelper.IsNullOrEmpty((String)this.strStateTestSql)) {
                return this.strStateTestSql;
            }
            if (StringHelper.IsNullOrEmpty((String)this.getQueryModelId())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u67e5\u8be2\u6a21\u578b");
            }
            QueryModel queryModel = new QueryModel();
            CallResult callResult = this.getDAModelStorage().GetQueryModel(this.getQueryModelId(), queryModel, true);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6307\u5b9a\u67e5\u8be2\u6a21\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.getQueryModelId(), (Object)callResult.getErrorInfo()));
            }
            DGModelMainQueryConfig mainQueryConfig = queryModel.getQueryModelConfig(false);
            mainQueryConfig.setExtSelect(this.getDEHelper().GetKeyDEFHelper().getName());
            BaseDAQueryModelHelper daQueryModelHelper = null;
            daQueryModelHelper = this.getDAModelStorage().GetDAQueryModelHelper(this.getDEHelper().getId(), mainQueryConfig);
            if (daQueryModelHelper == null) {
                throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6570\u636e\u67e5\u8be2\u6a21\u578b\u5bf9\u8c61");
            }
            DefaultDAQueryModelUserContext qmUserContext = new DefaultDAQueryModelUserContext();
            StringBuilderEx script = new StringBuilderEx();
            script.Append(daQueryModelHelper.GetQMDeclareScript());
            script.Append(qmUserContext.GetQMDeclareScript());
            script.Append(daQueryModelHelper.GetQueryModelScript());
            Vector<String> userConditions = new Vector<String>();
            daQueryModelHelper.FillMajorConditions(userConditions);
            callResult = daQueryModelHelper.GetDEFieldExp(this.getDEHelper().GetKeyDEFHelper());
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u5728\u67e5\u8be2\u6a21\u578b\u5bf9\u8c61\u4e2d\u7684\u522b\u540d", (Object)callResult.getUserObject()));
            }
            String strKeyCondition = StringHelper.Format((String)" %1$s = ? ", (Object)callResult.getUserObject());
            userConditions.add(strKeyCondition);
            if (userConditions.size() != 0) {
                script.Append(" WHERE ");
                boolean bFirst = true;
                for (String strCondition : userConditions) {
                    if (bFirst) {
                        bFirst = false;
                    } else {
                        script.Append(" AND ");
                    }
                    script.Append("(%1$s)", (Object)strCondition);
                }
            }
            this.strStateTestSql = script.toString();
            return this.strStateTestSql;
        }
    }

    @Override
    public IDEMainActionHelper getEditDEMainAction() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getEditDEMainActionId())) {
            return null;
        }
        return this.getDEHelper().FindDEMainAction(this.getEditDEMainActionId());
    }

    protected final String getEditDEMainActionId() {
        return this.strEditDEMainActionId;
    }

    protected void setEditDEMainActionId(String strEditDEMainActionId) {
        this.strEditDEMainActionId = strEditDEMainActionId;
    }

    @Override
    public boolean isMapTo(String strPDEId, String strDEMainStateId) {
        if (this.deMSMapMap == null) {
            return false;
        }
        String strMapId = StringHelper.Format((String)"%1$s:%2$s", (Object)strPDEId, (Object)strDEMainStateId);
        return this.deMSMapMap.containsKey(strMapId);
    }

    @Override
    public boolean isMapTo(String strPDEId) {
        if (this.deMSMapMap == null) {
            return false;
        }
        return this.deMSMapMap2.containsKey(strPDEId);
    }

    @Override
    public boolean isWFMode() {
        if (this.deMainState.isWFMODENull()) {
            return false;
        }
        return this.deMainState.getWFMODE();
    }

    @Override
    public boolean isDefaultState() {
        return this.bDefaultState;
    }

    protected void setDefaultState(boolean bDefaultState) {
        this.bDefaultState = bDefaultState;
    }

    @Override
    public final String getDERGroupId() {
        return this.strDERGroupId;
    }

    protected final void setDERGroupId(String strValue) {
        this.strDERGroupId = strValue;
    }
}

