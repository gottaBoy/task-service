/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRCondition
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRGroupCondition
 *  net.ibizsys.model.valuerule.IPSSysValueRule
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.field.valuerule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.field.PSDEFieldObjectImpl;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRCondition;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRGroupCondition;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRuleRuntime;
import net.ibizsys.model.dataentity.field.valuerule.PSDEFVRGroupConditionImpl;
import net.ibizsys.model.entity.PSDEFValueRule;
import net.ibizsys.model.entity.PSDEFValueRuleCond;
import net.ibizsys.model.valuerule.IPSSysValueRule;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFValueRuleImpl
extends PSDEFieldObjectImpl
implements IPSDEFValueRuleRuntime {
    private static final Log log = LogFactory.getLog(PSDEFValueRuleImpl.class);
    protected PSDEFValueRule psDEFValueRule = null;
    protected IPSDEFVRGroupCondition iPSDEFVRGroupCondition = null;
    private String strCodeName = "";
    private boolean bDefaultMode = true;
    private String strRuleInfo = "";
    private boolean bCheckDefault = false;
    private ArrayList<IPSDEFVRCondition> allPSDEFVRConditionList = new ArrayList();

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEField iPSDEField, PSDEFValueRule psDEFValueRule) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSDEField(iPSDEField);
            this.psDEFValueRule = psDEFValueRule;
            this.setId(this.psDEFValueRule.getPSDEFVALUERULEID());
            this.setName(this.psDEFValueRule.getPSDEFVALUERULENAME());
            this.setPSObjectData(this.psDEFValueRule);
            this.strCodeName = this.psDEFValueRule.getCODENAME();
            this.strRuleInfo = this.psDEFValueRule.getRULEINFO();
            this.bDefaultMode = this.psDEFValueRule.getDEFAULTMODE();
            this.bCheckDefault = this.bDefaultMode ? true : this.psDEFValueRule.getCHECKDEFAULT();
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
        super.onInit();
        this.onPreparePSDEFVRConds();
        if (StringHelper.compare((String)this.strRuleInfo, (String)"\u9ed8\u8ba4\u89c4\u5219", (boolean)true) == 0) {
            this.strRuleInfo = "";
        }
        if (StringHelper.isNullOrEmpty((String)this.strRuleInfo) && this.iPSDEFVRGroupCondition != null) {
            this.strRuleInfo = this.iPSDEFVRGroupCondition.getRuleInfo();
        }
        if (StringHelper.isNullOrEmpty((String)this.strRuleInfo)) {
            this.strRuleInfo = this.getName();
        }
    }

    protected void onPreparePSDEFVRConds() throws Exception {
        this.iPSDEFVRGroupCondition = null;
        this.allPSDEFVRConditionList.clear();
        Vector psDEFValueRuleCondList = new Vector();
        HashMap<String, PSDEFValueRuleCond> psDEFValueRuleCondMap = new HashMap<String, PSDEFValueRuleCond>();
        for (PSDEFValueRuleCond psDEFValueRuleCond : psDEFValueRuleCondList) {
            psDEFValueRuleCondMap.put(psDEFValueRuleCond.getPSDEFVRCONDID(), psDEFValueRuleCond);
        }
        for (PSDEFValueRuleCond psDEFValueRuleCond : psDEFValueRuleCondList) {
            if (StringHelper.isNullOrEmpty((String)psDEFValueRuleCond.getPPSDEFVRCONDID())) continue;
            PSDEFValueRuleCond parentPSDEFValueRuleCond = (PSDEFValueRuleCond)((Object)psDEFValueRuleCondMap.get(psDEFValueRuleCond.getPPSDEFVRCONDID()));
            parentPSDEFValueRuleCond.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
        }
        PSDEFValueRuleCond psDEFValueRuleCondGroup = new PSDEFValueRuleCond();
        psDEFValueRuleCondGroup.setCONDTYPE("GROUP");
        psDEFValueRuleCondGroup.setGROUPOP("AND");
        for (PSDEFValueRuleCond psDEFValueRuleCond : psDEFValueRuleCondList) {
            if (!StringHelper.isNullOrEmpty((String)psDEFValueRuleCond.getPPSDEFVRCONDID())) continue;
            psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
        }
        if (StringHelper.compare((String)this.getCodeName(), (String)"DEFAULT", (boolean)true) == 0) {
            PSDEFValueRuleCond psDEFValueRuleCond;
            if (this.getPSDEField().getStringLength() > 0) {
                psDEFValueRuleCond = new PSDEFValueRuleCond();
                psDEFValueRuleCond.setCONDTYPE("STRINGLENGTH");
                psDEFValueRuleCond.setPARAM4(this.getPSDEField().getStringLength());
                psDEFValueRuleCond.setPARAM6(true);
                psDEFValueRuleCond.setKEYCONDFLAG(true);
                psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
            }
            if (!StringHelper.isNullOrEmpty((String)this.getPSDEField().getPSSysValueRuleId())) {
                PSDEFValueRuleCond psDEFValueRuleCond2;
                IPSSysValueRule iPSSysVaueRule = this.getPSDataEntity().getPSSystem().getPSSysValueRule(this.getPSDEField().getPSSysValueRuleId());
                if (StringHelper.compare((String)iPSSysVaueRule.getRuleType(), (String)"REG", (boolean)true) == 0) {
                    psDEFValueRuleCond2 = new PSDEFValueRuleCond();
                    psDEFValueRuleCond2.setCONDTYPE("REGEX");
                    psDEFValueRuleCond2.setCONDVALUE(iPSSysVaueRule.getRegExCode());
                    psDEFValueRuleCond2.setRULEINFO(iPSSysVaueRule.getRuleInfo());
                    psDEFValueRuleCond2.setKEYCONDFLAG(true);
                    psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond2);
                } else {
                    psDEFValueRuleCond2 = new PSDEFValueRuleCond();
                    psDEFValueRuleCond2.setCONDTYPE("SYSVALUERULE");
                    psDEFValueRuleCond2.setPSSYSVALUERULEID(iPSSysVaueRule.getId());
                    psDEFValueRuleCond2.setRULEINFO(iPSSysVaueRule.getRuleInfo());
                    psDEFValueRuleCond2.setKEYCONDFLAG(true);
                    psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond2);
                }
            }
            if (this.getPSDEField().isCheckRecursion()) {
                psDEFValueRuleCond = new PSDEFValueRuleCond();
                psDEFValueRuleCond.setCONDTYPE("VALUERECURSION");
                psDEFValueRuleCond.setKEYCONDFLAG(true);
                IPSDataEntity inheritPSDataEntity = this.getPSDEField().getPSDataEntity().getInheritPSDataEntity();
                if (inheritPSDataEntity != null) {
                    psDEFValueRuleCond.setMAJORPSDEID(inheritPSDataEntity.getId());
                    psDEFValueRuleCond.setMAJORPSDENAME(inheritPSDataEntity.getName());
                }
                psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
            }
        }
        PSDEFVRGroupConditionImpl psDEFVRGroupConditionImpl = new PSDEFVRGroupConditionImpl();
        psDEFVRGroupConditionImpl.init(this.getPSModelStorageContext(), this, null, psDEFValueRuleCondGroup);
        this.iPSDEFVRGroupCondition = psDEFVRGroupConditionImpl;
    }

    protected void fillAllPSDEFVRCondition(IPSDEFVRCondition iPSDEFVRCondition) throws Exception {
        IPSDEFVRGroupCondition iPSDEFVRGroupCondition;
        Iterator psDEFVRConditions;
        this.allPSDEFVRConditionList.add(iPSDEFVRCondition);
        if (iPSDEFVRCondition instanceof IPSDEFVRGroupCondition && (psDEFVRConditions = (iPSDEFVRGroupCondition = (IPSDEFVRGroupCondition)iPSDEFVRCondition).getPSDEFVRConditions()) != null) {
            while (psDEFVRConditions.hasNext()) {
                this.fillAllPSDEFVRCondition((IPSDEFVRCondition)psDEFVRConditions.next());
            }
        }
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219\u6761\u4ef6")
    public IPSDEFVRGroupCondition getPSDEFVRGroupCondition() {
        return this.iPSDEFVRGroupCondition;
    }

    public String getTypeDetail() {
        return this.psDEFValueRule.getPSDEFVRTYPEDETAILID();
    }

    public String getCodeName() {
        return this.strCodeName;
    }

    @PSModelRTMeta(description="\u9ed8\u8ba4\u89c4\u5219 ")
    public boolean isDefaultMode() {
        return this.bDefaultMode;
    }

    @PSModelRTMeta(description="\u89c4\u5219\u4fe1\u606f")
    public String getRuleInfo() {
        return this.strRuleInfo;
    }

    @PSModelRTMeta(description="\u9ed8\u8ba4\u68c0\u67e5")
    public boolean isCheckDefault() {
        return this.bCheckDefault;
    }

    public Iterator<IPSDEFVRCondition> getAllPSDEFVRConditions() {
        if (this.allPSDEFVRConditionList == null || this.allPSDEFVRConditionList.size() == 0) {
            return null;
        }
        return this.allPSDEFVRConditionList.iterator();
    }
}

