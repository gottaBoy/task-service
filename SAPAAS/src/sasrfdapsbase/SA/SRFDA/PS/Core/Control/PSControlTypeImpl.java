/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxControlHandler;
import SA.SRFDA.PS.Core.Control.IPSAjaxControl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.JIT.Core.IPSJITControlType;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCtrlHandler;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITSFACHandler;
import SA.SRFDA.PS.Core.JIT.CtrlModel.IPSJITCtrlModel;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.PS.Data.PSControlType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.UtilityEx.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSControlTypeImpl
extends PSObjectImpl
implements IPSControlType,
IPSJITControlType {
    protected PSControlType psControlType = null;
    private static final Log log = LogFactory.getLog(PSControlTypeImpl.class);
    private boolean bAjaxControl = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSControlType psControlType) throws Exception {
        this.psControlType = psControlType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psControlType.getPSCTRLTYPEID());
        this.setName(psControlType.getPSCTRLTYPENAME());
        this.setPSObjectData(this.psControlType);
        this.bAjaxControl = this.psControlType.getAJAXCTRL();
        this.onInit();
    }

    @Override
    public String getControlDEId() {
        return this.psControlType.getCTRLDEID();
    }

    @Override
    public boolean isAjaxControl() {
        return this.bAjaxControl;
    }

    @Override
    public IPSControl createPSControl(IPSControlParam iPSControlParam) throws Exception {
        IPSControl iPSControl = (IPSControl)ObjectHelper.Create((String)this.psControlType.getCTRLOBJ());
        iPSControl.setPSControlType(this);
        return iPSControl;
    }

    @Override
    public IPSControlParam createPSControlParam(BaseDataEntity dataEntity) throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psControlType.getPARAMOBJ())) {
            throw new Exception(StringHelper.format((String)"\u90e8\u4ef6\u7c7b\u578b[%1$s]\u6ca1\u6709\u6307\u5b9a\u90e8\u4ef6\u53c2\u6570\u5bf9\u8c61", (Object)this.getName()));
        }
        IPSControlParam iPSControlParam = (IPSControlParam)ObjectHelper.Create((String)this.psControlType.getPARAMOBJ());
        if (iPSControlParam == null) {
            throw new Exception(StringHelper.format((String)"\u90e8\u4ef6\u7c7b\u578b[%1$s]\u6307\u5b9a\u90e8\u4ef6\u53c2\u6570\u5bf9\u8c61\u65e0\u6548", (Object)this.getName()));
        }
        return iPSControlParam;
    }

    @Override
    public IPSAjaxControlHandler createPSAjaxControlHandler(PSACHandler psACHandler) throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psControlType.getHANDLEROBJ())) {
            return null;
        }
        IPSAjaxControlHandler iPSAjaxControlHandler = (IPSAjaxControlHandler)ObjectHelper.Create((String)this.psControlType.getHANDLEROBJ());
        return iPSAjaxControlHandler;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public IPSJITCtrlModel createPSJITCtrlModel(IPSControl iPSControl) throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psControlType.getJITMODELOBJ())) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u5b9a\u4e49\u90e8\u4ef6[%1$s]\u5373\u65f6\u6a21\u578b\u5bf9\u8c61", (Object)iPSControl.getControlType()));
        }
        IPSJITCtrlModel iPSJITCtrlModel = (IPSJITCtrlModel)ObjectHelper.Create((String)this.psControlType.getJITMODELOBJ());
        return iPSJITCtrlModel;
    }

    @Override
    public IPSJITCtrlHandler createPSJITCtrlHandler(IPSControl iPSControl) throws Exception {
        IPSJITSFACHandler iPSJITSFACHandler;
        IPSJITCtrlHandler iPSJITCtrlHandler;
        IPSAjaxControl iPSAjaxControl;
        if (iPSControl instanceof IPSAjaxControl && (iPSAjaxControl = (IPSAjaxControl)iPSControl).getPSAjaxControlHandler() != null && iPSAjaxControl.getPSAjaxControlHandler().getPSSFACHandler() != null && (iPSJITCtrlHandler = (iPSJITSFACHandler = (IPSJITSFACHandler)iPSAjaxControl.getPSAjaxControlHandler().getPSSFACHandler()).createPSJITCtrlHandler(iPSControl, true)) != null) {
            return iPSJITCtrlHandler;
        }
        String strObj = this.psControlType.getJITCTRLOBJ();
        if (iPSControl.getPSAppView().isEnableWF() && !StringHelper.isNullOrEmpty((String)this.psControlType.getJITCTRLOBJ2())) {
            strObj = this.psControlType.getJITCTRLOBJ2();
        }
        if (StringHelper.isNullOrEmpty((String)strObj)) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u5b9a\u4e49\u90e8\u4ef6[%1$s]\u5373\u65f6\u5904\u7406\u5bf9\u8c61", (Object)iPSControl.getControlType()));
        }
        IPSJITCtrlHandler iPSJITCtrlHandler2 = (IPSJITCtrlHandler)ObjectHelper.Create((String)strObj);
        return iPSJITCtrlHandler2;
    }
}

