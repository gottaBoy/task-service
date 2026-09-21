/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DR;

import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRGroup;
import SA.SRFDA.PS.Core.DataEntity.DR.PSDEDRGroupImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEDRGroup;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDRGroupGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEDRGroup, IPSDEDRGroup> {
    private static final Log log = LogFactory.getLog(PSDEDRGroupGlobalModel.class);

    @Override
    protected PSDEDRGroup GetObject(String strPSDEDRGroupId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb\u5206\u7ec4[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEDRGroupId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEDRGroup OnCreateModelHelper(PSDEDRGroup vt) throws Exception {
        PSDEDRGroupImpl iPSDEDRGroup = new PSDEDRGroupImpl();
        iPSDEDRGroup.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEDRGroup;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEDRGroup obj) {
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
    protected Vector<PSDEDRGroup> getAllModels() throws Exception {
        Vector<PSDEDRGroup> psDEDRGroup = new Vector<PSDEDRGroup>();
        CallResult callResult = this.iPSModelHelper.getPSDEDRGroups(this.getPSDataEntity().getId(), psDEDRGroup);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5b9e\u4f53\u5173\u7cfb\u5206\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDRGroup;
    }

    @Override
    protected IPSDEDRGroup registerModel(PSDEDRGroup vt) throws Exception {
        IPSDEDRGroup iPSDEDRGroup = (IPSDEDRGroup)this.InternalGetModelHelper(vt.getPSDEDRGROUPID());
        if (iPSDEDRGroup != null) {
            return iPSDEDRGroup;
        }
        this.setModel(vt.getPSDEDRGROUPID(), vt, null);
        return (IPSDEDRGroup)this.FindModelHelper(vt.getPSDEDRGROUPID());
    }

    @Override
    protected String getObjectId(PSDEDRGroup vt) {
        return vt.getPSDEDRGROUPID();
    }

    @Override
    protected String getModelInfo() {
        return StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u5173\u7cfb\u754c\u9762\u5206\u7ec4", (Object)this.getPSDataEntity().getName());
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEDRGroup vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

