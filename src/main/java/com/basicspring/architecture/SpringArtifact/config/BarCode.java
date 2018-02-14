package com.basicspring.architecture.SpringArtifact.config;

import java.io.File;
import java.io.FileOutputStream;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.client.j2se.MatrixToImageWriter;

/**
 * 
 * @author Saurav
 *
 */

public class BarCode {
	
	public static void generateBarCode(){
		BitMatrix bitMatrix;
        
        try{
        	 bitMatrix = new Code128Writer().encode("123456789", BarcodeFormat.CODE_128, 150, 80, null);
             MatrixToImageWriter.writeToStream(bitMatrix, "png", new FileOutputStream(new File("C://Users//Dell//Desktop//css//code128_123456789.jpg")));
             System.out.println("Code128 Barcode Generated.");
        }catch(Exception e){
        	e.printStackTrace();
        }
	}
}
