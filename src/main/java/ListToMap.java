import java.util.*;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ListToMap {
    public static class Item {
        private int id;
        private String url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWebsites() {
            return websites;
        }

        public void setWebsites(int websites) {
            this.websites = websites;
        }

        private int websites;
        public Item(int id, String url, int websites) {
            this.id = id;
            this.url = url;
            this.websites = websites;
        }

    }
    public static void main(String[] args) {
        List<Item> list = new ArrayList<>();
        list.add(new Item(1, "liquidweb.com", 80000));
        list.add(new Item(2, "linode.com", 90000));
        list.add(new Item(3, "digitalocean.com", 120000));
        list.add(new Item(4, "aws.amazon.com", 200000));
        list.add(new Item(5, "mkyong.com", 1));
        list.add(new Item(5, "mkyong.com", 5));

//        Map<String, Integer> res = list.stream().collect(
//                Collectors.toMap(Item::getUrl, Item::getWebsites)
//        );
//
//        System.out.println(res);

        System.out.println("to avoid duplicates keys");

        Map<String, Integer> nonDups = list.stream().collect(
                Collectors.toMap(Item::getUrl, Item::getWebsites,
                        (oldValue, newValue) -> newValue)
        );
        System.out.println(nonDups);

        System.out.println();
        System.out.println("Sort and Collect");
        Map resu = list.stream()
                .sorted(Comparator.comparingLong(Item::getWebsites).reversed())
                .collect(Collectors.toMap(
                        Item::getId, Item::getWebsites,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
        System.out.println(resu);
    }
}
