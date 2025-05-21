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
               storage.push(tag);
               tags.add(tag);
               tags.remove();
            } else if (tag.isClosing()) {
               if (storage.peek().equals(tag.getMatching())) {
                  queue.push(storage.pop());
               } else {
                  tags.remove();
                  tags.add(tag.getMatching());
                  storage.pop();
               }
            } else if (tag.isSelfOpening()) {
               
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
