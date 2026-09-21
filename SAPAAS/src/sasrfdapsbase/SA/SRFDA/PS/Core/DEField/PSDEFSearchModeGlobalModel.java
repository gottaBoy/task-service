/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSDEFSearchMode;
import SA.SRFDA.PS.Core.DEField.PSDEFieldGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEFSearchMode;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFSearchModeGlobalModel
extends PSDEFieldGlobalModelBase<String, PSDEFSearchMode, IPSDEFSearchMode> {
    private static final Log log = LogFactory.getLog(PSDEFSearchModeGlobalModel.class);
    private IPSDEFSearchMode defaultPSDEFSearchMode = null;
    private static Map<String, String> psDBValueOPMap = new HashMap<String, String>();

    static {
        psDBValueOPMap.put("BITAND", "\u4f4d\u4e0e\u64cd\u4f5c\uff08BitAnd\uff09(\u4ec5\u9650\u6574\u6570\u5f62\uff09");
        psDBValueOPMap.put("CHILDOF", "\u5b50\u6570\u636e\uff08\u9012\u5f52\uff09");
        psDBValueOPMap.put("EQ", "\u7b49\u4e8e(=)");
        psDBValueOPMap.put("GT", "\u5927\u4e8e(>)");
        psDBValueOPMap.put("GTANDEQ", "\u5927\u4e8e\u7b49\u4e8e(>=)");
        psDBValueOPMap.put("IN", "\u503c\u5728\u8303\u56f4\u4e2d(In)");
        psDBValueOPMap.put("ISNOTNULL", "\u503c\u4e0d\u4e3a\u7a7a(NotNil)");
        psDBValueOPMap.put("ISNULL", "\u503c\u4e3a\u7a7a(Nil)");
        psDBValueOPMap.put("LEFTLIKE", "\u6587\u672c\u5de6\u5305\u542b(%#)");
        psDBValueOPMap.put("LIKE", "\u6587\u672c\u5305\u542b(%)");
        psDBValueOPMap.put("LT", "\u5c0f\u4e8e(<)");
        psDBValueOPMap.put("LTANDEQ", "\u5c0f\u4e8e\u7b49\u4e8e(<=)");
        psDBValueOPMap.put("NOTEQ", "\u4e0d\u7b49\u4e8e(<>)");
        psDBValueOPMap.put("NOTIN", "\u503c\u4e0d\u5728\u8303\u56f4\u4e2d(NotIn)");
        psDBValueOPMap.put("RIGHTLIKE", "\u6587\u672c\u53f3\u5305\u542b(#%)");
        psDBValueOPMap.put("TESTNULL", "\u7a7a\u503c\u5224\u65ad(TestNil)");
        psDBValueOPMap.put("USERLIKE", "\u81ea\u5b9a\u4e49\u6587\u672c\u5305\u542b(%)");
    }

    @Override
    protected PSDEFSearchMode GetObject(String strPSDEFSearchModeId) {
        if (this.isPrepareModels()) {
            return null;
        }
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEFSearchModeId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEFSearchMode OnCreateModelHelper(PSDEFSearchMode vt) throws Exception {
        IPSDEFSearchMode iPSDEFSearchMode = this.getPSDEField().createPSDEFSearchMode(vt);
        iPSDEFSearchMode.init(this.iDAGlobalHelper, this.iPSDEField, vt);
        return iPSDEFSearchMode;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEFSearchMode obj) {
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
    protected IPSDEFSearchMode registerModel(PSDEFSearchMode vt) throws Exception {
        IPSDEFSearchMode iPSDEFSearchMode = (IPSDEFSearchMode)this.InternalGetModelHelper(vt.getPSDEFSFITEMID());
        if (iPSDEFSearchMode != null) {
            return iPSDEFSearchMode;
        }
        this.setModel(vt.getPSDEFSFITEMID(), vt, null);
        this.setModel(vt.getPSDEFSFITEMNAME(), vt, null);
        if (!vt.getPSDEFSFITEMNAME().toUpperCase().equals(vt.getPSDEFSFITEMNAME())) {
            this.setModel(vt.getPSDEFSFITEMNAME().toUpperCase(), vt, null);
        }
        iPSDEFSearchMode = (IPSDEFSearchMode)this.FindModelHelper(vt.getPSDEFSFITEMID());
        if (this.defaultPSDEFSearchMode == null && iPSDEFSearchMode.isDefault()) {
            this.defaultPSDEFSearchMode = iPSDEFSearchMode;
        }
        return iPSDEFSearchMode;
    }

    @Override
    protected Vector<PSDEFSearchMode> getAllModels() throws Exception {
        Vector<PSDEFSearchMode> psDEFSearchModeList = new Vector<PSDEFSearchMode>();
        ArrayList<PSDEFSearchMode> psDEFSearchModeList2 = this.getPSDEField().getPSDEFieldData().getPSDEFSearchModes(false);
        if (psDEFSearchModeList2 == null) {
            return psDEFSearchModeList;
        }
        psDEFSearchModeList.addAll(psDEFSearchModeList2);
        return psDEFSearchModeList;
    }

    @Override
    protected String getObjectId(PSDEFSearchMode vt) {
        return vt.getPSDEFSFITEMID();
    }

    @Override
    protected String getModelInfo() {
        if (this.iPSDEField != null) {
            return this.iPSDEField.getName();
        }
        return super.getModelInfo();
    }

    public IPSDEFSearchMode getDefaultPSDEFSearchMode() {
        this.preloadModels();
        return this.defaultPSDEFSearchMode;
    }

    @Override
    public IPSDEFSearchMode FindModelHelper(String objObjectId, boolean bTryMode) throws Exception {
        IPSDEFSearchMode iPSDEFSearchMode = (IPSDEFSearchMode)super.FindModelHelper(objObjectId, true);
        if (iPSDEFSearchMode != null || bTryMode) {
            return iPSDEFSearchMode;
        }
        if (objObjectId.indexOf("N_") == 0) {
            for (Map.Entry<String, String> entry : psDBValueOPMap.entrySet()) {
                String strAutoId = String.format("N_%1$s_%2$s", this.getPSDEField().getName(), entry.getKey());
                if (StringHelper.Compare((String)objObjectId, (String)strAutoId, (boolean)true) != 0) continue;
                PSDEFSearchMode psDEFSearchMode = new PSDEFSearchMode();
                psDEFSearchMode.setPSDEFSFITEMID(KeyValueHelper.genUniqueId((String)this.iPSDEField.getId(), (String)strAutoId));
                psDEFSearchMode.setPSDEFSFITEMNAME(strAutoId);
                psDEFSearchMode.setPSDEFID(this.iPSDEField.getId());
                psDEFSearchMode.setPSDEFNAME(this.iPSDEField.getName());
                psDEFSearchMode.setPSDEID(this.iPSDEField.getPSDataEntity().getId());
                psDEFSearchMode.setPSDENAME(this.iPSDEField.getPSDataEntity().getName());
                psDEFSearchMode.setPSDBVALUEOPID(entry.getKey());
                psDEFSearchMode.setPSDBVALUEOPNAME(entry.getValue());
                iPSDEFSearchMode = this.OnCreateModelHelper(psDEFSearchMode);
                this.setModel(objObjectId, psDEFSearchMode, iPSDEFSearchMode);
                this.internalAddAllModelHelper(iPSDEFSearchMode);
                return iPSDEFSearchMode;
            }
        }
        return (IPSDEFSearchMode)super.FindModelHelper(objObjectId, bTryMode);
    }
}

