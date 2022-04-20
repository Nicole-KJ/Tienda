package com.tienda.jasperservice.impl;

import com.tienda.jaspercommons.JasperReportManager;
import com.tienda.jasperenums.TipoReporteEnum;
import com.tienda.jaspermodel.ReporteUsuarioDTO;
import com.tienda.jasperservice.api.ReporteUsuarioServiceAPI;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReporteUsuarioServiceImpl implements ReporteUsuarioServiceAPI{
    @Autowired
	private JasperReportManager reportManager;

    @Autowired
    private DataSource dataSource;
    
    @Override
    public ReporteUsuarioDTO obtenerReporteUsuario(Map<String, Object> params)
            throws JRException, IOException, SQLException {
        String fileName = "reporte_usuarios";
        ReporteUsuarioDTO dto = new ReporteUsuarioDTO();
        String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx"
                : ".pdf";
        dto.setFileName(fileName + extension);
        
        ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());

		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);

		return dto;
    }
    
}
