/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Testing;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.Testing.IPSSysTestData;
import SA.SRFDA.PS.Core.Testing.IPSSysTestDataInst;
import SA.SRFDA.PS.Core.Testing.IPSSysTestDataItem;
import SA.SRFDA.PS.Core.Testing.PSSysTestDataInstImpl;
import SA.SRFDA.PS.Core.Testing.PSSysTestDataItemImpl;
import SA.SRFDA.PS.Data.PSSysTestData;
import SA.SRFDA.PS.Data.PSSysTestDataItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysTestDataImpl
extends PSSystemObjectImpl
implements IPSSysTestData {
    private static final Log log = LogFactory.getLog(PSSysTestDataImpl.class);
    protected PSSysTestData psSysTestData = null;
    private ArrayList<IPSSysTestDataItem> psSysTestDataItemList = new ArrayList();
    private ArrayList<IPSSysTestDataInst> psSysTestDataInstList = null;
    private IPSDataEntity iPSDataEntity = null;
    private boolean bBaseMode = false;
    private int nInstCount = 1;
    private String strCodeName = "";
    private IPSSystemModule iPSSystemModule = null;
    private String strTestDataType = "DATA";

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysTestData psSysTestData) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysTestData = psSysTestData;
            this.setId(this.psSysTestData.getPSSYSTESTDATAID());
            this.setName(this.psSysTestData.getPSSYSTESTDATANAME());
            this.setPSObjectData(this.psSysTestData);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysTestData.getPSDEID())) {
                this.iPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psSysTestData.getPSDEID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysTestData.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysTestData.getPSMODULEID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysTestData.getTESTDATATYPE())) {
                this.strTestDataType = this.psSysTestData.getTESTDATATYPE();
            }
            this.strCodeName = this.psSysTestData.getCODENAME();
            if (!this.psSysTestData.isBASEMODENull()) {
                this.bBaseMode = this.psSysTestData.getBASEMODE();
            }
            if (this.psSysTestData.getRANDOMCOUNT() > 0) {
                this.nInstCount = this.psSysTestData.getRANDOMCOUNT();
            }
            if (this.nInstCount > 20) {
                this.nInstCount = 20;
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
        this.onPreparePSSysTestDataItems();
        super.onInit();
    }

    protected void onPreparePSSysTestDataItems() throws Exception {
        this.psSysTestDataItemList.clear();
        Vector<PSSysTestDataItem> psSysTestDataItemList = new Vector<PSSysTestDataItem>();
        CallResult callResult = this.getPSModelHelper().getPSSysTestDataItems(this.getId(), psSysTestDataItemList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6d4b\u8bd5\u6570\u636e\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysTestDataItem psSysTestDataItem : psSysTestDataItemList) {
            PSSysTestDataItemImpl iPSSysTestDataItem = new PSSysTestDataItemImpl();
            iPSSysTestDataItem.init(this.getDAGlobalHelper(), this, psSysTestDataItem);
            this.psSysTestDataItemList.add(iPSSysTestDataItem);
        }
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u6570\u636e\u9879\u96c6\u5408", child=true)
    public Iterator<IPSSysTestDataItem> getPSSysTestDataItems() {
        if (this.psSysTestDataItemList.size() == 0) {
            return null;
        }
        return this.psSysTestDataItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u5b9e\u4f53", dumpref=true)
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    public Iterator<IPSSysTestDataInst> getPSSysTestDataInsts() throws Exception {
        this.onPreparePSSysTestDataInsts();
        return this.psSysTestDataInstList.iterator();
    }

    @Override
    public IPSSysTestDataInst getPSSysTestDataInst(int nIndex) throws Exception {
        this.onPreparePSSysTestDataInsts();
        return this.psSysTestDataInstList.get(nIndex);
    }

    protected synchronized void onPreparePSSysTestDataInsts() throws Exception {
        if (this.psSysTestDataInstList != null) {
            return;
        }
        this.psSysTestDataInstList = new ArrayList();
        int i = 0;
        while (i < this.nInstCount) {
            PSSysTestDataInstImpl psSysTestDataInstImpl = new PSSysTestDataInstImpl();
            psSysTestDataInstImpl.setEntity((IEntity)new SimpleEntity());
            psSysTestDataInstImpl.setIndex(i);
            for (IPSSysTestDataItem iPSSysTestDataItem : this.psSysTestDataItemList) {
                iPSSysTestDataItem.fillEntity(psSysTestDataInstImpl);
            }
            this.psSysTestDataInstList.add(psSysTestDataInstImpl);
            ++i;
        }
    }

    @Override
    @PSModelRTMeta(description="\u57fa\u672c\u6a21\u5f0f")
    public boolean isBaseMode() {
        return this.bBaseMode;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f8b\u6570\u91cf")
    public int getInstCount() {
        return this.nInstCount;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getModelType() {
        return "PSSYSTESTDATA";
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u6570\u636e", fields={"DATA"})
    public String getData() {
        return this.psSysTestData.getDATA();
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", fields={"CUSTOMCODE"})
    public String getScriptCode() {
        return this.psSysTestData.getCUSTOMCODE();
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u6570\u636e\u7c7b\u578b", codelist="TestDataType", group="\u57fa\u672c", order=125)
    public String getTestDataType() {
        return this.strTestDataType;
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
    @PSModelRTMeta(description="\u5907\u6ce8", hideempty2=true, dynamodelmode=4)
    public String getMemo() {
        return super.getMemo();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSDataEntity() != null) {
            return String.format("%1$s/%2$s", this.getPSDataEntity().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return super.onGetRTMOSFolder();
    }

    @Override
    protected String onGetDynaModelFolder() {
        if (this.getPSDataEntity() != null) {
            return String.format("%1$s/%2$s/%3$s", this.getPSDataEntity().getDynaModelFolder(), Inflector.getInstance().pluralize((Object)this.getDumpModelType()).toUpperCase(), this.getDynaModelTag());
        }
        return super.onGetDynaModelFolder();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        if (this.getPSDataEntity() != null) {
            return this.getPSDataEntity();
        }
        return super.onGetParentModel();
    }
}

