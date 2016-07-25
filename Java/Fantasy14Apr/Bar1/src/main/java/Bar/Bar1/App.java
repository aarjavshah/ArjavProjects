package Bar.Bar1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, IOException, WriterException
    {
    	String text = "http://www.fcbarcelona.com"; // this is the text that we want to encode  
    	  
    	int width = 400;  
    	int height = 300; // change the height and width as per your requirement  
    	  
    	// (ImageIO.getWriterFormatNames() returns a list of supported formats)  
    	String imageFormat = "png"; // could be "gif", "tiff", "jpeg"   
    	  
    	BitMatrix bitMatrix = new QRCodeWriter().encode(text, BarcodeFormat.QR_CODE, width, height);  
    	MatrixToImageWriter.writeToStream(bitMatrix, imageFormat, new FileOutputStream(new File("D:\\A.png")));
    }
}
