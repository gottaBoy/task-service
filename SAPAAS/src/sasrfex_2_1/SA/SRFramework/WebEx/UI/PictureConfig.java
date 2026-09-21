/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.WebEx.UI.HiddenConfig;
import java.util.HashMap;

public class PictureConfig
extends HiddenConfig {
    public static final String TAG_PICTURE = "SRFEXPICTURE";
    public static final String TAG_UPLOADIMAGE = "UPLOADIMAGE";
    public static final String TAG_DISABLEUPLOADIMAGE = "DISABLEUPLOADIMAGE";
    public static final String TAG_REMOVEIMAGE = "REMOVEIMAGE";
    public static final String TAG_DISABLEREMOVEIMAGE = "DISABLEREMOVEIMAGE";
    public static final String TAG_UPLOADTEXT = "UPLOADTEXT";
    public static final String TAG_REMOVETEXT = "REMOVETEXT";
    public static final String TAG_UPLOADTEXTRESID = "UPLOADTEXTRESID";
    public static final String TAG_REMOVETEXTRESID = "REMOVETEXTRESID";
    public static final String TAG_UPLOADTIPRESID = "UPLOADTIPRESID";
    public static final String TAG_REMOVETIPRESID = "REMOVETIPRESID";
    public static final String TAG_UPLOADPAGEPATH = "UPLOADPAGEPATH";
    public static final String TAG_UPLOADTIPMESSAGE = "UPLOADTIPMESSAGE";
    public static final String TAG_REMOVETIPMESSAGE = "REMOVETIPMESSAGE";
    public static final String TAG_DOWNLOADPAGEPATH = "DOWNLOADPAGEPATH";
    public static final String TAG_PICTUREWIDTH = "PICTUREWIDTH";
    public static final String TAG_PICTUREHEIGHT = "PICTUREHEIGHT";
    public static final String TAG_FOLDER = "FOLDER";
    protected String strImage = "../sasrfex/images/default/icon_upload_1.gif";
    protected String strDisableImage = "../sasrfex/images/default/icon_upload_2.png";
    protected String strRemoveImage = "../sasrfex/images/default/icon_delete.png";
    protected String strDisableRemoveImage = "../sasrfex/images/default/icon_delete.png";
    protected String strUploadPagePath = "";
    protected String strDownloadPagePath = "";
    protected String strUploadTipMessage = "\u70b9\u51fb\u4e0a\u4f20\u56fe\u7247";
    protected String strRemoveTipMessage = "\u5220\u9664\u56fe\u7247\u6587\u4ef6";
    protected String strUploadText = "\u4e0a\u4f20\u56fe\u7247";
    protected String strRemoveText = "\u79fb\u9664\u56fe\u7247";
    protected String strUploadTipResId = "";
    protected String strRemoveTipResId = "";
    protected String strUploadTextResId = "";
    protected String strRemoveTextResId = "";
    protected int nPictureWidth = 0;
    protected int nPictureHeight = 0;
    protected String strFolder = "";

    @Override
    protected void OnSetPropertyEx(HashMap<String, String> attrMap) {
        if (attrMap.size() == 0) {
            return;
        }
        String strValue = "";
        strValue = attrMap.remove(TAG_UPLOADIMAGE);
        if (strValue != null) {
            this.strImage = strValue;
        }
        if ((strValue = attrMap.remove(TAG_DISABLEUPLOADIMAGE)) != null) {
            this.strDisableImage = strValue;
        }
        if ((strValue = attrMap.remove(TAG_REMOVEIMAGE)) != null) {
            this.strRemoveImage = strValue;
        }
        if ((strValue = attrMap.remove(TAG_DISABLEREMOVEIMAGE)) != null) {
            this.strDisableRemoveImage = strValue;
        }
        if ((strValue = attrMap.remove(TAG_UPLOADPAGEPATH)) != null) {
            this.strUploadPagePath = strValue;
        }
        if ((strValue = attrMap.remove(TAG_DOWNLOADPAGEPATH)) != null) {
            this.strDownloadPagePath = strValue;
        }
        if ((strValue = attrMap.remove(TAG_UPLOADTIPMESSAGE)) != null) {
            this.setUploadTipMessage(strValue);
        }
        if ((strValue = attrMap.remove(TAG_REMOVETIPMESSAGE)) != null) {
            this.setRemoveTipMessage(strValue);
        }
        if ((strValue = attrMap.remove(TAG_PICTUREWIDTH)) != null) {
            this.setPictureWidth(PictureConfig.GetValue((String)strValue, (int)0));
        }
        if ((strValue = attrMap.remove(TAG_PICTUREHEIGHT)) != null) {
            this.setPictureHeight(PictureConfig.GetValue((String)strValue, (int)0));
        }
        if ((strValue = attrMap.remove(TAG_FOLDER)) != null) {
            this.setFolder(strValue);
        }
        if ((strValue = attrMap.remove(TAG_UPLOADTEXT)) != null) {
            this.setUploadText(strValue);
        }
        if ((strValue = attrMap.remove(TAG_REMOVETEXT)) != null) {
            this.setRemoveText(strValue);
        }
        if ((strValue = attrMap.remove(TAG_UPLOADTEXTRESID)) != null) {
            this.setUploadTextResId(strValue);
        }
        if ((strValue = attrMap.remove(TAG_REMOVETEXTRESID)) != null) {
            this.setRemoveTextResId(strValue);
        }
        if ((strValue = attrMap.remove(TAG_UPLOADTIPRESID)) != null) {
            this.setUploadTipResId(strValue);
        }
        if ((strValue = attrMap.remove(TAG_REMOVETIPRESID)) != null) {
            this.setRemoveTipResId(strValue);
        }
        super.OnSetPropertyEx(attrMap);
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

    public int getPictureWidth() {
        return this.nPictureWidth;
    }

    public int getPictureHeight() {
        return this.nPictureHeight;
    }

    public void setPictureWidth(int pictureWidth) {
        this.nPictureWidth = pictureWidth;
    }

    public void setPictureHeight(int pictureHeight) {
        this.nPictureHeight = pictureHeight;
    }

    public String getRemoveImage() {
        return this.strRemoveImage;
    }

    public String getDisableRemoveImage() {
        return this.strDisableRemoveImage;
    }

    public void setRemoveImage(String strRemoveImage) {
        this.strRemoveImage = strRemoveImage;
    }

    public void setDisableRemoveImage(String strDisableRemoveImage) {
        this.strDisableRemoveImage = strDisableRemoveImage;
    }

    public String getFolder() {
        return this.strFolder;
    }

    public void setFolder(String strFolder) {
        this.strFolder = strFolder;
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
}

