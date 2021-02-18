package clases;

import clases.Conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JOptionPane;

public class Imprimir {

    //UTILIZANDO ITEXTPDF
    public void ImprimirReporteDeInscripcion(int ID_update) {
        int creditos_total = 0;
        String cedula = "", especialidad = "", expediente = "", apellidos = "", nombres = "";
        String[] asignaturas1 = {}, asignaturas2 = {};
        Document documento = new Document(PageSize.LETTER);
        
        //Fecha:
        Calendar calendar = Calendar.getInstance();
        String dia = Integer.toString(calendar.get(Calendar.DATE));
        String mes = Integer.toString(calendar.get(Calendar.MONTH) + 1); //Se debe sumar 1 debido a que el sistema detecta enero como el mes 0 y diciembre como el mes 11
        String year = Integer.toString(calendar.get(Calendar.YEAR));

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select nombres, apellidos, cedula, expediente, especialidad, email, materias_inscritas, estatus, registrado_por from alumnos where id = " + ID_update);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                cedula = rs.getString("cedula");
                especialidad = rs.getString("especialidad");
                expediente = rs.getString("expediente");
                apellidos = rs.getString("apellidos");
                nombres = rs.getString("nombres");
                asignaturas1 = rs.getString("materias_inscritas").split("-");
            }
            cn.close();

            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte de Inscripcion de " + nombres.trim() + " " + expediente.trim() + ".pdf"));

