/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSAppLan;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageItem;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Data.PSAppLan;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppLanImpl
extends PSApplicationObjectImpl
implements IPSAppLan {
    private static final Log log = LogFactory.getLog(PSAppLanImpl.class);
    protected PSAppLan psAppLan = null;
    private List<IPSLanguageItem> psLanguageItemList = null;
    private int nOrderValue = 99999;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppLan psAppLan) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.psAppLan = psAppLan;
            this.setId(this.psAppLan.getPSAPPLANID());
            if (!StringHelper.isNullOrEmpty((String)this.psAppLan.getPSLANGUAGENAME())) {
                this.setName(this.psAppLan.getPSLANGUAGENAME());
            } else {
                this.setName(this.psAppLan.getPSAPPLANNAME());
            }
            this.setPSObjectData(this.psAppLan);
            if (!this.psAppLan.isORDERVALUENull()) {
                this.nOrderValue = this.psAppLan.getORDERVALUE();
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
    public String getModelType() {
        return "PSAPPLAN";
    }

    @Override
    @PSModelRTMeta(description="\u8bed\u8a00", fields={"PSLANGUAGEID"})
    public String getLanguage() {
        return this.psAppLan.getPSLANGUAGEID();
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSApplication().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    @PSModelRTMeta(description="\u8bed\u8a00\u8d44\u6e90\u9879\u96c6\u5408", child=true)
    public Iterator<IPSLanguageItem> getAllPSLanguageItems() {
        if (this.psLanguageItemList == null) {
            ArrayList<IPSLanguageItem> list = new ArrayList<IPSLanguageItem>();
            Iterator<IPSLanguageRes> psLanguageReses = this.getPSApplication().getAllPSLanguageReses();
            if (psLanguageReses != null) {
                HashMap<String, IPSLanguageRes> psLanguageResMap = new HashMap<String, IPSLanguageRes>();
                while (psLanguageReses.hasNext()) {
                    IPSLanguageRes iPSLanguageRes = psLanguageReses.next();
                    psLanguageResMap.put(iPSLanguageRes.getId(), iPSLanguageRes);
                }
                try {
                    Iterator<IPSLanguageItem> psLanguageItems = this.getPSSystem().getAllPSLanguageItems();
                    if (psLanguageItems != null) {
                        while (psLanguageItems.hasNext()) {
                            IPSLanguageItem iPSLanguageItem = psLanguageItems.next();
                            if (StringHelper.isNullOrEmpty((String)iPSLanguageItem.getContent()) || !this.getLanguage().equals(iPSLanguageItem.getLanguage()) || iPSLanguageItem.getPSLanguageRes() == null || !psLanguageResMap.containsKey(iPSLanguageItem.getPSLanguageRes().getId())) continue;
                            list.add(iPSLanguageItem);
                        }
                    }
                }
                catch (Exception e) {
                    log.error((Object)e);
                }
            }
            this.psLanguageItemList = list;
        }
        return this.psLanguageItemList.iterator();
    }

    @Override
    protected String onGetDynaModelTag() {
        return this.getLanguage();
    }

    @Override
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
        super.onFillModelRefNode(objectNode, strModelRefType);
        objectNode.put("name", this.getName());
        objectNode.put("language", this.getLanguage());
    }
}

