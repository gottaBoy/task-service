/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.WF;

import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.DataEntity.WF.PSDEWFImpl;
import SA.SRFDA.PS.Data.PSWFDE;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEWFGlobalModel
extends PSDataEntityGlobalModelBase<String, PSWFDE, IPSDEWF> {
    private static final Log log = LogFactory.getLog(PSDEWFGlobalModel.class);

    @Override
    protected PSWFDE GetObject(String strPSWFDEId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u6d41\u7a0b\u914d\u7f6e[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSWFDEId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEWF OnCreateModelHelper(PSWFDE vt) throws Exception {
        PSDEWFImpl iPSWFDE = new PSDEWFImpl();
        iPSWFDE.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSWFDE;
    }

    @Override
    protected Boolean TestObjectRenew(PSWFDE obj) {
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
    protected Vector<PSWFDE> getAllModels() throws Exception {
        Vector<PSWFDE> psWFDEList = new Vector<PSWFDE>();
        CallResult callResult = this.iPSModelHelper.getPSWFDEs(this.getPSDataEntity().getId(), psWFDEList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u6d41\u7a0b\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (psWFDEList.size() > 0) {
            PSWFDE defaultPSWFDE = null;
            for (PSWFDE psWFDE : psWFDEList) {
                if (!psWFDE.getDEFAULTMODE()) continue;
                defaultPSWFDE = psWFDE;
                break;
            }
            if (defaultPSWFDE == null) {
                defaultPSWFDE = psWFDEList.get(0);
                defaultPSWFDE.setDEFAULTMODE(true);
            }
            for (PSWFDE psWFDE : psWFDEList) {
                if (psWFDE == defaultPSWFDE) continue;
                psWFDE.setDEFAULTMODE(false);
            }
        }
        return psWFDEList;
    }

    @Override
    protected IPSDEWF registerModel(PSWFDE vt) throws Exception {
        IPSDEWF iPSDEWF = (IPSDEWF)this.InternalGetModelHelper(vt.getPSWFDEID());
        if (iPSDEWF != null) {
            return iPSDEWF;
        }
        this.setModel(vt.getPSWFID(), vt, null);
        this.setModel(vt.getPSWFDEID(), vt, null);
        return (IPSDEWF)this.FindModelHelper(vt.getPSWFDEID());
    }

    @Override
    protected String getObjectId(PSWFDE vt) {
        return vt.getPSWFDEID();
    }
}