            Image header = Image.getInstance("src/images/Banner_UNEXPO.png");
            header.scaleToFit(540, 600);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLDITALIC, BaseColor.BLACK));
            parrafo.add("REPORTE DE INSCRIPCIÓN");
            parrafo.add("\n\n");
            
            Paragraph parrafo_fecha = new Paragraph();
            parrafo_fecha.setAlignment(Paragraph.ALIGN_RIGHT);
            parrafo_fecha.setFont(FontFactory.getFont("Tahoma", 12, Font.NORMAL, BaseColor.BLACK));
            parrafo_fecha.add("Fecha: " + dia + "/" + mes + "/" + year);
            parrafo_fecha.add("\n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);
            documento.add(parrafo_fecha);

            PdfPTable tablaAlumno = new PdfPTable(3);

            Phrase num_expediente = new Phrase("NÚMERO DE EXPEDIENTE");
            num_expediente.getFont().setStyle(Font.BOLD);
            PdfPCell cell_num_expediente = new PdfPCell(num_expediente);
            cell_num_expediente.setBackgroundColor(new BaseColor(229, 231, 233));
            cell_num_expediente.setHorizontalAlignment(Phrase.ALIGN_CENTER);
            tablaAlumno.addCell(cell_num_expediente);
            
            Phrase num_cedula = new Phrase("CÉDULA DE IDENTIDAD");
            num_cedula.getFont().setStyle(Font.BOLD);
            PdfPCell cell_num_cedula = new PdfPCell(num_cedula);
            cell_num_cedula.setBackgroundColor(new BaseColor(229, 231, 233));
            cell_num_cedula.setHorizontalAlignment(Phrase.ALIGN_CENTER);
            tablaAlumno.addCell(cell_num_cedula);
            
            Phrase periodo_academico = new Phrase("PERÍODO ACADÉMICO");
            periodo_academico.getFont().setStyle(Font.BOLD);
            PdfPCell cell_periodo_academico = new PdfPCell(periodo_academico);
            cell_periodo_academico.setBackgroundColor(new BaseColor(229, 231,233));
            cell_periodo_academico.setHorizontalAlignment(Phrase.ALIGN_CENTER);
            tablaAlumno.addCell(cell_periodo_academico);

            
            Phrase num_expediente2 = new Phrase(expediente);
            PdfPCell cell_num_expediente2 = new PdfPCell(num_expediente2);
            cell_num_expediente2.setHorizontalAlignment(Phrase.ALIGN_CENTER);
            tablaAlumno.addCell(cell_num_expediente2);
            
            Phrase num_cedula2 = new Phrase(cedula.toUpperCase());
            PdfPCell cell_num_cedula2 = new PdfPCell(num_cedula2);
            cell_num_cedula2.setHorizontalAlignment(Phrase.ALIGN_CENTER);
            tablaAlumno.addCell(cell_num_cedula2);
            
            Phrase periodo_academico2 = new Phrase("2021-1");
            PdfPCell cell_periodo_academico2 = new PdfPCell(periodo_academico2);
            cell_periodo_academico2.setHorizontalAlignment(Phrase.ALIGN_CENTER);
            tablaAlumno.addCell(cell_periodo_academico2);

            tablaAlumno.setWidthPercentage(100);

            documento.add(tablaAlumno);

            PdfPTable tablaAlumno2 = new PdfPTable(3);
            
            Phrase apellidos_Phrase = new Phrase("APELLIDOS");
            apellidos_Phrase.getFont().setStyle(Font.BOLD);
            PdfPCell cell_apellidos_Phrase = new PdfPCell(apellidos_Phrase);
            cell_apellidos_Phrase.setBackgroundColor(new BaseColor(229, 231, 233));
            cell_apellidos_Phrase.setHorizontalAlignment(Phrase.ALIGN_CENTER);
            tablaAlumno2.addCell(cell_apellidos_Phrase);
            
            Phrase nombres_Phrase = new Phrase("NOMBRES");
            nombres_Phrase.getFont().setStyle(Font.BOLD);
            PdfPCell cell_nombres_Phrase = new PdfPCell(nombres_Phrase);
            cell_nombres_Phrase.setBackgroundColor(new BaseColor(229, 231, 233));
            cell_nombres_Phrase.setHorizontalAlignment(Phrase.ALIGN_CENTER);
            tablaAlumno2.addCell(cell_nombres_Phrase);
            
            Phrase especialidad_Phrase = new Phrase("ESPECIALIDAD");
            especialidad_Phrase.getFont().setStyle(Font.BOLD);
            PdfPCell cell_especialidad_Phrase = new PdfPCell(especialidad_Phrase);
            cell_especialidad_Phrase.setBackgroundColor(new BaseColor(229, 231, 233));
            cell_especialidad_Phrase.setHorizontalAlignment(Phrase.ALIGN_CENTER);
            tablaAlumno2.addCell(cell_especialidad_Phrase);
            
            Phrase apellidos_Phrase2 = new Phrase(apellidos.toUpperCase());
            PdfPCell cell_apellidos_Phrase2 = new PdfPCell(apellidos_Phrase2);
            cell_apellidos_Phrase2.setHorizontalAlignment(Phrase.ALIGN_CENTER);
            tablaAlumno2.addCell(cell_apellidos_Phrase2);
            
            Phrase nombres_Phrase2 = new Phrase(nombres.toUpperCase());
            PdfPCell cell_nombres_Phrase2 = new PdfPCell(nombres_Phrase2);
            cell_nombres_Phrase2.setHorizontalAlignment(Phrase.ALIGN_CENTER);
            tablaAlumno2.addCell(cell_nombres_Phrase2);
            
            Phrase especialidad_Phrase2 = new Phrase("INGENIERÍA "+ especialidad.toUpperCase());
            PdfPCell cell_especialidad_Phrase2 = new PdfPCell(especialidad_Phrase2);
            cell_especialidad_Phrase2.setHorizontalAlignment(Phrase.ALIGN_CENTER);
            tablaAlumno2.addCell(cell_especialidad_Phrase2);

            tablaAlumno2.setWidthPercentage(100);

            documento.add(tablaAlumno2);

            documento.add(new Paragraph("\n"));

            PdfPTable tablaAsignatura = new PdfPTable(4);
            Phrase codigo = new Phrase("CÓDIGO");
            codigo.getFont().setStyle(Font.BOLD);
            codigo.getFont().setSize(12);
            PdfPCell cell_codigo = new PdfPCell(codigo);
            cell_codigo.setBackgroundColor(new BaseColor(229, 231, 233));
            cell_codigo.setHorizontalAlignment(Phrase.ALIGN_CENTER);
            tablaAsignatura.addCell(cell_codigo);

            Phrase asignatura = new Phrase("ASIGNATURA");
            asignatura.getFont().setStyle(Font.BOLD);
            PdfPCell cell_asignatura = new PdfPCell(asignatura);
            cell_asignatura.setBackgroundColor(new BaseColor(229, 231, 233));
            cell_asignatura.setHorizontalAlignment(Phrase.ALIGN_CENTER);
            tablaAsignatura.addCell(cell_asignatura);

            Phrase creditos = new Phrase("CRÉDITOS");
            creditos.getFont().setStyle(Font.BOLD);
            PdfPCell cell_creditos = new PdfPCell(creditos);
            cell_creditos.setBackgroundColor(new BaseColor(229, 231, 233));
            cell_creditos.setHorizontalAlignment(Phrase.ALIGN_CENTER);
            tablaAsignatura.addCell(cell_creditos);

            Phrase seccion = new Phrase("SECCIÓN");
            seccion.getFont().setStyle(Font.BOLD);
            PdfPCell cell_seccion = new PdfPCell(seccion);
            cell_seccion.setBackgroundColor(new BaseColor(229, 231, 233));
            cell_seccion.setHorizontalAlignment(Phrase.ALIGN_CENTER);
            tablaAsignatura.addCell(cell_seccion);

            tablaAsignatura.setWidthPercentage(100);

            tablaAsignatura.setWidths(new float[]{4F, 20F, 4F, 4F});

            for (int i = 0; i < asignaturas1.length; i++) {
                asignaturas2 = asignaturas1[i].split(",");
                try {

                    Connection cn2 = Conexion.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement(
                            "SELECT unidades_credito FROM materias WHERE codigo = '" + asignaturas2[0] + "'");
                    ResultSet rs2 = pst2.executeQuery();

                    if (rs2.next()) {
                        PdfPCell cell_codigo2 = new PdfPCell(new Phrase(asignaturas2[0]));
                        cell_codigo2.setHorizontalAlignment(Phrase.ALIGN_LEFT);
                        tablaAsignatura.addCell(cell_codigo2);

                        PdfPCell cell_asignatura2 = new PdfPCell(new Phrase(asignaturas2[1]));
                        cell_asignatura2.setHorizontalAlignment(Phrase.ALIGN_LEFT);
                        tablaAsignatura.addCell(cell_asignatura2);

                        PdfPCell cell_creditos2 = new PdfPCell(new Phrase(rs2.getString("unidades_credito")));
                        cell_creditos2.setHorizontalAlignment(Phrase.ALIGN_CENTER);
                        tablaAsignatura.addCell(cell_creditos2);

                        PdfPCell cell_seccion2 = new PdfPCell(new Phrase(asignaturas2[2]));
                        cell_seccion2.setHorizontalAlignment(Phrase.ALIGN_CENTER);
                        tablaAsignatura.addCell(cell_seccion2);

                        creditos_total += Integer.parseInt(rs2.getString("unidades_credito"));
                    }
                } catch (SQLException e) {
                    System.err.println("Ha ocurrido un error al obtener las unidades de crédito " + e);
                }
            }
            documento.add(tablaAsignatura);

            Paragraph parrafo2 = new Paragraph();
            parrafo2.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.BLACK));
            parrafo2.add("                                                                             "
                    + "CRÉDITOS INSCRITOS     :        " + String.valueOf(creditos_total));
            

            documento.add(parrafo2);
            
            Paragraph parrafo3 = new Paragraph();
            parrafo3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
            parrafo3.setFont(FontFactory.getFont("Tahoma", 10, Font.BOLDITALIC, BaseColor.BLACK));
            parrafo3.add("\n\n");
            parrafo3.add("NOTA  :        ESTA CONSTANCIA NO GARANTIZA SU INSCRIPCIÓN DEFINITIVA YA QUE EL DEPARTAMENTO DE                   "
                    + "ADMISIÓN Y CONTROL DE ESTUDIOS DEBE VERIFICAR SI TODOS LOS REQUISITOS HAN SIDO                                  "
                    + "CUMPLIDOS");
            
            documento.add(parrafo3);
                    
            documento.close();

            JOptionPane.showMessageDialog(null, "REPORTE DE INSCRIPCIÓN creado exitosamente. Por favor, revise su escritorio");
        } catch (DocumentException | IOException | SQLException e) {
            System.err.println("Error en PDF o ruta de imagen " + e);
            JOptionPane.showMessageDialog(null, "Error al crear el PDF");
        }
    }

    //UTILIZANDO HTML2PDF para tener estilo con HTML
}
