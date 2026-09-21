/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQuery
 *  net.ibizsys.model.dataentity.mainstate.IPSDEMainStateAction
 *  net.ibizsys.model.dataentity.mainstate.IPSDEMainStateOPPriv
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.mainstate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.PSDataEntityObjectImpl;
import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.model.dataentity.mainstate.IPSDEMainStateAction;
import net.ibizsys.model.dataentity.mainstate.IPSDEMainStateOPPriv;
import net.ibizsys.model.dataentity.mainstate.IPSDEMainStateRuntime;
import net.ibizsys.model.dataentity.mainstate.PSDEMainStateActionImpl;
import net.ibizsys.model.dataentity.mainstate.PSDEMainStateOPPrivImpl;
import net.ibizsys.model.entity.PSDEMainState;
import net.ibizsys.model.entity.PSDEMainStateAction;
import net.ibizsys.model.entity.PSDEMainStateOPPriv;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEMainStateImpl
extends PSDataEntityObjectImpl
implements IPSDEMainStateRuntime {
    private static final Log log = LogFactory.getLog(PSDEMainStateImpl.class);
    protected PSDEMainState psDEMainState;
    protected ArrayList<IPSDEMainStateAction> psDEMainStateActionList = new ArrayList();
    protected ArrayList<IPSDEMainStateOPPriv> psDEMainStateOPPrivList = new ArrayList();
    protected String strCodeName = "";
    private String strPSDEDataQueryId = "";
    private IPSDEDataQuery iPSDEDataQuery = null;
    private boolean bAllowMode = false;
    private boolean bOPPrivAllowMode = false;
    private boolean bDefaultMode = false;
    private String strMSTag = null;
    private boolean bEnableViewActions = false;
    private long nViewActions = 0L;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDataEntity iPSDataEntity, PSDEMainState psDEMainState) throws Exception {
        try {
            this.setPSDataEntity(iPSDataEntity);
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.psDEMainState = psDEMainState;
            this.setId(psDEMainState.getPSDEMAINSTATEID());
            this.setName(psDEMainState.getPSDEMAINSTATENAME());
            this.setPSObjectData(this.psDEMainState);
            this.strCodeName = this.psDEMainState.getCODENAME();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getName();
            }
            this.strPSDEDataQueryId = this.psDEMainState.getPSDEDQID();
            if (!StringHelper.isNullOrEmpty((String)this.strPSDEDataQueryId)) {
                this.iPSDEDataQuery = this.getPSDataEntity().getPSDEDataQuery(this.strPSDEDataQueryId);
            }
            if (!this.psDEMainState.isDEFAULTMODENull()) {
                this.bDefaultMode = this.psDEMainState.getDEFAULTMODE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEMainState.getMSTAG())) {
                this.strMSTag = this.psDEMainState.getMSTAG();
            }
            if (!this.psDEMainState.isENABLEVIEWACTIONSNull()) {
                this.bEnableViewActions = this.psDEMainState.getENABLEVIEWACTIONS();
            }
            if (this.bEnableViewActions) {
                this.nViewActions = this.psDEMainState.getVIEWACTIONS();
            }
            this.bAllowMode = StringHelper.compare((String)this.psDEMainState.getALLOWMODE(), (String)"ALLOW", (boolean)true) == 0;
            this.bOPPrivAllowMode = StringHelper.compare((String)this.psDEMainState.getOPPRIVALLOWMODE(), (String)"ALLOW", (boolean)true) == 0;
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSDEMainStateActions();
    }

    protected void onPreparePSDEMainStateActions() throws Exception {
        this.psDEMainStateActionList.clear();
        Vector<PSDEMainStateAction> psDEMainStateActionList = new Vector<PSDEMainStateAction>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEMainStateActions(this.getId(), psDEMainStateActionList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u4e3b\u72b6\u6001\u5b9e\u4f53\u884c\u4e3a\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEMainStateAction psDEMainStateAction : psDEMainStateActionList) {
            if (!psDEMainStateAction.isVALIDFLAGNull() && !psDEMainStateAction.getVALIDFLAG()) continue;
            PSDEMainStateActionImpl iPSDEMainStateAction = new PSDEMainStateActionImpl();
            iPSDEMainStateAction.init(this.getPSModelStorageContext(), this, psDEMainStateAction);
            this.psDEMainStateActionList.add(iPSDEMainStateAction);
        }
        Vector<PSDEMainStateOPPriv> psDEMainStateOPPrivList = new Vector<PSDEMainStateOPPriv>();
        callResult = this.getPSModelQueryHelper().getPSDEMainStateOPPrivs(this.getId(), psDEMainStateOPPrivList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u4e3b\u72b6\u6001\u64cd\u4f5c\u6807\u8bc6\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEMainStateOPPriv psDEMainStateOPPriv : psDEMainStateOPPrivList) {
            if (!psDEMainStateOPPriv.isVALIDFLAGNull() && !psDEMainStateOPPriv.getVALIDFLAG()) continue;
            PSDEMainStateOPPrivImpl iPSDEMainStateOPPriv = new PSDEMainStateOPPrivImpl();
            iPSDEMainStateOPPriv.init(this.getPSModelStorageContext(), this, psDEMainStateOPPriv);
            this.psDEMainStateOPPrivList.add(iPSDEMainStateOPPriv);
        }
    }

    public Iterator<IPSDEMainStateAction> getPSDEMainStateActions() {
        return this.psDEMainStateActionList.iterator();
    }

    public Iterator<IPSDEMainStateOPPriv> getPSDEMainStateOPPrivs() {
        return this.psDEMainStateOPPrivList.iterator();
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.strCodeName;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u5bf9\u8c61")
    public IPSDEDataQuery getPSDEDataQuery() {
        return this.iPSDEDataQuery;
    }

    public String getPSDEDataQueryId() {
        return this.strPSDEDataQueryId;
    }

    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getLogicName() {
        return this.psDEMainState.getPSDEMAINSTATENAME();
    }

    @PSModelRTMeta(description="\u5141\u8bb8\u6a21\u5f0f")
    public boolean isAllowMode() {
        return this.bAllowMode;
    }

    @PSModelRTMeta(description="\u9ed8\u8ba4\u4e3b\u72b6\u6001")
    public boolean isDefault() {
        return this.bDefaultMode;
    }

    @PSModelRTMeta(description="\u4e3b\u72b6\u6001\u6807\u8bb0")
    public String getMSTag() {
        return this.strMSTag;
    }

    public boolean testDEAction(String strDEActionName) throws Exception {
        return false;
    }

    @PSModelRTMeta(description="\u542f\u7528\u89c6\u56fe\u64cd\u4f5c\u63a7\u5236")
    public boolean isEnableViewActions() {
        return this.bEnableViewActions;
    }

    @PSModelRTMeta(description="\u89c6\u56fe\u64cd\u4f5c\u63a7\u5236", codelist="DEViewActions")
    public long getViewActions() {
        return this.nViewActions;
    }

    public void init(IDataEntity iDataEntity) throws Exception {
    }

    @PSModelRTMeta(description="\u884c\u4e3a\u63a7\u5236\u6a21\u5f0f")
    public boolean isActionAllowMode() {
        return this.isAllowMode();
    }

    @PSModelRTMeta(description="\u64cd\u4f5c\u6807\u8bc6\u5141\u8bb8\u6a21\u5f0f")
    public boolean isOPPrivAllowMode() {
        return this.bOPPrivAllowMode;
    }

    public boolean testDEOPPriv(String strDEOPPrivName) throws Exception {
        return false;
    }
}

