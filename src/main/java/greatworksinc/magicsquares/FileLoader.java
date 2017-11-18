package greatworksinc.magicsquares;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileLoader {
  private static final Logger log = LoggerFactory.getLogger(FileLoader.class);
  private static final Splitter COMMA_SPLITTER = Splitter.on(',');

  public static List<String> fromCSVtoList(String resourceName) {
    URL url = Resources.getResource(resourceName);
    try {
      List<String> rowsList = Files.readAllLines(Paths.get(url.toURI()));
      int rowsNumber = rowsList.size();
      List<String> outputList = Lists.newArrayList();
      for (String row : rowsList) {
        List<String> rowObjects = COMMA_SPLITTER.splitToList(row);
        if (rowObjects.size() != rowsNumber) {
          throw new IllegalArgumentException("Specified resource does not contain a properly formatted input");
        }
        outputList.addAll(rowObjects);
      }
      return outputList;
    } catch (IOException e) {
      log.error("The file input or output may not have been working.", e);
    } catch (URISyntaxException e) {
      log.error("File name syntax may have been wrong.", e);
    }
    return ImmutableList.of();
  }
}
