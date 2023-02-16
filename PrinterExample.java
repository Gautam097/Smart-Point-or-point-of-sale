//package printerexample;

import escpos.EscPos;
import escpos.EscPos.CharacterCodeTable;
import escpos.EscPosConst;
import escpos.Style;
import escpos.barcode.BarCode;
import escpos.barcode.BarCodeWrapperInterface;
import escpos.barcode.QRCode;
import escpos.image.BitImageWrapper;
import escpos.image.BitonalOrderedDither;
import escpos.image.BitonalThreshold;
import escpos.image.EscPosImage;
import escpos.image.GraphicsImageWrapper;
import escpos.image.ImageWrapperInterface;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.print.PrintService;
import output.PrinterOutputStream;

public class PrinterExample {

    public static void main(String[] args) {

        try {

            PrintService printService = PrinterOutputStream.getPrintServiceByName("THERMAL Receipt Printer");
            PrinterOutputStream printerOutputStream = new PrinterOutputStream(printService);
            EscPos escpos = new EscPos(printerOutputStream);
            Style header = new Style()
                    .setFontSize(Style.FontSize._2, Style.FontSize._2)
                    .setJustification(EscPosConst.Justification.Center)
                    .setBold(true)
                    .setColorMode(Style.ColorMode.WhiteOnBlack);

            Style address = new Style()
                    .setFontName(Style.FontName.Font_A_Default)
                    .setFontSize(Style.FontSize._1, Style.FontSize._1)
                    .setJustification(EscPosConst.Justification.Center);
            escpos.writeLF(header, " BarXchange ");
            escpos.writeLF(address, "SCO-108, Ranjeet Avenue");
            escpos.writeLF(address, "+918725983606");
            escpos.writeLF(address, "GSTIN : 23AADGS334SDZDT");
            escpos.writeLF(address, "Vat No : 94832848349");
            escpos.writeLF(address, "29-06-2019");
            escpos.writeLF(address, "Table No. 120");
            escpos.writeLF(address, "    ");
            escpos.writeLF(address, "    ");

            QRCode qrCode = new QRCode()
                    .setSize(5)
                    .setModel(QRCode.QRModel._2)
                    .setJustification(EscPosConst.Justification.Center);

            escpos.write(qrCode, "QR Code");

            escpos.writeLF(address, "    ");

//            BarCode barcode = new BarCode();
//            barcode.setJustification(EscPosConst.Justification.Center);
//            barcode.setHRIPosition(BarCode.BarCodeHRIPosition.BelowBarCode);
//            escpos.write(barcode, "7239409840");
//            GraphicsImageWrapper imageWrapper = new GraphicsImageWrapper();
//            imageWrapper.setJustification(EscPosConst.Justification.Center);
//            
//            BitonalThreshold bod = new BitonalThreshold();
//            BufferedImage bimg = ImageIO.read(new File("src/images/goku.png"));
//            EscPosImage escPos = new EscPosImage(bimg, bod);
//            escpos.write(imageWrapper, escPos);
//
////            BitonalThreshold bt = new BitonalThreshold();
            Style lineStyle = new Style()
                    .setFontSize(Style.FontSize._1, Style.FontSize._1)
                    .setJustification(EscPosConst.Justification.Center);

            escpos.writeLF(lineStyle, "----------------------------------------");
            
            Style rightText = new Style()
                    .setFontSize(Style.FontSize._1, Style.FontSize._1)
                    .setJustification(EscPosConst.Justification.Right);

            Style leftText = new Style()
                    .setFontSize(Style.FontSize._1, Style.FontSize._1)
                    .setJustification(EscPosConst.Justification.Left_Default);

            
            escpos.writeLF(rightText, "Bill No : 1234");
            escpos.write(leftText, "Cashier: casher1");
            escpos.write(rightText, "TYPE : DINE IN");
            
            
            escpos.feed(5);
            escpos.cut(EscPos.CutMode.PART);
            escpos.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
