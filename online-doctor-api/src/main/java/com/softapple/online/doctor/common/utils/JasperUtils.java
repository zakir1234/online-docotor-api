package com.softapple.online.doctor.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class JasperUtils {

    @Autowired
    DataSource dataSource;

    public static final Logger logger = Logger.getLogger(JasperUtils.class);

    public boolean jasperPrintWithList(List<?> list, Map<String, Object> paramsMap, String jasperFilePath, String downLoadFileName) throws Exception {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(jasperFilePath);
        JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, paramsMap, new JRBeanCollectionDataSource(list));
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(downLoadFileName);
        HttpServletResponse httpServletResponse = ((ServletRequestAttributes) requestAttributes).getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + stringBuilder + ".pdf");
        try (ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
            System.out.println("All done the report is done");
            servletOutputStream.flush();
            return true;
        }
    }

    public boolean jasperPrintWithQuery(Map<String, Object> map, String jasperFilePath, String downLoadFileName) throws Exception {
        Connection con = dataSource.getConnection();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(jasperFilePath);
        JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, map, con);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(downLoadFileName);
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletResponse httpServletResponse = ((ServletRequestAttributes) requestAttributes).getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + stringBuilder + ".pdf");
        try (ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
            System.out.println("All done the report is done");
            servletOutputStream.flush();
            return true;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception ex) {               
                logger.debug("This is debug :" + ex);
                logger.error("This is error : " + ex);
                logger.fatal("This is fatal : " + ex);

            }
        }
    }
}
