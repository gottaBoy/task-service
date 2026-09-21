/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.control.counter.IPSCounter
 *  net.ibizsys.model.control.counter.IPSCounterType
 *  net.ibizsys.model.control.counter.IPSSysCounterItem
 *  net.ibizsys.model.sys.IPSSystemModule
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.counter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSSystemObjectImpl;
import net.ibizsys.model.control.counter.IPSCounter;
import net.ibizsys.model.control.counter.IPSCounterType;
import net.ibizsys.model.control.counter.IPSSysCounterItem;
import net.ibizsys.model.control.counter.IPSSysCounterRuntime;
import net.ibizsys.model.control.counter.PSSysCounterItemImpl;
import net.ibizsys.model.entity.PSSysCounter;
import net.ibizsys.model.entity.PSSysCounterItem;
import net.ibizsys.model.sys.IPSSystemModule;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysCounterImpl
extends PSSystemObjectImpl
implements IPSSysCounterRuntime {
    private static final Log log = LogFactory.getLog(PSSysCounterImpl.class);
    protected PSSysCounter psSysCounter = null;
    private String strCodeName = "";
    private IPSCounterType iPSCounterType = null;
    private Properties classOrPkgNameMap = null;
    private IPSSystemModule iPSSystemModule = null;
    private boolean bSubSysCounter = false;
    private ArrayList<IPSSysCounterItem> psSysCounterItemList = new ArrayList();
    private int nTimer = 60000;
    private String strPSCounterId = null;
    private IPSCounter iPSCounter = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystem iPSSystem, PSSysCounter psSysCounter) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSSystem(iPSSystem);
            this.psSysCounter = psSysCounter;
            this.setId(this.psSysCounter.getPSSYSCOUNTERID());
            this.setName(this.psSysCounter.getPSSYSCOUNTERNAME());
            this.setPSObjectData(this.psSysCounter);
            this.iPSCounterType = this.getPSModelStorageContext().getPSCounterType(psSysCounter.getCOUNTERTYPE());
            this.strCodeName = this.psSysCounter.getCODENAME();
            this.classOrPkgNameMap = PropertiesHelper.load((String)this.psSysCounter.getBASECLSPARAMS());
            if (!this.psSysCounter.isRELOADTIMERNull()) {
                this.nTimer = this.psSysCounter.getRELOADTIMER();
            }
            if (this.nTimer < 5000) {
                this.nTimer = 60000;
            }
            this.strPSCounterId = this.psSysCounter.getPSCOUNTERID();
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.strPSCounterId)) {
            this.iPSCounter = this.getPSModelStorageContext().getPSCounter(this.strPSCounterId);
        }
        super.onInit();
    }

    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u7c7b\u578b", codelist="CounterType")
    public String getCounterType() {
        return this.iPSCounterType.getId();
    }

    public IPSCounterType getPSCounterType() {
        return this.iPSCounterType;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.strCodeName;
    }

    @PSModelRTMeta(description="\u8ba1\u6570\u5237\u65b0\u95f4\u9694\uff08\u6beb\u79d2\uff09")
    public int getTimer() {
        return this.nTimer;
    }

    public boolean getRefFlag() {
        return true;
    }

    public boolean isSubSysCounter() {
        return this.bSubSysCounter;
    }

    protected IPSSysCounterItem registerPSSysCounterItem(PSSysCounterItem psSysCounterItem) throws Exception {
        PSSysCounterItemImpl iPSSysCounterItem = new PSSysCounterItemImpl();
        iPSSysCounterItem.init(this.getPSModelStorageContext(), this, psSysCounterItem);
        this.psSysCounterItemList.add(iPSSysCounterItem);
        return iPSSysCounterItem;
    }

    protected void resetPSSysCounterItems() {
        this.psSysCounterItemList.clear();
    }

    public Iterator<IPSSysCounterItem> getPSSysCounterItems() {
        if (this.psSysCounterItemList == null || this.psSysCounterItemList.size() == 0) {
            return null;
        }
        return this.psSysCounterItemList.iterator();
    }

    public IPSCounter getPSCounter() {
        return this.iPSCounter;
    }
}

