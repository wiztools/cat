package org.wiztools.cat;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author subwiz
 */
public class CatMain {
    
    private static void cat(InputStream is) throws IOException {
        byte[] buf = new byte[1024*4];
        int read = -1;
        while((read = is.read(buf)) != -1) {
            if(read > 0) {
                System.out.write(buf, 0, read);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        if(args.length > 0) {
            for(String file: args) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    cat(fis);
                }
            }
        }
        else {
            cat(System.in);
        }
    }
}
