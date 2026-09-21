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

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMap;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.DataEntity.DataMap.PSDEMapImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Data.PSDEMap;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDEMapGlobalModel
extends PSAppDataEntityGlobalModelBase<String, PSDEMap, IPSAppDEMap> {
    private static final Log log = LogFactory.getLog(PSAppDEMapGlobalModel.class);

    @Override
    protected PSDEMap GetObject(String strPSDEMapId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u6620\u5c04[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEMapId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSAppDEMap OnCreateModelHelper(PSDEMap vt, String objObjectId) throws Exception {
        PSDEMapImpl iPSDEMap = new PSDEMapImpl();
        iPSDEMap.init(this.iDAGlobalHelper, this.getPSAppDataEntity(), vt);
        return iPSDEMap;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEMap obj) {
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
    protected IPSAppDEMap registerModel(PSDEMap vt) throws Exception {
        IPSAppDEMap iPSDEMap = (IPSAppDEMap)this.InternalGetModelHelper(vt.getPSDEMAPID());
        if (iPSDEMap != null) {
            return iPSDEMap;
        }
        this.setModel(vt.getPSDEMAPID(), vt, null);
        iPSDEMap = (IPSAppDEMap)this.FindModelHelper(vt.getPSDEMAPID());
        return iPSDEMap;
    }

    @Override
    protected Vector<PSDEMap> getAllModels() throws Exception {
        Vector<PSDEMap> psDEMapList = new Vector<PSDEMap>();
        CallResult callResult = this.iPSModelHelper.getPSDEMaps(this.getPSDataEntity().getId(), psDEMapList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u6620\u5c04\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<PSDEMap> psDEMapList2 = new Vector<PSDEMap>();
        for (PSDEMap psDEMap : psDEMapList) {
            IPSAppDataEntity dstPSAppDataEntity;
            String strDstPSDEId;
            if (psDEMap.isLOGICHOLDERNull() || (psDEMap.getLOGICHOLDER() & 2) != 2 || StringHelper.IsNullOrEmpty((String)(strDstPSDEId = psDEMap.getDSTPSDEID())) || (dstPSAppDataEntity = this.getPSAppDataEntity().getPSApplication().getPSAppDataEntityByDEId(strDstPSDEId, true)) == null) continue;
            psDEMapList2.add(psDEMap);
        }
        return psDEMapList2;
    }

    @Override
    protected String getObjectId(PSDEMap vt) {
        return vt.getPSDEMAPID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEMap vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20005, objObjectId);
    }
}

