package net.ibizsys.paas.web.util;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.psrt.srv.common.service.FileService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 文件上传Servlet处理对象
 * 
 * @author Administrator
 *
 */
public class UploadFileSaveServlet extends HttpServletBase {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected AjaxActionResult onProcessAction() throws Exception {
		AjaxActionResult ajaxActionResult = new AjaxActionResult();
		try
		{
			String strFileLocalPath = WebConfig.getCurrent().getFilePath();
			if (StringHelper.isNullOrEmpty(strFileLocalPath))
			{
				ajaxActionResult.setRetCode(Errors.INTERNALERROR);
				ajaxActionResult.setErrorInfo("系统没有配置文件存储路径");
				return ajaxActionResult;
			}
			
			ServletFileUpload sfu = this.createFileupload();
			
			List<FileItem> list = sfu.parseRequest(this.getWebContext().getRequest());//得到所有上传文件
			
			int nCount = list.size();
			
			if (nCount == 0)
			{
				ajaxActionResult.setRetCode(Errors.INVALIDDATA);
				ajaxActionResult.setErrorInfo("没有任何上传文件");
				return ajaxActionResult;
			}
			String strFileFolder = "";
			String strExtFolder = this.getWebContext().getParamValue("FOLDER");
			if (!StringHelper.isNullOrEmpty(strExtFolder))
			{
				strFileFolder += strExtFolder;
				strFileFolder += File.separator;

			}
			strFileFolder += StringHelper.format("%1$tY-%1$tm-%1$td", new java.util.Date());
			strFileFolder += File.separator;

			String strSessionId = "";
			strSessionId = KeyValueHelper.genGuidEx();

			strFileFolder += strSessionId.toUpperCase();
			strFileFolder += File.separator;

			File dir = new File(strFileLocalPath + strFileFolder);
			dir.mkdirs();

			String strFilename = "";
			String strFilePathName = strFileLocalPath + strFileFolder;
			int nFileSize = 0;

			JSONArray arr = new JSONArray();

			String strFileIds = "";
			String strFileNames = "";

			String strBackupFileName = strFilePathName;
			//代替此处的for循环
			Iterator<FileItem> iters = list.iterator();
			while(iters.hasNext())	//for (int i = 0; i < nCount; i++)
			{
				strFilePathName = strBackupFileName;
				
				FileItem uploadFile = (FileItem) iters.next();
				nFileSize = (int) uploadFile.getSize();
				strFilename = uploadFile.getName();
				
				strFilename =this.getRealFileName(strFilename);
				int nPos = 0;
				boolean bSaveFile = true;
				strFilePathName += strFilename;

				boolean bSaveOK = true;
				String strMessage = "";
				if (nPos > 0)
				{
					String strTempFileName = strFilePathName + StringHelper.format("_%1$s", nPos);
					
					File file = new File(strTempFileName); 
					uploadFile.write(file);
					
					bSaveOK = MergeFile(strFilePathName, strTempFileName, nPos);
					if (!bSaveOK)
						strMessage = "合并文件发生错误";
				} else
				{
					File file = new File(strFilePathName); 
					uploadFile.write(file);
				}

				net.ibizsys.psrt.srv.common.entity.File file = null;

				if (bSaveFile && bSaveOK)
				{
					FileService fileService = (FileService) ServiceGlobal.getService(FileService.class, this.getSessionFactory());
					boolean bNormalSave = true;
					if (isSavePicAsPng())
					{
						try
						{
							String strTmpFilePathName = strFilePathName.toLowerCase();
							int nFilePos = strTmpFilePathName.lastIndexOf(".png");
							if (nFilePos == strTmpFilePathName.length() - 4)
							{
								bNormalSave = true;
							} else
							{
								// 执行另存在操作
								bNormalSave = false;

								strTmpFilePathName = strFilePathName;

								strTmpFilePathName += ".png";

								File f = new File(strFilePathName);
								f.canRead();
								BufferedImage src = ImageIO.read(f);
								Iterator<ImageWriter> iter = ImageIO.getImageWritersByFormatName("jpg");

								if (iter.hasNext())
								{
									ImageWriter writer = iter.next();

									ImageWriteParam param = writer.getDefaultWriteParam();
									param.setCompressionMode(ImageWriteParam.MODE_DEFAULT);
									FileImageOutputStream out = new FileImageOutputStream(new File(strTmpFilePathName));
									writer.setOutput(out);
									writer.write(null, new IIOImage(src, null, null), param);
									out.close();
									writer.dispose();
								}

								if (isSave4Direct())
								{
									savePng4Direct(src, strTmpFilePathName, "jpg");
								}

								File saveFile = new File(strTmpFilePathName);
								file = new net.ibizsys.psrt.srv.common.entity.File();
								file.setFileSize((int) saveFile.length());
								file.setFileName(strFilename + ".png");
								file.setLocalPath(strFileFolder + strFilename + ".png");
								file.setFolder(strExtFolder);
								file.setPicWidth(src.getWidth());
								file.setPicHeight(src.getHeight());
								file.setLocalPath2(strFileFolder + strFilename);
								file.setFileName2(strFilename);
							}
						} catch (IOException je)
						{
							ajaxActionResult.setRetCode(Errors.INVALIDDATA);
							ajaxActionResult.setErrorInfo( StringHelper.format("转换图片格式发生异常，%1$s", je.getMessage()));
							return ajaxActionResult;
						}
					}

					if (bNormalSave)
					{
						File f = new File(strFilePathName);
						f.canRead();
						BufferedImage src = ImageIO.read(f);

						File saveFile = new File(strFilePathName);
						file = new net.ibizsys.psrt.srv.common.entity.File();
						file.setFileSize((int) saveFile.length());
						file.setFileName(strFilename);
						file.setLocalPath(strFileFolder + strFilename);
						file.setFolder(strExtFolder);
						if (src != null)
						{
							file.setPicWidth(src.getWidth());
							file.setPicHeight(src.getHeight());
							file.setLocalPath2(strFilePathName);
						}

						if (isSave4Direct())
						{
							savePng4Direct(src, strFilePathName, "png");
						}
					}
					onBeforeSaveFile(file);
					fileService.create(file);
					onAfterSaveFile(file);
					strMessage = file.getFileId();
				}
				if (file != null)
				{
					if (!StringHelper.isNullOrEmpty(strFileIds))
						strFileIds += ",";
					strFileIds += file.getFileId();

					if (!StringHelper.isNullOrEmpty(strFileNames))
						strFileNames += ",";
					strFileNames += file.getFileName();

					JSONObject prop = new JSONObject();

					prop.put("id", file.getFileId());
					prop.put("name", file.getFileName());

					// 缩略图地址

					arr.put(prop);
				}
			}
			ajaxActionResult.setExtAttr("files", arr);
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		
		return ajaxActionResult;
		
	}
	
