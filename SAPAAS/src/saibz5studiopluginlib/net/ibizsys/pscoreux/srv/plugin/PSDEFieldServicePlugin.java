/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.PluginActionResult
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServicePluginBase
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEField
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscoreux.srv.plugin;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServicePluginBase;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import org.hibernate.SessionFactory;

public class PSDEFieldServicePlugin
extends ServicePluginBase {
    public PluginActionResult doCheckEntity(IService iService, int nActionPos, IEntity et, boolean bCreate, boolean bTempMode, EntityError entityError, Object objParam) throws Exception {
        if (nActionPos == 40) {
            EntityFieldError entityFieldError = null;
            entityFieldError = this.onCheckField_FormulaFields(iService, (PSDEField)et, bCreate, bTempMode);
            if (entityFieldError != null) {
                entityError.register(entityFieldError);
            }
            if ((entityFieldError = this.onCheckField_Length(iService, (PSDEField)et, bCreate, bTempMode)) != null) {
                entityError.register(entityFieldError);
            }
            if ((entityFieldError = this.onCheckField_FloatAccuracy(iService, (PSDEField)et, bCreate, bTempMode)) != null) {
                entityError.register(entityFieldError);
            }
            if ((entityFieldError = this.onCheckField_FormulaFormat(iService, (PSDEField)et, bCreate, bTempMode)) != null) {
                entityError.register(entityFieldError);
            }
            return PluginActionResult.Continue;
        }
        return super.doCheckEntity(iService, nActionPos, et, bCreate, bTempMode, entityError, objParam);
    }

    private EntityFieldError onCheckField_FormulaFormat(IService iService, PSDEField et, boolean bCreate, boolean bTempMode) {
        String strRuleInfo = "";
        String strFormulaFormat = et.getFormulaFormat();
        if (!StringHelper.isNullOrEmpty((String)strFormulaFormat)) {
            int number = -1;
            int nMaxNum = this.getStringFormatMaxIndex(strFormulaFormat);
            int nFormularFieldCount = 0;
            if (!StringHelper.isNullOrEmpty((String)et.getFormulaFields())) {
                String strFormulaFields = et.getFormulaFields().toUpperCase();
                Pattern pattern = Pattern.compile("[;|]+");
                String[] formulaFields = pattern.split(strFormulaFields);
                nFormularFieldCount = formulaFields.length;
            }
            System.out.println("onCheckField_FormulaFormat ------" + nMaxNum + "------" + nFormularFieldCount);
            if (nFormularFieldCount < nMaxNum) {
                strRuleInfo = "\u903b\u8f91\u5b57\u6bb5\u683c\u5f0f\u4e0e\u903b\u8f91\u5c5e\u6027\u53c2\u6570\u4e2a\u6570\u4e0d\u5339\u914d";
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMULAFIELDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    private EntityFieldError onCheckField_FloatAccuracy(IService iService, PSDEField et, boolean bCreate, boolean bTempMode) throws Exception {
        String strRuleInfo = "";
        if (StringHelper.compare((String)et.getPSDataTypeId(), (String)"DECIMAL", (boolean)true) == 0) {
            int nLength = 0;
            int nPrecision = 0;
            if (et.getLength() != null) {
                nLength = et.getLength();
            }
            if (et.getPrecision2() == null) {
                return null;
            }
            nPrecision = et.getPrecision2();
            if (nPrecision > nLength) {
                strRuleInfo = "\u6d6e\u70b9\u7cbe\u5ea6\u8303\u56f4\u4e0d\u80fd\u5927\u4e8e\u957f\u5ea6\uff01";
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRECISION2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
            if (nPrecision < 1 || nPrecision > 30) {
                strRuleInfo = "\u6d6e\u70b9\u7cbe\u5ea6\u8303\u56f4\u4e0d\u80fd\u5c0f\u4e8e1\u6216\u8005\u5927\u4e8e30";
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRECISION2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    private EntityFieldError onCheckField_FormulaFields(IService iService, PSDEField et, boolean bCreate, boolean bTempMode) throws Exception {
        PSDEFieldService psdeFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)iService.getSessionFactory());
        String strRuleInfo = null;
        if (!StringHelper.isNullOrEmpty((String)et.getFormulaFields())) {
            String value = et.getFormulaFields().toUpperCase();
            Pattern pattern = Pattern.compile("^[ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_|;]*$");
            Matcher matcher = pattern.matcher(value);
            if (!matcher.find()) {
                strRuleInfo = "\u903b\u8f91\u5c5e\u6027\u53c2\u6570\u53ea\u5141\u8bb8\u4f7f\u7528;\u6216|\u5206\u9694\u3002";
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMULAFIELDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
            ArrayList psdeFieldList = psdeFieldService.selectByDataEntity(et.getPSDEId());
            ArrayList<String> strList = new ArrayList<String>();
            for (PSDEField psdeField : psdeFieldList) {
                strList.add(psdeField.getPSDEFieldName());
            }
            Pattern pattern3 = Pattern.compile("[;|]+");
            String[] strGroup = pattern3.split(value);
            StringBuilderEx strError = new StringBuilderEx();
            String[] stringArray = strGroup;
            int n = strGroup.length;
            int n2 = 0;
            while (n2 < n) {
                String string = stringArray[n2];
                if (!strList.contains(string)) {
                    strError.append(String.valueOf(string) + ";");
                }
                ++n2;
            }
            if (!StringHelper.isNullOrEmpty((String)strError.toString())) {
                strRuleInfo = "\u903b\u8f91\u5c5e\u6027\u53c2\u6570\u6240\u8bbe\u7f6e\u5c5e\u6027\u5fc5\u987b\u5728\u5f53\u524d\u5b9e\u4f53\u4e0b.(" + strError.toString() + ")\u672a\u5728\u5f53\u524d\u5b9e\u4f53\u4e0b\u3002";
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMULAFIELDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    private EntityFieldError onCheckField_Length(IService iService, PSDEField et, boolean bCreate, boolean bTempMode) throws Exception {
        String strRuleInfo = null;
        if (!StringHelper.isNullOrEmpty((Object)et.getLength())) {
            int length = et.getLength();
            String number = String.valueOf(length);
            if (number.indexOf(".") != -1) {
                strRuleInfo = "\u8f93\u5165\u503c\u6570\u636e\u7c7b\u578b\u4e0d\u6b63\u786e";
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMULAFIELDS");
                entityFieldError.setErrorType(2);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
            if (!(StringHelper.compare((String)et.getPSDataTypeId(), (String)"LONGTEXT_1000", (boolean)true) != 0 && StringHelper.compare((String)et.getPSDataTypeId(), (String)"TEXT", (boolean)true) != 0 || length >= 1 && length <= 4000)) {
                strRuleInfo = "\u6587\u672c\uff0c\u53ef\u6307\u5b9a\u957f\u5ea6\u7c7b\u578b,\u8f93\u5165\u503c\u957f\u5ea6\u5e94\u57281\u81f34000\u4e4b\u95f4";
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LENGTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
            if (StringHelper.compare((String)et.getPSDataTypeId(), (String)"FLOAT", (boolean)true) == 0 && (length < 1 || length > 38)) {
                strRuleInfo = "\u6d6e\u70b9\u7c7b\u578b,\u8f93\u5165\u503c\u957f\u5ea6\u5e94\u57281\u81f338\u4e4b\u95f4";
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LENGTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
            if (StringHelper.compare((String)et.getPSDataTypeId(), (String)"DECIMAL", (boolean)true) == 0 && (length < 1 || length > 65)) {
                strRuleInfo = "\u6570\u503c\u7c7b\u578b,\u8f93\u5165\u503c\u8f93\u5165\u503c\u957f\u5ea6\u5e94\u57281\u81f365\u4e4b\u95f4";
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LENGTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected int getStringFormatMaxIndex(String strValue) {
        int nMaxNum = 0;
        Pattern pattern = Pattern.compile("%([0-9]+?)\\$");
        Matcher matcher = pattern.matcher(strValue);
        while (matcher.find()) {
            int nTemp;
            if (matcher.groupCount() <= 0 || (nTemp = Integer.parseInt(matcher.group(1))) <= nMaxNum) continue;
            nMaxNum = nTemp;
        }
        return nMaxNum;
    }
}

