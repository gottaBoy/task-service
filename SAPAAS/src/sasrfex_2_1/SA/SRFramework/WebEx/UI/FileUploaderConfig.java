/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.HiddenConfig;

public class FileUploaderConfig
extends HiddenConfig {
    public static final String TAG_FILEUPLOADER = "SRFEXFILEUPLOADER";
    public static final String TAG_UPLOADIMAGE = "UPLOADIMAGE";
    public static final String TAG_DISABLEUPLOADIMAGE = "DISABLEUPLOADIMAGE";
    public static final String TAG_UPLOADPAGEPATH = "UPLOADPAGEPATH";
    public static final String TAG_UPLOADTIPMESSAGE = "UPLOADTIPMESSAGE";
    public static final String TAG_REMOVETIPMESSAGE = "REMOVETIPMESSAGE";
    public static final String TAG_DOWNLOADPAGEPATH = "DOWNLOADPAGEPATH";
    public static final String TAG_UPLOADTEXTRESID = "UPLOADTEXTRESID";
    public static final String TAG_REMOVETEXTRESID = "REMOVETEXTRESID";
    public static final String TAG_UPLOADTIPRESID = "UPLOADTIPRESID";
    public static final String TAG_REMOVETIPRESID = "REMOVETIPRESID";
    public static final String TAG_UPLOADTEXT = "UPLOADTEXT";
    public static final String TAG_REMOVETEXT = "REMOVETEXT";
    public static final String TAG_FOLDER = "FOLDER";
    public static final String TAG_MAXCOUNT = "MAXCOUNT";
    protected String strImage = "../sasrfex/images/default/icon_upload_1.gif";
    protected String strDisableImage = "../sasrfex/images/default/icon_upload_2.png";
    protected String strUploadPagePath = "";
    protected String strDownloadPagePath = "";
    protected String strUploadTipMessage = "\u70b9\u51fb\u4e0a\u4f20\u6587\u4ef6";
    protected String strRemoveTipMessage = "\u5220\u9664\u6307\u5b9a\u6587\u4ef6";
    protected String strFolder = "";
    protected String strUploadTipResId = "";
    protected String strRemoveTipResId = "";
    protected String strUploadTextResId = "";
    protected String strRemoveTextResId = "";
    protected int nMaxCount = 0;
    protected String strUploadText = "\u4e0a\u4f20\u6587\u4ef6";
    protected String strRemoveText = "\u79fb\u9664\u6587\u4ef6";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_UPLOADIMAGE, (boolean)true) == 0) {
            this.strImage = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DISABLEUPLOADIMAGE, (boolean)true) == 0) {
            this.strDisableImage = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_UPLOADPAGEPATH, (boolean)true) == 0) {
            this.strUploadPagePath = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DOWNLOADPAGEPATH, (boolean)true) == 0) {
            this.strDownloadPagePath = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_UPLOADTIPMESSAGE, (boolean)true) == 0) {
            this.setUploadTipMessage(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_REMOVETIPMESSAGE, (boolean)true) == 0) {
            this.setRemoveTipMessage(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_FOLDER, (boolean)true) == 0) {
            this.setFolder(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_MAXCOUNT, (boolean)true) == 0) {
            this.setMaxCount(FileUploaderConfig.GetValue((String)strValue, (int)this.getMaxCount()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_UPLOADTEXTRESID, (boolean)true) == 0) {
            this.setUploadTextResId(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_REMOVETEXTRESID, (boolean)true) == 0) {
            this.setRemoveTextResId(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_UPLOADTIPRESID, (boolean)true) == 0) {
            this.setUploadTipResId(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_REMOVETIPRESID, (boolean)true) == 0) {
            this.setRemoveTipResId(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_UPLOADTEXT, (boolean)true) == 0) {
            this.setUploadText(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_REMOVETEXT, (boolean)true) == 0) {
            this.setRemoveText(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getUploadImage() {
        return this.strImage;
    }

    public void setUploadImage(String strUploadImage) {
        this.strImage = strUploadImage;
    }

    public String getDisableUploadImage() {
        return this.strDisableImage;
    }

    public void setDisableUploadImage(String strDisableImage) {
        this.strDisableImage = strDisableImage;
    }

    public String getUploadPagePath() {
        return this.strUploadPagePath;
    }

    public void setUploadPagePath(String strUploadPagePath) {
        this.strUploadPagePath = strUploadPagePath;
    }

    public String getUploadTipMessage() {
        return this.strUploadTipMessage;
    }

    public String getRemoveTipMessage() {
        return this.strRemoveTipMessage;
    }

    public void setUploadTipMessage(String strUploadTipMessage) {
        this.strUploadTipMessage = strUploadTipMessage;
    }

    public void setRemoveTipMessage(String strRemoveTipMessage) {
        this.strRemoveTipMessage = strRemoveTipMessage;
    }

    public String getDownloadPagePath() {
        return this.strDownloadPagePath;
    }

    public void setDownloadPagePath(String strDownloadPagePath) {
        this.strDownloadPagePath = strDownloadPagePath;
    }

    public String getFolder() {
        return this.strFolder;
    }

    public void setFolder(String strFolder) {
        this.strFolder = strFolder;
    }

    public int getMaxCount() {
        return this.nMaxCount;
    }

    public void setMaxCount(int nMaxCount) {
        this.nMaxCount = nMaxCount;
    }

    public String getUploadTipResId() {
        return this.strUploadTipResId;
    }

    public void setUploadTipResId(String strUploadTipResId) {
        this.strUploadTipResId = strUploadTipResId;
    }

    public String getRemoveTipResId() {
        return this.strRemoveTipResId;
    }

    public void setRemoveTipResId(String strRemoveTipResId) {
        this.strRemoveTipResId = strRemoveTipResId;
    }

    public String getUploadTextResId() {
        return this.strUploadTextResId;
    }

    public void setUploadTextResId(String strUploadTextResId) {
        this.strUploadTextResId = strUploadTextResId;
    }

    public String getRemoveTextResId() {
        return this.strRemoveTextResId;
    }

    public void setRemoveTextResId(String strRemoveTextResId) {
        this.strRemoveTextResId = strRemoveTextResId;
    }

    public String getUploadText() {
        return this.strUploadText;
    }

    public void setUploadText(String strUploadText) {
        this.strUploadText = strUploadText;
    }

    public String getRemoveText() {
        return this.strRemoveText;
    }

    public void setRemoveText(String strRemoveText) {
        this.strRemoveText = strRemoveText;
    }
}

