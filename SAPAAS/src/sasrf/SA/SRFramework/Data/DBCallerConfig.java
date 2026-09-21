/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Data.DBCallerAction;
import SA.SRFramework.Data.DBCallerCheck;
import SA.SRFramework.Data.DBCallerParam;
import SA.SRFramework.Data.DBUserError;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Hashtable;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DBCallerConfig
extends XMLConfig {
    public static final String SASRFDBCALL = "SASRFDBCALL";
    public static final String PROCPARAMS = "PROCPARAMS";
    public static final String USERERRORS = "USERERRORS";
    public static final String USERERROR = "USERERROR";
    public static final String CUSTOMACTIONS = "CUSTOMACTIONS";
    public static final String CUSTOMACTION = "CUSTOMACTION";
    public static final String CHECKS = "CHECKS";
    public static final String CHECK = "CHECK";
    public static final String PROCPARAM = "PROCPARAM";
    public static final String NAME = "NAME";
    public static final String PROCNAME = "PROCNAME";
    public static final String PROCNAME2 = "PROCNAME2";
    public static final String PROCNAME3 = "PROCNAME3";
    public static final String PROCNAME4 = "PROCNAME4";
    public static final String LOGDBOPERATOR = "LOGDBOPERATOR";
    public static final String LOGICENABLE = "LOGICENABLE";
    public static final String CHECKEXIST = "CHECKEXIST";
    public static final String VIEWNAME = "VIEWNAME";
    public static final String DEBUG = "DEBUG";
    public static final String USERRETURN = "USERRETURN";
    public static final String SYSTEMRETURN = "SYSTEMRETURN";
    public static final String SORTPARAM = "SORTPARAM";
    public static final String SORTDIRECT = "SORTDIRECT";
    public static final String AUTOGENPROC = "AUTOGENPROC";
    public static final String ALWAYSREGENPROC = "ALWAYSREGENPROC";
    public static final String GENPROCNAME = "GENPROCNAME";
    public static final String DEFAULTSORT = "DEFAULTSORT";
    public static final String AUTODEFAULTSORT = "AUTODEFAULTSORT";
    protected String strProcName = "";
    protected String strProcName2 = "";
    protected String strProcName3 = "";
    protected String strProcName4 = "";
    protected String strViewName = "";
    protected boolean bLogicEnable = false;
    protected boolean bCheckExist = true;
    protected ArrayList paramList = new ArrayList();
    protected Hashtable userErrorList = new Hashtable();
    protected ArrayList customActionList = null;
    protected ArrayList checkList = null;
    protected boolean bLogDBOperator = true;
    protected boolean bUseProcName2 = false;
    protected boolean bUseProcName3 = false;
    protected boolean bUseProcName4 = false;
    protected boolean bDebug = false;
    protected String strUserReturn = "";
    protected String strSystemReturn = "";
    protected String strSortParam = "";
    protected String strSortDirect = "ASC";
    protected boolean bAutoGenProc = false;
    protected boolean bAlwaysReGenProc = false;
    protected boolean bGenProcFinish = false;
    protected String strGenProcName = "";
    protected String strDefaultSort = "";
    protected boolean bAutoDefaultSort = false;

    public String getProcName() {
        if (this.bUseProcName2 && StringHelper.Length(this.strProcName2) > 0) {
            return this.strProcName2;
        }
        if (this.bUseProcName3 && StringHelper.Length(this.strProcName3) > 0) {
            return this.strProcName3;
        }
        if (this.bUseProcName4 && StringHelper.Length(this.strProcName4) > 0) {
            return this.strProcName4;
        }
        if (StringHelper.StringLength(this.strProcName) == 0) {
            return this.strId;
        }
        return this.strProcName;
    }

    public boolean getLogDBOperator() {
        return this.bLogDBOperator;
    }

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (strName.compareToIgnoreCase(PROCPARAMS) == 0) {
            this.LoadProcParams(xmlNode);
            return;
        }
        if (strName.compareToIgnoreCase(USERERRORS) == 0) {
            this.LoadUserErrors(xmlNode);
            return;
        }
        if (StringHelper.Compare(strName, CUSTOMACTIONS, true) == 0) {
            this.LoadCustomActions(xmlNode);
            return;
        }
        if (StringHelper.Compare(strName, CHECKS, true) == 0) {
            this.LoadChecks(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare(strName, NAME, true) == 0 || StringHelper.Compare(strName, PROCNAME, true) == 0) {
            this.strProcName = strValue;
            return;
        }
        if (StringHelper.Compare(strName, PROCNAME2, true) == 0) {
            this.strProcName2 = strValue;
            return;
        }
        if (StringHelper.Compare(strName, PROCNAME3, true) == 0) {
            this.strProcName3 = strValue;
            return;
        }
        if (StringHelper.Compare(strName, PROCNAME4, true) == 0) {
            this.strProcName4 = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(LOGDBOPERATOR) == 0) {
            this.bLogDBOperator = DBCallerConfig.GetValue(strValue, this.bLogDBOperator);
            return;
        }
        if (StringHelper.Compare(strName, LOGICENABLE, true) == 0) {
            this.bLogicEnable = DBCallerConfig.GetValue(strValue, this.bLogicEnable);
            return;
        }
        if (StringHelper.Compare(strName, CHECKEXIST, true) == 0) {
            this.bCheckExist = DBCallerConfig.GetValue(strValue, this.bCheckExist);
            return;
        }
        if (StringHelper.Compare(strName, VIEWNAME, true) == 0) {
            this.strViewName = strValue;
            return;
        }
        if (StringHelper.Compare(strName, DEBUG, true) == 0) {
            this.bDebug = DBCallerConfig.GetValue(strValue, this.bDebug);
            return;
        }
        if (StringHelper.Compare(strName, USERRETURN, true) == 0) {
            this.strUserReturn = strValue;
            return;
        }
        if (StringHelper.Compare(strName, SYSTEMRETURN, true) == 0) {
            this.strSystemReturn = strValue;
            return;
        }
        if (StringHelper.Compare(strName, SORTPARAM, true) == 0) {
            this.strSortParam = strValue;
            return;
        }
        if (StringHelper.Compare(strName, SORTDIRECT, true) == 0) {
            this.strSortDirect = strValue;
            return;
        }
        if (StringHelper.Compare(strName, AUTOGENPROC, true) == 0) {
            this.bAutoGenProc = DBCallerConfig.GetValue(strValue, this.bAutoGenProc);
            return;
        }
        if (StringHelper.Compare(strName, ALWAYSREGENPROC, true) == 0) {
            this.bAlwaysReGenProc = DBCallerConfig.GetValue(strValue, this.bAlwaysReGenProc);
            return;
        }
        if (StringHelper.Compare(strName, GENPROCNAME, true) == 0) {
            this.strGenProcName = strValue;
            return;
        }
        if (StringHelper.Compare(strName, DEFAULTSORT, true) == 0) {
            this.strDefaultSort = strValue;
            return;
        }
        if (StringHelper.Compare(strName, AUTODEFAULTSORT, true) == 0) {
            this.bAutoDefaultSort = DBCallerConfig.GetValue(strValue, this.bAutoDefaultSort);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    protected void LoadProcParams(Node xmlNode) {
        NodeList nodes = xmlNode.getChildNodes();
        int i = 0;
        while (i < nodes.getLength()) {
            DBCallerParam dbCallerParam;
            Node childXML = nodes.item(i);
            if (childXML.getNodeName().compareToIgnoreCase(PROCPARAM) == 0 && (dbCallerParam = new DBCallerParam()).LoadConfig(childXML)) {
                this.paramList.add(dbCallerParam);
            }
            ++i;
        }
    }

    protected void LoadUserErrors(Node xmlNode) {
        NodeList nodes = xmlNode.getChildNodes();
        int i = 0;
        while (i < nodes.getLength()) {
            DBUserError dbUserError;
            Node childXML = nodes.item(i);
            if (childXML.getNodeName().compareToIgnoreCase(USERERROR) == 0 && (dbUserError = new DBUserError()).LoadConfig(childXML)) {
                this.userErrorList.put(dbUserError.getID(), dbUserError);
            }
            ++i;
        }
    }

    protected void LoadCustomActions(Node xmlNode) {
        if (this.customActionList == null) {
            this.customActionList = new ArrayList();
        }
        NodeList nodes = xmlNode.getChildNodes();
        int i = 0;
        while (i < nodes.getLength()) {
            DBCallerAction action;
            Node childXML = nodes.item(i);
            if (childXML.getNodeName().compareToIgnoreCase(CUSTOMACTION) == 0 && (action = new DBCallerAction()).LoadConfig(childXML)) {
                this.customActionList.add(action);
            }
            ++i;
        }
    }

    protected void LoadChecks(Node xmlNode) {
        if (this.checkList == null) {
            this.checkList = new ArrayList();
        }
        NodeList nodes = xmlNode.getChildNodes();
        int i = 0;
        while (i < nodes.getLength()) {
            DBCallerCheck check;
            Node childXML = nodes.item(i);
            if (childXML.getNodeName().compareToIgnoreCase(CHECK) == 0 && (check = new DBCallerCheck()).LoadConfig(childXML)) {
                this.checkList.add(check);
            }
            ++i;
        }
    }

    public ArrayList getChecks() {
        return this.checkList;
    }

    public ArrayList getParams() {
        return this.paramList;
    }

    public DBUserError GetUserError(String strErrorCode) {
        if (this.userErrorList.containsKey(strErrorCode)) {
            return (DBUserError)this.userErrorList.get(strErrorCode);
        }
        return null;
    }

    public void setUseProcName2(boolean bUseProcName2) {
        this.bUseProcName2 = bUseProcName2;
    }

    public void setUseProcName3(boolean bUseProcName3) {
        this.bUseProcName3 = bUseProcName3;
    }

    public void setUseProcName4(boolean bUseProcName4) {
        this.bUseProcName4 = bUseProcName4;
    }

    public String FindCustomAction(String strDatabase, String strActionType) {
        if (this.customActionList == null) {
            return "";
        }
        String strAction = "";
        int i = 0;
        while (i < this.customActionList.size()) {
            DBCallerAction action = (DBCallerAction)this.customActionList.get(i);
            if (StringHelper.Compare(action.getActionType(), strActionType, true) == 0 && (StringHelper.Length(action.getDatabase()) == 0 || StringHelper.Compare(action.getDatabase(), strDatabase, true) == 0)) {
                if (StringHelper.Length(strAction) > 0) {
                    strAction = String.valueOf(strAction) + "\r\n";
                }
                strAction = String.valueOf(strAction) + action.getAction();
            }
            ++i;
        }
        strAction = strAction.replaceAll("\r\n", "\n");
        return strAction;
    }

    public String FindCustomActionOne(String strDatabase, String strActionType) {
        if (this.customActionList == null) {
            return "";
        }
        String strAction = "";
        int i = 0;
        while (i < this.customActionList.size()) {
            DBCallerAction action = (DBCallerAction)this.customActionList.get(i);
            if (StringHelper.Compare(action.getActionType(), strActionType, true) == 0 && (StringHelper.Length(action.getDatabase()) == 0 || StringHelper.Compare(action.getDatabase(), strDatabase, true) == 0) && StringHelper.Length(strAction = action.getAction()) > 0) {
                return strAction;
            }
            ++i;
        }
        return "";
    }

    public boolean getLogicEnable() {
        return this.bLogicEnable;
    }

    public void setLogicEnable(boolean bLogicEnable) {
        this.bLogicEnable = bLogicEnable;
    }

    public boolean getCheckExist() {
        return this.bCheckExist;
    }

    public void setCheckExist(boolean bCheckExist) {
        this.bCheckExist = bCheckExist;
    }

    public void setViewName(String strViewName) {
        this.strViewName = strViewName;
    }

    public String getViewName() {
        if (StringHelper.Length(this.strViewName) == 0) {
            return this.getProcName();
        }
        return this.strViewName;
    }

    public boolean getDebug() {
        return this.bDebug;
    }

    public void setDebug(boolean bDebug) {
        this.bDebug = bDebug;
    }

    public void setUserReturn(String strUserReturn) {
        this.strUserReturn = strUserReturn;
    }

    public String getUserReturn() {
        return this.strUserReturn;
    }

    public void setSystemReturn(String strSystemReturn) {
        this.strSystemReturn = strSystemReturn;
    }

    public String getSystemReturn() {
        return this.strSystemReturn;
    }

    public void setSortParam(String strSortParam) {
        this.strSortParam = strSortParam;
    }

    public String getSortParam() {
        return this.strSortParam;
    }

    public void setSortDirect(String strSortDirect) {
        this.strSortDirect = strSortDirect;
    }

    public String getSortDirect() {
        return this.strSortDirect;
    }

    public boolean getAutoGenProc() {
        return this.bAutoGenProc;
    }

    public void setAutoGenProc(boolean bAutoGenProc) {
        this.bAutoGenProc = bAutoGenProc;
    }

    public boolean getAlwaysReGenProc() {
        return this.bAlwaysReGenProc;
    }

    public void setAlwaysReGenProc(boolean bAlwaysReGenProc) {
        this.bAlwaysReGenProc = bAlwaysReGenProc;
    }

    public boolean getGenProcFinish() {
        return this.bGenProcFinish;
    }

    public void setGenProcFinish(boolean bGenProcFinish) {
        this.bGenProcFinish = bGenProcFinish;
    }

    public void setGenProcName(String strGenProcName) {
        this.strGenProcName = strGenProcName;
    }

    public String getGenProcName() {
        return this.strGenProcName;
    }

    public String getDefaultSort() {
        return this.strDefaultSort;
    }

    public void setDefaultSort(String strDefaultSort) {
        this.strDefaultSort = strDefaultSort;
    }

    public boolean isAutoDefaultSort() {
        return this.bAutoDefaultSort;
    }

    public void setAutoDefaultSort(boolean bAutoDefaultSort) {
        this.bAutoDefaultSort = bAutoDefaultSort;
    }
}

