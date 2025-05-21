import java.util.*;

public class HTMLManager {
     private Queue<HTMLTag> tags;
     
     public HTMLManager(Queue<HTMLTag> html) {
         try {
            tags = new LinkedList();
            for (HTMLTag tag : html) {
               tags.add(tag);
            }
         } catch (IllegalArgumentException e) {
            System.out.println("Queue contains illegal arguments.");
         }
     }
     
     public void fixHTML() {
         Stack storage = new Stack<HTMLTag>;
         
         for (HTMLTag tag : tags) {
            if (tag.isOpening()) {
               storage.add(tag);
               tag.add(tag);
               tags.remove();
            } else if (tag.isClosing()) {
               
            }
         }
     }
     
     public Queue<HTMLTag> getTags() {
         return tags;
     }
     
     public String toString() {
         return "";
     }  
}
