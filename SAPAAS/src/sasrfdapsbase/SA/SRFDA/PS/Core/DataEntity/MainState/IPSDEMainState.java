/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEMainState
 */
package SA.SRFDA.PS.Core.DataEntity.MainState;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainStateAction;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainStateField;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainStateOPPriv;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDEMainState;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEMainState;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u4e3b\u72b6\u6001\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEMainState")
public interface IPSDEMainState
extends IPSDataEntityObject,
IDEMainState {
    public static final int WFSTATEMODE_NONE = 0;
    public static final int WFSTATEMODE_PROCESS = 1;
    public static final int WFSTATEMODE_FINISH = 2;
    public static final int WFSTATEMODE_ERROR = 3;
    public static final String ENTERSTATEMODE_ANY = "ANY";
    public static final String ENTERSTATEMODE_SOME = "SOME";
    public static final int MAINSTATETYPE_NORMAL = 0;
    public static final int MAINSTATETYPE_DEFAULT = 1;
    public static final int MAINSTATETYPE_LOCK = 2;
    public static final int MAINSTATETYPE_CLOSE = 2;

    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEMainState var3) throws Exception;

    public String getLogicName();

    public int getMSType();

    public boolean isActionAllowMode();

    public boolean isOPPrivAllowMode();

    public boolean isDefault();

    public String getMSTag();

    public Iterator<IPSDEMainStateAction> getPSDEMainStateActions();

    public Iterator<IPSDEMainStateOPPriv> getPSDEMainStateOPPrivs();

    public IPSDEDataQuery getPSDEDataQuery();

    public String getPSDEDataQueryId();

    @Override
    public String getCodeName();

    public boolean isEnableViewActions();

    public long getViewActions();

    public int getWFStateMode() throws Exception;

    public String getStateValue();

    public String getState2Value();

    public String getState3Value();

    public IPSDEMainState getParentPSDEMainState() throws Exception;

    public Iterator<IPSDEMainState> getPSDEMainStates() throws Exception;

    public IPSDEAction getEnterPSDEAction() throws Exception;

    public String getActionDenyMsg();

    public String getOPPrivDenyMsg();

    public String getEnterStateMode();

    public boolean isFieldAllowMode();

    public Iterator<IPSDEMainStateField> getPSDEMainStateFields();

    public Iterator<IPSDEMainState> getPrevPSDEMainStates() throws Exception;

    public String getPSDEFormId();

    public String getFormCodeName();

    public String getMobPSDEFormId();

    public String getMobFormCodeName();

    public String getUtilPSDEFormId();

    public String getUtilFormCodeName();

    public String getMobUtilPSDEFormId();

    public String getMobUtilFormCodeName();

    public String getQuickPSDEFormId();

    public String getQuickFormCodeName();

    public String getMobQuickPSDEFormId();

    public String getMobQuickFormCodeName();

    public int getOrderValue();
}

