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
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.EAI.IPSEAIDataTypeItem;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDataType;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDataTypeItem;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIScheme;
import SA.SRFDA.PS.Core.EAI.PSSysEAIDataTypeItemImpl;
import SA.SRFDA.PS.Core.EAI.PSSysEAISchemeObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysEAIDataType;
import SA.SRFDA.PS.Data.PSSysEAIDataTypeItem;
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

public class PSSysEAIDataTypeImpl
extends PSSysEAISchemeObjectImpl
implements IPSSysEAIDataType {
    private static final Log log = LogFactory.getLog(PSSysEAIDataTypeImpl.class);
    protected PSSysEAIDataType psSysEAIDataType = null;
    private ArrayList<IPSSysEAIDataTypeItem> psSysEAIDataTypeItemList = new ArrayList();
    private Map<String, IPSSysEAIDataTypeItem> psSysEAIDataTypeItemMap = new LinkedHashMap<String, IPSSysEAIDataTypeItem>();
    private boolean bEnableEnum = false;
    private int nMaxStringLength = -1;
    private int nMinStringLength = -1;
    private int nPrecision = 0;
    private String strMinValue = null;
    private String strMaxValue = null;
    private boolean bIncludeMinValue = false;
    private boolean bIncludeMaxValue = false;
    private String strPattern = null;
    private int nStdDataType = 25;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysEAIScheme iPSSysEAIScheme, PSSysEAIDataType psSysEAIDataType) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysEAIScheme(iPSSysEAIScheme);
            this.psSysEAIDataType = psSysEAIDataType;
            this.setId(this.psSysEAIDataType.getPSSYSEAIDATATYPEID());
            this.setName(this.psSysEAIDataType.getPSSYSEAIDATATYPENAME());
            this.setPSObjectData(this.psSysEAIDataType);
            if (!this.psSysEAIDataType.isENABLEENUMNull()) {
                this.bEnableEnum = this.psSysEAIDataType.getENABLEENUM();
            }
            if (!this.psSysEAIDataType.isMAXSTRLENGTHNull()) {
                this.nMaxStringLength = this.psSysEAIDataType.getMAXSTRLENGTH();
            }
            if (!this.psSysEAIDataType.isMINSTRLENGTHNull()) {
                this.nMinStringLength = this.psSysEAIDataType.getMINSTRLENGTH();
            }
            if (!this.psSysEAIDataType.isPRECISION2Null()) {
                this.nPrecision = this.psSysEAIDataType.getPRECISION2();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysEAIDataType.getMINVALUE())) {
                this.strMinValue = this.psSysEAIDataType.getMINVALUE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysEAIDataType.getMAXVALUE())) {
                this.strMaxValue = this.psSysEAIDataType.getMAXVALUE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysEAIDataType.getREGEXPCODE())) {
                this.strPattern = this.psSysEAIDataType.getREGEXPCODE();
            }
            if (!this.psSysEAIDataType.isINCMINVALUENull()) {
                this.bIncludeMinValue = this.psSysEAIDataType.getINCMINVALUE();
            }
            if (!this.psSysEAIDataType.isINCMAXVALUENull()) {
                this.bIncludeMaxValue = this.psSysEAIDataType.getINCMAXVALUE();
            }
            if (!this.psSysEAIDataType.isSTDDATATYPENull()) {
                this.nStdDataType = this.psSysEAIDataType.getSTDDATATYPE();
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
        if (this.isEnableEnum()) {
            this.onPreparePSSysEAIDataTypeItems();
        }
        super.onInit();
    }

    protected void onPreparePSSysEAIDataTypeItems() throws Exception {
        this.psSysEAIDataTypeItemList.clear();
        Vector<PSSysEAIDataTypeItem> psSysEAIDataTypeItemList = new Vector<PSSysEAIDataTypeItem>();
        CallResult callResult = this.getPSModelHelper().getPSSysEAIDataTypeItems(this.getId(), psSysEAIDataTypeItemList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u96c6\u6210\u6570\u636e\u7c7b\u578b\u9879\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysEAIDataTypeItem psSysEAIDataTypeItem : psSysEAIDataTypeItemList) {
            PSSysEAIDataTypeItemImpl iPSSysEAIDataTypeItem = new PSSysEAIDataTypeItemImpl();
            iPSSysEAIDataTypeItem.init(this.getDAGlobalHelper(), this, psSysEAIDataTypeItem);
            this.psSysEAIDataTypeItemList.add(iPSSysEAIDataTypeItem);
            this.psSysEAIDataTypeItemMap.put(iPSSysEAIDataTypeItem.getId(), iPSSysEAIDataTypeItem);
            this.psSysEAIDataTypeItemMap.put(iPSSysEAIDataTypeItem.getName(), iPSSysEAIDataTypeItem);
        }
    }

    @Override
    public String getModelType() {
        return "PSSYSEAIDATATYPE";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysEAIDataType.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7cbe\u5ea6", ignoredumpvalues="0")
    public int getPrecision() {
        return this.nPrecision;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u5b57\u7b26\u4e32\u957f\u5ea6")
    public int getMinStringLength() {
        return this.nMinStringLength;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u5b57\u7b26\u4e32\u957f\u5ea6")
    public int getMaxStringLength() {
        return this.nMaxStringLength;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u503c\uff08\u5b57\u7b26\u4e32\uff09")
    public String getMinValueString() {
        return this.strMinValue;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u503c\uff08\u5b57\u7b26\u4e32\uff09")
    public String getMaxValueString() {
        return this.strMaxValue;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7c7b\u578b\u6807\u8bb0")
    public String getDataTypeTag() {
        return this.psSysEAIDataType.getEAIDATATYPETAG();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7c7b\u578b\u6807\u8bb02")
    public String getDataTypeTag2() {
        return this.psSysEAIDataType.getEAIDATATYPETAG2();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u6a21\u5f0f")
    public String getPattern() {
        return this.strPattern;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u679a\u4e3e\u503c")
    public boolean isEnableEnum() {
        return this.bEnableEnum;
    }

    @Override
    @PSModelRTMeta(description="\u5305\u542b\u6700\u5c0f\u503c", ignoredumpvalues="false")
    public boolean isIncludeMinValue() {
        return this.bIncludeMinValue;
    }

    @Override
    @PSModelRTMeta(description="\u5305\u542b\u6700\u5927\u503c", ignoredumpvalues="false")
    public boolean isIncludeMaxValue() {
        return this.bIncludeMaxValue;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType")
    public int getStdDataType() {
        return this.nStdDataType;
    }

    @Override
    @PSModelRTMeta(description="\u96c6\u6210\u6570\u636e\u7c7b\u578b\u9879\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysEAIDataTypeItem> getAllPSSysEAIDataTypeItems() throws Exception {
        if (this.psSysEAIDataTypeItemList == null || this.psSysEAIDataTypeItemList.size() == 0) {
            return null;
        }
        return this.psSysEAIDataTypeItemList.iterator();
    }

    @Override
    public IPSSysEAIDataTypeItem getPSSysEAIDataTypeItem(String strPSSysEAIDataTypeItemId) throws Exception {
        return this.getPSSysEAIDataTypeItem(strPSSysEAIDataTypeItemId, false);
    }

    @Override
    public IPSEAIDataTypeItem getPSEAIDataTypeItem(String strPSEAIDataTypeItemId, boolean bTryMode) throws Exception {
        return this.getPSSysEAIDataTypeItem(strPSEAIDataTypeItemId, bTryMode);
    }

    @Override
    public IPSSysEAIDataTypeItem getPSSysEAIDataTypeItem(String strPSSysEAIDataTypeItemId, boolean bTryMode) throws Exception {
        IPSSysEAIDataTypeItem iPSSysEAIDataTypeItem = null;
        if (this.psSysEAIDataTypeItemMap != null) {
            iPSSysEAIDataTypeItem = this.psSysEAIDataTypeItemMap.get(strPSSysEAIDataTypeItemId);
        }
        if (iPSSysEAIDataTypeItem != null || bTryMode) {
            return iPSSysEAIDataTypeItem;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u96c6\u6210\u6570\u636e\u7c7b\u578b\u9879[%1$s]", (Object)strPSSysEAIDataTypeItemId));
    }

    @Override
    public Iterator<? extends IPSEAIDataTypeItem> getAllPSEAIDataTypeItems() throws Exception {
        return this.getAllPSSysEAIDataTypeItems();
    }

    @Override
    public IPSEAIDataTypeItem getPSEAIDataTypeItem(String strPSEAIDataTypeItemId) throws Exception {
        return this.getPSSysEAIDataTypeItem(strPSEAIDataTypeItemId);
    }
}

