/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  net.ibizsys.paas.core.IDEDataExportItem
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.util.KeyValueHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DataExport;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataExport;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExport;
import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExportGroup;
import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExportItem;
import SA.SRFDA.PS.Core.DataEntity.DataExport.PSDEDataExportGroupImpl;
import SA.SRFDA.PS.Core.DataEntity.DataExport.PSDEDataExportItemImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Data.PSDEDataExport;
import SA.SRFDA.PS.Data.PSDEGridColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.core.IDEDataExportItem;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataExportImpl
extends PSDataEntityObjectImpl
implements IPSDEDataExport,
IPSAppDEDataExport,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDEDataExportImpl.class);
    protected PSDEDataExport psDEDataExport;
    protected ArrayList<IPSDEDataExportItem> psDEDataExportItemList = new ArrayList();
    protected ArrayList<IDEDataExportItem> deDataExportItemList = new ArrayList();
    protected Map<String, IPSDEDataExportGroup> psDEDataExportGroupMap = new LinkedHashMap<String, IPSDEDataExportGroup>();
    protected String strCodeName = "";
    private int nMaxRowCount = 1000;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private int nActionHolder = 3;
    private boolean bCustomActionHolder = false;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSXCodeObject iPSXCodeObject = null;
    private boolean bDefault = false;
    private int nGroupLevel = 0;
    private int nPOTime = -1;
    private Properties expParams = null;
    private boolean bEnableCustomized = false;
    private IPSDEDataSet iPSDEDataSet = null;
    private IPSAppDEDataSet iPSAppDEDataSet = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDataEntity iPSAppDataEntity, PSDEDataExport psDEDataExport) throws Exception {
        this.iPSAppDataEntity = iPSAppDataEntity;
        this.init(iDAGlobalHelper, this.iPSAppDataEntity.getPSDataEntity(), psDEDataExport);
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEDataExport psDEDataExport) throws Exception {
        try {
            this.setPSDataEntity(iPSDataEntity);
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psDEDataExport = psDEDataExport;
            this.setId(psDEDataExport.getPSDEDATAEXPID());
            this.setName(psDEDataExport.getPSDEDATAEXPNAME());
            this.setPSObjectData(this.psDEDataExport);
            this.strCodeName = this.psDEDataExport.getCODENAME();
            if (!this.psDEDataExport.isMAXROWCNTNull()) {
                this.nMaxRowCount = this.psDEDataExport.getMAXROWCNT();
                if (this.nMaxRowCount <= 0) {
                    this.nMaxRowCount = 1000;
                }
            } else {
                this.nMaxRowCount = this.getPSSystemSetting().getDEDataExportMaxRowCount();
            }
            if (!this.psDEDataExport.isACTIONHOLDERNull()) {
                this.nActionHolder = this.psDEDataExport.getACTIONHOLDER();
                this.bCustomActionHolder = true;
            }
            if (!this.psDEDataExport.isDEFAULTFLAGNull()) {
                this.bDefault = this.psDEDataExport.getDEFAULTFLAG();
            }
            if (!this.psDEDataExport.isPOTIMENull() && this.psDEDataExport.getPOTIME() > 0) {
                this.nPOTime = this.psDEDataExport.getPOTIME();
            }
            if (!this.psDEDataExport.isENABLECUSTOMIZEDNull()) {
                this.bEnableCustomized = this.psDEDataExport.getENABLECUSTOMIZED();
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psDEDataExport.getEXPPARAMS())) {
                this.expParams = PropertiesHelper.Load((String)this.psDEDataExport.getEXPPARAMS());
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.Format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getModelName());
            String strExInfo = StringHelper.Format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.Format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psDEDataExport.getPSDEDATASETID())) {
            this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.psDEDataExport.getPSDEDATASETID());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEDataExport.getPSSYSPFPLUGINID())) {
            this.iPSSysPFPlugin = this.getPSDataEntity().getPSSystem().getPSSysPFPlugin(this.psDEDataExport.getPSSYSPFPLUGINID());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEDataExport.getPSSYSSFPLUGINID())) {
            this.iPSSysSFPlugin = this.getPSDataEntity().getPSSystem().getPSSysSFPlugin(this.psDEDataExport.getPSSYSSFPLUGINID());
        }
        if (this.getPSAppDataEntity() != null) {
            if (this.getPSSysPFPlugin() != null) {
                String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPlugin().getId(), (String)this.getPSAppDataEntity().getPSApplication().getPSPF().getId());
                IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSAppDataEntity().getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
                if (iPSSysPFPluginTempl != null) {
                    this.iPSXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, null, null, (Object)this);
                }
            }
            if (this.getPSDEDataSet() != null) {
                this.iPSAppDEDataSet = this.getPSAppDataEntity().getPSAppDEDataSet(this.getPSDEDataSet(), true);
            }
        } else if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        super.onInit();
        this.onPreparePSDEDataExportItems();
    }

    protected void onPreparePSDEDataExportItems() throws Exception {
        this.psDEDataExportItemList.clear();
        this.deDataExportItemList.clear();
        this.psDEDataExportGroupMap.clear();
        Vector<PSDEGridColumn> psDEGridColumnList = new Vector<PSDEGridColumn>();
        CallResult callResult = this.getPSModelHelper().getPSDEDataExportItems(this.getId(), psDEGridColumnList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEGridColumn psDEGridColumn : psDEGridColumnList) {
            if (StringHelper.Compare((String)psDEGridColumn.getGRIDCOLTYPE(), (String)"GROUPGRIDCOLUMN", (boolean)true) != 0) continue;
            PSDEDataExportGroupImpl iPSDEDataExportGroup = new PSDEDataExportGroupImpl();
            iPSDEDataExportGroup.init(this.getDAGlobalHelper(), this, psDEGridColumn);
            this.psDEDataExportGroupMap.put(iPSDEDataExportGroup.getId(), iPSDEDataExportGroup);
        }
        if (this.psDEDataExportGroupMap.size() > 0) {
            int nMaxGroupLevel = 0;
            for (IPSDEDataExportGroup iPSDEDataExportGroup : this.psDEDataExportGroupMap.values()) {
                iPSDEDataExportGroup.check();
                int nGroupLevel = iPSDEDataExportGroup.getGroupLevel();
                if (nGroupLevel <= nMaxGroupLevel) continue;
                nMaxGroupLevel = nGroupLevel;
            }
            this.nGroupLevel = nMaxGroupLevel;
        }
        ArrayList<Object> allList = new ArrayList<Object>();
        for (PSDEGridColumn psDEGridColumn : psDEGridColumnList) {
            if (StringHelper.Compare((String)psDEGridColumn.getGRIDCOLTYPE(), (String)"GROUPGRIDCOLUMN", (boolean)true) == 0) {
                allList.add(this.psDEDataExportGroupMap.get(psDEGridColumn.getPSDEGRIDCOLID()));
                continue;
            }
            if (StringHelper.Compare((String)psDEGridColumn.getGRIDCOLTYPE(), (String)"DEFGRIDCOLUMN", (boolean)true) != 0) continue;
            PSDEDataExportItemImpl iPSDEDataExportItem = new PSDEDataExportItemImpl();
            iPSDEDataExportItem.init(this.getDAGlobalHelper(), this, psDEGridColumn);
            this.psDEDataExportItemList.add(iPSDEDataExportItem);
            allList.add(iPSDEDataExportItem);
        }
        if (this.psDEDataExportGroupMap.size() > 0 && this.psDEDataExportItemList.size() > 0) {
            this.psDEDataExportItemList.clear();
            this.fillPSDEDataExportItemList(this.psDEDataExportItemList, null, allList);
        }
        this.deDataExportItemList.addAll(this.psDEDataExportItemList);
    }

    protected void fillPSDEDataExportItemList(List<IPSDEDataExportItem> list, IPSDEDataExportGroup parentPSDEDataExportGroup, List<Object> allList) throws Exception {
        for (Object objItem : allList) {
            if (objItem instanceof IPSDEDataExportItem) {
                IPSDEDataExportItem iPSDEDataExportItem = (IPSDEDataExportItem)objItem;
                if (parentPSDEDataExportGroup == null) {
                    if (iPSDEDataExportItem.getPSDEDataExportGroup() != null) continue;
                    list.add(iPSDEDataExportItem);
                    continue;
                }
                if (iPSDEDataExportItem.getPSDEDataExportGroup() == null || !iPSDEDataExportItem.getPSDEDataExportGroup().getId().equals(parentPSDEDataExportGroup.getId())) continue;
                list.add(iPSDEDataExportItem);
                continue;
            }
            if (!(objItem instanceof IPSDEDataExportGroup)) continue;
            IPSDEDataExportGroup iPSDEDataExportGroup = (IPSDEDataExportGroup)objItem;
            if (parentPSDEDataExportGroup == null) {
                if (iPSDEDataExportGroup.getParentPSDEDataExportGroup() != null) continue;
                this.fillPSDEDataExportItemList(list, iPSDEDataExportGroup, allList);
                continue;
            }
            if (iPSDEDataExportGroup.getParentPSDEDataExportGroup() == null || !iPSDEDataExportGroup.getParentPSDEDataExportGroup().getId().equals(parentPSDEDataExportGroup.getId())) continue;
            this.fillPSDEDataExportItemList(list, iPSDEDataExportGroup, allList);
        }
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53", hideempty=true)
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getModelType() {
        if (this.getPSAppDataEntity() != null) {
            return "PSAPPDEDATAEXP";
        }
        return "PSDEDATAEXP";
    }

    @Override
    public String getModelId() {
        if (this.getPSAppDataEntity() != null) {
            return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSAppDataEntity().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    public Iterator<IDEDataExportItem> getDEDataExportItems() {
        return this.deDataExportItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u51fa\u9879\u96c6\u5408", child=true)
    public Iterator<IPSDEDataExportItem> getPSDEDataExportItems() {
        return this.psDEDataExportItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u51fa\u5206\u7ec4\u96c6\u5408", child=true, ignorepf=true)
    public Iterator<IPSDEDataExportGroup> getPSDEDataExportGroups() {
        return this.psDEDataExportGroupMap.values().iterator();
    }

    @Override
    public IPSDEDataExportGroup getPSDEDataExportGroup(String strPSDEDataExportGroupId, boolean bTryMode) throws Exception {
        IPSDEDataExportGroup iPSDEDataExportGroup = this.psDEDataExportGroupMap.get(strPSDEDataExportGroupId);
        if (iPSDEDataExportGroup != null || bTryMode) {
            return iPSDEDataExportGroup;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5bfc\u51fa\u5206\u7ec4[%1$s]", strPSDEDataExportGroupId));
    }

    public void init(IDataEntity iDataEntity) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u8bb0\u5f55\u6570", fields={"MAXROWCNT"})
    public int getMaxRowCount() {
        return this.nMaxRowCount;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6301\u6709\u8005", codelist="DELogicHolder", dump=false)
    public int getActionHolder() {
        return this.nActionHolder;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u540e\u53f0\u6267\u884c", fields={"ACTIONHOLDER"})
    public boolean isEnableBackend() {
        return (this.getActionHolder() & 1) == 1;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u524d\u53f0\u6267\u884c", fields={"ACTIONHOLDER"})
    public boolean isEnableFront() {
        return (this.getActionHolder() & 2) == 2;
    }

    protected boolean isCustomActionHolder() {
        return this.bCustomActionHolder;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSXCodeObject getRender() {
        return this.iPSXCodeObject;
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5bfc\u51fa", ignoredumpvalues="false", fields={"DEFAULTFLAG"})
    public boolean isDefaultMode() {
        return this.bDefault;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u7ea7\u522b", ignoredumpvalues="0", ignorepf=true, doc="\u81ea\u52a8\u8ba1\u7b97\u5bfc\u51fa\u5206\u7ec4\u7ea7\u522b")
    public int getGroupLevel() {
        return this.nGroupLevel;
    }

    @Override
    @PSModelRTMeta(description="\u6027\u80fd\u4f18\u5316\u9884\u8b66\u65f6\u957f\uff08ms\uff09", ignorepf=true, ignoredumpvalues="-1", fields={"POTIME"})
    public int getPOTime() {
        return this.nPOTime;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u5165\u6807\u8bb0", fields={"EXPTAG"})
    public String getExpTag() {
        return this.psDEDataExport.getEXPTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u5165\u6807\u8bb02", fields={"EXPTAG2"})
    public String getExpTag2() {
        return this.psDEDataExport.getEXPTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u53c2\u6570", ignorepf=true, fields={"EXPPARAMS"})
    public Properties getExpParams() {
        return this.expParams;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u81ea\u5b9a\u4e49", ignoredumpvalues="false", fields={"ENABLECUSTOMIZED"})
    public boolean isEnableCustomized() {
        return this.bEnableCustomized;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u7c7b\u578b", fields={"CONTENTTYPE"})
    public String getContentType() {
        return this.psDEDataExport.getCONTENTTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u6587\u4ef6\u540d\u79f0\u683c\u5f0f\u5316", ignorepf=true, fields={"FILENAMEFORMAT"})
    public String getFileNameFormat() {
        return this.psDEDataExport.getFILENAMEFORMAT();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6570\u636e\u96c6", ignorepf=true, from="IPSDataEntity", dumpref=true, fields={"PSDEDATASETID"})
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u96c6\u5408", hideempty=true, dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEDataSet getPSAppDEDataSet() {
        return this.iPSAppDEDataSet;
    }
}

