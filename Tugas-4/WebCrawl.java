package tcp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Trivial client for the date server.
 */

public class WebCrawler 
{

    /**
     * Runs the client as an application.  First it displays a dialog
     * box asking for the IP address or hostname of a host running
     * the date server, then connects to it and displays the date that
     * it serves.
     */
	
    private static void print(String msg, Object... args) 
    {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) 
    {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }

	
    public static void main(String[] args) throws IOException 
    {
        /* Menggambil file HTML dari url */
            Document doc = Jsoup.connect("http://www.itb.ac.id/").timeout(30000).get();
        
        /* Mengambil semua url yang ada pada tag <a href = >*/
            Elements links = doc.select("a[href]");
        
        /* Proses menyimpan file html dari url di atas */
            File file = new File("D:/Documents/hasilambil.html");
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
        	writer.write(doc.body().toString());
            writer.flush();
            writer.close();
        
        /* Proses iterasi untuk menampilan semua url yang ada pada variable "links" */
            print("\nLinks: (%d)", links.size());
            for (Element link : links) 
            {
                print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
            }


        /* Melakukan semua yang diatas namun untuk semua url yang ada di variable "links" */
            for (Element link : links) 
            {
                doc = Jsoup.connect(link.attr("abs:href")).timeout(30000).userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21").ignoreHttpErrors(true).followRedirects(true).ignoreContentType(true).get();
                file = new File("D:/Kuliah/STI/Semester 5/pemrograman integratif/Server Java/Data Client/" + trim(link.text(), 35) + ".html");
                writer = new FileWriter(file);
            	writer.write(doc.body().toString());
                writer.flush();
                writer.close();
            }
        
        System.exit(0);
    }
}
