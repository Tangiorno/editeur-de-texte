package fr.iut.editeur.document;

public class Document {

    private String contentDocument;

    public Document() {
        this.contentDocument = "";
    }

    public String getTexte() {
        return contentDocument;
    }

    public void setTexte(String contentDocument) {
        this.contentDocument = contentDocument;
    }

    public void ajouter(String contentDocument) {
        this.contentDocument += contentDocument;
    }

    /**
     *
     * @param start indice à partir duquel on commence à remplacer le texte
     * @param end indice jusqu'où on remplace le texte
     * @param remplacement texte qui va remplacer l'ancien texte situé entre les deux indices
     */
    public void remplacer(int start, int end, String remplacement) {
        String leftPart = contentDocument.substring(0, start);
        String rightPart = contentDocument.substring(end);
        contentDocument = leftPart + remplacement + rightPart;
    }

    /**
     *
     * @param start indice à partir duquel le texte sera en majuscules
     * @param end indice jusqu'où le texte sera en majuscules
     */
    public void majuscules(int start, int end) {
        String contentDocument2 = this.contentDocument.substring(start, end).toUpperCase();
        remplacer(start, end, contentDocument2);
    }

    public void effacer(int start, int end) {
        String contentDocument2 = "";
        remplacer(start, end, contentDocument2);
    }

    /**
     * supprime tout le texte
     */
    public void clear() {
        remplacer(0, contentDocument.length(), "");
    }

    public void inserer(int index, String contentDocument){
        remplacer(index + 1, index + 1, contentDocument);
    }
    public void minuscules(int start, int end){
        String contentDocument2 = this.contentDocument.substring(start,end).toLowerCase();
        remplacer(start,end,contentDocument2);
    }

    @Override
    public String toString() {
        return this.contentDocument;
    }

    public void undo() {
    }
}
