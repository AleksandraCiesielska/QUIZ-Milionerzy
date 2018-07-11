package pl.akademiakodu;

//klasa ktora jest odpowiedpzialna za przechowywanie konkretnego pytania
//pytanie ma tylko opcję tak albbo nie

public class Question {
//treść pytania
    private String content;
//czy jest poprawne
    private boolean isCorrect;
//konstruktor 2 parametrów

    public Question(String content, boolean isCorrect) {
        this.content = content;
        this.isCorrect = isCorrect;
    }
//getter dla booleana
    public String getContent() {
        return content;
    }
//setter zmienia treśćź pytania
    public void setContent(String content) {
        this.content = content;
    }
//getter dla booleana
    public boolean isCorrect() {
        return isCorrect;
    }
//setter dla booleana
    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
//podpowiedż dla kompilatora bo nadpisujemy z obiektu
    @Override
    public String toString() {
        return "Question{" +
                "content='" + content + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }

}






