package com.tienda.jaspercommons;

import com.tienda.jasperenums.TipoReporteEnum;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class JasperReportManager {
    private static final String REPORT_FOLDER = "reports";
    private static final String JASPER = ".jasper";
    
    public ByteArrayOutputStream export(String filename, String tipoReporte, Map<String, Object> params, Connection con) throws JRException, IOException{
    
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ClassPathResource resource = new ClassPathResource(REPORT_FOLDER + File.separator + filename + JASPER);
        
        InputStream inputStream = resource.getInputStream();
        JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, params, con);
        
        if(tipoReporte.equalsIgnoreCase(TipoReporteEnum.EXCEL.toString())){
            //si el reporte se envia como excel nentonces:
            JRXlsExporter exporter = new JRXlsExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(stream));
            SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
            configuration.setDetectCellType(true);
            configuration.setCollapseRowSpan(true);
            exporter.setConfiguration(configuration);
            exporter.exportReport();
            
        }else{
            //si el reporte se envia como pdf nentonces:
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
        }
        
        return stream;
    }
}
