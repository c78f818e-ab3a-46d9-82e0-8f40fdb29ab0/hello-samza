package samza.marmot;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * Author: Eric Han
 * Date:   15/5/10
 */
public class TestHDFS {
    private static Logger log = Logger.getLogger(TestHDFS.class);
    public static void main(String[] args) {
        try {
            Configuration conf = new Configuration();
            FileSystem fs = FileSystem.get(new URI("hdfs://yarn1.alibaba.net:8020/"), conf);
            Path file = new Path("/user/lu.hl/README.md");
            FSDataInputStream getIt = fs.open(file);
            BufferedReader d = new BufferedReader(new InputStreamReader(getIt));
            String s;
            while ((s = d.readLine()) != null) {
                log.info(s);
            }
            d.close();
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
