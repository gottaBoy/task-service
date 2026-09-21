/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.jdom.Content
 *  org.jdom.Document
 *  org.jdom.Element
 *  org.jdom.output.Format
 *  org.jdom.output.XMLOutputter
 */
package SA.IM.Ctrl.Task;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Content;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class IMContactsRender {
    private ISRFDAGlobalHelper globalHelper = null;
    private IDEDataCtrl imOrgDataCtrl = null;
    public static final String TAG_ROOT_ORG_SQL = "SELECT IMORGID,IMORGNAME,PIMORGID,ORGTYPE,SHORTNAME FROM SRFT_IMORG_BASE WHERE ORGTYPE=20 ORDER BY ORDERFLAG2 DESC";
    public static final String TAG_ORG_SQL = "SELECT IMORGID,IMORGNAME,PIMORGID,ORGTYPE,SHORTNAME FROM SRFT_IMORG_BASE WHERE PIMORGID = '%1$s' ORDER BY ORDERFLAG2 DESC";
    public static final String TAG_USER_SQL = "SELECT * FROM SRFV_IMUSER WHERE IMORGID='%1$s' ORDER BY ORDERFLAG2 DESC";
    public static final String TAG_XML_ROOT = "Contacts";
    public static final String TAG_XML_ORG = "ContactGroup";
    public static final String TAG_XML_USER = "Contact";
    private static final Log log = LogFactory.getLog(IMContactsRender.class);

    public void Init(ISRFDAGlobalHelper globalHelper) throws Exception {
        this.globalHelper = globalHelper;
        this.imOrgDataCtrl = this.globalHelper.getDAModelStorage().FindDEDataCtrl2("IM0067", "SYSTEM", null);
    }

    public CallResult Export(String path, String strRootOrgId) {
        Element rootElement = this.CreateRoot();
        CallResult callResult = this.FillRootOrg(rootElement);
        Document doc = new Document(rootElement);
        this.OutputXmlFile(doc, path);
        return callResult;
    }

    protected CallResult FillRootOrg(Element orgElement) {
        Vector<BaseDataEntity> vector = new Vector<BaseDataEntity>();
        CallResult callResult = this.SelectRootOrg(vector);
        if (callResult.IsError()) {
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        for (BaseDataEntity dataEntity : vector) {
            Element subOrgElement = this.CreateOrg(dataEntity);
            CallResult callResult2 = this.FillSubOrg(subOrgElement, dataEntity);
            if (callResult2.IsError()) {
                log.error((Object)callResult2.getErrorInfo());
                return callResult2;
            }
            callResult2 = this.FillUser(subOrgElement, dataEntity);
            if (callResult2.IsError()) {
                log.error((Object)callResult2.getErrorInfo());
                return callResult2;
            }
            orgElement.addContent((Content)subOrgElement);
        }
        return callResult;
    }

    protected CallResult FillSubOrg(Element orgElement, BaseDataEntity imOrg) {
        Vector<BaseDataEntity> vector = new Vector<BaseDataEntity>();
        CallResult callResult = this.SelectSubOrg(imOrg, vector);
        if (callResult.IsError()) {
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        for (BaseDataEntity dataEntity : vector) {
            Element subOrgElement = this.CreateOrg(dataEntity);
            CallResult callResult2 = this.FillSubOrg(subOrgElement, dataEntity);
            if (callResult2.IsError()) {
                log.error((Object)callResult2.getErrorInfo());
                return callResult2;
            }
            callResult2 = this.FillUser(subOrgElement, dataEntity);
            if (callResult2.IsError()) {
                log.error((Object)callResult2.getErrorInfo());
                return callResult2;
            }
            orgElement.addContent((Content)subOrgElement);
        }
        return callResult;
    }

    protected CallResult FillUser(Element orgElement, BaseDataEntity imOrg) {
        Vector<BaseDataEntity> vector = new Vector<BaseDataEntity>();
        CallResult callResult = this.SelectUsers(imOrg, vector);
        if (callResult.IsError()) {
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        for (BaseDataEntity dataEntity : vector) {
            Element element = this.CreateUser(dataEntity);
            orgElement.addContent((Content)element);
        }
        return callResult;
    }

    protected CallResult SelectUsers(BaseDataEntity parentDataEntity, Vector<BaseDataEntity> vector) {
        String strParentOrg = parentDataEntity.GetParamStringValue("IMORGID", "");
        String strSQL = StringHelper.Format((String)TAG_USER_SQL, (Object)strParentOrg);
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.globalHelper.getDBCaller().CallRaw2(strSQL);
            if (selectResult.getRetCode() == 0) {
                DataTable dataTable = selectResult.getMainTable();
                int i = 0;
                while (i < dataTable.GetRowCount()) {
                    DataRow dataRow = dataTable.GetRow(i);
                    BaseDataEntity dataEntity = new BaseDataEntity();
                    dataEntity.FromDataRow(dataRow);
                    vector.add(dataEntity);
                    ++i;
                }
            } else {
                callResult.setRetCode(selectResult.getRetCode());
                callResult.setErrorInfo(selectResult.getErrorInfo());
            }
        }
        catch (Exception e) {
            log.error((Object)e);
            callResult.setErrorInfo(e.getMessage());
            callResult.setRetCode(1);
        }
        return callResult;
    }

    protected CallResult SelectRootOrg(Vector<BaseDataEntity> vector) {
        String strSQL = TAG_ROOT_ORG_SQL;
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.globalHelper.getDBCaller().CallRaw2(strSQL);
            if (selectResult.getRetCode() == 0) {
                DataTable dataTable = selectResult.getMainTable();
                int i = 0;
                while (i < dataTable.GetRowCount()) {
                    DataRow dataRow = dataTable.GetRow(i);
                    BaseDataEntity dataEntity = new BaseDataEntity();
                    dataEntity.FromDataRow(dataRow);
                    vector.add(dataEntity);
                    ++i;
                }
            } else {
                callResult.setRetCode(selectResult.getRetCode());
                callResult.setErrorInfo(selectResult.getErrorInfo());
            }
        }
        catch (Exception e) {
            log.error((Object)e);
            callResult.setErrorInfo(e.getMessage());
            callResult.setRetCode(1);
        }
        return callResult;
    }

    protected CallResult SelectSubOrg(BaseDataEntity parentDataEntity, Vector<BaseDataEntity> vector) {
        String strParentOrg = parentDataEntity.GetParamStringValue("IMORGID", "");
        String strSQL = StringHelper.Format((String)TAG_ORG_SQL, (Object)strParentOrg);
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.globalHelper.getDBCaller().CallRaw2(strSQL);
            if (selectResult.getRetCode() == 0) {
                DataTable dataTable = selectResult.getMainTable();
                int i = 0;
                while (i < dataTable.GetRowCount()) {
                    DataRow dataRow = dataTable.GetRow(i);
                    BaseDataEntity dataEntity = new BaseDataEntity();
                    dataEntity.FromDataRow(dataRow);
                    vector.add(dataEntity);
                    ++i;
                }
            } else {
                callResult.setRetCode(selectResult.getRetCode());
                callResult.setErrorInfo(selectResult.getErrorInfo());
            }
        }
        catch (Exception e) {
            log.error((Object)e);
            callResult.setErrorInfo(e.getMessage());
            callResult.setRetCode(1);
        }
        return callResult;
    }

    protected Element CreateRoot() {
        Element element = new Element(TAG_XML_ROOT);
        return element;
    }

    protected Element CreateOrg(BaseDataEntity imOrg) {
        Element element = new Element(TAG_XML_ORG);
        String strId = imOrg.GetParamStringValue("IMORGID", "");
        String strName = imOrg.GetParamStringValue("IMORGNAME", "");
        String strShortName = imOrg.GetParamStringValue("SHORTNAME", "");
        String strType = imOrg.GetParamStringValue("ORGTYPE", "");
        String strPIMOrgId = imOrg.GetParamStringValue("PIMORGID", "");
        String strMemo = imOrg.GetParamStringValue("MEMO", "");
        element.setAttribute("id", strId);
        element.setAttribute("name", strName);
        element.setAttribute("orgtype", strType);
        element.setAttribute("shortname", strShortName);
        element.setAttribute("pimorgid", strPIMOrgId);
        element.setAttribute("memo", strMemo);
        log.info((Object)("[\u68c0\u52a1\u901a]\u521b\u5efa\u7ec4\u7ec7[" + strName + "]\u5b8c\u6210"));
        return element;
    }

    protected Element CreateUser(BaseDataEntity data) {
        Element element = new Element(TAG_XML_USER);
        String strId = data.GetParamStringValue("IMUSERID", "");
        String strName = data.GetParamStringValue("IMUSERNAME", "");
        element.setAttribute("id", strId);
        element.setAttribute("name", strName);
        element.setAttribute("usertype", data.GetParamStringValue("USERTYPE", ""));
        element.setAttribute("talklevel", data.GetParamStringValue("TALKLEVEL", ""));
        element.setAttribute("userlevel", data.GetParamStringValue("userlevel", ""));
        element.setAttribute("sex", data.GetParamStringValue("SEX", "1"));
        element.setAttribute("phone", data.GetParamStringValue("PHONE", ""));
        element.setAttribute("officephone", data.GetParamStringValue("OFFICEPHONE", ""));
        element.setAttribute("shortphone", data.GetParamStringValue("SHORTPHONE", ""));
        element.setAttribute("shortphone2", data.GetParamStringValue("SHORTPHONE2", ""));
        element.setAttribute("email", data.GetParamStringValue("EMAIL", ""));
        element.setAttribute("duty", data.GetParamStringValue("DUTY", ""));
        element.setAttribute("dutylevel", data.GetParamStringValue("DUTYLEVEL", ""));
        element.setAttribute("workplace", data.GetParamStringValue("WORKPLACE", ""));
        element.setAttribute("holidaystate", data.GetParamStringValue("HOLIDAYSTATE", ""));
        element.setAttribute("birthday", data.GetParamStringValue("BIRTHDAY", ""));
        element.setAttribute("usericon", data.GetParamStringValue("ICONPATH", ""));
        log.info((Object)("[\u68c0\u52a1\u901a]\u521b\u5efa\u4eba\u5458[" + strName + "]\u5b8c\u6210"));
        return element;
    }

    public void OutputXmlFile(Document doc, String strFile) {
        block12: {
            FileOutputStream fos = null;
            try {
                try {
                    fos = new FileOutputStream(strFile);
                    XMLOutputter outputter = new XMLOutputter();
                    Format format = Format.getPrettyFormat();
                    outputter.setFormat(format);
                    outputter.output(doc, (OutputStream)fos);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    if (fos == null) break block12;
                    try {
                        fos.close();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            finally {
                if (fos != null) {
                    try {
                        fos.close();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

