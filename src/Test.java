
//このimport パソコン内にある
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;

public class Test{
    public static void main(String[] args) throws IOException {

    	/*
        Charset charset = StandardCharsets.UTF_8;//文字コード
        String moji = "abcあいう123";
		*/
    	//BufferedImage img = new BufferedImage(240, 240, BufferedImage.TYPE_3BYTE_BGR);

    	//使用する画像のpath
        String path = "C:\\Users\\ctc2019\\Documents\\pleiades-2020-03-java-win-64bit-jre_20200322\\pleiades\\workspace\\Picture_test\\src\\Arduino1.png";

        //保存する画像のpath
        String outpath = "C:\\Users\\ctc2019\\Documents\\pleiades-2020-03-java-win-64bit-jre_20200322\\pleiades\\workspace\\Picture_test\\src\\output.png";

        //ClassLoader classLoader = getClass().getClassLoader();

        //File型の変数に格納する(画像の参照を可能にする)
        File inputFile = new File(path);

        //画像ファイルをbase64 String配列に変換
        byte[]fileContent = FileUtils.readFileToByteArray(inputFile);
        String encodedString = Base64.getEncoder().encodeToString(fileContent);


        System.out.println(encodedString);

        //Create output file
        /*
        File outputFile = new File(inputFile
                .getParentFile()
                .getAbsolutePath() + File.pathSeparator + outpath);
		*/

        File outputFile = new File(outpath);

        //Base64 String配列を画像ファイルに変換
        byte[]decodedBytes = Base64.getDecoder().decode(encodedString);
        FileUtils.writeByteArrayToFile(outputFile, decodedBytes);
        //System.out.println(outputFile);

        //ImageIO.write(img, "png", outputFile);
        //　エンコード
        /*
        byte[]a = Base64.getEncoder()
            .encode(moji.getBytes(charset));
        String en1 = new String(a, charset);
        System.out.println("en1= " + en1);
		*/
        // en1= YWJj44GC44GE44GGMTIz

        //　デコード
        /*
        byte[]b = Base64.getDecoder().decode(a);
        String de1 = new String(b,charset);
        System.out.println("de1= " + de1);
		*/
        // de1= abcあいう123
    }
}