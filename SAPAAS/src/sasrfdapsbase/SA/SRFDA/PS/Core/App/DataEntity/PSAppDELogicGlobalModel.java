/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEFLogicImpl;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Data.PSDELogic;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDELogicGlobalModel
extends PSAppDataEntityGlobalModelBase<String, PSDELogic, IPSAppDELogic> {
    private static final Log log = LogFactory.getLog(PSAppDELogicGlobalModel.class);

    @Override
    protected PSDELogic GetObject(String strPSDELogicId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u903b\u8f91[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDELogicId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSAppDELogic OnCreateModelHelper(PSDELogic vt, String objObjectId) throws Exception {
        PSDELogicImpl iPSDELogic = null;
        iPSDELogic = StringHelper.Compare((String)vt.getLOGICSUBTYPE(), (String)"DEFIELD", (boolean)false) == 0 ? new PSDEFLogicImpl() : new PSDELogicImpl();
        this.setModel(objObjectId, vt, iPSDELogic);
        iPSDELogic.init(this.iDAGlobalHelper, this.getPSAppDataEntity(), vt);
        return iPSDELogic;
    }

    @Override
    protected IPSAppDELogic OnCreateModelHelper(PSDELogic vt) throws Exception {
        PSDELogicImpl iPSDELogic = null;
        iPSDELogic = StringHelper.Compare((String)vt.getLOGICSUBTYPE(), (String)"DEFIELD", (boolean)false) == 0 ? new PSDEFLogicImpl() : new PSDELogicImpl();
        iPSDELogic.init(this.iDAGlobalHelper, this.getPSAppDataEntity(), vt);
        return iPSDELogic;
    }

    @Override
    protected Boolean TestObjectRenew(PSDELogic obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected Vector<PSDELogic> getAllModels() throws Exception {
        Vector<PSDELogic> psDELogicList2 = new Vector<PSDELogic>();
        CallResult callResult = this.iPSModelHelper.getPSDELogics(this.getPSDataEntity().getId(), psDELogicList2);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<PSDELogic> psDELogicList = new Vector<PSDELogic>();
        for (PSDELogic psDELogic : psDELogicList2) {
            if (!StringHelper.IsNullOrEmpty((String)psDELogic.getLOGICTYPE()) && StringHelper.Compare((String)psDELogic.getLOGICTYPE(), (String)"DELOGIC", (boolean)true) != 0 || !psDELogic.isLOGICHOLDERNull() && (psDELogic.getLOGICHOLDER() & 2) != 2) continue;
            psDELogicList.add(psDELogic);
        }
        for (PSDELogic psDELogic : psDELogicList) {
            this.setModel(psDELogic.getPSDELOGICID(), psDELogic, null);
        }
        return psDELogicList;
    }

    @Override
    protected IPSAppDELogic registerModel(PSDELogic vt) throws Exception {
        IPSAppDELogic iPSDELogic = (IPSAppDELogic)this.InternalGetModelHelper(vt.getPSDELOGICID());
        if (iPSDELogic != null) {
            return iPSDELogic;
        }
        this.setModel(vt.getPSDELOGICID(), vt, null);
        return (IPSAppDELogic)this.FindModelHelper(vt.getPSDELOGICID());
    }

    @Override
    protected String getObjectId(PSDELogic vt) {
        return vt.getPSDELOGICID();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20021, objObjectId);
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDELogic vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

