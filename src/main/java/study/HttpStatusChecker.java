package study;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

public class HttpStatusChecker {

    public static String getStatusImage(int code) throws Exception {
        String url = "https://http.cat";
        ArrayList<String> linkHref = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();
        boolean checker = false;

        List<Element> elementList = doc.body().getElementsByAttributeValueContaining("class", "text-[2rem] tracking-[2px] font-semibold uppercase");
        for (Element e : elementList) {
            if (Integer.parseInt(e.text()) == code) {
                linkHref.add(e.parent().parent().getElementsByTag("img").attr("src"));
                checker = true;
            }
        }
        if (checker) {
            return url + linkHref.get(0);
        } else throw new Exception("Nothing to return");
    }

}
