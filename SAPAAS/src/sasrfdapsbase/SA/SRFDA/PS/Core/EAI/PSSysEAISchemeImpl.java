/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.EAI.IPSEAIDE;
import SA.SRFDA.PS.Core.EAI.IPSEAIDataType;
import SA.SRFDA.PS.Core.EAI.IPSEAIElement;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDE;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDataType;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIElement;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIScheme;
import SA.SRFDA.PS.Core.EAI.PSSysEAIDEImpl;
import SA.SRFDA.PS.Core.EAI.PSSysEAIDataTypeImpl;
import SA.SRFDA.PS.Core.EAI.PSSysEAIElementImpl;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysEAIDE;
import SA.SRFDA.PS.Data.PSSysEAIDataType;
import SA.SRFDA.PS.Data.PSSysEAIElement;
import SA.SRFDA.PS.Data.PSSysEAIScheme;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysEAISchemeImpl
extends PSSystemObjectImpl
implements IPSSysEAIScheme {
    private static final Log log = LogFactory.getLog(PSSysEAISchemeImpl.class);
    protected PSSysEAIScheme psSysEAIScheme = null;
    private ArrayList<IPSSysEAIDataType> psSysEAIDataTypeList = new ArrayList();
    private Map<String, IPSSysEAIDataType> psSysEAIDataTypeMap = new LinkedHashMap<String, IPSSysEAIDataType>();
    private ArrayList<IPSSysEAIElement> psSysEAIElementList = new ArrayList();
    private Map<String, IPSSysEAIElement> psSysEAIElementMap = new LinkedHashMap<String, IPSSysEAIElement>();
    private ArrayList<IPSSysEAIDE> psSysEAIDEList = new ArrayList();
    private Map<String, IPSSysEAIDE> psSysEAIDEMap = new LinkedHashMap<String, IPSSysEAIDE>();
    private String strCodeName = "";
    private IPSSystemModule iPSSystemModule = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysEAIScheme psSysEAIScheme) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysEAIScheme = psSysEAIScheme;
            this.setId(this.psSysEAIScheme.getPSSYSEAISCHEMEID());
            this.setName(this.psSysEAIScheme.getPSSYSEAISCHEMENAME());
            this.setPSObjectData(this.psSysEAIScheme);
            this.strCodeName = this.psSysEAIScheme.getCODENAME();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysEAIScheme.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysEAIScheme.getPSMODULEID());
            }
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
        String strPSSysSFPluginId = this.psSysEAIScheme.getPSSYSSFPLUGINID();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSSysSFPluginId)) {
            this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(strPSSysSFPluginId);
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        this.onPreparePSSysEAIDataTypes();
        this.onPreparePSSysEAIElements();
        this.onPreparePSSysEAIDEs();
        super.onInit();
    }

    protected void onPreparePSSysEAIDataTypes() throws Exception {
        this.psSysEAIDataTypeList.clear();
        Vector<PSSysEAIDataType> psSysEAIDataTypeList = new Vector<PSSysEAIDataType>();
        CallResult callResult = this.getPSModelHelper().getPSSysEAIDataTypes(this.getId(), psSysEAIDataTypeList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u96c6\u6210\u6570\u636e\u7c7b\u578b\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysEAIDataType psSysEAIDataType : psSysEAIDataTypeList) {
            PSSysEAIDataTypeImpl iPSSysEAIDataType = new PSSysEAIDataTypeImpl();
            iPSSysEAIDataType.init(this.getDAGlobalHelper(), this, psSysEAIDataType);
            this.psSysEAIDataTypeList.add(iPSSysEAIDataType);
            this.psSysEAIDataTypeMap.put(iPSSysEAIDataType.getId(), iPSSysEAIDataType);
            this.psSysEAIDataTypeMap.put(iPSSysEAIDataType.getName(), iPSSysEAIDataType);
        }
    }

    protected void onPreparePSSysEAIElements() throws Exception {
        this.psSysEAIElementList.clear();
        Vector<PSSysEAIElement> psSysEAIElementList = new Vector<PSSysEAIElement>();
        CallResult callResult = this.getPSModelHelper().getPSSysEAIElements(this.getId(), psSysEAIElementList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u96c6\u6210\u5143\u7d20\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysEAIElement psSysEAIElement : psSysEAIElementList) {
            PSSysEAIElementImpl iPSSysEAIElement = new PSSysEAIElementImpl();
            iPSSysEAIElement.init(this.getDAGlobalHelper(), this, psSysEAIElement);
            this.psSysEAIElementList.add(iPSSysEAIElement);
            this.psSysEAIElementMap.put(iPSSysEAIElement.getId(), iPSSysEAIElement);
            this.psSysEAIElementMap.put(iPSSysEAIElement.getName(), iPSSysEAIElement);
        }
    }

    protected void onPreparePSSysEAIDEs() throws Exception {
        this.psSysEAIDEList.clear();
        Vector<PSSysEAIDE> psSysEAIDEList = new Vector<PSSysEAIDE>();
        CallResult callResult = this.getPSModelHelper().getPSSysEAIDEs(this.getId(), psSysEAIDEList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u96c6\u6210\u5b9e\u4f53\u6620\u5c04\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysEAIDE psSysEAIDE : psSysEAIDEList) {
            PSSysEAIDEImpl iPSSysEAIDE = new PSSysEAIDEImpl();
            iPSSysEAIDE.init(this.getDAGlobalHelper(), this, psSysEAIDE);
            this.psSysEAIDEList.add(iPSSysEAIDE);
            this.psSysEAIDEMap.put(iPSSysEAIDE.getId(), iPSSysEAIDE);
            this.psSysEAIDEMap.put(iPSSysEAIDE.getName(), iPSSysEAIDE);
        }
    }

    @Override
    public String getModelType() {
        return "PSSYSEAISCHEME";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, dynamodelmode=4)
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
    }

    @Override
    @PSModelRTMeta(description="\u96c6\u6210\u6570\u636e\u7c7b\u578b\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysEAIDataType> getAllPSSysEAIDataTypes() {
        if (this.psSysEAIDataTypeList == null || this.psSysEAIDataTypeList.size() == 0) {
            return null;
        }
        return this.psSysEAIDataTypeList.iterator();
    }

    @Override
    public Iterator<? extends IPSEAIDataType> getAllPSEAIDataTypes() {
        return this.getAllPSSysEAIDataTypes();
    }

    @Override
    public IPSEAIDataType getPSEAIDataType(String strPSEAIDataTypeId) throws Exception {
        return this.getPSSysEAIDataType(strPSEAIDataTypeId);
    }

    @Override
    public IPSEAIDataType getPSEAIDataType(String strPSEAIDataTypeId, boolean bTryMode) throws Exception {
        return this.getPSSysEAIDataType(strPSEAIDataTypeId, bTryMode);
    }

    @Override
    public IPSSysEAIDataType getPSSysEAIDataType(String strPSSysEAIDataTypeId) throws Exception {
        return this.getPSSysEAIDataType(strPSSysEAIDataTypeId, false);
    }

    @Override
    public IPSSysEAIDataType getPSSysEAIDataType(String strPSSysEAIDataTypeId, boolean bTryMode) throws Exception {
        IPSSysEAIDataType iPSSysEAIDataType = null;
        if (this.psSysEAIDataTypeMap != null) {
            iPSSysEAIDataType = this.psSysEAIDataTypeMap.get(strPSSysEAIDataTypeId);
        }
        if (iPSSysEAIDataType != null || bTryMode) {
            return iPSSysEAIDataType;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u96c6\u6210\u6570\u636e\u7c7b\u578b[%1$s]", (Object)strPSSysEAIDataTypeId));
    }

    @Override
    @PSModelRTMeta(description="\u96c6\u6210\u5b9e\u4f53\u6620\u5c04\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysEAIDE> getAllPSSysEAIDEs() {
        if (this.psSysEAIDEList == null || this.psSysEAIDEList.size() == 0) {
            return null;
        }
        return this.psSysEAIDEList.iterator();
    }

    @Override
    public Iterator<? extends IPSEAIDE> getAllPSEAIDEs() {
        return this.getAllPSSysEAIDEs();
    }

    @Override
    public IPSEAIDE getPSEAIDE(String strPSEAIDEId) throws Exception {
        return this.getPSSysEAIDE(strPSEAIDEId);
    }

    @Override
    public IPSEAIDE getPSEAIDE(String strPSEAIDEId, boolean bTryMode) throws Exception {
        return this.getPSSysEAIDE(strPSEAIDEId, bTryMode);
    }

    @Override
    public IPSSysEAIDE getPSSysEAIDE(String strPSSysEAIDEId) throws Exception {
        return this.getPSSysEAIDE(strPSSysEAIDEId, false);
    }

    @Override
    public IPSSysEAIDE getPSSysEAIDE(String strPSSysEAIDEId, boolean bTryMode) throws Exception {
        IPSSysEAIDE iPSSysEAIDE = null;
        if (this.psSysEAIDEMap != null) {
            iPSSysEAIDE = this.psSysEAIDEMap.get(strPSSysEAIDEId);
        }
        if (iPSSysEAIDE != null || bTryMode) {
            return iPSSysEAIDE;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u96c6\u6210\u5b9e\u4f53\u6620\u5c04[%1$s]", (Object)strPSSysEAIDEId));
    }

    @Override
    @PSModelRTMeta(description="\u96c6\u6210\u5143\u7d20\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysEAIElement> getAllPSSysEAIElements() {
        if (this.psSysEAIElementList == null || this.psSysEAIElementList.size() == 0) {
            return null;
        }
        return this.psSysEAIElementList.iterator();
    }

    @Override
    public Iterator<? extends IPSEAIElement> getAllPSEAIElements() {
        return this.getAllPSSysEAIElements();
    }

    @Override
    public IPSEAIElement getPSEAIElement(String strPSEAIElementId) throws Exception {
        return this.getPSSysEAIElement(strPSEAIElementId);
    }

    @Override
    public IPSEAIElement getPSEAIElement(String strPSEAIElementId, boolean bTryMode) throws Exception {
        return this.getPSSysEAIElement(strPSEAIElementId, bTryMode);
    }

    @Override
    public IPSSysEAIElement getPSSysEAIElement(String strPSSysEAIElementId) throws Exception {
        return this.getPSSysEAIElement(strPSSysEAIElementId, false);
    }

    @Override
    public IPSSysEAIElement getPSSysEAIElement(String strPSSysEAIElementId, boolean bTryMode) throws Exception {
        IPSSysEAIElement iPSSysEAIElement = null;
        if (this.psSysEAIElementMap != null) {
            iPSSysEAIElement = this.psSysEAIElementMap.get(strPSSysEAIElementId);
        }
        if (iPSSysEAIElement != null || bTryMode) {
            return iPSSysEAIElement;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u96c6\u6210\u5143\u7d20[%1$s]", (Object)strPSSysEAIElementId));
    }

    @Override
    @PSModelRTMeta(description="\u4f53\u7cfb\u6807\u8bb0", hideempty2=true)
    public String getSchemeTag() {
        return this.psSysEAIScheme.getEAISCHEMETAG();
    }

    @Override
    @PSModelRTMeta(description="\u4f53\u7cfb\u6807\u8bb02", hideempty2=true)
    public String getSchemeTag2() {
        return this.psSysEAIScheme.getEAISCHEMETAG2();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }
}

