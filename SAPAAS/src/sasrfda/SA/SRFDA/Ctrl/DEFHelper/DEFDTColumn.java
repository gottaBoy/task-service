/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.DataEx.ConditionHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFDA.Ctrl.DEFHelper.DEFDTColumnConfig;
import SA.SRFDA.Ctrl.DEFHelper.IDEFDTColumn;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IInheritDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Model.IDAValueFunc;
import SA.SRFDA.Model.SearchItemConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.ConditionHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DEFDTColumn
implements IDEFDTColumn {
    protected IDEFHelper iDEFHelper = null;
    protected DEFDTColumnConfig defDTColumnConfig = null;
    protected ISRFDAGlobalHelper globalHelperEx = null;
    private static final Log log = LogFactory.getLog(DEFDTColumn.class);
    private String strQueryCS = "";
    private boolean bFKey = false;
    private boolean bPKey = false;

    @Override
    public CallResult Init(IDEFHelper iDEFHelper, DEFDTColumnConfig defDTColumnConfig, ISRFDAGlobalHelper globalHelperEx) {
        this.iDEFHelper = iDEFHelper;
        this.defDTColumnConfig = defDTColumnConfig;
        this.globalHelperEx = globalHelperEx;
        this.bFKey = iDEFHelper.getDEField().isFKEY();
        this.bPKey = iDEFHelper.getDEField().isPKEY();
        this.strQueryCS = this.iDEFHelper.getDEField().getQUERYCS();
        return new CallResult();
    }

    @Override
    public String GetDBDataType() {
        if (this.iDEFHelper.IsFormulaDEField()) {
            return this.OnGetDBDataType();
        }
        if (this.iDEFHelper.IsLinkDEField()) {
            if (!(this.iDEFHelper instanceof ILinkDEFHelper)) {
                log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[ILinkDEFHelper]", (Object)this.iDEFHelper.GetFullName()));
                return "";
            }
            ILinkDEFHelper linkDEFHelper = (ILinkDEFHelper)this.iDEFHelper;
            return linkDEFHelper.GetRealDEFHelper().GetDTColumn().GetDBDataType();
        }
        return this.OnGetDBDataType();
    }

    @Override
    public String GetDBDataType(boolean bAppendNullFlag, boolean bAllowNull, boolean bAppendDefault, String strDefault) {
        if (this.iDEFHelper.IsFormulaDEField()) {
            return this.OnGetDBDataType(bAppendNullFlag, bAllowNull, bAppendDefault, strDefault);
        }
        if (this.iDEFHelper.IsLinkDEField()) {
            if (!(this.iDEFHelper instanceof ILinkDEFHelper)) {
                log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[ILinkDEFHelper]", (Object)this.iDEFHelper.GetFullName()));
                return "";
            }
            ILinkDEFHelper linkDEFHelper = (ILinkDEFHelper)this.iDEFHelper;
            return linkDEFHelper.GetRealDEFHelper().GetDTColumn().GetDBDataType(bAppendNullFlag, bAllowNull, bAppendDefault, strDefault);
        }
        return this.OnGetDBDataType(bAppendNullFlag, bAllowNull, bAppendDefault, strDefault);
    }

    protected String OnGetDBDataType(boolean bAppendNullFlag, boolean bAllowNull, boolean bAppendDefault, String strDefault) {
        return "";
    }

    protected String OnGetDBDataType() {
        return "";
    }

    @Override
    public int GetJDBCType() {
        return -1;
    }

    @Override
    public String GetColumnName() {
        return this.iDEFHelper.getName();
    }

    @Override
    public String GetFormalColumnName() {
        return this.GetColumnName();
    }

    @Override
    public String GetTableName() {
        if (this.IsPhisical()) {
            return this.iDEFHelper.getDEField().getTABLENAME();
        }
        if (this.IsFormula() && this.iDEFHelper.IsFormulaPhisical()) {
            return this.iDEFHelper.getDEField().getTABLENAME();
        }
        return "";
    }

    @Override
    public boolean IsFKey() {
        return this.bFKey;
    }

    @Override
    public boolean IsPKey() {
        return this.bPKey;
    }

    @Override
    public String GetFormulaFormat() {
        String strPropertyName = StringHelper.Format((String)"%1$s.%2$s", (Object)this.globalHelperEx.getDAModelDB(), (Object)"FORMULAFORMAT");
        String strPropertyValue = this.iDEFHelper.GetProperty(strPropertyName, "");
        if (StringHelper.IsNullOrEmpty((String)strPropertyValue)) {
            strPropertyName = StringHelper.Format((String)"%2$s.%1$s", (Object)this.globalHelperEx.getDAModelDB(), (Object)"FORMULAFORMAT");
        }
        return this.iDEFHelper.GetProperty(strPropertyName, this.iDEFHelper.getDEField().getFORMULAFORMAT());
    }

    @Override
    public String GetFormulaColumns() {
        String strValue = this.OnGetFormulaColumns();
        if (!StringHelper.IsNullOrEmpty((String)strValue)) {
            strValue = strValue.replace("|", ";");
        }
        return strValue;
    }

    protected String OnGetFormulaColumns() {
        String strPropertyName = StringHelper.Format((String)"%1$s.%2$s", (Object)this.globalHelperEx.getDAModelDB(), (Object)"FORMULAFIELD");
        String strPropertyValue = this.iDEFHelper.GetProperty(strPropertyName, "");
        if (StringHelper.IsNullOrEmpty((String)strPropertyValue)) {
            strPropertyName = StringHelper.Format((String)"%2$s.%1$s", (Object)this.globalHelperEx.getDAModelDB(), (Object)"FORMULAFIELD");
        }
        return this.iDEFHelper.GetProperty(strPropertyName, this.iDEFHelper.getDEField().getFORMULAFIELD());
    }

    @Override
    public boolean IsPhisical() {
        if (this.iDEFHelper.getDEField().getDEFTYPE() == 1) {
            return true;
        }
        return StringHelper.Compare((String)this.iDEFHelper.GetDataType(), (String)"PICKUP", (boolean)true) == 0;
    }

    @Override
    public boolean IsFormula() {
        return this.iDEFHelper.getDEField().getDEFTYPE() == 2;
    }

    @Override
    public boolean IsSupportSearchAction(SearchItemConfig searchItemConfig) {
        String strSearchFunc = searchItemConfig.getFunc();
        String strDataType = "";
        if (!StringHelper.IsNullOrEmpty((String)strSearchFunc)) {
            IDAValueFunc iDAValueFunc = this.globalHelperEx.getDAConfigMgr().getValueFuncMgr().FindFunc(strSearchFunc);
            if (iDAValueFunc == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6SearchFunc[%1$s]\u5bf9\u5e94\u7684\u5bf9\u8c61", (Object)strSearchFunc));
                return false;
            }
            strDataType = iDAValueFunc.GetDataType();
        } else {
            strDataType = this.iDEFHelper.GetStdDataType();
        }
        return ConditionHelper.IsSupportDataType((String)strDataType, (String)searchItemConfig.getAction());
    }

    @Override
    public boolean IsValueAutoGen() {
        return !StringHelper.IsNullOrEmpty((String)this.GetValueGenFunc());
    }

    @Override
    public String GetValueGenFunc() {
        return this.OnGetValueGenFunc();
    }

    protected String OnGetValueGenFunc() {
        String strValueGenFunc = this.iDEFHelper.getDEField().getDATATYPEPARAM3();
        if (!StringHelper.IsNullOrEmpty((String)strValueGenFunc)) {
            return strValueGenFunc;
        }
        strValueGenFunc = this.GetDefaultValue();
        if (!StringHelper.IsNullOrEmpty((String)strValueGenFunc)) {
            return strValueGenFunc;
        }
        strValueGenFunc = this.defDTColumnConfig.getValueGenFunc(this.iDEFHelper.getDEHelper().GetDBType());
        return strValueGenFunc;
    }

    @Override
    public int GetLength() {
        if (this.iDEFHelper.IsInheritDEField()) {
            IInheritDEFHelper inheritDEFHelper = (IInheritDEFHelper)this.iDEFHelper;
            return inheritDEFHelper.GetRelatedDEFHelper().GetDTColumn().GetLength();
        }
        return this.iDEFHelper.getDEField().getLENGTH();
    }

    @Override
    public int GetPrecision() {
        return 0;
    }

    @Override
    public int GetScale() {
        return 0;
    }

    public String GetDefaultValue() {
        String strPropertyName = StringHelper.Format((String)"%1$s.%2$s", (Object)this.globalHelperEx.getDAModelDB(), (Object)"DEFAULTVALUE");
        String strPropertyValue = this.iDEFHelper.GetProperty(strPropertyName, "");
        if (StringHelper.IsNullOrEmpty((String)strPropertyValue)) {
            strPropertyName = StringHelper.Format((String)"%2$s.%1$s", (Object)this.globalHelperEx.getDAModelDB(), (Object)"DEFAULTVALUE");
        }
        return this.iDEFHelper.GetProperty(strPropertyName, this.iDEFHelper.getDEField().getDEFAULTVALUE());
    }

    @Override
    public boolean IsInsertProcParam() {
        if (this.iDEFHelper.IsFormulaDEField()) {
            return this.IsPKey() || this.IsFKey();
        }
        if (this.iDEFHelper.IsSystemReserver()) {
            return false;
        }
        return !this.iDEFHelper.isUIAssistField();
    }

    @Override
    public boolean IsNullable() {
        return this.iDEFHelper.getDEField().isNULLABLE();
    }

    @Override
    public boolean IsUpdateProcParam() {
        if (this.iDEFHelper.IsFormulaDEField()) {
            return this.IsPKey() || this.IsFKey();
        }
        if (this.iDEFHelper.IsSystemReserver()) {
            return false;
        }
        return !this.iDEFHelper.isUIAssistField();
    }

    @Override
    public boolean IsEnableInsert() {
        if (!this.iDEFHelper.IsPhisicalDEField()) {
            if (this.iDEFHelper.IsInheritDEField()) {
                IInheritDEFHelper inheritDEFHelper = (IInheritDEFHelper)this.iDEFHelper;
                if (inheritDEFHelper.GetRealDEFHelper().IsIndexTypeDEField()) {
                    return false;
                }
                return inheritDEFHelper.GetRelatedDEFHelper().GetDTColumn().IsEnableInsert();
            }
            return false;
        }
        if (this.iDEFHelper.IsSystemReserver()) {
            return false;
        }
        return !this.iDEFHelper.isUIAssistField();
    }

    @Override
    public boolean IsEnableUpdate() {
        if (!this.iDEFHelper.IsPhisicalDEField()) {
            if (this.iDEFHelper.IsInheritDEField()) {
                IInheritDEFHelper inheritDEFHelper = (IInheritDEFHelper)this.iDEFHelper;
                if (inheritDEFHelper.GetRealDEFHelper().IsIndexTypeDEField()) {
                    return false;
                }
                return inheritDEFHelper.GetRelatedDEFHelper().GetDTColumn().IsEnableInsert();
            }
            return false;
        }
        if (this.iDEFHelper.IsSystemReserver()) {
            return false;
        }
        if (this.iDEFHelper.isUIAssistField()) {
            return false;
        }
        return !this.IsPKey();
    }

    @Override
    public String GetInsertMode() {
        return this.iDEFHelper.getDEField().getINSERTMODE();
    }

    @Override
    public String GetUpdateMode() {
        return this.iDEFHelper.getDEField().getUPDATEMODE();
    }

    @Override
    public String GetStatisticsNullConvert() {
        return this.iDEFHelper.getDEField().getSTATNULLCONV();
    }

    @Override
    public String GetQueryCaseSenstive() {
        return this.strQueryCS;
    }

    @Override
    public boolean isViewColumn() {
        return !this.iDEFHelper.isUIAssistField();
    }
}

