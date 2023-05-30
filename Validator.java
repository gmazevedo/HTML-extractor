import java.util.Stack;

public class Validator {

    /** 
     * This method loops through the HTML structure contained in the received param doc and check if the structure is malformed.
     * @param doc string that contains the HTML content loaded from a given URL.
     * @return boolean False if the HTML content is not malformed, boolean True if the HTML content is malformed.
     */
    public boolean isValid(String doc) {
        String[] docLines = doc.split(System.lineSeparator());;
        String topItem = null;
        Stack<String> stack = new Stack<>(); 

        for (int i = 0; i < doc.lines().count(); i++) {

            String[] line = docLines[i].split("\\s") ;
            for(String word : line) {
                if(word.contains("<")&&!word.contains("</")){
                    stack.push(word);
                }
                if(word.startsWith("</")&& !stack.empty()) {
                    topItem = stack.peek().replaceAll("[^a-zA-Z ]", "");
                    if(topItem.equals(word.replaceAll("[^a-zA-Z ]", ""))){
                        stack.pop();
                    }
                }
            }
        }

        if(stack.empty()){
            return false;
        } else {
            return true;
        }
    }  
}
