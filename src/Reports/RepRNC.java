/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import DTO.GeralRep;
import DTO.Rnc;
import DTO.RncAnalitico;
import DTO.RncSintetico;
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
public class RepRNC {
    
    private final String caminho = "c:\\Users\\Juliano\\OneDrive\\IFC\\TCC TADS\\AtuaNC2\\src\\Reports\\";

    
    // PARA RELATÓRIO DE UMA RNC (analítico)
    public void imprimir(ArrayList<RncAnalitico> rnc) throws Exception{
        JasperReport report = JasperCompileManager.compileReport(caminho + "rRNC_ver1.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(rnc));
        JasperViewer jrviewer = new JasperViewer(print, false);    
        jrviewer.setVisible(true);   
        jrviewer.toFront();          
        // para gerar o PDF no disco
        // JasperExportManager.exportReportToPdfFile(print, "c:\\Users\\Juliano\\OneDrive\\IFC\\TCC TADS\\Relatorio_de_Usuarios.pdf");		     
	}

    // PARA IMPRIMIR UMA LISTA DE RNC COM OS PRINCIPAIS DADOS (lista sintética)
    
    public void imprimir2(ArrayList<RncSintetico> rnc) throws Exception{
    
        JasperReport report = JasperCompileManager.compileReport(caminho + "rRNC_ver2.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(rnc));
        JasperViewer jrviewer = new JasperViewer(print, false);    
        jrviewer.setVisible(true);   
        jrviewer.toFront();          
        // para gerar o PDF no disco
        // JasperExportManager.exportReportToPdfFile(print, "c:\\Users\\Juliano\\OneDrive\\IFC\\TCC TADS\\Relatorio_de_Usuarios.pdf");		     
	
	}
    
    // PARA RELATÓRIO DE GERAL DE RNC (lista rnc x setores)
    
    public void imprimir3(ArrayList<GeralRep> rnc) throws Exception{
        JasperReport report = JasperCompileManager.compileReport(caminho + "rRNC_geral2.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(rnc));
        JasperViewer jrviewer = new JasperViewer(print, false);    
        jrviewer.setVisible(true);   
        jrviewer.toFront();          
        // para gerar o PDF no disco
        // JasperExportManager.exportReportToPdfFile(print, "c:\\Users\\Juliano\\OneDrive\\IFC\\TCC TADS\\Relatorio_de_Usuarios.pdf");		     
	}
    
}
