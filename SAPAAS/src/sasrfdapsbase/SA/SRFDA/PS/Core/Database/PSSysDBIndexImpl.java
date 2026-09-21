/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.Database.IPSDEDBIndex;
import SA.SRFDA.PS.Core.Database.IPSDEDBIndexField;
import SA.SRFDA.PS.Core.Database.IPSSysDBColumn;
import SA.SRFDA.PS.Core.Database.IPSSysDBIndex;
import SA.SRFDA.PS.Core.Database.IPSSysDBIndexColumn;
import SA.SRFDA.PS.Core.Database.IPSSysDBTable;
import SA.SRFDA.PS.Core.Database.PSSysDBIndexColumnImpl;
import SA.SRFDA.PS.Core.Database.PSSysDBTableObjectImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSSysDBIndexImpl
extends PSSysDBTableObjectImpl
implements IPSSysDBIndex {
    private static final Log log = LogFactory.getLog(PSSysDBIndexImpl.class);
    private boolean bAllowReverse = false;
    private ArrayList<IPSSysDBIndexColumn> psSysDBIndexColumnList = new ArrayList();
    private ArrayList<IPSSysDBIndexColumn> psSysDBIndexColumnList2 = new ArrayList();
    private ArrayList<IPSSysDBIndexColumn> psSysDBIndexColumnList3 = new ArrayList();
    private String strCodeName = null;
    private String strIndexType = "NORMAL";
    private boolean bRemoveFlag = false;
    private IPSDEDBIndex iPSDEDBIndex = null;
    private IPSDER1N iPSDER1N = null;
    private IPSDEField iPSDEField = null;
    private IPSSysDBColumn iPSSysDBColumn = null;
    private String strUniqueId = null;
    private String strSourceType = null;
    private IPSSysDBColumn[] extColumns = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysDBTable iPSSysDBTable, Object object, IPSSysDBColumn[] extColumns) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysDBTable(iPSSysDBTable);
            this.extColumns = extColumns;
            if (object instanceof IPSDEDBIndex) {
                this.iPSDEDBIndex = (IPSDEDBIndex)object;
                this.setId(this.iPSDEDBIndex.getId());
                this.setName(this.iPSDEDBIndex.getName());
                this.strCodeName = this.iPSDEDBIndex.getCodeName();
                this.bAllowReverse = this.iPSDEDBIndex.isAllowReverse();
                this.strIndexType = this.iPSDEDBIndex.getIndexType();
                this.bRemoveFlag = this.iPSDEDBIndex.getRemoveFlag();
                this.strSourceType = "DEDBINDEX";
                this.setAutoModel(true);
            } else if (object instanceof IPSDER1N) {
                this.iPSDER1N = (IPSDER1N)object;
                this.setId(this.iPSDER1N.getId());
                this.setName(this.iPSDER1N.getName());
                String strFKeyName = this.iPSDER1N.getFKeyName();
                this.strCodeName = "IF_" + strFKeyName;
                if (extColumns != null && extColumns.length > 0) {
                    this.strCodeName = "IF2" + strFKeyName;
                }
                if (StringHelper.length((String)this.strCodeName) >= 18) {
                    this.strCodeName = this.strCodeName.substring(0, 18);
                }
                this.strSourceType = "DER";
                this.setAutoModel(true);
            } else if (object instanceof IPSDEField) {
                this.iPSDEField = (IPSDEField)object;
                this.setId(this.iPSDEField.getId());
                this.setName(this.iPSDEField.getName());
                String strFKeyName = KeyValueHelper.genUniqueId((String)iPSSysDBTable.getName(), (String)this.iPSDEField.getName()).toUpperCase();
                this.strCodeName = "IC_" + strFKeyName;
                if (extColumns != null && extColumns.length > 0) {
                    this.strCodeName = "IC2" + strFKeyName;
                }
                if (StringHelper.length((String)this.strCodeName) >= 18) {
                    this.strCodeName = this.strCodeName.substring(0, 18);
                }
                this.strSourceType = "DEFIELD";
                this.setAutoModel(true);
            } else if (object instanceof IPSSysDBColumn) {
                this.iPSSysDBColumn = (IPSSysDBColumn)object;
                this.setId(this.iPSSysDBColumn.getId());
                this.setName(this.iPSSysDBColumn.getName());
                String strFKeyName = KeyValueHelper.genUniqueId((String)iPSSysDBTable.getName(), (String)this.iPSSysDBColumn.getName()).toUpperCase();
                this.strCodeName = "IC_" + strFKeyName;
                if (extColumns != null && extColumns.length > 0) {
                    this.strCodeName = "IC2" + strFKeyName;
                }
                if (StringHelper.length((String)this.strCodeName) >= 18) {
                    this.strCodeName = this.strCodeName.substring(0, 18);
                }
                this.strSourceType = "DBCOLUMN";
                this.setAutoModel(true);
            } else {
                throw new Exception("\u65e0\u6cd5\u8bc6\u522b\u7684\u4f20\u5165\u5bf9\u8c61");
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
        this.preparePSSysDBIndexColumns();
        super.onInit();
    }

    protected void preparePSSysDBIndexColumns() throws Exception {
        PSSysDBIndexColumnImpl psSysDBIndexColumnImpl;
        this.psSysDBIndexColumnList.clear();
        this.psSysDBIndexColumnList2.clear();
        this.psSysDBIndexColumnList3.clear();
        TreeMap<String, String> map = new TreeMap<String, String>();
        if (this.getPSDEDBIndex() != null) {
            Iterator<IPSDEDBIndexField> psDEDBIndexFields = this.getPSDEDBIndex().getAllPSDEDBIndexFields();
            if (psDEDBIndexFields != null) {
                while (psDEDBIndexFields.hasNext()) {
                    IPSDEDBIndexField iPSDEDBIndexField = psDEDBIndexFields.next();
                    if (this.getPSSysDBTable().getPSSysDBColumn(iPSDEDBIndexField.getPSDEField().getName(), true) == null) {
                        log.warn((Object)String.format("\u5b9e\u4f53\u7d22\u5f15\u5c5e\u6027[%1$s]\u672a\u6307\u5b9a\u6570\u636e\u5217\uff0c\u5ffd\u7565", iPSDEDBIndexField.getPSDEField().getName()));
                        continue;
                    }
                    PSSysDBIndexColumnImpl psSysDBIndexColumnImpl2 = new PSSysDBIndexColumnImpl();
                    psSysDBIndexColumnImpl2.init(this.getDAGlobalHelper(), this, iPSDEDBIndexField);
                    if (psSysDBIndexColumnImpl2.isIncludeMode()) {
                        this.psSysDBIndexColumnList2.add(psSysDBIndexColumnImpl2);
                    } else {
                        this.psSysDBIndexColumnList.add(psSysDBIndexColumnImpl2);
                    }
                    this.psSysDBIndexColumnList3.add(psSysDBIndexColumnImpl2);
                }
            }
        } else if (this.getPSDER1N() != null) {
            if (this.getPSSysDBTable().getPSSysDBColumn(this.getPSDER1N().getPSPickupDEField().getName(), true) == null) {
                log.warn((Object)String.format("\u5173\u7cfb[%1$s]\u8fde\u63a5\u5c5e\u6027\u672a\u6307\u5b9a\u6570\u636e\u5217\uff0c\u5ffd\u7565", this.getPSDER1N().getName()));
                return;
            }
            psSysDBIndexColumnImpl = new PSSysDBIndexColumnImpl();
            psSysDBIndexColumnImpl.init(this.getDAGlobalHelper(), this, this.getPSDER1N().getPSPickupDEField());
            if (psSysDBIndexColumnImpl.isIncludeMode()) {
                this.psSysDBIndexColumnList2.add(psSysDBIndexColumnImpl);
            } else {
                this.psSysDBIndexColumnList.add(psSysDBIndexColumnImpl);
            }
            this.psSysDBIndexColumnList3.add(psSysDBIndexColumnImpl);
        } else if (this.getPSDEField() != null) {
            if (this.getPSSysDBTable().getPSSysDBColumn(this.getPSDEField().getName(), true) == null) {
                log.warn((Object)String.format("\u5b9e\u4f53\u5c5e\u6027[%1$s]\u672a\u6307\u5b9a\u6570\u636e\u5217\uff0c\u5ffd\u7565", this.getPSDEField().getName()));
                return;
            }
            psSysDBIndexColumnImpl = new PSSysDBIndexColumnImpl();
            psSysDBIndexColumnImpl.init(this.getDAGlobalHelper(), this, this.getPSDEField());
            if (psSysDBIndexColumnImpl.isIncludeMode()) {
                this.psSysDBIndexColumnList2.add(psSysDBIndexColumnImpl);
            } else {
                this.psSysDBIndexColumnList.add(psSysDBIndexColumnImpl);
            }
            this.psSysDBIndexColumnList3.add(psSysDBIndexColumnImpl);
        } else if (this.getPSSysDBColumn() != null) {
            psSysDBIndexColumnImpl = new PSSysDBIndexColumnImpl();
            psSysDBIndexColumnImpl.init(this.getDAGlobalHelper(), this, this.getPSSysDBColumn());
            if (psSysDBIndexColumnImpl.isIncludeMode()) {
                this.psSysDBIndexColumnList2.add(psSysDBIndexColumnImpl);
            } else {
                this.psSysDBIndexColumnList.add(psSysDBIndexColumnImpl);
            }
            this.psSysDBIndexColumnList3.add(psSysDBIndexColumnImpl);
        }
        for (IPSSysDBIndexColumn iPSSysDBIndexColumn : this.psSysDBIndexColumnList3) {
            map.put(iPSSysDBIndexColumn.getPSSysDBColumn().getName(), "");
        }
        if (this.extColumns != null) {
            IPSSysDBColumn[] iPSSysDBColumnArray = this.extColumns;
            int n = this.extColumns.length;
            int iPSDEDBIndexField = 0;
            while (iPSDEDBIndexField < n) {
                IPSSysDBColumn iPSSysDBColumn = iPSSysDBColumnArray[iPSDEDBIndexField];
                if (!map.containsKey(iPSSysDBColumn.getName())) {
                    PSSysDBIndexColumnImpl psSysDBIndexColumnImpl3 = new PSSysDBIndexColumnImpl();
                    psSysDBIndexColumnImpl3.init(this.getDAGlobalHelper(), this, iPSSysDBColumn);
                    if (psSysDBIndexColumnImpl3.isIncludeMode()) {
                        this.psSysDBIndexColumnList2.add(psSysDBIndexColumnImpl3);
                    } else {
                        this.psSysDBIndexColumnList.add(psSysDBIndexColumnImpl3);
                    }
                    this.psSysDBIndexColumnList3.add(psSysDBIndexColumnImpl3);
                    map.put(psSysDBIndexColumnImpl3.getPSSysDBColumn().getName(), "");
                }
                ++iPSDEDBIndexField;
            }
        }
        String strTemp = this.getPSSysDBTable().getName();
        for (String strKey : map.keySet()) {
            strTemp = String.valueOf(strTemp) + ";";
            strTemp = String.valueOf(strTemp) + strKey;
        }
        this.strUniqueId = KeyValueHelper.genUniqueId((String)strTemp.toUpperCase());
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u53cd\u5411\u68c0\u7d22", ignoredumpvalues="false")
    public boolean isAllowReverse() {
        return this.bAllowReverse;
    }

    @Override
    public Iterator<IPSSysDBIndexColumn> getPSSysDBIndexColumns(boolean bIncludeMode) {
        if (!bIncludeMode) {
            return this.psSysDBIndexColumnList.iterator();
        }
        return this.psSysDBIndexColumnList2.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u7d22\u5f15\u5217\u5bf9\u8c61\u96c6\u5408", child=true)
    public Iterator<IPSSysDBIndexColumn> getAllPSSysDBIndexColumns() {
        return this.psSysDBIndexColumnList3.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getModelType() {
        return "PSSYSDBINDEX";
    }

    @Override
    @PSModelRTMeta(description="\u7d22\u5f15\u7c7b\u578b", codelist="DEDBIndexType")
    public String getIndexType() {
        return this.strIndexType;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u9664\u6a21\u5f0f", ignoredumpvalues="false")
    public boolean getRemoveFlag() {
        return this.bRemoveFlag;
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u7d22\u5f15")
    public IPSDEDBIndex getPSDEDBIndex() {
        return this.iPSDEDBIndex;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb")
    public IPSDERBase getPSDER() {
        return this.getPSDER1N();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6765\u6e90\u7c7b\u578b", codelist="SysDBIndexSource")
    public String getSourceType() {
        return this.strSourceType;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5217")
    public IPSSysDBColumn getPSSysDBColumn() {
        return this.iPSSysDBColumn;
    }

    public IPSDER1N getPSDER1N() {
        return this.iPSDER1N;
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSSysDBTable().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysDBTable().getModelId(), (Object)this.getId());
    }

    @Override
    protected String onGetRTMOSFilePath() {
        return null;
    }

    @Override
    public String getUniqueId() {
        return this.strUniqueId;
    }
}

