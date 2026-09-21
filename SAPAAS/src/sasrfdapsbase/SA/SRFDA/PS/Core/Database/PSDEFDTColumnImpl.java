/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.IDBFunction
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSInheritDEField;
import SA.SRFDA.PS.Core.DEField.IPSLinkDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQEngine;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCodeExp;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSDEFDTColumn;
import SA.SRFDA.PS.Core.Database.PSDBTypeImpl;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEFDTColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDBFunction;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFDTColumnImpl
extends PSObjectImpl
implements IPSDEFDTColumn {
    private static final Log log = LogFactory.getLog(PSDEFDTColumnImpl.class);
    protected IPSDEField iPSDEField = null;
    protected IPSDEDBConfig iPSDEDBConfig = null;
    private String strQueryCS = "";
    private boolean bFKey = false;
    private boolean bPKey = false;
    private String strFormulaFormat = "";
    private String strFormulaColumns = "";
    private boolean bFormula = false;
    private boolean bAutoIncrement = false;
    private boolean bUnsigned = false;
    private String strInsertValueFunc = "";
    private String strInsertValueFuncField = "";
    private String strUpdateValueFunc = "";
    private String strUpdateValueFuncField = "";
    private boolean bCustomColumnName = false;
    private String strDefaultValue = "";
    private String strNullValueOrderMode = "";
    private String strDBType = "";

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDBConfig iPSDEDBConfig, IPSDEField iPSDEField, PSDEFDTColumn psDEFDTColumn) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setId(psDEFDTColumn.getPSDEFDTColId());
            this.setName(psDEFDTColumn.getPSDEFDTColName());
            this.iPSDEField = iPSDEField;
            this.iPSDEDBConfig = iPSDEDBConfig;
            this.setPSObjectData((IEntity)psDEFDTColumn, false);
            this.strDBType = psDEFDTColumn.getDBType();
            if (!iPSDEField.getPSDEFieldData().isPKEYNull()) {
                this.bPKey = iPSDEField.getPSDEFieldData().getPKEY() == 1;
            }
            this.bFormula = this.iPSDEField.getPSDEFieldData().getDEFTYPE() == 2;
            this.strFormulaFormat = DataObject.getStringValue((Object)psDEFDTColumn.getFormulaFormat(), (String)"");
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strFormulaFormat)) {
                this.strFormulaFormat = iPSDEField.getPSDEFieldData().getFORMULAFORMAT();
            }
            this.strFormulaColumns = DataObject.getStringValue((Object)psDEFDTColumn.getFormulaFields(), (String)"");
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strFormulaColumns)) {
                this.strFormulaColumns = iPSDEField.getPSDEFieldData().getFORMULAFIELDS();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strFormulaColumns)) {
                this.strFormulaColumns = this.strFormulaColumns.replace("|", ";");
            }
            this.bAutoIncrement = iPSDEField.getPSDEFieldType().isAutoIncrement();
            this.bUnsigned = iPSDEField.getPSDEFieldType().isUnsigned();
            this.strInsertValueFunc = DataObject.getStringValue((Object)psDEFDTColumn.getValueFunc2Format(), (String)"");
            this.strInsertValueFuncField = DataObject.getStringValue((Object)psDEFDTColumn.getValueFunc2Fields(), (String)"");
            this.strUpdateValueFunc = DataObject.getStringValue((Object)psDEFDTColumn.getValueFuncFormat(), (String)"");
            this.strUpdateValueFuncField = DataObject.getStringValue((Object)psDEFDTColumn.getValueFuncFields(), (String)"");
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getColumnName(), (String)this.getPSDEField().getName(), (boolean)true) != 0) {
                this.bCustomColumnName = true;
            }
            this.strDefaultValue = DataObject.getStringValue((Object)psDEFDTColumn.getDefaultValue(), (String)"");
            this.strNullValueOrderMode = DataObject.getStringValue((IDataObject)psDEFDTColumn, (String)"NULLVALORDER", (String)"");
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strNullValueOrderMode)) {
                this.strNullValueOrderMode = this.getPSDEField().getNullValueOrderMode();
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strNullValueOrderMode)) {
                this.strNullValueOrderMode = this.getPSDEDBConfig().getPSSystemDBConfig().getNullValueOrderMode();
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
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61", outputdoc="item.getModelType()!='PSDEFIELD'")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u5e93\u914d\u7f6e", outputdoc="item.getModelType()!='PSDEDBCFG'")
    public IPSDEDBConfig getPSDEDBConfig() {
        return this.iPSDEDBConfig;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u7c7b\u578b")
    public String getDBType() {
        return this.onGetDBType();
    }

    protected String onGetDBType() {
        return this.strDBType;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u6570\u636e\u7c7b\u578b", dump=false)
    public String getDBDataType() throws Exception {
        if (this.iPSDEField.isFormulaDEField()) {
            return this.onGetDBDataType();
        }
        if (this.iPSDEField.isLinkDEField()) {
            if (!(this.iPSDEField instanceof IPSLinkDEField)) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[IPSLinkDEField]", (Object)this.iPSDEField.getFullName()));
            }
            IPSLinkDEField linkDEFHelper = (IPSLinkDEField)this.iPSDEField;
            return linkDEFHelper.getRealPSDEField().getPSDTColumn(this.getDBType()).getDBDataType();
        }
        return this.onGetDBDataType();
    }

    @Override
    public String getDBDataType(boolean bAppendNullFlag, boolean bAllowNull, boolean bAppendDefault, String strDefault) throws Exception {
        if (this.iPSDEField.isFormulaDEField()) {
            return this.onGetDBDataType(bAppendNullFlag, bAllowNull, bAppendDefault, strDefault);
        }
        if (this.iPSDEField.isLinkDEField()) {
            if (!(this.iPSDEField instanceof IPSLinkDEField)) {
                log.error((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[IPSLinkDEField]", (Object)this.iPSDEField.getFullName()));
                return "";
            }
            IPSLinkDEField linkDEFHelper = (IPSLinkDEField)this.iPSDEField;
            return linkDEFHelper.getRealPSDEField().getPSDTColumn(this.getDBType()).getDBDataType(bAppendNullFlag, bAllowNull, bAppendDefault, strDefault);
        }
        return this.onGetDBDataType(bAppendNullFlag, bAllowNull, bAppendDefault, strDefault);
    }

    protected String onGetDBDataType(boolean bAppendNullFlag, boolean bAllowNull, boolean bAppendDefault, String strDefault) throws Exception {
        return "";
    }

    protected String onGetDBDataType() throws Exception {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u5217\u540d\u79f0")
    public String getColumnName() {
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPSDEDBConfig().getObjNameCase(), (String)"UCASE", (boolean)true) == 0) {
            return this.getName().toUpperCase();
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPSDEDBConfig().getObjNameCase(), (String)"LCASE", (boolean)true) == 0) {
            return this.getName().toLowerCase();
        }
        return this.getName();
    }

    @Override
    @PSModelRTMeta(description="\u5217\u522b\u540d", dump=false)
    public String getFormalColumnName() {
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPSDEDBConfig().getObjNameCase(), (String)"UCASE", (boolean)true) == 0) {
            return this.iPSDEField.getName().toUpperCase();
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPSDEDBConfig().getObjNameCase(), (String)"LCASE", (boolean)true) == 0) {
            return this.iPSDEField.getName().toLowerCase();
        }
        return this.iPSDEField.getName();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u5217\u540d")
    public String getStandardColumnName() {
        try {
            IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(this.getDBType(), false);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSDEDBConfig().getObjNameCase())) {
                if (this.getPSDEDBConfig().getObjNameCase().equals("LCASE")) {
                    return iPSDBType.getDBObjStandardName(this.getFormalColumnName().toLowerCase());
                }
                if (this.getPSDEDBConfig().getObjNameCase().equals("UCASE")) {
                    return iPSDBType.getDBObjStandardName(this.getFormalColumnName().toUpperCase());
                }
            }
            return iPSDBType.getDBObjStandardName(this.getFormalColumnName());
        }
        catch (Exception ex) {
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSDEDBConfig().getObjNameCase())) {
                if (this.getPSDEDBConfig().getObjNameCase().equals("LCASE")) {
                    return this.getFormalColumnName().toLowerCase();
                }
                if (this.getPSDEDBConfig().getObjNameCase().equals("UCASE")) {
                    return this.getFormalColumnName().toUpperCase();
                }
            }
            return this.getFormalColumnName();
        }
    }

    @Override
    @PSModelRTMeta(description="\u8868\u8303\u56f4", dump=false)
    public String getTableScope() throws Exception {
        if (this.isPhisical()) {
            return this.iPSDEField.getTableName();
        }
        if (this.isFormula() && this.iPSDEField.isFormulaPhisical()) {
            return this.iPSDEField.getTableName();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u9645\u8868\u540d\u79f0", dump=false)
    public String getRealTableName() throws Exception {
        if (this.isPhisical()) {
            return this.getPSDEDBConfig().getTableName();
        }
        if (this.isFormula() && this.iPSDEField.isFormulaPhisical()) {
            return this.getPSDEDBConfig().getTableName();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u5916\u952e", dump=false)
    public boolean isFKey() throws Exception {
        return this.bFKey;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u952e", dump=false)
    public boolean isPKey() throws Exception {
        return this.bPKey;
    }

    @Override
    @PSModelRTMeta(description="\u516c\u5f0f\u5217\u683c\u5f0f", dump=false)
    public String getFormulaFormat() throws Exception {
        return this.strFormulaFormat;
    }

    @Override
    @PSModelRTMeta(description="\u516c\u5f0f\u5217\u53c2\u6570", dump=false)
    public String getFormulaColumns() throws Exception {
        return this.strFormulaColumns;
    }

    @Override
    @PSModelRTMeta(description="\u7269\u7406\u5316\u5217", dump=false)
    public boolean isPhisical() throws Exception {
        if (this.iPSDEField.getPSDEFieldData().getDEFTYPE() == 1) {
            return true;
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.iPSDEField.getDataType(), (String)"PICKUP", (boolean)true) == 0) {
            return true;
        }
        if (this.iPSDEField instanceof IPSLinkDEField) {
            IPSLinkDEField iPSLinkDEField = (IPSLinkDEField)this.iPSDEField;
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.iPSDEField.getDataType(), (String)"INHERIT", (boolean)true) == 0 && (this.iPSDEField.getPSDataEntity().getPSDERInherit() != null && this.iPSDEField.getPSDataEntity().getPSDERInherit().isSameTable() ? iPSLinkDEField.getRelatedPSDEField() != null && iPSLinkDEField.getRelatedPSDEField().isPhisicalDEField() : this.iPSDEField.getPSDataEntity().getVirtualMode() == 5 && iPSLinkDEField.getRelatedPSDEField() != null && iPSLinkDEField.getRelatedPSDEField().isPhisicalDEField())) {
                return true;
            }
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u516c\u5f0f\u5217", dump=false)
    public boolean isFormula() throws Exception {
        return this.bFormula;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u52a8\u4ea7\u751f\u503c", ignoredumpvalues="false")
    public boolean isValueAutoGen() throws Exception {
        return !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getValueGenFunc());
    }

    @Override
    @PSModelRTMeta(description="\u503c\u4ea7\u751f\u51fd\u6570", dump=false)
    public String getValueGenFunc() throws Exception {
        return this.onGetValueGenFunc();
    }

    protected String onGetValueGenFunc() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getInsertValueFunc())) {
            return this.getInsertValueFunc();
        }
        return this.getDefaultValue();
    }

    @Override
    @PSModelRTMeta(description="\u5b57\u6bb5\u957f\u5ea6", dump=false)
    public int getLength() throws Exception {
        if (this.iPSDEField.isInheritDEField()) {
            IPSInheritDEField inheritDEFHelper = (IPSInheritDEField)this.iPSDEField;
            return inheritDEFHelper.getRelatedPSDEField().getPSDTColumn(this.getDBType()).getLength();
        }
        return this.iPSDEField.getLength();
    }

    @Override
    @PSModelRTMeta(description="\u5b57\u6bb5\u7cbe\u5ea6", dump=false)
    public int getPrecision() throws Exception {
        if (this.iPSDEField.isInheritDEField()) {
            IPSInheritDEField inheritDEFHelper = (IPSInheritDEField)this.iPSDEField;
            return inheritDEFHelper.getRelatedPSDEField().getPSDTColumn(this.getDBType()).getPrecision();
        }
        return this.iPSDEField.getPrecision();
    }

    @Override
    public int getScale() throws Exception {
        if (this.iPSDEField.isInheritDEField()) {
            IPSInheritDEField inheritDEFHelper = (IPSInheritDEField)this.iPSDEField;
            return inheritDEFHelper.getRelatedPSDEField().getPSDTColumn(this.getDBType()).getScale();
        }
        return this.iPSDEField.getLength();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c", dump=false)
    public String getDefaultValue() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strDefaultValue)) {
            return this.strDefaultValue;
        }
        return this.iPSDEField.getDefaultValue();
    }

    @Override
    public boolean isInsertProcParam() throws Exception {
        if (this.iPSDEField.isFormulaDEField()) {
            return this.isPKey() || this.isFKey();
        }
        return !this.iPSDEField.isSystemReserver();
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u503c\u8f93\u5165", dump=false)
    public boolean isNullable() throws Exception {
        return this.iPSDEField.getPSDEFieldData().getALLOWEMPTY();
    }

    @Override
    public boolean isUpdateProcParam() throws Exception {
        if (this.iPSDEField.isFormulaDEField()) {
            return this.isPKey() || this.isFKey();
        }
        return !this.iPSDEField.isSystemReserver();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u63d2\u5165", dump=false)
    public boolean isEnableInsert() throws Exception {
        if (!this.iPSDEField.isPhisicalDEField()) {
            if (this.iPSDEField.isInheritDEField()) {
                IPSInheritDEField inheritDEFHelper = (IPSInheritDEField)this.iPSDEField;
                if (inheritDEFHelper.getRealPSDEField().isIndexTypeDEField()) {
                    return false;
                }
                return inheritDEFHelper.getRelatedPSDEField().getPSDTColumn(this.getDBType()).isEnableInsert();
            }
            return false;
        }
        if (this.iPSDEField.isSystemReserver()) {
            return false;
        }
        return this.iPSDEField.isEnableCreate();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u66f4\u65b0", dump=false)
    public boolean isEnableUpdate() throws Exception {
        if (!this.iPSDEField.isPhisicalDEField()) {
            if (this.iPSDEField.isInheritDEField()) {
                IPSInheritDEField inheritDEFHelper = (IPSInheritDEField)this.iPSDEField;
                if (inheritDEFHelper.getRealPSDEField().isIndexTypeDEField()) {
                    return false;
                }
                return inheritDEFHelper.getRelatedPSDEField().getPSDTColumn(this.getDBType()).isEnableInsert();
            }
            return false;
        }
        if (this.iPSDEField.isSystemReserver()) {
            return false;
        }
        if (this.isPKey()) {
            return false;
        }
        return this.iPSDEField.isEnableModify();
    }

    @Override
    public String getQueryCaseSenstive() {
        return this.strQueryCS;
    }

    @Override
    public String getStatisticsNullConvert() {
        return null;
    }

    @Override
    public String getConditionSQL(IPSDEDQEngine iPSDEDQEngine, String strFieldName, String strCondition, String strCondValue, String strValType, String strParamArg) throws Exception {
        return this.getConditionSQL(iPSDEDQEngine, strFieldName, null, strCondition, strCondValue, strValType, strParamArg);
    }

    @Override
    public String getConditionSQL(IPSDEDQEngine iPSDEDQEngine, String strFieldName, IDBFunction iDBFunction, String strCondition, String strCondValue, String strValType, String strParamArg) throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strValType)) {
            strValType = strValType.toLowerCase();
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strParamArg)) {
            strParamArg = "";
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"TESTNULL", (boolean)true) == 0) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondValue, (String)"1", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s IS NULL", (Object)strFieldName);
            }
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s IS NOT NULL", (Object)strFieldName);
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"ISNULL", (boolean)true) == 0) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s IS NULL", (Object)strFieldName);
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"ISNOTNULL", (boolean)true) == 0) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s IS NOT NULL", (Object)strFieldName);
        }
        int nDataType = 0;
        if (iDBFunction == null) {
            nDataType = this.iPSDEField.getStdDataType();
        } else {
            nDataType = iDBFunction.getOutputDataType();
            strFieldName = iDBFunction.getFuncSQL(false, new String[]{strFieldName});
        }
        if (this.isStringType(nDataType)) {
            return this.getStringConditionSQL(strFieldName, nDataType, strCondition, strCondValue, strValType, strParamArg);
        }
        if (this.isIntType(nDataType)) {
            return this.getIntConditionSQL(strFieldName, nDataType, strCondition, strCondValue, strValType, strParamArg);
        }
        if (this.isDoubleType(nDataType)) {
            return this.getDoubleConditionSQL(strFieldName, nDataType, strCondition, strCondValue, strValType, strParamArg);
        }
        if (this.isDateTimeType(nDataType)) {
            return this.getDateTimeConditionSQL(strFieldName, nDataType, strCondition, strCondValue, strValType, strParamArg);
        }
        if (this.isBooleanType(nDataType)) {
            return this.getBooleanConditionSQL(strFieldName, nDataType, strCondition, strCondValue, strValType, strParamArg);
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strValType)) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u4e0d\u652f\u6301\u6761\u4ef6\uff1a%1$s [%2$s] (%3$s)", (Object)strFieldName, (Object)strCondition, (Object)strCondValue));
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u4e0d\u652f\u6301\u6761\u4ef6\uff1a%1$s [%2$s] %3$s(%4$s)", (Object)strFieldName, (Object)strCondition, (Object)strValType, (Object)strCondValue));
    }

    protected String getStringConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) throws Exception {
        return this.getStringConditionSQL(strFieldName, nDataType, strCondition, strValue, "", "");
    }

    protected String getStringConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName, String strParamArg) throws Exception {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strParamName)) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"EQ", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"ABSEQ", (boolean)true) == 0) {
                strValue = strValue.replace("'", "''");
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s = '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"NOTEQ", (boolean)true) == 0) {
                strValue = strValue.replace("'", "''");
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s <> '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"GT", (boolean)true) == 0) {
                strValue = strValue.replace("'", "''");
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s > '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"GTANDEQ", (boolean)true) == 0) {
                strValue = strValue.replace("'", "''");
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s >= '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"LT", (boolean)true) == 0) {
                strValue = strValue.replace("'", "''");
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s < '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"LTANDEQ", (boolean)true) == 0) {
                strValue = strValue.replace("'", "''");
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s <= '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"LIKE", (boolean)true) == 0) {
                strValue = strValue.replace("'", "''");
                strValue = "%" + strValue + "%";
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s LIKE '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"LEFTLIKE", (boolean)true) == 0) {
                strValue = strValue.replace("'", "''");
                strValue = String.valueOf(strValue) + "%";
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s LIKE '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"RIGHTLIKE", (boolean)true) == 0) {
                strValue = strValue.replace("'", "''");
                strValue = "%" + strValue;
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s LIKE '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"NOTIN", (boolean)true) == 0) {
                strValue = strValue.replace(",", ";");
                String[] items = SA.SRFramework.Utility.StringHelper.SplitEx((String)(strValue = strValue.replace("'", "''")));
                if (items.length == 0) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u53c2\u6570");
                }
                StringBuilderEx sb = new StringBuilderEx();
                sb.Append(strFieldName);
                if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"NOTIN", (boolean)true) == 0) {
                    sb.Append(" NOT ");
                }
                sb.Append(" IN (");
                int i = 0;
                while (i < items.length) {
                    if (i != 0) {
                        sb.Append(",");
                    }
                    sb.Append("'%1$s'", (Object)items[i]);
                    ++i;
                }
                sb.Append(")");
                return sb.toString();
            }
        } else {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"EQ", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"ABSEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s =  ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"NOTEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s <>  ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"GT", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s >  ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"GTANDEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s >=  ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"LT", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s <  ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"LTANDEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s <=  ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"LIKE", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s LIKE  '%%'|| ${srf%2$s('%3$s','%4$s')} ||'%%'", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"LEFTLIKE", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s LIKE  ${srf%2$s('%3$s','%4$s')} ||'%%'", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"RIGHTLIKE", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s LIKE  '%%'|| ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s IN (${srf%2$s('%3$s','%4$s')})", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"NOTIN", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s NOT IN (${srf%2$s('%3$s','%4$s')})", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strParamName)) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u4e0d\u652f\u6301\u6761\u4ef6\uff1a%1$s [%2$s] (%3$s)", (Object)strFieldName, (Object)strCondition, (Object)strValue));
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u4e0d\u652f\u6301\u6761\u4ef6\uff1a%1$s [%2$s] %3$s(%4$s)", (Object)strFieldName, (Object)strCondition, (Object)strParamName, (Object)strValue));
    }

    protected String getIntConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) throws Exception {
        return this.getIntConditionSQL(strFieldName, nDataType, strCondition, strValue, "", "");
    }

    protected String getIntConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName, String strParamArg) throws Exception {
        Object objValue = null;
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strParamName) && SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) != 0 && SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"NOTIN", (boolean)true) != 0 && (objValue = DataTypeHelper.testBigInt((String)strValue)) == null) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u503c[%1$s]\u975e\u6574\u6570\u503c", (Object)strValue));
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strParamName)) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"EQ", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"ABSEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s = %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"NOTEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s <> %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"GT", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s > %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"GTANDEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s >= %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"LT", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s < %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"LTANDEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s <= %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"NOTIN", (boolean)true) == 0) {
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strValue)) {
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0) {
                        return "1<>1";
                    }
                    return "1=1";
                }
                strValue = strValue.replace(",", ";");
                String[] items = SA.SRFramework.Utility.StringHelper.SplitEx((String)strValue);
                String strSQL = "";
                strSQL = SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0 ? SA.SRFramework.Utility.StringHelper.Format((String)"%1$s IN (", (Object)strFieldName) : SA.SRFramework.Utility.StringHelper.Format((String)"%1$s NOT IN (", (Object)strFieldName);
                int i = 0;
                while (i < items.length) {
                    Object objItem = DataTypeHelper.testBigInt((String)items[i]);
                    if (objItem == null) {
                        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u503c[%1$s]\u975e\u6574\u6570\u503c", (Object)items[i]));
                    }
                    if (i != 0) {
                        strSQL = String.valueOf(strSQL) + ",";
                    }
                    strSQL = String.valueOf(strSQL) + SA.SRFramework.Utility.StringHelper.Format((String)"%1$s", (Object)items[i]);
                    ++i;
                }
                strSQL = String.valueOf(strSQL) + ")";
                return strSQL;
            }
        } else {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"EQ", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"ABSEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s = ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"NOTEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s <> ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"GT", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s > ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"GTANDEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s >=${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"LT", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s < ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"LTANDEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s <= ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s IN (${srf%2$s('%3$s','%4$s')})", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"NOTIN", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s NOT IN (${srf%2$s('%3$s','%4$s')})", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strParamName)) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u4e0d\u652f\u6301\u6761\u4ef6\uff1a%1$s [%2$s] (%3$s)", (Object)strFieldName, (Object)strCondition, (Object)strValue));
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u4e0d\u652f\u6301\u6761\u4ef6\uff1a%1$s [%2$s] %3$s(%4$s)", (Object)strFieldName, (Object)strCondition, (Object)strParamName, (Object)strValue));
    }

    protected String getDoubleConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) throws Exception {
        return this.getDoubleConditionSQL(strFieldName, nDataType, strCondition, strValue, "", "");
    }

    protected String getDoubleConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName, String strParamArg) throws Exception {
        Object objValue = null;
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strParamName) && SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) != 0 && SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"NOTIN", (boolean)true) != 0 && (objValue = DataTypeHelper.testDouble((String)strValue)) == null) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u503c[%1$s]\u975e\u6d6e\u70b9\u503c", (Object)strValue));
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strParamName)) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"EQ", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"ABSEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s = %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"NOTEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s <> %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"GT", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s > %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"GTANDEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s >= %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"LT", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s < %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"LTANDEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s <= %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"NOTIN", (boolean)true) == 0) {
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strValue)) {
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0) {
                        return "1<>1";
                    }
                    return "1=1";
                }
                strValue = strValue.replace(",", ";");
                String[] items = SA.SRFramework.Utility.StringHelper.SplitEx((String)strValue);
                String strSQL = "";
                strSQL = SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0 ? SA.SRFramework.Utility.StringHelper.Format((String)"%1$s IN (", (Object)strFieldName) : SA.SRFramework.Utility.StringHelper.Format((String)"%1$s NOT IN (", (Object)strFieldName);
                int i = 0;
                while (i < items.length) {
                    Object objItem = DataTypeHelper.testDouble((String)items[i]);
                    if (objItem == null) {
                        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u503c[%1$s]\u975e\u6d6e\u70b9\u503c", (Object)items[i]));
                    }
                    if (i != 0) {
                        strSQL = String.valueOf(strSQL) + ",";
                    }
                    strSQL = String.valueOf(strSQL) + SA.SRFramework.Utility.StringHelper.Format((String)"%1$s", (Object)items[i]);
                    ++i;
                }
                strSQL = String.valueOf(strSQL) + ")";
                return strSQL;
            }
        } else {
            CallParam callParam = new CallParam();
            callParam.setParamName(strParamName);
            callParam.setValue(objValue);
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"EQ", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"ABSEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s = ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"NOTEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s <> ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"GT", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s > ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"GTANDEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s >=${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"LT", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s < ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"LTANDEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s <= ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s IN (${srf%2$s('%3$s','%4$s')})", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"NOTIN", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s NOT IN (${srf%2$s('%3$s','%4$s')})", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strParamName)) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u4e0d\u652f\u6301\u6761\u4ef6\uff1a%1$s [%2$s] (%3$s)", (Object)strFieldName, (Object)strCondition, (Object)strValue));
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u4e0d\u652f\u6301\u6761\u4ef6\uff1a%1$s [%2$s] %3$s(%4$s)", (Object)strFieldName, (Object)strCondition, (Object)strParamName, (Object)strValue));
    }

    protected String getDateTimeConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) throws Exception {
        return this.getDateTimeConditionSQL(strFieldName, nDataType, strCondition, strValue, "", "");
    }

    protected String getDateTimeConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName, String strParamArg) throws Exception {
        Object objValue = null;
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strParamName) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strValue)) {
            objValue = DataTypeHelper.testDateTime((String)strValue);
            if (objValue == null) {
                log.error((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u503c[%1$s]\u975e\u65e5\u671f\u65f6\u95f4\u6027", (Object)strValue));
                return "";
            }
            Timestamp ts = (Timestamp)objValue;
            strValue = SA.SRFramework.Utility.StringHelper.Format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)ts);
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"LT", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"LTANDEQ", (boolean)true) == 0) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date(ts.getTime()));
                if (calendar.get(11) == 0 && calendar.get(12) == 0 && calendar.get(13) == 0) {
                    strValue = SA.SRFramework.Utility.StringHelper.Format((String)"%1$tY-%1$tm-%1$td 23:59:59", (Object)ts);
                    objValue = DataTypeHelper.testDateTime((String)strValue);
                }
            }
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strParamName)) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"EQ", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"ABSEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s = '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"NOTEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s <> '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"GT", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s > '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"GTANDEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s >= '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"LT", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s < '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"LTANDEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s <= '%2$s'", (Object)strFieldName, (Object)strValue);
            }
        } else {
            CallParam callParam = new CallParam();
            callParam.setParamName(strParamName);
            callParam.setValue(objValue);
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"EQ", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"ABSEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s = ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"NOTEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s <> ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"GT", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s > ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"GTANDEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s >= ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"LT", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s < ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"LTANDEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s <= ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strParamName)) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u4e0d\u652f\u6301\u6761\u4ef6\uff1a%1$s [%2$s] (%3$s)", (Object)strFieldName, (Object)strCondition, (Object)strValue));
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u4e0d\u652f\u6301\u6761\u4ef6\uff1a%1$s [%2$s] %3$s(%4$s)", (Object)strFieldName, (Object)strCondition, (Object)strParamName, (Object)strValue));
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEField.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u589e\u5217", ignoredumpvalues="false")
    public boolean isAutoIncrement() {
        return this.bAutoIncrement;
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u7b26\u53f7\u5217", dump=false)
    public boolean isUnsigned() {
        return this.bUnsigned;
    }

    @Override
    public String getModelType() {
        return "PSDEFDTCOL";
    }

    @Override
    @PSModelRTMeta(description="\u503c\u63d2\u5165\u51fd\u6570", hideempty2=true, dump=false)
    public String getInsertValueFunc() {
        return this.strInsertValueFunc;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u63d2\u5165\u51fd\u6570\u5c5e\u6027", hideempty2=true, dump=false)
    public String getInsertValueFuncField() {
        return this.strInsertValueFuncField;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u66f4\u65b0\u51fd\u6570", hideempty2=true, dump=false)
    public String getUpdateValueFunc() {
        return this.strUpdateValueFunc;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u66f4\u65b0\u51fd\u6570\u5c5e\u6027", hideempty2=true, dump=false)
    public String getUpdateValueFuncField() {
        return this.strUpdateValueFuncField;
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEDBConfig().getModelId(), (Object)this.getName());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEDBConfig().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEField().getPSDataEntity().getPSSystem());
    }

    protected IPSSystemRuntime getPSSystemRuntime() {
        return (IPSSystemRuntime)((Object)this.getPSDEField().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getModelName() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s|%2$s", (Object)super.getModelName(), (Object)this.getDBType());
    }

    @Override
    public boolean isCustomColumnName() {
        return this.bCustomColumnName;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7a7a\u503c\u6392\u5e8f\u6a21\u5f0f", codelist="DBNullValueOrderMode", dump=false)
    public String getNullValueOrderMode() {
        return this.strNullValueOrderMode;
    }

    protected String getBooleanConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) throws Exception {
        return this.getBooleanConditionSQL(strFieldName, nDataType, strCondition, strValue, "", "");
    }

    protected String getBooleanConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName, String strParamArg) throws Exception {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strParamName)) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"EQ", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"ABSEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s = %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"NOTEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s <> %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"NOTIN", (boolean)true) == 0) {
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strValue)) {
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0) {
                        return "1<>1";
                    }
                    return "1=1";
                }
                strValue = strValue.replace(",", ";");
                String[] items = SA.SRFramework.Utility.StringHelper.SplitEx((String)strValue);
                String strSQL = "";
                strSQL = SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0 ? SA.SRFramework.Utility.StringHelper.Format((String)"%1$s IN (", (Object)strFieldName) : SA.SRFramework.Utility.StringHelper.Format((String)"%1$s NOT IN (", (Object)strFieldName);
                int i = 0;
                while (i < items.length) {
                    Object objItem = DataTypeHelper.testBigInt((String)items[i]);
                    if (objItem == null) {
                        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u503c[%1$s]\u975e\u6574\u6570\u503c", (Object)items[i]));
                    }
                    if (i != 0) {
                        strSQL = String.valueOf(strSQL) + ",";
                    }
                    strSQL = String.valueOf(strSQL) + SA.SRFramework.Utility.StringHelper.Format((String)"%1$s", (Object)items[i]);
                    ++i;
                }
                strSQL = String.valueOf(strSQL) + ")";
                return strSQL;
            }
        } else {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"EQ", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"ABSEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s = ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"NOTEQ", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s <> ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s IN (${srf%2$s('%3$s','%4$s')})", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCondition, (String)"NOTIN", (boolean)true) == 0) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s NOT IN (${srf%2$s('%3$s','%4$s')})", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strParamName)) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u4e0d\u652f\u6301\u6761\u4ef6\uff1a%1$s [%2$s] (%3$s)", (Object)strFieldName, (Object)strCondition, (Object)strValue));
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u4e0d\u652f\u6301\u6761\u4ef6\uff1a%1$s [%2$s] %3$s(%4$s)", (Object)strFieldName, (Object)strCondition, (Object)strParamName, (Object)strValue));
    }

    protected boolean isBooleanType(int dataType) {
        return dataType == 3;
    }

    protected boolean isStringType(int dataType) {
        return DataTypeHelper.isStringType((int)dataType);
    }

    protected boolean isIntType(int dataType) {
        return DataTypeHelper.isIntType((int)dataType);
    }

    protected boolean isDoubleType(int dataType) {
        return DataTypeHelper.isDoubleType((int)dataType) || DataTypeHelper.isBigDecimalType((int)dataType);
    }

    protected boolean isDateTimeType(int dataType) {
        return DataTypeHelper.isDateTimeType((int)dataType);
    }

    @Override
    public boolean isFormulaPhisical() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u67e5\u8be2\u4ee3\u7801\u8868\u8fbe\u5f0f", outputdoc="false")
    public IPSDEDataQueryCodeExp getPSDEDataQueryCodeExp() throws Exception {
        if (this.getPSSystemRuntime().getDynaInstMode() != 0) {
            return null;
        }
        IPSDEDataQuery iPSDEDataQuery = this.getPSDEField().getPSDataEntity().getDefaultPSDEDataQuery();
        if (iPSDEDataQuery == null) {
            return null;
        }
        IPSDEDataQueryCode iPSDEDataQueryCode = iPSDEDataQuery.getPSDEDataQueryCode(this.getDBType(), true);
        if (iPSDEDataQueryCode == null) {
            return null;
        }
        return iPSDEDataQueryCode.getPSDEDataQueryCodeExp(this.getPSDEField().getName(), true);
    }

    @Override
    @PSModelRTMeta(description="\u67e5\u8be2\u4ee3\u7801\u8868\u8fbe\u5f0f", outputdoc="false")
    public String getQueryCodeExp() throws Exception {
        IPSDEDataQueryCodeExp iPSDEDataQueryCodeExp = this.getPSDEDataQueryCodeExp();
        if (iPSDEDataQueryCodeExp != null) {
            return iPSDEDataQueryCodeExp.getExpression();
        }
        return null;
    }

    @Override
    public int getJDBCType() throws Exception {
        return PSDBTypeImpl.getJDBCType(this.iPSDEField.getStdDataType());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        if (this.getPSDEDBConfig() != null) {
            return this.getPSDEDBConfig();
        }
        return super.onGetParentModel();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        if (this.getPSDEDBConfig() != null) {
            return this.getPSDEDBConfig();
        }
        return super.onGetParentModel();
    }
}

