package com.jspsmart.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Local compatibility implementation for the legacy JSP SmartUpload API.
 *
 * <p>The original component is not distributed with the recovered task7
 * runtime. This implementation keeps the API used by the application while
 * delegating multipart parsing to Commons FileUpload.</p>
 */
public class SmartUpload {
    private PageContext pageContext;
    private javax.servlet.http.HttpServletRequest request;
    private HttpServletResponse response;
    private Request smartRequest;
    private final Files files = new Files();
    private String contentDisposition;
    private boolean contentDispositionConfigured;

    public void initialize(PageContext pageContext) throws ServletException {
        if (pageContext == null) {
            throw new ServletException("PageContext is required");
        }
        this.pageContext = pageContext;
        this.request = (javax.servlet.http.HttpServletRequest) pageContext.getRequest();
        this.response = (HttpServletResponse) pageContext.getResponse();
        this.smartRequest = new Request(request);
    }

    public void upload() throws SmartUploadException, IOException {
        ensureInitialized();
        if (!ServletFileUpload.isMultipartContent(request)) {
            return;
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);
        String encoding = request.getCharacterEncoding();
        if (encoding != null) {
            upload.setHeaderEncoding(encoding);
        }

        try {
            List items = upload.parseRequest(request);
            for (Object value : items) {
                FileItem item = (FileItem) value;
                if (item.isFormField()) {
                    String fieldEncoding = encoding == null ? "UTF-8" : encoding;
                    smartRequest.setParameter(item.getFieldName(), item.getString(fieldEncoding));
                } else if (item.getName() != null && item.getName().length() > 0) {
                    files.add(new SmartFile(item));
                }
            }
        } catch (Exception ex) {
            throw new SmartUploadException("Unable to parse multipart request", ex);
        }
    }

    public Files getFiles() {
        return files;
    }

    public Request getRequest() {
        ensureInitializedUnchecked();
        return smartRequest;
    }

    public void setContentDisposition(String value) {
        contentDispositionConfigured = true;
        contentDisposition = value;
    }

    public void downloadFile(String path) throws SmartUploadException, IOException {
        downloadFile(path, null, null);
    }

    public void downloadFile(String path, String contentType, String fileName)
            throws SmartUploadException, IOException {
        ensureInitialized();
        File file = new File(path);
        if (!file.isFile()) {
            throw new SmartUploadException("Download file does not exist: " + path);
        }

        String actualName = fileName;
        if (actualName == null || actualName.length() == 0) {
            actualName = file.getName();
        }
        response.reset();
        response.setContentType(contentType == null || contentType.length() == 0
                ? "application/octet-stream" : contentType);
        if (!contentDispositionConfigured || contentDisposition != null) {
            String disposition = contentDisposition == null ? "attachment" : contentDisposition;
            response.setHeader("Content-Disposition",
                    disposition + "; filename=\"" + encodeFileName(actualName) + "\"");
        }
        if (file.length() <= Integer.MAX_VALUE) {
            response.setContentLength((int) file.length());
        } else {
            response.setHeader("Content-Length", String.valueOf(file.length()));
        }

        InputStream input = null;
        ServletOutputStream output = null;
        try {
            input = new FileInputStream(file);
            output = response.getOutputStream();
            byte[] buffer = new byte[8192];
            int count;
            while ((count = input.read(buffer)) != -1) {
                output.write(buffer, 0, count);
            }
            output.flush();
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    private void ensureInitialized() throws SmartUploadException {
        if (pageContext == null || request == null || response == null) {
            throw new SmartUploadException("SmartUpload has not been initialized");
        }
    }

    private void ensureInitializedUnchecked() {
        if (pageContext == null || request == null || response == null) {
            throw new IllegalStateException("SmartUpload has not been initialized");
        }
    }

    private static String encodeFileName(String value) {
        try {
            return new String(value.getBytes("UTF-8"), "ISO-8859-1");
        } catch (Exception ex) {
            try {
                return URLEncoder.encode(value, "UTF-8");
            } catch (Exception ignored) {
                return value;
            }
        }
    }
}
