/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel.util;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.SystemValueRuleModelBase;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;

public class NumberRangeValueRuleModel
extends SystemValueRuleModelBase {
    public static final String PARAM_MINVALUE = "MINVALUE";
    public static final String PARAM_MAXVALUE = "MAXVALUE";
    public static final String PARAM_INCMINVALUE = "INCMINVALUE";
    public static final String PARAM_INCMAXVALUE = "INCMAXVALUE";
    private Double fMinValue = null;
    private Double fMaxValue = null;
    private boolean bIncMaxValue = true;
    private boolean bIncMinValue = true;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!StringHelper.isNullOrEmpty(PropertiesHelper.getProperty(this.getRuleParams(), PARAM_MINVALUE))) {
            this.fMinValue = PropertiesHelper.getProperty(this.getRuleParams(), PARAM_MINVALUE, -1.0);
        }
        if (!StringHelper.isNullOrEmpty(PropertiesHelper.getProperty(this.getRuleParams(), PARAM_MAXVALUE))) {
            this.fMaxValue = PropertiesHelper.getProperty(this.getRuleParams(), PARAM_MAXVALUE, -1.0);
        }
        if (!StringHelper.isNullOrEmpty(PropertiesHelper.getProperty(this.getRuleParams(), PARAM_INCMINVALUE))) {
            this.bIncMinValue = PropertiesHelper.getProperty(this.getRuleParams(), PARAM_INCMINVALUE, true);
        }
        if (!StringHelper.isNullOrEmpty(PropertiesHelper.getProperty(this.getRuleParams(), PARAM_INCMAXVALUE))) {
            this.bIncMaxValue = PropertiesHelper.getProperty(this.getRuleParams(), PARAM_INCMAXVALUE, true);
        }
    }

    @Override
    public boolean check(IEntity et, String strFieldName, boolean bTempMode, Object objParam, String strRuleInfo, boolean bTryMode) throws Exception {
        Object objValue;
        if (StringHelper.isNullOrEmpty(strRuleInfo)) {
            strRuleInfo = this.getLocalization("CTRL.SERVICE.CHECKFIELDVALUERANGERULE_INFO", "\u6570\u503c\u5fc5\u987b\u7b26\u5408\u503c\u8303\u56f4\u89c4\u5219");
        }
        if ((objValue = et.get(strFieldName)) == null) {
            return true;
        }
        double fSrcValue = 0.0;
        if (objValue instanceof Double) {
            fSrcValue = (Double)objValue;
        } else {
            String strValue = objValue.toString();
            if (StringHelper.isNullOrEmpty(strValue)) {
                return true;
            }
            fSrcValue = Double.parseDouble(objValue.toString());
        }
        if (this.fMinValue != null) {
            if (this.bIncMinValue) {
                if (fSrcValue < this.fMinValue) {
                    if (bTryMode) {
                        return false;
                    }
                    throw new Exception(strRuleInfo);
                }
            } else if (fSrcValue <= this.fMinValue) {
                if (bTryMode) {
                    return false;
                }
                throw new Exception(strRuleInfo);
            }
        }
        if (this.fMaxValue != null) {
            if (this.bIncMaxValue) {
                if (fSrcValue > this.fMaxValue) {
                    if (bTryMode) {
                        return false;
                    }
                    throw new Exception(strRuleInfo);
                }
            } else if (fSrcValue >= this.fMaxValue) {
                if (bTryMode) {
                    return false;
                }
                throw new Exception(strRuleInfo);
            }
        }
        return true;
    }
}

