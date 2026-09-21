/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.File
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExAjaxListResult
 *  com.jspsmart.upload.SmartFile
 *  com.jspsmart.upload.SmartUpload
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExAjaxListResult;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UploadFileSavePage
extends BaseMainPage {
    protected String strProcessInfo = "";

    protected void OnInitComponents() {
        super.OnInitComponents();
        try {
            String strFileLocalPath = this.webContext.getWebExConfig().GetValue("SRFDA", "FILEFOLDER", "");
            if (StringHelper.IsNullOrEmpty((String)strFileLocalPath)) {
                this.strProcessInfo = "alert('\u7cfb\u7edf\u6ca1\u6709\u914d\u7f6e\u6587\u4ef6\u5b58\u50a8\u8def\u5f84');";
                return;
            }
            SmartUpload su = new SmartUpload();
            su.initialize(this.pageContext);
            su.upload();
            int nCount = su.getFiles().getCount();
            if (nCount == 0) {
                this.strProcessInfo = "alert('\u6ca1\u6709\u4efb\u4f55\u4e0a\u4f20\u6587\u4ef6');";
                return;
            }
            String strFileFolder = "";
            String strExtFolder = this.webContext.GetParamValue("FOLDER");
            if (!StringHelper.IsNullOrEmpty((String)strExtFolder)) {
                strFileFolder = String.valueOf(strFileFolder) + strExtFolder;
                strFileFolder = String.valueOf(strFileFolder) + File.separator;
            }
            strFileFolder = String.valueOf(strFileFolder) + StringHelper.Format((String)"%1$tY-%1$tm-%1$td", (Object)new Date());
            strFileFolder = String.valueOf(strFileFolder) + File.separator;
            String strSessionId = "";
            strSessionId = StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0 ? this.GetSLSessionGUID(su) : Helper.GenGuidEx();
            strFileFolder = String.valueOf(strFileFolder) + strSessionId.toUpperCase();
            strFileFolder = String.valueOf(strFileFolder) + File.separator;
            File dir = new File(String.valueOf(strFileLocalPath) + strFileFolder);
            dir.mkdirs();
            String strFilename = "";
            String strFilePathName = String.valueOf(strFileLocalPath) + strFileFolder;
            int nFileSize = 0;
            String strSLFileKey = "";
            ArrayList<JSONObject> arr = new ArrayList<JSONObject>();
            String strFileIds = "";
            String strFileNames = "";
            Vector<String> slFileKeys = new Vector<String>();
            String strBackupFileName = strFilePathName;
            int i = 0;
            while (i < nCount) {
                JSONObject prop;
                strFilePathName = strBackupFileName;
                SmartFile uploadFile = su.getFiles().getFile(i);
                nFileSize = uploadFile.getSize();
                strFilename = uploadFile.getFileName();
                int nPos = 0;
                boolean bSaveFile = true;
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    strSLFileKey = strFilename;
                    strFilename = this.GetSLRealFileName(su, strSLFileKey);
                    boolean bIsNewFileRequest = this.isSLNewFileRequest(su, strSLFileKey);
                    boolean bIsFinalFileRequest = this.isSLFinalFileRequest(su, strSLFileKey);
                    boolean bIsFinalUploadRequest = this.isSLFinalUploadRequest(su, strSLFileKey);
                    slFileKeys.add(strSLFileKey);
                    nPos = this.GetSLFileStartPos(su, strSLFileKey);
                    this.PageLog(this, 0, StringHelper.Format((String)"S[%1$s] K[%2$s] FN[%3$s] N[%4$s] S[%5$s] F[%6$s] P[%7$s]", (Object)strSessionId, (Object)strSLFileKey, (Object)strFilename, (Object)bIsNewFileRequest, (Object)bIsFinalFileRequest, (Object)bIsFinalUploadRequest, (Object)nPos));
                    bSaveFile = bIsFinalFileRequest;
                }
                strFilePathName = String.valueOf(strFilePathName) + strFilename;
                boolean bSaveOK = true;
                String strMessage = "";
                if (nPos > 0) {
                    String strTempFileName = String.valueOf(strFilePathName) + StringHelper.Format((String)"_%1$s", (Object)nPos);
                    uploadFile.saveAs(strTempFileName);
                    bSaveOK = this.MergeFile(strFilePathName, strTempFileName, nPos);
                    if (!bSaveOK) {
                        strMessage = "\u5408\u5e76\u6587\u4ef6\u53d1\u751f\u9519\u8bef";
                    }
                } else {
                    uploadFile.saveAs(strFilePathName);
                }
                SA.SRFDA.Ctrl.Data.File file = null;
                if (bSaveFile && bSaveOK) {
                    String strKeyValue;
                    IDEHelper fileDEHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper("DE0010");
                    if (fileDEHelper == null) {
                        this.strProcessInfo = StringHelper.Format((String)"alert('\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[FILE]\u8f85\u52a9\u5bf9\u8c61');");
                        return;
                    }
                    IDEDataCtrl fileDEDataCtrl = fileDEHelper.GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext());
                    if (fileDEDataCtrl == null) {
                        this.strProcessInfo = StringHelper.Format((String)"alert('\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[FILE]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61');");
                        return;
                    }
                    IDEHelper iMajorDEHelper = null;
                    if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPDEID()) && (iMajorDEHelper = this.getDAModelStorage().FindDEHelper(this.getWebContext().getSRFPDEID())) == null) {
                        this.strProcessInfo = StringHelper.Format((String)"alert('\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61');", (Object)this.getWebContext().getSRFPDEID());
                        return;
                    }
                    boolean bNormalSave = true;
                    if (this.IsSavePicAsPng()) {
                        try {
                            String strTmpFilePathName = strFilePathName.toLowerCase();
                            int nFilePos = strTmpFilePathName.lastIndexOf(".png");
                            if (nFilePos == strTmpFilePathName.length() - 4) {
                                bNormalSave = true;
                            } else {
                                bNormalSave = false;
                                strTmpFilePathName = strFilePathName;
                                strTmpFilePathName = String.valueOf(strTmpFilePathName) + ".png";
                                File f = new File(strFilePathName);
                                f.canRead();
                                BufferedImage src = ImageIO.read(f);
                                Iterator<ImageWriter> iter = ImageIO.getImageWritersByFormatName("jpg");
                                if (iter.hasNext()) {
                                    ImageWriter writer = iter.next();
                                    ImageWriteParam param = writer.getDefaultWriteParam();
                                    param.setCompressionMode(1);
                                    FileImageOutputStream out = new FileImageOutputStream(new File(strTmpFilePathName));
                                    writer.setOutput(out);
                                    writer.write(null, new IIOImage(src, null, null), param);
                                    out.close();
                                    writer.dispose();
                                }
                                if (this.IsSave4Direct()) {
                                    UploadFileSavePage.SavePng4Direct(src, strTmpFilePathName, "jpg");
                                }
                                File saveFile = new File(strTmpFilePathName);
                                file = new SA.SRFDA.Ctrl.Data.File();
                                file.setFILESIZE((int)saveFile.length());
                                file.setFILE_NAME(String.valueOf(strFilename) + ".png");
                                file.setLOCALPATH(String.valueOf(strFileFolder) + strFilename + ".png");
                                file.setFOLDER(strExtFolder);
                                file.setPICWIDTH(src.getWidth());
                                file.setPICHEIGHT(src.getHeight());
                                file.setLOCALPATH2(String.valueOf(strFileFolder) + strFilename);
                                file.setFILENAME2(strFilename);
                            }
                        }
                        catch (IOException je) {
                            this.PageLog(this, 1, StringHelper.Format((String)"\u8f6c\u6362\u56fe\u7247\u683c\u5f0f\u53d1\u751f\u5f02\u5e38", (Object)je));
                            this.strProcessInfo = StringHelper.Format((String)"alert('\u8f6c\u6362\u56fe\u7247\u683c\u5f0f\u53d1\u751f\u5f02\u5e38\uff0c%1$s');", (Object)je.getMessage());
                            return;
                        }
                    }
                    if (bNormalSave) {
                        File f = new File(strFilePathName);
                        f.canRead();
                        BufferedImage src = ImageIO.read(f);
                        File saveFile = new File(strFilePathName);
                        file = new SA.SRFDA.Ctrl.Data.File();
                        file.setFILESIZE((int)saveFile.length());
                        file.setFILE_NAME(strFilename);
                        file.setLOCALPATH(String.valueOf(strFileFolder) + strFilename);
                        file.setFOLDER(strExtFolder);
                        if (src != null) {
                            file.setPICWIDTH(src.getWidth());
                            file.setPICHEIGHT(src.getHeight());
                            file.setLOCALPATH2(strFilePathName);
                        }
                        if (this.IsSave4Direct()) {
                            UploadFileSavePage.SavePng4Direct(src, strFilePathName, "png");
                        }
                    }
                    if (iMajorDEHelper != null && !StringHelper.IsNullOrEmpty((String)(strKeyValue = this.getWebContext().GetParamValue(iMajorDEHelper.GetKeyDEFHelper().getName())))) {
                        file.setOWNERTYPE(iMajorDEHelper.getId());
                        file.setOWNERID(strKeyValue);
                    }
                    CallResult callResult = fileDEDataCtrl.Save(true, file);
                    if ((callResult = this.OnAfterSaveFile(callResult, file)).getRetCode() != 0) {
                        this.strProcessInfo = StringHelper.Format((String)"alert('\u4fdd\u5b58\u6587\u4ef6\u4fe1\u606f\u51fa\u73b0\u9519\u8bef\uff0c%1$s');", (Object)callResult.getErrorInfo());
                        strMessage = StringHelper.Format((String)"\u4fdd\u5b58\u6587\u4ef6\u4fe1\u606f\u51fa\u73b0\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                        bSaveOK = false;
                    } else {
                        strMessage = file.getFILE_ID();
                    }
                }
                if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    prop = new JSONObject();
                    prop.put(String.valueOf(strSLFileKey) + "_RadUAG_success", bSaveOK);
                    arr.add(prop);
                    prop = new JSONObject();
                    prop.put(String.valueOf(strSLFileKey) + "_RadUAG_fileName", (Object)strFilename);
                    arr.add(prop);
                    prop = new JSONObject();
                    prop.put(String.valueOf(strSLFileKey) + "_RadUAG_message", (Object)strMessage);
                    arr.add(prop);
                } else if (file != null) {
                    if (!StringHelper.IsNullOrEmpty((String)strFileIds)) {
                        strFileIds = String.valueOf(strFileIds) + ",";
                    }
                    strFileIds = String.valueOf(strFileIds) + file.getFILE_ID();
                    if (!StringHelper.IsNullOrEmpty((String)strFileNames)) {
                        strFileNames = String.valueOf(strFileNames) + ",";
                    }
                    strFileNames = String.valueOf(strFileNames) + file.getFILE_NAME();
                    prop = new JSONObject();
                    prop.put("fileid", (Object)file.getFILE_ID());
                    prop.put("filename", (Object)file.getFILE_NAME());
                    arr.add(prop);
                }
                ++i;
            }
            if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0) {
                JSONObject jsonData = new JSONObject();
                jsonData.put("JSONData", (Object)JSONArray.fromArray((Object[])arr.toArray()));
                this.getResponse().getWriter().print(jsonData.toString());
            } else if (StringHelper.Compare((String)this.getPageModel(), (String)"IOS", (boolean)true) == 0) {
                SRFExAjaxListResult ajaxActionResultEx = new SRFExAjaxListResult();
                ajaxActionResultEx.getItems().addAll(arr);
                this.getResponse().getWriter().print(ajaxActionResultEx.ToJSONString());
            } else {
                StringBuilderEx script = new StringBuilderEx();
                script.Append("var win=window;if(parent)win=parent;win.returnValue={ret:'ok',filename:'%1$s',fileid:'%2$s'};win.close();", (Object)strFileNames, (Object)strFileIds);
                this.strProcessInfo = script.toString();
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String GetJSCode() {
        return this.strProcessInfo;
    }

    public String GetSLRealFileName(SmartUpload su, String strFileId) {
        String strFileName = su.getRequest().getParameter(String.valueOf(strFileId) + "_RadUAG_fileName");
        try {
            strFileName = URLDecoder.decode(strFileName, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return strFileName;
    }

    protected CallResult OnAfterSaveFile(CallResult callResult, SA.SRFDA.Ctrl.Data.File file) {
        return callResult;
    }

    public int GetSLFileStartPos(SmartUpload su, String strFileId) {
        return Integer.parseInt(su.getRequest().getParameter(String.valueOf(strFileId) + "_RadUAG_position"));
    }

    public boolean isSLNewFileRequest(SmartUpload su, String strFileId) {
        String strValue = su.getRequest().getParameter(String.valueOf(strFileId) + "_RadUAG_newFileRequest");
        return StringHelper.Compare((String)strValue, (String)"TRUE", (boolean)true) == 0;
    }

    public boolean isSLFinalFileRequest(SmartUpload su, String strFileId) {
        String strValue = su.getRequest().getParameter(String.valueOf(strFileId) + "_RadUAG_finalFileRequest");
        return StringHelper.Compare((String)strValue, (String)"TRUE", (boolean)true) == 0;
    }

    public boolean isSLFinalUploadRequest(SmartUpload su, String strFileId) {
        String strValue = su.getRequest().getParameter(String.valueOf(strFileId) + "_RadUAG_finalUploadRequest");
        return StringHelper.Compare((String)strValue, (String)"TRUE", (boolean)true) == 0;
    }

    public String GetSLSessionGUID(SmartUpload su) {
        return su.getRequest().getParameter("RadUAG_guid");
    }

    protected boolean MergeFile(String strDstFile, String strSrcFile, int nPos) {
        try {
            int length = 10240;
            FileInputStream in = new FileInputStream(strSrcFile);
            FileOutputStream out = new FileOutputStream(strDstFile, true);
            byte[] buffer = new byte[length];
            while (true) {
                int ins;
                if ((ins = in.read(buffer)) == -1) break;
                out.write(buffer, 0, ins);
            }
            in.close();
            out.flush();
            out.close();
            File file = new File(strSrcFile);
            file.delete();
            return true;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void SavePng4Direct(BufferedImage bi, String strFileName, String strPicType) {
        try {
            if (bi == null) {
                return;
            }
            String strName = strFileName.substring(0, strFileName.indexOf("."));
            BufferedImage bi90 = UploadFileSavePage.RotateImg(bi, 90);
            BufferedImage bi180 = UploadFileSavePage.RotateImg(bi, 180);
            BufferedImage bi270 = UploadFileSavePage.RotateImg(bi, 270);
            if (StringHelper.Compare((String)strPicType, (String)"png", (boolean)true) == 0) {
                ImageIO.write((RenderedImage)bi90, "png", new File(String.valueOf(strName) + "_90.png"));
                ImageIO.write((RenderedImage)bi180, "png", new File(String.valueOf(strName) + "_180.png"));
                ImageIO.write((RenderedImage)bi270, "png", new File(String.valueOf(strName) + "_270.png"));
            } else {
                Iterator<ImageWriter> iter = ImageIO.getImageWritersByFormatName("jpg");
                if (iter.hasNext()) {
                    ImageWriter writer = iter.next();
                    ImageWriteParam param = writer.getDefaultWriteParam();
                    param.setCompressionMode(1);
                    FileImageOutputStream out90 = new FileImageOutputStream(new File(String.valueOf(strName) + "_90.png"));
                    writer.setOutput(out90);
                    writer.write(null, new IIOImage(bi90, null, null), param);
                    out90.close();
                    FileImageOutputStream out180 = new FileImageOutputStream(new File(String.valueOf(strName) + "_180.png"));
                    writer.setOutput(out180);
                    writer.write(null, new IIOImage(bi180, null, null), param);
                    out180.close();
                    FileImageOutputStream out270 = new FileImageOutputStream(new File(String.valueOf(strName) + "_270.png"));
                    writer.setOutput(out270);
                    writer.write(null, new IIOImage(bi270, null, null), param);
                    out270.close();
                    writer.dispose();
                    bi90 = null;
                    bi180 = null;
                    bi270 = null;
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static BufferedImage RotateImg(BufferedImage image, int degree) throws IOException {
        int iw = image.getWidth();
        int ih = image.getHeight();
        int w = 0;
        int h = 0;
        int x = 0;
        int y = 0;
        if ((degree %= 360) < 0) {
            degree += 360;
        }
        double ang = Math.toRadians(degree);
        if (degree == 180 || degree == 0 || degree == 360) {
            w = iw;
            h = ih;
        } else if (degree == 90 || degree == 270) {
            w = ih;
            h = iw;
        } else {
            int d = iw + ih;
            w = (int)((double)d * Math.abs(Math.cos(ang)));
            h = (int)((double)d * Math.abs(Math.sin(ang)));
        }
        x = w / 2 - iw / 2;
        y = h / 2 - ih / 2;
        BufferedImage rotatedImage = new BufferedImage(w, h, image.getType());
        Graphics2D gs = (Graphics2D)rotatedImage.getGraphics();
        rotatedImage = gs.getDeviceConfiguration().createCompatibleImage(w, h);
        AffineTransform at = new AffineTransform();
        at.rotate(ang, w / 2, h / 2);
        at.translate(x, y);
        AffineTransformOp op = new AffineTransformOp(at, 3);
        op.filter(image, rotatedImage);
        image = rotatedImage;
        return image;
    }

    protected boolean IsSavePicAsPng() {
        String strSaveAsPng = this.getWebContext().GetParamValue("SAVEPICASPNG");
        return StringHelper.Compare((String)strSaveAsPng, (String)"TRUE", (boolean)true) == 0;
    }

    protected boolean IsSave4Direct() {
        return true;
    }
}

