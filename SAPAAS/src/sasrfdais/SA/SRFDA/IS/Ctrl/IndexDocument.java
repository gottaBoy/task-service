/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.IS.Ctrl;

import SA.SRFramework.Utility.StringHelper;
import java.util.Date;
import java.util.TreeMap;

public class IndexDocument {
    protected String strDescription = "";
    protected String strKey = "";
    protected String strMajorInfo = "";
    protected String strContent = "";
    protected String strDocumentType = "";
    protected Date updateDate = null;
    protected boolean bDescAsHTML = true;
    protected String strPrivKey = "";
    protected TreeMap<String, String> extFieldMap = new TreeMap();

    public String getDescription() {
        return this.strDescription;
    }

    public void setDescription(String strDescription) {
        this.strDescription = strDescription;
    }

    public String getKey() {
        return this.strKey;
    }

    public String getMajorInfo() {
        return this.strMajorInfo;
    }

    public String getContent() {
        return this.strContent;
    }

    public void setKey(String strKey) {
        this.strKey = strKey;
    }

    public void setMajorInfo(String strMajorInfo) {
        this.strMajorInfo = strMajorInfo;
    }

    public void setContent(String strContent) {
        this.strContent = strContent;
    }

    public String getDocumentType() {
        return this.strDocumentType;
    }

    public void setDocumentType(String strDocumentType) {
        this.strDocumentType = strDocumentType;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public TreeMap<String, String> getExtFieldMap() {
        return this.extFieldMap;
    }

    public boolean isDescAsHTML() {
        return this.bDescAsHTML;
    }

    public void setDescAsHTML(boolean bDescAsHTML) {
        this.bDescAsHTML = bDescAsHTML;
    }

    public String getPrivKey() {
        return this.strPrivKey;
    }

    public void setPrivKey(String strPrivKey) {
        this.strPrivKey = StringHelper.IsNullOrEmpty((String)strPrivKey) ? "" : strPrivKey;
    }
}

