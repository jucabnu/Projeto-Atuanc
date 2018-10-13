/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import DTO.Usuario;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Juliano
 */
public class RepUsuarios {
    
    private final String caminho = "c:\\Users\\Juliano\\OneDrive\\IFC\\TCC TADS\\AtuaNC2\\src\\Reports\\";

    public void imprimir(ArrayList<Usuario> usuarios) throws Exception{
    
        JasperReport report = JasperCompileManager.compileReport(caminho+ "rUsuarios.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(usuarios));
        JasperViewer jrviewer = new JasperViewer(print, false);    
        jrviewer.setVisible(true);   
        jrviewer.toFront();  
        
        // para gerar o PDF no disco
        // JasperExportManager.exportReportToPdfFile(print, "c:\\Users\\Juliano\\OneDrive\\IFC\\TCC TADS\\Relatorio_de_Usuarios.pdf");		
     
	}

}
