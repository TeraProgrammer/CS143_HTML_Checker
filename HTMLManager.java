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
         Stack storage = new Stack<HTMLTag>();
         int sizeQueue = tags.size();
         
         for (int i = 0; i < sizeQueue; i++) {
            HTMLTag tag = tags.remove();
            if (tag.isOpening()) {
               storage.push(tag);
               tags.add(tag);
               tags.remove();
            } else if (tag.isClosing()) {
               if (storage.peek().equals(tag.getMatching())) {
                  storage.pop();
                  tags.add(tag);
                  tags.remove();
               } else {
                  tags.remove();
                  tags.add(tag.getMatching());
                  storage.pop();
               }
            } else if (tag.isSelfClosing()) {
               tags.add(tag);
               tags.remove();
               storage.pop();
            }
         }
     }
     
     public Queue<HTMLTag> getTags() {
         return tags;
     }
     
     public String toString() {
         StringBuilder stringTags = new StringBuilder();
         for (HTMLTag tag : tags) {
            stringTags.append(tag.toString().trim());
         }
         
         return stringTags.toString();
     }  
}
