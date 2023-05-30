public class Extractor {

    /**
     * This method loops through the HTML structure contained in the received param doc and returns the deepest level text.
     * If the HTML structure is malformed, returns a malformed HTML message.
     * @param doc string that contains the HTML content loaded from a given URL.
     * @return the string that contains:
     * 1. The deepest text within the HTML structure; OR
     * 2. The message "malformed HTML" when doc has syntax errors
     */
    public String findDeepest(String doc){
        Validator validator = new Validator();

        String result = null;
        String[] docLines = doc.split(System.lineSeparator());
        int accLevel = 0;
        int lastLevel = -1;
        int opened = 0;
        int closed = 0;
        boolean mismatch = false;
        
        for (int i = 0; i < doc.lines().count(); i++) {
            if(!docLines[i].isBlank()){
                if(docLines[i].contains("<") && docLines[i].contains(">") && !docLines[i].contains("</")){
                    accLevel++;
                    opened++;
                } else if((!docLines[i].contains("</")) && lastLevel < accLevel) {
                    result = docLines[i].trim();
                    lastLevel = accLevel;
                } else if(docLines[i].contains("</")) {
                    accLevel--;
                    closed++;
                }  
            }   
        }

        mismatch = validator.isValid(doc);

        if(opened != closed || opened == 0 || mismatch)
            return "malformed HTML";

        return result;
    }
}