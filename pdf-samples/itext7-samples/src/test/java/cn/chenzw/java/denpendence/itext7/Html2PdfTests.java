package cn.chenzw.java.denpendence.itext7;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.extgstate.PdfExtGState;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.font.FontProvider;
import com.itextpdf.layout.font.FontSet;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.*;


@RunWith(JUnit4.class)
public class Html2PdfTests {

    @Test
    public void testSimpleHtml2Pdf() throws IOException {
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\"/>\n" +
                "    <title>标题</title>\n" +
                "</head>\n" +
                "<style>\n" +
                "    *{\n" +
                "        font-family: KaiTi_GB2312;\n" +
                "    }\n" +
                "</style>\n" +
                "<body>\n" +
                "    这是带有中文的html格式内容hello world! <font color=\"red\">XMLWorkerHelper</font> [这是带有中文的html格式内容]\n" +
                "</body>\n" +
                "</html>";

        HtmlConverter.convertToPdf(html, new FileOutputStream("result.pdf"), new ConverterProperties());
    }

    @Test
    public void testHtml2Pdf() throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("html/index.html");

        ConverterProperties converterProperties = new ConverterProperties();
        FontProvider fontProvider = new FontProvider();
        PdfFont sysFont = PdfFontFactory.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
        fontProvider.addFont(sysFont.getFontProgram(), "UniGB-UCS2-H");
        converterProperties.setFontProvider(fontProvider);

        HtmlConverter.convertToPdf(is, new FileOutputStream("result.pdf"), converterProperties);
    }

    @Test
    public void testHtml2PdfWithWaterMask() throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("html/index.html");

        ConverterProperties converterProperties = new ConverterProperties();
        FontProvider fontProvider = new FontProvider();
        PdfFont sysFont = PdfFontFactory.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
        fontProvider.addFont(sysFont.getFontProgram(), "UniGB-UCS2-H");
        converterProperties.setFontProvider(fontProvider);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HtmlConverter.convertToPdf(is, new PdfWriter(baos), converterProperties);

        // 添加水印
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(new ByteArrayInputStream(baos.toByteArray())), new PdfWriter("result_water_mask.pdf"));
        pdfDoc.addEventHandler(PdfDocumentEvent.END_PAGE, new IEventHandler() {

            @Override
            public void handleEvent(Event event) {
                PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
                PdfDocument pdfDoc = docEvent.getDocument();
                PdfPage page = docEvent.getPage();
                PdfFont font = null;
                try {
                    //  font = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD); // 要显示中文水印的话，需要设置中文字体，这里可以动态判断
                    font = PdfFontFactory.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                PdfCanvas canvas = new PdfCanvas(page);
                PdfExtGState gs1 = new PdfExtGState();
                gs1.setFillOpacity(0.5f); // 水印透明度
                canvas.setExtGState(gs1);

                new Canvas(canvas, page.getPageSize())
                        .setFontColor(ColorConstants.LIGHT_GRAY) //字体颜色
                        .setFontSize(60) //字体大小
                        .setFont(font)
                        .showTextAligned(
                                new Paragraph("测试测试2"), 100, 100,
                                pdfDoc.getPageNumber(page), TextAlignment.CENTER, VerticalAlignment.MIDDLE, 45);

                PdfCanvas canvas2 = new PdfCanvas(page);
                PdfExtGState gs2 = new PdfExtGState();
                gs2.setFillOpacity(0.3f); // 水印透明度
                canvas2.setExtGState(gs2);
                new Canvas(canvas2, page.getPageSize())
                        .setFontColor(ColorConstants.LIGHT_GRAY) //字体颜色
                        .setFontSize(80) //字体大小
                        .setFont(font)
                        .showTextAligned(
                                new Paragraph("xxxxxx"), 200, 200,
                                pdfDoc.getPageNumber(page), TextAlignment.CENTER, VerticalAlignment.MIDDLE, 45);
            }
        });
        pdfDoc.close();
    }


}
