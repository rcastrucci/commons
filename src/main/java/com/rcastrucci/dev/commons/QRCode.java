package com.rcastrucci.dev.commons;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Data
public class QRCode {

    @NotNull
    private String path;
    @NotNull
    private String filename;
    @NotNull
    private String target;
    private int width;
    private int height;
    private String charset;

    public QRCode(String path, String filename, String target) {
        this.path = path;
        this.filename = filename;
        this.target = target;
        this.width = 1200;
        this.height = 1200;
        this.charset = "UTF-8";
    }

    /**
     * Generates a save a QRCode image using the constructor properties
     * @throws WriterException exception thrown on trying to save the image on disk
     * @throws IOException exception thrown on interrupted I/O operations
     */
    public void generateQRCode() throws WriterException, IOException {
        //MultiFormatWriter is a factory class that finds the appropriate Writer subclass for the BarcodeFormat requested and encodes the barcode with the supplied contents.
        BitMatrix matrix = new MultiFormatWriter().encode(new String(target.getBytes(charset), charset), BarcodeFormat.QR_CODE, width, height);
        // If folder doesn't exist it creates if it has no permission to create then will return false
        if (FileUtils.checkCreateFolder(path)) {
            MatrixToImageWriter.writeToPath(matrix, "png", new File(path+"/"+filename).toPath());
        }
    }

    public String readQRCode() throws IOException, NotFoundException {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(path)))));
        Result result = new MultiFormatReader().decode(binaryBitmap);
        return result.getText();
    }
}
