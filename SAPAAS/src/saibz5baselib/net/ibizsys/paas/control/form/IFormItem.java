/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.control.form;

import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.control.form.IFIDEACMode;
import net.ibizsys.paas.control.form.IFIDEFValueRule;
import net.ibizsys.paas.control.form.IForm;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.web.IWebContext;
import net.sf.json.JSONObject;

public interface IFormItem
extends IModelBase {
    public static final String KEY = "srfkey";
    public static final String UF = "srfuf";
    public static final String TEMPMODE = "srftempmode";
    public static final String DEID = "srfdeid";
    public static final String SOURCEKEY = "srfsourcekey";
    public static final String LASTUPDATEDATE = "srfupdatedate";
    public static final String ITEMPRIV_PREFIX = "srfip_";
    public static final int ENABLECOND_NONE = 0;
    public static final int ENABLECOND_CREATE = 1;
    public static final int ENABLECOND_UPDATE = 2;
    public static final int IGNOREINPUT_NONE = 0;
    public static final int IGNOREINPUT_CREATE = 1;
    public static final int IGNOREINPUT_UPDATE = 2;
    public static final int ENABLECOND_ALL = 3;
    public static final int IGNOREINPUT_ALL = 3;
    public static final int IGNOREINPUT_DISABLE = 4;
    public static final int IGNOREINPUT_DISABLE_AND_NOTSETOUTPUT = 12;
    public static final int IGNOREINPUT_UPDATE_AND_SETORIGIN = 18;
    public static final int WRITEBACKDEFMODE_NONE = 0;
    public static final int WRITEBACKDEFMODE_ALWAYS = 1;
    public static final int WRITEBACKDEFMODE_ENABLED = 2;

    public IDataItem getDataItem();

    public Object getInputValue(IWebContext var1) throws Exception;

    public Object getOutputValue(IWebContext var1, IDataObject var2, boolean var3) throws Exception;

    public Object getDefaultValue(IWebContext var1, boolean var2) throws Exception;

    public JSONObject getConfig(IWebContext var1, IDataObject var2, boolean var3) throws Exception;

    public String getPrivilegeId();

    public String getValueItemName();

    public Iterator<IFIDEFValueRule> getFIDEFValueRules();

    public String getDEFName();

    public IForm getForm();

    public IDEField getDEField();

    public IFIDEACMode getFIDEACMode();

    public int getEnableCond();

    public String getCreateDVT();

    public String getCreateDV();

    public String getUpdateDVT();

    public String getUpdateDV();

    public ICodeList getCodeList() throws Exception;

    public String getCaption();

    public boolean isAllowEmpty();

    public String getCapLanId();

    public String getCapLanResTag();

    public String getCodeListId();

    public String getValueRuleId();

    public int getIgnoreInput();

    public String getValueTranslator();

    public String getUserDictCatId();

    public String getPrivFieldName();

    public String getInputTip();

    public String getInputTipLanResTag();

    public String getInputTipUrl();

    public String getInputTipSetId();

    public String getInputTipUniqueTag();

    public boolean isInputTipClosable();

    public int getWriteBackDEFMode();
}

