/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEField
 */
package net.ibizsys.model.dataentity.field;

import java.util.Iterator;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.field.IPSDEFSearchMode;
import net.ibizsys.model.dataentity.field.IPSDEFUIMode;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.paas.core.IDEField;

public interface IPSDEField
extends IPSModelObject,
IDEField {
    public IPSDataEntity getPSDataEntity();

    public String getLogicName();

    public String getLNLanResTag();

    public IPSLanguageRes getLNPSLanguageRes();

    public boolean isLinkDEField();

    public boolean isInheritDEField();

    public boolean isFormulaDEField();

    public boolean isPhisicalDEField();

    public boolean isIndexTypeDEField();

    public boolean isFormTypeDEField();

    public boolean isPasteReset();

    public boolean isSystemReserver();

    public boolean isEnableAudit();

    public String getAuditInfoFormat();

    public int getPrecision();

    public boolean isEnablePriv();

    public String getStringCase();

    public String getUpdateOVMode();

    public String getCodeName();

    public boolean isEnableUserInsert();

    public boolean isEnableUserUpdate();

    public String getFullName();

    public IPSDEFUIMode getPSDEFUIMode(String var1) throws Exception;

    public IPSDEFSearchMode getPSDEFSearchMode(String var1) throws Exception;

    public Iterator<IPSDEFSearchMode> getAllPSDEFSearchModes() throws Exception;

    public boolean isAllowEmpty();

    public IPSDEFValueRule getPSDEFValueRule(String var1) throws Exception;

    public Iterator<IPSDEFValueRule> getAllPSDEFValueRules() throws Exception;

    public String getValueFormat();

    public int getEnableUserInput();

    public IPSCodeList getPSCodeList() throws Exception;

    public int getLength();

    public int getStringLength();

    public String getDefaultValueType();

    public String getDefaultValue();

    public String getPSSysValueRuleId();

    public String getDEMSFieldMode();

    public int getOrderValue();

    public long getCreateTime();

    public boolean isCheckRecursion();
}

