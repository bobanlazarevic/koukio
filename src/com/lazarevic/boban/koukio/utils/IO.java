package com.lazarevic.boban.koukio.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IO {

  public static List<String> readFile(String fileName) {

    File f = new File(fileName);

    List<String> result = null;
    try {
      try(BufferedReader br = new BufferedReader(new FileReader(f))) {
        String line = br.readLine();

        result = new ArrayList<>(Integer.valueOf(line));
        while( null != (line = br.readLine())) {
          result.add(line);
        }
      }
    } catch(IOException e) {
      // e.printStackTrace();
    }

    return null != result ? result : new ArrayList<>();
  }

}