	/**
	 * 保存文件前调用
	 * @param file
	 * @return
	 */
	protected void onBeforeSaveFile(net.ibizsys.psrt.srv.common.entity.File file) throws Exception
	{

	}
	
	
	/**
	 * 保存文件后调用
	 * @param file
	 * @return
	 */
	protected void onAfterSaveFile(net.ibizsys.psrt.srv.common.entity.File file) throws Exception
	{

	}
	
	/**
	 * 合并文件
	 * 
	 * @param strDstFile
	 * @param strSrcFile
	 * @param nPos
	 * @return
	 */
	protected boolean MergeFile(String strDstFile, String strSrcFile, int nPos)
	{
		try
		{
			int length = 10240;
			FileInputStream in = new FileInputStream(strSrcFile);

			FileOutputStream out = new FileOutputStream(strDstFile, true);

			byte[] buffer = new byte[length];
			while (true)
			{
				int ins = in.read(buffer);
				if (ins == -1)
				{
					in.close();
					out.flush();
					out.close();
					break;

				} else
					out.write(buffer, 0, ins);
			}

			File file = new File(strSrcFile);
			file.delete();

			return true;
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
			return false;
		} catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 额外保存几个方向，右转90,180,270度
	 * 
	 * @param bi
	 * @param strFileName
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void savePng4Direct(BufferedImage bi, String strFileName, String strPicType)
	{
		try
		{
			if (bi == null)
				return;
			String strName = strFileName.substring(0, strFileName.indexOf("."));

			BufferedImage bi90 = rotateImg(bi, 90);
			BufferedImage bi180 = rotateImg(bi, 180);
			BufferedImage bi270 = rotateImg(bi, 270);

			if (StringHelper.compare(strPicType, "png", true) == 0)
			{
				ImageIO.write(bi90, "png", new File(strName + "_90.png"));
				ImageIO.write(bi180, "png", new File(strName + "_180.png"));
				ImageIO.write(bi270, "png", new File(strName + "_270.png"));
			} else
			{
				Iterator<ImageWriter> iter = ImageIO.getImageWritersByFormatName("jpg");
				if (iter.hasNext())
				{
					ImageWriter writer = iter.next();

					ImageWriteParam param = writer.getDefaultWriteParam();
					param.setCompressionMode(ImageWriteParam.MODE_DEFAULT);

					FileImageOutputStream out90 = new FileImageOutputStream(new File(strName + "_90.png"));
					writer.setOutput(out90);
					writer.write(null, new IIOImage(bi90, null, null), param);
					out90.close();

					FileImageOutputStream out180 = new FileImageOutputStream(new File(strName + "_180.png"));
					writer.setOutput(out180);
					writer.write(null, new IIOImage(bi180, null, null), param);
					out180.close();

					FileImageOutputStream out270 = new FileImageOutputStream(new File(strName + "_270.png"));
					writer.setOutput(out270);
					writer.write(null, new IIOImage(bi270, null, null), param);
					out270.close();

					writer.dispose();

					bi90 = null;
					bi180 = null;
					bi270 = null;
				}
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	/**
	 * 旋转图片
	 * 
	 * @param image
	 * @param degree
	 * @return
	 * @throws IOException
	 */
	public static BufferedImage rotateImg(BufferedImage image, int degree) throws IOException
	{

		int iw = image.getWidth();// 原始图象的宽度
		int ih = image.getHeight();// 原始图象的高度
		int w = 0;
		int h = 0;
		int x = 0;
		int y = 0;
		degree = degree % 360;
		if (degree < 0)
			degree = 360 + degree;// 将角度转换到0-360度之间
		double ang = Math.toRadians(degree);// 将角度转为弧度

		/**
		 * 确定旋转后的图象的高度和宽度
		 */

		if (degree == 180 || degree == 0 || degree == 360)
		{
			w = iw;
			h = ih;
		} else if (degree == 90 || degree == 270)
		{
			w = ih;
			h = iw;
		} else
		{
			int d = iw + ih;
			w = (int) (d * Math.abs(Math.cos(ang)));
			h = (int) (d * Math.abs(Math.sin(ang)));
		}

		x = (w / 2) - (iw / 2);// 确定原点坐标
		y = (h / 2) - (ih / 2);
		BufferedImage rotatedImage = new BufferedImage(w, h, image.getType());
		Graphics2D gs = (Graphics2D) rotatedImage.getGraphics();

		rotatedImage = gs.getDeviceConfiguration().createCompatibleImage(w, h);

		AffineTransform at = new AffineTransform();
		at.rotate(ang, w / 2, h / 2);// 旋转图象
		at.translate(x, y);
		AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BICUBIC);
		op.filter(image, rotatedImage);
		image = rotatedImage;

		return image;
	}
	
	/**
	 * 是否将图片另存为PNG
	 * 
	 * @return
	 */
	protected boolean isSavePicAsPng()
	{
		String strSaveAsPng = this.getWebContext().getParamValue("SAVEPICASPNG");
		if (StringHelper.compare(strSaveAsPng, "TRUE", true) == 0)
		{
			return true;
		} else
			return false;
	}
	
	/**
	 * 保存4个方向的图片
	 * 
	 * @return
	 */
	protected boolean isSave4Direct()
	{
		return true;
	}

	/**
	 * 获取实际的文件名称
	 * @param strFilename
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	protected String getRealFileName(String strFilename) throws UnsupportedEncodingException{
		strFilename = new String(strFilename.getBytes("UTF-8"),"UTF-8");
		strFilename = URLDecoder.decode(strFilename, "UTF-8");
		return strFilename;
	}
	
	/**
	 * 建立上传控件
	 * @return
	 * @throws ServletException
	 */
	protected ServletFileUpload createFileupload() throws ServletException{
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setHeaderEncoding("UTF-8");
		return sfu;
	}
}
