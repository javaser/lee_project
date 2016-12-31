package lee.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * @author Lee
 * @since 2016/12/30
 */
// 使用注解 @MultipartConfig 将一个 Servlet 标识为支持文件上传
@MultipartConfig
@WebServlet(name = "uploadServlet", urlPatterns = "/uploadServlet")
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 上传文件在服务器的存储路径，要判断文件夹是否存在
        String savePath = req.getServletContext().getRealPath
                ("/WEB-INF/uploadFile");
        // 获取上传文件的集合
        Collection<Part> parts = req.getParts();
        // 单个文件
        if (parts.size() == 1) {
            Part part = req.getPart("file");
            String header = part.getHeader("content-disposition");
            String fileName = getFileName(header);
            part.write(savePath + File.separator + fileName);
        } else {
            // 一次上传多个文件
            for (Part part : parts) {
                //获取请求头，请求头的格式：form-data; name="file"; filename="snmp4j--api.zip"
                String header = part.getHeader("content-disposition");
                //获取文件名
                String fileName = getFileName(header);
                //把文件写到指定路径
                part.write(savePath + File.separator + fileName);
            }
        }
//        String encoding = resp.getCharacterEncoding();
//        System.out.println(encoding);
        PrintWriter out = resp.getWriter();
        out.println("上传成功");
        out.flush();
        out.close();
    }

    private String getFileName(String header) {
        /**
         * String[] tempArr1 = header.split(";");代码执行完之后，在不同的浏览器下，tempArr1数组里面的内容稍有区别
         * 火狐或者google浏览器下：tempArr1={form-data,name="file",filename="snmp4j--api.zip"}
         * IE浏览器下：tempArr1={form-data,name="file",filename="E:\snmp4j--api.zip"}
         */
        String[] tempArr1 = header.split(";");
        /**
         *火狐或者google浏览器下：tempArr2={filename,"snmp4j--api.zip"}
         *IE浏览器下：tempArr2={filename,"E:\snmp4j--api.zip"}
         */
        String[] tempArr2 = tempArr1[2].split("=");
        //获取文件名，兼容各种浏览器的写法
        String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
        return fileName;

    }
}
