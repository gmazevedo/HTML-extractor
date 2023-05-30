public class HtmlAnalyzer {
    /**
     * This method receives a URL link by args and analyzed the HTML structure loaded from it, printing:
     * 1. The string that is the deepest level text found in the HTML structure; OR
     * 2. The "URL connection error" message, if occurred an error while trying to connect to the URL; OR
     * 3. The "malformed HTML" message, if the HTML structure loaded is malformed.
     * @param args String that contains a URL for html code to be analyzed 
     */
    public static void main(String[] args){
        Loader loader = new Loader();
        Extractor extractor = new Extractor();

        String deepestPart = null;
        String content;
        String urlInput = args[0];

        try {
            content = loader.getContent(urlInput);
            deepestPart = extractor.findDeepest(content);
            System.out.println(deepestPart); 
        } catch (Exception ex) {
            System.out.println("URL connection error");
        }
    }
}



