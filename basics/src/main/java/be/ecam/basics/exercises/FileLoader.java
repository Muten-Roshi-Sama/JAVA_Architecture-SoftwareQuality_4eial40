// FileLoader.java
package be.ecam.basics.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

// Initial Problem (Pitfall: Pitfall: checked exceptions enforcement and Exception handling):
    //           -> catch block just returns null(Swallowing IOException)
    //           --> test expects missing files to propagate an IOException, not return null
    //           ---> 
    // Solution :
    //      Use try-with-resources and let IOException propagate.



public class FileLoader {

    public static String firstLine(Path path) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
            return br.readLine();
        }
    }
}

