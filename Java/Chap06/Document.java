package Chap06;

class Document {
    static int count = 0;
    String name;

    Document() {
        this("Unnamed"+ ++count);
    }

    Document(String name) {
        this.name = name;
        System.out.println("Document " + this.name + " is created.");
    }
}

class DocumentTest {
    public static void main(String[] args) {
        Document d1 = new Document();
        Document d2 = new Document("Java.txt");
        Document d3 = new Document();
        Document d4 = new Document();
    }
}