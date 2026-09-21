/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.Database.IPSDEDBIndex;
import SA.SRFDA.PS.Core.Database.IPSDEDBIndexField;
import SA.SRFDA.PS.Core.Database.PSDEDBIndexFieldImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSDEDBIndex;
import SA.SRFDA.PS.Data.PSDEDBIndexField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEDBIndexImpl
extends PSDataEntityObjectImpl
implements IPSDEDBIndex {
    private static final Log log = LogFactory.getLog(PSDEDBIndexImpl.class);
    protected PSDEDBIndex psDEDBIndex = null;
    private boolean bAllowReverse = false;
    private ArrayList<IPSDEDBIndexField> psDEDBIndexFieldList = new ArrayList();
    private ArrayList<IPSDEDBIndexField> psDEDBIndexFieldList2 = new ArrayList();
    private ArrayList<IPSDEDBIndexField> psDEDBIndexFieldList3 = new ArrayList();
    private String strCodeName = null;
    private String strIndexType = "NORMAL";
    private boolean bRemoveFlag = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEDBIndex psDEDBIndex) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.psDEDBIndex = psDEDBIndex;
            this.setId(this.psDEDBIndex.getPSDEDBINDEXID());
            this.setName(this.psDEDBIndex.getPSDEDBINDEXNAME());
            this.setPSObjectData(this.psDEDBIndex);
            if (!this.psDEDBIndex.isALLOWREVERSENull()) {
                this.bAllowReverse = this.psDEDBIndex.getALLOWREVERSE();
            }
            this.strCodeName = this.psDEDBIndex.getCODENAME();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = "I" + Helper.GenUniqueId((String)this.psDEDBIndex.getPSDEDBINDEXID()).toUpperCase();
                if (StringHelper.length((String)this.strCodeName) >= 18) {
                    this.strCodeName = this.strCodeName.substring(0, 18);
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEDBIndex.getINDEXTYPE())) {
                this.strIndexType = this.psDEDBIndex.getINDEXTYPE();
            }
            if (!this.psDEDBIndex.isREMOVEFLAGNull()) {
                this.bRemoveFlag = this.psDEDBIndex.getREMOVEFLAG();
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
        this.preparePSDEDBIndexFields();
        super.onInit();
    }

    protected void preparePSDEDBIndexFields() throws Exception {
        this.psDEDBIndexFieldList.clear();
        this.psDEDBIndexFieldList2.clear();
        this.psDEDBIndexFieldList3.clear();
        Vector<PSDEDBIndexField> psDEDBIndexFieldList = new Vector<PSDEDBIndexField>();
        CallResult callResult = this.getPSModelHelper().getPSDEDBIndexFields(this.getId(), psDEDBIndexFieldList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u7d22\u5f15\u5c5e\u6027\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEDBIndexField psDEDBIndexField : psDEDBIndexFieldList) {
            PSDEDBIndexFieldImpl psDEDBIndexFieldImpl = new PSDEDBIndexFieldImpl();
            psDEDBIndexFieldImpl.init(this.getDAGlobalHelper(), this, psDEDBIndexField);
            if (StringHelper.compare((String)this.getPSDataEntity().getTableName(), (String)psDEDBIndexFieldImpl.getPSDEField().getTableName(), (boolean)true) != 0) {
                throw new Exception(StringHelper.format((String)"\u4e91\u5b9e\u4f53[%1$s]\u6570\u636e\u5e93\u7d22\u5f15[%2$s]\u5c5e\u6027[%3$s]\u4e0d\u5c5e\u4e8e\u4e3b\u8868[%4$s]", (Object)this.getPSDataEntity().getName(), (Object)this.getName(), (Object)psDEDBIndexFieldImpl.getPSDEField().getName(), (Object)this.getPSDataEntity().getTableName()));
            }
            if (psDEDBIndexFieldImpl.isIncludeMode()) {
                this.psDEDBIndexFieldList2.add(psDEDBIndexFieldImpl);
            } else {
                this.psDEDBIndexFieldList.add(psDEDBIndexFieldImpl);
            }
            this.psDEDBIndexFieldList3.add(psDEDBIndexFieldImpl);
        }
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u53cd\u5411\u68c0\u7d22", ignoredumpvalues="false")
    public boolean isAllowReverse() {
        return this.bAllowReverse;
    }

    @Override
    public Iterator<IPSDEDBIndexField> getPSDEDBIndexFields(boolean bIncludeMode) {
        if (!bIncludeMode) {
            return this.psDEDBIndexFieldList.iterator();
        }
        return this.psDEDBIndexFieldList2.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u7d22\u5f15\u5c5e\u6027\u5bf9\u8c61\u96c6\u5408", child=true)
    public Iterator<IPSDEDBIndexField> getAllPSDEDBIndexFields() {
        return this.psDEDBIndexFieldList3.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getModelType() {
        return "PSDEDBINDEX";
    }

    @Override
    @PSModelRTMeta(description="\u7d22\u5f15\u7c7b\u578b", codelist="DEDBIndexType")
    public String getIndexType() {
        return this.strIndexType;
    }

    @Override
    public boolean getRemoveFlag() {
        return this.bRemoveFlag;
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }
}

