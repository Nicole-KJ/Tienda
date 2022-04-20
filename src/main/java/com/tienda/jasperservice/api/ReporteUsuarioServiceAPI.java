package com.tienda.jasperservice.api;

import com.tienda.jaspermodel.ReporteUsuarioDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;

public interface ReporteUsuarioServiceAPI {
    ReporteUsuarioDTO obtenerReporteUsuario(Map<String, Object> params) throws JRException, IOException, SQLException;
}
