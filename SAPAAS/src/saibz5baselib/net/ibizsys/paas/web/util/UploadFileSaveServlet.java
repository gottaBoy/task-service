/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  net.sf.json.JSON
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.fileupload.FileItem
 *  org.apache.commons.fileupload.FileItemFactory
 *  org.apache.commons.fileupload.disk.DiskFileItemFactory
 *  org.apache.commons.fileupload.servlet.ServletFileUpload
 */
package net.ibizsys.paas.web.util;

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
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletException;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.psrt.srv.common.entity.FileBase;
import net.ibizsys.psrt.srv.common.service.FileService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadFileSaveServlet
extends HttpServletBase {
    private static final long serialVersionUID = 1L;

    @Override
    protected AjaxActionResult onProcessAction() throws Exception {
        AjaxActionResult ajaxActionResult = new AjaxActionResult();
        try {
            String strFileLocalPath = WebConfig.getCurrent().getFilePath();
            if (StringHelper.isNullOrEmpty(strFileLocalPath)) {
                ajaxActionResult.setRetCode(1);
                ajaxActionResult.setErrorInfo("\u7cfb\u7edf\u6ca1\u6709\u914d\u7f6e\u6587\u4ef6\u5b58\u50a8\u8def\u5f84");
                return ajaxActionResult;
            }
            ServletFileUpload sfu = this.createFileupload();
            List list = sfu.parseRequest(this.getWebContext().getRequest());
            int nCount = list.size();
            if (nCount == 0) {
                ajaxActionResult.setRetCode(3);
                ajaxActionResult.setErrorInfo("\u6ca1\u6709\u4efb\u4f55\u4e0a\u4f20\u6587\u4ef6");
                return ajaxActionResult;
            }
            String strFileFolder = "";
            String strExtFolder = this.getWebContext().getParamValue("FOLDER");
            if (!StringHelper.isNullOrEmpty(strExtFolder)) {
                strFileFolder = String.valueOf(strFileFolder) + strExtFolder;
                strFileFolder = String.valueOf(strFileFolder) + File.separator;
            }
            strFileFolder = String.valueOf(strFileFolder) + StringHelper.format("%1$tY-%1$tm-%1$td", new Date());
            strFileFolder = String.valueOf(strFileFolder) + File.separator;
            String strSessionId = "";
            strSessionId = KeyValueHelper.genGuidEx();
            strFileFolder = String.valueOf(strFileFolder) + strSessionId.toUpperCase();
            strFileFolder = String.valueOf(strFileFolder) + File.separator;
            File dir = new File(String.valueOf(strFileLocalPath) + strFileFolder);
            dir.mkdirs();
            String strFilename = "";
            String strFilePathName = String.valueOf(strFileLocalPath) + strFileFolder;
            int nFileSize = 0;
            JSONArray arr = new JSONArray();
            String strFileIds = "";
            String strFileNames = "";
            String strBackupFileName = strFilePathName;
            Iterator iters = list.iterator();
            while (iters.hasNext()) {
                Serializable file;
                strFilePathName = strBackupFileName;
                FileItem uploadFile = (FileItem)iters.next();
                nFileSize = (int)uploadFile.getSize();
                strFilename = uploadFile.getName();
                strFilename = this.getRealFileName(strFilename);
                int nPos = 0;
                boolean bSaveFile = true;
                strFilePathName = String.valueOf(strFilePathName) + strFilename;
                boolean bSaveOK = true;
                String strMessage = "";
                if (nPos > 0) {
                    String strTempFileName = String.valueOf(strFilePathName) + StringHelper.format("_%1$s", nPos);
                    File file2 = new File(strTempFileName);
                    uploadFile.write(file2);
                    bSaveOK = this.MergeFile(strFilePathName, strTempFileName, nPos);
                    if (!bSaveOK) {
                        strMessage = "\u5408\u5e76\u6587\u4ef6\u53d1\u751f\u9519\u8bef";
                    }
                } else {
                    file = new File(strFilePathName);
                    uploadFile.write((File)file);
                }
                file = null;
                if (bSaveFile && bSaveOK) {
                    FileService fileService = (FileService)ServiceGlobal.getService(FileService.class, this.getSessionFactory());
                    boolean bNormalSave = true;
                    if (this.isSavePicAsPng()) {
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
                                if (this.isSave4Direct()) {
                                    UploadFileSaveServlet.savePng4Direct(src, strTmpFilePathName, "jpg");
                                }
                                File saveFile = new File(strTmpFilePathName);
                                file = new net.ibizsys.psrt.srv.common.entity.File();
                                ((FileBase)file).setFileSize((int)saveFile.length());
                                ((FileBase)file).setFileName(String.valueOf(strFilename) + ".png");
                                ((FileBase)file).setLocalPath(String.valueOf(strFileFolder) + strFilename + ".png");
                                ((FileBase)file).setFolder(strExtFolder);
                                ((FileBase)file).setPicWidth(src.getWidth());
                                ((FileBase)file).setPicHeight(src.getHeight());
                                ((FileBase)file).setLocalPath2(String.valueOf(strFileFolder) + strFilename);
                                ((FileBase)file).setFileName2(strFilename);
                            }
                        }
                        catch (IOException je) {
                            ajaxActionResult.setRetCode(3);
                            ajaxActionResult.setErrorInfo(StringHelper.format("\u8f6c\u6362\u56fe\u7247\u683c\u5f0f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", je.getMessage()));
                            return ajaxActionResult;
                        }
                    }
                    if (bNormalSave) {
                        File f = new File(strFilePathName);
                        f.canRead();
                        BufferedImage src = ImageIO.read(f);
                        File saveFile = new File(strFilePathName);
                        file = new net.ibizsys.psrt.srv.common.entity.File();
                        ((FileBase)file).setFileSize((int)saveFile.length());
                        ((FileBase)file).setFileName(strFilename);
                        ((FileBase)file).setLocalPath(String.valueOf(strFileFolder) + strFilename);
                        ((FileBase)file).setFolder(strExtFolder);
                        if (src != null) {
                            ((FileBase)file).setPicWidth(src.getWidth());
                            ((FileBase)file).setPicHeight(src.getHeight());
                            ((FileBase)file).setLocalPath2(strFilePathName);
                        }
                        if (this.isSave4Direct()) {
                            UploadFileSaveServlet.savePng4Direct(src, strFilePathName, "png");
                        }
                    }
                    this.onBeforeSaveFile((net.ibizsys.psrt.srv.common.entity.File)file);
                    fileService.create(file);
                    this.onAfterSaveFile((net.ibizsys.psrt.srv.common.entity.File)file);
                    strMessage = ((FileBase)file).getFileId();
                }
                if (file == null) continue;
                if (!StringHelper.isNullOrEmpty(strFileIds)) {
                    strFileIds = String.valueOf(strFileIds) + ",";
                }
                strFileIds = String.valueOf(strFileIds) + ((FileBase)file).getFileId();
                if (!StringHelper.isNullOrEmpty(strFileNames)) {
                    strFileNames = String.valueOf(strFileNames) + ",";
                }
                strFileNames = String.valueOf(strFileNames) + ((FileBase)file).getFileName();
                JSONObject prop = new JSONObject();
                prop.put("id", (Object)((FileBase)file).getFileId());
                prop.put("name", (Object)((FileBase)file).getFileName());
                arr.put((JSON)prop);
            }
            ajaxActionResult.setExtAttr("files", arr);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return ajaxActionResult;
    }

    protected void onBeforeSaveFile(net.ibizsys.psrt.srv.common.entity.File file) throws Exception {
    }

    protected void onAfterSaveFile(net.ibizsys.psrt.srv.common.entity.File file) throws Exception {
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

    public static void savePng4Direct(BufferedImage bi, String strFileName, String strPicType) {
        try {
            if (bi == null) {
                return;
            }
            String strName = strFileName.substring(0, strFileName.indexOf("."));
            BufferedImage bi90 = UploadFileSaveServlet.rotateImg(bi, 90);
            BufferedImage bi180 = UploadFileSaveServlet.rotateImg(bi, 180);
            BufferedImage bi270 = UploadFileSaveServlet.rotateImg(bi, 270);
            if (StringHelper.compare(strPicType, "png", true) == 0) {
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

    public static BufferedImage rotateImg(BufferedImage image, int degree) throws IOException {
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

    protected boolean isSavePicAsPng() {
        String strSaveAsPng = this.getWebContext().getParamValue("SAVEPICASPNG");
        return StringHelper.compare(strSaveAsPng, "TRUE", true) == 0;
    }

    protected boolean isSave4Direct() {
        return true;
    }

    protected String getRealFileName(String strFilename) throws UnsupportedEncodingException {
        strFilename = new String(strFilename.getBytes("UTF-8"), "UTF-8");
        strFilename = URLDecoder.decode(strFilename, "UTF-8");
        return strFilename;
    }

    protected ServletFileUpload createFileupload() throws ServletException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload((FileItemFactory)factory);
        sfu.setHeaderEncoding("UTF-8");
        return sfu;
    }
}

