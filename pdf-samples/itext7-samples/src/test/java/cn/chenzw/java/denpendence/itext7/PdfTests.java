package cn.chenzw.java.dependence.itext7;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

@RunWith(JUnit4.class)
public class PdfTests {

    @Test
    public void testBasic() throws IOException {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter("result.pdf");

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Initialize document
        Document document = new Document(pdf);

        PdfFont f2 = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H", true);
        PdfFont f3 = PdfFontFactory.createFont("C:/Windows/Fonts/simhei.ttf", PdfEncodings.IDENTITY_H, true);
        //Add paragraph to the document
        document.add(new Paragraph("hellos你好").setFont(f2));
        document.add(new Paragraph("hellos你好").setFont(f3));

        //Close document
        document.close();
    }

}
