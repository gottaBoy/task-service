/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIHierarchy;
import SA.SRFDA.PS.Core.BI.IPSSysBIDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBIHierarchy;
import SA.SRFDA.PS.Core.BI.IPSSysBIScheme;
import SA.SRFDA.PS.Core.BI.PSSysBIHierarchyImpl;
import SA.SRFDA.PS.Core.BI.PSSysBISchemeObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysBIDimension;
import SA.SRFDA.PS.Data.PSSysBIHierarchy;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBIDimensionImpl
extends PSSysBISchemeObjectImpl
implements IPSSysBIDimension {
    private static final Log log = LogFactory.getLog(PSSysBIDimensionImpl.class);
    protected PSSysBIDimension psSysBIDimension = null;
    private ArrayList<IPSSysBIHierarchy> psSysBIHierarchyList = new ArrayList();
    private Map<String, IPSSysBIHierarchy> psSysBIHierarchyMap = new LinkedHashMap<String, IPSSysBIHierarchy>();

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysBIScheme iPSSysBIScheme, PSSysBIDimension psSysBIDimension) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysBIScheme(iPSSysBIScheme);
            this.psSysBIDimension = psSysBIDimension;
            this.setId(this.psSysBIDimension.getPSSYSBIDIMENSIONID());
            this.setName(this.psSysBIDimension.getPSSYSBIDIMENSIONNAME());
            this.setPSObjectData(this.psSysBIDimension);
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        this.onPreparePSSysBIHierarchies();
        super.onInit();
    }

    protected void onPreparePSSysBIHierarchies() throws Exception {
        this.psSysBIHierarchyList.clear();
        Vector<PSSysBIHierarchy> psSysBIHierarchyList = new Vector<PSSysBIHierarchy>();
        CallResult callResult = this.getPSModelHelper().getPSSysBIHierarchies(this.getId(), psSysBIHierarchyList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7ef4\u5ea6\u67b6\u6784\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysBIHierarchy psSysBIHierarchy : psSysBIHierarchyList) {
            PSSysBIHierarchyImpl iPSSysBIHierarchy = new PSSysBIHierarchyImpl();
            iPSSysBIHierarchy.init(this.getDAGlobalHelper(), this, psSysBIHierarchy);
            this.psSysBIHierarchyList.add(iPSSysBIHierarchy);
            this.psSysBIHierarchyMap.put(iPSSysBIHierarchy.getId(), iPSSysBIHierarchy);
            this.psSysBIHierarchyMap.put(iPSSysBIHierarchy.getName(), iPSSysBIHierarchy);
        }
    }

    @Override
    public String getModelType() {
        return "PSSYSBIDIMENSION";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysBIDimension.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7ef4\u5ea6\u67b6\u6784\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysBIHierarchy> getAllPSSysBIHierarchies() throws Exception {
        if (this.psSysBIHierarchyList == null || this.psSysBIHierarchyList.size() == 0) {
            return null;
        }
        return this.psSysBIHierarchyList.iterator();
    }

    @Override
    public IPSSysBIHierarchy getPSSysBIHierarchy(String strPSSysBIHierarchyId) throws Exception {
        return this.getPSSysBIHierarchy(strPSSysBIHierarchyId, false);
    }

    @Override
    public IPSBIHierarchy getPSBIHierarchy(String strPSBIHierarchyId, boolean bTryMode) throws Exception {
        return this.getPSSysBIHierarchy(strPSBIHierarchyId, bTryMode);
    }

    @Override
    public IPSSysBIHierarchy getPSSysBIHierarchy(String strPSSysBIHierarchyId, boolean bTryMode) throws Exception {
        IPSSysBIHierarchy iPSSysBIHierarchy = null;
        if (this.psSysBIHierarchyMap != null) {
            iPSSysBIHierarchy = this.psSysBIHierarchyMap.get(strPSSysBIHierarchyId);
        }
        if (iPSSysBIHierarchy != null || bTryMode) {
            return iPSSysBIHierarchy;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7ef4\u5ea6\u67b6\u6784[%1$s]", (Object)strPSSysBIHierarchyId));
    }

    @Override
    public Iterator<? extends IPSBIHierarchy> getAllPSBIHierarchies() throws Exception {
        return this.getAllPSSysBIHierarchies();
    }

    @Override
    public IPSBIHierarchy getPSBIHierarchy(String strPSBIHierarchyId) throws Exception {
        return this.getPSSysBIHierarchy(strPSBIHierarchyId);
    }

    @Override
    @PSModelRTMeta(description="\u7ef4\u5ea6\u6807\u8bb0")
    public String getDimensionTag() {
        return this.psSysBIDimension.getBIDIMENSIONTAG();
    }

    @Override
    @PSModelRTMeta(description="\u7ef4\u5ea6\u6807\u8bb02")
    public String getDimensionTag2() {
        return this.psSysBIDimension.getBIDIMENSIONTAG2();
    }
}

