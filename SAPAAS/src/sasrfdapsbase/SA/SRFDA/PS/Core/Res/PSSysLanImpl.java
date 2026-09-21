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
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageItem;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysLan;
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

public class PSSysLanImpl
extends PSSystemObjectImpl
implements IPSSysLan {
    protected PSAppLan psAppLan = null;
    private static final Log log = LogFactory.getLog(PSSysLanImpl.class);
    private List<IPSLanguageItem> psLanguageItemList = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSAppLan psAppLan) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psAppLan = psAppLan;
            this.setId(this.psAppLan.getPSLANGUAGEID());
            this.setName(this.psAppLan.getPSLANGUAGENAME());
            this.setPSObjectData(this.psAppLan);
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
        return "PSSYSLAN";
    }

    @Override
    @PSModelRTMeta(description="\u8bed\u8a00")
    public String getLanguage() {
        return this.psAppLan.getPSLANGUAGEID();
    }

    @Override
    @PSModelRTMeta(description="\u8bed\u8a00\u8d44\u6e90\u9879\u96c6\u5408", child=true)
    public Iterator<IPSLanguageItem> getAllPSLanguageItems() {
        if (this.psLanguageItemList == null) {
            ArrayList<IPSLanguageItem> list = new ArrayList<IPSLanguageItem>();
            try {
                Iterator<IPSLanguageRes> psLanguageReses = this.getPSSystem().getAllPSLanguageReses();
                if (psLanguageReses != null) {
                    HashMap<String, IPSLanguageRes> psLanguageResMap = new HashMap<String, IPSLanguageRes>();
                    while (psLanguageReses.hasNext()) {
                        IPSLanguageRes iPSLanguageRes = psLanguageReses.next();
                        psLanguageResMap.put(iPSLanguageRes.getId(), iPSLanguageRes);
                    }
                    Iterator<IPSLanguageItem> psLanguageItems = this.getPSSystem().getAllPSLanguageItems();
                    if (psLanguageItems != null) {
                        while (psLanguageItems.hasNext()) {
                            IPSLanguageItem iPSLanguageItem = psLanguageItems.next();
                            if (StringHelper.isNullOrEmpty((String)iPSLanguageItem.getContent()) || !this.getLanguage().equals(iPSLanguageItem.getLanguage()) || iPSLanguageItem.getPSLanguageRes() == null || !psLanguageResMap.containsKey(iPSLanguageItem.getPSLanguageRes().getId())) continue;
                            list.add(iPSLanguageItem);
                        }
                    }
                }
            }
            catch (Exception e) {
                log.error((Object)e);
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
    protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
        super.onFillModelRefNode(objectNode, strModelRefType);
        objectNode.put("name", this.getName());
        objectNode.put("language", this.getLanguage());
    }
}

