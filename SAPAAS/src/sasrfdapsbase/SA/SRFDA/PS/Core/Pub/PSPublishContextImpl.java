/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.Log.IPSLogItem;
import SA.SRFDA.PS.Core.Log.PSLogItemImpl;
import SA.SRFDA.PS.Core.PSActionContextImpl;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class PSPublishContextImpl
extends PSActionContextImpl
implements IPSPublisherContext {
    private boolean bEnableVC = true;
    private boolean bRebuildMode = false;
    private HashMap<String, Object> params = null;
    private int nRebuildModeEx = 0;
    private ArrayList<IPSLogItem> psLogItemList = null;

    public PSPublishContextImpl(IDEDataCtrl iDEDataCtrl) {
        super(iDEDataCtrl);
    }

    public PSPublishContextImpl(ISRFDAGlobalHelper iDAGlobalHelper, ISRFDAWebContext daWebContext) {
        super(iDAGlobalHelper, daWebContext);
    }

    public void setPSLogItemList(ArrayList<IPSLogItem> psLogItemList) {
        this.psLogItemList = psLogItemList;
    }

    @Override
    public boolean isEnableVC() {
        return this.bEnableVC;
    }

    public void setEnableVC(boolean bEnableVC) {
        this.bEnableVC = bEnableVC;
    }

    @Override
    public boolean isRebuildMode() {
        return this.bRebuildMode;
    }

    public void setRebuildMode(boolean bRebuildMode) {
        this.bRebuildMode = bRebuildMode;
    }

    @Override
    public int getRebuildModeEx() {
        return this.nRebuildModeEx;
    }

    public void setRebuildModeEx(int nRebuildModeEx) {
        this.nRebuildModeEx = nRebuildModeEx;
    }

    public void setPubParams(HashMap<String, Object> params) {
        this.params = params;
    }

    @Override
    public HashMap<String, Object> getPubParams() {
        return this.params;
    }

    @Override
    public void log(int nLogLevel, IPSModelObject iPSModelObject, String strInfo, String strUserData) {
        this.log(nLogLevel, iPSModelObject, strInfo, strUserData, null);
    }

    @Override
    public void log(int nLogLevel, IPSModelObject iPSModelObject, String strInfo, String strUserData, String strUserData2) {
        if (this.psLogItemList != null) {
            PSLogItemImpl psLogItemImpl = new PSLogItemImpl();
            psLogItemImpl.setLogLevel(nLogLevel);
            psLogItemImpl.setLogInfo(strInfo);
            psLogItemImpl.setPSObject(iPSModelObject);
            psLogItemImpl.setUserData(strUserData);
            psLogItemImpl.setUserData2(strUserData2);
            this.psLogItemList.add(psLogItemImpl);
        }
    }

    @Override
    public void log(int nLogLevel, IPSModelObject iPSModelObject, String strInfo) {
        this.log(nLogLevel, iPSModelObject, strInfo, null, null);
    }
}

